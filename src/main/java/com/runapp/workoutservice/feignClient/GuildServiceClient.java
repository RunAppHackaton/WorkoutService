package com.runapp.workoutservice.feignClient;

import com.runapp.workoutservice.dto.response.TeamResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "guild-service")
public interface GuildServiceClient {

    @GetMapping("/users")
    ResponseEntity<List<TeamResponse>> getAllTeams();
}
