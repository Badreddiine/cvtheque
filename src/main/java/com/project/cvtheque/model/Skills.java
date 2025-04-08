package com.project.cvtheque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomSkill;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @ManyToMany(mappedBy = "skills")
    private Set<CV> cvs = new HashSet<>();

    public Skills(Long id, String nom, Set<CV> cvs) {
        this.id = id;
        this.nomSkill = nom;
        this.cvs = cvs;
    }

    public Skills() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Long getId() {
        return id;
    }

    public String getNomSkill() {
        return nomSkill;
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

    public void setNomSkill(String nom) {
        this.nomSkill = nom;
    }

    public void setCvs(Set<CV> cvs) {
        this.cvs = cvs;
    }
}