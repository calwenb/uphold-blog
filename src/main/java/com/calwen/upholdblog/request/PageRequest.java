package com.calwen.upholdblog.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author calwen
 * @since 2022/12/16
 */
@Data
public class PageRequest {
    /**
     * 分页页码
     */
//    @NotNull(message = " 分页页码参数 page必传 ")
    private Integer pageNum;

    /**
     * 分页大小
     */
//    @NotNull(message = " 分页大小参数 size必传 ")
//    @Max(value = 200, message = " 分页大小不可超过200 ")
    private Integer pageSize;
}
