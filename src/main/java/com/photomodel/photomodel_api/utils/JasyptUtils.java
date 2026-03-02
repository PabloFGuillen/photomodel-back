package com.photomodel.photomodel_api.utils;

import jakarta.annotation.PostConstruct;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JasyptUtils {

    @Value("${jasypt.password.encoder}")
    private String secretKey;

    private BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    @PostConstruct
    public void init() {
        textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(secretKey);
    }


    public String encryptPassword(String password){
        if(password != null){
            return textEncryptor.encrypt(password);

        } else {
            return null;
        }
    }

    public String decryptPassword(String encryptedPassword){
        if(encryptedPassword != null){
            return textEncryptor.decrypt(encryptedPassword);

        } else {

            return null;
        }

    }
}