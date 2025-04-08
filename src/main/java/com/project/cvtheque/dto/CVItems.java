package com.project.cvtheque.dto;

import com.project.cvtheque.model.*;

import java.util.Set;

public class CVItems {
    private Set<Experience> experiences;
    private Set<Education> educations;
    private Set<Skills> skills;
    private Set<Certificat> certificats;
    private Set<Langue> langues;
    private Set<Loisir> loisirs;

    // Getters and Setters
    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public Set<Certificat> getCertificats() {
        return certificats;
    }

    public void setCertificats(Set<Certificat> certificats) {
        this.certificats = certificats;
    }

    public Set<Langue> getLangues() {
        return langues;
    }

    public void setLangues(Set<Langue> langues) {
        this.langues = langues;
    }

    public Set<Loisir> getLoisirs() {
        return loisirs;
    }

    public void setLoisirs(Set<Loisir> loisirs) {
        this.loisirs = loisirs;
    }
}
