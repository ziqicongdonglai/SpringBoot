package com.example.jpademo.service.impl;

import com.example.jpademo.dao.MessageRepository;
import com.example.jpademo.model.Message;
import com.example.jpademo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author ke_zhang
 * @create 2020/4/14 10:14
 * @description
 */

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void batchSave(List<Message> messages) {
        messageRepository.saveAll(messages);
    }

    @Override
    public void delete(Integer id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void batchDelete(List<Message> messages) {
        //使用一条 SQL
        messageRepository.deleteInBatch(messages);
        //使用多条 SQL
        messageRepository.deleteAll(messages);
    }

    @Override
    public void deleteAll() {
        messageRepository.deleteAllInBatch();
    }

    @Override
    public void update(Message message) {
        messageRepository.saveAndFlush(message);
    }

    //获取持久化管理器:
    @PersistenceContext
    private EntityManager em;

    //批量更新方法，批量插入，删除也都可以如此
    @Transactional
    @Override
    public void batchUpdate(List<Message> messages) {
        messages.forEach(message -> {
            em.merge(message);
        });
        em.flush();
        em.clear();
    }

    @Override
    public long count() {
        return messageRepository.count();
    }

    @Override
    public Message getMessage(Integer id) {
        //findOne的速度快于findById
        Optional<Message> msg = messageRepository.findById(id);
        //Optional<Message> msg = messageRepository.findOne(Example.of(Message.builder().msgId(id).build()));
        return msg.orElse(null);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }
}
