package com.project.neo.history.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void store(MultipartFile file, String dirName,String fileName);

}
