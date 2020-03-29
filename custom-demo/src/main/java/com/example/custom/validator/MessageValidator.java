package com.example.custom.validator;

import com.example.custom.pojo.Message;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author ke_zhang
 * @create 2020/3/29 15:45
 * @description 用户自定义验证器
 */
public class MessageValidator implements Validator {
    //验证器只是支持User类验证
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Message.class);
    }

    //逻辑验证
    @Override
    public void validate(Object target, Errors errors) {
        //对象为空
        if (target == null) {
            //直接在参数处报错，这样就不能进入控制器的方法
            errors.rejectValue("",null,"消息不能为空");
            return;
        }
        //强制转换
        Message message = (Message) target;
        //用户非空串
        if (StringUtils.isEmpty(message.getText())) {
            //增加错误，可以进入控制器方法
            errors.rejectValue("text","正文不能为空");
        }
    }
}
