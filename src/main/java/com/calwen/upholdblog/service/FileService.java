package com.calwen.upholdblog.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author calwen
 * @since 2022/11/17
 */
public interface FileService {

    String upload(MultipartFile file);

    ResponseEntity<FileSystemResource> get(String url);

    String parsContent(MultipartFile file);
}
