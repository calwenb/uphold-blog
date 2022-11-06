package com.calwen.upholdblog.entity;

import com.wen.releasedao.core.annotation.CreateTime;
import com.wen.releasedao.core.annotation.FieldId;
import com.wen.releasedao.core.annotation.TableName;
import com.wen.releasedao.core.annotation.UpdateTime;
import com.wen.releasedao.core.enums.IdTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * User实体类
 *
 * @author calwen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserEntity {
    @FieldId(idType = IdTypeEnum.AUTO)
    private Integer id;
    private String name;
    private String account;
    private String password;
    private String type;
    private String phone;
    private String email;
    private Boolean deleted;
    @CreateTime
    private Date createTime;
    @UpdateTime
    private Date updateTime;
}
