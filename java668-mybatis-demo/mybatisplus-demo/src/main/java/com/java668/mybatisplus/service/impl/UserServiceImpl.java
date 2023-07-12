package com.java668.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java668.mybatisplus.mapper.UserDetailMapper;
import com.java668.mybatisplus.mapper.UserMapper;
import com.java668.mybatisplus.po.User;
import com.java668.mybatisplus.po.UserDetail;
import com.java668.mybatisplus.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserDetailMapper userDetailMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean test(String id) {
        User user = new User();
        user.setId(id);
        user.setName("小青牛1");
        updateById(user);

        UserDetail userDetail = new UserDetail();
        userDetail.setId(id);
        userDetail.setName("小青牛1");
        userDetailMapper.updateById(userDetail);
        return true;
    }
}