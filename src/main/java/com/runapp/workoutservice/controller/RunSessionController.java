package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.request.RunSessionImageDeleteRequest;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.service.RunSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/run-sessions")
public class RunSessionController {

    private final RunSessionService runSessionService;

    @Autowired
    public RunSessionController(RunSessionService runSessionService) {
        this.runSessionService = runSessionService;
    }

    @PostMapping
    public ResponseEntity<RunSessionModel> createRunSession(@RequestBody RunSessionModel runSessionModel) {
        RunSessionModel createdRunSession = runSessionService.add(runSessionModel);
        return ResponseEntity.ok(createdRunSession);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunSessionModel> getRunSessionById(@PathVariable Long id) {
        RunSessionModel runSessionModel = runSessionService.getById(id);
        return ResponseEntity.ok(runSessionModel);
    }

    @GetMapping
    public ResponseEntity<List<RunSessionModel>> getAllRunSessions() {
        List<RunSessionModel> runSessions = runSessionService.getAll();
        return ResponseEntity.ok(runSessions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RunSessionModel> updateRunSession(@PathVariable Long id, @RequestBody RunSessionModel runSessionModel) {
        runSessionModel.setId(id);
        RunSessionModel updatedRunSession = runSessionService.update(runSessionModel);
        return ResponseEntity.ok(updatedRunSession);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRunSession(@PathVariable Long id) {
        runSessionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-image")
    public ResponseEntity<Object> deleteRunSessionImage(@RequestBody RunSessionImageDeleteRequest deleteRequest) {
        return runSessionService.deleteImage(deleteRequest);
    }

    @PostMapping("/upload-image/{id}")
    public ResponseEntity<Object> uploadRunSessionImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        return runSessionService.uploadImage(file, id);
    }
}
