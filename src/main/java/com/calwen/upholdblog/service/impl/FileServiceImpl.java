package com.calwen.upholdblog.service.impl;

import com.calwen.upholdblog.enums.FileEnum;
import com.calwen.upholdblog.exception.FailException;
import com.calwen.upholdblog.service.FileService;
import com.calwen.upholdblog.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author calwen
 * @since 2022/11/17
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${uphold-blog.file.baseDir}")
    String baseDir;

    @Override
    public String upload(MultipartFile file) {
        try {
            String resource = System.currentTimeMillis() + file.getOriginalFilename();
            String path = baseDir + resource;
            createFatherDir(baseDir);
            file.transferTo(Paths.get(path));
            return resource;
        } catch (IOException e) {
            e.printStackTrace();
            throw new FailException("上传文件发生错误");
        }
    }

    @Override
    public ResponseEntity<FileSystemResource> get(String url) {
        FileSystemResource file = new FileSystemResource(baseDir + url);
        if (!file.exists()) {
            return null;
        }
        String contentDisposition = ContentDisposition
                .builder("attachment")
                .filename(Optional.ofNullable(file.getFilename()).orElse("未知文件"))
                .build().toString();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file);
    }

    @Override
    public String parsContent(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            return new String(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFatherDir(String path) {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
            LoggerUtil.info("不存在该文件目录:" + path, FileServiceImpl.class);
        }
    }
}
