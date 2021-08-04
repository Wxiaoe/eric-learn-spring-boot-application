package com.example.ericlearnspringbootsample.spring.boot.module.enable.importbeandefinitionregistrar;

import com.example.ericlearnspringbootsample.spring.boot.module.enable.importselctor.EnableServer;
import com.example.ericlearnspringbootsample.spring.boot.module.enable.importselctor.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableServer2(type = Server.Type.HTTP)
public class EnableServer2Bootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableServer2Bootstrap.class);
        context.refresh();
        Server server = context.getBean(Server.class);
        server.start();
        server.close();
        context.close();
    }
}
