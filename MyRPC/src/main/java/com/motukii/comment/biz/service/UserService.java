package com.motukii.comment.biz.service;


import com.motukii.comment.biz.common.User;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-11
 * @Description: 服务接口，客户端调用，服务端提供
 */
public interface UserService {
    User getUserByUserId(Integer id);
}
