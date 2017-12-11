package com.edu.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuanxu
 * 表明函数返回可以直接作为body ResponseBody
 */
@RestController
public class RoleController {
    @GetMapping("/role/show")
    public String show() {
        System.out.println("====role show====");
        return "role show";
    }
    @GetMapping("/role/empty")
    public String args() throws IllegalArgumentException {
        throw new IllegalArgumentException("args empty");
    }
    @GetMapping("/role/null")
    public String empty() throws NullPointerException {
        throw new NullPointerException("null");
    }
}
