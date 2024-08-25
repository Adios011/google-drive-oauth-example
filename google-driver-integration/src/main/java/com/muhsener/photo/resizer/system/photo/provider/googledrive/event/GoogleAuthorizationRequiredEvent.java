package com.muhsener.photo.resizer.system.photo.provider.googledrive.event;

import com.muhsener.photo.resizer.system.photo.service.domain.event.AuthorizationRequiredEvent;

public class GoogleAuthorizationRequiredEvent implements AuthorizationRequiredEvent {

    private String userId ;
    private String authorizationLink;
    private String callBackURI;

    public GoogleAuthorizationRequiredEvent(String userId, String authorizationLink, String callBackURI) {
        this.userId = userId;
        this.authorizationLink = authorizationLink;
        this.callBackURI = callBackURI;
    }


    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthorizationLink() {
        return authorizationLink;
    }

    @Override
    public String getCallbackURI() {
        return callBackURI;
    }

    public void setAuthorizationLink(String authorizationLink) {
        this.authorizationLink = authorizationLink;
    }

    public String getCallBackURI() {
        return callBackURI;
    }

    public void setCallBackURI(String callBackURI) {
        this.callBackURI = callBackURI;
    }
}
