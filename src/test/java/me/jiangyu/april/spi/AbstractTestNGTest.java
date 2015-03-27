package me.jiangyu.april.spi;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

/**
 * Created by jiangyukun on 2015/3/26.
 */
@ContextConfiguration({
        "classpath:testRoot.xml",
        "classpath:testMvc.xml"
})
public abstract class AbstractTestNGTest extends AbstractTestNGSpringContextTests { // 集成TestNG
    @BeforeSuite(alwaysRun = true)
    public void init() {
//      MockitoAnnotations.initMocks(this); // 基于Spring自动装配注解，这里不再需要初始化
    }
}