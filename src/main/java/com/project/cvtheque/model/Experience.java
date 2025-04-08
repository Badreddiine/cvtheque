package com.project.cvtheque.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String poste;
    private String entreprise;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


    @ManyToMany(mappedBy = "experiences")
    private Set<CV> cvs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getPoste() {
        return poste;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public String getDescription() {
        return description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Set<CV> getCvs() {
        return cvs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setCvs(Set<CV> cvs) {
        this.cvs = cvs;
    }

    public Experience(Long id, String poste, String entreprise, LocalDate dateDebut, LocalDate dateFin, String description, Utilisateur utilisateur, Set<CV> cvs) {
        this.id = id;
        this.poste = poste;
        this.entreprise = entreprise;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.utilisateur = utilisateur;
        this.cvs = cvs;
    }

    public Experience() {
    }
}