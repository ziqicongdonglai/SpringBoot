package com.example.annotation.mapper;

import com.example.annotation.param.MessageParam;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author ke_zhang
 * @create 2020/4/12 15:03
 * @description Message的数据访问接口
 */
public class MessageSQL {
    public String getCount(MessageParam messageParam) {
        return new SQL(){{
            SELECT("count(2)");
            FROM("message");
            if(!StringUtils.isEmpty(messageParam.getMsgText())) {
                WHERE("msg_text=#{msgText}");
            }
            if(!StringUtils.isEmpty(messageParam.getMsgSummary())) {
                WHERE("msg_summary=#{msgSummary}");
            }
            // 说明SQL内部使用StringBuilder实现SQL拼接
        }}.toString();
    }

    public String selectMessages(MessageParam messageParam) {
        return new SQL(){{
            SELECT("*");
            FROM("message");
            WHERE("msg_id=1");
            if (messageParam != null) {
                if (!StringUtils.isEmpty(messageParam.getMsgText())) {
                    WHERE(" and msg_text = #{msgText} ");
                }
                if(!StringUtils.isEmpty(messageParam.getMsgSummary())) {
                    WHERE("msg_summary=#{msgSummary}");
                }
            }
            ORDER_BY("msg_id");

            if (messageParam != null) {
                OFFSET(messageParam.getBeginLine());
                LIMIT(messageParam.getPageSize());
            }
        }}.toString();
    }
}