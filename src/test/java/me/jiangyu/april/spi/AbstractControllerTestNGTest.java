package me.jiangyu.april.spi;

import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jiangyukun on 2015/3/26.
 */
@WebAppConfiguration
public abstract class AbstractControllerTestNGTest extends AbstractTestNGTest {
    protected MockMvc mockMvc;

    protected abstract Object getController();

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.getController()).build();
    }

    protected void getMock(String url, Object[] params, String expectedContent) throws Exception {
        // 2. 构造GET请求
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url, params);

        this.jsonRequestMock(requestBuilder, expectedContent);
    }

    protected void postMock(String url, String paramsJson, String expectedContent) throws Exception {
        // 2. 构造POST请求
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(url)
                .content(paramsJson) // 设置request body请求体，服务于"@RequestBody"
                ;

        this.jsonRequestMock(requestBuilder, expectedContent);
    }

    private void jsonRequestMock(MockHttpServletRequestBuilder requestBuilder, String expectedContent) throws Exception {
        // 2. 设置HTTP请求属性
        requestBuilder.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
        ;

        // 3. 定义期望响应行为
        this.mockMvc.perform(requestBuilder)
                .andDo(print()) // 打印整个请求与响应细节
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedContent)) // 校验是否是期望的结果
        ;
    }
}
