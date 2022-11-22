package com.calwen.upholdblog.service;

import com.calwen.upholdblog.entity.TagEntity;
import com.calwen.upholdblog.vo.TagCountVO;

import java.util.List;

/**
 * @author calwen
 * @since 2022/11/13
 */
public interface TagService {
    List<String> listByBlogId(Integer blogId);

    List<TagEntity> listByValues(List<String> values);

    List<String> tagEnum();

    boolean blogSave(Integer blogId, List<String> list);

    List<TagCountVO> tagCount();

}
