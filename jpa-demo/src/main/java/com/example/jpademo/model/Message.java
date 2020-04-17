package com.example.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ke_zhang
 * @create 2020/4/14 8:34
 * @description Message持久层对象
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer msgId;
    @Column(nullable = false)
    private String msgText;
    @Column(length = 32)
    private String msgSummary;
}
