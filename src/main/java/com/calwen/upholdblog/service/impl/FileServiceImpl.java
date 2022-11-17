package com.calwen.upholdblog.service.impl;

import com.calwen.upholdblog.enums.FileEnum;
import com.calwen.upholdblog.exception.FailException;
import com.calwen.upholdblog.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author calwen
 * @since 2022/11/17
 */
public class FileServiceImpl implements FileService {

    @Value("${uphold-blog.file.baseDir}")
    String baseDir;

    @Override
    public String uploadImg(MultipartFile file) {
        String fileName = System.currentTimeMillis() + file.getName();
        String path = baseDir + FileEnum.IMG_DIR + fileName;
        try {
            file.transferTo(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FailException("上传文件");
        }
        return FileEnum.IMG_DIR + fileName;
    }

    @Override
    public void getImg(String url) {
        Files.read
    }
}
