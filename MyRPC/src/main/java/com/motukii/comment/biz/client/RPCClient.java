package com.motukii.comment.biz.client;

import com.motukii.comment.biz.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-11
 * @Description: 客户端建立Socket连接，传输Id给服务端，得到返回的User对象
 */

public class RPCClient {
    public static void main(String[] args) {
        try {
            //建立Socket连接
            Socket socket = new Socket("127.0.0.1", 8899);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            //传给服务器Id
            objectOutputStream.writeInt(new Random().nextInt());
            objectOutputStream.flush();
            //服务器查询数据，返回对应的对象
            User user = (User) objectInputStream.readObject();
            System.out.println("服务端返回的User:"+user);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }
}
