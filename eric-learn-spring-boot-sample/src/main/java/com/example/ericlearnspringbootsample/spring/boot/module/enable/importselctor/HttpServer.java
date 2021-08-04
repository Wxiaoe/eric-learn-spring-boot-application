package com.example.ericlearnspringbootsample.spring.boot.module.enable.importselctor;

import org.springframework.stereotype.Component;

@Component // 根据ImportSelector的契约，确保实现为Spring组件
public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("HTTP 服务启动中...");
    }

    @Override
    public void close() {
        System.out.println("HTTP 服务关闭中...");
    }
}
