package com.runapp.workoutservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dto.dtoMapper.RunSessionDtoMapper;
import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.model.RunTypeModel;
import com.runapp.workoutservice.model.StageModel;
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.service.serviceTemplate.RunSessionService;
import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

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

@ContextConfiguration(classes = {RunSessionController.class})
@ExtendWith(SpringExtension.class)
class RunSessionControllerDiffblueTest {
    @Autowired
    private RunSessionController runSessionController;

    @MockBean
    private RunSessionDtoMapper runSessionDtoMapper;

    @MockBean
    private RunSessionService runSessionService;

    /**
     * Method under test:
     * {@link RunSessionController#addRunSession(RunSessionRequest)}
     */
    @Test
    void testAddRunSession() throws Exception {
        when(runSessionService.getAll()).thenReturn(new ArrayList<>());

        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setCaloriesBurned(1);
        runSessionRequest.setDistance_km(new BigDecimal("2.3"));
        runSessionRequest.setNotes("Notes");
        runSessionRequest.setRouteId(1);
        runSessionRequest.setRoute_points(new ArrayList<>());
        runSessionRequest.setShoesId(1);
        runSessionRequest.setTraining_id_from_run_plan(1);
        runSessionRequest.setUserId(1);
        runSessionRequest.setWeatherConditions("Weather Conditions");
        String content = (new ObjectMapper()).writeValueAsString(runSessionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link RunSessionController#addRunSession(RunSessionRequest)}
     */
    @Test
    void testAddRunSession2() throws Exception {
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan = new RunPlanModel();
        runPlan.setDayOfTheWeek(1);
        runPlan.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan.setId(1L);
        runPlan.setStartingWeeklyVolume(1);
        runPlan.setTrainingModels(new ArrayList<>());
        runPlan.setUserId(1);

        RunTypeModel runType = new RunTypeModel();
        runType.setDescription("The characteristics of someone or something");
        runType.setId(1L);
        runType.setRuntypeImageUrl("https://example.org/example");
        runType.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage = new StageModel();
        stage.setDescription("The characteristics of someone or something");
        stage.setId(1L);
        stage.setName("Name");
        stage.setStageEnum(StageEnum.STAGE1);

        TrainingModel training = new TrainingModel();
        training.setHitch(10.0d);
        training.setId(1L);
        training.setIntervalModelList(new ArrayList<>());
        training.setKilometers(10.0d);
        training.setRunPlan(runPlan);
        training.setRunType(runType);
        training.setStage(stage);
        training.setWarmUp(10.0d);

        RunSessionModel runSessionModel = new RunSessionModel();
        runSessionModel.setCaloriesBurned(1);
        runSessionModel.setDate(LocalDate.of(1970, 1, 1));
        runSessionModel.setDistance(1);
        runSessionModel.setId(1L);
        runSessionModel.setNotes("Notes");
        runSessionModel.setPhotosUrl("https://example.org/example");
        runSessionModel.setRoute(route);
        runSessionModel.setShoesId(1);
        runSessionModel.setTraining(training);
        runSessionModel.setUserId(1);
        runSessionModel.setWeatherConditions("Weather Conditions");

        ArrayList<RunSessionModel> runSessionModelList = new ArrayList<>();
        runSessionModelList.add(runSessionModel);
        when(runSessionService.getAll()).thenReturn(runSessionModelList);

        RouteModel route2 = new RouteModel();
        route2.setId(1L);
        route2.setRoutePoints(new ArrayList<>());
        RunSessionResponse.RunSessionResponseBuilder caloriesBurnedResult = RunSessionResponse.builder().caloriesBurned(1);
        RunSessionResponse.RunSessionResponseBuilder shoesIdResult = caloriesBurnedResult.date(LocalDate.of(1970, 1, 1))
                .distance(1)
                .duration_time(null)
                .id(1L)
                .notes("Notes")
                .pace(null)
                .photosUrl("https://example.org/example")
                .route(route2)
                .shoesId(1);

        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(1);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(1L);
        runPlan2.setStartingWeeklyVolume(1);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId(1);

        RunTypeModel runType2 = new RunTypeModel();
        runType2.setDescription("The characteristics of someone or something");
        runType2.setId(1L);
        runType2.setRuntypeImageUrl("https://example.org/example");
        runType2.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage2 = new StageModel();
        stage2.setDescription("The characteristics of someone or something");
        stage2.setId(1L);
        stage2.setName("Name");
        stage2.setStageEnum(StageEnum.STAGE1);

        TrainingModel training2 = new TrainingModel();
        training2.setHitch(10.0d);
        training2.setId(1L);
        training2.setIntervalModelList(new ArrayList<>());
        training2.setKilometers(10.0d);
        training2.setRunPlan(runPlan2);
        training2.setRunType(runType2);
        training2.setStage(stage2);
        training2.setWarmUp(10.0d);
        RunSessionResponse buildResult = shoesIdResult.training(training2)
                .userId(1)
                .weatherConditions("Weather Conditions")
                .build();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);

        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setCaloriesBurned(1);
        runSessionRequest.setDistance_km(new BigDecimal("2.3"));
        runSessionRequest.setNotes("Notes");
        runSessionRequest.setRouteId(1);
        runSessionRequest.setRoute_points(new ArrayList<>());
        runSessionRequest.setShoesId(1);
        runSessionRequest.setTraining_id_from_run_plan(1);
        runSessionRequest.setUserId(1);
        runSessionRequest.setWeatherConditions("Weather Conditions");
        String content = (new ObjectMapper()).writeValueAsString(runSessionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"pace\":null,\"caloriesBurned\":1,"
                                        + "\"weatherConditions\":\"Weather Conditions\",\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\","
                                        + "\"route\":{\"id\":1,\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,"
                                        + "\"stage\":{\"id\":1,\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or"
                                        + " something\"},\"runType\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or"
                                        + " something\",\"runtypeImageUrl\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId"
                                        + "\":1}]"));
    }

