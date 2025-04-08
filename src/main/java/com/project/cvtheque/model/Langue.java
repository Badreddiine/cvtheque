package com.project.cvtheque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String niveau;

    @ManyToMany(mappedBy = "langues")
    private Set<CV> cvs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Langue(Long id, String nom, String niveau, Set<CV> cvs, Utilisateur utilisateur) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
        this.cvs = cvs;
        this.utilisateur = utilisateur;
    }

    public Langue() {
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNiveau() {
        return niveau;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setCvs(Set<CV> cvs) {
        this.cvs = cvs;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}