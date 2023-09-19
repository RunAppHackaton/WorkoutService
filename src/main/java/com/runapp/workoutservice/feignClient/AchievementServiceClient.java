package com.runapp.workoutservice.feignClient;

import com.runapp.workoutservice.dto.response.AchievementResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "achievement-service")
public interface AchievementServiceClient {

    @GetMapping("/achievements/by-story/{storyId}")
    ResponseEntity<List<AchievementResponse>> getAchievementsByStoryId(@PathVariable int storyId);
}
