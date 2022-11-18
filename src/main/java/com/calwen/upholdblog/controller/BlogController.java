package com.calwen.upholdblog.controller;

import com.calwen.upholdblog.convert.BlogConvert;
import com.calwen.upholdblog.request.blog.BlogQueryRequest;
import com.calwen.upholdblog.request.blog.BlogRequest;
import com.calwen.upholdblog.service.BlogService;
import com.calwen.upholdblog.service.TagService;
import com.calwen.upholdblog.util.JwtUtil;
import com.calwen.upholdblog.util.ResultUtil;
import com.calwen.upholdblog.vo.BlogVO;
import com.calwen.upholdblog.vo.ResultVO;
import com.calwen.upholdblog.vo.TagCountVO;
import com.wen.releasedao.core.vo.PageVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

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
    @Resource
    TagService tagService;

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

    @DeleteMapping("/{id}")
    public ResultVO<Object> del(@PathVariable Integer id) {
        return ResultUtil.autoDo(service.del(id, JwtUtil.getUid()));
    }

    @GetMapping("/tag/enum")
    public ResultVO<List<String>> tagEnum() {
        List<String> data = tagService.tagEnum();
        return ResultUtil.success(data);
    }

    @GetMapping("/tag/count")
    public ResultVO<List<TagCountVO>> tagCount() {
        List<TagCountVO> data = tagService.tagCount();
        return ResultUtil.success(data);
    }
}

