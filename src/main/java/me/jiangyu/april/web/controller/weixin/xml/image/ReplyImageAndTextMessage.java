package me.jiangyu.april.web.controller.weixin.xml.image;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import me.jiangyu.april.core.WeixinConstants;
import me.jiangyu.april.web.controller.weixin.xml.GenericReplyMessage;

/**
 * 回复图文消息
 * Created by jiangyukun on 4/27/15.
 */

public class ReplyImageAndTextMessage extends GenericReplyMessage {
    private int articleCount;
    private Articles articles;

    public ReplyImageAndTextMessage() {
    }

    public ReplyImageAndTextMessage(ReceiveImageMessage receiveImageMessage) {
        super(receiveImageMessage);
        setMsgType(WeixinConstants.MESSAGE_TYPE_NEWS);
        setArticleCount(1);
        Item item = new Item();
        item.setPicUrl(receiveImageMessage.getPicUrl());
        item.setDescription("test");
        item.setTitle("测试啦");
        item.setUrl("http://test.jiangyu.me");
        Articles articles = new Articles();
        articles.setItem(item);
        setArticles(articles);
    }

    public static class Articles {
        private Item item;

        @JacksonXmlProperty(localName = "item")
        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }
    }

    @JacksonXmlProperty(localName = "ArticleCount")
    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    @JacksonXmlProperty(localName = "Articles")
    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public static class Item {
        private String title = "test";
        private String description = "test";
        private String picUrl = "test";
        private String url = "test";

        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @JacksonXmlProperty(localName = "Description")
        @JacksonXmlCData
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @JacksonXmlProperty(localName = "PicUrl")
        @JacksonXmlCData
        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        @JacksonXmlProperty(localName = "Url")
        @JacksonXmlCData
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
