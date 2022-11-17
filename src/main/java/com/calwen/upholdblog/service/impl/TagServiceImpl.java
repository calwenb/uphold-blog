package com.calwen.upholdblog.service.impl;

import com.calwen.upholdblog.entity.TagEntity;
import com.calwen.upholdblog.service.TagService;
import com.wen.releasedao.core.mapper.BaseMapper;
import com.wen.releasedao.core.wrapper.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author calwen
 * @since 2022/11/13
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    BaseMapper baseMapper;

    @Override
    public List<String> listByBlogId(Integer blogId) {
        QueryWrapper wrapper = new QueryWrapper().eq("blog_id", blogId);
        List<TagEntity> list = baseMapper.getList(TagEntity.class, wrapper);
        return list.stream().map(TagEntity::getValue).collect(Collectors.toList());
    }

    @Override
    public List<String> listValue() {
        List<TagEntity> list = baseMapper.getList(TagEntity.class);
        return list.stream().map(TagEntity::getValue).distinct().collect(Collectors.toList());
    }

    @Override
    public boolean BlogSave(Integer blogId, List<String> list) {
        baseMapper.delete(TagEntity.class, new QueryWrapper().eq("blog_id", blogId));
        List<TagEntity> entityList = list.stream().map(e -> {
            TagEntity entity = new TagEntity();
            entity.setValue(e);
            entity.setBlogId(blogId);
            baseMapper.save(entity);
            return entity;
        }).collect(Collectors.toList());
//        return baseMapper.saveBatch(entityList);
        return true;
    }
}
