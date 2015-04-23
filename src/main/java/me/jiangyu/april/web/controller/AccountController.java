package me.jiangyu.april.web.controller;

import me.jiangyu.april.dto.AjaxResponseFormat;
import me.jiangyu.april.entity.User;
import me.jiangyu.april.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jyk on 2015/4/8.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public void login() {
    }

    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        return "redirect:/index";
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxResponseFormat save(User user) {
        userService.save(user);
        return AjaxResponseFormat.DEFAULT;
    }
}
