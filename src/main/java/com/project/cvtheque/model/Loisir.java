package com.project.cvtheque.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Loisir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @ManyToMany(mappedBy = "loisirs")
    private Set<CV> cvs = new HashSet<>();

    public Loisir(Long id, String description, Set<CV> cvs) {
        this.id = id;
        this.description = description;
        this.cvs = cvs;
    }

    public Loisir() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Set<CV> getCvs() {
        return cvs;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCvs(Set<CV> cvs) {
        this.cvs = cvs;
    }
}