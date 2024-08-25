package com.muhsener.photo.resizer.system.photo.service.domain.entity;

import java.io.InputStream;
import java.io.OutputStream;

public class Photo {

    private String id ;
    private String name;
    private String thumbnailLink;
    private byte[] bytes;
    private double length;
    private double width;

    private InputStream inputStream;
    private OutputStream outputStream;

    private String mimeType;


    private Photo(Builder builder) {
        id = builder.id;
        name = builder.name;
        bytes = builder.bytes;
        length = builder.length;
        width = builder.width;
        thumbnailLink = builder.thumbnailLink;
        inputStream = builder.inputStream;
        outputStream = builder.outputStream;
        mimeType = builder.mimeType;
    }


    public String getId() {
        return id;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public String getMimeType() {
        return mimeType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getName() {
        return name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String id;
        private String name;
        private String thumbnailLink;
        private byte[] bytes;
        private double length;
        private double width;
        private InputStream inputStream;
        private OutputStream outputStream;
        private String mimeType;


        private Builder() {
        }



        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder thumbnailLink(String val){
            thumbnailLink = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder bytes(byte[] val) {
            bytes = val;
            return this;
        }

        public Builder length(double val) {
            length = val;
            return this;
        }

        public Builder width(double val) {
            width = val;
            return this;
        }

        public Builder inputStream(InputStream val){
            inputStream = val ;
            return this;
        }
        public Builder outputStream(OutputStream val){
            outputStream = val ;
            return this;
        }

        public Builder mimeType(String val){
            mimeType = val;
            return this;
        }

        public Photo build() {
            return new Photo(this);
        }
    }
}
