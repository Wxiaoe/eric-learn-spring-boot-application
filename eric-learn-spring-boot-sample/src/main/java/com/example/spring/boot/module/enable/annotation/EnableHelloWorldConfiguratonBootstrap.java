package com.example.spring.boot.module.enable.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 *  1.实现Configuration配置类 就是被@Configuration注解的类
 *  2.Enable驱动模块注解: 名称前缀为Enable的注解并且被@Import注解，导入类为步骤1的配置类
 *  3.将Enable驱动注解标注到引导类上
 * @author wxf
 */
@Configuration
@EnableHelloWorldConfiguration
public class EnableHelloWorldConfiguratonBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableHelloWorldConfiguratonBootstrap.class);
        context.refresh();
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.printf("helloWorld = %s \n" , helloWorld);
        context.close();
    }
}
