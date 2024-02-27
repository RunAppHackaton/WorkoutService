package com.runapp.workoutservice.staticObject;

import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.model.*;
import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class StaticRunSession {

    public static RunSessionRequest runSessionRequest1(){
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setCaloriesBurned(1);
        runSessionRequest.setDistance_km(new BigDecimal("2.3"));
        runSessionRequest.setNotes("Notes");
        runSessionRequest.setRouteId(1);
        runSessionRequest.setRoute_points(new ArrayList<>());
        runSessionRequest.setShoesId(1);
        runSessionRequest.setTraining_id_from_run_plan(1);
        runSessionRequest.setUserId(1);
        runSessionRequest.setWeatherConditions("Weather Conditions");
        return runSessionRequest;
    }

    public static RunSessionModel runSession(){
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan = new RunPlanModel();
        runPlan.setDayOfTheWeek(1);
        runPlan.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan.setId(1L);
        runPlan.setStartingWeeklyVolume(1);
        runPlan.setTrainingModels(new ArrayList<>());
        runPlan.setUserId(1);

        RunTypeModel runType = new RunTypeModel();
        runType.setDescription("The characteristics of someone or something");
        runType.setId(1L);
        runType.setRuntypeImageUrl("https://example.org/example");
        runType.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage = new StageModel();
        stage.setDescription("The characteristics of someone or something");
        stage.setId(1L);
        stage.setName("Name");
        stage.setStageEnum(StageEnum.STAGE1);

        TrainingModel training = new TrainingModel();
        training.setHitch(10.0d);
        training.setId(1L);
        training.setIntervalModelList(new ArrayList<>());
        training.setKilometers(10.0d);
        training.setRunPlan(runPlan);
        training.setRunType(runType);
        training.setStage(stage);
        training.setWarmUp(10.0d);

        RunSessionModel runSessionModel = new RunSessionModel();
        runSessionModel.setCaloriesBurned(1);
        runSessionModel.setDate(LocalDate.of(1970, 1, 1));
        runSessionModel.setDistance(1);
        runSessionModel.setId(1L);
        runSessionModel.setNotes("Notes");
        runSessionModel.setPhotosUrl("https://example.org/example");
        runSessionModel.setRoute(route);
        runSessionModel.setShoesId(1);
        runSessionModel.setTraining(training);
        runSessionModel.setUserId(1);
        runSessionModel.setWeatherConditions("Weather Conditions");
        return runSessionModel;
    }
}
