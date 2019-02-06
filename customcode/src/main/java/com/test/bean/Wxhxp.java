package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;


@ChineseName("危险化学品重大危险源信息;Detail;List:SHOW=wxydymc,zycp:FUNCTION=修改,阶段操作;")
public class Wxhxp extends BasePojo {
    private String qyzzjgdm;
    @ChineseName("企业名称")
    private String qymc;
    @ChineseName("危险源单元名称")
    private String wxydymc;
    @ChineseName("重大危险源级别")
    private String wxyjb;
    private String wxyname;
    @ChineseName("所在地区;Spinner:url=data/dataAction!findByTypeId?typeId=0b8415e08bf3474686e643318c0a497c&parentId=239787ea0e834a379ae0b8cfde1df307:codekey=dataCode:namekey=dataName;Must")
    private String szdq;
    private String szdqname;
    @ChineseName("详细地址")
    private String xxdz;
    @ChineseName("生产经营活动类型;Spinner:url=data/dataAction!findByType?typeId=scfs&parentId=-1:codekey=dataCode:namekey=dataName;")
    private String scjyhdlx;
    @ChineseName("生产存储产所产权;Spinner:url=data/dataAction!findByType?typeId=sccccscq&parentId=-1:codekey=dataCode:namekey=dataName;")
    private String sccccscq;
    @ChineseName("主要产品")
    private String zycp;
    @ChineseName("防雷防静电设施是否定期接受检测;Spinner:string=是,否;Hide")
    private String flfjdssdqjc;
    @ChineseName("压力容器总数")
    private String ylrqzs;
    @ChineseName("三类压力容器数量")
    private String slylrqsl;
    @ChineseName("R值")
    private String rz;
    @ChineseName("经度")
    private String jd;
    @ChineseName("纬度")
    private String wd;
    @ChineseName("备注")
    private String bz;
    @ChineseName("是否重大危险源")
    private String sfzdwxy;//是否重大危险源
    @ChineseName("风险评估等级")
    //风险评估等级
    private String fxpgdj;
    private String video;
    private String jiance;
    @ChineseName("备案单位;Spinner:string=是,否;")
    private String badw;//备案单位
    @ChineseName("备案编号")
    private String babh;//备案编号
    @ChineseName("评估报告")
    private String pgbg;//评估报告
    private String msdsIds;//MDSD的id们


    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getJiance() {
        return jiance;
    }

    public void setJiance(String jiance) {
        this.jiance = jiance;
    }

    public String getFxpgdj() {
        return fxpgdj;
    }

    public void setFxpgdj(String fxpgdj) {
        this.fxpgdj = fxpgdj;
    }

    public String getSfzdwxy() {
        return sfzdwxy;
    }

    public void setSfzdwxy(String sfzdwxy) {
        this.sfzdwxy = sfzdwxy;
    }

    public String getWxyname() {
        return wxyname;
    }

    public void setWxyname(String wxyname) {
        this.wxyname = wxyname;
    }

    public String getQyzzjgdm() {
        return qyzzjgdm;
    }

    public void setQyzzjgdm(String qyzzjgdm) {
        this.qyzzjgdm = qyzzjgdm;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getWxydymc() {
        return wxydymc;
    }

    public void setWxydymc(String wxydymc) {
        this.wxydymc = wxydymc;
    }

    public String getWxyjb() {
        return wxyjb;
    }

    public void setWxyjb(String wxyjb) {
        this.wxyjb = wxyjb;
    }

    public String getSzdq() {
        return szdq;
    }

    public void setSzdq(String szdq) {
        this.szdq = szdq;
    }

    public String getXxdz() {
        return xxdz;
    }

    public void setXxdz(String xxdz) {
        this.xxdz = xxdz;
    }

    public String getScjyhdlx() {
        return scjyhdlx;
    }

    public void setScjyhdlx(String scjyhdlx) {
        this.scjyhdlx = scjyhdlx;
    }

    public String getSccccscq() {
        return sccccscq;
    }

    public void setSccccscq(String sccccscq) {
        this.sccccscq = sccccscq;
    }

    public String getZycp() {
        return zycp;
    }

    public void setZycp(String zycp) {
        this.zycp = zycp;
    }

    public String getFlfjdssdqjc() {
        return flfjdssdqjc;
    }

    public void setFlfjdssdqjc(String flfjdssdqjc) {
        this.flfjdssdqjc = flfjdssdqjc;
    }

    public String getYlrqzs() {
        return ylrqzs;
    }

    public void setYlrqzs(String ylrqzs) {
        this.ylrqzs = ylrqzs;
    }

    public String getSlylrqsl() {
        return slylrqsl;
    }

    public void setSlylrqsl(String slylrqsl) {
        this.slylrqsl = slylrqsl;
    }

    public String getRz() {
        return rz;
    }

    public void setRz(String rz) {
        this.rz = rz;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getSzdqname() {
        return szdqname;
    }

    public void setSzdqname(String szdqname) {
        this.szdqname = szdqname;
    }

    public String getBadw() {
        return badw;
    }

    public void setBadw(String badw) {
        this.badw = badw;
    }

    public String getBabh() {
        return babh;
    }

    public void setBabh(String babh) {
        this.babh = babh;
    }

    public String getPgbg() {
        return pgbg;
    }

    public void setPgbg(String pgbg) {
        this.pgbg = pgbg;
    }

    public String getMsdsIds() {
        return msdsIds;
    }

    public void setMsdsIds(String msdsIds) {
        this.msdsIds = msdsIds;
    }


}
