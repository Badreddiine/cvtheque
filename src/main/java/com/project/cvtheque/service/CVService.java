package com.project.cvtheque.service;

import com.project.cvtheque.model.*;
import com.project.cvtheque.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional

public class CVService {
    private final CVRepository cvRepository;

    public CVService(CVRepository cvRepository, UtilisateurRepository utilisateurRepository) {
        this.cvRepository = cvRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    private final UtilisateurRepository utilisateurRepository;

    public CV createCV(CV cv, Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        cv.setUtilisateur(utilisateur);
        return cvRepository.save(cv);
    }

    public CV getCVById(Long id) {
        return cvRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CV non trouvé"));
    }

    public List<CV> getAllCVsByUser(Long utilisateurId) {
        return cvRepository.findByUtilisateurId(utilisateurId);
    }

    public CV updateCV(Long id, CV cvDetails) {
        CV cv = getCVById(id);
        cv.setTitre(cvDetails.getTitre());
        // Mettre à jour d'autres champs si nécessaire
        return cvRepository.save(cv);
    }

    public void deleteCV(Long id) {
        CV cv = getCVById(id);
        cvRepository.delete(cv);
    }

    public CV getOrCreateDefaultCV(Long utilisateurId) {
        return cvRepository.findFirstByUtilisateurId(utilisateurId)
                .orElseGet(() -> {
                    CV newCV = new CV();
                    newCV.setTitre("CV par défaut");
                    newCV.setDateCreation(LocalDate.now()); // Utilisation de LocalDate
                    return createCV(newCV, utilisateurId);
                });
    }
}