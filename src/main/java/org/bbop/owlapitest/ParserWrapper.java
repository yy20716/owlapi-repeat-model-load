package org.bbop.owlapitest;

import org.obolibrary.oboformat.model.OBODoc;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyAlreadyExistsException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyDocumentAlreadyExistsException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyLoaderListener;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.google.common.base.Optional;

public class ParserWrapper {
  OWLOntologyManager manager;    
  OBODoc obodoc;
  boolean isCheckOboDoc = true;

  public ParserWrapper() {
    manager = OWLManager.createOWLOntologyManager();
    OWLOntologyLoaderListener listener = new OWLOntologyLoaderListener() {

      // generated
      private static final long serialVersionUID = 8475800207882525640L;

      public void startedLoadingOntology(LoadingStartedEvent event) {
        IRI id = event.getOntologyID().getOntologyIRI().orNull();
        IRI source = event.getDocumentIRI();
        System.out.println("Start loading ontology: "+id+" from: "+source);
      }

      public void finishedLoadingOntology(LoadingFinishedEvent event) {
        IRI id = event.getOntologyID().getOntologyIRI().orNull();
        IRI source = event.getDocumentIRI();
        System.out.println("Finished loading ontology: "+id+" from: "+source);
      }
    };
    manager.addOntologyLoaderListener(listener);
  }

  public OWLOntologyManager getManager() {
    return manager;
  }

  public OWLOntology parseOWL(IRI iri) throws OWLOntologyCreationException {
    OWLOntology ont;
    try {
      ont = manager.loadOntology(iri);
    } catch (OWLOntologyAlreadyExistsException e) {
      // Trying to recover from exception
      OWLOntologyID ontologyID = e.getOntologyID();
      ont = manager.getOntology(ontologyID);
      if (ont == null) {
        // throw original exception, if no ontology could be found
        // never return null ontology
        throw e;
      }
      System.out.println("Skip already loaded ontology: "+iri);
    } catch (OWLOntologyDocumentAlreadyExistsException e) {
      // Trying to recover from exception
      IRI duplicate = e.getOntologyDocumentIRI();
      ont = manager.getOntology(duplicate);
      if (ont == null) {
        for(OWLOntology managed : manager.getOntologies()) {
          Optional<IRI> managedIRI = managed.getOntologyID().getOntologyIRI();
          if(managedIRI.isPresent() && duplicate.equals(managedIRI.get())) {
            System.out.println("Skip already loaded ontology: "+iri);
            ont = managed;
            break;
          }
        }
      }
      if (ont == null) {
        // throw original exception, if no ontology could be found
        // never return null ontology
        throw e;
      }
    }
    return ont;
  }
}