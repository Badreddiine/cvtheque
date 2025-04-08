package com.project.cvtheque.repository;


import com.project.cvtheque.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    List<Skills> findByUtilisateurId(Long userId);
}