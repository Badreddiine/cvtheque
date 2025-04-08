package com.project.cvtheque.controller;


import com.project.cvtheque.model.Utilisateur;
import com.project.cvtheque.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(utilisateurService.createUser(utilisateur));
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        return ResponseEntity.ok(utilisateurService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(utilisateurService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable Long userId, @RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(utilisateurService.updateUser(userId, utilisateur));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        utilisateurService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}