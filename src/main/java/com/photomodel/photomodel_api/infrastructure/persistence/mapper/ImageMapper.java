package com.photomodel.photomodel_api.infrastructure.persistence.mapper;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.ImageJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageJpaEntity toEntity(Image image){

        ImageJpaEntity imageJpaEntity = new ImageJpaEntity();
        imageJpaEntity.setUrl(image.getUrl());
        imageJpaEntity.setUserId(image.getUserId());

        return imageJpaEntity;
    }

    public Image toDomain(ImageJpaEntity imageJpaEntity){
        Image image = new Image();
        image.setUrl(imageJpaEntity.getUrl());
        image.setUserId(imageJpaEntity.getUserId());
        return image;
    }
}
