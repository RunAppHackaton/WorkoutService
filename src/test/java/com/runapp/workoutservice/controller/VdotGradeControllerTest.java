package com.runapp.workoutservice.controller;

import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import com.runapp.workoutservice.staticObject.StaticVdot;
import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VdotGradeController.class)
public class VdotGradeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VdotCradeServiceImpl vdotGradeService;

    @MockBean
    private VdotWorkoutRepository vdotWorkoutRepository;

    @Test
    public void testGetPersonalityVDOTWhenValidRequestThenReturnVdotWorkout() throws Exception {
        VdotGradeModel vdotGradeModel = StaticVdot.vdotGradeModel();
        VdotWorkoutModel vdotWorkoutModel = StaticVdot.vdotWorkoutModel();

        when(vdotGradeService.findClosestTimeByDistanceAndTime(DistanceTypeEnum.EASY_1500M, "00:10:00")).thenReturn(vdotGradeModel);
        when(vdotWorkoutRepository.findById(1L)).thenReturn(Optional.of(vdotWorkoutModel));

        mockMvc.perform(MockMvcRequestBuilders.post("/vdot/my-personal-indicators")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"distance\":\"EASY_1500M\",\"time\":\"00:10:00\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.vdot").value(1L));
    }

    @Test
    public void testGetPersonalityVDOTWhenInvalidRequestThenReturnBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/vdot/my-personal-indicators")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"distance\":\"INVALID_DISTANCE\",\"time\":\"00:10:00\"}"))
                .andExpect(status().isBadRequest());
    }
}