package com.runapp.workoutservice.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dto.request.VdotGradeRequest;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {VdotGradeController.class})
@ExtendWith(SpringExtension.class)
class VdotGradeControllerDiffblueTest {
    @MockBean
    private VdotCradeServiceImpl vdotCradeServiceImpl;

    @Autowired
    private VdotGradeController vdotGradeController;

    @MockBean
    private VdotWorkoutRepository vdotWorkoutRepository;

    /**
     * Method under test:
     * {@link VdotGradeController#getPersonalityVDOT(VdotGradeRequest)}
     */
    @Test
    void testGetPersonalityVDOT() throws Exception {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest();
        vdotGradeRequest.setDistance(DistanceTypeEnum.EASY_1500M);
        vdotGradeRequest.setTime("Time");
        String content = (new ObjectMapper()).writeValueAsString(vdotGradeRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vdot/my-personal-indicators")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(vdotGradeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test:
     * {@link VdotGradeController#getPersonalityVDOT(VdotGradeRequest)}
     */
    @Test
    void testGetPersonalityVDOT2() throws Exception {
        VdotGradeModel vdotGradeModel = new VdotGradeModel();
        vdotGradeModel.setEasy10000m("Easy10000m");
        vdotGradeModel.setEasy15000m("Easy15000m");
        vdotGradeModel.setEasy1500m("Easy1500m");
        vdotGradeModel.setEasy2Mile("Easy2 Mile");
        vdotGradeModel.setEasy3000m("Easy3000m");
        vdotGradeModel.setEasy5000m("Easy5000m");
        vdotGradeModel.setEasyMile("Easy Mile");
        vdotGradeModel.setHalfMarathon("Half Marathon");
        vdotGradeModel.setMarathon("Marathon");
        vdotGradeModel.setVdot(1L);
        when(vdotCradeServiceImpl.findClosestTimeByDistanceAndTime(Mockito.<DistanceTypeEnum>any(), Mockito.<String>any()))
                .thenReturn(vdotGradeModel);

        VdotWorkoutModel vdotWorkoutModel = new VdotWorkoutModel();
        vdotWorkoutModel.setEasyKm("Easy Km");
        vdotWorkoutModel.setEasyMi("Easy Mi");
        vdotWorkoutModel.setInterval_1000m("Interval 1000m");
        vdotWorkoutModel.setInterval_1200m("Interval 1200m");
        vdotWorkoutModel.setInterval_400m("Interval 400m");
        vdotWorkoutModel.setInterval_mi("Interval mi");
        vdotWorkoutModel.setMarathonKm("Marathon Km");
        vdotWorkoutModel.setMarathonMi("Marathon Mi");
        vdotWorkoutModel.setRepetition_200m("Bella");
        vdotWorkoutModel.setRepetition_400m("Bella");
        vdotWorkoutModel.setRepetition_800m("Bella");
        vdotWorkoutModel.setThreshold_1000m("Threshold 1000m");
        vdotWorkoutModel.setThreshold_400m("Threshold 400m");
        vdotWorkoutModel.setThreshold_mi("Threshold mi");
        vdotWorkoutModel.setVdot(1L);
        Optional<VdotWorkoutModel> ofResult = Optional.of(vdotWorkoutModel);
        when(vdotWorkoutRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest();
        vdotGradeRequest.setDistance(DistanceTypeEnum.EASY_1500M);
        vdotGradeRequest.setTime("99:09:09");
        String content = (new ObjectMapper()).writeValueAsString(vdotGradeRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vdot/my-personal-indicators")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(vdotGradeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"vdot\":1,\"easyMi\":\"Easy Mi\",\"easyKm\":\"Easy Km\",\"marathonMi\":\"Marathon Mi\",\"marathonKm\":\"Marathon"
                                        + " Km\",\"threshold_400m\":\"Threshold 400m\",\"threshold_1000m\":\"Threshold 1000m\",\"threshold_mi\":\"Threshold"
                                        + " mi\",\"interval_400m\":\"Interval 400m\",\"interval_1000m\":\"Interval 1000m\",\"interval_1200m\":\"Interval"
                                        + " 1200m\",\"interval_mi\":\"Interval mi\",\"repetition_200m\":\"Bella\",\"repetition_400m\":\"Bella\",\"repetition"
                                        + "_800m\":\"Bella\"}"));
    }
}
