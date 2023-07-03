package com.java668.feishu.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/15 17:16
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping
public class AuthController {

    @RequestMapping("/get_appid")
    public ResponseEntity<Map<String, Object>> getAppid() {
        Map<String, Object> result = new HashMap<>();
        result.put("appid", "cli_a40069e79f7c900d");
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam("code") String code) {
        System.out.println(code);
        return ResponseEntity.ok(code);
    }

}