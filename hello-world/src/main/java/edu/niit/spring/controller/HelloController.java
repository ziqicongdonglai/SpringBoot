package edu.niit.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ke_zhang
 * @create 2020/3/9 9:22
 */

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String Hello() {
        return "Hello,Spring Boot";
    }

    @GetMapping("/hello/{name}")
    public String Name(@PathVariable(value = "name") String name){
        return "Hello," + name;
    }
}
