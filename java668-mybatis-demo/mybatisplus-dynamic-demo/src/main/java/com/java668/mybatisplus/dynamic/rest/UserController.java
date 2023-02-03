package com.java668.mybatisplus.dynamic.rest;

import com.java668.mybatisplus.dynamic.po.User;
import com.java668.mybatisplus.dynamic.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:32
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @GetMapping("{id}")
    public User get(@PathVariable("id") Long id) throws SQLException {
        userService.test();
        return userService.getById(id);
    }

}