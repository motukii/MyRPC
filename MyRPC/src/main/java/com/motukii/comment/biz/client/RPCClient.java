package com.motukii.comment.biz.client;

import com.motukii.comment.biz.common.User;
import com.motukii.comment.biz.service.UserService;


/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-11
 * @Description: 客户端建立Socket连接，传输Id给服务端，得到返回的User对象
 */

public class RPCClient {
    public static void main(String[] args) {

        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        // 服务的方法1
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);
        // 服务的方法2
        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = proxy.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);
    }
}
