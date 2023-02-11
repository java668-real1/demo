package com.java668.mybatisplus.dynamic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java668.mybatisplus.dynamic.po.User;

import java.sql.SQLException;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
public interface IUserService extends IService<User> {

    void test();
}