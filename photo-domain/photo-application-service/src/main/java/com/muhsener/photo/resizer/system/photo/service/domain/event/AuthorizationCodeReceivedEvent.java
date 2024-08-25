package com.muhsener.photo.resizer.system.photo.service.domain.event;

public class AuthorizationCodeReceivedEvent {

    private String userId;
    private String authorizationCode;

    public AuthorizationCodeReceivedEvent(String userId, String authorizationCode) {
        this.userId = userId;
        this.authorizationCode = authorizationCode;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }
}
