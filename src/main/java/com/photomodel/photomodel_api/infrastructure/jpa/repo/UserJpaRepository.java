package com.photomodel.photomodel_api.infrastructure.jpa.repo;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.infrastructure.jpa.UserJpaEntity;
import com.photomodel.photomodel_api.utils.JasyptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJpaRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private JasyptUtils jasyptUtils;

    public void insertUser(UserJpaEntity userJpaEntity){
        mongoTemplate.save(userJpaEntity);
    }

    public UserJpaEntity getUserByEmail(String email){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        return mongoTemplate.findOne(query, UserJpaEntity.class);
    }

    public UserJpaEntity getUserById(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        return mongoTemplate.findOne(query, UserJpaEntity.class);
    }

    public UserJpaEntity getUsertByUsername(String username){
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(username));

        return mongoTemplate.findOne(query, UserJpaEntity.class);
    }

    public boolean existsUserByEmail(String email){
        boolean existsUsertWithEmail = false;

        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        UserJpaEntity userJpaEntity = mongoTemplate.findOne(query, UserJpaEntity.class);
        if(userJpaEntity != null){
            existsUsertWithEmail = true;
        }

        return existsUsertWithEmail;

    }

    public boolean existsUserByUsername(String username){
        boolean existsUsertWithEmail = false;

        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(username));

        UserJpaEntity userJpaEntity = mongoTemplate.findOne(query, UserJpaEntity.class);
        if(userJpaEntity != null){
            existsUsertWithEmail = true;
        }

        return existsUsertWithEmail;

    }

    public void uploadPhotoUseCase(List<Image> imageList, String userId){

    }

    public void updateUser(UserJpaEntity user){
        mongoTemplate.save(user);
    }


}
