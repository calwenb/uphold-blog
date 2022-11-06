package com.calwen.upholdblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenEnum {
    HEADER("Authorization"),
    TOKEN_PREFIX("Bearer "),
    JWT_SECRET("uphold-blog-calwen");

    private final String value;
}
