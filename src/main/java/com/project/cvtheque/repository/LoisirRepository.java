package com.project.cvtheque.repository;


import com.project.cvtheque.model.Loisir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoisirRepository extends JpaRepository<Loisir, Long> {
    List<Loisir> findByUtilisateurId(Long userId);
}