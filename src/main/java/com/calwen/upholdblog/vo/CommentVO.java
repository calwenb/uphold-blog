package com.calwen.upholdblog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wen.releasedao.core.annotation.Column;
import com.wen.releasedao.core.annotation.CreateTime;
import com.wen.releasedao.core.annotation.UpdateTime;
import lombok.Data;

import java.util.Date;

/**
 * @author calwen
 * @since 2022/11/18
 */
@Data
public class CommentVO {
    private Integer id;
    private String content;
    private Integer userId;
    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
}
