package com.example.custom.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

/**
 * @author ke_zhang
 * @create 2020/3/29 15:06
 * @description Gson自定义自动转换类
 */

//@Configuration
public class GsonConfig {
    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .excludeFieldsWithModifiers(Modifier.PROTECTED)
                .create();
        converter.setGson(gson);
        return converter;
    }
}
