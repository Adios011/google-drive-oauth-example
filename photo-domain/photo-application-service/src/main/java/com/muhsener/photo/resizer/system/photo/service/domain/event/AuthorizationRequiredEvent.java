package com.muhsener.photo.resizer.system.photo.service.domain.event;

public interface AuthorizationRequiredEvent {
     String getUserId();
     String getAuthorizationLink();
     String getCallbackURI();
}
