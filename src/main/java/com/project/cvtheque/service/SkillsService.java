package com.project.cvtheque.service;

import com.project.cvtheque.exception.ResourceNotFoundException;

import com.project.cvtheque.model.Skills;
import com.project.cvtheque.repository.SkillsRepository;
import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsService {

    private final SkillsRepository skillsRepository;
    private final UtilisateurRepository utilisateurRepository;

    public SkillsService(SkillsRepository skillsRepository,
                         UtilisateurRepository utilisateurRepository) {
        this.skillsRepository = skillsRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Skills createSkill(Long userId, Skills skill) {
        Utilisateur user = utilisateurRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        skill.setUtilisateur(user);
        return skillsRepository.save(skill);
    }

    public List<Skills> getAllSkillsByUserId(Long userId) {
        if (!utilisateurRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return skillsRepository.findByUtilisateurId(userId);
    }

    public Skills getSkillById(Long id) {
        return skillsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));
    }

    public Skills updateSkill(Long id, Skills skillDetails) {
        Skills skill = getSkillById(id);
        skill.setNomSkill(skillDetails.getNomSkill());

        return skillsRepository.save(skill);
    }

    public void deleteSkill(Long id) {
        Skills skill = getSkillById(id);
        skillsRepository.delete(skill);
    }
}