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
public class RPCRequest implements Serializable {
    // 服务类名，客户端只知道接口名，在服务端中用接口名指向实现类
    private String interfaceName;
    // 方法名
    private String methodName;
    // 参数列表
    private Object[] params;
    // 参数类型
    private Class<?>[] paramTypes;
}
