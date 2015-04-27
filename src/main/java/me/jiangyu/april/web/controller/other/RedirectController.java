package me.jiangyu.april.web.controller.other;

import me.jiangyu.april.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by jiangyukun on 2015/3/20.
 */
@Controller
@RequestMapping("/redirect")
public class RedirectController {
    public static final String PREFIX = "redirect:";

    @RequestMapping("/action1")
    public String action1(@RequestParam("userId") UserDto dto, Model model) {
        model.addAttribute("id", "sdf");
        return PREFIX + "/action2";
    }

    @RequestMapping("/action2")
    public String action2(Map<String, String> map) {
        System.out.println(map.get("id"));
        return PREFIX + "/action3";
    }

    @RequestMapping("/action3")
    public String action3(Model model) {
        System.out.println(model.containsAttribute("id"));
        return PREFIX + "/action4";
    }

    @RequestMapping("/action4")
    public String action4(Map<String, String> map) {
        System.out.println(map.get("id"));
        return "/index";
    }
}
