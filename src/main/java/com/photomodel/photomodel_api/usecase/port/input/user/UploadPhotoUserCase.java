package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.Image;

import java.util.List;

public interface UploadPhotoUserCase {

    void uploadPhotoUseCase(List<Image> imageList, String userId);
}
