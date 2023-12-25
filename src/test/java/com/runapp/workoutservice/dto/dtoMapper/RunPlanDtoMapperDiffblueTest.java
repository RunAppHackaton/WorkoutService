package com.runapp.workoutservice.dto.dtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dto.response.RunPlanLongResponse;
import com.runapp.workoutservice.dto.response.RunPlanShortResponse;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.model.RunTypeModel;
import com.runapp.workoutservice.model.StageModel;
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;

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

@ContextConfiguration(classes = {RunPlanDtoMapper.class})
@ExtendWith(SpringExtension.class)
class RunPlanDtoMapperDiffblueTest {
    @MockBean
    private ObjectMapper objectMapper;

    @Autowired
    private RunPlanDtoMapper runPlanDtoMapper;

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(RunPlanModel)}
     */
    @Test
    void testToLongDto() {
        RunPlanModel model = new RunPlanModel();
        model.setDayOfTheWeek(1);
        model.setFinalDate(LocalDate.of(1970, 1, 1));
        model.setId(1L);
        model.setStartingWeeklyVolume(1);
        ArrayList<TrainingModel> trainingModels = new ArrayList<>();
        model.setTrainingModels(trainingModels);
        model.setUserId(1);
        RunPlanLongResponse actualToLongDtoResult = runPlanDtoMapper.toLongDto(model);
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals(1, actualToLongDtoResult.getUserId());
        assertEquals(1L, actualToLongDtoResult.getId());
        assertEquals(trainingModels, actualToLongDtoResult.getTrainings());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(RunPlanModel)}
     */
    @Test
    void testToLongDto2() {
        RunPlanModel model = mock(RunPlanModel.class);
        when(model.getDayOfTheWeek()).thenReturn(1);
        when(model.getStartingWeeklyVolume()).thenReturn(1);
        when(model.getUserId()).thenReturn(1);
        when(model.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        when(model.getTrainingModels()).thenReturn(trainingModelList);
        when(model.getId()).thenReturn(1L);
        doNothing().when(model).setDayOfTheWeek(anyInt());
        doNothing().when(model).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(model).setId(anyLong());
        doNothing().when(model).setStartingWeeklyVolume(anyInt());
        doNothing().when(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(model).setUserId(anyInt());
        model.setDayOfTheWeek(1);
        model.setFinalDate(LocalDate.of(1970, 1, 1));
        model.setId(1L);
        model.setStartingWeeklyVolume(1);
        model.setTrainingModels(new ArrayList<>());
        model.setUserId(1);
        RunPlanLongResponse actualToLongDtoResult = runPlanDtoMapper.toLongDto(model);
        verify(model).getDayOfTheWeek();
        verify(model).getFinalDate();
        verify(model).getId();
        verify(model).getStartingWeeklyVolume();
        verify(model).getTrainingModels();
        verify(model).getUserId();
        verify(model).setDayOfTheWeek(anyInt());
        verify(model).setFinalDate(Mockito.<LocalDate>any());
        verify(model).setId(anyLong());
        verify(model).setStartingWeeklyVolume(anyInt());
        verify(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        verify(model).setUserId(anyInt());
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals(1, actualToLongDtoResult.getUserId());
        assertEquals(1L, actualToLongDtoResult.getId());
        assertEquals(trainingModelList, actualToLongDtoResult.getTrainings());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(RunPlanModel)}
     */
    @Test
    void testToLongDto3() {
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

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setHitch(10.0d);
        trainingModel.setId(1L);
        trainingModel.setIntervalModelList(new ArrayList<>());
        trainingModel.setKilometers(10.0d);
        trainingModel.setRunPlan(runPlan);
        trainingModel.setRunType(runType);
        trainingModel.setStage(stage);
        trainingModel.setWarmUp(10.0d);

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel);
        RunPlanModel model = mock(RunPlanModel.class);
        when(model.getDayOfTheWeek()).thenReturn(1);
        when(model.getStartingWeeklyVolume()).thenReturn(1);
        when(model.getUserId()).thenReturn(1);
        when(model.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(model.getTrainingModels()).thenReturn(trainingModelList);
        when(model.getId()).thenReturn(1L);
        doNothing().when(model).setDayOfTheWeek(anyInt());
        doNothing().when(model).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(model).setId(anyLong());
        doNothing().when(model).setStartingWeeklyVolume(anyInt());
        doNothing().when(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(model).setUserId(anyInt());
        model.setDayOfTheWeek(1);
        model.setFinalDate(LocalDate.of(1970, 1, 1));
        model.setId(1L);
        model.setStartingWeeklyVolume(1);
        model.setTrainingModels(new ArrayList<>());
        model.setUserId(1);
        RunPlanLongResponse actualToLongDtoResult = runPlanDtoMapper.toLongDto(model);
        verify(model).getDayOfTheWeek();
        verify(model).getFinalDate();
        verify(model).getId();
        verify(model).getStartingWeeklyVolume();
        verify(model).getTrainingModels();
        verify(model).getUserId();
        verify(model).setDayOfTheWeek(anyInt());
        verify(model).setFinalDate(Mockito.<LocalDate>any());
        verify(model).setId(anyLong());
        verify(model).setStartingWeeklyVolume(anyInt());
        verify(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        verify(model).setUserId(anyInt());
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals(1, actualToLongDtoResult.getUserId());
        assertEquals(1, actualToLongDtoResult.getTrainings().size());
        assertEquals(1L, actualToLongDtoResult.getId());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(RunPlanModel)}
     */
    @Test
    void testToLongDto4() {
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

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setHitch(10.0d);
        trainingModel.setId(1L);
        trainingModel.setIntervalModelList(new ArrayList<>());
        trainingModel.setKilometers(10.0d);
        trainingModel.setRunPlan(runPlan);
        trainingModel.setRunType(runType);
        trainingModel.setStage(stage);
        trainingModel.setWarmUp(10.0d);

        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(0);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(2L);
        runPlan2.setStartingWeeklyVolume(0);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId(2);

        RunTypeModel runType2 = new RunTypeModel();
        runType2.setDescription("Description");
        runType2.setId(2L);
        runType2.setRuntypeImageUrl("Runtype Image Url");
        runType2.setTypeName(TrainingTypeEnum.SPEED_SURGE);

        StageModel stage2 = new StageModel();
        stage2.setDescription("Description");
        stage2.setId(2L);
        stage2.setName("com.runapp.workoutservice.model.StageModel");
        stage2.setStageEnum(StageEnum.STAGE2);

        TrainingModel trainingModel2 = new TrainingModel();
        trainingModel2.setHitch(0.5d);
        trainingModel2.setId(2L);
        trainingModel2.setIntervalModelList(new ArrayList<>());
        trainingModel2.setKilometers(0.5d);
        trainingModel2.setRunPlan(runPlan2);
        trainingModel2.setRunType(runType2);
        trainingModel2.setStage(stage2);
        trainingModel2.setWarmUp(0.5d);

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel2);
        trainingModelList.add(trainingModel);
        RunPlanModel model = mock(RunPlanModel.class);
        when(model.getDayOfTheWeek()).thenReturn(1);
        when(model.getStartingWeeklyVolume()).thenReturn(1);
        when(model.getUserId()).thenReturn(1);
        when(model.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(model.getTrainingModels()).thenReturn(trainingModelList);
        when(model.getId()).thenReturn(1L);
        doNothing().when(model).setDayOfTheWeek(anyInt());
        doNothing().when(model).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(model).setId(anyLong());
        doNothing().when(model).setStartingWeeklyVolume(anyInt());
        doNothing().when(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(model).setUserId(anyInt());
        model.setDayOfTheWeek(1);
        model.setFinalDate(LocalDate.of(1970, 1, 1));
        model.setId(1L);
        model.setStartingWeeklyVolume(1);
        model.setTrainingModels(new ArrayList<>());
        model.setUserId(1);
        RunPlanLongResponse actualToLongDtoResult = runPlanDtoMapper.toLongDto(model);
        verify(model).getDayOfTheWeek();
        verify(model).getFinalDate();
        verify(model).getId();
        verify(model).getStartingWeeklyVolume();
        verify(model).getTrainingModels();
        verify(model).getUserId();
        verify(model).setDayOfTheWeek(anyInt());
        verify(model).setFinalDate(Mockito.<LocalDate>any());
        verify(model).setId(anyLong());
        verify(model).setStartingWeeklyVolume(anyInt());
        verify(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        verify(model).setUserId(anyInt());
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals(1, actualToLongDtoResult.getUserId());
        assertEquals(1L, actualToLongDtoResult.getId());
        assertEquals(2, actualToLongDtoResult.getTrainings().size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto5() {
        assertTrue(runPlanDtoMapper.toLongDto(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto6() {
        RunPlanModel runPlanModel = new RunPlanModel();
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel);
        assertEquals(1, runPlanDtoMapper.toLongDto(runPlanModels).size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto7() {
        RunPlanModel runPlanModel = new RunPlanModel();
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);

        RunPlanModel runPlanModel2 = new RunPlanModel();
        runPlanModel2.setDayOfTheWeek(0);
        runPlanModel2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel2.setId(2L);
        runPlanModel2.setStartingWeeklyVolume(0);
        runPlanModel2.setTrainingModels(new ArrayList<>());
        runPlanModel2.setUserId(2);

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel2);
        runPlanModels.add(runPlanModel);
        assertEquals(2, runPlanDtoMapper.toLongDto(runPlanModels).size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto8() {
        RunPlanModel runPlanModel = mock(RunPlanModel.class);
        when(runPlanModel.getDayOfTheWeek()).thenReturn(1);
        when(runPlanModel.getStartingWeeklyVolume()).thenReturn(1);
        when(runPlanModel.getUserId()).thenReturn(1);
        when(runPlanModel.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(runPlanModel.getTrainingModels()).thenReturn(new ArrayList<>());
        when(runPlanModel.getId()).thenReturn(1L);
        doNothing().when(runPlanModel).setDayOfTheWeek(anyInt());
        doNothing().when(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(runPlanModel).setId(anyLong());
        doNothing().when(runPlanModel).setStartingWeeklyVolume(anyInt());
        doNothing().when(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(runPlanModel).setUserId(anyInt());
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel);
        List<RunPlanLongResponse> actualToLongDtoResult = runPlanDtoMapper.toLongDto(runPlanModels);
        verify(runPlanModel).getDayOfTheWeek();
        verify(runPlanModel).getFinalDate();
        verify(runPlanModel).getId();
        verify(runPlanModel).getStartingWeeklyVolume();
        verify(runPlanModel).getTrainingModels();
        verify(runPlanModel).getUserId();
        verify(runPlanModel).setDayOfTheWeek(anyInt());
        verify(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        verify(runPlanModel).setId(anyLong());
        verify(runPlanModel).setStartingWeeklyVolume(anyInt());
        verify(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        verify(runPlanModel).setUserId(anyInt());
        assertEquals(1, actualToLongDtoResult.size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto9() {
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

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setHitch(10.0d);
        trainingModel.setId(1L);
        trainingModel.setIntervalModelList(new ArrayList<>());
        trainingModel.setKilometers(10.0d);
        trainingModel.setRunPlan(runPlan);
        trainingModel.setRunType(runType);
        trainingModel.setStage(stage);
        trainingModel.setWarmUp(10.0d);

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel);
        RunPlanModel runPlanModel = mock(RunPlanModel.class);
        when(runPlanModel.getDayOfTheWeek()).thenReturn(1);
        when(runPlanModel.getStartingWeeklyVolume()).thenReturn(1);
        when(runPlanModel.getUserId()).thenReturn(1);
        when(runPlanModel.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(runPlanModel.getTrainingModels()).thenReturn(trainingModelList);
        when(runPlanModel.getId()).thenReturn(1L);
        doNothing().when(runPlanModel).setDayOfTheWeek(anyInt());
        doNothing().when(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(runPlanModel).setId(anyLong());
        doNothing().when(runPlanModel).setStartingWeeklyVolume(anyInt());
        doNothing().when(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(runPlanModel).setUserId(anyInt());
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel);
        List<RunPlanLongResponse> actualToLongDtoResult = runPlanDtoMapper.toLongDto(runPlanModels);
        verify(runPlanModel).getDayOfTheWeek();
        verify(runPlanModel).getFinalDate();
        verify(runPlanModel).getId();
        verify(runPlanModel).getStartingWeeklyVolume();
        verify(runPlanModel).getTrainingModels();
        verify(runPlanModel).getUserId();
        verify(runPlanModel).setDayOfTheWeek(anyInt());
        verify(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        verify(runPlanModel).setId(anyLong());
        verify(runPlanModel).setStartingWeeklyVolume(anyInt());
        verify(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        verify(runPlanModel).setUserId(anyInt());
        assertEquals(1, actualToLongDtoResult.size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto10() {
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

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setHitch(10.0d);
        trainingModel.setId(1L);
        trainingModel.setIntervalModelList(new ArrayList<>());
        trainingModel.setKilometers(10.0d);
        trainingModel.setRunPlan(runPlan);
        trainingModel.setRunType(runType);
        trainingModel.setStage(stage);
        trainingModel.setWarmUp(10.0d);

        RunPlanModel runPlan2 = new RunPlanModel();
        runPlan2.setDayOfTheWeek(0);
        runPlan2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlan2.setId(2L);
        runPlan2.setStartingWeeklyVolume(0);
        runPlan2.setTrainingModels(new ArrayList<>());
        runPlan2.setUserId(2);

        RunTypeModel runType2 = new RunTypeModel();
        runType2.setDescription("Description");
        runType2.setId(2L);
        runType2.setRuntypeImageUrl("Runtype Image Url");
        runType2.setTypeName(TrainingTypeEnum.SPEED_SURGE);

        StageModel stage2 = new StageModel();
        stage2.setDescription("Description");
        stage2.setId(2L);
        stage2.setName("com.runapp.workoutservice.model.StageModel");
        stage2.setStageEnum(StageEnum.STAGE2);

        TrainingModel trainingModel2 = new TrainingModel();
        trainingModel2.setHitch(0.5d);
        trainingModel2.setId(2L);
        trainingModel2.setIntervalModelList(new ArrayList<>());
        trainingModel2.setKilometers(0.5d);
        trainingModel2.setRunPlan(runPlan2);
        trainingModel2.setRunType(runType2);
        trainingModel2.setStage(stage2);
        trainingModel2.setWarmUp(0.5d);

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel2);
        trainingModelList.add(trainingModel);
        RunPlanModel runPlanModel = mock(RunPlanModel.class);
        when(runPlanModel.getDayOfTheWeek()).thenReturn(1);
        when(runPlanModel.getStartingWeeklyVolume()).thenReturn(1);
        when(runPlanModel.getUserId()).thenReturn(1);
        when(runPlanModel.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(runPlanModel.getTrainingModels()).thenReturn(trainingModelList);
        when(runPlanModel.getId()).thenReturn(1L);
        doNothing().when(runPlanModel).setDayOfTheWeek(anyInt());
        doNothing().when(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(runPlanModel).setId(anyLong());
        doNothing().when(runPlanModel).setStartingWeeklyVolume(anyInt());
        doNothing().when(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(runPlanModel).setUserId(anyInt());
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel);
        List<RunPlanLongResponse> actualToLongDtoResult = runPlanDtoMapper.toLongDto(runPlanModels);
        verify(runPlanModel).getDayOfTheWeek();
        verify(runPlanModel).getFinalDate();
        verify(runPlanModel).getId();
        verify(runPlanModel).getStartingWeeklyVolume();
        verify(runPlanModel).getTrainingModels();
        verify(runPlanModel).getUserId();
        verify(runPlanModel).setDayOfTheWeek(anyInt());
        verify(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        verify(runPlanModel).setId(anyLong());
        verify(runPlanModel).setStartingWeeklyVolume(anyInt());
        verify(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        verify(runPlanModel).setUserId(anyInt());
        assertEquals(1, actualToLongDtoResult.size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toShortDto(List)}
     */
    @Test
    void testToShortDto() {
        assertTrue(runPlanDtoMapper.toShortDto(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toShortDto(List)}
     */
    @Test
    void testToShortDto2() throws IllegalArgumentException {
        when(objectMapper.convertValue(Mockito.<Object>any(), Mockito.<Class<RunPlanShortResponse>>any()))
                .thenReturn(new RunPlanShortResponse());

        RunPlanModel runPlanModel = new RunPlanModel();
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel);
        List<RunPlanShortResponse> actualToShortDtoResult = runPlanDtoMapper.toShortDto(runPlanModels);
        verify(objectMapper).convertValue(Mockito.<Object>any(), Mockito.<Class<RunPlanShortResponse>>any());
        assertEquals(1, actualToShortDtoResult.size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toShortDto(List)}
     */
    @Test
    void testToShortDto3() throws IllegalArgumentException {
        when(objectMapper.convertValue(Mockito.<Object>any(), Mockito.<Class<RunPlanShortResponse>>any()))
                .thenReturn(new RunPlanShortResponse());

        RunPlanModel runPlanModel = new RunPlanModel();
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId(1);

        RunPlanModel runPlanModel2 = new RunPlanModel();
        runPlanModel2.setDayOfTheWeek(0);
        runPlanModel2.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel2.setId(2L);
        runPlanModel2.setStartingWeeklyVolume(0);
        runPlanModel2.setTrainingModels(new ArrayList<>());
        runPlanModel2.setUserId(2);

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel2);
        runPlanModels.add(runPlanModel);
        List<RunPlanShortResponse> actualToShortDtoResult = runPlanDtoMapper.toShortDto(runPlanModels);
        verify(objectMapper, atLeast(1)).convertValue(Mockito.<Object>any(), Mockito.<Class<RunPlanShortResponse>>any());
        assertEquals(2, actualToShortDtoResult.size());
    }
}
