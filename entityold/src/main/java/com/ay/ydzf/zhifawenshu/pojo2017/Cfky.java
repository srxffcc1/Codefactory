package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/**
 * 场所、设施、财物信息 描述：用于查封扣押（场所、设施、财物）清单。
 * 
 * @author: YCL
 * @date: 2017年4月12日
 */
@ChineseName("场所、设施、财物信息")
public class Cfky extends BasePojo {
    @ChineseName("编号")
    public String bh;
    @ChineseName("名称")
    public String mc;
    @ChineseName("规格（型号）或者地址")
    public String gghzdz;
    @ChineseName("单位")
    public String dw;
    @ChineseName("数量或者面积")
    public String slhzmj;
    @ChineseName("备注")
    public String bz;

    @ChineseName("文书ID")
    public String wsid;
    @ChineseName("填写的顺序（序号）")
    public String txxh;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getGghzdz() {
        return gghzdz;
    }

    public void setGghzdz(String gghzdz) {
        this.gghzdz = gghzdz;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getSlhzmj() {
        return slhzmj;
    }

    public void setSlhzmj(String slhzmj) {
        this.slhzmj = slhzmj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getWsid() {
        return wsid;
    }

    public void setWsid(String wsid) {
        this.wsid = wsid;
    }

    public String getTxxh() {
        return txxh;
    }

    public void setTxxh(String txxh) {
        this.txxh = txxh;
    }

}
