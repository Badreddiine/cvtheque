package com.project.cvtheque.controller;

import com.project.cvtheque.model.TypeAbonnement;
import com.project.cvtheque.model.Abonnement;
import com.project.cvtheque.service.AbonnementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/abonnements")
public class AbonnementController {

    private final AbonnementService abonnementService;

    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @GetMapping("/current")
    public ResponseEntity<Abonnement> getCurrentAbonnement(@PathVariable Long userId) {
        return ResponseEntity.ok(abonnementService.getCurrentAbonnement(userId));
    }

    @PostMapping("/upgrade")
    public ResponseEntity<Abonnement> upgradeAbonnement(
            @PathVariable Long userId,
            @RequestParam TypeAbonnement newType) {
        return ResponseEntity.ok(abonnementService.upgradeAbonnement(userId, newType));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Abonnement>> getAbonnementHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(abonnementService.getAbonnementHistory(userId));
    }
}
