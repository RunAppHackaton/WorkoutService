package com.runapp.workoutservice.service;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.AchievementServiceClient;
import com.runapp.workoutservice.feignClient.ShoesServiceClient;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.repository.RunSessionRepository;
import com.runapp.workoutservice.service.serviceImpl.RunSessionServiceImpl;
import com.runapp.workoutservice.staticObject.StaticRunSession;
import com.runapp.workoutservice.utill.existHandler.ExistEnum;
import com.runapp.workoutservice.utill.existHandler.ExistHandlerRegistry;
import com.runapp.workoutservice.utill.supportClasses.AchievementConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RunSessionServiceTest {

    @Mock
    private RunSessionRepository runSessionRepository;

    @Mock
    private ShoesServiceClient shoesServiceClient;

    @Mock
    private ExistHandlerRegistry existHandlerRegistry;

    @Mock
    private AchievementServiceClient achievementServiceClient;

    @Mock
    private AchievementConverter achievementConverter;

    @InjectMocks
    private RunSessionServiceImpl runSessionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void add_ValidRunSessionModel_ReturnsSavedModel() {
        RunSessionModel sessionModel = StaticRunSession.runSession();

        when(runSessionRepository.save(any(RunSessionModel.class))).thenReturn(sessionModel);

        RunSessionModel savedModel = runSessionService.add(sessionModel);

        assertNotNull(savedModel);
        assertEquals(sessionModel.getId(), savedModel.getId());
        assertEquals(sessionModel.getUserId(), savedModel.getUserId());
        assertEquals(sessionModel.getShoesId(), savedModel.getShoesId());
        assertEquals(sessionModel.getDistance(), savedModel.getDistance());

        verify(runSessionRepository, times(1)).save(any(RunSessionModel.class));
        verify(achievementServiceClient, times(1)).saveTraining(any());
        verify(existHandlerRegistry, times(1)).handleRequest(ExistEnum.SHOES, sessionModel.getShoesId());
        verify(shoesServiceClient, times(1)).updateMileage((long) sessionModel.getShoesId(), sessionModel.getDistance());
    }

    @Test
    void getById_ExistingId_ReturnsRunSessionModel() {
        long id = 1L;
        RunSessionModel sessionModel = new RunSessionModel();
        sessionModel.setId(id);

        when(runSessionRepository.findById(id)).thenReturn(Optional.of(sessionModel));

        RunSessionModel retrievedModel = runSessionService.getById(id);

        assertNotNull(retrievedModel);
        assertEquals(id, retrievedModel.getId());

        verify(runSessionRepository, times(1)).findById(id);
    }

    @Test
    void getById_NonExistingId_ThrowsNoEntityFoundException() {
        long id = 1L;

        when(runSessionRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoEntityFoundException.class, () -> runSessionService.getById(id));

        verify(runSessionRepository, times(1)).findById(id);
    }

    @Test
    void getAll_ReturnsListOfRunSessionModels() {
        RunSessionModel sessionModel1 = new RunSessionModel();
        sessionModel1.setId(1L);
        RunSessionModel sessionModel2 = new RunSessionModel();
        sessionModel2.setId(2L);
        List<RunSessionModel> sessionModels = new ArrayList<>();
        sessionModels.add(sessionModel1);
        sessionModels.add(sessionModel2);

        when(runSessionRepository.findAll()).thenReturn(sessionModels);

        List<RunSessionModel> retrievedModels = runSessionService.getAll();

        assertNotNull(retrievedModels);
        assertEquals(sessionModels.size(), retrievedModels.size());
        assertEquals(sessionModel1.getId(), retrievedModels.get(0).getId());
        assertEquals(sessionModel2.getId(), retrievedModels.get(1).getId());

        verify(runSessionRepository, times(1)).findAll();
    }

    @Test
    void deleteById_ExistingId_DeletesRunSessionModel() {
        long id = 1L;

        when(runSessionRepository.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> runSessionService.deleteById(id));

        verify(runSessionRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteById_NonExistingId_ThrowsNoEntityFoundException() {
        long id = 1L;

        when(runSessionRepository.existsById(id)).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> runSessionService.deleteById(id));

        verify(runSessionRepository, times(0)).deleteById(id);
    }

    @Test
    void update_ExistingId_ReturnsUpdatedRunSessionModel() {
        long id = 1L;
        RunSessionModel sessionModel = new RunSessionModel();
        sessionModel.setId(id);

        when(runSessionRepository.existsById(id)).thenReturn(true);
        when(runSessionRepository.save(any(RunSessionModel.class))).thenReturn(sessionModel);

        RunSessionModel updatedModel = runSessionService.update(sessionModel);

        assertNotNull(updatedModel);
        assertEquals(id, updatedModel.getId());

        verify(runSessionRepository, times(1)).save(any(RunSessionModel.class));
    }

    @Test
    void update_NonExistingId_ThrowsNoEntityFoundException() {
        long id = 1L;
        RunSessionModel sessionModel = new RunSessionModel();
        sessionModel.setId(id);

        when(runSessionRepository.existsById(id)).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> runSessionService.update(sessionModel));

        verify(runSessionRepository, times(0)).save(any(RunSessionModel.class));
    }
}

