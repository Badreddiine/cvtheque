package com.project.cvtheque.controller;


import com.project.cvtheque.model.Experience;
import com.project.cvtheque.service.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{utilisateurId}/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Experience> createExperience(
            @PathVariable Long utilisateurId,
            @RequestBody Experience experience) {
        return new ResponseEntity<>(
                experienceService.createExperience(utilisateurId, experience),
                HttpStatus.CREATED);
    }

    // READ (all)
    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences(
            @PathVariable Long utilisateurId) {
        return ResponseEntity.ok(experienceService.getAllExperiencesByUserId(utilisateurId));
    }

    // READ (single)
    @GetMapping("/{experienceId}")
    public ResponseEntity<Experience> getExperienceById(
            @PathVariable Long experienceId) {
        return ResponseEntity.ok(experienceService.getExperienceById(experienceId));
    }

    // UPDATE
    @PutMapping("/{experienceId}")
    public ResponseEntity<Experience> updateExperience(
            @PathVariable Long experienceId,
            @RequestBody Experience experience) {
        return ResponseEntity.ok(experienceService.updateExperience(experienceId, experience));
    }

    // DELETE
    @DeleteMapping("/{experienceId}")
    public ResponseEntity<Void> deleteExperience(
            @PathVariable Long experienceId) {
        experienceService.deleteExperience(experienceId);
        return ResponseEntity.noContent().build();
    }
}