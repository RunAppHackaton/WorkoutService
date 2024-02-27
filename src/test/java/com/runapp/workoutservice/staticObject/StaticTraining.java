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
        return training;
    }
}
