package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.request.VdotGradeRequest;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/vdot")
@Tag(name = "Vdot Grade Management", description = "Operations related to Vdot grades")
public class VdotGradeController {

    private final VdotCradeServiceImpl vdotGradeService;
    private final VdotWorkoutRepository vdotWorkoutRepository;

    @Autowired
    public VdotGradeController(VdotCradeServiceImpl vdotGradeService, VdotWorkoutRepository vdotWorkoutRepository) {
        this.vdotGradeService = vdotGradeService;
        this.vdotWorkoutRepository = vdotWorkoutRepository;
    }

    @PostMapping("my-personal-indicators")
    @Operation(summary = "Get VDOT workout based on personal indicators",
            description = "Retrieve a VDOT workout based on the provided distance and time indicators")
    @ApiResponse(responseCode = "200", description = "VDOT workout found", content = @Content(schema = @Schema(implementation = VdotWorkoutModel.class)))
    public ResponseEntity<VdotWorkoutModel> getPersonalityVDOT(
            @Parameter(description = "Request body containing distance and time indicators", required = true)
            @RequestBody @Valid VdotGradeRequest vdotGradeRequest) {
        VdotGradeModel vdotGradeModel = vdotGradeService.findClosestTimeByDistanceAndTime(vdotGradeRequest.getDistance(), vdotGradeRequest.getTime());
        return ResponseEntity.ok().body(vdotWorkoutRepository.findById(vdotGradeModel.getVdot()).orElse(null));
    }
}
