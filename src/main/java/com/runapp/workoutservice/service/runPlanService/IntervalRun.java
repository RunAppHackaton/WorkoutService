package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.IntervalRestTypeEnum;
import com.runapp.workoutservice.utill.TrainingTypeEnum;

public class IntervalRun extends RunTraining {
    public IntervalRun(int warmUpKilometers, int hitchKilometers, String runIntervalPace, String restIntervalPace) {
        super(warmUpKilometers,
                hitchKilometers,
                warmUpKilometers + hitchKilometers,
                null,
                TrainingTypeEnum.INTERVAL_RUN,
                null);

        Interval[] intervals = getIntervals(4, runIntervalPace, restIntervalPace, 800, 400);
        setIntervals(intervals);
    }

    public Interval[] getIntervals(int times, String runPace, String restPace, int run_metres, int rest_metres) {
        Interval[] intervals = new Interval[times];
        for (int x = 0; x < times; x++) {
            intervals[x] = new Interval(run_metres, runPace, IntervalRestTypeEnum.RECOVERY_RUN, rest_metres, restPace);
        }
        return intervals;
    }
}
