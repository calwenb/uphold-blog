package com.calwen.upholdblog.convert;

import com.calwen.upholdblog.entity.BlogEntity;
import com.calwen.upholdblog.service.UserService;
import com.calwen.upholdblog.vo.BlogVO;
import com.wen.releasedao.core.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author calwen
 * @since 2022/10/31
 */
@Component
@Slf4j
public class BlogConvert {
    @Resource
    UserService userService;

    public BlogVO convert(BlogEntity entity) {
        BlogVO vo = new BlogVO();
        BeanUtils.copyProperties(entity, vo);
        String userName = userService.getName(entity.getUserId());
        vo.setUserName(userName);
        if (StringUtils.isNotBlank(entity.getTag())) {
            String tagStr = entity.getTag();
            List<String> tagList = Arrays.asList(tagStr.substring(1, tagStr.length() - 1).split(","));
            vo.setTagList(tagList);
        }
        return vo;
    }

    public List<BlogVO> list(List<BlogEntity> list) {
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    public PageVO<BlogVO> page(PageVO<BlogEntity> page) {
        List<BlogVO> list = list(page.getContent());
        return PageVO.of(list, page.getPage(), page.getSize(), page.getTotal());
    }
}
