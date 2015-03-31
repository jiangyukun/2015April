package me.jiangyu.april.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jyk on 2015/3/31.
 */
@Component
public class ExceptionHandler implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.error("ExceptionHandler");
        try {
            return invocation.proceed();
        } catch (Exception e) {
            logger.error("catch");
            return "exception";
        }
    }
}
