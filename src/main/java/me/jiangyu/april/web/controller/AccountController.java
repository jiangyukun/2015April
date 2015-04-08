package me.jiangyu.april.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jyk on 2015/4/8.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @RequestMapping("/login")
    public void login() {
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username, String password) {
        return "redirect:/index";
    }
}
