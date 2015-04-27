package me.jiangyu.april.web.controller.weixin;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import me.jiangyu.april.web.controller.weixin.xml.ReceiveMessage;
import me.jiangyu.april.web.controller.weixin.xml.ReplyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * 启用服务器配置、接收回复消息
 * Created by jyk on 2015/4/25.
 */
@Controller
@RequestMapping("/weixin")
public class TokenController {
    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

    @RequestMapping(value = "event", method = RequestMethod.GET)
    @ResponseBody
    public String token(String signature, long timestamp, int nonce, String echostr) {
        logger.info("启用服务器配置 signature: " + signature + " timestamp: " + timestamp + " nonce: " + nonce + " echostr: " + echostr);
        return echostr;
    }

    /**
     * 回复消息
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(value = "event", method = RequestMethod.POST)
    public void message(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            logger.debug(String.format("Header- [%s: %s]", headers.nextElement(), request.getHeader(headers.nextElement())));
        }
        InputStream is = request.getInputStream();
        XmlMapper xmlMapper = new XmlMapper();
        ReceiveMessage receiveXml = new ReceiveMessage();
        try {
            receiveXml = xmlMapper.readValue(is, ReceiveMessage.class);
        } catch (Throwable t) {
            logger.error(t.getMessage());
        }
        logger.info("event[get] message");
        logger.info("\t --- " + String.format("FromUser: %s ToUser: %s Content: %s CreateTime: %s MsgId: %s MsgType: %s",
                receiveXml.getFromUserName(), receiveXml.getToUserName(), receiveXml.getContent(),
                receiveXml.getCreateTime(), receiveXml.getMsgId(), receiveXml.getMsgType()));
        ReplyMessage replyMessage = new ReplyMessage(receiveXml);
        String replyXml = xmlMapper.writeValueAsString(replyMessage);
        replyXml = replyXml.replaceFirst(" xmlns=\"\"", "");
        logger.info("回复消息：" + replyXml);
        response.getWriter().write(replyXml);
    }
}
