package me.jiangyu.april.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.Properties;

/**
 * ¶ÁÈ¡propertiesÎÄ¼þ
 * Created by jiangyukun on 2015/4/27.
 */
public class PropertiesUtils {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    private static Properties properties = new Properties();

    static {
        try {
            Resource resource = new ClassPathResource("/weixin/wx.properties");
            InputStream inputStream = resource.getInputStream();
            properties.load(inputStream);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * ²âÊÔ
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getProperty("access_token_base_url"));
    }
}
