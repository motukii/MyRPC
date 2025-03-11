package com.motukii.comment.biz.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: 陈宇航
 * @CreateTime: 2025-03-11
 * @Description: User对象
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    // 客户端和服务端共有的
    private Integer id;
    private String userName;
    private Boolean sex;
}
