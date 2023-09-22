package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.request.VdotGradeRequest;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.Impl.VdotCradeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/vdot")
public class VdotGradeController {

    private final VdotCradeServiceImpl vdotGradeService;
    private final VdotWorkoutRepository vdotWorkoutRepository;

    @Autowired
    public VdotGradeController(VdotCradeServiceImpl vdotGradeService, VdotWorkoutRepository vdotWorkoutRepository) {
        this.vdotGradeService = vdotGradeService;
        this.vdotWorkoutRepository = vdotWorkoutRepository;
    }


    @PostMapping("my-personal-indicators")
    public ResponseEntity<VdotWorkoutModel> getPersonalityVDOT(@RequestBody @Valid VdotGradeRequest vdotGradeRequest) {
        VdotGradeModel vdotGradeModel = vdotGradeService.findClosestTimeByDistanceAndTime(vdotGradeRequest.getDistance(), vdotGradeRequest.getTime());
        return ResponseEntity.ok().body(vdotWorkoutRepository.findById(vdotGradeModel.getVdot()).orElse(null));
    }
}
