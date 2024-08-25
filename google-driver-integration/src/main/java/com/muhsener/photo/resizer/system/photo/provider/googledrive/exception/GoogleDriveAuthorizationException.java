package com.muhsener.photo.resizer.system.photo.provider.googledrive.exception;

import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;

public class GoogleDriveAuthorizationException extends ThirdPartyAuthorizationException {


    public GoogleDriveAuthorizationException(String message, String userId, String authorizationLink, String callBackURI) {
        super(message, userId, authorizationLink, callBackURI);
    }



}
