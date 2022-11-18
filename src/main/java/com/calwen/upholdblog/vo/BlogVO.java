package com.calwen.upholdblog.vo;

import com.calwen.upholdblog.entity.TagEntity;
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
    private Integer typeName;
    //    private Integer typeId;
    private List<String> tagList;
    private Integer view;
    private Integer like;
    private Boolean open;
    private String content;
    private String imgUrl;
    private String preview;
    private Boolean edit;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;
}
