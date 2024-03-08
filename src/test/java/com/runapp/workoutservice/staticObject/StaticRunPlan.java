package com.runapp.workoutservice.staticObject;

import com.runapp.workoutservice.dto.request.RunPlanRequest;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import com.runapp.workoutservice.utill.enums.RunPlanEnum;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class StaticRunPlan {
    public static RunPlanModel runPlanModel(){
        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(1);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(1L);
        runPlan2.setStartingWeeklyVolume(1);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId("1");
        return runPlan2;
    }

    public static RunPlanRequest runPlanRequest(){
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setGoal_date(LocalDate.of(1970, 1, 1));
        runPlanRequest.setKilometers_per_week(1);
        runPlanRequest.setNumber_of_workouts_per_week(10);
        runPlanRequest.setRunPlanEnum(RunPlanEnum.PLAN_5000M);
        runPlanRequest.setTarget_time("Target time");
        runPlanRequest.setTime_at_which_you_ran("Time at which you ran");
        runPlanRequest.setTraining_days(new DayOfWeek[]{DayOfWeek.MONDAY});
        runPlanRequest.setType_were_you_running(DistanceTypeEnum.EASY_1500M);
        runPlanRequest.setUser_id("1");
        return runPlanRequest;
    }

    public static RunPlanModel runPlanModel2(){
        RunPlanModel runPlanModel2 = new RunPlanModel();
        runPlanModel2.setDayOfTheWeek(0);
        runPlanModel2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel2.setId(2L);
        runPlanModel2.setStartingWeeklyVolume(0);
        runPlanModel2.setTrainingModels(new ArrayList<>());
        runPlanModel2.setUserId("2");
        return runPlanModel2;
    }
}
