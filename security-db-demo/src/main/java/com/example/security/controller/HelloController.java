package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ke_zhang
 * @create 2020/4/19 0:31
 * @description
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }
    @GetMapping("/dba/hello")
    public String dba() {
        return "hello dba";
    }
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }
    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }
}
