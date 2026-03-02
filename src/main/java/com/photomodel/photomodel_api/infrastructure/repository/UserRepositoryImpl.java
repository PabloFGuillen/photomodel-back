package com.photomodel.photomodel_api.infrastructure.repository;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.infrastructure.jpa.ImageJpaEntity;
import com.photomodel.photomodel_api.infrastructure.jpa.UserJpaEntity;
import com.photomodel.photomodel_api.infrastructure.jpa.repo.UserJpaRepository;
import com.photomodel.photomodel_api.infrastructure.mapper.ImageMapper;
import com.photomodel.photomodel_api.infrastructure.mapper.UserMapper;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        UserJpaEntity userJpaEntity = userMapper.getEntity(user);

        userJpaRepository.insertUser(userJpaEntity);
        return userMapper.getDomain(userJpaEntity);
    }

    @Override
    public User getUserByEmail(String email) {
        UserJpaEntity userJpaEntity = userJpaRepository.getUserByEmail(email);
        return userMapper.getDomain(userJpaEntity);
    }

    @Override
    public User getUserById(Long id) {
        UserJpaEntity userJpaEntity = userJpaRepository.getUserById(id);
        return userMapper.getDomain(userJpaEntity);
    }

    @Override
    public User getUsertByUsername(String username) {
        UserJpaEntity userJpaEntity = userJpaRepository.getUsertByUsername(username);
        return userMapper.getDomain(userJpaEntity);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userJpaRepository.existsUserByEmail(email);
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return userJpaRepository.existsUserByUsername(username);
    }

    @Override
    public void uploadPhotoUseCase(List<Image> imageList, String userId) {
        List<ImageJpaEntity> imageJpaEntities = new ArrayList<>();
        for(Image image: imageList){
            ImageJpaEntity imageJpaEntity = imageMapper.toEntity(image);
            imageJpaEntities.add(imageJpaEntity);
        }

        userJpaRepository.uploadPhotoUseCase(imageList, userId);
    }

    @Override
    public void updateUser(User user) {
        UserJpaEntity userJpaEntity = userMapper.getEntity(user);
        userJpaRepository.updateUser(userJpaEntity);
    }

}
