package com.muhsener.photo.resizer.system.photo.provider.googledrive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.muhsener.photo.resizer.system.photo.provider.googledrive.exception.GoogleDriveAuthorizationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleAuthorizationService {

    @Value("${google.oauth.callback.uri}")
    private String CALLBACK_URI;

    private final GoogleAuthorizationCodeFlow flow;


    public GoogleAuthorizationService(GoogleAuthorizationCodeFlow flow) {
        this.flow = flow;
    }

    public Credential validateAuthorization(String userId) throws IOException, GoogleDriveAuthorizationException {

        Credential credential = flow.loadCredential(userId);
        if (credential == null || !credential.refreshToken()) {
            GoogleAuthorizationCodeRequestUrl authorizationLink = flow.newAuthorizationUrl();
            String link = authorizationLink.setRedirectUri(CALLBACK_URI)
                    .setAccessType("offline").
                    setState(userId)
                    .build();


            throw new GoogleDriveAuthorizationException("Authorization is required",
                    userId, link, CALLBACK_URI);
        }

        return credential;


    }


    public void requestAndSaveTokens(String userId, String code) throws IOException {
        GoogleTokenResponse googleTokenResponse = flow.newTokenRequest(code)
                .setRedirectUri(CALLBACK_URI).execute();

        flow.createAndStoreCredential(googleTokenResponse, userId);
    }
}
