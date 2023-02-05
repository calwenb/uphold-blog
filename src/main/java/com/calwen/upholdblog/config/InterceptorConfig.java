package com.calwen.upholdblog.config;

import com.calwen.upholdblog.interceptor.AdminInterceptor;
import com.calwen.upholdblog.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Token验证拦截器规则配置类
 *
 * @author calwen
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Bean
    AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Bean
    AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //验证拦截
        registry.addInterceptor(authenticationInterceptor());
        registry.addInterceptor(adminInterceptor());
    }


}