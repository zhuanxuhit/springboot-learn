package com.edu.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhuanxu
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user/home",method = {RequestMethod.GET})
    @ResponseBody
    public String home() {
        return "user home";
    }

    @GetMapping("/user/show")
    @ResponseBody
    public String show() {
        return "user show";
    }
    @PostMapping("/user/create")
    @ResponseBody
    public String create(@RequestParam(name = "username", defaultValue = "wc") String name, @RequestParam(name = "password") String password){
        return "user create, username=" + name + " password=" + password;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public String display(@PathVariable(name = "id") String id){
        return  "user: " + id;
    }
    @GetMapping("/user/ip")
    @ResponseBody
    public String display(HttpServletRequest req){
        return  "user ip: "  + req.getRemoteHost();
    }
}
