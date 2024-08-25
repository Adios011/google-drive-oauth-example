package com.muhsener.photo.resizer.system.photo.provider.googledrive.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.muhsener.photo.resizer.system.photo.provider.googledrive.GoogleAuthorizationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OAuthController {


    private final GoogleAuthorizationService googleAuthorizationService;


    public OAuthController(GoogleAuthorizationService googleAuthorizationService) {
        this.googleAuthorizationService = googleAuthorizationService;
    }

        @GetMapping("google/callback")
        public void handleGoogleCallback(@RequestParam(name = "code") String code,
                                         @RequestParam(name = "state") String userId,
                                         HttpServletResponse response) throws IOException {
            googleAuthorizationService.requestAndSaveTokens(userId , code);
            response.sendRedirect("http://localhost:8080");
        }
}
