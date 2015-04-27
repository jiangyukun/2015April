package me.jiangyu.april.core.util;

import me.jiangyu.april.core.WeixinConstants;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * http«Î«Û≤‚ ‘
 * Created by jiangyukun on 2015/4/27.
 */
public class HttpUtilTest {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + PropertiesUtils.getProperty(WeixinConstants.APPID) + "&secret=" + PropertiesUtils.getProperty(WeixinConstants.SECRET));

        System.out.println("Executing request " + httpget.getRequestLine());
        ResponseHandler<String> responseHandler = (response) -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        String responseBody = httpclient.execute(httpget, responseHandler);
        System.out.println(responseBody);
        httpclient.close();
    }
}
