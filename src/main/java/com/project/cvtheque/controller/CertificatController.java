package com.project.cvtheque.controller;

import com.project.cvtheque.model.Certificat;
import com.project.cvtheque.service.CertificatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/certificats")
public class CertificatController {

    private final CertificatService certificatService;

    public CertificatController(CertificatService certificatService) {
        this.certificatService = certificatService;
    }

    @PostMapping
    public ResponseEntity<Certificat> addCertificat(
            @PathVariable Long userId,
            @RequestBody Certificat certificat) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(certificatService.createCertificat(userId, certificat));
    }

    @GetMapping
    public ResponseEntity<List<Certificat>> getAllCertificats(@PathVariable Long userId) {
        return ResponseEntity.ok(certificatService.getAllCertificatsByUserId(userId));
    }

    @GetMapping("/{certId}")
    public ResponseEntity<Certificat> getCertificatById(@PathVariable Long certId) {
        return ResponseEntity.ok(certificatService.getCertificatById(certId));
    }

    @DeleteMapping("/{certId}")
    public ResponseEntity<Void> deleteCertificat(@PathVariable Long certId) {
        certificatService.deleteCertificat(certId);
        return ResponseEntity.noContent().build();
    }
}