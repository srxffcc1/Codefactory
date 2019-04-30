package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("现场处理措施文书")
public class Xcclws extends BasePojo {

    @ChineseName("城镇")
    private  String town;

    @ChineseName("年份")
    private  String year;

    @ChineseName("部门")
    private  String bm;

    @ChineseName("文号")
    private  String number;

    @ChineseName("企业id")
    private String qyid;

    @ChineseName("企业名称")
    private String qymc;

    @ChineseName("监督管理局")
    private String jdglj;

    @ChineseName("市")
    private String city;

    @ChineseName("检查人员一")
    private String jcryone;

    @ChineseName("检查人员二")
    private String jcrytwo;

    @ChineseName("检查情况")
    private String jcjl;

    @ChineseName("处理决定")
    private String cljd;

    @ChineseName("开具日期")
    private String kjsj;

    @ChineseName("步骤")
    private String step;

    @ChineseName("现场依据")
    private String xcyj;

    @ChineseName("现场检查时间")
    private String xcjcsj;

    public String getXcjcsj() {
        return xcjcsj;
    }

    public void setXcjcsj(String xcjcsj) {
        this.xcjcsj = xcjcsj;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getJdglj() {
        return jdglj;
    }

    public void setJdglj(String jdglj) {
        this.jdglj = jdglj;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJcryone() {
        return jcryone;
    }

    public void setJcryone(String jcryone) {
        this.jcryone = jcryone;
    }

    public String getJcrytwo() {
        return jcrytwo;
    }

    public void setJcrytwo(String jcrytwo) {
        this.jcrytwo = jcrytwo;
    }

    public String getJcjl() {
        return jcjl;
    }

    public void setJcjl(String jcjl) {
        this.jcjl = jcjl;
    }

    public String getCljd() {
        return cljd;
    }

    public void setCljd(String cljd) {
        this.cljd = cljd;
    }

    public String getKjsj() {
        return kjsj;
    }

    public void setKjsj(String kjsj) {
        this.kjsj = kjsj;
    }

    public String getXcyj() {
        return xcyj;
    }

    public void setXcyj(String xcyj) {
        this.xcyj = xcyj;
    }
}
