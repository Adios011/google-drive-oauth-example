package com.muhsener.photo.resizer.system.photo.service.domain.service.impl;

import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import com.muhsener.photo.resizer.system.photo.service.domain.service.PhotoResizerService;
import com.twelvemonkeys.image.BufferedImageFactory;
import com.twelvemonkeys.imageio.plugins.jpeg.JPEGImageWriter;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import com.twelvemonkeys.imageio.plugins.webp.* ;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;


@Service("photoResizerService")
public class PhotoResizerServiceImpl implements PhotoResizerService {

    @Override
    public Photo resizePhoto(Photo photo, double newHeight, double newWidth) throws IOException {

        BufferedImage originalImage = ImageIO.read(photo.getInputStream());
        System.out.println(originalImage.getHeight());
        System.out.println(originalImage.getWidth());


        int height = originalImage.getHeight() * 2 ;
        int width = originalImage.getWidth() * 2 ;

        Image scaledImage = originalImage.getScaledInstance( width,  height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width , height , originalImage.getType());

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(scaledImage , 0 , 0 , null);
        g2d.dispose();

        System.out.println(photo.getMimeType());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream)) {
            System.out.println(Arrays.toString(ImageIO.getReaderFormatNames()));


            ImageWriter writer = ImageIO.getImageWritersByFormatName(photo.getMimeType()).next();
            ImageWriteParam jpegParams = writer.getDefaultWriteParam();

            // Optional: Set the compression quality
            jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(0.85f); // Adjust quality from 0 to 1

            writer.setOutput(imageOutputStream);
            writer.write(null, new javax.imageio.IIOImage(resizedImage, null, null), jpegParams);
            writer.dispose();
        }




        return Photo.builder()
                .bytes(outputStream.toByteArray())
                .build();
    }
}
