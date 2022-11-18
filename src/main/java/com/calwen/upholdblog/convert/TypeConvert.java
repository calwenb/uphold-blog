package com.calwen.upholdblog.convert;

import com.calwen.upholdblog.entity.BlogEntity;
import com.calwen.upholdblog.entity.TypeEntity;
import com.calwen.upholdblog.service.TagService;
import com.calwen.upholdblog.service.UserService;
import com.calwen.upholdblog.util.JwtUtil;
import com.calwen.upholdblog.vo.TypeVO;
import com.wen.releasedao.core.mapper.BaseMapper;
import com.wen.releasedao.core.vo.PageVO;
import com.wen.releasedao.core.wrapper.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author calwen
 * @since 2022/10/31
 */
@Component
@Slf4j
public class TypeConvert {

    @Resource
    BaseMapper baseMapper;

    public TypeVO convert(TypeEntity entity) {
        if (entity == null) {
            return new TypeVO();
        }
        TypeVO vo = new TypeVO();
        BeanUtils.copyProperties(entity, vo);
        int count = baseMapper.getCount(BlogEntity.class,
                new QueryWrapper().eq("type_id", entity.getId()));
        vo.setCount(count);
        return vo;
    }

    public List<TypeVO> list(List<TypeEntity> list) {
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    public PageVO<TypeVO> page(PageVO<TypeEntity> page) {
        List<TypeVO> list = list(page.getContent());
        return PageVO.of(list, page.getPage(), page.getSize(), page.getTotal());
    }
}
