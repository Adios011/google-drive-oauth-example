package com.muhsener.photo.resizer.system.photo.service.domain;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.ExternalPhotoRequest;
import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import com.muhsener.photo.resizer.system.photo.service.domain.mapper.PhotoDataMapper;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyPhotoProvider;
import com.muhsener.photo.resizer.system.photo.service.domain.service.PhotoResizerService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ResizeExternalPhotoUseCase {

    private final ThirdPartyPhotoProvider thirdPartyPhotoProvider;
    private final PhotoResizerService photoResizerService;
    private final PhotoDataMapper photoDataMapper;

    public ResizeExternalPhotoUseCase(ThirdPartyPhotoProvider thirdPartyPhotoProvider,
                                      PhotoResizerService photoResizerService, PhotoDataMapper photoDataMapper) {
        this.thirdPartyPhotoProvider = thirdPartyPhotoProvider;
        this.photoResizerService = photoResizerService;
        this.photoDataMapper = photoDataMapper;
    }

    public PhotoDTO resize(ExternalPhotoRequest request) throws ThirdPartyAuthorizationException, IOException {
        String fileId = request.getFileId();

        Photo photo = thirdPartyPhotoProvider.findByFileId(request.getUserId(), fileId);
        Photo resizedPhoto = photoResizerService.resizePhoto(photo, request.getNewLength(), request.getNewWidth());

        return photoDataMapper.toDTO(resizedPhoto);


    }


}
