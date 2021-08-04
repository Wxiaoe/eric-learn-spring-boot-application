package com.example.ericlearnspringbootsample.spring.boot.autoconfigure.formatter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormatterAutoConfiguration {

    /**
     *  构建 {@link DefaultFormatter} Bean
     *
     * @return {@link DefaultFormatter}
     */
    @Bean
    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formater defaultFormatter() {
        return new DefaultFormatter();
    }


    /**
     *  构建 {@link JsonFormatter} Bean
     *
     * @return {@link JsonFormatter}
     */
    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formater jsonFormatter(){
        return new JsonFormatter();
    }
}


