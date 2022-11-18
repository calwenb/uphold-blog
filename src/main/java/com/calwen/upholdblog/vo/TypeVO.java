package com.calwen.upholdblog.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author calwen
 * @since 2022/11/18
 */
@Data
public class TypeVO {
    private Integer id;
    private String value;
    private Boolean open;
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;
    private Integer count;
}
