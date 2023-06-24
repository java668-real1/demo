package com.java668.oxadmin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

}
