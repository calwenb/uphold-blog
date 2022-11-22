package com.calwen.upholdblog.entity;

import com.wen.releasedao.core.annotation.*;
import com.wen.releasedao.core.enums.IdTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author calwen
 * @since 2022/11/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("type")
public class TypeEntity {
    @ColumnId(idType = IdTypeEnum.AUTO)
    private Integer id;
    private String value;

//    @Column(defaultValue = "true")
    private Boolean open;
//    @Column(defaultValue = "false")
    private Boolean deleted;
    @CreateTime
    private Date createTime;
    @UpdateTime
    private Date updateTime;
}

