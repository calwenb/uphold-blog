package com.calwen.upholdblog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Data
public class BlogVO {
    private Integer id;
    private String title;
    private String userName;
    private Integer columnName;
    //    private Integer typeId;
    private List<String> tagList;
    private Integer view;
    private Integer like;
    private Boolean open;
    private String content;
    private String preview="阅览下";
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
