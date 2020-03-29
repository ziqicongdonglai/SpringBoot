package com.example.custom.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.Arrays;

/**
 * @author ke_zhang
 * @create 2020/3/29 15:06
 * @description
 */
@Configuration
public class MyFastjsonConfig {
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd hh:mm:ss");
        config.setSerializerFeatures(
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );
        //消除循环依赖
        config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));

        converter.setFastJsonConfig(config);
        return converter;
    }
}
