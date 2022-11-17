package com.calwen.upholdblog.entity;

import com.wen.releasedao.core.annotation.*;
import com.wen.releasedao.core.enums.IdTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("blog")
public class BlogEntity {
    @ColumnId(idType = IdTypeEnum.AUTO)
    private Integer id;
    private String title;
    private Integer userId;
    private Integer columnId;
    private Integer typeId;
    private String tag;
    private Integer view;
    private Integer like;
    private Boolean open;
    private String content;
    private String imgUrl;
//    @FieldValue("")
    private Boolean deleted;
    @CreateTime
    private Date createTime;
    @UpdateTime
    private Date updateTime;
}
