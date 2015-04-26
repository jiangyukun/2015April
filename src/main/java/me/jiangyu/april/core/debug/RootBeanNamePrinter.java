package me.jiangyu.april.core.debug;

import me.jiangyu.april.core.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 打印Ioc容器中所有的类
 * Created by jiangyukun on 2015/3/26.
 */
@Component
public class RootBeanNamePrinter implements BeanPostProcessor, BeanFactoryAware {
    private static final Logger logger = LoggerFactory.getLogger(RootBeanNamePrinter.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Constants.DEBUG) {
            logger.info("[root] " + bean);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (Constants.DEBUG) {
            ConfigurableListableBeanFactory configurableListableBeanFactory = (ConfigurableListableBeanFactory) beanFactory;
            String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
            for (String beanName : beanNames) {
                BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
                logger.info(beanDefinition.getBeanClassName());
            }
        }
    }
}
