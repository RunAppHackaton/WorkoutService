package com.runapp.workoutservice.feignClient;

import com.runapp.workoutservice.dto.response.TeamResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "guild-service")
public interface GuildServiceClient {

    @GetMapping("/users")
    ResponseEntity<List<TeamResponse>> getAllTeams();

    @GetMapping("/users/{id}")
    ResponseEntity<TeamResponse> getTeamById(@PathVariable int id);
}
