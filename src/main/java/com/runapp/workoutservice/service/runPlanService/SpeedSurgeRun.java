package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.IntervalRestTypeEnum;
import com.runapp.workoutservice.utill.StageEnum;
import com.runapp.workoutservice.utill.TrainingTypeEnum;

import java.time.LocalDate;

public class SpeedSurgeRun extends RunTraining {
    public SpeedSurgeRun(int warmUpKilometers, int hitchKilometers, String runIntervalPace, String restIntervalPace, LocalDate date, StageEnum stage) {
        super(warmUpKilometers, hitchKilometers, warmUpKilometers + hitchKilometers, null, TrainingTypeEnum.SPEED_SURGE, null, date, stage);

        Interval[] intervals = getIntervals(8, runIntervalPace, restIntervalPace);
        setIntervals(intervals);
    }

    public Interval[] getIntervals(int times, String runPace, String restPace) {
        Interval[] intervals = new Interval[times];
        for (int x = 0; x < times; x++) {
            intervals[x] = new Interval(0, runPace, IntervalRestTypeEnum.RECOVERY_RUN, 0, restPace, "00:01:00", "00:01:00");
        }
        return intervals;
    }
}
