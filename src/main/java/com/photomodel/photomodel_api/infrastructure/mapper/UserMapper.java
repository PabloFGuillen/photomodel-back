package com.photomodel.photomodel_api.infrastructure.mapper;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.infrastructure.jpa.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserJpaEntity getEntity(User user){
        UserJpaEntity userJpaEntity = new UserJpaEntity();
        userJpaEntity.setId(user.getId());
        userJpaEntity.setRole(user.getRole());
        userJpaEntity.setUsername(user.getUsername());
        userJpaEntity.setEmail(user.getEmail());
        userJpaEntity.setLevel(user.getLevel());
        userJpaEntity.setPassword(user.getPassword());
        userJpaEntity.setImageList(user.getImageList());
        userJpaEntity.setEmailValidated(user.getEmailValidated());

        return userJpaEntity;
    }

    public User getDomain(UserJpaEntity userJpa){
        User user = new User();
        user.setId(userJpa.getId());
        user.setRole(userJpa.getRole());
        user.setUsername(userJpa.getUsername());
        user.setEmail(userJpa.getEmail());
        user.setLevel(userJpa.getLevel());
        user.setPassword(userJpa.getPassword());
        user.setImageList(userJpa.getImageList());
        user.setEmailValidated(userJpa.getEmailValidated());
        return user;
    }
}
