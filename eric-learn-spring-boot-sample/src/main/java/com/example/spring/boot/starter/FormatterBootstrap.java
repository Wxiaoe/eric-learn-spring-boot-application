package com.example.spring.boot.starter;

import com.example.spring.boot.autoconfigure.formatter.Formater;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
public class FormatterBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 带格式化对象
        Map<String,Object> data = new HashMap<>();
        data.put("name", "酷酷");
        // 获取Formatter, 来自FormatterAutoConfiguration
        Formater formater = context.getBean(Formater.class);
        System.out.printf("%s.format(data) : %s\n",formater.getClass().getSimpleName(), formater.format(data));
        // 关闭上下文
        context.close();
    }
}
