package com.example.custom.exception;


import com.example.custom.common.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ke_zhang
 * @create 2020/3/26 8:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {
    /**错误码*/
    protected Integer code;
    /**错误信息*/
    protected String message;

    public CustomException(ExceptionType type) {
        this.code = type.getCode();
        this.message = type.getMsg();
    }
}
