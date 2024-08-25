package com.muhsener.photo.resizer.system.photo.provider.googledrive.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Configuration
public class GoogleDriveAPIConfig {


    @Value("${google.oauth.callback.uri}")
    private String CALLBACK_URI;

    @Value("${google.secret.key.path}")
    private Resource gdSecretKeys;

    @Value("file:${google.credentials.folder.path}")
    private Resource credentialsFolder;

    @Bean
    public HttpTransport httpTransport(){
        return new NetHttpTransport();
    }

    @Bean
    public JsonFactory jsonFactory(){
        return GsonFactory.getDefaultInstance();
    }

    public List<String> scopes(){
        return Collections.singletonList(DriveScopes.DRIVE);
    }

    @Bean
    public GoogleClientSecrets googleClientSecrets() throws IOException {
        return GoogleClientSecrets.load(jsonFactory() , new InputStreamReader(gdSecretKeys.getInputStream()));
    }

    @Bean
    public GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow() throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(httpTransport() , jsonFactory() , googleClientSecrets(),scopes())
                .setDataStoreFactory(new FileDataStoreFactory(credentialsFolder.getFile()))
                .build();
    }






}
