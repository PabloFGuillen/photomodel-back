package com.photomodel.photomodel_api.infrastructure.persistence.mapper;

import com.photomodel.photomodel_api.domain.Proyect;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.ProyectJpaEntity;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

@Component
public class ProyectMapper {

    public ProyectJpaEntity toEntity(Proyect proyect){
        ProyectJpaEntity proyectJpaEntity = new ProyectJpaEntity();
        proyectJpaEntity.setId(proyect.getId());
        proyectJpaEntity.setPaidProject(proyect.isPaidProject());
        proyectJpaEntity.setUserId(proyect.getUserId());
        proyectJpaEntity.setDescription(proyect.getDescription());
        proyectJpaEntity.setTitle(proyect.getTitle());
        proyectJpaEntity.setDate(proyect.getDate());
        if(proyect.getLatitude() != null && proyect.getLatitude() != null){
            GeoJsonPoint geoJsonPoint = new GeoJsonPoint(proyect.getLongitude(), proyect.getLatitude());
            proyectJpaEntity.setGeoLocation(geoJsonPoint);
        }

        return proyectJpaEntity;
    }

    public Proyect toDomain(ProyectJpaEntity proyectJpaEntity){
        Proyect proyect = new Proyect();
        proyectJpaEntity.setId(proyect.getId());
        proyectJpaEntity.setPaidProject(proyect.isPaidProject());
        proyectJpaEntity.setUserId(proyect.getUserId());
        proyectJpaEntity.setDescription(proyect.getDescription());
        proyectJpaEntity.setTitle(proyect.getTitle());
        proyectJpaEntity.setDate(proyect.getDate());
        if(proyectJpaEntity.getGeoLocation() != null){
            GeoJsonPoint geoJsonPoint = proyectJpaEntity.getGeoLocation();
            proyect.setLatitude(geoJsonPoint.getY());
            proyect.setLongitude(geoJsonPoint.getX());
        }
        return proyect;
    }
}