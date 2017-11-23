package com.edu.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config/springboot.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            System.out.println("=========" + properties);
            PropertiesPropertySource source = new PropertiesPropertySource("my", properties);
            environment.getPropertySources().addLast(source);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
