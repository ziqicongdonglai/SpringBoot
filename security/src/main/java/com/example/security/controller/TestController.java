package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ke_zhang
 * @create 2020/4/16 8:32
 * @description
 */

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return  "hello security";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!";
    }
}
