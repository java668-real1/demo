package com.java668.mybatisplus.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("tbl_user")
public class User {

    private String id;
    private String name;
    private Integer age;

    /**
     * 乐观锁version注解
     */
    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;
}