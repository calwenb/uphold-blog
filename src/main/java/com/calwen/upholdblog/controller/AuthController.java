package com.calwen.upholdblog.controller;

import com.calwen.upholdblog.annotation.PassAuth;
import com.calwen.upholdblog.entity.UserEntity;
import com.calwen.upholdblog.vo.ResultVO;
import com.calwen.upholdblog.request.UserRequest;
import com.calwen.upholdblog.service.AuthService;
import com.calwen.upholdblog.util.ResultUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author calwen
 * @since 2022/10/28
 */
@RestController
@RequestMapping("/auths")
public class AuthController {
    @Resource
    AuthService authService;

    @PassAuth
    @PostMapping("/login")
    public ResultVO<String> login(@Validated(UserRequest.login.class)
                                  @RequestBody UserRequest request) {
        String token = authService.login(request);
        return ResultUtil.success(token);
    }

    @PassAuth
    @PostMapping("/register")
    public ResultVO<String> register(@Validated(UserRequest.register.class)
                                     @RequestBody UserRequest request) {
        String token = authService.register(request);
        return ResultUtil.success(token);
    }

    @PostMapping("/out-login")
    public ResultVO<String> outLogin() {
        boolean b = authService.removeToken();
        return ResultUtil.autoDo(b);
    }

    @GetMapping("/user/info")
    public ResultVO<UserEntity> getUserByToken() {
        UserEntity user = authService.getUser();
        return ResultUtil.success(user);
    }
}
