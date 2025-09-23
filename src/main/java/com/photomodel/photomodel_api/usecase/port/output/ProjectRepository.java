package com.photomodel.photomodel_api.usecase.port.output;

import com.photomodel.photomodel_api.domain.Proyect;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Document(collection = "Project")

public interface ProjectRepository {

    void insertProyect(Proyect proyect);

    Proyect getProyect(String proyectId);

    List<Proyect> getProyectListNearLocation(Double latitude, Double longitude, Integer kilometers);
}
