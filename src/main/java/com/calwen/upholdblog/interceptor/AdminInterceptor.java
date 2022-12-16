package com.calwen.upholdblog.interceptor;

import com.alibaba.fastjson2.JSON;
import com.calwen.upholdblog.annotation.AdminAuth;
import com.calwen.upholdblog.annotation.PassAuth;
import com.calwen.upholdblog.entity.UserEntity;
import com.calwen.upholdblog.enums.UserTypeEnum;
import com.calwen.upholdblog.service.AuthService;
import com.calwen.upholdblog.util.LoggerUtil;
import com.calwen.upholdblog.util.ResultUtil;
import com.calwen.upholdblog.vo.ResultVO;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * token验证拦截器类
 * 用于后端接口的验证，
 * 调用后端接口需携带token进行身份验证，
 * 使用@PassAuth注解则跳过拦截器
 *
 * @author calwen
 */
public class AdminInterceptor implements HandlerInterceptor {

    @Resource
    AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(AdminAuth.class)) {
            AdminAuth adminAuth = method.getAnnotation(AdminAuth.class);
            if (adminAuth.required() &&
                    !UserTypeEnum.ADMIN.name().equals(authService.getUser().getType())) {
                ResultVO<String> resultVO = ResultUtil.noPower();
                response.getWriter().println(JSON.toJSONString(resultVO));
                return false;
            }
        }
        return true;
    }

}