package com.edu.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// 自动注入数组
@ConfigurationProperties(prefix = "mysql")
@Component
public class Mysql {
    private List<String> hosts = new ArrayList<>();

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }
}
