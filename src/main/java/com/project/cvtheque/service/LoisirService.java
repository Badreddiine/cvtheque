package com.project.cvtheque.service;

import com.project.cvtheque.exception.ResourceNotFoundException;
import com.project.cvtheque.model.Loisir;
import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.repository.LoisirRepository;
import com.project.cvtheque.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoisirService {

    private final LoisirRepository loisirRepository;
    private final UtilisateurRepository utilisateurRepository;

    public LoisirService(LoisirRepository loisirRepository,
                         UtilisateurRepository utilisateurRepository) {
        this.loisirRepository = loisirRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Loisir createLoisir(Long utilisateurId, Loisir loisir) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé"));
        loisir.setUtilisateur(utilisateur);
        return loisirRepository.save(loisir);
    }

    public List<Loisir> getAllLoisirsByUserId(Long userId) {
        if (!utilisateurRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Utilisateur non trouvé");
        }
        return loisirRepository.findByUtilisateurId(userId);
    }

    public Loisir getLoisirById(Long id) {
        return loisirRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loisir non trouvé"));
    }

    public Loisir updateLoisir(Long id, Loisir loisirDetails) {
        Loisir loisir = getLoisirById(id);
        loisir.setDescription(loisirDetails.getDescription());
        return loisirRepository.save(loisir);
    }

    public void deleteLoisir(Long id) {
        loisirRepository.deleteById(id);
    }
}