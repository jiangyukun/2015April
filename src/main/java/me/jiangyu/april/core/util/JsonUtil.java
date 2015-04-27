package me.jiangyu.april.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.jiangyu.april.core.exception.UnExpectedException;

/**
 * Created by jiangyukun on 2015/4/27.
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T reader(String str, Class<T> type) {
        try {
            return objectMapper.readValue(str, type);
        } catch (Exception e) {
            throw new UnExpectedException(e.getMessage());
        }
    }
}
