package com.edu.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 属性自动注入，此时能做成是因为 @EnableAutoConfiguration 这个注解
@ConfigurationProperties(prefix = "author")
@Component
public class Author {

    private String name;

    private Integer age;

    public void show() {
        System.out.println("AuthorConfig name: " + name + " age: " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
