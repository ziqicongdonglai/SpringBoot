package com.example.restful.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke_zhang
 * @create 2020/3/24 11:23
 * @description Message的持久层对象Persisent Object
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;
    private String text;
    private String summary;
}
