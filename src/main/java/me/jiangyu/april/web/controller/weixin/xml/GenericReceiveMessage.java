package me.jiangyu.april.web.controller.weixin.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 接收到的消息基类
 * Created by jiangyukun on 4/27/15.
 */
public class GenericReceiveMessage extends GenericMessage {
    private String msgId;

    @JacksonXmlProperty(localName = "MsgId")
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
