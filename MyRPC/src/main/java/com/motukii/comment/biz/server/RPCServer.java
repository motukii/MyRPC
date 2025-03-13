package com.motukii.comment.biz.server;

import com.motukii.comment.biz.common.RPCRequest;
import com.motukii.comment.biz.common.RPCResponse;
import com.motukii.comment.biz.service.impl.UserServiceImpl;
import org.apache.zookeeper.server.Request;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-11
 * @Description: 服务端以BIO的方式监听Socket，如有数据，调用对应服务的实现类执行任务，将结果返回给客户端
 */

public interface RPCServer {
    void start(int port);
    void stop();
}
