package com.calwen.upholdblog.request.blog;

import lombok.Data;

import javax.validation.constraints.Max;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Data
public class BlogQueryRequest {
    private String keyword;
    private Integer userId;
    private String columnName;
    private String tag;
    /**
     * 简单查询
     */
    private boolean simple;
    /**
     * 分页页码
     */
//    @NotNull(message = " 分页页码参数 page必传 ")
    private Integer pageNum;

    /**
     * 分页大小
     */
//    @NotNull(message = " 分页大小参数 size必传 ")
    @Max(value = 200, message = " 分页大小不可超过200 ")
    private Integer PageSize;
}
