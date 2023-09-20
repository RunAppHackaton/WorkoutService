package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.IntervalRestTypeEnum;
import com.runapp.workoutservice.utill.TrainingTypeEnum;

public class SpeedSurgeRun extends RunTraining {
    public SpeedSurgeRun(int warmUpKilometers, int hitchKilometers, String runIntervalPace, String restIntervalPace) {
        super(warmUpKilometers,
                hitchKilometers,
                warmUpKilometers + hitchKilometers,
                null,
                TrainingTypeEnum.SPEED_SURGE,
                null);

        Interval[] intervals = getIntervals(8, runIntervalPace, restIntervalPace);
        setIntervals(intervals);
    }

    public Interval[] getIntervals(int times, String runPace, String restPace) {
        Interval[] intervals = new Interval[times];
        for (int x = 0; x < times; x++) {
            intervals[x] = new Interval(0, runPace, IntervalRestTypeEnum.RECOVERY_RUN, 0, restPace);
        }
        return intervals;
    }
}
