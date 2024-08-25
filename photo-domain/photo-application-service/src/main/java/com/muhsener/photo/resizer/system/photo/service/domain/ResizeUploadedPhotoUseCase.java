package com.muhsener.photo.resizer.system.photo.service.domain;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.dto.UploadedPhotoRequest;
import com.muhsener.photo.resizer.system.photo.service.domain.service.PhotoResizerService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ResizeUploadedPhotoUseCase {

    private final PhotoResizerService photoResizerService;

    public ResizeUploadedPhotoUseCase(PhotoResizerService photoResizerService) {
        this.photoResizerService = photoResizerService;
    }

    @Transactional
    public PhotoDTO resize(UploadedPhotoRequest request) {
        return null;
    }
}
