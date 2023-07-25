package com.s3.s3test.controller;

import com.s3.s3test.service.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static java.lang.System.*;

@RestController
@RequestMapping("/upload")
public class S3Controller {

    @Autowired
    IS3Service s3service;

    @PostMapping("")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            s3service.uploadFile(file);
            return ResponseEntity.status(HttpStatus.OK).body("Imagen subida correctamente");

        } catch (Exception e) {
            err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Fallo al subir la imagen");
        }

    }
}
