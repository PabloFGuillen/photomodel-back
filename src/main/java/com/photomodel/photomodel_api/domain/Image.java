package com.photomodel.photomodel_api.domain;

public class Image {

    private String userId;

    private String url;

    private Boolean mainPicture = false;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(Boolean mainPicture) {
        this.mainPicture = mainPicture;
    }
}
