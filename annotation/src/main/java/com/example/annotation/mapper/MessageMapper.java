package com.example.annotation.mapper;


import com.example.annotation.model.Message;
import com.example.annotation.param.MessageParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @Date : 2020-2-18 09:09
 * @Description: Message的数据访问接口
 */
@Mapper
@Repository
//1.
public interface MessageMapper {
    @Select("select * from message")
    List<Message> selectAll();

    @Select("select * from message where msg_id=#{msgId}")
    Message selectById(Integer msgId);

    @Select("select * from message where msg_text#{msgText} or msg_summary=#{msgSummary}")
    List<Message> selectByTextAndSummary(Map<String, String> params);

    @Insert("INSERT INTO message (msg_text, msg_summary) VALUES (#{msgText}, #{msgSummary})")
    int insert(Message message);

    @Delete("delete from message where msg_id=#{msgId} ")
    int delete(Integer id);

    @Update({"<script>",
            "update message set",
            "<if test='msgText != null'>msg_text=#{msgText},</if>",
            "<if test='msgSummary != null'>msg_summary=#{msgSummary}</if>",
            "where msg_id = #{msgId}",
            "</script>"})
    int update(Message message);

    @Update({"<script>",
            "update message",
            "<set>",
            "<if test='msgText != null'> msg_text=#{msgText},</if>",
            "<if test='msgSummary !=null'> msg_summary=#{msgText}</if>",
            "</set>",
            "where msg_id =#{msgId}",
           "</script>"})
    int updateText(Message message);

    @Insert({"<script>",
            "insert into message (msg_text, msg_summary) values",
            "<foreach collection='list' item='msg' index='index' separator=','>",
            "(#{msg.msgText}, #{msg.msgSummary})",
            "</foreach>",
            "</script>"})
    int batchInsert(List<Message> messages);

    @SelectProvider(type = MessageSQL.class, method = "getCount")
    int getCount(MessageParam messageParam);

    @SelectProvider(type = MessageSQL.class, method = "selectMessages")
    List<Message> selectMessages(MessageParam messageParam);
}
