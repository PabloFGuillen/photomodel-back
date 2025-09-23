package com.photomodel.photomodel_api.infrastructure.persistence.repository;

import com.photomodel.photomodel_api.domain.Proyect;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.ProyectJpaEntity;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.repo.ApplicationJpaRepository;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.repo.ProyectJpaRepository;
import com.photomodel.photomodel_api.infrastructure.persistence.mapper.ProyectMapper;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProyectRepositoryImpl implements ProjectRepository {

    @Autowired
    private ProyectMapper proyectMapper;

    @Autowired
    private ProyectJpaRepository proyectJpaRepository;

    @Override
    public void insertProyect(Proyect proyect) {
        ProyectJpaEntity proyectJpaEntity = proyectMapper.toEntity(proyect);

    }

    @Override
    public Proyect getProyect(String proyectId) {
        return null;
    }

    @Override
    public List<Proyect> getProyectListNearLocation(Double latitude, Double longitude, Integer kilometers) {
        return null;
    }
}
