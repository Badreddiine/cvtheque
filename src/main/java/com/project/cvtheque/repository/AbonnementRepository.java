package com.project.cvtheque.repository;

import com.project.cvtheque.model.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {

    // La méthode recherche l'abonnement courant pour un utilisateur via la propriété "utilisateur"
    Optional<Abonnement> findCurrentByUtilisateurId(Long utilisateurId);

    // Récupère l'historique des abonnements d'un utilisateur en triant par date de début décroissante
    List<Abonnement> findByUtilisateurIdOrderByDateDebutDesc(Long utilisateurId);
}
