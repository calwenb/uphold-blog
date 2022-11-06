package com.calwen.upholdblog.service.impl;

import com.calwen.upholdblog.entity.UserEntity;
import com.calwen.upholdblog.service.UserService;
import com.wen.releasedao.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author calwen
 * @since 2022/11/5
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    BaseMapper baseMapper;

    @Override
    public UserEntity get(Integer id) {
        return baseMapper.getById(UserEntity.class, id);
    }

    @Override
    public String getName(Integer id) {
        UserEntity user = this.get(id);
        return user != null ? user.getName() : "";
    }
}
