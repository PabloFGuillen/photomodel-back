package com.photomodel.photomodel_api.infrastructure.persistence.mapper;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserJpaEntity getEntity(User user){
        UserJpaEntity userJpaEntity = new UserJpaEntity();
        userJpaEntity.setId(user.getId());
        userJpaEntity.setRole(user.getRole());
        userJpaEntity.setUserName(user.getUserName());
        userJpaEntity.setEmail(user.getEmail());
        userJpaEntity.setLevel(user.getLevel());
        userJpaEntity.setPassword(user.getPassword());
        userJpaEntity.setImageList(user.getImageList());
        return userJpaEntity;
    }

    public User getDomain(UserJpaEntity userJpa){
        User userJpaEntity = new User();
        userJpaEntity.setId(userJpa.getId());
        userJpaEntity.setRole(userJpa.getRole());
        userJpaEntity.setUserName(userJpa.getUserName());
        userJpaEntity.setEmail(userJpa.getEmail());
        userJpaEntity.setLevel(userJpa.getLevel());
        userJpaEntity.setPassword(userJpa.getPassword());
        userJpaEntity.setImageList(userJpa.getImageList());
        return userJpaEntity;
    }
}
