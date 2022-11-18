package com.calwen.upholdblog.request.blog;


import lombok.Data;

/**
 * @author calwen
 * @since 2022/11/18
 */
@Data
public class TypeRequest {
    private Integer id;
    private String value;
    private Boolean open;
}
