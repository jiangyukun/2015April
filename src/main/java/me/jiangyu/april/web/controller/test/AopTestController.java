package me.jiangyu.april.web.controller.test;

import me.jiangyu.april.web.aop.AopTest1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by jyk on 2015/3/31.
 */
@Controller
@RequestMapping("/aop")
public class AopTestController {
    private static final Logger logger = LoggerFactory.getLogger(AopTestController.class);

    @Resource(name = "aopTest1Proxy")
    private AopTest1 aopTest1;

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        String a = aopTest1.print();
        logger.error("::" + a);
        throw new RuntimeException("..");
    }
}
