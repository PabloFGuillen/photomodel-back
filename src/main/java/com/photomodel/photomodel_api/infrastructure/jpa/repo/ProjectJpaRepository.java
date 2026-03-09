package com.photomodel.photomodel_api.infrastructure.jpa.repo;

import com.photomodel.photomodel_api.infrastructure.jpa.ProjectJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProjectJpaRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void insertProject(ProjectJpaEntity projectJpaEntity){
        mongoTemplate.save(projectJpaEntity);

    }

    public  ProjectJpaEntity getProject(String projectId){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(projectId));

        return mongoTemplate.findOne(query, ProjectJpaEntity.class);
    }

    public List<ProjectJpaEntity> getProjectListNearLocation(String title, String username, Integer distance, Boolean paid, Instant date, Double latitude, Double longitude){
        Query query = new Query();

        GeoJsonPoint point = new GeoJsonPoint(longitude, latitude);
        Distance distanceDto = new Distance(10, Metrics.KILOMETERS);
        query.addCriteria(Criteria.where("geoLocation").nearSphere(point).maxDistance(distanceDto.getNormalizedValue()));

        if(title != null){
            query.addCriteria(Criteria.where("title").is(title));
        }

        if(username != null){
            query.addCriteria(Criteria.where("username").is(username));
        }

        if(date != null){
            query.addCriteria(Criteria.where("date").is(date));
        }

        if(paid){
            query.addCriteria(Criteria.where("paid").is(paid));
        }

        return mongoTemplate.find(query, ProjectJpaEntity.class);

    }

}
