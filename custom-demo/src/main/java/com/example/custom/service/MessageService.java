package com.example.custom.service;

import com.example.custom.exception.CustomException;
import com.example.custom.pojo.Message;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:25
 * @description 消息服务接口
 */
public interface MessageService {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message) throws CustomException;
    void delete(Long id);
    Message update(Message message) throws CustomException;
    Message updateText(Message message) throws CustomException;
}
