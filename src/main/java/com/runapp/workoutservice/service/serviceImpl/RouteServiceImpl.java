package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.repository.RouteRepository;
import com.runapp.workoutservice.service.serviceTemplate.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements GenericService<RouteModel> {

    private final RouteRepository routeRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(RouteServiceImpl.class);

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteModel add(RouteModel entity) {
        LOGGER.info("Route add: {}", entity);
        return routeRepository.save(entity);
    }

    @Override
    public RouteModel getById(Long id) {
        LOGGER.info("Route get by id: {}", id);
        return routeRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Route with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RouteModel> getAll() {
        LOGGER.info("Route get all");
        return routeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("Route delete by id: {}", id);
        if (!routeRepository.existsById(id)) {
            throw new NoEntityFoundException("Route with id: " + id + " doesn't exist");
        }
        routeRepository.deleteById(id);
    }

    @Override
    public RouteModel update(RouteModel entity) {
        LOGGER.info("Route update: {}", entity);
        if (!routeRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("Route with id: " + entity.getId() + " doesn't exist");
        }
        return routeRepository.save(entity);
    }
}
