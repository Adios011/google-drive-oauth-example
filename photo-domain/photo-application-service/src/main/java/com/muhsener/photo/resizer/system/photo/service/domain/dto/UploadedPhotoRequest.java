package com.muhsener.photo.resizer.system.photo.service.domain.dto;

public class UploadedPhotoRequest {

    private double newLength;
    private double newWidth;



    public double getNewLength() {
        return newLength;
    }

    public void setNewLength(double newLength) {
        this.newLength = newLength;
    }

    public double getNewWidth() {
        return newWidth;
    }

    public void setNewWidth(double newWidth) {
        this.newWidth = newWidth;
    }
}
