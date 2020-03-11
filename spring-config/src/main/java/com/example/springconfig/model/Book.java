package com.example.springconfig.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author ke_zhang
 * @create 2020/3/11 9:07
 */

@Data
@ToString
//@NoArgsConstructor //生成没有任何构造函数的构造方法？
//@AllArgsConstructor
//@RequiredArgsConstructor
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String isdn;
    private String name;
    private String author;
    private Float price;
//    @Value(value = "${}")
    private String desc;

    private List<String> fans;
    private Map<String,Integer> rank;

}
