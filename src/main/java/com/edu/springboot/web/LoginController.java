package com.edu.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhuanxu
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username);
        if (username.equals(password)) {
            return "/ok";
        } else {
            return "/fail";
        }
    }
}
