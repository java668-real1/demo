package com.java668.springboot.rest;

import cn.hutool.core.map.MapUtil;
import com.java668.springboot.model.PageResp;
import com.java668.springboot.model.Result;
import com.java668.springboot.po.User;
import com.java668.springboot.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping("/login")
    public Result userLogin(@RequestBody Map<String, Object> params) {
        HashMap<String, Object> map = new HashMap<>();
        if (MapUtil.getStr(params, "username").equals("admin") && MapUtil.getStr(params, "password").equals("111111")) {
            map.put("token", "admin-token");
        } else {
            map.put("token", "editor-token");
        }
        return Result.succeed(map);
    }

    @GetMapping("/info")
    public Result userInfo(@RequestParam("token") String token) {
        HashMap<String, Object> map = new HashMap<>();
        if (token.equals("admin-token")) {
            map.put("roles", "admin");
            map.put("name", "Super Admin");
        } else {
            map.put("roles", "editor");
            map.put("name", "Normal Editor");
        }
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.succeed(map);
    }

    @PostMapping("/logout")
    public Result userLogout() {
        return Result.succeed("success");
    }

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