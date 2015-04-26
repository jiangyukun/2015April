package me.jiangyu.april.web.controller.weixin;

import me.jiangyu.april.web.controller.weixin.xml.ReceiveMessage;
import me.jiangyu.april.web.controller.weixin.xml.ReplyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 启用服务器配置
 * Created by jyk on 2015/3/27.
 */
@Controller
@RequestMapping("/weixin")
public class TokenController {
    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

    @RequestMapping(value = "event", method = RequestMethod.GET)
    @ResponseBody
    public String token(String signature, long timestamp, int nonce, String echostr) {
        logger.info("server config :: signature: " + signature + " timestamp: " + timestamp + " nonce: " + nonce + " echostr: " + echostr);
        return echostr;
    }

    /**
     * 回复消息
     *
     * @return 消息
     */
    @RequestMapping(value = "event", method = RequestMethod.POST, consumes = {"application/xml"}, produces = {"application/xml;charset=utf-8"})
    @ResponseBody
    public ReplyMessage message(@RequestBody ReceiveMessage receiveXml) {
        logger.info("event[get] message");
        logger.info("\t --- " + String.format("FromUser: %s ToUser: %s Content: %s CreateTime: %s MsgId: %s",
                receiveXml.getFromUserName(), receiveXml.getToUserName(), receiveXml.getContent(), receiveXml.getCreateTime(), receiveXml.getMsgId()));
        return new ReplyMessage(receiveXml);
    }
}
