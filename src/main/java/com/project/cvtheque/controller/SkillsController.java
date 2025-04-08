package com.project.cvtheque.controller;


import com.project.cvtheque.model.Skills;
import com.project.cvtheque.service.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/skills")
public class SkillsController {

    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @PostMapping
    public ResponseEntity<Skills> createSkill(
            @PathVariable Long userId,
            @RequestBody Skills skill) {
        return new ResponseEntity<>(
                skillsService.createSkill(userId, skill),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Skills>> getAllSkillsByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(skillsService.getAllSkillsByUserId(userId));
    }

    @GetMapping("/{skillId}")
    public ResponseEntity<Skills> getSkillById(
            @PathVariable Long skillId) {
        return ResponseEntity.ok(skillsService.getSkillById(skillId));
    }

    @PutMapping("/{skillId}")
    public ResponseEntity<Skills> updateSkill(
            @PathVariable Long skillId,
            @RequestBody Skills skill) {
        return ResponseEntity.ok(skillsService.updateSkill(skillId, skill));
    }

    @DeleteMapping("/{skillId}")
    public ResponseEntity<Void> deleteSkill(
            @PathVariable Long skillId) {
        skillsService.deleteSkill(skillId);
        return ResponseEntity.noContent().build();
    }
}