package me.jiangyu.april.web.controller.weixin.xml;

/**
 * �ظ���Ϣ����
 * Created by jiangyukun on 4/27/15.
 */
public class GenericReplyMessage extends GenericMessage {
    public GenericReplyMessage() {
    }

    public GenericReplyMessage(GenericReceiveMessage receiveMessage) {
        setFromUserName(receiveMessage.getToUserName());
        setToUserName(receiveMessage.getFromUserName());
        setMsgType(receiveMessage.getMsgType());
        setCreateTime(System.currentTimeMillis());
    }
}
