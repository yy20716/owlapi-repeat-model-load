package org.bbop.owlapitest;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.obolibrary.obo2owl.Obo2OWLConstants;
import org.semanticweb.elk.owlapi.ElkReasonerFactory;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import gnu.trove.set.hash.THashSet;

public class Main {
  
  private void testLoadModelAnnotation(ParserWrapper pwr, File legoFile) {
    OWLReasoner currentReasoner = null;
    OWLOntologyManager manager = pwr.getManager();
    OWLOntology model = null;

    try {
      model = pwr.parseOWL(IRI.create(legoFile));

      OWLReasonerFactory reasonerFactory = new ElkReasonerFactory();
      currentReasoner = reasonerFactory.createReasoner(model);
      boolean consistent = currentReasoner.isConsistent();
      if(consistent == false){
        return;
      }

      // The following block of codes are the logic of "getId" in ModelAnnotationSolrDocumentLoader.java
      // See also: https://github.com/owlcollab/owltools/blob/708ba8bf5f4e9ef47ef684c50e1ec8d5648be88e/OWLTools-Solr/src/main/java/owltools/solrj/ModelAnnotationSolrDocumentLoader.java#L501
      OWLClass c = model.getOWLOntologyManager().getOWLDataFactory().getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_0008150"));
      OWLAnnotationProperty shortIdProp = model.getOWLOntologyManager().getOWLDataFactory().getOWLAnnotationProperty(IRI.create(Obo2OWLConstants.OIOVOCAB_IRI_PREFIX+"id"));
      Set<OWLOntology> all = new HashSet<OWLOntology>();
      all.add(model);
      all.addAll(model.getImportsClosure());
      Set<OWLClass> owlClasses = new THashSet<OWLClass>();
      for (OWLOntology o : all)
        owlClasses.addAll(o.getClassesInSignature());
      Set<OWLAnnotation>anns = new HashSet<OWLAnnotation>();
      if (c instanceof OWLEntity) {
        for (OWLOntology ont : all)
          anns.addAll(getAnnotations((OWLEntity) c, shortIdProp, ont));
      }
      Set<String> litSet = new HashSet<>();
      for (OWLAnnotation a : anns) {
        if (a.getValue() instanceof OWLLiteral) {
          OWLLiteral val = (OWLLiteral) a.getValue();
          litSet.add(val.getLiteral());
        }
      }
      System.out.println(litSet);
      
      // The following block of codes are the part of the logic of "load()" in ModelAnnotationSolrDocumentLoader.java
      // https://github.com/owlcollab/owltools/blob/708ba8bf5f4e9ef47ef684c50e1ec8d5648be88e/OWLTools-Solr/src/main/java/owltools/solrj/ModelAnnotationSolrDocumentLoader.java#L245                   
      Set<OWLObjectPropertyAssertionAxiom> axioms = model.getAxioms(AxiomType.OBJECT_PROPERTY_ASSERTION);
      for (OWLObjectPropertyAssertionAxiom axiom : axioms) {
        OWLIndividual gp = axiom.getObject();
        if (gp.isNamed()) {
          final OWLNamedIndividual gpNamed = gp.asOWLNamedIndividual();
          final Set<OWLClass> results = new HashSet<OWLClass>();
          Set<OWLClass> inferredTypes = currentReasoner.getTypes(gpNamed, true).getFlattened();
          for (OWLClass cls : inferredTypes) {
            if (cls.isBuiltIn() == false) {
              results.add(cls);
            }
          }
          System.out.println(results);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (currentReasoner != null) {
        currentReasoner.dispose();
      }
      if (model != null) {
        manager.removeOntology(model);
      }
    }
  }

  public Set<OWLAnnotation> getAnnotations(OWLEntity e, OWLAnnotationProperty property, OWLOntology ont) {
    Set<OWLAnnotation> annotations;
    if (e != null && property != null && ont != null) {
      annotations = new HashSet<>();
      for (OWLAnnotationAssertionAxiom ax : ont.getAnnotationAssertionAxioms(e.getIRI())) {
        if (property.equals(ax.getProperty())) {
          annotations.add(ax.getAnnotation());
        }
      }
    }
    else {
      annotations = Collections.emptySet();
    }
    return annotations;
  }

  public static void showHeapStatus() {
    long heapSize = Runtime.getRuntime().totalMemory(); 
    long heapMaxSize = Runtime.getRuntime().maxMemory();
    long heapFreeSize = Runtime.getRuntime().freeMemory(); 

    System.out.println("heap size: " +  formatSize(heapSize));
    System.out.println("heap max size: "+ formatSize(heapMaxSize));
    System.out.println("heap free size: "+ formatSize(heapFreeSize)); 
  }

  private static String formatSize(long v) {
    if (v < 1024) return v + " B";
    int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
    return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
  }

  public static void main(String[] args) {
    ParserWrapper pwr = new ParserWrapper();
    Main main = new Main();

    // loading four models using the same ontology manager (which resides in pwr).
    main.testLoadModelAnnotation (pwr, new File("0000000300000001.ttl"));
    showHeapStatus();
    main.testLoadModelAnnotation (pwr, new File("568b0f9600000093.ttl"));
    showHeapStatus();
    main.testLoadModelAnnotation (pwr, new File("5745387b00000365.ttl"));
    showHeapStatus();
    main.testLoadModelAnnotation (pwr, new File("57f1b14b00000466.ttl"));
    showHeapStatus();  
  }
}
