package com.calwen.upholdblog.controller;

import com.calwen.upholdblog.annotation.PassAuth;
import com.calwen.upholdblog.service.FileService;
import com.calwen.upholdblog.util.ResultUtil;
import com.calwen.upholdblog.vo.ResultVO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author calwen
 * @since 2022/11/17
 */
@RestController
@RequestMapping("/files")
public class FileController {
    @Resource
    FileService service;

    @PassAuth
    @PostMapping("/upload-img")
    public ResultVO<String> upload(MultipartFile file) {
        String data = service.uploadImg(file);
        return ResultUtil.success(data);
    }

    @PassAuth
    @GetMapping
    public ResponseEntity<FileSystemResource> get(String url) {
        return service.get(url);


    }

}
