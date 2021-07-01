package com.example.spring.boot.module.enable.importselctor;

public interface Server {

    /**
     *  启动服务器
     */
    void start();

    /**
     *  关闭服务
     */
    void close();

    enum Type {
        HTTP,// HTTP服务
        FTP // FTP服务
    }
}
