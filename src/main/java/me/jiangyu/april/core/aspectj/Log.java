package me.jiangyu.april.core.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyukun on 2015/3/26.
 */
@Aspect
@Component
public class Log {
    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    @Pointcut("execution(* me.jiangyu.april.web.TestController.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforeController() {
        logger.error("before");
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public String afterThrowing(JoinPoint jp, Exception e) {
        logger.error("xc");
        return "xxx";
    }

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        logger.error("abc");
    }
}
