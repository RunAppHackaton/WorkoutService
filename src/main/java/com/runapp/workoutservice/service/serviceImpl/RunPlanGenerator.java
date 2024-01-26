package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.dto.request.RunPlanRequest;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.service.runPlanService.*;
import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import com.runapp.workoutservice.utill.enums.StageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class RunPlanGenerator {
    private VdotCradeServiceImpl vdotGradeServiceImpl;
    private VdotWorkoutServiceImpl vdotWorkoutServiceImpl;
    private VdotGradeModel indicatorsVdot;
    private LocalDate goal_date;
    private String target_time;
    private DistanceTypeEnum type_were_you_running;
    private String time_at_which_you_ran;
    private int kilometers_per_week;
    private DayOfWeek[] training_days;
    private VdotWorkoutModel vdotWorkoutModel;
    private final static Logger LOGGER = LoggerFactory.getLogger(RunPlanGenerator.class);

    public RunPlanGenerator(VdotWorkoutServiceImpl vdotWorkoutServiceImpl, VdotCradeServiceImpl vdotGradeServiceImpl, RunPlanRequest runPlanRequest) {
        this.vdotWorkoutServiceImpl = vdotWorkoutServiceImpl;
        this.vdotGradeServiceImpl = vdotGradeServiceImpl;
        this.indicatorsVdot = vdotGradeServiceImpl.findClosestTimeByDistanceAndTime(runPlanRequest.getType_were_you_running(), runPlanRequest.getTime_at_which_you_ran());
        vdotWorkoutModel = vdotWorkoutServiceImpl.getById(indicatorsVdot.getVdot());
    }

    public List<RunTraining> generatePlan(RunPlanRequest runPlanRequest) {
        LOGGER.info("RunTraining Generate plan for request: {}", runPlanRequest);
        LocalDate[] localDates = getDatesBeforeEndDate(runPlanRequest.getGoal_date(), runPlanRequest.getTraining_days());
        return fillingTheStageWithTraining(localDates, runPlanRequest.getKilometers_per_week(), runPlanRequest.getTraining_days());
    }

    private List<RunTraining> fillingTheStageWithTraining(LocalDate[] localDates, int kilometers_per_week, DayOfWeek[] training_days) {
        LOGGER.info("RunTraining Fill the stage with training: localDates={}, kilometers_per_week={}, training_days[]={}", Arrays.toString(localDates), kilometers_per_week, Arrays.toString(training_days));
        int trainingPerWeek = training_days.length;
        List<RunTraining> runTrainings = new ArrayList<>();

        int chunkSize = localDates.length / 4;
        LocalDate[][] dateChunks = new LocalDate[4][];

        for (int i = 0; i < 4; i++) {
            int start = i * chunkSize;
            int end = (i == 3) ? localDates.length : (i + 1) * chunkSize;
            dateChunks[i] = Arrays.copyOfRange(localDates, start, end);
        }
        switch (trainingPerWeek) {
            case 2:
                runTrainings.addAll(fillingWithTwoWorkouts(dateChunks[0], kilometers_per_week, StageEnum.STAGE1));
                runTrainings.addAll(fillingWithTwoWorkouts(dateChunks[1], kilometers_per_week, StageEnum.STAGE2));
                runTrainings.addAll(fillingWithTwoWorkouts(dateChunks[2], kilometers_per_week, StageEnum.STAGE3));
                runTrainings.addAll(fillingWithTwoWorkouts(dateChunks[3], kilometers_per_week, StageEnum.STAGE4));
                break;
            case 3:
                runTrainings.addAll(fillingWithThreeWorkouts(dateChunks[0], kilometers_per_week, StageEnum.STAGE1));
                runTrainings.addAll(fillingWithThreeWorkouts(dateChunks[1], kilometers_per_week, StageEnum.STAGE2));
                runTrainings.addAll(fillingWithThreeWorkouts(dateChunks[2], kilometers_per_week, StageEnum.STAGE3));
                runTrainings.addAll(fillingWithThreeWorkouts(dateChunks[3], kilometers_per_week, StageEnum.STAGE4));
                break;
            case 4:
                runTrainings.addAll(fillingWithFourWorkouts(dateChunks[0], kilometers_per_week, StageEnum.STAGE1));
                runTrainings.addAll(fillingWithFourWorkouts(dateChunks[1], kilometers_per_week, StageEnum.STAGE2));
                runTrainings.addAll(fillingWithFourWorkouts(dateChunks[2], kilometers_per_week, StageEnum.STAGE3));
                runTrainings.addAll(fillingWithFourWorkouts(dateChunks[3], kilometers_per_week, StageEnum.STAGE4));
                break;
            case 5:
                runTrainings.addAll(fillingWithFiveWorkouts(dateChunks[0], kilometers_per_week, StageEnum.STAGE1));
                runTrainings.addAll(fillingWithFiveWorkouts(dateChunks[1], kilometers_per_week, StageEnum.STAGE2));
                runTrainings.addAll(fillingWithFiveWorkouts(dateChunks[2], kilometers_per_week, StageEnum.STAGE3));
                runTrainings.addAll(fillingWithFiveWorkouts(dateChunks[3], kilometers_per_week, StageEnum.STAGE4));
                break;
        }

        return runTrainings;
    }


    private List<RunTraining> fillingWithTwoWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        List<RunTraining> runTrainings = new ArrayList<>();
        LOGGER.info("RunTraining Fill training with 2 workouts: localDates={}, kilometers_per_week={}, stageEnum={}", Arrays.toString(localDates), kilometers_per_week, stageEnum);
        for (int x = 0; x < localDates.length; x += 2) {
            int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 20);
            int longRunKilometers = calculatePercentage(kilometers_per_week, 40);

            switch (stageEnum) {
                case STAGE1 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new SpeedSurgeRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getRepetition_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE2 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new IntervalRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getInterval_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE3 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
                case STAGE4 -> {
                    kilometers_per_week -= calculatePercentage(kilometers_per_week, 15);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
            }
            if (localDates.length - x != 1)
                runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 1], stageEnum));
        }
        return runTrainings;
    }

    private List<RunTraining> fillingWithThreeWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        List<RunTraining> runTrainings = new ArrayList<>();
        LOGGER.info("RunTraining Fill training with 3 workouts: localDates={}, kilometers_per_week={}, stageEnum={}", Arrays.toString(localDates), kilometers_per_week, stageEnum);
        for (int x = 0; x < localDates.length; x += 3) {

            int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 20);
            int longRunKilometers = calculatePercentage(kilometers_per_week, 50);
            int easyRunKilometers = calculatePercentage(kilometers_per_week, 30);

            if (localDates.length - x == 1) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                return runTrainings;
            }

            if (localDates.length - x == 2) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 1], stageEnum));
                return runTrainings;
            }

            switch (stageEnum) {
                case STAGE1 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new SpeedSurgeRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getRepetition_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE2 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new IntervalRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getInterval_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE3 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
                case STAGE4 -> {
                    kilometers_per_week -= calculatePercentage(kilometers_per_week, 15);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
            }
            runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 1], stageEnum));
            runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 2], stageEnum));
        }
        return runTrainings;
    }

    private List<RunTraining> fillingWithFourWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        List<RunTraining> runTrainings = new ArrayList<>();
        int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 20);
        int longRunKilometers = calculatePercentage(kilometers_per_week, 50);
        int easyRunKilometers = calculatePercentage(kilometers_per_week, 30);
        LOGGER.info("RunTraining Fill training with 4 workouts: localDates={}, kilometers_per_week={}, stageEnum={}", Arrays.toString(localDates), kilometers_per_week, stageEnum);
        for (int x = 0; x < localDates.length; x += 4) {

            if (localDates.length - x == 1) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                return runTrainings;
            }

            if (localDates.length - x == 2) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 1], stageEnum));
                return runTrainings;
            }

            if (localDates.length - x == 3) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 1], stageEnum));
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 2], stageEnum));
                return runTrainings;
            }


            switch (stageEnum) {
                case STAGE1 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new SpeedSurgeRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getRepetition_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE2 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new IntervalRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getInterval_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE3 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
                case STAGE4 -> {
                    kilometers_per_week -= calculatePercentage(kilometers_per_week, 15);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
            }
            runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 1], stageEnum));
            runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 2], stageEnum));
            runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 3], stageEnum));
        }
        return runTrainings;
    }

    private List<RunTraining> fillingWithFiveWorkouts(LocalDate[] localDates, int kilometers_per_week, StageEnum stageEnum) {
        List<RunTraining> runTrainings = new ArrayList<>();
        LOGGER.info("RunTraining Fill with 5 workouts: localDates={}, kilometers_per_week={}, stageEnum={}", Arrays.toString(localDates), kilometers_per_week, stageEnum);
        for (int x = 0; x < localDates.length; x += 5) {
        int warmUpAndHitchKilometers = calculatePercentage(kilometers_per_week, 20);
        int longRunKilometers = calculatePercentage(kilometers_per_week, 50);
        int easyRunKilometers = calculatePercentage(kilometers_per_week, 30);

            if (localDates.length - x == 1) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                return runTrainings;
            }

            if (localDates.length - x == 2) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 1], stageEnum));
                return runTrainings;
            }

            if (localDates.length - x == 3) {
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 1], stageEnum));
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 2], stageEnum));
                return runTrainings;
            }

            if (localDates.length - x == 4) {
                runTrainings.add(new SpeedSurgeRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getRepetition_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 1], stageEnum));
                runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 2], stageEnum));
                return runTrainings;
            }

            switch (stageEnum) {
                case STAGE1 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new SpeedSurgeRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getRepetition_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE2 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new IntervalRun(warmUpAndHitchKilometers, warmUpAndHitchKilometers, vdotWorkoutModel.getInterval_400m(), vdotWorkoutModel.getEasyKm(), localDates[x], stageEnum));
                }
                case STAGE3 -> {
                    kilometers_per_week += increaseByPercentage(kilometers_per_week, 15.0);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
                case STAGE4 -> {
                    kilometers_per_week -= calculatePercentage(kilometers_per_week, 15);
                    runTrainings.add(new TempoRun(warmUpAndHitchKilometers, vdotWorkoutModel.getThreshold_mi(), localDates[x], stageEnum));
                }
            }
            runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 1], stageEnum));
            runTrainings.add(new LongRun(longRunKilometers, vdotWorkoutModel.getMarathonKm(), localDates[x + 2], stageEnum));
            runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 3], stageEnum));
            runTrainings.add(new EasyRun(easyRunKilometers, vdotWorkoutModel.getEasyKm(), localDates[x + 4], stageEnum));
        }
        return runTrainings;
    }


    public static LocalDate[] getDatesBeforeEndDate(LocalDate endDate, DayOfWeek[] daysOfWeek) {
        List<LocalDate> validDates = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        while (!currentDate.isAfter(endDate)) {
            if (containsDayOfWeek(currentDate.getDayOfWeek(), daysOfWeek)) {
                LocalDate dateTime = LocalDate.from(currentDate.atStartOfDay());
                validDates.add(dateTime);
            }
            currentDate = currentDate.plusDays(1);
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
