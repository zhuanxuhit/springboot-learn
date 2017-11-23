package com.edu.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootConfiguration
@EnableMy("hello enable my")
@EnableEcho(packages = {"com.edu.springboot.bean"})
@Import(MyImportBeanDefinitionRegistrar.class)
public class ImportConfig {
}
