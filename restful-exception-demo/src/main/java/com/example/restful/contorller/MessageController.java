package com.example.restful.contorller;

//import com.spring.restful.common.ExceptionType;
//import com.spring.restful.exception.CustomException;

import com.example.restful.common.ExceptionType;
import com.example.restful.exception.CustomException;
import com.example.restful.pojo.Message;
import com.example.restful.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:22
 * @description 控制器
 */
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
    public ResponseEntity<Message> create(@RequestBody Message message) {
        if (message == null || message.getText() == null || message.getText().isEmpty()) {
            throw new CustomException(ExceptionType.USER_INPUT_ERROR);
        }
        try {
            Message msg = this.messageService.save(message);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.SERVER_ERROR.getCode(),e.getMessage());
        }
    }
    @PutMapping("/message")
    public ResponseEntity<Message> modify(@RequestBody Message message) throws CustomException {
        if (message == null || message.getText() == null || message.getText().isEmpty()) {
            throw new CustomException((ExceptionType.USER_INPUT_ERROR));
        }
        try {
            Message msg = this.messageService.update(message);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.SERVER_ERROR.getCode(), e.getMessage());
        }
    }
    @PatchMapping("/message/text")
    public ResponseEntity<Message> patch(Message message) throws CustomException {
        if (message == null || message.getText() == null || message.getText().isEmpty()) {
            throw new CustomException((ExceptionType.USER_INPUT_ERROR));
        }
        try {
            Message msg = this.messageService.updateText(message);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.SERVER_ERROR.getCode(), e.getMessage());
        }
    }
    @GetMapping("/message/{id}")
    public ResponseEntity<Message> get(@PathVariable Long id) {
        Message msg = this.messageService.findOne(id);
        if (msg != null) {
            return ResponseEntity.ok(msg);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/message/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id)  {
        this.messageService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 测试异常
     */
    @GetMapping("/exception")
    public String exception() {
        int i = 1 / 0;
        return "exception";
    }

    @GetMapping("/userException")
    public String userException() {
        throw new CustomException((ExceptionType.USER_INPUT_ERROR));
    }
}
