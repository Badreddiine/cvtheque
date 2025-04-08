package com.project.cvtheque.controller;


import com.project.cvtheque.model.Education;
import com.project.cvtheque.service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/users/{userId}/educations")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<Education> addEducation(
            @PathVariable Long userId,
            @RequestBody Education education) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(educationService.createEducation(userId, education));
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations(@PathVariable Long userId) {
        return ResponseEntity.ok(educationService.getAllEducationsByUserId(userId));
    }

    @GetMapping("/{eduId}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long eduId) {
        return ResponseEntity.ok(educationService.getEducationById(eduId));
    }

    @PutMapping("/{eduId}")
    public ResponseEntity<Education> updateEducation(
            @PathVariable Long eduId,
            @RequestBody Education education) {
        return ResponseEntity.ok(educationService.updateEducation(eduId, education));
    }

    @DeleteMapping("/{eduId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long eduId) {
        educationService.deleteEducation(eduId);
        return ResponseEntity.noContent().build();
    }
}