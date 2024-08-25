package com.muhsener.photo.resizer.system.photo.provider.googledrive.event.listener;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.muhsener.photo.resizer.system.photo.service.domain.event.AuthorizationCodeReceivedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthorizationCodeReceivedEventHandler {

    private final GoogleAuthorizationCodeFlow authorizationCodeFlow;

    @Value("${google.oauth.callback.uri}")
    private String CALLBACK_URI;


    public AuthorizationCodeReceivedEventHandler(GoogleAuthorizationCodeFlow authorizationCodeFlow) {
        this.authorizationCodeFlow = authorizationCodeFlow;
    }

    @EventListener
    public void handle(AuthorizationCodeReceivedEvent event) throws IOException {
        GoogleTokenResponse tokenResponse = authorizationCodeFlow.newTokenRequest(event.getAuthorizationCode())
                .setRedirectUri(CALLBACK_URI).execute();
        authorizationCodeFlow.createAndStoreCredential(tokenResponse , event.getUserId());
    }
}
