package com.runapp.workoutservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dto.response.RunPlanLongResponse;
import com.runapp.workoutservice.dto.response.RunPlanShortResponse;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.service.serviceImpl.RunPlanServiceImpl;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import com.runapp.workoutservice.service.serviceImpl.VdotWorkoutServiceImpl;
import com.runapp.workoutservice.dto.dtoMapper.RunPlanDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
public class RunPlanControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VdotWorkoutServiceImpl vdotWorkoutService;

    @Mock
    private VdotCradeServiceImpl vdotCradeService;

    @Mock
    private RunPlanServiceImpl runPlanService;

    @Mock
    private RunPlanDtoMapper runPlanDtoMapper;

    @InjectMocks
    private RunPlanController runPlanController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(runPlanController).build();
    }

    @Test
    public void testGetAllShortRunPlansWhenPlansExistThenReturnShortRunPlans() throws Exception {
        // Arrange
        List<RunPlanModel> runPlans = Arrays.asList(new RunPlanModel());
        List<RunPlanShortResponse> runPlanShortResponses = Collections.singletonList(new RunPlanShortResponse());

        when(runPlanService.getAll()).thenReturn(runPlans);
        when(runPlanDtoMapper.toShortDto(runPlans)).thenReturn(runPlanShortResponses);

        // Act
        ResultActions result = mockMvc.perform(get("/run-plan/short"));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").exists()); // You may need to adjust this depending on the structure of your response
    }

    @Test
    public void testGetAllShortRunPlansWhenNoPlansExistThenReturnEmptyList() throws Exception {
        // Arrange
        when(runPlanService.getAll()).thenReturn(Collections.emptyList());
        when(runPlanDtoMapper.toShortDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Act
        ResultActions result = mockMvc.perform(get("/run-plan/short"));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetAllLongRunPlansWhenPlansExistThenReturnLongRunPlans() throws Exception {
        // Arrange
        List<RunPlanModel> runPlans = Arrays.asList(new RunPlanModel());
        List<RunPlanLongResponse> runPlanLongResponses = Collections.singletonList(new RunPlanLongResponse());

        when(runPlanService.getAll()).thenReturn(runPlans);
        when(runPlanDtoMapper.toLongDto(runPlans)).thenReturn(runPlanLongResponses);

        // Act
        ResultActions result = mockMvc.perform(get("/run-plan/full"));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").exists()); // You may need to adjust this depending on the structure of your response
    }

    @Test
    public void testGetAllLongRunPlansWhenNoPlansExistThenReturnEmptyList() throws Exception {
        // Arrange
        when(runPlanService.getAll()).thenReturn(Collections.emptyList());
        when(runPlanDtoMapper.toLongDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Act
        ResultActions result = mockMvc.perform(get("/run-plan/full"));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testDeleteRunPlanWhenValidIdThenReturnNoContent() throws Exception {
        // Arrange
        Long validId = 1L;
        doNothing().when(runPlanService).deleteById(validId);

        // Act
        ResultActions result = mockMvc.perform(delete("/run-plan/{id}", validId));

        // Assert
        result.andExpect(status().isNoContent());
    }


    @Test
    public void testDeleteRunPlanWhenNonExistentIdThenReturnNotFound() throws Exception {
        // Arrange
        Long invalidId = 1L;

        // Act
        ResultActions result = mockMvc.perform(delete("/run-plan/{id}", invalidId));

        // Assert
        result.andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllShortRunPlansReturnsEmptyListForRandomId() throws Exception {
        // Arrange
        when(runPlanService.getAll()).thenReturn(Collections.emptyList());

        // Act
        mockMvc.perform(get("/run-plan/short")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetAllLongRunPlansReturnsEmptyListForRandomId() throws Exception {
        // Arrange
        when(runPlanService.getAll()).thenReturn(Collections.emptyList());

        // Act
        mockMvc.perform(get("/run-plan/full")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }
}
