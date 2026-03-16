package com.photomodel.photomodel_api.infrastructure.jpa.repo;

import com.photomodel.photomodel_api.infrastructure.jpa.ApplicationJpaEntity;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationJpaRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertApplication(ApplicationJpaEntity applicationJpaEntity){
        mongoTemplate.save(applicationJpaEntity);
    }
    public ApplicationJpaEntity getApplication(String applicationId){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(applicationId));

        return mongoTemplate.findOne(query, ApplicationJpaEntity.class);
    }

    public void updateApplication(ApplicationJpaEntity application){

    }

    public List<ApplicationJpaEntity> getProjectApplications(String projectId, String role){
        Query query = new Query();
        query.addCriteria(Criteria.where("projectId").is(projectId).and("role").is(role));

        return mongoTemplate.find(query, ApplicationJpaEntity.class);
    }

    public ApplicationJpaEntity getApplicationByUserIdAndProject(String userId, String projectId){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        query.addCriteria(Criteria.where("projectId").is(projectId));

        return mongoTemplate.findOne(query, ApplicationJpaEntity.class);
    }

    public List<ApplicationJpaEntity> getPendingApplicationsToProjectUseCase(String projectId){
        Query query = new Query();
        query.addCriteria(Criteria.where("projectId").is(projectId));
        query.addCriteria(Criteria.where("status").is(ProjectStatus.PENDING));
        return mongoTemplate.find(query, ApplicationJpaEntity.class);
    }

}
