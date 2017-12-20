package com.edu.springboot.jdbc;


import com.edu.springboot.jdbc.dao.ProductDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhuanxu
 */
@SpringBootApplication
@PropertySources({@PropertySource("classpath:/config/jdbc.properties")})
@EnableTransactionManagement
public class Jdbc {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Jdbc.class);
        DataSource dataSource =  context.getBean(DataSource.class);
        System.out.println(dataSource.getClass());
        try(Connection connection = dataSource.getConnection()) {
        // try-resource, 自动 close
            context.getBean(ProductDao.class).addProduct("MP3");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
