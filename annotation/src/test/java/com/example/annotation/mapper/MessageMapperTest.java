package com.example.annotation.mapper;

import com.example.annotation.model.Message;
import com.example.annotation.model.Page;
import com.example.annotation.param.MessageParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author ke_zhang
 * @create 2020/4/9 9:38
 * @description
 */
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//3.
class MessageMapperTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    @Order(1)
    public void testInsert() {
        //1.模拟数据
        Message msg = Message.builder().msgText("学习").msgSummary("study").build();
        int num = messageMapper.insert(msg);
        log.info("插入的数据：{}", num);
    }

    @Test
    @Order(2)
    public void testSelectAll() {
        List<Message> msgs = messageMapper.selectAll();
        if (msgs == null) {
            log.error("msg为null");
        } else {
            msgs.forEach(msg -> log.info("查询到的记录：{}", msg));
        }
    }

    @Test
    @Order(3)
    public void testSelectById() {
        Message message = messageMapper.selectById(3);
        log.info("id为1的数据：{}", message);
    }

    @Test
    @Order(4)
    public void testDelete() {
        int num = messageMapper.delete(4);
        log.info("删除的数据条数：{}", num);
    }

    @Test
    @Order(5)
    public void testUpdate() {
        Message message = Message.builder().msgId(6).msgText("computer").msgSummary("").build();
        int num = messageMapper.update(message);
        log.info("更新的数据条数：{}", num);
    }

    @Test
    @Order(6)
    public void testUpdateSummary() {
        Message message = Message.builder().msgId(3).msgSummary("一只猫的名字").build();
        int num = messageMapper.updateText(message);
        log.info("更新Text的数据条数：{}", num);
    }

    @Test
    @Order(7)
    public void testBatchInsert() {
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("岁岁").msgSummary("猫").build(),
                Message.builder().msgText("哈比").msgSummary("猫").build()));
        int num = messageMapper.batchInsert(messages);
        log.info("插入的数据条数：{}", num);
    }

    @Test
    @Order(8)
    public void testCount() {
        MessageParam messageParam = new MessageParam();
        messageParam.setMsgText("");
        messageParam.setMsgSummary("动物");
        long count = messageMapper.getCount(messageParam);
        log.info("count ----, {}", count);
    }

    @Test
    @Order(9)
    public void testSelectByTextAndSummary() {
        Map<String, String> params = new HashMap<>();
        params.put("msgText", "兔子");
        params.put("msgSummary", "动物");
        messageMapper.selectByTextAndSummary(params)
                .forEach(msg -> log.info(msg.toString()));
    }

    @Test
    @Order(10)
    public void testPage() {
        MessageParam messageParam = new MessageParam();
        messageParam.setMsgText("");
        messageParam.setMsgSummary("动物");
        messageParam.setCurrentPage(0);
        List<Message> msgs = messageMapper.selectMessages(messageParam);
        long count = messageMapper.getCount(messageParam);
        Page<Message> page = new Page<>(messageParam, count, msgs);
        log.info("page = {}", page);
    }
}