package com.runapp.workoutservice.utill.existHandler;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.AchievementServiceClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AchievementExistHandler implements ExistHandler {
    private final AchievementServiceClient achievementServiceClient;

    @Override
    public boolean handleRequest(int entityId) {
        try {
            achievementServiceClient.getAchievementsByStoryId(entityId);
        } catch (FeignException.NotFound e) {
            throw new NoEntityFoundException("Achievement in story with id: " + entityId + " doesn't exist");
        }
        return true;
    }
}
