package com.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringbootApplication {

	public static void main(String[] args) {
	    // 会自动扫描配置类
        SpringApplication springApplication = new SpringApplication(
                SpringConfig.class);
        // 设置当前环境
//        springApplication.setAdditionalProfiles("dev");

		ConfigurableApplicationContext context =  springApplication.run(args);
        // 获取配置
		System.out.println(context.getEnvironment().getProperty("local.ip"));
        context.getBean(Author.class).show();
        System.out.println(context.getEnvironment().getProperty("spring.name"));

//        List<String> hosts = new ArrayList<String>(context.getEnvironment().getProperty("mysql.hosts"));
        System.out.println(context.getEnvironment().getProperty("mysql.hosts[0]"));
        System.out.println(context.getBean(Mysql.class).getHosts());


        // 自动配置实现
//        Condition
//        Conditional
        System.out.println(context.getEnvironment().getProperty("file.encoding"));
        System.out.println(Arrays.toString(context.getBeanNamesForType(EncodingConverter.class)));
        System.out.println(context.getBean(Tomcat.class));

        // 注解
//        context.getBean("jeep",Runnable.class).run();
        System.out.println("=======end=======");
        System.out.println(context.getBean(User.class));
        System.out.println(context.getBean(Role.class));
        System.out.println(context.getBean(Cat.class));
        context.close();
    }
}
