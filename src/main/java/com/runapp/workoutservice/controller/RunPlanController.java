package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.request.RunPlanRequest;
import com.runapp.workoutservice.dto.response.RunPlanLongResponse;
import com.runapp.workoutservice.dto.response.RunPlanShortResponse;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.service.serviceImpl.RunPlanGenerator;
import com.runapp.workoutservice.service.serviceImpl.RunPlanServiceImpl;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import com.runapp.workoutservice.service.serviceImpl.VdotWorkoutServiceImpl;
import com.runapp.workoutservice.dto.dtoMapper.RunPlanDtoMapper;
import com.runapp.workoutservice.service.runPlanService.RunTraining;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/run-plan")
@Tag(name = "Run Plan Management", description = "Operations related to run plans")
public class RunPlanController {

    private final VdotWorkoutServiceImpl vdotWorkoutService;
    private final VdotCradeServiceImpl vdotCradeService;
    private final RunPlanServiceImpl runPlanService;
    private final RunPlanDtoMapper runPlanDtoMapper;

    @Autowired
    public RunPlanController(VdotWorkoutServiceImpl vdotWorkoutService, VdotCradeServiceImpl vdotCradeService, RunPlanServiceImpl runPlanService, RunPlanDtoMapper runPlanDtoMapper) {
        this.vdotWorkoutService = vdotWorkoutService;
        this.vdotCradeService = vdotCradeService;
        this.runPlanService = runPlanService;
        this.runPlanDtoMapper = runPlanDtoMapper;
    }

    @PostMapping
    @Operation(summary = "Create a new run plan", description = "Create a new run plan with the provided data")
    @ApiResponse(responseCode = "200", description = "Run plan created", content = @Content(schema = @Schema(implementation = RunPlanLongResponse.class)))
    public ResponseEntity<Object> createPlan(@RequestBody RunPlanRequest runPlanRequest) {
        RunPlanGenerator runPlanGenerator = new RunPlanGenerator(vdotWorkoutService, vdotCradeService, runPlanRequest);
        List<RunTraining> plan = runPlanGenerator.generatePlan(runPlanRequest);
        return ResponseEntity.ok().body(runPlanDtoMapper.toLongDto(runPlanService.createPlan(plan, runPlanRequest)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a run plan by ID", description = "Retrieve a run plan by its ID")
    @ApiResponse(responseCode = "200", description = "Run plan found", content = @Content(schema = @Schema(implementation = RunPlanLongResponse.class)))
    public ResponseEntity<RunPlanLongResponse> getRunPlanById(
            @Parameter(description = "Run plan ID", required = true)
            @PathVariable Long id) {
        RunPlanModel runPlan = runPlanService.getById(id);

        return ResponseEntity.ok().body(runPlanDtoMapper.toLongDto(runPlan));
    }

    @GetMapping("/short")
    @Operation(summary = "Get all short run plans", description = "Retrieve a list of all short run plans")
    @ApiResponse(responseCode = "200", description = "Short run plans found", content = @Content(schema = @Schema(implementation = RunPlanShortResponse.class)))
    public ResponseEntity<List<RunPlanShortResponse>> getAllShortRunPlans() {
        List<RunPlanModel> runPlans = runPlanService.getAll();
        List<RunPlanShortResponse> runPlanShortResponses = runPlanDtoMapper.toShortDto(runPlans);
        return ResponseEntity.ok().body(runPlanShortResponses);
    }

    @GetMapping("/full")
    @Operation(summary = "Get all long run plans", description = "Retrieve a list of all long run plans")
    @ApiResponse(responseCode = "200", description = "Long run plans found", content = @Content(schema = @Schema(implementation = RunPlanLongResponse.class)))
    public ResponseEntity<List<RunPlanLongResponse>> getAllLongRunPlans() {
        List<RunPlanModel> runPlans = runPlanService.getAll();
        List<RunPlanLongResponse> runPlanLongResponses = runPlanDtoMapper.toLongDto(runPlans);
        return ResponseEntity.ok().body(runPlanLongResponses);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a run plan by ID", description = "Delete a run plan by its ID")
    @ApiResponse(responseCode = "204", description = "Run plan deleted")
    @ApiResponse(responseCode = "404", description = "Run plan not found")
    public ResponseEntity<Void> deleteRunPlan(
            @Parameter(description = "Run plan ID", required = true)
            @PathVariable Long id) {
        runPlanService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
