package com.example.ericlearnspringbootsample.spring.boot.module.enable.importselctor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.function.Predicate;

public class ServerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
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

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
