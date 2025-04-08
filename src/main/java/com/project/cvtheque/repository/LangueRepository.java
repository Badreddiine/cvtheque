package com.project.cvtheque.repository;

import com.project.cvtheque.model.Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LangueRepository extends JpaRepository<Langue, Long> {
    List<Langue> findByUtilisateurId(Long userId);
}