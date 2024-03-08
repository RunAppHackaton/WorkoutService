package com.runapp.workoutservice.dtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.workoutservice.dto.request.RoutePointRequest;
import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.feignClient.AchievementServiceClient;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.RoutePointModel;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.model.RunTypeModel;
import com.runapp.workoutservice.model.StageModel;
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.staticObject.StaticRunPlan;
import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RunSessionDtoMapper.class})
@ExtendWith(SpringExtension.class)
class RunSessionDtoMapperDiffblueTest {
    @MockBean
    private AchievementServiceClient achievementServiceClient;

    @Autowired
    private RunSessionDtoMapper runSessionDtoMapper;

    /**
     * Method under test: {@link RunSessionDtoMapper#toResponse(RunSessionModel)}
     */
    @Test
    void testToResponse() {
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan = StaticRunPlan.runPlanModel();

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

        RunSessionModel model = new RunSessionModel();
        model.setCaloriesBurned(1);
        model.setDate(LocalDate.of(1970, 1, 1));
        model.setDistance(1);
        model.setId(1L);
        model.setNotes("Notes");
        model.setPhotosUrl("https://example.org/example");
        model.setRoute(route);
        model.setShoesId(1);
        model.setTraining(training);
        model.setUserId("1");
        model.setWeatherConditions("Weather Conditions");
        RunSessionResponse actualToResponseResult = runSessionDtoMapper.toResponse(model);
        assertEquals("1970-01-01", actualToResponseResult.getDate().toString());
        assertEquals("Notes", actualToResponseResult.getNotes());
        assertEquals("Weather Conditions", actualToResponseResult.getWeatherConditions());
        assertEquals("https://example.org/example", actualToResponseResult.getPhotosUrl());
        assertNull(actualToResponseResult.getDuration_time());
        assertNull(actualToResponseResult.getPace());
        assertEquals(1, actualToResponseResult.getCaloriesBurned());
        assertEquals(1, actualToResponseResult.getDistance());
        assertEquals(1, actualToResponseResult.getShoesId());
        assertEquals("1", actualToResponseResult.getUserId());
        assertEquals(1L, actualToResponseResult.getId());
        assertSame(route, actualToResponseResult.getRoute());
        assertSame(training, actualToResponseResult.getTraining());
    }

