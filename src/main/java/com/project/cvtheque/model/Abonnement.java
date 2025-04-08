package com.project.cvtheque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity

public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_abonnement")
    private Long idAbonnement;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TypeAbonnement type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusAbonnement status = StatusAbonnement.ACTIF;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    private Utilisateur utilisateur;

    public boolean isActif() {
        LocalDate now = LocalDate.now();
        return status == StatusAbonnement.ACTIF
                && !now.isBefore(dateDebut)
                && !now.isAfter(dateFin);
    }

    public Long getIdAbonnement() {
        return idAbonnement;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public TypeAbonnement getType() {
        return type;
    }

    public StatusAbonnement getStatus() {
        return status;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setIdAbonnement(Long idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setType(TypeAbonnement type) {
        this.type = type;
    }

    public void setStatus(StatusAbonnement status) {
        this.status = status;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
