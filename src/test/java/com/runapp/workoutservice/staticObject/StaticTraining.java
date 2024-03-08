package com.runapp.workoutservice.staticObject;

import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.model.RunTypeModel;
import com.runapp.workoutservice.model.StageModel;
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;

public class StaticTraining {
    public static TrainingModel trainingModel1(){
        RunPlanModel runPlan = new RunPlanModel();
        runPlan.setDayOfTheWeek(1);
        runPlan.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan.setId(1L);
        runPlan.setStartingWeeklyVolume(1);
        runPlan.setTrainingModels(new ArrayList<>());
        runPlan.setUserId("1");

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
        return training;
    }

    public static TrainingModel trainingModel2(){
        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(0);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(2L);
        runPlan2.setStartingWeeklyVolume(0);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId("2");

        RunTypeModel runType2 = new RunTypeModel();
        runType2.setDescription("Description");
        runType2.setId(2L);
        runType2.setRuntypeImageUrl("Runtype Image Url");
        runType2.setTypeName(TrainingTypeEnum.SPEED_SURGE);

        StageModel stage2 = new StageModel();
        stage2.setDescription("Description");
        stage2.setId(2L);
        stage2.setName("com.runapp.workoutservice.model.StageModel");
        stage2.setStageEnum(StageEnum.STAGE2);

        TrainingModel trainingModel2 = new TrainingModel();
        trainingModel2.setHitch(0.5d);
        trainingModel2.setId(2L);
        trainingModel2.setIntervalModelList(new ArrayList<>());
        trainingModel2.setKilometers(0.5d);
        trainingModel2.setRunPlan(runPlan2);
        trainingModel2.setRunType(runType2);
        trainingModel2.setStage(stage2);
        trainingModel2.setWarmUp(0.5d);
        return trainingModel2;
    }
}
