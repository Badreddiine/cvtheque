package com.project.cvtheque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.*;

@Entity

public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToMany
    @JoinTable(
            name = "cv_experience",
            joinColumns = @JoinColumn(name = "cv_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id")
    )
    private Set<Experience> experiences = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cv_education",
            joinColumns = @JoinColumn(name = "cv_id"),
            inverseJoinColumns = @JoinColumn(name = "education_id")
    )
    private Set<Education> educations = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cv_skills",
            joinColumns = @JoinColumn(name = "cv_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skills> skills = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cv_certificat",
            joinColumns = @JoinColumn(name = "cv_id"),
            inverseJoinColumns = @JoinColumn(name = "certificat_id")
    )
    private Set<Certificat> certificats = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cv_langue",
            joinColumns = @JoinColumn(name = "cv_id"),
            inverseJoinColumns = @JoinColumn(name = "langue_id")
    )
    private Set<Langue> langues = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cv_loisir",
            joinColumns = @JoinColumn(name = "cv_id"),
            inverseJoinColumns = @JoinColumn(name = "loisir_id")
    )
    private Set<Loisir> loisirs = new HashSet<>();

    public CV() {
        this.dateCreation = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public Set<Certificat> getCertificats() {
        return certificats;
    }

    public Set<Langue> getLangues() {
        return langues;
    }

    public Set<Loisir> getLoisirs() {
        return loisirs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public void setCertificats(Set<Certificat> certificats) {
        this.certificats = certificats;
    }

    public void setLangues(Set<Langue> langues) {
        this.langues = langues;
    }

    public void setLoisirs(Set<Loisir> loisirs) {
        this.loisirs = loisirs;
    }

    public CV(Long id, String titre, LocalDate dateCreation, Utilisateur utilisateur, Set<Experience> experiences, Set<Education> educations, Set<Skills> skills, Set<Certificat> certificats, Set<Langue> langues, Set<Loisir> loisirs) {
        this.id = id;
        this.titre = titre;
        this.dateCreation = dateCreation;
        this.utilisateur = utilisateur;
        this.experiences = experiences;
        this.educations = educations;
        this.skills = skills;
        this.certificats = certificats;
        this.langues = langues;
        this.loisirs = loisirs;
    }

}