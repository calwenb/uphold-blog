package com.calwen.upholdblog.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.calwen.upholdblog.entity.BlogEntity;
import com.calwen.upholdblog.entity.TagEntity;
import com.calwen.upholdblog.entity.UserEntity;
import com.calwen.upholdblog.exception.OauthException;
import com.calwen.upholdblog.request.blog.BlogQueryRequest;
import com.calwen.upholdblog.request.blog.BlogRequest;
import com.calwen.upholdblog.service.BlogService;
import com.calwen.upholdblog.service.TagService;
import com.calwen.upholdblog.service.UserService;
import com.wen.releasedao.core.mapper.BaseMapper;
import com.wen.releasedao.core.vo.PageRequest;
import com.wen.releasedao.core.vo.PageVO;
import com.wen.releasedao.core.wrapper.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
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
    @Resource
    TagService tagService;
    @Value("${uphold-blog.file.baseDir}")
    String baseDir;

    @Override
    public BlogEntity get(Integer id) {
        return baseMapper.getById(BlogEntity.class, id);
    }

    @Override
    public PageVO<BlogEntity> page(BlogQueryRequest request) {
        QueryWrapper wrapper = this.conditionWrapper(request);
        return baseMapper.page(BlogEntity.class, wrapper, new PageRequest(request.getPageNum(), request.getPageSize()));
    }

    private QueryWrapper conditionWrapper(BlogQueryRequest request) {
        String keyword = request.getKeyword();
        List<String> tagList = request.getTagList();
        Integer typeId = request.getTypeId();
        QueryWrapper wrapper = new QueryWrapper();
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("title", keyword);
        }
        if (tagList != null && !tagList.isEmpty()) {
            for (String tag : tagList) {
                wrapper.eq("tag", tag);
            }
        }
        if (typeId != null) {
            wrapper.eq("typeId", typeId);
        }
        wrapper.orderDesc("update_time");
        return wrapper;
    }

    @Override
    public Boolean save(BlogRequest request) {
//      this.verify(request.getId(), request.getUserId());
        BlogEntity blog = new BlogEntity();
        BeanUtils.copyProperties(request, blog);
        blog.setTypeId(0);
        blog.setView(0);
        blog.setLike(0);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setDeleted(false);
        baseMapper.save(blog);
        tagService.BlogSave(blog.getId(), request.getTagList());
        return true;
    }

    @Override
    public Boolean del(Integer id, Integer userId) {
        this.verify(id, userId);
        baseMapper.deleteById(BlogEntity.class, id);
        baseMapper.delete(TagEntity.class, new QueryWrapper().eq("blog_id", id));
        return true;
    }

    @Override
    public Boolean saveByFile(BlogRequest request) {
        try {
            String path = baseDir + request.getFileUrl();
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            String content = new String(bytes);
            request.setContent(content);
            return save(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
