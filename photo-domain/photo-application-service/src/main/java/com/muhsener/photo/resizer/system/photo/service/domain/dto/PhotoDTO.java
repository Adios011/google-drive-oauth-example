package com.muhsener.photo.resizer.system.photo.service.domain.dto;

public class PhotoDTO {

    private String id ;
    private String name;
    private String thumbnailLink;
    private byte[] bytes;
    private double length;
    private double width;


    public PhotoDTO() {
    }

    public PhotoDTO(String id, String name, String thumbnailLink) {
        this.id = id;
        this.name = name;
        this.thumbnailLink = thumbnailLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
