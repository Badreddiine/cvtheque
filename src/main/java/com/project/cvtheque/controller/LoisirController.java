package com.project.cvtheque.controller;

import com.project.cvtheque.model.Loisir;
import com.project.cvtheque.service.LoisirService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/loisirs")
public class LoisirController {

    private final LoisirService loisirService;

    public LoisirController(LoisirService loisirService) {
        this.loisirService = loisirService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Loisir> createLoisir(
            @PathVariable Long userId,
            @RequestBody Loisir loisir) {
        return new ResponseEntity<>(
                loisirService.createLoisir(userId, loisir),
                HttpStatus.CREATED);
    }

    // READ (all)
    @GetMapping
    public ResponseEntity<List<Loisir>> getAllLoisirs(
            @PathVariable Long userId) {
        return ResponseEntity.ok(loisirService.getAllLoisirsByUserId(userId));
    }

    // READ (single)
    @GetMapping("/{id}")
    public ResponseEntity<Loisir> getLoisirById(
            @PathVariable Long userId,
            @PathVariable Long id) {
        return ResponseEntity.ok(loisirService.getLoisirById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Loisir> updateLoisir(
            @PathVariable Long id,
            @RequestBody Loisir loisir) {
        return ResponseEntity.ok(loisirService.updateLoisir(id, loisir));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoisir(
            @PathVariable Long id) {
        loisirService.deleteLoisir(id);
        return ResponseEntity.noContent().build();
    }
}