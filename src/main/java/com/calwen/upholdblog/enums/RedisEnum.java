package com.calwen.upholdblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RedisEnum {
    TOKEN_PREFIX("uphold-blog:token:"),
    LIKE_PREFIX("uphold-blog:like:");

    private final String value;
}
