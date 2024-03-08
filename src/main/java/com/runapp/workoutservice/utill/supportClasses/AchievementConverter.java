package com.runapp.workoutservice.utill.supportClasses;

import com.runapp.workoutservice.dto.request.TrainingAchievementRequest;
import com.runapp.workoutservice.model.RunSessionModel;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AchievementConverter {

    public TrainingAchievementRequest convertToAchievementRequest(RunSessionModel runSessionModel) {
        TrainingAchievementRequest achievementRequest = new TrainingAchievementRequest();
        achievementRequest.setTraining_date(runSessionModel.getDate());
        achievementRequest.setDistance_km(runSessionModel.getDistance());
        achievementRequest.setTraining_duration(runSessionModel.getTime());
        achievementRequest.setPace(runSessionModel.getPace());
        achievementRequest.setUserId(runSessionModel.getUserId());
        return achievementRequest;
    }
}
