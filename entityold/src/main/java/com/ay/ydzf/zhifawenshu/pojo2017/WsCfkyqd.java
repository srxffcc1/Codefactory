package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

import java.util.List;

//@ChineseName("查封扣押（场所、设施、财物）清单")
public class WsCfkyqd extends BasePojo {
    @ChineseName("行政执法id")
    public String xzzfid;
    @ChineseName("执法文书名称")
    public String tname;
    @ChineseName("填报时间")
    public String tbsj;
    @ChineseName("企业ID")
    public String qyid;
    @ChineseName("地方")
    public String pcode;
    @ChineseName("字")
    public String ycode;
    @ChineseName("号")
    public String ncode;
    @ChineseName("版本号")
    public String version;

    /** 场所、设施、财物 **/
    public List<Cfky> cfkyList;

    @ChineseName("当事人（签名或者盖章）")
    public String dsrqz;
    @ChineseName("当事人日期")
    public String dsrrq;
    @ChineseName("安全生产监管行政执法人员（签名 ）1")
    public String zfrqz1;
    @ChineseName("证号1")
    public String zfrzh1;
    @ChineseName("日期1")
    public String zfrrq1;
    @ChineseName("安全生产监管行政执法人员（签名 ）2")
    public String zfrqz2;
    @ChineseName("证号2")
    public String zfrzh2;
    @ChineseName("日期2")
    public String zfrrq2;

    @ChineseName("备用1")
    public String by1;
    @ChineseName("备用2")
    public String by2;
    @ChineseName("备用3")
    public String by3;

    public String getXzzfid() {
        return xzzfid;
    }

    public void setXzzfid(String xzzfid) {
        this.xzzfid = xzzfid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTbsj() {
        return tbsj;
    }

    public void setTbsj(String tbsj) {
        this.tbsj = tbsj;
    }

    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getYcode() {
        return ycode;
    }

    public void setYcode(String ycode) {
        this.ycode = ycode;
    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Cfky> getCfkyList() {
        return cfkyList;
    }

    public void setCfkyList(List<Cfky> cfkyList) {
        this.cfkyList = cfkyList;
    }

    public String getDsrqz() {
        return dsrqz;
    }

    public void setDsrqz(String dsrqz) {
        this.dsrqz = dsrqz;
    }

    public String getDsrrq() {
        return dsrrq;
    }

    public void setDsrrq(String dsrrq) {
        this.dsrrq = dsrrq;
    }

    public String getZfrqz1() {
        return zfrqz1;
    }

    public void setZfrqz1(String zfrqz1) {
        this.zfrqz1 = zfrqz1;
    }

    public String getZfrzh1() {
        return zfrzh1;
    }

    public void setZfrzh1(String zfrzh1) {
        this.zfrzh1 = zfrzh1;
    }

    public String getZfrrq1() {
        return zfrrq1;
    }

    public void setZfrrq1(String zfrrq1) {
        this.zfrrq1 = zfrrq1;
    }

    public String getZfrqz2() {
        return zfrqz2;
    }

    public void setZfrqz2(String zfrqz2) {
        this.zfrqz2 = zfrqz2;
    }

    public String getZfrzh2() {
        return zfrzh2;
    }

    public void setZfrzh2(String zfrzh2) {
        this.zfrzh2 = zfrzh2;
    }

    public String getZfrrq2() {
        return zfrrq2;
    }

    public void setZfrrq2(String zfrrq2) {
        this.zfrrq2 = zfrrq2;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3;
    }

}