package com.project.cvtheque.service;
import com.project.cvtheque.model.Abonnement;
import com.project.cvtheque.exception.ResourceNotFoundException;
import com.project.cvtheque.model.StatusAbonnement;
import com.project.cvtheque.model.TypeAbonnement;
import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.repository.AbonnementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AbonnementService {

    private final AbonnementRepository abonnementRepository;

    public AbonnementService(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    public Abonnement getCurrentAbonnement(Long userId) {
        return abonnementRepository.findCurrentByUtilisateurId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No active subscription found"));
    }

    public Abonnement upgradeAbonnement(Long userId, TypeAbonnement newType) {
        Abonnement current = getCurrentAbonnement(userId);
        current.setStatus(StatusAbonnement.INACTIF);
        abonnementRepository.save(current);

        Abonnement newAbonnement = new Abonnement();
        newAbonnement.setType(newType);
        newAbonnement.setDateDebut(LocalDate.now());
        newAbonnement.setDateFin(calculateEndDate(newType));
        newAbonnement.setStatus(StatusAbonnement.ACTIF);
        newAbonnement.setUtilisateur(current.getUtilisateur());

        return abonnementRepository.save(newAbonnement);
    }

    public Abonnement createAbonnement(Abonnement abonnement) {
        if (abonnement.getUtilisateur() == null) {
            throw new IllegalArgumentException("Un utilisateur doit être associé à l'abonnement");
        }
        return abonnementRepository.save(abonnement);
    }

    public Abonnement createDefaultAbonnement(Utilisateur utilisateur) {
        Abonnement abonnement = new Abonnement();
        abonnement.setType(TypeAbonnement.GRATUIT);
        abonnement.setStatus(StatusAbonnement.ACTIF);
        abonnement.setDateDebut(LocalDate.now());
        abonnement.setDateFin(LocalDate.now().plusYears(1));
        abonnement.setUtilisateur(utilisateur);
        return createAbonnement(abonnement);
    }

    public List<Abonnement> getAbonnementHistory(Long userId) {
        return abonnementRepository.findByUtilisateurIdOrderByDateDebutDesc(userId);
    }

    private LocalDate calculateEndDate(TypeAbonnement type) {
        return switch(type) {
            case GRATUIT -> LocalDate.now().plusYears(1);
            case PREMIUM -> LocalDate.now().plusYears(1);
            case BUSINESS -> LocalDate.now().plusYears(2);
        };
    }
}
