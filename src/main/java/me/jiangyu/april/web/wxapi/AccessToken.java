package me.jiangyu.april.web.wxapi;

import me.jiangyu.april.core.WeixinConstants;
import me.jiangyu.april.core.util.HttpClientUtils;
import me.jiangyu.april.core.util.JsonUtil;
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
            String accessTokenStr = HttpClientUtils.getAccessTokenString();
            accessTokenDto = JsonUtil.reader(accessTokenStr, AccessTokenDto.class);
        }
        return accessTokenDto;
    }

    public static void main(String[] args) {
        AccessTokenDto accessTokenDto = AccessToken.getAccessToken();
        System.out.println(accessTokenDto);
    }
}
