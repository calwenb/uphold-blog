package com.calwen.upholdblog.service;

import com.calwen.upholdblog.entity.UserEntity;

/**
 * @author calwen
 * @since 2022/11/5
 */
public interface UserService {
    UserEntity get(Integer id);

    String getName(Integer id);
}
