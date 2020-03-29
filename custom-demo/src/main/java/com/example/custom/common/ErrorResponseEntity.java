package com.example.custom.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke_zhang
 * @create 2020/3/26 8:36
 * @description 通用返回值类，统一数据响应的返回结果格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseEntity {
    private int code;
    private String message;
}
