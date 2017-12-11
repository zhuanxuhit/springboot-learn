package com.edu.springboot;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 在@Import中引入
 * @author zhuanxu
 */
public class MyImportSelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //AnnotationMetadataReadingVisitor
        // 可以根据传入的 importingClassMetadata 的注释值来选择性的装载 Bean
        System.out.println(importingClassMetadata.getAnnotationTypes());

        System.out.println(importingClassMetadata.getAnnotationAttributes(EnableMy.class.getName()));
        return new String[]{User.class.getName(),Role.class.getName()};
    }
}
