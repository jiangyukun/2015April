package me.jiangyu.april.web.wxapi;

import me.jiangyu.april.core.WeixinConstants;
import me.jiangyu.april.core.util.PropertiesUtils;
import me.jiangyu.april.dto.weixin.AccessTokenDto;

/**
 * ªÒ»°Œ¢–≈access_token
 * Created by jiangyukun on 2015/4/27.
 */
public class AccessToken {
    private static AccessTokenDto accessTokenDto;

    public static AccessTokenDto getAccessToken() {
        if (accessTokenDto == null) {
            String accessTokenBaseUrl = PropertiesUtils.getProperty(WeixinConstants.ACCESS_TOKEN_BASE_URL_KEY);
        }
        return null;
    }
}
