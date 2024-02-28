package com.runapp.workoutservice.service;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.IntervalModel;
import com.runapp.workoutservice.repository.IntervalsRepository;
import com.runapp.workoutservice.service.serviceImpl.IntervalsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IntervalsServiceTest {

    @Mock
    private IntervalsRepository intervalsRepositoryMock;

    @InjectMocks
    private IntervalsServiceImpl intervalsService;

    public IntervalsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddInterval() {
        IntervalModel interval = new IntervalModel();
        when(intervalsRepositoryMock.save(interval)).thenReturn(interval);

        IntervalModel result = intervalsService.add(interval);

        assertNotNull(result);
        assertEquals(interval, result);
    }

    @Test
    void testGetIntervalById() {
        long id = 1;
        IntervalModel interval = new IntervalModel();
        interval.setId(id);
        when(intervalsRepositoryMock.findById(id)).thenReturn(Optional.of(interval));

        IntervalModel result = intervalsService.getById(id);

        assertNotNull(result);
        assertEquals(interval, result);
    }

    @Test
    void testGetIntervalByIdNotFound() {
        long id = 1;
        when(intervalsRepositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoEntityFoundException.class, () -> intervalsService.getById(id));
    }

    @Test
    void testGetAllIntervals() {
        List<IntervalModel> intervalList = new ArrayList<>();
        intervalList.add(new IntervalModel());
        intervalList.add(new IntervalModel());
        when(intervalsRepositoryMock.findAll()).thenReturn(intervalList);

        List<IntervalModel> result = intervalsService.getAll();

        assertNotNull(result);
        assertEquals(intervalList.size(), result.size());
    }

    @Test
    void testDeleteIntervalById() {
        long id = 1;
        when(intervalsRepositoryMock.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> intervalsService.deleteById(id));
        verify(intervalsRepositoryMock, times(1)).deleteById(id);
    }

    @Test
    void testDeleteIntervalByIdNotFound() {
        long id = 1;
        when(intervalsRepositoryMock.existsById(id)).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> intervalsService.deleteById(id));
        verify(intervalsRepositoryMock, never()).deleteById(id);
    }

    @Test
    void testUpdateInterval() {
        IntervalModel interval = new IntervalModel();
        interval.setId(1L);
        when(intervalsRepositoryMock.existsById(interval.getId())).thenReturn(true);
        when(intervalsRepositoryMock.save(interval)).thenReturn(interval);

        IntervalModel result = intervalsService.update(interval);

        assertNotNull(result);
        assertEquals(interval, result);
    }

    @Test
    void testUpdateIntervalNotFound() {
        IntervalModel interval = new IntervalModel();
        interval.setId(1L);
        when(intervalsRepositoryMock.existsById(interval.getId())).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> intervalsService.update(interval));
        verify(intervalsRepositoryMock, never()).save(interval);
    }
}

