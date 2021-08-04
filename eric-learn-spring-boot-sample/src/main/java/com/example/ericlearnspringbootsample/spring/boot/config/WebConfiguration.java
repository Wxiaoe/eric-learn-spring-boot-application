package com.example.ericlearnspringbootsample.spring.boot.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

//@Configuration
//@SpringBootApplication
//@EnableAutoConfiguration
@Configuration
public class WebConfiguration {

    /**
     *  webflux 可以配合jetty tomcat undertow三种嵌入式Web容器使用
     * @return
     */
//    @Bean
//    public RouterFunction<ServerResponse> helloWorld() {
//        return RouterFunctions.route().GET("/hello-world", serverRequest -> ServerResponse.ok().body(Mono.just("hello,wold"),String.class)).build();
//    }

    /** 10.这里不完善，ApplicationRunner @Bean 方法申明时，依赖注入WebServerApplicationContext，
     * 同时兼顾servlet和reactive两种web场景
     *  {@link ApplicationRunner#run(ApplicationArguments)} 方法在Spring Boot 应用启动后回调
     * @param context
     * @return
     */
    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> {
            System.out.println("当前 webServer 实现类为：" + context.getWebServer().getClass().getName());
        };
    }

    /**
     *  11.上面的runner不完善，ApplicationRunner @Bean 方法申明时，依赖注入WebServerApplicationContext，
     *      * 同时兼顾servlet和reactive两种web场景，但是未考虑非Web应用的场景类型
     *      Spring Boot提供了在架构设计层面兼容性更强的方案，即 Web服务器已初始化事件——WebServerInitializedEvent
     *     该事件兼容非 Web应用，如果WebServerApplicationContext注入失败也不会有问题
     */
    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前 webServer 实现类为：" + event.getWebServer().getClass().getName());
    }

        @Bean
    public ApplicationRunner runner(BeanFactory beanFactory) {
        return args -> {
            System.out.println("当前 helloWorld Bean 实现类为：" + beanFactory.getBean("helloWorld").getClass().getName());

            System.out.println("当前 WebConfiguration Bean 实现类为：" + beanFactory.getBean(WebConfiguration.class).getClass().getName());
        };
    }
}
