package me.jiangyu.april.web.controller.weixin.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import me.jiangyu.april.core.WeixinConstants;

/**
 * 回复微信消息
 * Created by jiangyukun on 4/25/15.
 */
@JacksonXmlRootElement(localName = "xml")
public class ReplyMessage {

    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private String content;

    public ReplyMessage(ReceiveMessage receiveXml) {
        this.setFromUserName(receiveXml.getToUserName());
        this.setToUserName(receiveXml.getFromUserName());
        this.setContent(receiveXml.getContent());
        this.setCreateTime(System.currentTimeMillis());
        this.setMsgType(WeixinConstants.MESSAGE_TYPE_TEXT);
    }

    @JacksonXmlProperty(localName = "ToUserName")
    @JacksonXmlCData
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }


    @JacksonXmlProperty(localName = "FromUserName")
    @JacksonXmlCData
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @JacksonXmlProperty(localName = "CreateTime")
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @JacksonXmlProperty(localName = "MsgType")
    @JacksonXmlCData
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
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
