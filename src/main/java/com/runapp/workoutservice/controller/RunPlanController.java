package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.request.RunPlanRequest;
import com.runapp.workoutservice.dto.response.RunPlanLongResponse;
import com.runapp.workoutservice.dto.response.RunPlanShortResponse;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.service.Impl.RunPlanGenerator;
import com.runapp.workoutservice.service.Impl.RunPlanServiceImpl;
import com.runapp.workoutservice.service.Impl.VdotCradeServiceImpl;
import com.runapp.workoutservice.service.Impl.VdotWorkoutServiceImpl;
import com.runapp.workoutservice.service.dtoMapper.RunPlanDtoMapper;
import com.runapp.workoutservice.service.runPlanService.RunTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/run-plan")
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
    public ResponseEntity<Object> createPlan(@RequestBody RunPlanRequest runPlanRequest) {
        // todo изменить ответ
        RunPlanGenerator runPlanGenerator = new RunPlanGenerator(vdotWorkoutService, vdotCradeService, runPlanRequest);
        List<RunTraining> plan = runPlanGenerator.generatePlan(runPlanRequest);
        return ResponseEntity.ok().body(runPlanService.createPlan(plan, runPlanRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunPlanLongResponse> getRunPlanById(@PathVariable Long id) {
        RunPlanModel runPlan = runPlanService.getById(id);
        return ResponseEntity.ok().body(runPlanDtoMapper.toLongDto(runPlan));
    }

    @GetMapping("/short")
    public ResponseEntity<List<RunPlanShortResponse>> getAllShortRunPlans() {
        List<RunPlanModel> runPlans = runPlanService.getAll();
        List<RunPlanShortResponse> runPlanLongResponses = runPlanDtoMapper.toShortDto(runPlans);
        return ResponseEntity.ok().body(runPlanLongResponses);
    }

    @GetMapping("/full")
    public ResponseEntity<List<RunPlanLongResponse>> getAllLongRunPlans() {
        List<RunPlanModel> runPlans = runPlanService.getAll();
        List<RunPlanLongResponse> runPlanLongResponses = runPlanDtoMapper.toLongDto(runPlans);
        return ResponseEntity.ok().body(runPlanLongResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRunPlan(@PathVariable Long id) {
        runPlanService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
