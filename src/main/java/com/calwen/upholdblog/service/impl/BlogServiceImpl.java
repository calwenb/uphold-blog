package com.calwen.upholdblog.service.impl;

import java.util.Date;
import java.util.Objects;

import com.calwen.upholdblog.entity.BlogEntity;
import com.calwen.upholdblog.entity.UserEntity;
import com.calwen.upholdblog.exception.OauthException;
import com.calwen.upholdblog.request.blog.BlogQueryRequest;
import com.calwen.upholdblog.request.blog.BlogRequest;
import com.calwen.upholdblog.service.BlogService;
import com.calwen.upholdblog.service.UserService;
import com.calwen.upholdblog.vo.BlogVO;
import com.wen.releasedao.core.mapper.BaseMapper;
import com.wen.releasedao.core.vo.PageRequest;
import com.wen.releasedao.core.vo.PageVO;
import com.wen.releasedao.core.wrapper.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    BaseMapper baseMapper;
    @Resource
    UserService userService;

    @Override
    public BlogEntity get(Integer id) {
        return baseMapper.getById(BlogEntity.class, id);
    }

    @Override
    public PageVO<BlogEntity> page(BlogQueryRequest request) {
        QueryWrapper wrapper = this.conditionWrapper(request);
        return baseMapper.page(BlogEntity.class, wrapper,
                new PageRequest(request.getPageNum(), request.getPageSize()));
    }

    private QueryWrapper conditionWrapper(BlogQueryRequest request) {
        QueryWrapper wrapper = new QueryWrapper();
        String keyword = request.getKeyword();
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("title", keyword);
        }
        return wrapper;
    }

    @Override
    public Boolean save(BlogRequest request) {
//        this.verify(request.getId(), request.getUserId());
        BlogEntity entity = new BlogEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setColumnId(0);
        entity.setTypeId(0);
        entity.setView(0);
        entity.setLike(0);
        entity.setDeleted(false);
        return baseMapper.add(entity);
    }

    @Override
    public Boolean del(Integer id, Integer userId) {
        this.verify(id,userId);
        return baseMapper.deleteById(BlogEntity.class, id);
    }

    @Override
    public Boolean update(BlogRequest request) {
        this.verify(request.getId(), request.getUserId());
        BlogEntity entity = new BlogEntity();
        return baseMapper.save(entity);
    }

    /**
     * 权限校验
     */
    private void verify(Integer id, Integer userId) {
        BlogEntity blog = this.get(id);
        UserEntity user = userService.get(userId);
        if (Objects.equals(blog.getUserId(), user.getId())) {
            return;
        }
        throw new OauthException("无权操作");
    }

}
