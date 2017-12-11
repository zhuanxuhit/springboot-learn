package com.edu.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhuanxu
 */
@Controller
public class AccountController {

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
    @GetMapping("/logout")
    public String logout(Model model){
        model.addAttribute("username","zhuanxu");
        model.addAttribute("status","logout");
        return "logout";
    }
}
