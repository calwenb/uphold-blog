package com.calwen.upholdblog.entity;

import com.wen.releasedao.core.annotation.Column;
import com.wen.releasedao.core.annotation.CreateTime;
import com.wen.releasedao.core.annotation.TableName;
import com.wen.releasedao.core.annotation.UpdateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author calwen
 * @since 2022/12/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comment")
public class CommentEntity {
    private Integer id;
    private String content;
    private Integer userId;
    @Column(defaultValue = "true")
    private Boolean deleted;
    @CreateTime
    private Date createTime;
    @UpdateTime
    private Date updateTime;
}
