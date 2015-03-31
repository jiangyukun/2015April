package me.jiangyu.april.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * Created by jyk on 2015/3/31.
 */
@Controller
@RequestMapping("/session")
@SessionAttributes("userId")
public class SessionController {
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping("/test1")
    public void test1(ModelMap map) {
        map.addAttribute("userId", "abc");
    }

    @RequestMapping("/test3")
    public void test3(Map<String, String> map) {
        map.put("userId", "abc");
    }

    @RequestMapping("/test2")
    public void test2(ModelMap map) {
        String userId = (String) map.get("userId");
        logger.debug(userId);
    }
}
