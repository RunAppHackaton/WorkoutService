package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.dtoMapper.RunSessionDtoMapper;
import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.service.serviceTemplate.RunSessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@WebMvcTest(RunSessionController.class)
public class RunSessionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RunSessionService runSessionService;

    @MockBean
    private RunSessionDtoMapper runSessionDtoMapper;

    private RunSessionModel runSessionModel;
    private RunSessionResponse runSessionResponse;

    @BeforeEach
    public void setUp() {
        runSessionModel = new RunSessionModel();
        runSessionModel.setId(1L);
        runSessionModel.setDate(LocalDate.now());
        runSessionModel.setDistance(10);
        runSessionModel.setTime(Duration.ofHours(1));
        runSessionModel.setPace(Duration.ofHours(2));
        runSessionModel.setCaloriesBurned(600);
        runSessionModel.setWeatherConditions("Sunny");
        runSessionModel.setNotes("Good run");
        runSessionModel.setUserId("1");
        runSessionModel.setShoesId(1);

        runSessionResponse = RunSessionResponse.builder()
                .id(1L)
                .date(LocalDate.now())
                .distance(10)
                .duration_time(Duration.ofHours(1))
                .pace(Duration.ofHours(2))
                .caloriesBurned(600)
                .weatherConditions("Sunny")
                .notes("Good run")
                .userId("1")
                .shoesId(1)
                .build();
    }

    // ... existing test methods ...

    @Test
    public void testDeleteRunSessionWhenRunSessionExistsThenReturnsNoContent() throws Exception {
        Mockito.doNothing().when(runSessionService).deleteById(runSessionModel.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/run-sessions/" + runSessionModel.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        Mockito.verify(runSessionService, Mockito.times(1)).deleteById(runSessionModel.getId());
    }

    @Test
    public void testDeleteRunSessionWhenRunSessionDoesNotExistThenReturnsNotFound() throws Exception {
        Mockito.doThrow(new NoEntityFoundException("Run session not found")).when(runSessionService).deleteById(runSessionModel.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/run-sessions/" + runSessionModel.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        Mockito.verify(runSessionService, Mockito.times(1)).deleteById(runSessionModel.getId());
    }

    @Test
    public void testUpdateRunSessionWhenValidDataThenSuccess() throws Exception {
        // Create a mock RunSessionModel with a valid ID
        RunSessionModel runSessionModel = new RunSessionModel();
        runSessionModel.setId(123L); // Set a valid ID

        // Mock the behavior of the service and mapper
        Mockito.when(runSessionDtoMapper.toModel(Mockito.any(RunSessionRequest.class))).thenReturn(runSessionModel);
        Mockito.when(runSessionService.getById(123L)).thenReturn(runSessionModel); // Make sure to pass the valid ID here
        Mockito.when(runSessionService.update(runSessionModel)).thenReturn(runSessionModel);
        Mockito.when(runSessionDtoMapper.toResponse(runSessionModel)).thenReturn(runSessionResponse);

        // Perform the request and assertions
        mockMvc.perform(MockMvcRequestBuilders.put("/run-sessions/" + runSessionModel.getId()).header("X-UserId", "123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"distance_km\": 10.5,\n" +
                                "  \"duration_time\": \"PT1H30M\",\n" +
                                "  \"caloriesBurned\": 500,\n" +
                                "  \"notes\": \"Ran in the park.\",\n" +
                                "  \"routeId\": 123,\n" +
                                "  \"shoesId\": 456,\n" +
                                "  \"userId\": \"123456789\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(runSessionResponse.getId()));

        // Verify that the methods were called with the expected arguments
        Mockito.verify(runSessionDtoMapper, Mockito.times(1)).toModel(Mockito.any(RunSessionRequest.class));
        Mockito.verify(runSessionService, Mockito.times(1)).getById(123L);
        Mockito.verify(runSessionService, Mockito.times(1)).update(runSessionModel);
        Mockito.verify(runSessionDtoMapper, Mockito.times(1)).toResponse(runSessionModel);
    }

    @Test
    public void testGetAllRunSessionsWhenRunSessionsExistThenReturnRunSessions() throws Exception {
        Mockito.when(runSessionService.getAll()).thenReturn(Arrays.asList(runSessionModel));
        Mockito.when(runSessionDtoMapper.toResponse(runSessionModel)).thenReturn(runSessionResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/run-sessions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(runSessionResponse.getId()));

        Mockito.verify(runSessionService, Mockito.times(1)).getAll();
        Mockito.verify(runSessionDtoMapper, Mockito.times(1)).toResponse(runSessionModel);
    }

    @Test
    public void testGetAllRunSessionsWhenNoRunSessionsExistThenReturnEmptyList() throws Exception {
        Mockito.when(runSessionService.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/run-sessions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

        Mockito.verify(runSessionService, Mockito.times(1)).getAll();
        Mockito.verify(runSessionDtoMapper, Mockito.never()).toResponse(Mockito.any(RunSessionModel.class));
    }

    @Test
    public void testGetRunSessionByIdWhenRunSessionExistsThenReturnRunSession() throws Exception {
        Mockito.when(runSessionService.getById(runSessionModel.getId())).thenReturn(runSessionModel);
        Mockito.when(runSessionDtoMapper.toResponse(runSessionModel)).thenReturn(runSessionResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/run-sessions/" + runSessionModel.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(runSessionResponse.getId()));

        Mockito.verify(runSessionService, Mockito.times(1)).getById(runSessionModel.getId());
        Mockito.verify(runSessionDtoMapper, Mockito.times(1)).toResponse(runSessionModel);
    }

    @Test
    public void testGetRunSessionByIdWhenRunSessionDoesNotExistThenReturnEmptyList() throws Exception {
        Mockito.when(runSessionService.getById(runSessionModel.getId())).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/run-sessions/" + runSessionModel.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(runSessionService, Mockito.times(1)).getById(runSessionModel.getId());
        Mockito.verify(runSessionDtoMapper, Mockito.never()).toResponse(Mockito.any(RunSessionModel.class));
    }
}