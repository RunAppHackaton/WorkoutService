package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.ShoesServiceClient;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.repository.RouteRepository;
import com.runapp.workoutservice.repository.RunSessionRepository;
import com.runapp.workoutservice.service.serviceTemplate.RunSessionService;
import com.runapp.workoutservice.utill.existHandler.ExistEnum;
import com.runapp.workoutservice.utill.existHandler.ExistHandlerRegistry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RunSessionServiceImpl implements RunSessionService {

    private final RunSessionRepository runSessionRepository;
    private final ShoesServiceClient shoesServiceClient;
    private final ExistHandlerRegistry existHandlerRegistry;

    @Override
    public RunSessionModel add(RunSessionModel entity) {
        existHandlerRegistry.handleRequest(ExistEnum.USER, entity.getUserId());
        existHandlerRegistry.handleRequest(ExistEnum.SHOES, entity.getShoesId());
        shoesServiceClient.updateMileage((long) entity.getShoesId(), entity.getDistance());

        return runSessionRepository.save(entity);
    }

    @Override
    public RunSessionModel getById(Long id) {
        return runSessionRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("RunSession with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RunSessionModel> getAll() {
        return runSessionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!runSessionRepository.existsById(id)) {
            throw new NoEntityFoundException("RunSession with id: " + id + " doesn't exist");
        }
        runSessionRepository.deleteById(id);
    }

    @Override
    public RunSessionModel update(RunSessionModel entity) {
        existHandlerRegistry.handleRequest(ExistEnum.USER, entity.getUserId());
        existHandlerRegistry.handleRequest(ExistEnum.SHOES, entity.getShoesId());

        if (!runSessionRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("RunSession with id: " + entity.getId() + " doesn't exist");
        }
        return runSessionRepository.save(entity);
    }
}
