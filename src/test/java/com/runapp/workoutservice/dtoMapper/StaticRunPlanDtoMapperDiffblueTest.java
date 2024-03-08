package com.runapp.workoutservice.dtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.staticObject.StaticRunPlan;
import com.runapp.workoutservice.staticObject.StaticTraining;

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
class StaticRunPlanDtoMapperDiffblueTest {
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
        model.setUserId("1");
        RunPlanLongResponse actualToLongDtoResult = runPlanDtoMapper.toLongDto(model);
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals("1", actualToLongDtoResult.getUserId());
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
        when(model.getUserId()).thenReturn("1");
        when(model.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        when(model.getTrainingModels()).thenReturn(trainingModelList);
        when(model.getId()).thenReturn(1L);
        doNothing().when(model).setDayOfTheWeek(anyInt());
        doNothing().when(model).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(model).setId(anyLong());
        doNothing().when(model).setStartingWeeklyVolume(anyInt());
        doNothing().when(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(model).setUserId(any());
        model.setDayOfTheWeek(1);
        model.setFinalDate(LocalDate.of(1970, 1, 1));
        model.setId(1L);
        model.setStartingWeeklyVolume(1);
        model.setTrainingModels(new ArrayList<>());
        model.setUserId("1");
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
        verify(model).setUserId(any());
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals("1", actualToLongDtoResult.getUserId());
        assertEquals(1L, actualToLongDtoResult.getId());
        assertEquals(trainingModelList, actualToLongDtoResult.getTrainings());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(RunPlanModel)}
     */
    @Test
    void testToLongDto3() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel);
        RunPlanModel model = mock(RunPlanModel.class);
        when(model.getDayOfTheWeek()).thenReturn(1);
        when(model.getStartingWeeklyVolume()).thenReturn(1);
        when(model.getUserId()).thenReturn("1");
        when(model.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(model.getTrainingModels()).thenReturn(trainingModelList);
        when(model.getId()).thenReturn(1L);
        doNothing().when(model).setDayOfTheWeek(anyInt());
        doNothing().when(model).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(model).setId(anyLong());
        doNothing().when(model).setStartingWeeklyVolume(anyInt());
        doNothing().when(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(model).setUserId(any());
        model.setDayOfTheWeek(1);
        model.setFinalDate(LocalDate.of(1970, 1, 1));
        model.setId(1L);
        model.setStartingWeeklyVolume(1);
        model.setTrainingModels(new ArrayList<>());
        model.setUserId("1");
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
        verify(model).setUserId(any());
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals("1", actualToLongDtoResult.getUserId());
        assertEquals(1, actualToLongDtoResult.getTrainings().size());
        assertEquals(1L, actualToLongDtoResult.getId());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(RunPlanModel)}
     */
    @Test
    void testToLongDto4() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();
        TrainingModel trainingModel2 = StaticTraining.trainingModel2();

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel2);
        trainingModelList.add(trainingModel);
        RunPlanModel model = mock(RunPlanModel.class);
        when(model.getDayOfTheWeek()).thenReturn(1);
        when(model.getStartingWeeklyVolume()).thenReturn(1);
        when(model.getUserId()).thenReturn("1");
        when(model.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(model.getTrainingModels()).thenReturn(trainingModelList);
        when(model.getId()).thenReturn(1L);
        doNothing().when(model).setDayOfTheWeek(anyInt());
        doNothing().when(model).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(model).setId(anyLong());
        doNothing().when(model).setStartingWeeklyVolume(anyInt());
        doNothing().when(model).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(model).setUserId(any());
        model.setDayOfTheWeek(1);
        model.setFinalDate(LocalDate.of(1970, 1, 1));
        model.setId(1L);
        model.setStartingWeeklyVolume(1);
        model.setTrainingModels(new ArrayList<>());
        model.setUserId("1");
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
        verify(model).setUserId(any());
        assertEquals("1970-01-01", actualToLongDtoResult.getFinalDate().toString());
        assertEquals(1, actualToLongDtoResult.getDayOfTheWeek());
        assertEquals(1, actualToLongDtoResult.getStartingWeeklyVolume());
        assertEquals("1", actualToLongDtoResult.getUserId());
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
        RunPlanModel runPlanModel = StaticRunPlan.runPlanModel();

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel);
        assertEquals(1, runPlanDtoMapper.toLongDto(runPlanModels).size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto7() {
        RunPlanModel runPlanModel = StaticRunPlan.runPlanModel();

        RunPlanModel runPlanModel2 = StaticRunPlan.runPlanModel2();

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
        when(runPlanModel.getUserId()).thenReturn("1");
        when(runPlanModel.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(runPlanModel.getTrainingModels()).thenReturn(new ArrayList<>());
        when(runPlanModel.getId()).thenReturn(1L);
        doNothing().when(runPlanModel).setDayOfTheWeek(anyInt());
        doNothing().when(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(runPlanModel).setId(anyLong());
        doNothing().when(runPlanModel).setStartingWeeklyVolume(anyInt());
        doNothing().when(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(runPlanModel).setUserId(any());
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId("1");

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
        verify(runPlanModel).setUserId(any());
        assertEquals(1, actualToLongDtoResult.size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto9() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel);
        RunPlanModel runPlanModel = mock(RunPlanModel.class);
        when(runPlanModel.getDayOfTheWeek()).thenReturn(1);
        when(runPlanModel.getStartingWeeklyVolume()).thenReturn(1);
        when(runPlanModel.getUserId()).thenReturn("1");
        when(runPlanModel.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(runPlanModel.getTrainingModels()).thenReturn(trainingModelList);
        when(runPlanModel.getId()).thenReturn(1L);
        doNothing().when(runPlanModel).setDayOfTheWeek(anyInt());
        doNothing().when(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(runPlanModel).setId(anyLong());
        doNothing().when(runPlanModel).setStartingWeeklyVolume(anyInt());
        doNothing().when(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(runPlanModel).setUserId(any());
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId("1");

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
        verify(runPlanModel).setUserId(any());
        assertEquals(1, actualToLongDtoResult.size());
    }

    /**
     * Method under test: {@link RunPlanDtoMapper#toLongDto(List)}
     */
    @Test
    void testToLongDto10() {
        TrainingModel trainingModel = StaticTraining.trainingModel1();
        TrainingModel trainingModel2 = StaticTraining.trainingModel2();

        ArrayList<TrainingModel> trainingModelList = new ArrayList<>();
        trainingModelList.add(trainingModel2);
        trainingModelList.add(trainingModel);
        RunPlanModel runPlanModel = mock(RunPlanModel.class);
        when(runPlanModel.getDayOfTheWeek()).thenReturn(1);
        when(runPlanModel.getStartingWeeklyVolume()).thenReturn(1);
        when(runPlanModel.getUserId()).thenReturn("1");
        when(runPlanModel.getFinalDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(runPlanModel.getTrainingModels()).thenReturn(trainingModelList);
        when(runPlanModel.getId()).thenReturn(1L);
        doNothing().when(runPlanModel).setDayOfTheWeek(anyInt());
        doNothing().when(runPlanModel).setFinalDate(Mockito.<LocalDate>any());
        doNothing().when(runPlanModel).setId(anyLong());
        doNothing().when(runPlanModel).setStartingWeeklyVolume(anyInt());
        doNothing().when(runPlanModel).setTrainingModels(Mockito.<List<TrainingModel>>any());
        doNothing().when(runPlanModel).setUserId(any());
        runPlanModel.setDayOfTheWeek(1);
        runPlanModel.setFinalDate(LocalDate.of(1970, 1, 1));
        runPlanModel.setId(1L);
        runPlanModel.setStartingWeeklyVolume(1);
        runPlanModel.setTrainingModels(new ArrayList<>());
        runPlanModel.setUserId("1");

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
        verify(runPlanModel).setUserId(any());
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

        RunPlanModel runPlanModel = StaticRunPlan.runPlanModel();

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

        RunPlanModel runPlanModel = StaticRunPlan.runPlanModel();
        RunPlanModel runPlanModel2 = StaticRunPlan.runPlanModel2();

        ArrayList<RunPlanModel> runPlanModels = new ArrayList<>();
        runPlanModels.add(runPlanModel2);
        runPlanModels.add(runPlanModel);
        List<RunPlanShortResponse> actualToShortDtoResult = runPlanDtoMapper.toShortDto(runPlanModels);
        verify(objectMapper, atLeast(1)).convertValue(Mockito.<Object>any(), Mockito.<Class<RunPlanShortResponse>>any());
        assertEquals(2, actualToShortDtoResult.size());
    }
}
