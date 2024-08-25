package com.muhsener.photo.resizer.system.photo.service.domain.mapper;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import org.springframework.stereotype.Component;

@Component
public class PhotoDataMapper {


    public PhotoDTO toDTO(Photo resizedPhoto) {
        PhotoDTO dto = new PhotoDTO();
        dto.setId(resizedPhoto.getId());
        dto.setBytes(resizedPhoto.getBytes());
        dto.setLength(resizedPhoto.getWidth());
        dto.setWidth(resizedPhoto.getWidth());
        dto.setName(resizedPhoto.getName());


        return dto;

    }
}

