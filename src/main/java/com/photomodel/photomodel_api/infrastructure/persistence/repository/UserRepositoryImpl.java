package com.photomodel.photomodel_api.infrastructure.persistence.repository;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.UserJpaEntity;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.repo.UserJpaRepository;
import com.photomodel.photomodel_api.infrastructure.persistence.mapper.UserMapper;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        UserJpaEntity userJpaEntity = userMapper.getEntity(user);

        return userMapper.getDomain(userJpaEntity);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUsertByUsername(String username) {
        return null;
    }

    @Override
    public boolean existsUserByEmailOrUsername(String email, String username) {
        return false;
    }

    @Override
    public void uploadPhotoUseCase(List<Image> imageList, String userId) {

    }

    @Override
    public void updateUser(User user) {

    }
}