    /**
     * Method under test: {@link RunSessionController#deleteRunSession(Long)}
     */
    @Test
    void testDeleteRunSession() throws Exception {
        doNothing().when(runSessionService).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/run-sessions/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RunSessionController#deleteRunSession(Long)}
     */
    @Test
    void testDeleteRunSession2() throws Exception {
        doNothing().when(runSessionService).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/run-sessions/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RunSessionController#getAllRunSessions()}
     */
    @Test
    void testGetAllRunSessions() throws Exception {
        when(runSessionService.getAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions");
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RunSessionController#getAllRunSessions()}
     */
    @Test
    void testGetAllRunSessions2() throws Exception {
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan = new RunPlanModel();
        runPlan.setDayOfTheWeek(1);
        runPlan.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan.setId(1L);
        runPlan.setStartingWeeklyVolume(1);
        runPlan.setTrainingModels(new ArrayList<>());
        runPlan.setUserId(1);

        RunTypeModel runType = new RunTypeModel();
        runType.setDescription("The characteristics of someone or something");
        runType.setId(1L);
        runType.setRuntypeImageUrl("https://example.org/example");
        runType.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage = new StageModel();
        stage.setDescription("The characteristics of someone or something");
        stage.setId(1L);
        stage.setName("Name");
        stage.setStageEnum(StageEnum.STAGE1);

        TrainingModel training = new TrainingModel();
        training.setHitch(10.0d);
        training.setId(1L);
        training.setIntervalModelList(new ArrayList<>());
        training.setKilometers(10.0d);
        training.setRunPlan(runPlan);
        training.setRunType(runType);
        training.setStage(stage);
        training.setWarmUp(10.0d);

        RunSessionModel runSessionModel = new RunSessionModel();
        runSessionModel.setCaloriesBurned(1);
        runSessionModel.setDate(LocalDate.of(1970, 1, 1));
        runSessionModel.setDistance(1);
        runSessionModel.setId(1L);
        runSessionModel.setNotes("Notes");
        runSessionModel.setPhotosUrl("https://example.org/example");
        runSessionModel.setRoute(route);
        runSessionModel.setShoesId(1);
        runSessionModel.setTraining(training);
        runSessionModel.setUserId(1);
        runSessionModel.setWeatherConditions("Weather Conditions");

        ArrayList<RunSessionModel> runSessionModelList = new ArrayList<>();
        runSessionModelList.add(runSessionModel);
        when(runSessionService.getAll()).thenReturn(runSessionModelList);

        RouteModel route2 = new RouteModel();
        route2.setId(1L);
        route2.setRoutePoints(new ArrayList<>());
        RunSessionResponse.RunSessionResponseBuilder caloriesBurnedResult = RunSessionResponse.builder().caloriesBurned(1);
        RunSessionResponse.RunSessionResponseBuilder shoesIdResult = caloriesBurnedResult.date(LocalDate.of(1970, 1, 1))
                .distance(1)
                .duration_time(null)
                .id(1L)
                .notes("Notes")
                .pace(null)
                .photosUrl("https://example.org/example")
                .route(route2)
                .shoesId(1);

        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(1);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(1L);
        runPlan2.setStartingWeeklyVolume(1);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId(1);

        RunTypeModel runType2 = new RunTypeModel();
        runType2.setDescription("The characteristics of someone or something");
        runType2.setId(1L);
        runType2.setRuntypeImageUrl("https://example.org/example");
        runType2.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage2 = new StageModel();
        stage2.setDescription("The characteristics of someone or something");
        stage2.setId(1L);
        stage2.setName("Name");
        stage2.setStageEnum(StageEnum.STAGE1);

        TrainingModel training2 = new TrainingModel();
        training2.setHitch(10.0d);
        training2.setId(1L);
        training2.setIntervalModelList(new ArrayList<>());
        training2.setKilometers(10.0d);
        training2.setRunPlan(runPlan2);
        training2.setRunType(runType2);
        training2.setStage(stage2);
        training2.setWarmUp(10.0d);
        RunSessionResponse buildResult = shoesIdResult.training(training2)
                .userId(1)
                .weatherConditions("Weather Conditions")
                .build();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions");
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"pace\":null,\"caloriesBurned\":1,"
                                        + "\"weatherConditions\":\"Weather Conditions\",\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\","
                                        + "\"route\":{\"id\":1,\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,"
                                        + "\"stage\":{\"id\":1,\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or"
                                        + " something\"},\"runType\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or"
                                        + " something\",\"runtypeImageUrl\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId"
                                        + "\":1}]"));
    }

    /**
     * Method under test: {@link RunSessionController#getRunSessionById(Long)}
     */
    @Test
    void testGetRunSessionById() throws Exception {
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan = new RunPlanModel();
        runPlan.setDayOfTheWeek(1);
        runPlan.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan.setId(1L);
        runPlan.setStartingWeeklyVolume(1);
        runPlan.setTrainingModels(new ArrayList<>());
        runPlan.setUserId(1);

        RunTypeModel runType = new RunTypeModel();
        runType.setDescription("The characteristics of someone or something");
        runType.setId(1L);
        runType.setRuntypeImageUrl("https://example.org/example");
        runType.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage = new StageModel();
        stage.setDescription("The characteristics of someone or something");
        stage.setId(1L);
        stage.setName("Name");
        stage.setStageEnum(StageEnum.STAGE1);

        TrainingModel training = new TrainingModel();
        training.setHitch(10.0d);
        training.setId(1L);
        training.setIntervalModelList(new ArrayList<>());
        training.setKilometers(10.0d);
        training.setRunPlan(runPlan);
        training.setRunType(runType);
        training.setStage(stage);
        training.setWarmUp(10.0d);

        RunSessionModel runSessionModel = new RunSessionModel();
        runSessionModel.setCaloriesBurned(1);
        runSessionModel.setDate(LocalDate.of(1970, 1, 1));
        runSessionModel.setDistance(1);
        runSessionModel.setId(1L);
        runSessionModel.setNotes("Notes");
        runSessionModel.setPhotosUrl("https://example.org/example");
        runSessionModel.setRoute(route);
        runSessionModel.setShoesId(1);
        runSessionModel.setTraining(training);
        runSessionModel.setUserId(1);
        runSessionModel.setWeatherConditions("Weather Conditions");
        when(runSessionService.getById(Mockito.<Long>any())).thenReturn(runSessionModel);

        RouteModel route2 = new RouteModel();
        route2.setId(1L);
        route2.setRoutePoints(new ArrayList<>());
        RunSessionResponse.RunSessionResponseBuilder caloriesBurnedResult = RunSessionResponse.builder().caloriesBurned(1);
        RunSessionResponse.RunSessionResponseBuilder shoesIdResult = caloriesBurnedResult.date(LocalDate.of(1970, 1, 1))
                .distance(1)
                .duration_time(null)
                .id(1L)
                .notes("Notes")
                .pace(null)
                .photosUrl("https://example.org/example")
                .route(route2)
                .shoesId(1);

        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(1);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(1L);
        runPlan2.setStartingWeeklyVolume(1);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId(1);

        RunTypeModel runType2 = new RunTypeModel();
        runType2.setDescription("The characteristics of someone or something");
        runType2.setId(1L);
        runType2.setRuntypeImageUrl("https://example.org/example");
        runType2.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage2 = new StageModel();
        stage2.setDescription("The characteristics of someone or something");
        stage2.setId(1L);
        stage2.setName("Name");
        stage2.setStageEnum(StageEnum.STAGE1);

        TrainingModel training2 = new TrainingModel();
        training2.setHitch(10.0d);
        training2.setId(1L);
        training2.setIntervalModelList(new ArrayList<>());
        training2.setKilometers(10.0d);
        training2.setRunPlan(runPlan2);
        training2.setRunType(runType2);
        training2.setStage(stage2);
        training2.setWarmUp(10.0d);
        RunSessionResponse buildResult = shoesIdResult.training(training2)
                .userId(1)
                .weatherConditions("Weather Conditions")
                .build();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions/{id}", 1L);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"pace\":null,\"caloriesBurned\":1,\"weatherConditions"
                                        + "\":\"Weather Conditions\",\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\",\"route\":{\"id\":1,"
                                        + "\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,\"stage\":{\"id\":1,"
                                        + "\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or something\"},\"runType"
                                        + "\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or something\",\"runtypeImageUrl"
                                        + "\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId\":1}"));
    }

