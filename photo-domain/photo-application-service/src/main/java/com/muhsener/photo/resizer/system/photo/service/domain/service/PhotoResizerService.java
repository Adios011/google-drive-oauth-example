package com.muhsener.photo.resizer.system.photo.service.domain.service;

import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;

import java.io.IOException;

public interface PhotoResizerService {

     Photo resizePhoto(Photo photo , double newLength, double newWidth) throws IOException;
}
