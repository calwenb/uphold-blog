package com.calwen.upholdblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一返回体枚举类
 *
 * @author calwen
 * @since 2022/7/20
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(2000, "操作成功"),
    ERROR(7000, "操作失败"),
    UNAUTHORIZED(4001, "身份验证失败，请重新登录"),
    NO_POWER(4003, "很抱歉，您无权访问"),
    BAD_REQUEST(4000, "错误请求，请检查api调用"),
    EXCEPTION(5000, "很抱歉,服务器发生异常：");

    private final Integer code;
    private final String message;
}
