package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.usecase.port.input.user.UploadPhotoUserCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadPhotoUserCaseService implements UploadPhotoUserCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void uploadPhotoUseCase(List<Image> imageList, String userId){
            userRepository.uploadPhotoUseCase(imageList, userId);
    }
}
