package com.edu.springboot;

//import com.edu.springboot.event.MyApplicationListener;
import com.edu.springboot.event.MyApplicationEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

public class SpringbootApplication {

	public static void main(String[] args) {
//        DelegatingApplicationListener
//        EventListenerMethodProcessor
	    // 会自动扫描配置类
        SpringApplication springApplication = new SpringApplication(
                SpringConfig.class);
        // 设置当前环境
//        springApplication.setAdditionalProfiles("dev");
        // 添加事件监听，另一种通过 @compent 直接交由容器管理
//        springApplication.addListeners(new MyApplicationListener());

		ConfigurableApplicationContext context =  springApplication.run(args);
		// 发布事件
        context.publishEvent(new MyApplicationEvent(new Object()));

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
