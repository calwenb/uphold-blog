package com.calwen.upholdblog.service;

import com.calwen.upholdblog.entity.TagEntity;
import com.calwen.upholdblog.entity.TypeEntity;
import com.calwen.upholdblog.request.blog.TypeRequest;

import java.util.List;

/**
 * @author calwen
 * @since 2022/11/18
 */
public interface TypeService {

    List<TypeEntity> list();

    boolean save(TypeRequest typeRequest);


    boolean del(Integer id);
}
