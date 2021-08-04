package com.example.ericlearnspringbootsample.spring.boot.module.enable.importbeandefinitionregistrar;

import com.example.ericlearnspringbootsample.spring.boot.module.enable.importselctor.Server;
import com.example.ericlearnspringbootsample.spring.boot.module.enable.importselctor.ServerImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer2 {

    /**
     *  设置服务器类型
     * @return
     */
    Server.Type type();
}
