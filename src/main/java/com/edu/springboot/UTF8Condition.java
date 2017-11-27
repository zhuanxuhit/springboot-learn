package com.edu.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 注解 @Conditional 使用
public class UTF8Condition implements Condition{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String encoding = context.getEnvironment().getProperty("file.encoding");
        if (encoding != null) {
            return  "UTF-8".equals(encoding);
        }
        return false;
    }
}
