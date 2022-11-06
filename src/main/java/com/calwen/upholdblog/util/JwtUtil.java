package com.calwen.upholdblog.util;

import com.calwen.upholdblog.entity.UserEntity;
import com.calwen.upholdblog.service.AuthService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


/**
 * @author calwen
 * @since 2022/11/5
 */
@Component
public class JwtUtil {
    static AuthService authService;
    @Resource
    ApplicationContext context;

    @PostConstruct
    public void init() {
        authService = context.getBean(AuthService.class);
    }


    public static UserEntity getUser() {
        return authService.getUser();
    }

    public static Integer getUid() {
        return authService.getUserId();
    }
}
