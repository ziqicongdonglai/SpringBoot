package com.example.swagger.repository;



import com.example.swagger.pojo.Message;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:23
 * @description Message的数据访问接口
 */
public interface MessageRepository {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message);
    void delete(Long id);
    Message update(Message message);
    Message updateText(Message message);
}
