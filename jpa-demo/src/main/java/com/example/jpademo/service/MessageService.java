package com.example.jpademo.service;

import com.example.jpademo.model.Message;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/14 9:06
 * @description
 */
public interface MessageService {
    void save(Message message);
    void batchSave(List<Message> messages);

    void delete(Integer id);
    void batchDelete(List<Message> messages);
    void deleteAll();

    void update(Message message);
    void batchUpdate(List<Message> messages);

    long count();

    Message getMessage(Integer id);
    List<Message> getAll();
}
