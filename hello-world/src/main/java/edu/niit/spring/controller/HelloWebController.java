package edu.niit.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ke_zhang
 * @create 2020/3/9 10:15
 * 标准的Spring MVC控制器
 */

@Controller
@RequestMapping("/springWeb")
@ResponseBody
public class HelloWebController {
    @RequestMapping("/hello")
    public String hello() {
        return "<h2>Hello,Spring Boot</h2>";
    }
}
