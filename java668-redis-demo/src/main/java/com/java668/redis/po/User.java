package com.java668.redis.po;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 乐观锁version注解
     */
    @Version
    private Integer version;
}