package com.s3.s3test.service;

import org.springframework.web.multipart.MultipartFile;

public interface IS3Service {

    public void uploadFile(MultipartFile file);

    public void getFile();

    public void deleteFile();

}
