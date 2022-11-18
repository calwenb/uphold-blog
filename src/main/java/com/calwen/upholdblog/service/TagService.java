package com.calwen.upholdblog.service;

import com.calwen.upholdblog.vo.TagCountVO;

import java.util.List;

/**
 * @author calwen
 * @since 2022/11/13
 */
public interface TagService {
    List<String> listByBlogId(Integer blogId);

    List<String> tagEnum();

    boolean BlogSave(Integer blogId,List<String> list);

    List<TagCountVO> tagCount();

}
