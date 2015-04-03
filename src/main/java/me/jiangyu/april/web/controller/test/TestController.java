package me.jiangyu.april.web.controller.test;

import me.jiangyu.april.core.exception.WebSiteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by jiangyukun on 2015/3/20.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(Map<String, String> map) throws Exception {
        map.put("id", "123");
        throw new WebSiteException("exception1");
    }

    @RequestMapping("/login")
    public String login() throws Exception {
        return "/login";
    }

    @RequestMapping("/pushState")
    public void pushState() {
    }

    @RequestMapping("/add")
    public void add() {
    }

    @RequestMapping("/detail")
    public void detail() {
    }
}
