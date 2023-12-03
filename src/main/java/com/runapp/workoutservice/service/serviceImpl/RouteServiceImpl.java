package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.repository.RouteRepository;
import com.runapp.workoutservice.service.serviceTemplate.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements GenericService<RouteModel> {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteModel add(RouteModel entity) {
        return routeRepository.save(entity);
    }

    @Override
    public RouteModel getById(Long id) {
        return routeRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Route with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RouteModel> getAll() {
        return routeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!routeRepository.existsById(id)) {
            throw new NoEntityFoundException("Route with id: " + id + " doesn't exist");
        }
        routeRepository.deleteById(id);
    }

    @Override
    public RouteModel update(RouteModel entity) {
        if (!routeRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("Route with id: " + entity.getId() + " doesn't exist");
        }
        return routeRepository.save(entity);
    }
}
