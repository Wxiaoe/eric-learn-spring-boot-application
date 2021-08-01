package com.example.spring.boot.autoconfigure.formatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormatterAutoConfiguration {

    /**
     *  构建 {@link DefaultFormatter} Bean
     *
     * @return {@link DefaultFormatter}
     */
    @Bean
    public Formater defaultFormatter() {
        return new DefaultFormatter();
    }
}


