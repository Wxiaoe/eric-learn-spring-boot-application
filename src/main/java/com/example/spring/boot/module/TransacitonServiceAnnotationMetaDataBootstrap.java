package com.example.spring.boot.module;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.Set;

@CusttomerService
public class TransacitonServiceAnnotationMetaDataBootstrap {

    public static void main(String[] args)throws Exception {
        String className = TransacitonServiceAnnotationMetaDataBootstrap.class.getName();
        CachingMetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        annotationMetadata.getAnnotationTypes().forEach(annotationType -> {
            Set<String> annotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
            annotationTypes.forEach(metaAnnotationType -> {
                System.out.printf("注解 @%s 元注解  @%s\n", annotationType, metaAnnotationType);
            });
        });
    }

    public static void printAnnotationAttribute(Annotation annotation) {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        // 完全Java反射实现（ReflectionUtils为Spring的反射工具类)
        ReflectionUtils.doWithMethods(annotationType,
                method -> System.out.printf("@%s.%s() = %s\n",annotationType.getSimpleName(),method.getName(),ReflectionUtils.invokeMethod(method,annotation))
        // 执行Method反射调用
                // ,method -> method.getParameterCount() == 0); // 选择无参构造
                , method -> !method.getDeclaringClass().equals(Annotation.class)
        );
    }
}
