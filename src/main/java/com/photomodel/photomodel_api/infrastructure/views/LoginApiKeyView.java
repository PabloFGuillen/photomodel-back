package com.photomodel.photomodel_api.infrastructure.views;

public class LoginApiKeyView {

    private String type = "Bearer";

    private String token;


    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginApiKeyView(String token) {
        this.token = token;
    }
}
