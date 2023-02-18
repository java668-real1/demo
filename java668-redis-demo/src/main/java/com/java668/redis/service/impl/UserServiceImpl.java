package com.java668.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java668.redis.mapper.UserMapper;
import com.java668.redis.po.User;
import com.java668.redis.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final CacheManager cacheManager;

    @Override
    @Cacheable(value = {"user"}, key = "#root.methodName", sync = true)
    public User getCache(Long id) {
        System.out.println(cacheManager);
        return getById(id);
    }

}