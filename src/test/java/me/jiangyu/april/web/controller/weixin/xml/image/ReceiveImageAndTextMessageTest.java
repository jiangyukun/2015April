package me.jiangyu.april.web.controller.weixin.xml.image;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class ReceiveImageAndTextMessageTest {
    private static XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) throws IOException {
        ReplyImageAndTextMessage imageAndTextMessage = new ReplyImageAndTextMessage();
        imageAndTextMessage.setArticleCount(1);
        ReplyImageAndTextMessage.Articles articles = new ReplyImageAndTextMessage.Articles();
        ReplyImageAndTextMessage.Item item = new ReplyImageAndTextMessage.Item();
        articles.setItem(item);
        imageAndTextMessage.setArticles(articles);
        System.out.println(xmlMapper.writeValueAsString(imageAndTextMessage));
    }

}
