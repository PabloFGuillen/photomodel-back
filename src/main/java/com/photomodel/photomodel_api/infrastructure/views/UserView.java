package com.photomodel.photomodel_api.infrastructure.views;

import com.photomodel.photomodel_api.domain.Image;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import com.photomodel.photomodel_api.utils.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserView {

    private String id;

    private String username;

    private UserType level;

    private UserRole role;

    private List<Image> imageList = new ArrayList<>();

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
