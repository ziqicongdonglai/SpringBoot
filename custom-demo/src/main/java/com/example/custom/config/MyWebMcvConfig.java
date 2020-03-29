package com.example.custom.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ke_zhang
 * @create 2020/3/29 15:07
 * @description 自定义MCV Configurer， 不推荐使用
 * 等同：
 * spring.resources.static-locations=classpath:/static/
 * spring.mvc.static-path-pattern=/**
 */
//@Configuration
public class MyWebMcvConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
    }
}
