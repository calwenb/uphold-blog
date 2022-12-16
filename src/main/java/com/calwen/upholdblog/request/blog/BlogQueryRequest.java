package com.calwen.upholdblog.request.blog;

import com.calwen.upholdblog.request.PageRequest;
import lombok.Data;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Data
public class BlogQueryRequest extends PageRequest {
    private String keyword;
    private Integer userId;
    private Integer typeId;
    private List<String> tagList;
    /**
     * 简单查询
     */
    private boolean simple;

}
