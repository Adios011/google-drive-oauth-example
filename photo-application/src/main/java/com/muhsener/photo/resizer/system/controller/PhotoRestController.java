package com.muhsener.photo.resizer.system.controller;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.ExternalPhotoRequest;
import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.input.PhotoApplicationService;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;
import jdk.jfr.ContentType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PhotoRestController {

    private final PhotoApplicationService photoApplicationService;

    public PhotoRestController(PhotoApplicationService photoApplicationService) {
        this.photoApplicationService = photoApplicationService;
    }

    @GetMapping("/resize/{fileId}")
    public ResponseEntity<byte[]> resizePhoto(@PathVariable(name = "fileId") String fileId) throws ThirdPartyAuthorizationException, IOException {
        ExternalPhotoRequest request = new ExternalPhotoRequest("userId" ,fileId , 500 ,500);
        PhotoDTO resizedPhoto = photoApplicationService.resize(request);

        byte[] bytes = resizedPhoto.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity(bytes, headers, HttpStatus.OK);

    }
}
