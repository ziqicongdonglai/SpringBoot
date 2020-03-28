package com.example.restful.contorller;

//import com.spring.restful.common.ExceptionType;
//import com.spring.restful.exception.CustomException;

import com.example.restful.pojo.Message;
import com.example.restful.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:22
 */
//控制类
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/message")
    public ResponseEntity<List<Message>> list() {
        List<Message> list = this.messageService.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/message")
    public ResponseEntity<Message> create(Message message) {
        Message msg = this.messageService.save(message);
        return ResponseEntity.ok(msg);
    }
    @PutMapping("/message")
    public ResponseEntity<Message> modify(Message message) {
        Message msg = this.messageService.update(message);
        return ResponseEntity.ok(msg);
    }
    @PatchMapping("/message/text")
    public ResponseEntity<Message> patch(Message message) {
        Message msg = this.messageService.updateText(message);
        return ResponseEntity.ok(msg);
    }
    @GetMapping("/message/{id}")
    public ResponseEntity<Message> get(@PathVariable Long id) {
        Message msg = this.messageService.findOne(id);
        return ResponseEntity.ok(msg);
    }
    @DeleteMapping("/message/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        this.messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
