package com.asjad.tech.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class AssociationModel {
    public final String data_version;
    public final Data data[];
    public final long size;

    @JsonCreator
    public AssociationModel(@JsonProperty("data_version") String data_version, @JsonProperty("data") Data[] data, @JsonProperty("size") long size){
        this.data_version = data_version;
        this.data = data;
        this.size = size;
    }

    public static final class Data {
        public final Target target;
        public final Association_score association_score;
        public final Disease disease;
        public final boolean is_direct;
        public final Evidence_count evidence_count;
        public final String id;

        @JsonCreator
        public Data(@JsonProperty("target") Target target, @JsonProperty("association_score") Association_score association_score, @JsonProperty("disease") Disease disease, @JsonProperty("is_direct") boolean is_direct, @JsonProperty("evidence_count") Evidence_count evidence_count, @JsonProperty("id") String id){
            this.target = target;
            this.association_score = association_score;
            this.disease = disease;
            this.is_direct = is_direct;
            this.evidence_count = evidence_count;
            this.id = id;
        }

        public static final class Target {
            public final Tractability tractability;
            public final Gene_info gene_info;
            public final String id;

            @JsonCreator
            public Target(@JsonProperty("tractability") Tractability tractability, @JsonProperty("gene_info") Gene_info gene_info, @JsonProperty("id") String id){
                this.tractability = tractability;
                this.gene_info = gene_info;
                this.id = id;
            }

            public static final class Tractability {
                public final Smallmolecule smallmolecule;
                public final Antibody antibody;

                @JsonCreator
                public Tractability(@JsonProperty("smallmolecule") Smallmolecule smallmolecule, @JsonProperty("antibody") Antibody antibody){
                    this.smallmolecule = smallmolecule;
                    this.antibody = antibody;
                }

                public static final class Smallmolecule {
                    public final String top_category;
                    public final boolean small_molecule_genome_member;
                    public final int[] buckets;
                    public final long high_quality_compounds;
                    public final long ensemble;
                    public final Categories categories;

                    @JsonCreator
                    public Smallmolecule(@JsonProperty("top_category") String top_category, @JsonProperty("small_molecule_genome_member") boolean small_molecule_genome_member, @JsonProperty("buckets") int[] buckets, @JsonProperty("high_quality_compounds") long high_quality_compounds, @JsonProperty("ensemble") long ensemble, @JsonProperty("categories") Categories categories){
                        this.top_category = top_category;
                        this.small_molecule_genome_member = small_molecule_genome_member;
                        this.buckets = buckets;
                        this.high_quality_compounds = high_quality_compounds;
                        this.ensemble = ensemble;
                        this.categories = categories;
                    }

                    public static final class Categories {
                        public final long clinical_precedence;
                        public final double predicted_tractable;
                        public final long discovery_precedence;

                        @JsonCreator
                        public Categories(@JsonProperty("clinical_precedence") long clinical_precedence, @JsonProperty("predicted_tractable") double predicted_tractable, @JsonProperty("discovery_precedence") long discovery_precedence){
                            this.clinical_precedence = clinical_precedence;
                            this.predicted_tractable = predicted_tractable;
                            this.discovery_precedence = discovery_precedence;
                        }
                    }
                }

                public static final class Antibody {
                    public final String top_category;
                    public final int[] buckets;
                    public final Categories categories;

                    @JsonCreator
                    public Antibody(@JsonProperty("top_category") String top_category, @JsonProperty("buckets") int[] buckets, @JsonProperty("categories") Categories categories){
                        this.top_category = top_category;
                        this.buckets = buckets;
                        this.categories = categories;
                    }

                    public static final class Categories {
                        public final double predicted_tractable_med_low_confidence;
                        public final long clinical_precedence;
                        public final long predicted_tractable_high_confidence;

                        @JsonCreator
                        public Categories(@JsonProperty("predicted_tractable_med_low_confidence") double predicted_tractable_med_low_confidence, @JsonProperty("clinical_precedence") long clinical_precedence, @JsonProperty("predicted_tractable_high_confidence") long predicted_tractable_high_confidence){
                            this.predicted_tractable_med_low_confidence = predicted_tractable_med_low_confidence;
                            this.clinical_precedence = clinical_precedence;
                            this.predicted_tractable_high_confidence = predicted_tractable_high_confidence;
                        }
                    }
                }
            }

            public static final class Gene_info {
                public final String symbol;
                public final String name;

                @JsonCreator
                public Gene_info(@JsonProperty("symbol") String symbol, @JsonProperty("name") String name){
                    this.symbol = symbol;
                    this.name = name;
                }
            }
        }

        public static final class Association_score {
            public final Datatypes datatypes;
            public final double overall;
            public final Datasources datasources;

            @JsonCreator
            public Association_score(@JsonProperty("datatypes") Datatypes datatypes, @JsonProperty("overall") double overall, @JsonProperty("datasources") Datasources datasources){
                this.datatypes = datatypes;
                this.overall = overall;
                this.datasources = datasources;
            }

            public static final class Datatypes {
                public final double literature;
                public final long rna_expression;
                public final long genetic_association;
                public final long somatic_mutation;
                public final long known_drug;
                public final long animal_model;
                public final double affected_pathway;

                @JsonCreator
                public Datatypes(@JsonProperty("literature") double literature, @JsonProperty("rna_expression") long rna_expression, @JsonProperty("genetic_association") long genetic_association, @JsonProperty("somatic_mutation") long somatic_mutation, @JsonProperty("known_drug") long known_drug, @JsonProperty("animal_model") long animal_model, @JsonProperty("affected_pathway") double affected_pathway){
                    this.literature = literature;
                    this.rna_expression = rna_expression;
                    this.genetic_association = genetic_association;
                    this.somatic_mutation = somatic_mutation;
                    this.known_drug = known_drug;
                    this.animal_model = animal_model;
                    this.affected_pathway = affected_pathway;
                }
            }

            public static final class Datasources {
                public final long progeny;
                public final long sysbio;
                public final long expression_atlas;
                public final double europepmc;
                public final long intogen;
                public final long phewas_catalog;
                public final long uniprot_literature;
                public final long phenodigm;
                public final long eva;
                public final long gene2phenotype;
                public final long gwas_catalog;
                public final double slapenrich;
                public final long genomics_england;
                public final long postgap;
                public final long uniprot;
                public final long chembl;
                public final long cancer_gene_census;
                public final long reactome;
                public final long uniprot_somatic;
                public final long eva_somatic;
                public final long crispr;

                @JsonCreator
                public Datasources(@JsonProperty("progeny") long progeny, @JsonProperty("sysbio") long sysbio, @JsonProperty("expression_atlas") long expression_atlas, @JsonProperty("europepmc") double europepmc, @JsonProperty("intogen") long intogen, @JsonProperty("phewas_catalog") long phewas_catalog, @JsonProperty("uniprot_literature") long uniprot_literature, @JsonProperty("phenodigm") long phenodigm, @JsonProperty("eva") long eva, @JsonProperty("gene2phenotype") long gene2phenotype, @JsonProperty("gwas_catalog") long gwas_catalog, @JsonProperty("slapenrich") double slapenrich, @JsonProperty("genomics_england") long genomics_england, @JsonProperty("postgap") long postgap, @JsonProperty("uniprot") long uniprot, @JsonProperty("chembl") long chembl, @JsonProperty("cancer_gene_census") long cancer_gene_census, @JsonProperty("reactome") long reactome, @JsonProperty("uniprot_somatic") long uniprot_somatic, @JsonProperty("eva_somatic") long eva_somatic, @JsonProperty("crispr") long crispr){
                    this.progeny = progeny;
                    this.sysbio = sysbio;
                    this.expression_atlas = expression_atlas;
                    this.europepmc = europepmc;
                    this.intogen = intogen;
                    this.phewas_catalog = phewas_catalog;
                    this.uniprot_literature = uniprot_literature;
                    this.phenodigm = phenodigm;
                    this.eva = eva;
                    this.gene2phenotype = gene2phenotype;
                    this.gwas_catalog = gwas_catalog;
                    this.slapenrich = slapenrich;
                    this.genomics_england = genomics_england;
                    this.postgap = postgap;
                    this.uniprot = uniprot;
                    this.chembl = chembl;
                    this.cancer_gene_census = cancer_gene_census;
                    this.reactome = reactome;
                    this.uniprot_somatic = uniprot_somatic;
                    this.eva_somatic = eva_somatic;
                    this.crispr = crispr;
                }
            }
        }

        public static final class Disease {
            public final Efo_info efo_info;
            public final String id;

            @JsonCreator
            public Disease(@JsonProperty("efo_info") Efo_info efo_info, @JsonProperty("id") String id){
                this.efo_info = efo_info;
                this.id = id;
            }

            public static final class Efo_info {
                public final Therapeutic_area therapeutic_area;
                public final List path;
                public final String label;

                @JsonCreator
                public Efo_info(@JsonProperty("therapeutic_area") Therapeutic_area therapeutic_area, @JsonProperty("path") List path, @JsonProperty("label") String label){
                    this.therapeutic_area = therapeutic_area;
                    this.path = path;
                    this.label = label;
                }

                public static final class Therapeutic_area {
                    public final String[] labels;
                    public final String[] codes;

                    @JsonCreator
                    public Therapeutic_area(@JsonProperty("labels") String[] labels, @JsonProperty("codes") String[] codes){
                        this.labels = labels;
                        this.codes = codes;
                    }
                }

                public static final class Path {

                    @JsonCreator
                    public Path(){

                    }
                }
            }
        }

        public static final class Evidence_count {
            public final Datatypes datatypes;
            public final long total;
            public final Datasources datasources;

            @JsonCreator
            public Evidence_count(@JsonProperty("datatypes") Datatypes datatypes, @JsonProperty("total") long total, @JsonProperty("datasources") Datasources datasources){
                this.datatypes = datatypes;
                this.total = total;
                this.datasources = datasources;
            }

            public static final class Datatypes {
                public final long literature;
                public final long rna_expression;
                public final long genetic_association;
                public final long somatic_mutation;
                public final long known_drug;
                public final long animal_model;
                public final long affected_pathway;

                @JsonCreator
                public Datatypes(@JsonProperty("literature") long literature, @JsonProperty("rna_expression") long rna_expression, @JsonProperty("genetic_association") long genetic_association, @JsonProperty("somatic_mutation") long somatic_mutation, @JsonProperty("known_drug") long known_drug, @JsonProperty("animal_model") long animal_model, @JsonProperty("affected_pathway") long affected_pathway){
                    this.literature = literature;
                    this.rna_expression = rna_expression;
                    this.genetic_association = genetic_association;
                    this.somatic_mutation = somatic_mutation;
                    this.known_drug = known_drug;
                    this.animal_model = animal_model;
                    this.affected_pathway = affected_pathway;
                }
            }

            public static final class Datasources {
                public final long progeny;
                public final long sysbio;
                public final long expression_atlas;
                public final long europepmc;
                public final long intogen;
                public final long phewas_catalog;
                public final long uniprot_literature;
                public final long phenodigm;
                public final long eva;
                public final long gene2phenotype;
                public final long gwas_catalog;
                public final long slapenrich;
                public final long genomics_england;
                public final long postgap;
                public final long uniprot;
                public final long chembl;
                public final long cancer_gene_census;
                public final long reactome;
                public final long uniprot_somatic;
                public final long eva_somatic;
                public final long crispr;

                @JsonCreator
                public Datasources(@JsonProperty("progeny") long progeny, @JsonProperty("sysbio") long sysbio, @JsonProperty("expression_atlas") long expression_atlas, @JsonProperty("europepmc") long europepmc, @JsonProperty("intogen") long intogen, @JsonProperty("phewas_catalog") long phewas_catalog, @JsonProperty("uniprot_literature") long uniprot_literature, @JsonProperty("phenodigm") long phenodigm, @JsonProperty("eva") long eva, @JsonProperty("gene2phenotype") long gene2phenotype, @JsonProperty("gwas_catalog") long gwas_catalog, @JsonProperty("slapenrich") long slapenrich, @JsonProperty("genomics_england") long genomics_england, @JsonProperty("postgap") long postgap, @JsonProperty("uniprot") long uniprot, @JsonProperty("chembl") long chembl, @JsonProperty("cancer_gene_census") long cancer_gene_census, @JsonProperty("reactome") long reactome, @JsonProperty("uniprot_somatic") long uniprot_somatic, @JsonProperty("eva_somatic") long eva_somatic, @JsonProperty("crispr") long crispr){
                    this.progeny = progeny;
                    this.sysbio = sysbio;
                    this.expression_atlas = expression_atlas;
                    this.europepmc = europepmc;
                    this.intogen = intogen;
                    this.phewas_catalog = phewas_catalog;
                    this.uniprot_literature = uniprot_literature;
                    this.phenodigm = phenodigm;
                    this.eva = eva;
                    this.gene2phenotype = gene2phenotype;
                    this.gwas_catalog = gwas_catalog;
                    this.slapenrich = slapenrich;
                    this.genomics_england = genomics_england;
                    this.postgap = postgap;
                    this.uniprot = uniprot;
                    this.chembl = chembl;
                    this.cancer_gene_census = cancer_gene_census;
                    this.reactome = reactome;
                    this.uniprot_somatic = uniprot_somatic;
                    this.eva_somatic = eva_somatic;
                    this.crispr = crispr;
                }
            }
        }
    }
}
