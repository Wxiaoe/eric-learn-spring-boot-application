package com.example.spring.boot.module;

import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CusttomerService(name = "test")
public class TransactionalServiceAnnotationRelectionBootstrap {

    public static void main(String[] args) {
        // Class 实现了 AnnotatedElement
        AnnotatedElement annotatedElement = TransactionalServiceAnnotationRelectionBootstrap.class;

        // 从AnnotatedElement获取CusttomerService
        CusttomerService custtomerService = annotatedElement.getAnnotation(CusttomerService.class);
//        String nameAttribute = custtomerService.name();
//        System.out.println("CusttomerService.name() = " + nameAttribute);


        // 完全java反射实现（RelectionUtils为spring的反射工具类)
//        ReflectionUtils.doWithMethods(CusttomerService.class,
////                method -> System.out.printf("@CusttomerService.%s() = %s\n",method.getName(), ReflectionUtils.invokeMethod(method, custtomerService)),
////                method -> method.getParameterCount() == 0); // 选择无参构造
        ReflectionUtils.doWithMethods(CusttomerService.class,
                method -> System.out.printf("@CusttomerService.%s() = %s\n",method.getName(), ReflectionUtils.invokeMethod(method, custtomerService)),
                method -> !method.getDeclaringClass().equals(Annotation.class)); // 选择无参构造



        // 获取 custtomerService的所有元注解
        Set<Annotation> metaAnnotations = getAllMetaAnnotaions(custtomerService);
        // 输出结果
        metaAnnotations.forEach(TransacitonServiceAnnotationMetaDataBootstrap::printAnnotationAttribute);
    }

    private static Set<Annotation> getAllMetaAnnotaions(Annotation annotation) {
        Annotation[] metaAnnotations = annotation.annotationType().getAnnotations();
        if (ObjectUtils.isEmpty(metaAnnotations)) {
            return Collections.emptySet();
        }

        // 获取所有非java标准元注解集合
        Set<Annotation> metaAnnotationsSet = Stream.of(metaAnnotations)
                // 排除Java标准注解，如 @Target 、@Documented 等，他们因相互依赖，将导致递归不断
                // 通过java.lang.annotation包名排除
                .filter(metaAnnotation -> !Target.class.getPackage().equals(metaAnnotation.annotationType().getPackage()))
                .collect(Collectors.toSet());

        // 递归查找元注解的元注解集合
        Set<Annotation> metaMetaAnnotationSet = metaAnnotationsSet.stream().map(TransactionalServiceAnnotationRelectionBootstrap::getAllMetaAnnotaions)
                .collect(HashSet::new, Set::addAll, Set::addAll);
        // 添加递归结果
        metaAnnotationsSet.addAll(metaMetaAnnotationSet);
        return metaAnnotationsSet;
    }
}
