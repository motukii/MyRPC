package com.motukii.comment.biz.server;

import com.motukii.comment.biz.common.User;
import com.motukii.comment.biz.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-11
 * @Description: 服务端以BIO的方式监听Socket，如有数据，调用对应服务的实现类执行任务，将结果返回给客户端
 */

public class RPCServer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务器启动成功");
            // BIO的方式监听Socket
            while (true) {
                Socket socket = serverSocket.accept();
                // 开启一个线程去处理
                new Thread(() -> {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        // 读取客户端传过来的id
                        Integer id = ois.readInt();
                        User userByUserId = userService.getUserByUserId(id);
                        // 写入user对象给客户端
                        oos.writeObject(userByUserId);
                        oos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("从 IO 中读取数据");
                    }
                }).start();
            }
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
}
