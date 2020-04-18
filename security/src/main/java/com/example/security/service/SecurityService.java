package com.example.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author ke_zhang
 * @create 2020/4/18 19:51
 * @description 方法安全注解
 */
//@Service
public class SecurityService {
    @PreAuthorize("hasRole('admin')")
    public String admin() {
        return "hello admin";
    }

    @Secured("ROLE_user")
    public String user() {
        return "hello user";
    }

    @PreAuthorize("hasAnyRole('admin', 'user')")
    public String hello() {
        return "hello hello";
    }
}
