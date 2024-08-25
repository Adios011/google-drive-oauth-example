package com.muhsener.photo.resizer.system.exception.handler;

import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ThirdPartyAuthorizationException.class)
    public void handleThirdPartyAuthorizationException(ThirdPartyAuthorizationException ex , HttpServletResponse response) throws Exception {
        response.sendRedirect(ex.getAuthorizationLink());
    }
}
