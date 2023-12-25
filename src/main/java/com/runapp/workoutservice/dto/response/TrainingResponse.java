package com.runapp.workoutservice.dto.response;

import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TrainingResponse {
    private long id;
    private double kilometers;
    private double warmUp;
    private double hitch;
    private StageEnum stage;
    private long run_type_id;
    private TrainingTypeEnum typeName;
    private List<IntervalResponse> intervals;
}
