package com.java668.mybatisplus.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class UserDetail {

    private String id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 乐观锁version注解
     */
    @Version
    private Integer version;
}