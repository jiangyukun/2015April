package me.jiangyu.april.web.advisor;

import me.jiangyu.april.core.Constants;
import me.jiangyu.april.core.exception.AjaxException;
import me.jiangyu.april.dto.AjaxResponseFormat;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jiangyukun on 15/4/11.
 */
public class AjaxRequestControllerExceptionAdvice implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AjaxRequestControllerExceptionAdvice.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            Object result = invocation.proceed();
            return result instanceof AjaxResponseFormat ? result : new AjaxResponseFormat(Constants.Code.OK, Constants.SUCCESS, result);
        } catch (AjaxException ajax) {
            logger.error(ajax.getMessage());

        }
        return new AjaxResponseFormat("124438", Constants.EXCEPTION);
    }
}
