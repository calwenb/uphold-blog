package com.calwen.upholdblog.service.impl;

import java.util.Date;

import com.calwen.upholdblog.entity.TypeEntity;
import com.calwen.upholdblog.request.blog.TypeRequest;
import com.calwen.upholdblog.service.TypeService;
import com.wen.releasedao.core.mapper.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author calwen
 * @since 2022/11/18
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    BaseMapper baseMapper;

    @Override
    public List<TypeEntity> list() {
        return baseMapper.getList(TypeEntity.class);
    }

    @Override
    public boolean save(TypeRequest request) {
        TypeEntity entity = new TypeEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setDeleted(false);
        entity.setCreateTime(new Date());
        return baseMapper.save(entity);
    }

    @Override
    public boolean del(Integer id) {
        return baseMapper.deleteById(TypeEntity.class, id);
    }
}
