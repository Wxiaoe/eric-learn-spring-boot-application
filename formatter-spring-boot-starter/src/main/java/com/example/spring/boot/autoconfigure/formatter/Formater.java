package com.example.spring.boot.autoconfigure.formatter;

public interface Formater {

    /**
     *  格式化操作
     *
     * @param object 带格式化对象
     * @return 返回格式化后的内容
     */
    String format(Object object);
}
