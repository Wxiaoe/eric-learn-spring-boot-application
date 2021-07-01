package com.example.spring.boot.module.enable.importselctor;

import org.springframework.stereotype.Component;

@Component
public class FtpServer implements Server {

    @Override
    public void start() {
        System.out.println("FTP 服务启动中...");
    }

    @Override
    public void close() {
        System.out.println("FTP 服务关闭中...");
    }
}
