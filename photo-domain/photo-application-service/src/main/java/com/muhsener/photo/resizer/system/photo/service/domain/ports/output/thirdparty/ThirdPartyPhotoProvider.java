package com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty;

import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;

import java.io.IOException;
import java.util.List;

public interface ThirdPartyPhotoProvider {

    List<Photo> findAll(String userId) throws IOException , ThirdPartyAuthorizationException;

    Photo findByFileId(String userId, String fileId) throws ThirdPartyAuthorizationException, IOException;

}
