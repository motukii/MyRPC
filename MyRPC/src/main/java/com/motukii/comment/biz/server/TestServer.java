package com.motukii.comment.biz.server;

import com.motukii.comment.biz.service.BlogService;
import com.motukii.comment.biz.service.UserService;
import com.motukii.comment.biz.service.impl.BlogServiceImpl;
import com.motukii.comment.biz.service.impl.UserServiceImpl;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-13
 * @Description:
 */

public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer rpcServer = new ThreadPoolRPCRPCServer(serviceProvider);
        rpcServer.start(8899);
    }
}
