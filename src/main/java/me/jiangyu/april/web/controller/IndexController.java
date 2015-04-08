package me.jiangyu.april.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jyk on 2015/4/8.
 */
@Controller
public class IndexController {
    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }
}
