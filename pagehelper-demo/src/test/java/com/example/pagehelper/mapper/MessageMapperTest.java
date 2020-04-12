package com.example.pagehelper.mapper;

import com.example.pagehelper.model.Message;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ke_zhang
 * @create 2020/4/12 20:05
 * @description
 */
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageMapperTest {
    @Resource
    private MessageMapper messageMapper;

    @Test
    @Order(1)
    public void findAllWithRowBounds() {
        messageMapper.findAllWithRowBounds(new RowBounds(1, 3))
                .forEach(message -> log.info("Page(1) Message {}", message));
        messageMapper.findAllWithRowBounds(new RowBounds(2, 3))
                .forEach(message -> log.info("Page(2) Message {}", message));
        log.info("======================");

        messageMapper.findAllWithRowBounds(new RowBounds(1, 0))
                .forEach(coffee -> log.info("Page(1) Message {}", coffee));
        log.info("======================");
    }

    @Test
    @Order(2)
    public void findAllWithParam() {
        messageMapper.findAllWithParam(1, 3)
                .forEach(coffee -> log.info("Page(1) Message {}", coffee));
        List<Message> messages = messageMapper.findAllWithParam(2, 3);
        PageInfo<Message> page = new PageInfo<>(messages);
        log.info("PageInfo: {}", page);
    }
}