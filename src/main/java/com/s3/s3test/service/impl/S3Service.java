package com.s3.s3test.service.impl;

import com.s3.s3test.service.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;

@Service
public class S3Service implements IS3Service {
    private final S3Client s3Client;

    private static final String BUCKET_NAME = "almacen-pruebas-super-app";

    @Autowired
    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }
    @Override
    public void uploadFile(MultipartFile file){
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .build();

            PutObjectResponse putObjectResponse = s3Client.putObject(putObjectRequest,
                    RequestBody.fromBytes(file.getBytes()));

            System.out.println(putObjectResponse.responseMetadata().toString());

            // Puedes manejar la respuesta de putObjectResponse según sea necesario.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getFile() {

    }

    @Override
    public void deleteFile() {

    }
}
