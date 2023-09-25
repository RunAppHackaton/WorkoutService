package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.request.RunSessionImageDeleteRequest;
import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.service.RunSessionService;
import com.runapp.workoutservice.service.dtoMapper.RunSessionDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/run-sessions")
@Tag(name = "Run Session Management", description = "Operations related to run sessions")
public class RunSessionController {

    private final RunSessionService runSessionService;

    @Autowired
    public RunSessionController(RunSessionService runSessionService) {
        this.runSessionService = runSessionService;
    }

    @PostMapping
    @Operation(summary = "Create a new run session", description = "Create a new run session with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Run session created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    public ResponseEntity<?> createRunSession(@RequestBody @Valid RunSessionRequest runSessionRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        }

        RunSessionModel runSessionModel = RunSessionDtoMapper.toModel(runSessionRequest);
        RunSessionModel createdRunSession = runSessionService.add(runSessionModel);
        return ResponseEntity.ok(RunSessionDtoMapper.toResponse(createdRunSession));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a run session by ID", description = "Retrieve a run session by its ID")
    @ApiResponse(responseCode = "200", description = "Run session found")
    @ApiResponse(responseCode = "404", description = "Run session not found")
    public ResponseEntity<?> getRunSessionById(@Parameter(description = "Run session ID", required = true)
                                               @PathVariable Long id) {
        RunSessionModel runSessionModel = runSessionService.getById(id);
        if (runSessionModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RunSessionDtoMapper.toResponse(runSessionModel));
    }

    @GetMapping
    @Operation(summary = "Get all run sessions", description = "Retrieve a list of all run sessions")
    @ApiResponse(responseCode = "200", description = "Run sessions found")
    public ResponseEntity<List<RunSessionResponse>> getAllRunSessions() {
        List<RunSessionModel> runSessions = runSessionService.getAll();
        List<RunSessionResponse> responseList = RunSessionDtoMapper.toResponseList(runSessions);
        return ResponseEntity.ok(responseList);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a run session", description = "Update an existing run session with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Run session updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Run session not found"),
    })
    public ResponseEntity<?> updateRunSession(@Parameter(description = "Run session ID", required = true)
                                              @PathVariable Long id,
                                              @RequestBody @Valid RunSessionRequest runSessionRequest,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        }
        RunSessionModel runSessionModel = RunSessionDtoMapper.toModel(runSessionRequest);
        runSessionModel.setId(id);
        RunSessionModel updatedRunSession = runSessionService.update(runSessionModel);
        return ResponseEntity.ok(RunSessionDtoMapper.toResponse(updatedRunSession));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a run session by ID", description = "Delete a run session by its ID")
    @ApiResponse(responseCode = "204", description = "Run session deleted")
    @ApiResponse(responseCode = "404", description = "Run session not found")
    public ResponseEntity<Object> deleteRunSession(@PathVariable Long id) {
        runSessionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-image")
    @Operation(summary = "Delete an image associated with a run session", description = "Delete the image associated with a run session by providing the image URI and run session details.")
    @ApiResponse(responseCode = "200", description = "Image deleted successfully")
    @ApiResponse(responseCode = "404", description = "Run session not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Object> deleteRunSessionImage(
            @Parameter(description = "Run session ID", required = true)
            @RequestBody RunSessionImageDeleteRequest deleteRequest) {
        return runSessionService.deleteImage(deleteRequest);
    }


    @PostMapping("/upload-image/{id}")
    @Operation(summary = "Upload an image for a run session", description = "Upload an image file for a specific run session by providing the file and run session ID.")
    @ApiResponse(responseCode = "200", description = "Image uploaded successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Run session not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Object> uploadRunSessionImage(@Parameter(description = "Image file to upload", required = true) @RequestParam("file") MultipartFile file,
                                                        @Parameter(description = "ID of the run session to associate with the uploaded image", required = true) @PathVariable Long id) {
        return runSessionService.uploadImage(file, id);
    }
}
