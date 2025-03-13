package com.motukii.comment.biz.service.impl;

import com.motukii.comment.biz.common.Blog;
import com.motukii.comment.biz.service.BlogService;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-13
 * @Description:
 */

public class BlogServiceImpl implements BlogService {

    /**
     * @param id
     * @return
     */
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").useId(22).build();
        System.out.println("客户端查询了"+id+"博客");
        return blog;
    }
}
