package com.example.custom.repository.impl;


import com.example.custom.pojo.Message;
import com.example.custom.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:24
 * @description Message的数据接口实现类
 */
@Service
public class MessageRepositoryImpl implements MessageRepository {
    //生成id
    private static AtomicLong counter = new AtomicLong();
    //存储Message的数据
    private final ConcurrentHashMap<Long, Message> msgs = new ConcurrentHashMap<>();
    @Override
    public List<Message> findAll() {
        return new ArrayList<>(this.msgs.values());
    }

    @Override
    public Message findOne(Long id) {
        return this.msgs.get(id);
    }

    @Override
    public Message save(Message message) {
        Long id = message.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.msgs.put(id,message);
        return message;
    }

    @Override
    public void delete(Long id) {
        this.msgs.remove(id);
    }

    @Override
    public Message update(Message message) {
        this.msgs.put(message.getId(),message);
        return message;
    }

    @Override
    public Message updateText(Message message) {
        Message msg = this.msgs.get(message.getId());
        msg.setText(message.getText());
        this.msgs.put(msg.getId(),msg);
        return msg;
    }
}
