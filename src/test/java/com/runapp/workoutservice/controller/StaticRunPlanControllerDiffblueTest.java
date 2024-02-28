package com.runapp.workoutservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dto.dtoMapper.RunPlanDtoMapper;
import com.runapp.workoutservice.dto.request.RunPlanRequest;
import com.runapp.workoutservice.dto.response.RunPlanLongResponse;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.service.serviceImpl.RunPlanServiceImpl;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import com.runapp.workoutservice.service.serviceImpl.VdotWorkoutServiceImpl;
import com.runapp.workoutservice.staticObject.StaticRunPlan;
import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import com.runapp.workoutservice.utill.enums.RunPlanEnum;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
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

@ContextConfiguration(classes = {RunPlanController.class})
@ExtendWith(SpringExtension.class)
class StaticRunPlanControllerDiffblueTest {
    @Autowired
    private RunPlanController runPlanController;

    @MockBean
    private RunPlanDtoMapper runPlanDtoMapper;

    @MockBean
    private RunPlanServiceImpl runPlanServiceImpl;

    @MockBean
    private VdotCradeServiceImpl vdotCradeServiceImpl;

    @MockBean
    private VdotWorkoutServiceImpl vdotWorkoutServiceImpl;

    /**
     * Method under test: {@link RunPlanController#createPlan(RunPlanRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePlan() throws Exception {
        RunPlanRequest runPlanRequest = StaticRunPlan.runPlanRequest();
        String content = (new ObjectMapper()).writeValueAsString(runPlanRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-plan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(runPlanController).build().perform(requestBuilder);
    }

    /**
     * Method under test: {@link RunPlanController#deleteRunPlan(Long)}
     */
    @Test
    void testDeleteRunPlan() throws Exception {
        doNothing().when(runPlanServiceImpl).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/run-plan/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(runPlanController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RunPlanController#deleteRunPlan(Long)}
     */
    @Test
    void testDeleteRunPlan2() throws Exception {
        doNothing().when(runPlanServiceImpl).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/run-plan/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(runPlanController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RunPlanController#getAllLongRunPlans()}
     */
    @Test
    void testGetAllLongRunPlans() throws Exception {
        when(runPlanServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(runPlanDtoMapper.toLongDto(Mockito.<List<RunPlanModel>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-plan/full");
        MockMvcBuilders.standaloneSetup(runPlanController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RunPlanController#getAllShortRunPlans()}
     */
    @Test
    void testGetAllShortRunPlans() throws Exception {
        when(runPlanServiceImpl.getAll()).thenReturn(new ArrayList<>());
        when(runPlanDtoMapper.toShortDto(Mockito.<List<RunPlanModel>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-plan/short");
        MockMvcBuilders.standaloneSetup(runPlanController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RunPlanController#getRunPlanById(Long)}
     */
    @Test
    void testGetRunPlanById() throws Exception {
        RunPlanModel runPlanModel = StaticRunPlan.runPlanModel();
        when(runPlanServiceImpl.getById(Mockito.<Long>any())).thenReturn(runPlanModel);
        when(runPlanDtoMapper.toLongDto(Mockito.<RunPlanModel>any())).thenReturn(new RunPlanLongResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-plan/{id}", 1L);
        MockMvcBuilders.standaloneSetup(runPlanController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":0,\"dayOfTheWeek\":0,\"startingWeeklyVolume\":0,\"finalDate\":null,\"userId\":0,\"trainings\":null}"));
    }
}
