package me.jiangyu.april.web;

import me.jiangyu.april.spi.AbstractControllerTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.NestedServletException;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by jiangyukun on 2015/3/10.
 */
public class TestControllerTest extends AbstractControllerTestNGTest {
    @Autowired
    private TestController indexController;

    @Override
    protected Object getController() {
        return indexController;
    }

    @Test(expectedExceptions = {NestedServletException.class})
    public void testIndex() throws Exception {
        this.mockMvc.perform(
                post("/index")
        ).andExpect(
                content().string("xxx")
        )
        ;
    }
}
