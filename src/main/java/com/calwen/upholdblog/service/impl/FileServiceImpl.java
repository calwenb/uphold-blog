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

/**
 * @author calwen
 * @since 2022/11/17
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${uphold-blog.file.baseDir}")
    String baseDir;

    @Override
    public String uploadImg(MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String path = baseDir + FileEnum.IMG_DIR.getValue() + fileName;
//            createFatherDir(path);
            file.transferTo(Paths.get(path));
            return FileEnum.IMG_DIR.getValue() + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new FailException("上传文件发生错误");
        }
    }

    @Override
    public ResponseEntity<FileSystemResource> get(String url) {
        if (url==null){
            return null;
        }
        FileSystemResource resource = new FileSystemResource(baseDir + url);
        resource.getFilename();
        String contentDisposition = ContentDisposition
                .builder("attachment")
                .filename(resource.getFilename())
                .build().toString();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .contentType(MediaType.IMAGE_JPEG)
                .body(new FileSystemResource(baseDir + url));
    }

    private void createFatherDir(String path) {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
            LoggerUtil.info("不存在该文件目录:" + path, FileServiceImpl.class);
        }
    }
}
