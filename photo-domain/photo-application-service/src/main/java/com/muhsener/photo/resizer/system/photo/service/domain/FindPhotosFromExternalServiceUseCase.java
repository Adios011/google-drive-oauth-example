package com.muhsener.photo.resizer.system.photo.service.domain;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyPhotoProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindPhotosFromExternalServiceUseCase {

    private final ThirdPartyPhotoProvider thirdPartyPhotoProvider;

    public FindPhotosFromExternalServiceUseCase(ThirdPartyPhotoProvider thirdPartyPhotoProvider) {
        this.thirdPartyPhotoProvider = thirdPartyPhotoProvider;
    }

    public List<PhotoDTO> findPhotosFromExternalService(String userId) throws IOException, ThirdPartyAuthorizationException {
          List<Photo> photos =  thirdPartyPhotoProvider.findAll(userId);

          return photos.stream().map(photo ->
              new PhotoDTO(photo.getId() , photo.getName() , photo.getThumbnailLink()))
                  .collect(Collectors.toList());


    }
}
