package com.edu.springboot.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuanxu
 */
@Repository
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(String name) {
        String sql = "insert into product (pname) values('" + name + "')";
        this.jdbcTemplate.execute(sql);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addProductBatch(String... names) {
        for (String name :
                names) {
            String sql = "insert into product (pname) values('" + name + "')";
            this.jdbcTemplate.execute(sql);
        }
    }
}
