package com.java668.oxadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('product')")
    public List<String> list(Principal principal) {
        List<String> list = new ArrayList<>();
        list.add("眼镜");
        list.add("格子衬衣");
        list.add("双肩包");
//        list.add(principal.getName());
        return list;
    }

}
