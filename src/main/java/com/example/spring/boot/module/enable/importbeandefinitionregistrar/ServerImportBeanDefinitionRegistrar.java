package com.example.spring.boot.module.enable.importbeandefinitionregistrar;

import com.example.spring.boot.module.enable.importselctor.FtpServer;
import com.example.spring.boot.module.enable.importselctor.HttpServer;
import com.example.spring.boot.module.enable.importselctor.Server;
import com.example.spring.boot.module.enable.importselctor.ServerImportSelector;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.stream.Stream;

public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        String[] selectImportsClassNames = this.selectImports(importingClassMetadata);
        Stream.of(selectImportsClassNames)
                // 转化为BeanDefinitionBuilder对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                // 转化为BeanDefinition
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition ->
                        // 注册BeanDefinition到BeanDefinitionRegistry
                        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry)
                );
    }

    private String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer2.class.getName());
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        String[] importClassNames = new String[0];
        switch (type) {
            case HTTP:
                importClassNames = new String[] {HttpServer.class.getName()};
                break;
            case FTP:
                importClassNames = new String[]{FtpServer.class.getName()};
                break;
        }
        return importClassNames;
    }
}
