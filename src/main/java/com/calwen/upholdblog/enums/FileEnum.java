package com.calwen.upholdblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author calwen
 * @since 2022/11/17
 */
@Getter
@AllArgsConstructor
public enum FileEnum {
    IMG_DIR("/img/");

    private final String value;
}
