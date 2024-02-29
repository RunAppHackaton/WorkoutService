package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.dtoMapper.RunSessionDtoMapper;
import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.service.serviceImpl.RunSessionServiceImpl;
import com.runapp.workoutservice.service.serviceTemplate.RunSessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/run-sessions")
@Tag(name = "Run Session Management", description = "Operations related to run sessions")
public class RunSessionController {

    private final RunSessionService runSessionService;
    private final RunSessionDtoMapper runSessionDtoMapper;

    @Autowired
    public RunSessionController(RunSessionService  runSessionService, RunSessionDtoMapper runSessionDtoMapper) {
        this.runSessionService = runSessionService;
        this.runSessionDtoMapper = runSessionDtoMapper;
    }

    @GetMapping
    @Operation(summary = "Get all run sessions", description = "Retrieve a list of all run sessions")
    @ApiResponse(responseCode = "200", description = "Run sessions found", content = @Content(schema = @Schema(implementation = RunSessionResponse.class)))
    public List<RunSessionResponse> getAllRunSessions() {
        List<RunSessionModel> runSessions = runSessionService.getAll();
        return runSessions.stream()
                .map(runSessionDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a run session by ID", description = "Retrieve a run session by its ID")
    @ApiResponse(responseCode = "200", description = "Run session found", content = @Content(schema = @Schema(implementation = RunSessionResponse.class)))
    public ResponseEntity<RunSessionResponse> getRunSessionById(
            @Parameter(description = "Run session ID", required = true)
            @PathVariable Long id) {
        RunSessionModel runSession = runSessionService.getById(id);
        return ResponseEntity.ok(runSessionDtoMapper.toResponse(runSession));
    }

    @PostMapping
    @Operation(summary = "Add a new run session", description = "Create a new run session with the provided data")
    @ApiResponse(responseCode = "201", description = "Run session created", content = @Content(schema = @Schema(implementation = RunSessionResponse.class)))
    public ResponseEntity<RunSessionResponse> addRunSession(
            @Parameter(description = "Run session data", required = true)
            @Valid @RequestBody RunSessionRequest runSessionRequest) {
        RunSessionModel runSession = runSessionDtoMapper.toModel(runSessionRequest);
        RunSessionModel savedRunSession = runSessionService.add(runSession);
        return new ResponseEntity<>(runSessionDtoMapper.toResponse(savedRunSession), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a run session by ID", description = "Update a run session with the provided data")
    @ApiResponse(responseCode = "200", description = "Run session updated", content = @Content(schema = @Schema(implementation = RunSessionResponse.class)))
    @ApiResponse(responseCode = "404", description = "Run session not found")
    public ResponseEntity<RunSessionResponse> updateRunSession(
            @Parameter(description = "Run session ID", required = true)
            @PathVariable Long id,
            @Parameter(description = "Updated run session data", required = true)
            @RequestBody RunSessionRequest runSessionRequest) {
        RunSessionModel existingRunSession = runSessionService.getById(id);
        RunSessionModel updatedRunSession = runSessionDtoMapper.toModel(runSessionRequest);
        updatedRunSession.setId(existingRunSession.getId());
        updatedRunSession = runSessionService.update(updatedRunSession);
        return ResponseEntity.ok(runSessionDtoMapper.toResponse(updatedRunSession));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a run session by ID", description = "Delete a run session by its ID")
    @ApiResponse(responseCode = "204", description = "Run session deleted")
    @ApiResponse(responseCode = "404", description = "Run session not found")
    public ResponseEntity<Void> deleteRunSession(
            @Parameter(description = "Run session ID", required = true)
            @PathVariable Long id) {
        runSessionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
