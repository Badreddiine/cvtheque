package com.project.cvtheque.repository;

import com.project.cvtheque.model.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CVRepository extends JpaRepository<CV, Long> {
    List<CV> findByUtilisateurId(Long utilisateurId);
    Optional<CV> findFirstByUtilisateurId(Long utilisateurId);
}