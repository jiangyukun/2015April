package me.jiangyu.april.dto.weixin;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jiangyukun on 2015/4/27.
 */
public class AccessTokenDto {
    private String accessToken;
    private String expiresIn;

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("expires_in")
    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

}
