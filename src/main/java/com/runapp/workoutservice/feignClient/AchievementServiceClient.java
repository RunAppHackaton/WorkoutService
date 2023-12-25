package com.runapp.workoutservice.feignClient;

import com.runapp.workoutservice.dto.request.TrainingAchievementRequest;
import com.runapp.workoutservice.dto.response.AchievementResponse;
import com.runapp.workoutservice.dto.response.TrainingAchievementResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "achievement-service")
public interface AchievementServiceClient {

    @GetMapping("/achievements/by-story/{storyId}")
    ResponseEntity<List<AchievementResponse>> getAchievementsByStoryId(@PathVariable int storyId);

    @PostMapping("/trainings")
    ResponseEntity<TrainingAchievementResponse> saveTraining(@RequestBody TrainingAchievementRequest trainingRequest);
}
