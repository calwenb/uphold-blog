package com.calwen.upholdblog.controller;

import com.calwen.upholdblog.convert.TypeConvert;
import com.calwen.upholdblog.entity.TypeEntity;
import com.calwen.upholdblog.request.blog.TypeRequest;
import com.calwen.upholdblog.service.TypeService;
import com.calwen.upholdblog.util.ResultUtil;
import com.calwen.upholdblog.vo.ResultVO;
import com.calwen.upholdblog.vo.TypeVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author calwen
 * @since 2022/11/18
 */
@RestController
@RequestMapping("/types")
public class TypeController {
    @Resource
    TypeService typeService;
    @Resource
    TypeConvert convert;

    @GetMapping("/list")
    public ResultVO<List<TypeVO>> list() {
        List<TypeVO> data = convert.list(typeService.list());
        return ResultUtil.success(data);
    }

    @PostMapping
    public ResultVO<Object> save(@RequestBody TypeRequest request) {
        boolean b = typeService.save(request);
        return ResultUtil.autoDo(b);
    }

    @DeleteMapping("/{id}")
    public ResultVO<Object> del(@PathVariable Integer id) {
        boolean b = typeService.del(id);
        return ResultUtil.autoDo(b);
    }

}
