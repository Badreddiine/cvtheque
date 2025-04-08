package com.project.cvtheque.repository;

import com.project.cvtheque.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByUtilisateurId(Long userId);
}