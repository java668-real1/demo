package com.java668.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java668.redis.po.User;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
public interface IUserService extends IService<User> {

    User getCache(Long id);
}