package me.jiangyu.april.web.controller.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jyk on 2015/3/27.
 */
@Controller
@RequestMapping("/weixin")
public class TokenController {
    @RequestMapping("/token")
    @ResponseBody
    public String token(String signature, long timestamp, int nonce, String echostr) {
        return echostr;
    }
}
