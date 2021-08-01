package com.example.spring.boot.autoconfigure.formatter;

public class DefaultFormatter implements Formater {

    @Override
    public String format(Object object) {
        return String.valueOf(object);
    }
}
