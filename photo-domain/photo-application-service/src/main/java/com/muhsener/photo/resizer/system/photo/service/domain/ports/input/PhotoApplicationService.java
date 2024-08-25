package com.muhsener.photo.resizer.system.photo.service.domain.ports.input;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.ExternalPhotoRequest;
import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.dto.UploadedPhotoRequest;
import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;

import java.io.IOException;
import java.util.List;

public interface PhotoApplicationService {


    PhotoDTO resize(UploadedPhotoRequest request);

    PhotoDTO resize(ExternalPhotoRequest request) throws ThirdPartyAuthorizationException, IOException;

    List<PhotoDTO> findPhotosFromExternalServices(String userId) throws IOException, ThirdPartyAuthorizationException;

}
