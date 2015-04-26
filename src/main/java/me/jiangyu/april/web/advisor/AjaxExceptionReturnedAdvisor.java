package me.jiangyu.april.web.advisor;

import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangyukun on 15/4/11.
 */
@Component
public class AjaxExceptionReturnedAdvisor extends AbstractPointcutAdvisor {
    private static final Logger logger = LoggerFactory.getLogger(AjaxExceptionReturnedAdvisor.class);

    @Override
    public Pointcut getPointcut() {
        return new AnnotationMatchingPointcut(RestController.class);
    }

    @Override
    public Advice getAdvice() {
        return new AjaxRequestControllerExceptionAdvice();
    }
}
