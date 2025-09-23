package com.photomodel.photomodel_api.usecase.port.input.project;

import com.photomodel.photomodel_api.domain.Proyect;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListProjectsUseCase {

    List<Proyect> getProyectList(Double latitude, Double longitude, Integer kilometers);

}
