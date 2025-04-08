package com.project.cvtheque.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diplome;
    private String etablissement;
    private String description;
    private LocalDate anneeObtention;

    @ManyToMany(mappedBy = "educations")
    private Set<CV> cvs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Long getId() {
        return id;
    }

    public String getDiplome() {
        return diplome;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getAnneeObtention() {
        return anneeObtention;
    }

    public Set<CV> getCvs() {
        return cvs;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAnneeObtention(LocalDate anneeObtention) {
        this.anneeObtention = anneeObtention;
    }

    public void setCvs(Set<CV> cvs) {
        this.cvs = cvs;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Education(Long id, String diplome, String etablissement, String description, LocalDate anneeObtention, Set<CV> cvs, Utilisateur utilisateur) {
        this.id = id;
        this.diplome = diplome;
        this.etablissement = etablissement;
        this.description = description;
        this.anneeObtention = anneeObtention;
        this.cvs = cvs;
        this.utilisateur = utilisateur;
    }

    public Education() {
    }
}