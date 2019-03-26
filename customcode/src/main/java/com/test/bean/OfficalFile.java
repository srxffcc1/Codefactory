package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
@ChineseName("公文发布;Detail;List:SHOW=articleNumber,name:FUNCTION=查看,回复,快捷回复;")
public class OfficalFile extends BasePojo {
    @ChineseName("索引号")
    private String  fileIndex;
    @ChineseName("文号")
    private String  articleNumber;
    @ChineseName("名称")
    private String name;
    @ChineseName("主题分类")
    private String titleType;
    private String titleTypeVal;
    @ChineseName("体裁分类")
    private String genreType;
    @ChineseName("发布机构")
    private  String publisher;
    @ChineseName("发布日期")
    private String publishTime;
    private String content;
    //接受企业 xzqhjd
    private  String xzqhjd;//未使用
    private String fbzt; //0 未发布 1,已发布 2 归档
    private String receiver;// pub 发往公众端  ent 发送到企业
    public String getFileIndex() {
        return fileIndex;
    }

    public void setFileIndex(String fileIndex) {
        this.fileIndex = fileIndex;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitleTypeVal() {
        return titleTypeVal;
    }

    public void setTitleTypeVal(String titleTypeVal) {
        this.titleTypeVal = titleTypeVal;
    }

    public String getXzqhjd() {
        return xzqhjd;
    }

    public void setXzqhjd(String xzqhjd) {
        this.xzqhjd = xzqhjd;
    }

    public String getFbzt() {
        return fbzt;
    }

    public void setFbzt(String fbzt) {
        this.fbzt = fbzt;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
