package com.calwen.upholdblog.controller;

import com.calwen.upholdblog.convert.BlogConvert;
import com.calwen.upholdblog.request.blog.BlogQueryRequest;
import com.calwen.upholdblog.request.blog.BlogRequest;
import com.calwen.upholdblog.service.BlogService;
import com.calwen.upholdblog.util.JwtUtil;
import com.calwen.upholdblog.util.ResultUtil;
import com.calwen.upholdblog.vo.BlogVO;
import com.calwen.upholdblog.vo.ResultVO;
import com.wen.releasedao.core.vo.PageVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author calwen
 * @since 2022/11/5
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Resource
    BlogService service;
    @Resource
    BlogConvert convert;

    @GetMapping("/{id}")
    public ResultVO<BlogVO> get(@PathVariable Integer id) {
        BlogVO data = convert.convert(service.get(id));
        return ResultUtil.success(data);
    }

    @GetMapping("/page")
    public ResultVO<PageVO<BlogVO>> page(BlogQueryRequest request) {
        PageVO<BlogVO> data = convert.page(service.page(request));
        return ResultUtil.success(data);
    }

    @PostMapping
    public ResultVO<Object> save(@Valid @RequestBody BlogRequest request) {
        request.setUserId(JwtUtil.getUid());
        return ResultUtil.autoDo(service.save(request));
    }
}
