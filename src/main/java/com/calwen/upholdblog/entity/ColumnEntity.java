package com.calwen.upholdblog.entity;

import com.wen.releasedao.core.annotation.TableName;
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
@TableName("column")
public class ColumnEntity {
    private Integer id;
    private String name;
    private Integer userId;
    private Boolean open;
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;
}
