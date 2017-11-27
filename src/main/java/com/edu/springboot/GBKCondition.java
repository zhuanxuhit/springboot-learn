package com.edu.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 该类可以被
public class GBKCondition implements Condition{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String encoding = context.getEnvironment().getProperty("file.encoding");
        if (encoding != null) {
            return  "gbk".equals(encoding);
        }
        return false;
    }
}
