package com.calwen.upholdblog.controller;

import com.calwen.upholdblog.annotation.AdminAuth;
import com.calwen.upholdblog.entity.CommentEntity;
import com.calwen.upholdblog.request.CommentQueryRequest;
import com.calwen.upholdblog.service.CommentService;
import com.calwen.upholdblog.util.JwtUtil;
import com.calwen.upholdblog.util.ResultUtil;
import com.calwen.upholdblog.vo.ResultVO;
import com.wen.releasedao.core.vo.PageVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author calwen
 * @since 2022/12/16
 */
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Resource
    CommentService service;

    @GetMapping("/page")
    public ResultVO<PageVO<CommentEntity>> page(CommentQueryRequest request) {
        PageVO<CommentEntity> data = service.page(request);
        return ResultUtil.success(data);
    }

    @AdminAuth
    @PostMapping
    public ResultVO<Object> save(@RequestParam String content) {
        boolean b = service.save(content, JwtUtil.getUid());
        return ResultUtil.autoDo(b);
    }

}
