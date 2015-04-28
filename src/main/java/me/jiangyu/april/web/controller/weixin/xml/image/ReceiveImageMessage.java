package me.jiangyu.april.web.controller.weixin.xml.image;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import me.jiangyu.april.web.controller.weixin.xml.GenericReceiveMessage;

/**
 * Created by jiangyukun on 4/27/15.
 */
public class ReceiveImageMessage extends GenericReceiveMessage {
    private String picUrl;
    private String mediaId;

    @JacksonXmlProperty(localName = "PicUrl")
    @JacksonXmlCData
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @JacksonXmlProperty(localName = "MediaId")
    @JacksonXmlCData
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
