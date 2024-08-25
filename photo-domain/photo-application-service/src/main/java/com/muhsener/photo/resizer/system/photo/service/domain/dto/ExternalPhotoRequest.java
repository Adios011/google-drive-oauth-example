package com.muhsener.photo.resizer.system.photo.service.domain.dto;

public class ExternalPhotoRequest {

    private String userId;
    private String fileId;
    private double newLength;
    private double newWidth;


    public ExternalPhotoRequest(String userId, String fileId, double newLength, double newWidth) {
        this.userId = userId;
        this.fileId = fileId;
        this.newLength = newLength;
        this.newWidth = newWidth;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

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
