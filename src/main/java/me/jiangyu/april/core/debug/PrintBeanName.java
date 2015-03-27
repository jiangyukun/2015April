package me.jiangyu.april.core.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by jiangyukun on 2015/3/26.
 */
@Component
public class PrintBeanName implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(PrintBeanName.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.debug(beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
