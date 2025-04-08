package com.project.cvtheque.service;

import com.project.cvtheque.exception.ResourceNotFoundException;

import com.project.cvtheque.model.Experience;
import com.project.cvtheque.repository.ExperienceRepository;
import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final UtilisateurRepository utilisateurRepository;

    public ExperienceService(ExperienceRepository experienceRepository,
                             UtilisateurRepository utilisateurRepository) {
        this.experienceRepository = experienceRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    // CREATE
    public Experience createExperience(Long utilisateurId, Experience experience) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID: " + utilisateurId));
        experience.setUtilisateur(utilisateur);
        return experienceRepository.save(experience);
    }

    // READ (all for user)
    public List<Experience> getAllExperiencesByUserId(Long utilisateurId) {
        if (!utilisateurRepository.existsById(utilisateurId)) {
            throw new ResourceNotFoundException("Utilisateur non trouvé avec l'ID: " + utilisateurId);
        }
        return experienceRepository.findByUtilisateurId(utilisateurId);
    }

    // READ (single)
    public Experience getExperienceById(Long experienceId) {
        return experienceRepository.findById(experienceId)
                .orElseThrow(() -> new ResourceNotFoundException("Expérience non trouvée avec l'ID: " + experienceId));
    }

    // UPDATE
    public Experience updateExperience(Long experienceId, Experience updatedExperience) {
        Experience experience = getExperienceById(experienceId);

        experience.setPoste(updatedExperience.getPoste());
        experience.setEntreprise(updatedExperience.getEntreprise());
        experience.setDateDebut(updatedExperience.getDateDebut());
        experience.setDateFin(updatedExperience.getDateFin());
        experience.setDescription(updatedExperience.getDescription());

        return experienceRepository.save(experience);
    }

    // DELETE
    public void deleteExperience(Long experienceId) {
        Experience experience = getExperienceById(experienceId);
        experienceRepository.delete(experience);
    }
}