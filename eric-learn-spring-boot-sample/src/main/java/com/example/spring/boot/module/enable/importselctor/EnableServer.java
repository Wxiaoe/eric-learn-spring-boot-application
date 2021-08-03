package com.example.spring.boot.module.enable.importselctor;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportSelector.class)
public @interface EnableServer {

    /**
     *  设置服务器类型
     * @return
     */
    Server.Type type();
}
