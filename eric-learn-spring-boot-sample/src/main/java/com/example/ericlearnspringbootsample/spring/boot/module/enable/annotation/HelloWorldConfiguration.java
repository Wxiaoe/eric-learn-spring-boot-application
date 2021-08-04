package com.example.ericlearnspringbootsample.spring.boot.module.enable.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  配置类
 * @author wxf
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean("helloWorld")
    public String helloWorld() {
        return "Hello, World";
    }
}
