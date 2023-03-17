package com.java668.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java668.springboot.model.PageResp;
import com.java668.springboot.po.User;

import java.util.Map;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
public interface IUserService extends IService<User> {

    /**
     * 分页
     * @param params
     * @return
     */
    PageResp<User> page(Map<String, Object> params);

    /**
     * 点赞
     * @param id
     * @return
     */
    Boolean likes(Long id);
}