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
import java.time.temporal.ChronoUnit;
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

    public List<ProjectJpaEntity> getProjectListNearLocation(Integer page, String title, String username, Integer distance, Boolean paid, Instant date, Double latitude, Double longitude){
        Query query = new Query();

        // 1️⃣ GeoPoint correcto
        GeoJsonPoint point = new GeoJsonPoint(longitude, latitude);
        Distance mongoDistance = new Distance(10*1000, Metrics.NEUTRAL);

        query.addCriteria(
                Criteria.where("geoLocation")
                        .nearSphere(point)
                        .maxDistance(mongoDistance.getNormalizedValue())
        );

        // 2️⃣ Filtro por proyecto abierto
        query.addCriteria(Criteria.where("closedProject").is(false));

        // 3️⃣ Filtro opcional por título
        if (title != null && !title.isEmpty()) {
            query.addCriteria(Criteria.where("title").is(title));
        }

        // 4️⃣ Filtro opcional por username
        if (username != null && !username.isEmpty()) {
            query.addCriteria(Criteria.where("userId").is(username)); // si el username es userId
        }

        // 5️⃣ Filtro opcional por fecha (por día)
        if (date != null) {
            Instant start = date.truncatedTo(ChronoUnit.DAYS);
            Instant end = start.plus(1, ChronoUnit.DAYS);
            query.addCriteria(
                    Criteria.where("date").gte(start).lt(end)
            );
        }

        // 6️⃣ Filtro opcional por pago
        if (paid != null) {
            query.addCriteria(Criteria.where("paidProject").is(paid));
        }

        // 7️⃣ Paginación 10 en 10
        int pageSize = 10;
        query.skip((long) page * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, ProjectJpaEntity.class);
    }

}
