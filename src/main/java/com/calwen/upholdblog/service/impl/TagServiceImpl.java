package com.calwen.upholdblog.service.impl;

import com.calwen.upholdblog.entity.TagEntity;
import com.calwen.upholdblog.service.TagService;
import com.calwen.upholdblog.vo.TagCountVO;
import com.wen.releasedao.core.mapper.BaseMapper;
import com.wen.releasedao.core.wrapper.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    public List<TagEntity> listByValues(List<String> values) {
        if (values != null && !values.isEmpty()) {
            QueryWrapper wrapper = new QueryWrapper();
            for (String value : values) {
                wrapper.eq("value", value);
            }
            return baseMapper.getList(TagEntity.class, wrapper);
        }
        return null;
    }

    @Override
    public List<String> tagEnum() {
        List<TagEntity> list = baseMapper.getList(TagEntity.class);
        return list.stream().map(TagEntity::getValue).distinct().collect(Collectors.toList());
    }

    @Override
    public boolean blogSave(Integer blogId, List<String> list) {
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

    @Override
    public List<TagCountVO> tagCount() {
        List<TagEntity> list = baseMapper.getList(TagEntity.class);
        Map<String, List<TagEntity>> map = list.stream()
                .collect(Collectors.groupingBy(TagEntity::getValue));
        return map.entrySet().stream().map(e -> {
                    TagCountVO vo = new TagCountVO();
                    vo.setValue(e.getKey());
                    vo.setCount(e.getValue().size());
                    return vo;
                }).sorted(Comparator.comparing(TagCountVO::getCount).reversed())
                .collect(Collectors.toList());
    }
}
