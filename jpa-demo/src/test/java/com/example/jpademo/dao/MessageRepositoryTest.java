package com.example.jpademo.dao;

import com.example.jpademo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ke_zhang
 * @create 2020/4/14 9:08
 * @description
 */

@Slf4j
@SpringBootTest
class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    // 添加一个或多个
    @Test
    public void testSave() {
        Message message = Message.builder().msgText("computer").msgSummary("学习").build();
        // 保存单个对象
        messageRepository.save(message);

        List<Message> messages = new ArrayList<>();
        messages.add(Message.builder().msgText("小哈").msgSummary("猫").build());
        messages.add(Message.builder().msgText("岁岁").msgSummary("猫").build());
        messages.add(Message.builder().msgText("小狼").msgSummary("猫").build());
        messages.add(Message.builder().msgText("除夕").msgSummary("猫").build());
        messages.add(Message.builder().msgText("坨坨").msgSummary("猫").build());
        messages.add(Message.builder().msgText("六条").msgSummary("猫").build());
        messages.add(Message.builder().msgText("Q米").msgSummary("猫").build());
        messages.add(Message.builder().msgText("小班").msgSummary("猫").build());
        messages.add(Message.builder().msgText("恭喜").msgSummary("猫").build());

        message = new Message();
        message.setMsgText("纳豆");
        message.setMsgSummary("猫");
        messages.add(message);
        // 保存多个
        messageRepository.saveAll(messages);
    }

    @Test
    public void testDelete() {
        Message message = Message.builder().msgId(1).build();

        // 删除单条记录
        // 根据主键删除
        //messageRepository.deleteById(2);
        //提供对象 根据主键删除
        //messageRepository.delete(message);

        // 删除集合
        //List<Message> messages = new ArrayList<>();
        //message = Message.builder().msgId(5).build();
        //messages.add(message);
        //message = Message.builder().msgId(6).build();
        //messages.add(message);
        // 删除集合：一条一条删除
        //messageRepository.deleteAll(messages);
        // 删除集合：一条 sql，拼接 or 语句
        //messageRepository.deleteInBatch(messages);

        // 删除全部
        // 删除所有：先findAll，然后一条一条删除，最后提交事务
        //messageRepository.deleteAll();
        // 删除所有：使用一条 sql
        //messageRepository.deleteAllInBatch();
    }

    //简单查询
    @Test
    public void testSelect() {
        //查询所有
        messageRepository.findAll().forEach(msg -> log.info(msg.toString()));

        //分页查询全部，返回封装了的分页信息，jpa页码从0开始
        Page<Message> pageInfo = messageRepository.findAll(
                PageRequest.of(1, 3, Sort.Direction.ASC, "msgId"));
        log.info("总记录数：{}", pageInfo.getTotalElements());
        log.info("当前页记录数：{}", pageInfo.getNumberOfElements());
        log.info("每页记录数：{}", pageInfo.getSize());
        log.info("获取总页数：{}", pageInfo.getTotalPages());
        log.info("查询结果：{}", pageInfo.getContent());
        log.info("当前页(从0开始)：{}", pageInfo.getNumber());
        log.info("是否为首页：{}", pageInfo.isFirst());
        log.info("是否为尾页：{}", pageInfo.isLast());

        //条件查询
        Message message = Message.builder().msgSummary("学习").build();
        List<Message> messages = messageRepository.findAll(Example.of(message));
        log.info("满足summary是学习的message有:");
        messages.forEach(msg -> log.info(msg.toString()));

        //单个查询
        Message msg = Message.builder().msgId(2).build();
        Optional<Message> optionalMessage = messageRepository.findOne(Example.of(msg));
        log.info("单个查询结果：{}", optionalMessage.orElse(null));
    }

    @Test
    public void testQueryByName() {
        List<Message> msg1 = messageRepository.findByMsgSummary("学习");
        msg1.forEach(msg -> log.info(msg.toString()));
        log.info("---------------------------------------");
        List<Message> msg2 = messageRepository.findByMsgTextOrMsgSummary("笔记本", "学习");
        msg2.forEach(msg -> log.info(msg.toString()));
        log.info("---------------------------------------");
        List<Message> msg3 = messageRepository.findByMsgTextLike("学");
        msg3.forEach(msg -> log.info(msg.toString()));
        log.info("---------------------------------------");
        List<Message> msg4 = messageRepository.findDistinctByMsgIdLessThan(7);
        msg4.forEach(msg -> log.info(msg.toString()));
    }

    @Test
    public void testCustomSQL() {
        Integer num = messageRepository.insertMessage("自定义SQL", "JPA");
        log.info("增加的数据条数：{}", num);
        Integer updateNum = messageRepository.updateName("JPQL",1);
        log.info("修改的数据条数：{}", updateNum);
    }

}