package me.jiangyu.april.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiangyukun on 2015/3/20.
 */
@Controller
@RequestMapping("/binder")
public class BinderController {
    @RequestMapping("/test")
    public void test() {
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        System.out.println(dataBinder);
    }
}
