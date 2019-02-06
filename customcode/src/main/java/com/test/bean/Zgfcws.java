package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("整改复查文书")
public class Zgfcws extends BasePojo {

    /*文号*/
    @ChineseName("城镇")
    private  String town;

    @ChineseName("年份")
    private  String year;

    @ChineseName("部门")
    private  String bm;

    @ChineseName("文号")
    private  String number;

    /*责令整改文号*/
    @ChineseName("责令日期")
    private  String zlrq;

    @ChineseName("年份1")
    private  String zlzgyear;

    @ChineseName("部门1")
    private  String zlzgbm;

    @ChineseName("文号1")
    private  String zlzgnumber;


    @ChineseName("企业id")
    private String qyid;

    @ChineseName("企业名称")
    private String qymc;



    @ChineseName("检查情况")
    private String jcjl;

    @ChineseName("处理决定")
    private String jd;


    @ChineseName("开具日期")
    private String kjsj;

    @ChineseName("步骤")
    private String step;

    public String getStep() {
        return step;
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

    public String getZlrq() {
        return zlrq;
    }

    public void setZlrq(String zlrq) {
        this.zlrq = zlrq;
    }

    public String getZlzgyear() {
        return zlzgyear;
    }

    public void setZlzgyear(String zlzgyear) {
        this.zlzgyear = zlzgyear;
    }

    public String getZlzgbm() {
        return zlzgbm;
    }

    public void setZlzgbm(String zlzgbm) {
        this.zlzgbm = zlzgbm;
    }

    public String getZlzgnumber() {
        return zlzgnumber;
    }

    public void setZlzgnumber(String zlzgnumber) {
        this.zlzgnumber = zlzgnumber;
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

    public String getJcjl() {
        return jcjl;
    }

    public void setJcjl(String jcjl) {
        this.jcjl = jcjl;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getKjsj() {
        return kjsj;
    }

    public void setKjsj(String kjsj) {
        this.kjsj = kjsj;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
