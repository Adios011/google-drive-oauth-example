package com.muhsener.photo.resizer.system.photo.provider.googledrive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.muhsener.photo.resizer.system.photo.provider.googledrive.exception.GoogleDriveAuthorizationException;
import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyPhotoProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleDrivePhotoProvider implements ThirdPartyPhotoProvider {

    private final GoogleAuthorizationService googleAuthorizationService;

    private final GoogleAuthorizationCodeFlow flow;
    private final HttpTransport HTTP_TRANSPORT;
    private final JsonFactory JSON_FACTORY;

    @Value("${application.name}")
    private String APPLICATION_NAME;


    public GoogleDrivePhotoProvider(GoogleAuthorizationService googleAuthorizationService,
                                    GoogleAuthorizationCodeFlow flow, HttpTransport httpTransport, JsonFactory jsonFactory) {
        this.googleAuthorizationService = googleAuthorizationService;
        this.flow = flow;
        HTTP_TRANSPORT = httpTransport;
        JSON_FACTORY = jsonFactory;
    }


    public Drive initDrive(Credential credential) {
        return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

    }

    @Override
    public List<Photo> findAll(String userId) throws IOException, GoogleDriveAuthorizationException {
        Credential credential = googleAuthorizationService.validateAuthorization(userId);
        Drive drive = initDrive(credential);

        FileList fileList = drive.files().list().setFields("files(id,name,thumbnailLink)").execute();

        List<Photo> photos = new ArrayList<>();


        for (File file : fileList.getFiles()) {
            System.out.println(file.getThumbnailLink());
            Photo photo = Photo.builder()
                    .id(file.getId())
                    .name(file.getName())
                    .thumbnailLink(file.getThumbnailLink())
                    .build();
            photos.add(photo);
        }

        return photos;

    }

    @Override
    public Photo findByFileId(String userId, String fileId) throws GoogleDriveAuthorizationException, IOException {
        Credential credential = googleAuthorizationService.validateAuthorization(userId);
        Drive drive = initDrive(credential);

        File file = drive.files().get(fileId).setFields("mimeType").execute();

        OutputStream outputStream = new ByteArrayOutputStream();
//        drive.files().get(fileId).executeMediaAndDownloadTo(outputStream);
        InputStream is = drive.files().get(fileId).executeMediaAsInputStream();

        String mimeType = file.getMimeType();
        String formatType = mimeType.substring(mimeType.indexOf("/") + 1);

        System.out.println("formatType --> " + formatType);
        return Photo.builder()
                .id(fileId)
                .mimeType(formatType)
                .inputStream(is)
                .outputStream(outputStream)
                .build();

    }
}
