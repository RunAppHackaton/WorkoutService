package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.TerrainTypeModel;
import com.runapp.workoutservice.repository.TerrainTypeRepository;
import com.runapp.workoutservice.service.TerrainTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainTypeServiceImpl implements TerrainTypeService {

    private final TerrainTypeRepository terrainTypeRepository;

    @Autowired
    public TerrainTypeServiceImpl(TerrainTypeRepository terrainTypeRepository) {
        this.terrainTypeRepository = terrainTypeRepository;
    }

    @Override
    public TerrainTypeModel add(TerrainTypeModel entity) {
        return terrainTypeRepository.save(entity);
    }

    @Override
    public TerrainTypeModel getById(Long id) {
        return terrainTypeRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("TerrainType with id: " + id + " doesn't exist"));
    }

    @Override
    public List<TerrainTypeModel> getAll() {
        return terrainTypeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!terrainTypeRepository.existsById(id)) {
            throw new NoEntityFoundException("TerrainType with id: " + id + " doesn't exist");
        }
        terrainTypeRepository.deleteById(id);
    }

    @Override
    public TerrainTypeModel update(TerrainTypeModel entity) {
        if (!terrainTypeRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("TerrainType with id: " + entity.getId() + " doesn't exist");
        }
        return terrainTypeRepository.save(entity);
    }
}
