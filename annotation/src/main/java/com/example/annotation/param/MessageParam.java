package com.example.annotation.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ke_zhang
 * @create 2020/4/12 15:11
 * @description Message的分页类
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class MessageParam extends PageParam {
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
