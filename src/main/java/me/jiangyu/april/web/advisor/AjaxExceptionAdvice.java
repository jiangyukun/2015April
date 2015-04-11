package me.jiangyu.april.web.advisor;

import me.jiangyu.april.core.Constants;
import me.jiangyu.april.core.exception.AjaxException;
import me.jiangyu.april.dto.DtoReturned;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jiangyukun on 15/4/11.
 */
public class AjaxExceptionAdvice implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AjaxExceptionAdvice.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return invocation.proceed();
        } catch (AjaxException ajax) {
            logger.error(ajax.getMessage());

        }
        return new DtoReturned(Constants.EXCEPTION);
    }
}
