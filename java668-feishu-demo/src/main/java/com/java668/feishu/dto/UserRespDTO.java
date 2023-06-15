package com.java668.feishu.dto;

import lombok.Data;

@Data
public class UserRespDTO {

    private Long id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 乐观锁version注解
     */
    private Integer version;

    private Integer likes;
}