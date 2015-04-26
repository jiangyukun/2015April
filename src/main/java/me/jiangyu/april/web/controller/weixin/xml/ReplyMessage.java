package me.jiangyu.april.web.controller.weixin.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import me.jiangyu.april.web.WeixinConstants;

/**
 * 回复微信消息
 * Created by jiangyukun on 4/25/15.
 */
@JacksonXmlRootElement(localName = "xml")
public class ReplyMessage {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Content;

    public ReplyMessage(ReceiveMessage receiveXml) {
        this.setFromUserName(receiveXml.getToUserName());
        this.setToUserName(receiveXml.getFromUserName());
        this.setContent(receiveXml.getContent());
        this.setCreateTime(receiveXml.getCreateTime());
        this.setMsgType(WeixinConstants.MESSAGE_TYPE_TEXT);
    }

    @JacksonXmlProperty(localName = "ToUserName")
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    @JacksonXmlProperty(localName = "FromUserName")
    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    @JacksonXmlProperty(localName = "CreateTime")
    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    @JacksonXmlProperty(localName = "MsgType")
    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    @JacksonXmlProperty(localName = "Content")
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
