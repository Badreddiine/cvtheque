package com.project.cvtheque.service;

import com.project.cvtheque.exception.ResourceNotFoundException;
import com.project.cvtheque.model.Certificat;
import com.project.cvtheque.repository.CertificatRepository;
import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CertificatService {

    private final CertificatRepository certificatRepository;
    private final UtilisateurRepository utilisateurRepository;

    public CertificatService(CertificatRepository certificatRepository, UtilisateurRepository utilisateurRepository) {
        this.certificatRepository = certificatRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    // Constructeur...

    public Certificat createCertificat(Long userId, Certificat certificat) {
        Utilisateur utilisateur = utilisateurRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        certificat.setUtilisateur(utilisateur);
        return certificatRepository.save(certificat);
    }

    public List<Certificat> getAllCertificatsByUserId(Long userId) {
        return certificatRepository.findByUtilisateurId(userId);
    }

    public Certificat getCertificatById(Long certId) {
        return certificatRepository.findById(certId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificat not found"));
    }

    public void deleteCertificat(Long certId) {
        certificatRepository.deleteById(certId);
    }
}