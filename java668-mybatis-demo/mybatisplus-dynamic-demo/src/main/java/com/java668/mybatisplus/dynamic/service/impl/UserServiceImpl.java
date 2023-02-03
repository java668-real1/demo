package com.java668.mybatisplus.dynamic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java668.mybatisplus.dynamic.mapper.UserMapper;
import com.java668.mybatisplus.dynamic.po.User;
import com.java668.mybatisplus.dynamic.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}