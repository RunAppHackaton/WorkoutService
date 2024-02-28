package com.runapp.workoutservice.service;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.repository.VdotGradeRepository;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VdotCradeServiceTest {

    @Mock
    private VdotGradeRepository vdotGradeRepository;

    @InjectMocks
    private VdotCradeServiceImpl vdotCradeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void add_ValidVdotGradeModel_ReturnsSavedModel() {
        VdotGradeModel vdotGradeModel = new VdotGradeModel();
        vdotGradeModel.setVdot(1L);

        when(vdotGradeRepository.save(any(VdotGradeModel.class))).thenReturn(vdotGradeModel);

        VdotGradeModel savedModel = vdotCradeService.add(vdotGradeModel);

        assertNotNull(savedModel);
        assertEquals(vdotGradeModel.getVdot(), savedModel.getVdot());

        verify(vdotGradeRepository, times(1)).save(any(VdotGradeModel.class));
    }

    @Test
    void getById_ExistingId_ReturnsVdotGradeModel() {
        long id = 1L;
        VdotGradeModel vdotGradeModel = new VdotGradeModel();
        vdotGradeModel.setVdot(id);

        when(vdotGradeRepository.findById(id)).thenReturn(Optional.of(vdotGradeModel));

        VdotGradeModel retrievedModel = vdotCradeService.getById(id);

        assertNotNull(retrievedModel);
        assertEquals(id, retrievedModel.getVdot());

        verify(vdotGradeRepository, times(1)).findById(id);
    }

    @Test
    void getById_NonExistingId_ThrowsNoEntityFoundException() {
        long id = 1L;

        when(vdotGradeRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoEntityFoundException.class, () -> vdotCradeService.getById(id));

        verify(vdotGradeRepository, times(1)).findById(id);
    }

    @Test
    void getAll_ReturnsListOfVdotGradeModels() {
        List<VdotGradeModel> vdotGradeModels = new ArrayList<>();
        vdotGradeModels.add(new VdotGradeModel());
        vdotGradeModels.add(new VdotGradeModel());

        when(vdotGradeRepository.findAll()).thenReturn(vdotGradeModels);

        List<VdotGradeModel> retrievedModels = vdotCradeService.getAll();

        assertNotNull(retrievedModels);
        assertEquals(2, retrievedModels.size());

        verify(vdotGradeRepository, times(1)).findAll();
    }

    @Test
    void deleteById_ExistingId_DeletesModel() {
        long id = 1L;

        when(vdotGradeRepository.existsById(id)).thenReturn(true);

        vdotCradeService.deleteById(id);

        verify(vdotGradeRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteById_NonExistingId_ThrowsNoEntityFoundException() {
        long id = 1L;

        when(vdotGradeRepository.existsById(id)).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> vdotCradeService.deleteById(id));

        verify(vdotGradeRepository, times(0)).deleteById(id);
    }

    @Test
    void update_ExistingModel_ReturnsUpdatedModel() {
        VdotGradeModel vdotGradeModel = new VdotGradeModel();
        vdotGradeModel.setVdot(1L);

        when(vdotGradeRepository.existsById(vdotGradeModel.getVdot())).thenReturn(true);
        when(vdotGradeRepository.save(any(VdotGradeModel.class))).thenReturn(vdotGradeModel);

        VdotGradeModel updatedModel = vdotCradeService.update(vdotGradeModel);

        assertNotNull(updatedModel);
        assertEquals(vdotGradeModel.getVdot(), updatedModel.getVdot());

        verify(vdotGradeRepository, times(1)).save(any(VdotGradeModel.class));
    }

    @Test
    void update_NonExistingModel_ThrowsNoEntityFoundException() {
        VdotGradeModel vdotGradeModel = new VdotGradeModel();
        vdotGradeModel.setVdot(1L);

        when(vdotGradeRepository.existsById(vdotGradeModel.getVdot())).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> vdotCradeService.update(vdotGradeModel));

        verify(vdotGradeRepository, times(0)).save(any(VdotGradeModel.class));
    }

    // Additional tests for findClosestTimeByDistanceAndTime method...
}
