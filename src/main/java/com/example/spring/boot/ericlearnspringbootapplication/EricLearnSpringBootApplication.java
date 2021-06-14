package com.example.spring.boot.ericlearnspringbootapplication;

import com.example.spring.boot.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author wxf
 */
//@EnableAutoConfiguration
//@ComponentScan
//@Configuration
//@SpringBootApplication(scanBasePackages = "com.example.spring.boot.config")  // same as @EnableAutoConfiguration + @ComponentScan + @SpringBootConfiguration(继承@Configuration)
@EnableAutoConfiguration
public class EricLearnSpringBootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EricLearnSpringBootApplication.class, args);
//        SpringApplication.run(WebConfiguration.class, args);
        SpringApplication.run(EricLearnSpringBootApplication.class, args);
    }




}
