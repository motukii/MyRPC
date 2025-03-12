package com.motukii.comment.biz.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-12
 * @Description:
 */

@Data
@Builder
public class RPCResponse implements Serializable {
    // 状态信息
    private int code;
    private String message;
    // 具体数据
    private Object data;

    // 成功响应，返回指定数据
    public static RPCResponse success(Object data) {
        return RPCResponse.builder().code(200).build();
    }

    // 失败响应，返回错误信息
    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).message("服务器发生错误").build();
    }
}
