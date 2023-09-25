package com.runapp.workoutservice.feignClient;

import com.runapp.workoutservice.dto.response.AchievementResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "achievement-service")
public interface AchievementServiceClient {

    @GetMapping("/achievements/by-story/{storyId}")
    ResponseEntity<List<AchievementResponse>> getAchievementsByStoryId(@PathVariable int storyId);

    @GetMapping("/achievements/random/{storyId}")
    ResponseEntity<AchievementResponse> getRandomAchievement(@PathVariable int storyId);
}
