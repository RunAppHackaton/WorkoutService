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
class RunPlanControllerDiffblueTest {
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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.runapp.workoutservice.dto.request.RunPlanRequest["goal_date"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setGoal_date(LocalDate.of(1970, 1, 1));
        runPlanRequest.setKilometers_per_week(1);
        runPlanRequest.setNumber_of_workouts_per_week(10);
        runPlanRequest.setRunPlanEnum(RunPlanEnum.PLAN_5000M);
        runPlanRequest.setTarget_time("Target time");
        runPlanRequest.setTime_at_which_you_ran("Time at which you ran");
        runPlanRequest.setTraining_days(new DayOfWeek[]{DayOfWeek.MONDAY});
        runPlanRequest.setType_were_you_running(DistanceTypeEnum.EASY_1500M);
        runPlanRequest.setUser_id(1);
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
        RunPlanModel runPlanModel = new RunPlanModel();
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);
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
