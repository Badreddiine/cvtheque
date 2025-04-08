package com.project.cvtheque.service;
import com.project.cvtheque.model.Langue;
import com.project.cvtheque.repository.LangueRepository;
import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class LangueService {
    private final LangueRepository langueRepository;

    public LangueService(LangueRepository langueRepository) {
        this.langueRepository = langueRepository;
    }

    public Langue createLangue(Long userId, Langue langue) {
        // Implémentation de la création
        return langueRepository.save(langue);
    }

    public List<Langue> getAllLanguesByUserId(Long userId) {
        return langueRepository.findByUtilisateurId(userId);
    }

    public Langue getLangueById(Long langueId) {
        return langueRepository.findById(langueId)
                .orElseThrow(() -> new RuntimeException("Langue non trouvée"));
    }

    public void deleteLangue(Long langueId) {
        langueRepository.deleteById(langueId);
    }
}