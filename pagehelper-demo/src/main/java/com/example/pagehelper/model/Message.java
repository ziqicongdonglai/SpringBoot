package com.example.pagehelper.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author ke_zhang
 * @create 2020/4/12 19:56
 * @description
 */
@Data
@Builder
public class Message {
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
