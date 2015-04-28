package me.jiangyu.april.web.controller.weixin.xml.text;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import me.jiangyu.april.web.controller.weixin.xml.GenericReplyMessage;

/**
 * 回复微信消息
 * Created by jiangyukun on 4/25/15.
 */
public class ReplyTextMessage extends GenericReplyMessage {
    private String content;

    public ReplyTextMessage(ReceiveTextMessage receiveXml) {
        super(receiveXml);
        this.content = receiveXml.getContent();
    }

    @JacksonXmlProperty(localName = "Content")
    @JacksonXmlCData
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
