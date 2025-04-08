package com.project.cvtheque.controller;

import com.project.cvtheque.model.Langue;
import com.project.cvtheque.service.LangueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/langues")
public class LangueController {

    private final LangueService langueService;

    public LangueController(LangueService langueService) {
        this.langueService = langueService;
    }

    @PostMapping
    public ResponseEntity<Langue> addLangue(
            @PathVariable Long userId,
            @RequestBody Langue langue) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(langueService.createLangue(userId, langue));
    }

    @GetMapping
    public ResponseEntity<List<Langue>> getAllLangues(@PathVariable Long userId) {
        return ResponseEntity.ok(langueService.getAllLanguesByUserId(userId));
    }

    @GetMapping("/{langueId}")
    public ResponseEntity<Langue> getLangueById(
            @PathVariable Long langueId) {
        return ResponseEntity.ok(langueService.getLangueById(langueId));
    }

    @DeleteMapping("/{langueId}")
    public ResponseEntity<Void> deleteLangue(@PathVariable Long langueId) {
        langueService.deleteLangue(langueId);
        return ResponseEntity.noContent().build();
    }
}