package com.example.spring.boot.module;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Scope
public @interface CusttomerService {

    /**
     *  Bean服务名称
     * @return
     */
    @AliasFor(annotation = Service.class, attribute = "value")
    String name() default "";
}
