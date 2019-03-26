package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

@ChineseName("通知公告;Detail;List:SHOW=noticeTitle,noticeContent:FUNCTION=查看,修改,发布,撤回;")
public class GovNotice extends BasePojo {

    @ChineseName("标题")
    private  String noticeTitle;

    @ChineseName("内容")
    private String noticeContent;

    @ChineseName("发布人")
    private String publisher;

    private String fbzt;//0 未发布,1 已发布


    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getFbzt() {
        return fbzt;
    }

    public void setFbzt(String fbzt) {
        this.fbzt = fbzt;
    }
}
