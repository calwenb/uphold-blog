package com.calwen.upholdblog.request.blog;

import lombok.Data;

import java.util.List;

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
    private List<String> tagList;
    private Boolean open;
    private String content;
    private String imgUrl;
    //    private Integer typeId;
}
