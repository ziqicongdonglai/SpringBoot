package com.example.restful.service;

import com.example.restful.pojo.Message;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:25
 */
//消息服务接口
public interface MessageService {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message);
    void delete(Long id);
    Message update(Message message);
    Message updateText(Message message);
}
