package com.calwen.upholdblog.service;

import com.calwen.upholdblog.entity.CommentEntity;
import com.calwen.upholdblog.request.CommentQueryRequest;
import com.calwen.upholdblog.request.blog.TypeRequest;
import com.wen.releasedao.core.vo.PageVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author calwen
 * @since 2022/12/16
 */
@RestController
@RequestMapping("/comments")
public interface CommentService {
    List<CommentEntity> list(CommentQueryRequest request);

    PageVO<CommentEntity> page(CommentQueryRequest request);

    boolean save(String content, Integer userId);


    boolean del(Integer id);

}
