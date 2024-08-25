package com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty;

public class ThirdPartyAuthorizationException extends Exception{

    private String userId ;
    private String authorizationLink;
    private String callBackURI;


    public ThirdPartyAuthorizationException(String message, String userId, String authorizationLink, String callBackURI) {
        super(message);
        this.userId = userId;
        this.authorizationLink = authorizationLink;
        this.callBackURI = callBackURI;
    }


    public String getUserId() {
        return userId;
    }

    public String getAuthorizationLink() {
        return authorizationLink;
    }

    public String getCallBackURI() {
        return callBackURI;
    }
}
