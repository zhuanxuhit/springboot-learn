package com.edu.springboot.tomcat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuanxu
 */
@RestController
public class UserController {
    @GetMapping("/user/show")
    public String show(){
        return "user show";
    }
}
