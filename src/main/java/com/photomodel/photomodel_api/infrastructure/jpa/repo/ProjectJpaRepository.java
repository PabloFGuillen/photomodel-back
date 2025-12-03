package com.photomodel.photomodel_api.infrastructure.jpa.repo;

import com.photomodel.photomodel_api.infrastructure.jpa.ProjectJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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

    public List<ProjectJpaEntity> getProjectListNearLocation(Double latitude, Double longitude, Integer kilometers){
        return null;
    }

}
