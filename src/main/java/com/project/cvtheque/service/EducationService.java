package com.project.cvtheque.service;

import com.project.cvtheque.exception.ResourceNotFoundException;

import com.project.cvtheque.model.Education;
import com.project.cvtheque.repository.EducationRepository;
import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



import com.project.cvtheque.model.Education;
import com.project.cvtheque.repository.EducationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public Education createEducation(Long userId, Education education) {
        // Implémentation existante
        return educationRepository.save(education);
    }

    public List<Education> getAllEducationsByUserId(Long userId) {
        return educationRepository.findByUtilisateurId(userId);
    }

    public Education getEducationById(Long eduId) {
        return educationRepository.findById(eduId)
                .orElseThrow(() -> new RuntimeException("Education not found"));
    }

    public Education updateEducation(Long eduId, Education education) {
        Education existing = getEducationById(eduId);
        // Mettre à jour les champs nécessaires
        return educationRepository.save(existing);
    }

    public void deleteEducation(Long eduId) {
        educationRepository.deleteById(eduId);
    }
}