package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dto.request.RunPlanRuquest;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.Impl.RunPlanGenerator;
import com.runapp.workoutservice.service.Impl.VdotCradeServiceImpl;
import com.runapp.workoutservice.service.runPlanService.RunTraining;
import com.runapp.workoutservice.utill.DistanceTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/run")
public class RunPlanController {

    private RunPlanGenerator runPlanGenerator;
    private final VdotCradeServiceImpl vdotCradeService;
    private final VdotWorkoutRepository vdotWorkoutRepository;

    @Autowired
    public RunPlanController(RunPlanGenerator runPlanGenerator, VdotCradeServiceImpl vdotCradeService, VdotWorkoutRepository vdotWorkoutRepository) {
        this.runPlanGenerator = runPlanGenerator;
        this.vdotCradeService = vdotCradeService;
        this.vdotWorkoutRepository = vdotWorkoutRepository;
    }

    @PostMapping
    public ResponseEntity<Object> createPlan(@RequestBody RunPlanRuquest runPlanRuquest) {
//        VdotGradeModel indicatorsVdot = vdotCradeService.findClosestTimeByDistanceAndTime(runPlanRuquest.getType_were_you_running(), runPlanRuquest.getTime_at_which_you_ran());
        DistanceTypeEnum typeWereYouRunning = runPlanRuquest.getType_were_you_running();
        String timeAtWhichYouRan = runPlanRuquest.getTime_at_which_you_ran();
        LocalDate goalDate = runPlanRuquest.getGoal_date();
        String targetTime = runPlanRuquest.getTarget_time();
        int kilometersPerWeek = runPlanRuquest.getKilometers_per_week();
        DayOfWeek[] trainingDays = runPlanRuquest.getTraining_days();

        // Создаем объект RunPlanGenerator с переданными данными
        runPlanGenerator = new RunPlanGenerator(
                vdotWorkoutRepository,
                vdotCradeService,
                typeWereYouRunning,
                timeAtWhichYouRan,
                goalDate,
                targetTime,
                kilometersPerWeek,
                trainingDays
        );
        List<RunTraining> runTrainings = runPlanGenerator.generatePlan();
        System.out.println("ded");
        return ResponseEntity.ok().body(runTrainings);
    }
}
