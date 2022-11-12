package com.calwen.upholdblog.request.blog;

import lombok.Data;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Data
public class BlogRequest {
    private Integer id;
    private String title;
    private Integer userId;
    private String columnName;
    private String tag;
    private Boolean open;
    private String content;
    //    private Integer typeId;
}