    /**
     * Method under test:
     * {@link RunSessionController#updateRunSession(Long, RunSessionRequest)}
     */
    @Test
    void testUpdateRunSession() throws Exception {
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan = new RunPlanModel();
        runPlan.setDayOfTheWeek(1);
        runPlan.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan.setId(1L);
        runPlan.setStartingWeeklyVolume(1);
        runPlan.setTrainingModels(new ArrayList<>());
        runPlan.setUserId(1);

        RunTypeModel runType = new RunTypeModel();
        runType.setDescription("The characteristics of someone or something");
        runType.setId(1L);
        runType.setRuntypeImageUrl("https://example.org/example");
        runType.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage = new StageModel();
        stage.setDescription("The characteristics of someone or something");
        stage.setId(1L);
        stage.setName("Name");
        stage.setStageEnum(StageEnum.STAGE1);

        TrainingModel training = new TrainingModel();
        training.setHitch(10.0d);
        training.setId(1L);
        training.setIntervalModelList(new ArrayList<>());
        training.setKilometers(10.0d);
        training.setRunPlan(runPlan);
        training.setRunType(runType);
        training.setStage(stage);
        training.setWarmUp(10.0d);

        RunSessionModel runSessionModel = new RunSessionModel();
        runSessionModel.setCaloriesBurned(1);
        runSessionModel.setDate(LocalDate.of(1970, 1, 1));
        runSessionModel.setDistance(1);
        runSessionModel.setId(1L);
        runSessionModel.setNotes("Notes");
        runSessionModel.setPhotosUrl("https://example.org/example");
        runSessionModel.setRoute(route);
        runSessionModel.setShoesId(1);
        runSessionModel.setTraining(training);
        runSessionModel.setUserId(1);
        runSessionModel.setWeatherConditions("Weather Conditions");

        RouteModel route2 = new RouteModel();
        route2.setId(1L);
        route2.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(1);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(1L);
        runPlan2.setStartingWeeklyVolume(1);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId(1);

        RunTypeModel runType2 = new RunTypeModel();
        runType2.setDescription("The characteristics of someone or something");
        runType2.setId(1L);
        runType2.setRuntypeImageUrl("https://example.org/example");
        runType2.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage2 = new StageModel();
        stage2.setDescription("The characteristics of someone or something");
        stage2.setId(1L);
        stage2.setName("Name");
        stage2.setStageEnum(StageEnum.STAGE1);

        TrainingModel training2 = new TrainingModel();
        training2.setHitch(10.0d);
        training2.setId(1L);
        training2.setIntervalModelList(new ArrayList<>());
        training2.setKilometers(10.0d);
        training2.setRunPlan(runPlan2);
        training2.setRunType(runType2);
        training2.setStage(stage2);
        training2.setWarmUp(10.0d);

        RunSessionModel runSessionModel2 = new RunSessionModel();
        runSessionModel2.setCaloriesBurned(1);
        runSessionModel2.setDate(LocalDate.of(1970, 1, 1));
        runSessionModel2.setDistance(1);
        runSessionModel2.setId(1L);
        runSessionModel2.setNotes("Notes");
        runSessionModel2.setPhotosUrl("https://example.org/example");
        runSessionModel2.setRoute(route2);
        runSessionModel2.setShoesId(1);
        runSessionModel2.setTraining(training2);
        runSessionModel2.setUserId(1);
        runSessionModel2.setWeatherConditions("Weather Conditions");
        when(runSessionService.update(Mockito.<RunSessionModel>any())).thenReturn(runSessionModel2);
        when(runSessionService.getById(Mockito.<Long>any())).thenReturn(runSessionModel);

        RouteModel route3 = new RouteModel();
        route3.setId(1L);
        route3.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan3 = new RunPlanModel();
        runPlan3.setDayOfTheWeek(1);
        runPlan3.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan3.setId(1L);
        runPlan3.setStartingWeeklyVolume(1);
        runPlan3.setTrainingModels(new ArrayList<>());
        runPlan3.setUserId(1);

        RunTypeModel runType3 = new RunTypeModel();
        runType3.setDescription("The characteristics of someone or something");
        runType3.setId(1L);
        runType3.setRuntypeImageUrl("https://example.org/example");
        runType3.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage3 = new StageModel();
        stage3.setDescription("The characteristics of someone or something");
        stage3.setId(1L);
        stage3.setName("Name");
        stage3.setStageEnum(StageEnum.STAGE1);

        TrainingModel training3 = new TrainingModel();
        training3.setHitch(10.0d);
        training3.setId(1L);
        training3.setIntervalModelList(new ArrayList<>());
        training3.setKilometers(10.0d);
        training3.setRunPlan(runPlan3);
        training3.setRunType(runType3);
        training3.setStage(stage3);
        training3.setWarmUp(10.0d);

        RunSessionModel runSessionModel3 = new RunSessionModel();
        runSessionModel3.setCaloriesBurned(1);
        runSessionModel3.setDate(LocalDate.of(1970, 1, 1));
        runSessionModel3.setDistance(1);
        runSessionModel3.setId(1L);
        runSessionModel3.setNotes("Notes");
        runSessionModel3.setPhotosUrl("https://example.org/example");
        runSessionModel3.setRoute(route3);
        runSessionModel3.setShoesId(1);
        runSessionModel3.setTraining(training3);
        runSessionModel3.setUserId(1);
        runSessionModel3.setWeatherConditions("Weather Conditions");

        RouteModel route4 = new RouteModel();
        route4.setId(1L);
        route4.setRoutePoints(new ArrayList<>());
        RunSessionResponse.RunSessionResponseBuilder caloriesBurnedResult = RunSessionResponse.builder().caloriesBurned(1);
        RunSessionResponse.RunSessionResponseBuilder shoesIdResult = caloriesBurnedResult.date(LocalDate.of(1970, 1, 1))
                .distance(1)
                .duration_time(null)
                .id(1L)
                .notes("Notes")
                .pace(null)
                .photosUrl("https://example.org/example")
                .route(route4)
                .shoesId(1);

        RunPlanModel runPlan4 = new RunPlanModel();
        runPlan4.setDayOfTheWeek(1);
        runPlan4.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan4.setId(1L);
        runPlan4.setStartingWeeklyVolume(1);
        runPlan4.setTrainingModels(new ArrayList<>());
        runPlan4.setUserId(1);

        RunTypeModel runType4 = new RunTypeModel();
        runType4.setDescription("The characteristics of someone or something");
        runType4.setId(1L);
        runType4.setRuntypeImageUrl("https://example.org/example");
        runType4.setTypeName(TrainingTypeEnum.EASY_RUN);

        StageModel stage4 = new StageModel();
        stage4.setDescription("The characteristics of someone or something");
        stage4.setId(1L);
        stage4.setName("Name");
        stage4.setStageEnum(StageEnum.STAGE1);

        TrainingModel training4 = new TrainingModel();
        training4.setHitch(10.0d);
        training4.setId(1L);
        training4.setIntervalModelList(new ArrayList<>());
        training4.setKilometers(10.0d);
        training4.setRunPlan(runPlan4);
        training4.setRunType(runType4);
        training4.setStage(stage4);
        training4.setWarmUp(10.0d);
        RunSessionResponse buildResult = shoesIdResult.training(training4)
                .userId(1)
                .weatherConditions("Weather Conditions")
                .build();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);
        when(runSessionDtoMapper.toModel(Mockito.<RunSessionRequest>any())).thenReturn(runSessionModel3);

        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setCaloriesBurned(1);
        runSessionRequest.setDistance_km(new BigDecimal("2.3"));
        runSessionRequest.setNotes("Notes");
        runSessionRequest.setRouteId(1);
        runSessionRequest.setRoute_points(new ArrayList<>());
        runSessionRequest.setShoesId(1);
        runSessionRequest.setTraining_id_from_run_plan(1);
        runSessionRequest.setUserId(1);
        runSessionRequest.setWeatherConditions("Weather Conditions");
        String content = (new ObjectMapper()).writeValueAsString(runSessionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/run-sessions/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"pace\":null,\"caloriesBurned\":1,\"weatherConditions"
                                        + "\":\"Weather Conditions\",\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\",\"route\":{\"id\":1,"
                                        + "\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,\"stage\":{\"id\":1,"
                                        + "\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or something\"},\"runType"
                                        + "\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or something\",\"runtypeImageUrl"
                                        + "\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId\":1}"));
    }
}
