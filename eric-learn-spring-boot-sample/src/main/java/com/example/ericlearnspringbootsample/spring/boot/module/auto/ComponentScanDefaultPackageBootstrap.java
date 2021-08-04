package com.example.ericlearnspringbootsample.spring.boot.module.auto;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

@ComponentScan(basePackages = "")
public class ComponentScanDefaultPackageBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanDefaultPackageBootstrap.class);
        System.out.println("当前Spring应用上下文中所有注册的Bean名称：");
        Stream.of(context.getBeanDefinitionNames())
                .map(name -> "\t" + name)
                .forEach(System.out::println);
        context.close();
    }
}
