package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("责令整改文书")
public class Zlzgws extends BasePojo {

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

    @ChineseName("单位地址")
    private String dwdz;

    @ChineseName("检查场所")
    private String jccs;

    @ChineseName("市")
    private String city;

    @ChineseName("监督管理局")
    private String jdglj;

    @ChineseName("检查人员一")
    private String jcryone;

    @ChineseName("检查人员二")
    private String jcrytwo;

    @ChineseName("检查情况")
    private String jcjl;

    @ChineseName("开具日期")
    private String kjsj;

    @ChineseName("整改到期日期")
    private String zgdqrq;

    @ChineseName("步骤")
    private String step;

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

    public String getDwdz() {
        return dwdz;
    }

    public void setDwdz(String dwdz) {
        this.dwdz = dwdz;
    }

    public String getJccs() {
        return jccs;
    }

    public void setJccs(String jccs) {
        this.jccs = jccs;
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

    public String getKjsj() {
        return kjsj;
    }

    public void setKjsj(String kjsj) {
        this.kjsj = kjsj;
    }

    public String getZgdqrq() {
        return zgdqrq;
    }

    public void setZgdqrq(String zgdqrq) {
        this.zgdqrq = zgdqrq;
    }

    public String getJdglj() {
        return jdglj;
    }

    public void setJdglj(String jdglj) {
        this.jdglj = jdglj;
    }

}
