package com.example.spring.boot.module.enable.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *  Enable模块的驱动注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorldConfiguration {
}