    /**
     * Method under test: {@link RunSessionDtoMapper#toResponse(RunSessionModel)}
     */
    @Test
    void testToResponse2() {
        RouteModel route = new RouteModel();
        route.setId(1L);
        route.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan = new RunPlanModel();
        runPlan.setDayOfTheWeek(1);
        runPlan.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan.setId(1L);
        runPlan.setStartingWeeklyVolume(1);
        runPlan.setTrainingModels(new ArrayList<>());
        runPlan.setUserId("1");

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

        RouteModel routeModel = new RouteModel();
        routeModel.setId(1L);
        routeModel.setRoutePoints(new ArrayList<>());

        RunPlanModel runPlan2 = StaticRunPlan.runPlanModel();

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

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setHitch(10.0d);
        trainingModel.setId(1L);
        trainingModel.setIntervalModelList(new ArrayList<>());
        trainingModel.setKilometers(10.0d);
        trainingModel.setRunPlan(runPlan2);
        trainingModel.setRunType(runType2);
        trainingModel.setStage(stage2);
        trainingModel.setWarmUp(10.0d);
        RunSessionModel model = mock(RunSessionModel.class);
        when(model.getRoute()).thenReturn(routeModel);
        when(model.getTraining()).thenReturn(trainingModel);
        when(model.getCaloriesBurned()).thenReturn(1);
        when(model.getDistance()).thenReturn(1);
        when(model.getShoesId()).thenReturn(1);
        when(model.getUserId()).thenReturn("1");
        when(model.getNotes()).thenReturn("Notes");
        when(model.getPhotosUrl()).thenReturn("https://example.org/example");
        when(model.getWeatherConditions()).thenReturn("Weather Conditions");
        when(model.getPace()).thenReturn(null);
        when(model.getTime()).thenReturn(null);
        when(model.getDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(model.getId()).thenReturn(1L);
        doNothing().when(model).setCaloriesBurned(anyInt());
        doNothing().when(model).setDate(Mockito.<LocalDate>any());
        doNothing().when(model).setDistance(anyInt());
        doNothing().when(model).setId(anyLong());
        doNothing().when(model).setNotes(Mockito.<String>any());
        doNothing().when(model).setPhotosUrl(Mockito.<String>any());
        doNothing().when(model).setRoute(Mockito.<RouteModel>any());
        doNothing().when(model).setShoesId(anyInt());
        doNothing().when(model).setTraining(Mockito.<TrainingModel>any());
        doNothing().when(model).setUserId(anyString());
        doNothing().when(model).setWeatherConditions(Mockito.<String>any());
        model.setCaloriesBurned(1);
        model.setDate(LocalDate.of(1970, 1, 1));
        model.setDistance(1);
        model.setId(1L);
        model.setNotes("Notes");
        model.setPhotosUrl("https://example.org/example");
        model.setRoute(route);
        model.setShoesId(1);
        model.setTraining(training);
        model.setUserId("1");
        model.setWeatherConditions("Weather Conditions");
        RunSessionResponse actualToResponseResult = runSessionDtoMapper.toResponse(model);
        verify(model).getCaloriesBurned();
        verify(model).getDate();
        verify(model).getDistance();
        verify(model).getId();
        verify(model).getNotes();
        verify(model).getPace();
        verify(model).getPhotosUrl();
        verify(model).getRoute();
        verify(model).getShoesId();
        verify(model).getTime();
        verify(model).getTraining();
        verify(model).getUserId();
        verify(model).getWeatherConditions();
        verify(model).setCaloriesBurned(anyInt());
        verify(model).setDate(Mockito.<LocalDate>any());
        verify(model).setDistance(anyInt());
        verify(model).setId(anyLong());
        verify(model).setNotes(Mockito.<String>any());
        verify(model).setPhotosUrl(Mockito.<String>any());
        verify(model).setRoute(Mockito.<RouteModel>any());
        verify(model).setShoesId(anyInt());
        verify(model).setTraining(Mockito.<TrainingModel>any());
        verify(model).setUserId(anyString());
        verify(model).setWeatherConditions(Mockito.<String>any());
        assertEquals("1970-01-01", actualToResponseResult.getDate().toString());
        assertEquals("Notes", actualToResponseResult.getNotes());
        assertEquals("Weather Conditions", actualToResponseResult.getWeatherConditions());
        assertEquals("https://example.org/example", actualToResponseResult.getPhotosUrl());
        assertNull(actualToResponseResult.getDuration_time());
        assertNull(actualToResponseResult.getPace());
        assertEquals(1, actualToResponseResult.getCaloriesBurned());
        assertEquals(1, actualToResponseResult.getDistance());
        assertEquals(1, actualToResponseResult.getShoesId());
        assertEquals("1", actualToResponseResult.getUserId());
        assertEquals(1L, actualToResponseResult.getId());
        assertSame(routeModel, actualToResponseResult.getRoute());
        assertSame(trainingModel, actualToResponseResult.getTraining());
    }

    /**
     * Method under test: {@link RunSessionDtoMapper#toModel(RunSessionRequest)}
     */
    @Test
    void testToModel() {
        RunSessionRequest request = mock(RunSessionRequest.class);
        when(request.getCaloriesBurned()).thenReturn(1);
        when(request.getShoesId()).thenReturn(1);
        when(request.getTraining_id_from_run_plan()).thenReturn(1);
        when(request.getUserId()).thenReturn("1");
        when(request.getNotes()).thenReturn("Notes");
        when(request.getWeatherConditions()).thenReturn("Weather Conditions");
        when(request.getDuration_time()).thenReturn(null);
        when(request.getPace()).thenReturn(null);
        ArrayList<RoutePointRequest> routePointRequestList = new ArrayList<>();
        when(request.getRoute_points()).thenReturn(routePointRequestList);
        when(request.getDistance_km()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(request).setDistance_km(Mockito.<BigDecimal>any());
        request.setDistance_km(null);
        RunSessionModel actualToModelResult = runSessionDtoMapper.toModel(request);
        verify(request).getCaloriesBurned();
        verify(request).getDistance_km();
        verify(request).getDuration_time();
        verify(request).getNotes();
        verify(request).getPace();
        verify(request).getRoute_points();
        verify(request, atLeast(1)).getShoesId();
        verify(request, atLeast(1)).getTraining_id_from_run_plan();
        verify(request).getUserId();
        verify(request).getWeatherConditions();
        verify(request).setDistance_km(Mockito.<BigDecimal>any());
        assertEquals("DEFAULT", actualToModelResult.getPhotosUrl());
        assertEquals("Notes", actualToModelResult.getNotes());
        assertEquals("Weather Conditions", actualToModelResult.getWeatherConditions());
        assertNull(actualToModelResult.getPace());
        assertNull(actualToModelResult.getTime());
        assertEquals(1, actualToModelResult.getCaloriesBurned());
        assertEquals(1, actualToModelResult.getShoesId());
        assertEquals("1", actualToModelResult.getUserId());
        assertEquals(1L, actualToModelResult.getTraining().getId());
        assertEquals(2, actualToModelResult.getDistance());
        assertEquals(routePointRequestList, actualToModelResult.getRoute().getRoutePoints());
    }

    /**
     * Method under test: {@link RunSessionDtoMapper#toModel(RunSessionRequest)}
     */
    @Test
    void testToModel2() {
        RunSessionRequest request = mock(RunSessionRequest.class);
        when(request.getCaloriesBurned()).thenReturn(1);
        when(request.getShoesId()).thenReturn(0);
        when(request.getTraining_id_from_run_plan()).thenReturn(1);
        when(request.getUserId()).thenReturn("1");
        when(request.getNotes()).thenReturn("Notes");
        when(request.getWeatherConditions()).thenReturn("Weather Conditions");
        when(request.getDuration_time()).thenReturn(null);
        when(request.getPace()).thenReturn(null);
        ArrayList<RoutePointRequest> routePointRequestList = new ArrayList<>();
        when(request.getRoute_points()).thenReturn(routePointRequestList);
        when(request.getDistance_km()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(request).setDistance_km(Mockito.<BigDecimal>any());
        request.setDistance_km(null);
        RunSessionModel actualToModelResult = runSessionDtoMapper.toModel(request);
        verify(request).getCaloriesBurned();
        verify(request).getDistance_km();
        verify(request).getDuration_time();
        verify(request).getNotes();
        verify(request).getPace();
        verify(request).getRoute_points();
        verify(request).getShoesId();
        verify(request, atLeast(1)).getTraining_id_from_run_plan();
        verify(request).getUserId();
        verify(request).getWeatherConditions();
        verify(request).setDistance_km(Mockito.<BigDecimal>any());
        assertEquals("DEFAULT", actualToModelResult.getPhotosUrl());
        assertEquals("Notes", actualToModelResult.getNotes());
        assertEquals("Weather Conditions", actualToModelResult.getWeatherConditions());
        assertNull(actualToModelResult.getPace());
        assertNull(actualToModelResult.getTime());
        assertEquals(1, actualToModelResult.getCaloriesBurned());
        assertEquals("1", actualToModelResult.getUserId());
        assertEquals(1L, actualToModelResult.getTraining().getId());
        assertEquals(2, actualToModelResult.getDistance());
        assertEquals(routePointRequestList, actualToModelResult.getRoute().getRoutePoints());
    }

    /**
     * Method under test: {@link RunSessionDtoMapper#toModel(RunSessionRequest)}
     */
    @Test
    void testToModel3() {
        RunSessionRequest request = mock(RunSessionRequest.class);
        when(request.getCaloriesBurned()).thenReturn(1);
        when(request.getShoesId()).thenReturn(1);
        when(request.getTraining_id_from_run_plan()).thenReturn(0);
        when(request.getUserId()).thenReturn("1");
        when(request.getNotes()).thenReturn("Notes");
        when(request.getWeatherConditions()).thenReturn("Weather Conditions");
        when(request.getDuration_time()).thenReturn(null);
        when(request.getPace()).thenReturn(null);
        ArrayList<RoutePointRequest> routePointRequestList = new ArrayList<>();
        when(request.getRoute_points()).thenReturn(routePointRequestList);
        when(request.getDistance_km()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(request).setDistance_km(Mockito.<BigDecimal>any());
        request.setDistance_km(null);
        RunSessionModel actualToModelResult = runSessionDtoMapper.toModel(request);
        verify(request).getCaloriesBurned();
        verify(request).getDistance_km();
        verify(request).getDuration_time();
        verify(request).getNotes();
        verify(request).getPace();
        verify(request).getRoute_points();
        verify(request, atLeast(1)).getShoesId();
        verify(request).getTraining_id_from_run_plan();
        verify(request).getUserId();
        verify(request).getWeatherConditions();
        verify(request).setDistance_km(Mockito.<BigDecimal>any());
        assertEquals("DEFAULT", actualToModelResult.getPhotosUrl());
        assertEquals("Notes", actualToModelResult.getNotes());
        assertEquals("Weather Conditions", actualToModelResult.getWeatherConditions());
        assertNull(actualToModelResult.getPace());
        assertNull(actualToModelResult.getTime());
        assertEquals(1, actualToModelResult.getCaloriesBurned());
        assertEquals(1, actualToModelResult.getShoesId());
        assertEquals("1", actualToModelResult.getUserId());
        assertEquals(2, actualToModelResult.getDistance());
        assertEquals(routePointRequestList, actualToModelResult.getRoute().getRoutePoints());
    }

    /**
     * Method under test: {@link RunSessionDtoMapper#toModel(RunSessionRequest)}
     */
    @Test
    void testToModel4() {
        ArrayList<RoutePointRequest> routePointRequestList = new ArrayList<>();
        routePointRequestList.add(new RoutePointRequest(1L,10.0d, 10.0d));
        RunSessionRequest request = mock(RunSessionRequest.class);
        when(request.getCaloriesBurned()).thenReturn(1);
        when(request.getShoesId()).thenReturn(1);
        when(request.getTraining_id_from_run_plan()).thenReturn(1);
        when(request.getUserId()).thenReturn("1");
        when(request.getNotes()).thenReturn("Notes");
        when(request.getWeatherConditions()).thenReturn("Weather Conditions");
        when(request.getDuration_time()).thenReturn(null);
        when(request.getPace()).thenReturn(null);
        when(request.getRoute_points()).thenReturn(routePointRequestList);
        when(request.getDistance_km()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(request).setDistance_km(Mockito.<BigDecimal>any());
        request.setDistance_km(null);
        RunSessionModel actualToModelResult = runSessionDtoMapper.toModel(request);
        verify(request).getCaloriesBurned();
        verify(request).getDistance_km();
        verify(request).getDuration_time();
        verify(request).getNotes();
        verify(request).getPace();
        verify(request).getRoute_points();
        verify(request, atLeast(1)).getShoesId();
        verify(request, atLeast(1)).getTraining_id_from_run_plan();
        verify(request).getUserId();
        verify(request).getWeatherConditions();
        verify(request).setDistance_km(Mockito.<BigDecimal>any());
        assertEquals("DEFAULT", actualToModelResult.getPhotosUrl());
        assertEquals("Notes", actualToModelResult.getNotes());
        assertEquals("Weather Conditions", actualToModelResult.getWeatherConditions());
        assertNull(actualToModelResult.getPace());
        assertNull(actualToModelResult.getTime());
        assertEquals(1, actualToModelResult.getCaloriesBurned());
        assertEquals(1, actualToModelResult.getShoesId());
        assertEquals("1", actualToModelResult.getUserId());
        RouteModel route = actualToModelResult.getRoute();
        List<RoutePointModel> routePoints = route.getRoutePoints();
        assertEquals(1, routePoints.size());
        RoutePointModel getResult = routePoints.get(0);
        assertEquals(10.0d, getResult.getLatitude());
        assertEquals(10.0d, getResult.getLongitude());
        assertEquals(1L, actualToModelResult.getTraining().getId());
        assertEquals(2, actualToModelResult.getDistance());
        assertSame(route, getResult.getRoute());
    }
}
