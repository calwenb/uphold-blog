package com.calwen.upholdblog.entity;

import com.wen.releasedao.core.annotation.ColumnId;
import com.wen.releasedao.core.annotation.TableName;
import com.wen.releasedao.core.enums.IdTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tag")
public class TagEntity {
    @ColumnId(idType = IdTypeEnum.AUTO)
    private Integer id;
    private Integer blogId;
    private String value;

}
