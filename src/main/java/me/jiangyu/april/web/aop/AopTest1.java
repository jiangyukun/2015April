package me.jiangyu.april.web.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jyk on 2015/3/31.
 */
@Component
public class AopTest1 {
    private static final Logger logger = LoggerFactory.getLogger(AopTest1.class);

    public String print() {
        logger.error("test1");
        throw new RuntimeException("throw");
    }
}
