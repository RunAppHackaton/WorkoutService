package com.runapp.workoutservice.service;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.repository.RunPlanRepository;
import com.runapp.workoutservice.service.serviceImpl.RunPlanServiceImpl;
import com.runapp.workoutservice.utill.existHandler.ExistHandlerRegistry;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class RunPlanServiceTest {

    @Mock
    private RunPlanRepository runPlanRepository;

    @Mock
    private ExistHandlerRegistry existHandlerRegistry;

    @InjectMocks
    private RunPlanServiceImpl runPlanService;
//TODO
//    @Test
//    void add_ThrowsNoEntityFoundException() {
//        MockitoAnnotations.initMocks(this);
//        RunPlanModel entity = new RunPlanModel();
//        entity.setUserId(1);
//        doThrow(new NoEntityFoundException("User with id: " + entity.getUserId() + " doesn't exist")).when(existHandlerRegistry).handleRequest(any(), any());
//        assertThrows(NoEntityFoundException.class, () -> runPlanService.add(entity));
//    }

    @Test
    void getById_ReturnsRunPlanModel() {
        MockitoAnnotations.initMocks(this);
        Long id = 1L;
        RunPlanModel expected = new RunPlanModel();
        expected.setId(id);
        when(runPlanRepository.findById(id)).thenReturn(Optional.of(expected));
        assertEquals(expected, runPlanService.getById(id));
    }

    @Test
    void testGetAllThrowsNoEntityFoundException() {
        MockitoAnnotations.initMocks(this);
        when(runPlanRepository.findAll()).thenReturn(Collections.emptyList());

        Throwable exception = assertThrows(NoEntityFoundException.class, () -> {
            runPlanService.getAll();
        });

        // Проверка содержания сообщения об ошибке
        assertTrue(exception.getMessage().contains("RunPlan records don't exist"));
    }


    @Test
    void deleteById_ThrowsNoEntityFoundException() {
        MockitoAnnotations.initMocks(this);
        Long id = 1L;
        doThrow(new NoEntityFoundException("RunPlan with id: " + id + " doesn't exist")).when(runPlanRepository).deleteById(id);
        assertThrows(NoEntityFoundException.class, () -> runPlanService.deleteById(id));
    }
//TODO
//    @Test
//    void update_ThrowsNoEntityFoundException() {
//        RunPlanModel entity = new RunPlanModel();
//        entity.setId(1L);
//        when(runPlanRepository.existsById(entity.getId())).thenReturn(false);
//        assertThrows(NoEntityFoundException.class, () -> runPlanService.update(entity));
//    }

// TODO
//    @Test
//    void createPlan_SavesRunPlanModel() {
//        MockitoAnnotations.initMocks(this);
//        List<RunTraining> runTrainings = new ArrayList<>();
//        RunPlanRequest runPlanRequest = new RunPlanRequest();
//        runPlanRequest.setUser_id(1);
//        runPlanRequest.setTraining_days(new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY});
//
//        RunPlanModel expected = new RunPlanModel();
//        LocalDate goalDate = LocalDate.of(2024, 2, 27); // Set the correct date
//        int trainingDaysLength = runPlanRequest.getTraining_days().length; // Use the length of training_days
//        int startingWeeklyVolume = 30;
//
//        expected.setDayOfTheWeek(trainingDaysLength);
//        expected.setStartingWeeklyVolume(startingWeeklyVolume);
//        expected.setFinalDate(goalDate);
//        expected.setUserId(runPlanRequest.getUser_id());
//
//        when(runPlanRepository.save(any())).thenReturn(expected);
//
//        RunPlanModel actual = runPlanService.createPlan(runTrainings, runPlanRequest);
//
//        assertEquals(expected.getDayOfTheWeek(), actual.getDayOfTheWeek());
//        assertEquals(expected.getStartingWeeklyVolume(), actual.getStartingWeeklyVolume());
//        assertEquals(expected.getFinalDate(), actual.getFinalDate());
//        assertEquals(expected.getUserId(), actual.getUserId());
//        assertEquals(expected.getTrainingModels(), actual.getTrainingModels());
//    }
}

