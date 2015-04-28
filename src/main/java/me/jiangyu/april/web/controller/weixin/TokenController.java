package me.jiangyu.april.web.controller.weixin;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import me.jiangyu.april.core.WeixinConstants;
import me.jiangyu.april.web.controller.weixin.xml.GenericReceiveMessage;
import me.jiangyu.april.web.controller.weixin.xml.image.ReceiveImageMessage;
import me.jiangyu.april.web.controller.weixin.xml.image.ReplyImageAndTextMessage;
import me.jiangyu.april.web.controller.weixin.xml.text.ReceiveTextMessage;
import me.jiangyu.april.web.controller.weixin.xml.text.ReplyTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

/**
 * 启用服务器配置、接收回复消息
 * Created by jyk on 2015/4/25.
 */
@Controller
@RequestMapping("/weixin")
public class TokenController {
    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);
    private XmlMapper xmlMapper = new XmlMapper();

    @RequestMapping(value = "event", method = RequestMethod.GET)
    @ResponseBody
    public String token(String signature, long timestamp, int nonce, String echostr) {
        logger.info("启用服务器配置 signature: " + signature + " timestamp: " + timestamp + " nonce: " + nonce + " echostr: " + echostr);
        return echostr;
    }

    /**
     * 回复消息
     *
     * @param request  HttpServletRequest
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
        String xml = printXml(is);

        GenericReceiveMessage receiveXml = null;
        try {
            receiveXml = xmlMapper.readValue(xml, ReceiveTextMessage.class);
        } catch (Throwable t) {
            logger.debug("解析文本消息失败！" + t.getMessage());
            try {
                receiveXml = xmlMapper.readValue(xml, ReceiveImageMessage.class);
            } catch (Exception e) {
                logger.debug("解析图文消息失败！" + t.getMessage());
            }
        }
        String replyXml;
        Assert.notNull(receiveXml);
        logger.info(receiveXml.getMsgType());
        switch (receiveXml.getMsgType()) {
            case WeixinConstants.MESSAGE_TYPE_TEXT:
                replyXml = replyTextMessage((ReceiveTextMessage) receiveXml);
                break;
            case WeixinConstants.MESSAGE_TYPE_IMAGE:
                replyXml = replyImageAndTextMessage((ReceiveImageMessage) receiveXml);
                break;
            default:
                logger.debug("回复其他消息");
                replyXml = "";
                break;
        }
        Assert.hasLength(replyXml);
        response.getWriter().write(replyXml);
    }

    private String printXml(InputStream is) throws IOException {
        String line, xml = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        while ((line = bufferedReader.readLine()) != null) {
            xml += line;
        }
        logger.debug("消息内容为：" + xml);
        return xml;
    }

    private String replyImageAndTextMessage(ReceiveImageMessage receiveXml) throws IOException {
        ReplyImageAndTextMessage imageAndTextMessage = new ReplyImageAndTextMessage(receiveXml);
        String replyTextXml = xmlMapper.writeValueAsString(imageAndTextMessage);
        replyTextXml = replyTextXml.replaceFirst(" xmlns=\"\"", "");
        logger.info("回复图文消息：" + replyTextXml);
        return replyTextXml;
    }

    private String replyTextMessage(ReceiveTextMessage textMessage) throws IOException {
        logger.info("receive text message");
        logger.info("\t --- " + String.format("FromUser: %s ToUser: %s Content: %s CreateTime: %s MsgId: %s MsgType: %s",
                textMessage.getFromUserName(), textMessage.getToUserName(), textMessage.getContent(),
                textMessage.getCreateTime(), textMessage.getMsgId(), textMessage.getMsgType()));
        ReplyTextMessage replyMessage = new ReplyTextMessage(textMessage);
        String replyTextXml = xmlMapper.writeValueAsString(replyMessage);
        replyTextXml = replyTextXml.replaceFirst(" xmlns=\"\"", "");
        logger.info("回复文本消息：" + replyTextXml);
        return replyTextXml;
    }
}
