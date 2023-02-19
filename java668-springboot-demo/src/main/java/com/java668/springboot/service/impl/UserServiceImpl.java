package com.java668.springboot.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java668.springboot.mapper.UserMapper;
import com.java668.springboot.model.PageResp;
import com.java668.springboot.po.User;
import com.java668.springboot.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public PageResp<User> page(Map<String, Object> params) {
        Page<User> page = new Page<>(MapUtil.getInt(params, "page"), MapUtil.getInt(params, "limit"));
        page(page);
        return PageResp.<User>builder()
                .list(page.getRecords())
                .total(page.getTotal())
                .build();
    }

}