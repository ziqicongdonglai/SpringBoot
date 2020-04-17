package com.example.jpademo.service;

import com.example.jpademo.dao.MessageRepository;
import com.example.jpademo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ke_zhang
 * @create 2020/4/14 10:18
 * @description
 */

@Slf4j
@SpringBootTest
class MessageServiceTest {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testUpdate() {
        //根据主键更新
        Message message = Message.builder().msgId(7)
                .msgText("笔记本").msgSummary("学习").build();
        messageRepository.saveAndFlush(message);

        //批量更新
        List<Message> messages = new ArrayList<>();
        messages.add(Message.builder().msgId(8).msgText("笔记本").msgSummary("学习").build());
        messages.add(Message.builder().msgId(9).msgText("开学").msgSummary("学习").build());
        messageService.batchUpdate(messages);
    }
}