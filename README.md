# owlapi-repeat-model-load

This repo contains testcodes that tests [the memory leak issue](https://github.com/owlcollab/owltools/issues/253#issuecomment-388415035). It consists of four [noctua-model](https://github.com/geneontology/noctua-models) files; the codes will load them using the same ontology manager in owlapi and prints out its memory usages.

## Installation and Usage
Run the following commands for building and running the executable jar file.  
~~~~
mvn clean package
java -jar target/owlapitest-0.0.1-SNAPSHOT-jar-with-dependencies.jar 2>&1 | tee output.txt
~~~~

## Output
In my observation, heap freesize is not monotonically decreasing, so it seems that gc is working properly. Here is the output from my environment.
~~~~
yy20716@yy20716-Dell-Precision-M3800:~/eclipse-workspace/owlapi-test$ java -jar target/owlapitest-0.0.1-SNAPSHOT-jar-with-dependencies.jar 2>&1 | tee output.txt
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/home/yy20716/eclipse-workspace/owlapitest/target/owlapitest-0.0.1-SNAPSHOT-jar-with-dependencies.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
Start loading ontology: file:/home/yy20716/eclipse-workspace/owlapitest/0000000300000001.ttl from: file:/home/yy20716/eclipse-workspace/owlapitest/0000000300000001.ttl
Start loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-lego.owl from: http://purl.obolibrary.org/obo/go/extensions/go-lego.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro.owl from: http://purl.obolibrary.org/obo/ro.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/annotations.owl from: http://purl.obolibrary.org/obo/ro/annotations.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/annotations.owl from: http://purl.obolibrary.org/obo/ro/annotations.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/pato_import.owl from: http://purl.obolibrary.org/obo/ro/pato_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/pato_import.owl from: http://purl.obolibrary.org/obo/ro/pato_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/temporal-intervals.owl from: http://purl.obolibrary.org/obo/ro/temporal-intervals.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/core.owl from: http://purl.obolibrary.org/obo/ro/core.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/bfo-axioms.owl from: http://purl.obolibrary.org/obo/ro/bfo-axioms.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/bfo-axioms.owl from: http://purl.obolibrary.org/obo/ro/bfo-axioms.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/bfo-classes-minimal.owl from: http://purl.obolibrary.org/obo/ro/bfo-classes-minimal.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/bfo-classes-minimal.owl from: http://purl.obolibrary.org/obo/ro/bfo-classes-minimal.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/core.owl from: http://purl.obolibrary.org/obo/ro/core.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/temporal-intervals.owl from: http://purl.obolibrary.org/obo/ro/temporal-intervals.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/go_cc_import.owl from: http://purl.obolibrary.org/obo/ro/go_cc_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/go_cc_import.owl from: http://purl.obolibrary.org/obo/ro/go_cc_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/go_mf_import.owl from: http://purl.obolibrary.org/obo/ro/go_mf_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/go_mf_import.owl from: http://purl.obolibrary.org/obo/ro/go_mf_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/rohom.owl from: http://purl.obolibrary.org/obo/ro/rohom.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/rohom.owl from: http://purl.obolibrary.org/obo/ro/rohom.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/go-biotic.owl from: http://purl.obolibrary.org/obo/ro/go-biotic.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/go-biotic.owl from: http://purl.obolibrary.org/obo/ro/go-biotic.owl
Start loading ontology: http://purl.obolibrary.org/obo/ro/el-constraints.owl from: http://purl.obolibrary.org/obo/ro/el-constraints.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro/el-constraints.owl from: http://purl.obolibrary.org/obo/ro/el-constraints.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ro.owl from: http://purl.obolibrary.org/obo/ro.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/extensions/legorel.owl from: http://purl.obolibrary.org/obo/go/extensions/legorel.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/extensions/legorel.owl from: http://purl.obolibrary.org/obo/go/extensions/legorel.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-plus.owl from: http://purl.obolibrary.org/obo/go/extensions/go-plus.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/uberon_import.owl from: http://purl.obolibrary.org/obo/go/imports/uberon_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/uberon_import.owl from: http://purl.obolibrary.org/obo/go/imports/uberon_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-gci.owl from: http://purl.obolibrary.org/obo/go/extensions/go-gci.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-gci.owl from: http://purl.obolibrary.org/obo/go/extensions/go-gci.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/pr_import.owl from: http://purl.obolibrary.org/obo/go/imports/pr_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/pr_import.owl from: http://purl.obolibrary.org/obo/go/imports/pr_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-bridge.owl from: http://purl.obolibrary.org/obo/go/extensions/go-bridge.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-bridge.owl from: http://purl.obolibrary.org/obo/go/extensions/go-bridge.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/cl_import.owl from: http://purl.obolibrary.org/obo/go/imports/cl_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/cl_import.owl from: http://purl.obolibrary.org/obo/go/imports/cl_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/oba_import.owl from: http://purl.obolibrary.org/obo/go/imports/oba_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/oba_import.owl from: http://purl.obolibrary.org/obo/go/imports/oba_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/po_import.owl from: http://purl.obolibrary.org/obo/go/imports/po_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/po_import.owl from: http://purl.obolibrary.org/obo/go/imports/po_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/fao_import.owl from: http://purl.obolibrary.org/obo/go/imports/fao_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/fao_import.owl from: http://purl.obolibrary.org/obo/go/imports/fao_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/x-disjoint.owl from: http://purl.obolibrary.org/obo/go/imports/x-disjoint.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/x-disjoint.owl from: http://purl.obolibrary.org/obo/go/imports/x-disjoint.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/chebi_import.owl from: http://purl.obolibrary.org/obo/go/imports/chebi_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/chebi_import.owl from: http://purl.obolibrary.org/obo/go/imports/chebi_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/ro_import.owl from: http://purl.obolibrary.org/obo/go/imports/ro_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/ro_import.owl from: http://purl.obolibrary.org/obo/go/imports/ro_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/ncbitaxon_import.owl from: http://purl.obolibrary.org/obo/go/imports/ncbitaxon_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/ncbitaxon_import.owl from: http://purl.obolibrary.org/obo/go/imports/ncbitaxon_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/pato_import.owl from: http://purl.obolibrary.org/obo/go/imports/pato_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/pato_import.owl from: http://purl.obolibrary.org/obo/go/imports/pato_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/ro_pending.owl from: http://purl.obolibrary.org/obo/go/imports/ro_pending.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/extensions/ro_pending.owl from: http://purl.obolibrary.org/obo/go/imports/ro_pending.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/caro_import.owl from: http://purl.obolibrary.org/obo/go/imports/caro_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/caro_import.owl from: http://purl.obolibrary.org/obo/go/imports/caro_import.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/imports/so_import.owl from: http://purl.obolibrary.org/obo/go/imports/so_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/imports/so_import.owl from: http://purl.obolibrary.org/obo/go/imports/so_import.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-plus.owl from: http://purl.obolibrary.org/obo/go/extensions/go-plus.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-bfo-bridge.owl from: http://purl.obolibrary.org/obo/go/extensions/go-bfo-bridge.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-bfo-bridge.owl from: http://purl.obolibrary.org/obo/go/extensions/go-bfo-bridge.owl
Start loading ontology: http://purl.obolibrary.org/obo/wbphenotype.owl from: http://purl.obolibrary.org/obo/wbphenotype.owl
Finished loading ontology: http://purl.obolibrary.org/obo/wbphenotype.owl from: http://purl.obolibrary.org/obo/wbphenotype.owl
Start loading ontology: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim.owl from: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim.owl from: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim.owl
Start loading ontology: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim-disjoint-over-in-taxon.owl from: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim-disjoint-over-in-taxon.owl
Finished loading ontology: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim-disjoint-over-in-taxon.owl from: http://purl.obolibrary.org/obo/ncbitaxon/subsets/taxslim-disjoint-over-in-taxon.owl
Start loading ontology: http://purl.obolibrary.org/obo/eco.owl from: http://purl.obolibrary.org/obo/eco.owl
Finished loading ontology: http://purl.obolibrary.org/obo/eco.owl from: http://purl.obolibrary.org/obo/eco.owl
Start loading ontology: http://purl.obolibrary.org/obo/wbbt.owl from: http://purl.obolibrary.org/obo/wbbt.owl
Finished loading ontology: http://purl.obolibrary.org/obo/wbbt.owl from: http://purl.obolibrary.org/obo/wbbt.owl
Start loading ontology: http://purl.obolibrary.org/obo/emapa.owl from: http://purl.obolibrary.org/obo/emapa.owl
Finished loading ontology: http://purl.obolibrary.org/obo/emapa.owl from: http://purl.obolibrary.org/obo/emapa.owl
Start loading ontology: http://purl.obolibrary.org/obo/uberon/bridge/uberon-bridge-to-emapa.owl from: http://purl.obolibrary.org/obo/uberon/bridge/uberon-bridge-to-emapa.owl
Finished loading ontology: http://purl.obolibrary.org/obo/uberon/bridge/uberon-bridge-to-emapa.owl from: http://purl.obolibrary.org/obo/uberon/bridge/uberon-bridge-to-emapa.owl
Start loading ontology: http://purl.obolibrary.org/obo/go/noctua/neo.owl from: http://purl.obolibrary.org/obo/go/noctua/neo.owl
Finished loading ontology: http://purl.obolibrary.org/obo/go/noctua/neo.owl from: http://purl.obolibrary.org/obo/go/noctua/neo.owl
Start loading ontology: http://snapshot.geneontology.org/metadata/users.ttl from: http://snapshot.geneontology.org/metadata/users.ttl
Finished loading ontology: null from: http://snapshot.geneontology.org/metadata/users.ttl
Start loading ontology: http://snapshot.geneontology.org/metadata/groups.ttl from: http://snapshot.geneontology.org/metadata/groups.ttl
Finished loading ontology: null from: http://snapshot.geneontology.org/metadata/groups.ttl
Finished loading ontology: http://purl.obolibrary.org/obo/go/extensions/go-lego.owl from: http://purl.obolibrary.org/obo/go/extensions/go-lego.owl
Finished loading ontology: http://model.geneontology.org/0000000300000001 from: file:/home/yy20716/eclipse-workspace/owlapitest/0000000300000001.ttl
log4j:WARN No appenders could be found for logger (org.semanticweb.elk.config.ConfigurationFactory).
log4j:WARN Please initialize the log4j system properly.
[GO:0008150]
[<http://purl.obolibrary.org/obo/GO_0031146>]
[<http://purl.obolibrary.org/obo/GO_0003674>]
[<http://purl.obolibrary.org/obo/CHEBI_36080>, <http://purl.obolibrary.org/obo/PR_000000001>]
[<http://purl.obolibrary.org/obo/GO_0005886>]
[<http://identifiers.org/uniprot/O88572>]
[<http://purl.obolibrary.org/obo/GO_0003674>]
[<http://identifiers.org/uniprot/O88572>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0005515>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0005515>]
[<http://purl.obolibrary.org/obo/GO_0098772>]
[<http://purl.obolibrary.org/obo/GO_0030674>, <http://purl.obolibrary.org/obo/GO_0030295>]
[<http://identifiers.org/uniprot/Q61086>]
[<http://identifiers.org/uniprot/Q6PJ87>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0043565>, <http://purl.obolibrary.org/obo/GO_0098772>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://identifiers.org/uniprot/Q02248>]
[<http://identifiers.org/uniprot/Q3ULA2>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://identifiers.org/uniprot/P27782>]
[<http://identifiers.org/uniprot/Q02248>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://identifiers.org/uniprot/Q02248>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0003700>]
[<http://identifiers.org/uniprot/P51141>]
[<http://identifiers.org/uniprot/P27782>]
[<http://purl.obolibrary.org/obo/GO_0003674>]
[<http://purl.obolibrary.org/obo/GO_0030674>, <http://purl.obolibrary.org/obo/GO_0030295>]
[<http://identifiers.org/uniprot/Q9WV60>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0005515>]
[<http://identifiers.org/uniprot/P17553>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0005515>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0005515>]
[<http://identifiers.org/uniprot/P51141>]
[<http://identifiers.org/uniprot/Q02248>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0042813>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://identifiers.org/uniprot/Q02248>]
[<http://purl.obolibrary.org/obo/GO_0004842>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0042813>]
[<http://purl.obolibrary.org/obo/GO_0042813>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://identifiers.org/uniprot/O35625>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://purl.obolibrary.org/obo/GO_0003700>]
[<http://identifiers.org/uniprot/Q61086>]
[<http://identifiers.org/uniprot/Q02248>]
[<http://identifiers.org/uniprot/Q9WV60>]
[<http://purl.obolibrary.org/obo/GO_0030877>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0004672>, <http://purl.obolibrary.org/obo/GO_0098772>]
[<http://purl.obolibrary.org/obo/GO_0019005>]
[<http://purl.obolibrary.org/obo/GO_0004672>, <http://purl.obolibrary.org/obo/GO_0098772>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://purl.obolibrary.org/obo/GO_0005615>]
[<http://identifiers.org/uniprot/P27782>]
[<http://identifiers.org/uniprot/Q5SQA3>]
[<http://identifiers.org/uniprot/Q02248>]
[<http://purl.obolibrary.org/obo/GO_0005575>]
[<http://purl.obolibrary.org/obo/GO_0003674>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/GO_0005829>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://identifiers.org/uniprot/Q6PJ87>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0005515>]
heap size: 3.9 GB
heap max size: 3.9 GB
heap free size: 835.1 MB
Start loading ontology: file:/home/yy20716/eclipse-workspace/owlapitest/568b0f9600000093.ttl from: file:/home/yy20716/eclipse-workspace/owlapitest/568b0f9600000093.ttl
Finished loading ontology: http://model.geneontology.org/568b0f9600000093 from: file:/home/yy20716/eclipse-workspace/owlapitest/568b0f9600000093.ttl
[GO:0008150]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/GO_0005886>]
[<http://www.informatics.jax.org/accession/MGI:MGI:1202709>]
[<http://purl.obolibrary.org/obo/GO_0005515>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://www.informatics.jax.org/accession/MGI:MGI:2446244>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://purl.obolibrary.org/obo/GO_0000785>]
[<http://purl.obolibrary.org/obo/GO_1903757>, <http://purl.obolibrary.org/obo/GO_0032212>, <http://purl.obolibrary.org/obo/GO_0051568>, <http://purl.obolibrary.org/obo/GO_0051973>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://www.informatics.jax.org/accession/MGI:MGI:1202709>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://www.informatics.jax.org/accession/MGI:MGI:88276>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://purl.obolibrary.org/obo/GO_0003720>]
[<http://purl.obolibrary.org/obo/GO_0060070>]
[<http://www.informatics.jax.org/accession/MGI:MGI:1202709>]
[<http://www.informatics.jax.org/accession/MGI:MGI:97250>]
[<http://purl.obolibrary.org/obo/GO_0032212>, <http://purl.obolibrary.org/obo/GO_0006366>, <http://purl.obolibrary.org/obo/GO_0051973>]
[<http://www.informatics.jax.org/accession/MGI:MGI:1202709>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/GO_0032212>, <http://purl.obolibrary.org/obo/GO_0006366>, <http://purl.obolibrary.org/obo/GO_0051973>]
[<http://purl.obolibrary.org/obo/GO_0007004>]
[<http://www.informatics.jax.org/accession/MGI:MGI:1202709>]
[<http://www.informatics.jax.org/accession/MGI:MGI:88276>]
[<http://purl.obolibrary.org/obo/CL_0000352>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/GO_1990841>, <http://purl.obolibrary.org/obo/GO_0008047>]
[<http://www.informatics.jax.org/accession/MGI:MGI:1342287>]
[<http://www.informatics.jax.org/accession/MGI:MGI:98956>]
[<http://purl.obolibrary.org/obo/GO_0018024>]
[<http://purl.obolibrary.org/obo/GO_0000785>]
heap size: 3.9 GB
heap max size: 3.9 GB
heap free size: 875.3 MB
Start loading ontology: file:/home/yy20716/eclipse-workspace/owlapitest/5745387b00000365.ttl from: file:/home/yy20716/eclipse-workspace/owlapitest/5745387b00000365.ttl
Finished loading ontology: http://model.geneontology.org/5745387b00000365 from: file:/home/yy20716/eclipse-workspace/owlapitest/5745387b00000365.ttl
[GO:0008150]
[<http://purl.obolibrary.org/obo/GO_0008104>]
[<http://purl.obolibrary.org/obo/GO_0019538>, <http://purl.obolibrary.org/obo/GO_0010467>]
[<http://purl.obolibrary.org/obo/GO_0005634>]
[<http://purl.obolibrary.org/obo/UBERON_0000955>]
[<http://purl.obolibrary.org/obo/UBERON_0000955>]
[<http://identifiers.org/uniprot/Q15465>]
[<http://identifiers.org/uniprot/P32243>]
[<http://identifiers.org/uniprot/P32243>]
[<http://purl.obolibrary.org/obo/UBERON_0000955>]
[<http://identifiers.org/uniprot/P32243>]
heap size: 3.9 GB
heap max size: 3.9 GB
heap free size: 765.2 MB
Start loading ontology: file:/home/yy20716/eclipse-workspace/owlapitest/57f1b14b00000466.ttl from: file:/home/yy20716/eclipse-workspace/owlapitest/57f1b14b00000466.ttl
Finished loading ontology: http://model.geneontology.org/57f1b14b00000466 from: file:/home/yy20716/eclipse-workspace/owlapitest/57f1b14b00000466.ttl
[GO:0008150]
[<http://purl.obolibrary.org/obo/GO_0043624>]
[<http://purl.obolibrary.org/obo/GO_0019003>]
[<http://purl.obolibrary.org/obo/GO_0004930>]
[<http://purl.obolibrary.org/obo/GO_0031684>]
[<http://purl.obolibrary.org/obo/GO_0005834>]
[<http://purl.obolibrary.org/obo/GO_0031684>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0005525>]
[<http://purl.obolibrary.org/obo/GO_0031684>]
[<http://purl.obolibrary.org/obo/GO_0005834>]
[<http://purl.obolibrary.org/obo/GO_0031684>]
[<http://purl.obolibrary.org/obo/GO_0031684>]
[<http://purl.obolibrary.org/obo/GO_0001664>]
[<http://purl.obolibrary.org/obo/GO_1902605>]
[<http://purl.obolibrary.org/obo/GO_0005834>]
[<http://purl.obolibrary.org/obo/GO_0098772>, <http://purl.obolibrary.org/obo/GO_0003924>]
[<http://purl.obolibrary.org/obo/GO_0031684>]
[<http://purl.obolibrary.org/obo/GO_0005525>]
[<http://purl.obolibrary.org/obo/GO_0004930>]
[<http://purl.obolibrary.org/obo/GO_0019003>]
heap size: 3.9 GB
heap max size: 3.9 GB
heap free size: 874.6 MB
~~~~

