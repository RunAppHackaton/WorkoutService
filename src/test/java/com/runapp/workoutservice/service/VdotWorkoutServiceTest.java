package com.runapp.workoutservice.service;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.serviceImpl.VdotWorkoutServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VdotWorkoutServiceTest {

    @Mock
    private VdotWorkoutRepository vdotWorkoutRepository;

    @InjectMocks
    private VdotWorkoutServiceImpl vdotWorkoutService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void add_ValidVdotWorkoutModel_ReturnsSavedModel() {
        VdotWorkoutModel vdotWorkoutModel = new VdotWorkoutModel();
        vdotWorkoutModel.setVdot(1L);

        when(vdotWorkoutRepository.save(any(VdotWorkoutModel.class))).thenReturn(vdotWorkoutModel);

        VdotWorkoutModel savedModel = vdotWorkoutService.add(vdotWorkoutModel);

        assertNotNull(savedModel);
        assertEquals(vdotWorkoutModel.getVdot(), savedModel.getVdot());

        verify(vdotWorkoutRepository, times(1)).save(any(VdotWorkoutModel.class));
    }

    @Test
    void getById_ExistingId_ReturnsVdotWorkoutModel() {
        long id = 1L;
        VdotWorkoutModel vdotWorkoutModel = new VdotWorkoutModel();
        vdotWorkoutModel.setVdot(id);

        when(vdotWorkoutRepository.findById(id)).thenReturn(Optional.of(vdotWorkoutModel));

        VdotWorkoutModel retrievedModel = vdotWorkoutService.getById(id);

        assertNotNull(retrievedModel);
        assertEquals(id, retrievedModel.getVdot());

        verify(vdotWorkoutRepository, times(1)).findById(id);
    }

    @Test
    void getById_NonExistingId_ThrowsNoEntityFoundException() {
        long id = 1L;

        when(vdotWorkoutRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoEntityFoundException.class, () -> vdotWorkoutService.getById(id));

        verify(vdotWorkoutRepository, times(1)).findById(id);
    }

    @Test
    void getAll_ReturnsListOfVdotWorkoutModels() {
        List<VdotWorkoutModel> vdotWorkoutModels = new ArrayList<>();
        vdotWorkoutModels.add(new VdotWorkoutModel());
        vdotWorkoutModels.add(new VdotWorkoutModel());

        when(vdotWorkoutRepository.findAll()).thenReturn(vdotWorkoutModels);

        List<VdotWorkoutModel> retrievedModels = vdotWorkoutService.getAll();

        assertNotNull(retrievedModels);
        assertEquals(2, retrievedModels.size());

        verify(vdotWorkoutRepository, times(1)).findAll();
    }

    @Test
    void deleteById_ExistingId_DeletesModel() {
        long id = 1L;

        when(vdotWorkoutRepository.existsById(id)).thenReturn(true);

        vdotWorkoutService.deleteById(id);

        verify(vdotWorkoutRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteById_NonExistingId_ThrowsNoEntityFoundException() {
        long id = 1L;

        when(vdotWorkoutRepository.existsById(id)).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> vdotWorkoutService.deleteById(id));

        verify(vdotWorkoutRepository, times(0)).deleteById(id);
    }

    @Test
    void update_ExistingModel_ReturnsUpdatedModel() {
        VdotWorkoutModel vdotWorkoutModel = new VdotWorkoutModel();
        vdotWorkoutModel.setVdot(1L);

        when(vdotWorkoutRepository.existsById(vdotWorkoutModel.getVdot())).thenReturn(true);
        when(vdotWorkoutRepository.save(any(VdotWorkoutModel.class))).thenReturn(vdotWorkoutModel);

        VdotWorkoutModel updatedModel = vdotWorkoutService.update(vdotWorkoutModel);

        assertNotNull(updatedModel);
        assertEquals(vdotWorkoutModel.getVdot(), updatedModel.getVdot());

        verify(vdotWorkoutRepository, times(1)).save(any(VdotWorkoutModel.class));
    }

    @Test
    void update_NonExistingModel_ThrowsNoEntityFoundException() {
        VdotWorkoutModel vdotWorkoutModel = new VdotWorkoutModel();
        vdotWorkoutModel.setVdot(1L);

        when(vdotWorkoutRepository.existsById(vdotWorkoutModel.getVdot())).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> vdotWorkoutService.update(vdotWorkoutModel));

        verify(vdotWorkoutRepository, times(0)).save(any(VdotWorkoutModel.class));
    }
}
