package com.project.cvtheque.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String organisme;
    private LocalDate dateObtention;

    @ManyToMany(mappedBy = "certificats")
    private Set<CV> cvs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Long getId() {
        return id;
    }

    public String getOrganisme() {
        return organisme;
    }

    public LocalDate getDateObtention() {
        return dateObtention;
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

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public void setDateObtention(LocalDate dateObtention) {
        this.dateObtention = dateObtention;
    }

    public void setCvs(Set<CV> cvs) {
        this.cvs = cvs;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Certificat(Long id, String organisme, LocalDate dateObtention, Set<CV> cvs, Utilisateur utilisateur) {
        this.id = id;
        this.organisme = organisme;
        this.dateObtention = dateObtention;
        this.cvs = cvs;
        this.utilisateur = utilisateur;
    }

    public Certificat() {
    }
}