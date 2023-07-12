package com.java668.mybatisplus.rest;

import com.java668.mybatisplus.po.User;
import com.java668.mybatisplus.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @GetMapping("{id}")
    public User get(@PathVariable("id") String id) {
        return userService.getById(id);
    }



    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return userService.removeById(id);
    }

    @GetMapping("/delete1/{id}")
    public boolean delete1(@PathVariable("id") String id) {
        return userService.removeById(id, true);
    }

    @GetMapping("/test/{id}")
    public boolean test(@PathVariable("id") String id) {
        executorService.submit(() -> {
            try {
                userService.test(id);
            } catch (Exception e) {
                log.error("e", e);
            }
        });
        return true;
    }
}