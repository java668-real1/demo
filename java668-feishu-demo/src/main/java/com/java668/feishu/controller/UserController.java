package com.java668.feishu.controller;

import com.java668.feishu.dto.UserRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/15 16:43
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/login")
    public ResponseEntity<UserRespDTO> userLogin() {
        return ResponseEntity.ok(new UserRespDTO());
    }

}