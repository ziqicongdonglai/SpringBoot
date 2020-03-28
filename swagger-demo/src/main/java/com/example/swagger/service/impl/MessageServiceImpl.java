package com.example.swagger.service.impl;

import com.example.swagger.exception.CustomException;
import com.example.swagger.pojo.Message;
import com.example.swagger.repository.MessageRepository;
import com.example.swagger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:25
 * @description 消息服务类
 */
    @Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository repository;

    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Message save(Message message) throws CustomException {
        return repository.save(message);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Message update(Message message) throws CustomException {
        return repository.update(message);
    }

    @Override
    public Message updateText(Message message) throws CustomException {
        return repository.updateText(message);
    }
}
