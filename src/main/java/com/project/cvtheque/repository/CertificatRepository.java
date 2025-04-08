package com.project.cvtheque.repository;

import com.project.cvtheque.model.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Long> {
    List<Certificat> findByUtilisateurId(Long userId);
}