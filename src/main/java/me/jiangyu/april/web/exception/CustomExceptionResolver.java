package me.jiangyu.april.web.exception;

import me.jiangyu.april.core.exception.WebSiteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiangyukun on 2015/3/20.
 */
public class CustomExceptionResolver extends AbstractHandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error(ex.getMessage());
        if (ex instanceof WebSiteException) {
            return new ModelAndView("/index");
        }
        return null;
    }
}
