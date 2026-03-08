package com.photomodel.photomodel_api.infrastructure.jpa;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import com.photomodel.photomodel_api.utils.enums.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "User")
public class UserJpaEntity {

    @Id
    private String id;

    private String username;

    private String email;

    private String password;

    @Field("level")
    private UserType level;

    @Field("role")
    private UserRole role;

    private Boolean emailValidated;

    private List<Image> imageList = new ArrayList<>();


    public Boolean getEmailValidated() {
        return emailValidated;
    }

    public void setEmailValidated(Boolean emailValidated) {
        this.emailValidated = emailValidated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getLevel() {
        return level;
    }

    public void setLevel(UserType level) {
        this.level = level;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
