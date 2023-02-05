package com.calwen.upholdblog.service.impl;

import com.calwen.upholdblog.entity.CommentEntity;
import com.calwen.upholdblog.request.CommentQueryRequest;
import com.calwen.upholdblog.service.CommentService;
import com.wen.releasedao.core.mapper.BaseMapper;
import com.wen.releasedao.core.vo.PageRequest;
import com.wen.releasedao.core.vo.PageVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author calwen
 * @since 2022/12/16
 */
@Service
public class commentServiceImpl implements CommentService {
    @Resource
    BaseMapper baseMapper;

    @Override
    public List<CommentEntity> list(CommentQueryRequest request) {
        return baseMapper.getList(CommentEntity.class);
    }

    @Override
    public PageVO<CommentEntity> page(CommentQueryRequest request) {
        return baseMapper.page(CommentEntity.class, new PageRequest(request.getPageNum(), request.getPageSize()));
    }

    @Override
    public boolean save(String content, Integer userId) {
        return false;
    }

    @Override
    public boolean del(Integer id) {
        return false;
    }
}
