package com.project.cvtheque.controller;


import com.project.cvtheque.service.CVService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import com.project.cvtheque.model.CV;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/cvs")
public class CVController {
    private final CVService cvService;

    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    @PostMapping
    public ResponseEntity<CV> createCV(@PathVariable Long userId, @RequestBody CV cv) {
        return new ResponseEntity<>(cvService.createCV(cv, userId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CV>> getAllCVsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(cvService.getAllCVsByUser(userId));
    }

    @GetMapping("/{cvId}")
    public ResponseEntity<CV> getCVById(@PathVariable Long cvId) {
        return ResponseEntity.ok(cvService.getCVById(cvId));
    }

    @PutMapping("/{cvId}")
    public ResponseEntity<CV> updateCV(@PathVariable Long cvId, @RequestBody CV cv) {
        return ResponseEntity.ok(cvService.updateCV(cvId, cv));
    }

    @DeleteMapping("/{cvId}")
    public ResponseEntity<Void> deleteCV(@PathVariable Long cvId) {
        cvService.deleteCV(cvId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/default")
    public ResponseEntity<CV> getOrCreateDefaultCV(@PathVariable Long userId) {
        return ResponseEntity.ok(cvService.getOrCreateDefaultCV(userId));
    }
}