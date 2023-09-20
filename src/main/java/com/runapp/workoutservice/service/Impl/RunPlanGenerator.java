package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.runPlanService.*;
import com.runapp.workoutservice.utill.DistanceTypeEnum;
import com.runapp.workoutservice.utill.StageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class RunPlanGenerator {
    private VdotCradeServiceImpl vdotGradeServiceImpl;
    private VdotWorkoutRepository vdotWorkoutRepository;
    private VdotGradeModel indicatorsVdot;
    private LocalDate goal_date;
    private String target_time;
    private DistanceTypeEnum type_were_you_running;
    private String time_at_which_you_ran;
    private int kilometers_per_week;
    private DayOfWeek[] training_days;
    private VdotWorkoutModel vdotWorkoutModel;

    public RunPlanGenerator(VdotWorkoutRepository vdotWorkoutRepository, VdotCradeServiceImpl vdotGradeServiceImpl, DistanceTypeEnum type_were_you_running, String time_at_which_you_ran, LocalDate goal_date, String target_time, int kilometers_per_week, DayOfWeek[] training_days) {
        this.vdotWorkoutRepository = vdotWorkoutRepository;
        this.vdotGradeServiceImpl = vdotGradeServiceImpl;
        this.indicatorsVdot = vdotGradeServiceImpl.findClosestTimeByDistanceAndTime(type_were_you_running, time_at_which_you_ran);
        vdotWorkoutModel = vdotWorkoutRepository.findById(indicatorsVdot.getVdot()).orElse(null);
        this.goal_date = goal_date;
        this.target_time = target_time;
        this.kilometers_per_week = kilometers_per_week;
        this.training_days = training_days;
    }

    public List<RunTraining> generatePlan() {
        LocalDate[] localDates = getDatesBeforeEndDate(goal_date, training_days);
//        List<List<RunTraining>> runPlan = new ArrayList<>();
        return fillingWithTwoWorkouts(localDates, kilometers_per_week, StageEnum.STAGE2);
    }

//    private List<RunTraining> fillingTheStageWithTraining(LocalDate[] localDates, int kilometers_per_week, DayOfWeek[] training_days) {
//        switch () {
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//        }
//
//    }

    private List<RunTraining> fillingWithTwoWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        List<RunTraining> runTrainings = new ArrayList<>();
        switch (stageEnum) {
            case STAGE1:
                for (int x = 0; x < localDates.length; x++) {
                    if (x % 2 == 0) kilometers_per_week = increaseByPercentage(kilometers_per_week, 15.0);
                    int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 30) / 2;
                    int longRunKilometers = calculatePercentage(kilometers_per_week, 70);
                    runTrainings.add(new SpeedSurgeRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getRepetition_400m(), vdotWorkoutModel.getEasyKm()));
                    runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm()));
                }
                break;
            case STAGE2:
                for (int x = 0; x < localDates.length; x++) {
                    if (x % 2 == 0) kilometers_per_week = increaseByPercentage(kilometers_per_week, 15.0);
                    int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 30) / 2;
                    int longRunKilometers = calculatePercentage(kilometers_per_week, 70);
                    if (x % 2 == 0) runTrainings.add(new IntervalRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getInterval_1000m(), vdotWorkoutModel.getEasyKm()));
                    else runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm()));
                }
                break;
            case STAGE3:
                for (int x = 0; x < localDates.length; x++) {
                    if (x % 2 == 0) kilometers_per_week = increaseByPercentage(kilometers_per_week, 15.0);
                    int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 30);
                    int longRunKilometers = calculatePercentage(kilometers_per_week, 70);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi()));
                    runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm()));
                }
                break;
            case STAGE4:
                for (int x = 0; x < localDates.length; x++) {
                    if (x % 2 == 0) kilometers_per_week -= calculatePercentage(kilometers_per_week, 15);
                    int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 30);
                    int longRunKilometers = calculatePercentage(kilometers_per_week, 70);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi()));
                    runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm()));
                }
                break;
        }
        return runTrainings;
    }

    private List<RunTraining> fillingWithThreeWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        switch (stageEnum) {
            case STAGE1:
                break;
            case STAGE2:
                break;
            case STAGE3:
                break;
            case STAGE4:
                break;
        }
        return null;
    }

    private List<RunTraining> fillingWithFourWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        switch (stageEnum) {
            case STAGE1:
                break;
            case STAGE2:
                break;
            case STAGE3:
                break;
            case STAGE4:
                break;
        }
        return null;
    }

    private List<RunTraining> fillingWithFiveWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        switch (stageEnum) {
            case STAGE1:
                break;
            case STAGE2:
                break;
            case STAGE3:
                break;
            case STAGE4:
                break;
        }
        return null;
    }

    public static LocalDate[] getDatesBeforeEndDate(LocalDate endDate, DayOfWeek[] daysOfWeek) {
        List<LocalDate> validDates = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        while (!currentDate.isAfter(endDate)) {
            if (containsDayOfWeek(currentDate.getDayOfWeek(), daysOfWeek)) {
                LocalDate dateTime = LocalDate.from(currentDate.atStartOfDay());
                validDates.add(dateTime);
            }
            currentDate = currentDate.plusDays(1); // Переход к следующей дате
        }

        return validDates.toArray(new LocalDate[0]);
    }

    private static boolean containsDayOfWeek(DayOfWeek dayOfWeek, DayOfWeek[] daysOfWeek) {
        for (DayOfWeek day : daysOfWeek) {
            if (day == dayOfWeek) {
                return true;
            }
        }
        return false;
    }

    private static int increaseByPercentage(int number, double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("The percentage cannot be negative.");
        }

        double increaseFactor = 1 + (percentage / 100);
        double result = number * increaseFactor;

        return (int) Math.round(result);
    }

    public static int calculatePercentage(int number, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("The percentage must be in the range from 0 to 100.");
        }

        double result = (number * percentage) / 100;

        return (int) Math.round(result);
    }
}
