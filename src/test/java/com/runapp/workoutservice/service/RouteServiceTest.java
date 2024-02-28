package com.runapp.workoutservice.service;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.repository.RouteRepository;
import com.runapp.workoutservice.service.serviceImpl.RouteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RouteServiceTest {

    @Mock
    private RouteRepository routeRepositoryMock;

    @InjectMocks
    private RouteServiceImpl routeService;

    public RouteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRoute() {
        RouteModel route = new RouteModel();
        when(routeRepositoryMock.save(route)).thenReturn(route);

        RouteModel result = routeService.add(route);

        assertNotNull(result);
        assertEquals(route, result);
    }

    @Test
    void testGetRouteById() {
        long id = 1;
        RouteModel route = new RouteModel();
        route.setId(id);
        when(routeRepositoryMock.findById(id)).thenReturn(Optional.of(route));

        RouteModel result = routeService.getById(id);

        assertNotNull(result);
        assertEquals(route, result);
    }

    @Test
    void testGetRouteByIdNotFound() {
        long id = 1;
        when(routeRepositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoEntityFoundException.class, () -> routeService.getById(id));
    }

    @Test
    void testGetAllRoutes() {
        List<RouteModel> routeList = new ArrayList<>();
        routeList.add(new RouteModel());
        routeList.add(new RouteModel());
        when(routeRepositoryMock.findAll()).thenReturn(routeList);

        List<RouteModel> result = routeService.getAll();

        assertNotNull(result);
        assertEquals(routeList.size(), result.size());
    }

    @Test
    void testDeleteRouteById() {
        long id = 1;
        when(routeRepositoryMock.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> routeService.deleteById(id));
        verify(routeRepositoryMock, times(1)).deleteById(id);
    }

    @Test
    void testDeleteRouteByIdNotFound() {
        long id = 1;
        when(routeRepositoryMock.existsById(id)).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> routeService.deleteById(id));
        verify(routeRepositoryMock, never()).deleteById(id);
    }

    @Test
    void testUpdateRoute() {
        RouteModel route = new RouteModel();
        route.setId(1L);
        when(routeRepositoryMock.existsById(route.getId())).thenReturn(true);
        when(routeRepositoryMock.save(route)).thenReturn(route);

        RouteModel result = routeService.update(route);

        assertNotNull(result);
        assertEquals(route, result);
    }

    @Test
    void testUpdateRouteNotFound() {
        RouteModel route = new RouteModel();
        route.setId(1L);
        when(routeRepositoryMock.existsById(route.getId())).thenReturn(false);

        assertThrows(NoEntityFoundException.class, () -> routeService.update(route));
        verify(routeRepositoryMock, never()).save(route);
    }
}

