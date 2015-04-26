package me.jiangyu.april.web.debug;

import me.jiangyu.april.core.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 打印Ioc容器中所有的类
 * Created by jiangyukun on 2015/3/26.
 */
@Component
public class WebBeanNamePostProcessor implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(WebBeanNamePostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Constants.DEBUG) {
            logger.info("[web] " + bean.getClass().getName());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
