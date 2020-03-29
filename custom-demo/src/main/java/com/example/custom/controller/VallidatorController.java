package com.example.custom.controller;

import com.example.custom.pojo.Message;
import com.example.custom.pojo.ValidatorObj;
import com.example.custom.validator.MessageValidator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ke_zhang
 * @create 2020/3/29 15:28
 * @description
 */
@RestController
public class VallidatorController {
    @PostMapping(value = "/validate")
    public Map<String, Object> validate(@Valid @RequestBody ValidatorObj obj, Errors errors) {
        Map<String,Object> errMap = new HashMap<>();
        //获取错误列表
        List<ObjectError> objectErrors = errors.getAllErrors();
        for (ObjectError error : objectErrors) {
            String key = null;
            String msg = null;
            //字段错误
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                //获取错误验证字段名
                key = fieldError.getField();
            } else {
                //非字段错误
                //获取验证对象名称
                key = error.getObjectName();
            }
            //错误信息
            msg = error.getObjectName();
            errMap.put(key,msg);
        }
        return errMap;
    }

    /**
     * 调用控制器前先执行这个方法
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //绑定验证器
        binder.setValidator(new MessageValidator());
        //定义日期参数格式，参数不再需要注解@DateTimeFormat,boolean参数表示是否允许为空
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    /**
     * 验证url:http://localhost:8080/msgValidator?msg=1&date=2020-01-01
     * @param msg Message对象
     * @param errors 验证器返回的错误
     * @param date 因为WebDataBinder已经绑定了格式，所以不再需要注解
     * @return 各类数据
     */
    @GetMapping("/msgValidator")
    public Map<String,Object> validator(@Valid Message msg, Errors errors, Date date) {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("date", date);
        //判断是否存在错误
        if (errors.hasErrors()) {
            //获取全部错误
            List<ObjectError> objectErrors = errors.getAllErrors();
            for (ObjectError error: objectErrors) {
                //判断是否字段错误
                if (error instanceof FieldError) {
                    //字段错误
                    FieldError fe = (FieldError) error;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else {
                    //对象错误
                    map.put(error.getObjectName(),error.getDefaultMessage());
                }
            }
        }
        return map;
    }
}
