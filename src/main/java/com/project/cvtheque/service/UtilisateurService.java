package com.project.cvtheque.service;

import com.project.cvtheque.exception.ResourceNotFoundException;
import com.project.cvtheque.model.*;
import com.project.cvtheque.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final AbonnementService abonnementService;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, AbonnementService abonnementService) {
        this.utilisateurRepository = utilisateurRepository;
        this.abonnementService = abonnementService;
    }

    public Utilisateur createUser(Utilisateur utilisateur) {
        Utilisateur savedUser = utilisateurRepository.save(utilisateur);
        abonnementService.createDefaultAbonnement(savedUser);
        return savedUser;
    }

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUserById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public Utilisateur updateUser(Long id, Utilisateur utilisateur) {
        Utilisateur existing = getUserById(id);
        existing.setNom(utilisateur.getNom());
        existing.setPrenom(utilisateur.getPrenom());
        existing.setEmail(utilisateur.getEmail());
        return utilisateurRepository.save(existing);
    }

    public void deleteUser(Long id) {
        utilisateurRepository.deleteById(id);
    }



}