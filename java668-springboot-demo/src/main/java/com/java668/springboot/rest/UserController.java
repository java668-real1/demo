package com.java668.springboot.rest;

import com.java668.springboot.model.PageResp;
import com.java668.springboot.model.Result;
import com.java668.springboot.po.User;
import com.java668.springboot.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public Result<User> get(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return Result.succeed(user);
    }

    @GetMapping("/page")
    public Result<PageResp<User>> page(@RequestParam Map<String, Object> params) {
        return Result.succeed(userService.page(params));
    }

}