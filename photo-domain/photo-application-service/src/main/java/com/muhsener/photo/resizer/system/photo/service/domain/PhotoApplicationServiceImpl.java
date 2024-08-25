package com.muhsener.photo.resizer.system.photo.service.domain;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.ExternalPhotoRequest;
import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.dto.UploadedPhotoRequest;
import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.input.PhotoApplicationService;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("photoApplicationService")
public class PhotoApplicationServiceImpl implements PhotoApplicationService {

    private final ResizeUploadedPhotoUseCase resizeUploadedPhotoUseCase;
    private final ResizeExternalPhotoUseCase resizeExternalPhotoUseCase;
    private final FindPhotosFromExternalServiceUseCase findPhotosFromExternalServiceUseCase;

    public PhotoApplicationServiceImpl(ResizeUploadedPhotoUseCase resizeUploadedPhotoUseCase,
                                       ResizeExternalPhotoUseCase resizeExternalPhotoUseCase,
                                       FindPhotosFromExternalServiceUseCase findPhotosFromExternalServiceUseCase) {
        this.resizeUploadedPhotoUseCase = resizeUploadedPhotoUseCase;
        this.resizeExternalPhotoUseCase = resizeExternalPhotoUseCase;
        this.findPhotosFromExternalServiceUseCase = findPhotosFromExternalServiceUseCase;
    }

    @Override
    public PhotoDTO resize(UploadedPhotoRequest request) {
       return  resizeUploadedPhotoUseCase.resize(request);
    }

    @Override
    public PhotoDTO resize(ExternalPhotoRequest request) throws ThirdPartyAuthorizationException, IOException {
        return resizeExternalPhotoUseCase.resize(request);
    }

    @Override
    public List<PhotoDTO> findPhotosFromExternalServices(String userId) throws IOException, ThirdPartyAuthorizationException {
       return  findPhotosFromExternalServiceUseCase.findPhotosFromExternalService(userId);
    }
}
