package com.photomodel.photomodel_api.usecase.port.output;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.domain.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Document(collection = "User")
public interface UserRepository {

    User save(User user);

    User getUserByEmail(String email);

    User getUserById(Long id);

    User getUsertByUsername(String username);

    boolean existsUserByEmailOrUsername(String email, String username);

    void uploadPhotoUseCase(List<Image> imageList, String userId);

    void updateUser(User user);
}
