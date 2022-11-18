package com.calwen.upholdblog.service;

import com.calwen.upholdblog.entity.BlogEntity;
import com.calwen.upholdblog.request.blog.BlogQueryRequest;
import com.calwen.upholdblog.request.blog.BlogRequest;
import com.wen.releasedao.core.vo.PageVO;

/**
 * @author calwen
 * @since 2022/11/5
 */
public interface BlogService {

    BlogEntity get(Integer id);

    PageVO<BlogEntity> page(BlogQueryRequest request);

    Boolean save(BlogRequest request);

    Boolean del(Integer id, Integer userId);

    Boolean saveByFile(BlogRequest request);
}
