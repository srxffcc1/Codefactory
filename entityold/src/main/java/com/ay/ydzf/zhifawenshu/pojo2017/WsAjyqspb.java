package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/**
 * 描述：45 案件延期审批表
 * 
 * @author: YCL
 * @date: 2017年3月24日
 */
//@ChineseName("案件延期审批表")
public class WsAjyqspb extends BasePojo {
    @ChineseName("行政执法id")
    public String xzzfid;

    @ChineseName("执法文书名称")
    public String tname;

    @ChineseName("填报时间")
    public String tbsj;

    @ChineseName("地方")
    public String pcode;

    @ChineseName("字")
    public String ycode;

    @ChineseName("号")
    public String ncode;

    @ChineseName("企业ID")
    public String qyid;

    @ChineseName("案件名称")
    public String ajmc;

    /**
     * 当事人基本情况_单位信息
     */

    @ChineseName("单位名称")
    public String dwmc;

    @ChineseName("法定代表人")
    public String fddbr;

    @ChineseName("联系电话")
    public String lxdh;

    @ChineseName("地址")
    public String dz;

    @ChineseName("邮政编码")
    public String yzbm;

    /**
     * 当事人基本情况_个人信息
     */
    @ChineseName("个人姓名")
    public String dsrGrxm;

    @ChineseName("出生年月")
    public String dsrCsny;

    @ChineseName("性别")
    public String dsrXb;

    @ChineseName("所在单位")
    public String dsrSzdw;

    @ChineseName("单位地址")
    public String dsrDwdz;

    @ChineseName("家庭住址")
    public String dsrJtzz;

    @ChineseName("联系电话")
    public String dsrLxdh;

    @ChineseName("邮编")
    public String dsrYzbm;

    /**
     * 案件延期
     */
    @ChineseName("案件延期理由")
    public String ajyqly;

    @ChineseName("承办人签名1")
    public String cbrqm_one;

    @ChineseName("承办人签名2")
    public String cbrqm_two;

    @ChineseName("承办人签名日期")
    public String cbrqmrq;

    /**
     * 审核
     */
    @ChineseName("审核意见")
    public String shyj;

    @ChineseName("审核人签名")
    public String shrqm;

    @ChineseName("审核人签名日期")
    public String shrqmrq;

    /**
     * 审批
     */
    @ChineseName("审批意见")
    public String spyj;

    @ChineseName("审批人签名")
    public String sprqm;

    @ChineseName("审批人签名日期")
    public String sprqmrq;

    @ChineseName("版本号")
    public String version;

    @ChineseName("备用字段1")
    public String column1;

    @ChineseName("备用字段2")
    public String column2;

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

    public String getAjmc() {
        return ajmc;
    }

    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }

    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getDsrGrxm() {
        return dsrGrxm;
    }

    public void setDsrGrxm(String dsrGrxm) {
        this.dsrGrxm = dsrGrxm;
    }

    public String getDsrCsny() {
        return dsrCsny;
    }

    public void setDsrCsny(String dsrCsny) {
        this.dsrCsny = dsrCsny;
    }

    public String getDsrXb() {
        return dsrXb;
    }

    public void setDsrXb(String dsrXb) {
        this.dsrXb = dsrXb;
    }

    public String getDsrSzdw() {
        return dsrSzdw;
    }

    public void setDsrSzdw(String dsrSzdw) {
        this.dsrSzdw = dsrSzdw;
    }

    public String getDsrDwdz() {
        return dsrDwdz;
    }

    public void setDsrDwdz(String dsrDwdz) {
        this.dsrDwdz = dsrDwdz;
    }

    public String getDsrJtzz() {
        return dsrJtzz;
    }

    public void setDsrJtzz(String dsrJtzz) {
        this.dsrJtzz = dsrJtzz;
    }

    public String getDsrLxdh() {
        return dsrLxdh;
    }

    public void setDsrLxdh(String dsrLxdh) {
        this.dsrLxdh = dsrLxdh;
    }

    public String getDsrYzbm() {
        return dsrYzbm;
    }

    public void setDsrYzbm(String dsrYzbm) {
        this.dsrYzbm = dsrYzbm;
    }

    public String getAjyqly() {
        return ajyqly;
    }

    public void setAjyqly(String ajyqly) {
        this.ajyqly = ajyqly;
    }

    public String getCbrqm_one() {
        return cbrqm_one;
    }

    public void setCbrqm_one(String cbrqm_one) {
        this.cbrqm_one = cbrqm_one;
    }

    public String getCbrqm_two() {
        return cbrqm_two;
    }

    public void setCbrqm_two(String cbrqm_two) {
        this.cbrqm_two = cbrqm_two;
    }

    public String getCbrqmrq() {
        return cbrqmrq;
    }

    public void setCbrqmrq(String cbrqmrq) {
        this.cbrqmrq = cbrqmrq;
    }

    public String getShyj() {
        return shyj;
    }

    public void setShyj(String shyj) {
        this.shyj = shyj;
    }

    public String getShrqm() {
        return shrqm;
    }

    public void setShrqm(String shrqm) {
        this.shrqm = shrqm;
    }

    public String getShrqmrq() {
        return shrqmrq;
    }

    public void setShrqmrq(String shrqmrq) {
        this.shrqmrq = shrqmrq;
    }

    public String getSpyj() {
        return spyj;
    }

    public void setSpyj(String spyj) {
        this.spyj = spyj;
    }

    public String getSprqm() {
        return sprqm;
    }

    public void setSprqm(String sprqm) {
        this.sprqm = sprqm;
    }

    public String getSprqmrq() {
        return sprqmrq;
    }

    public void setSprqmrq(String sprqmrq) {
        this.sprqmrq = sprqmrq;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

}
