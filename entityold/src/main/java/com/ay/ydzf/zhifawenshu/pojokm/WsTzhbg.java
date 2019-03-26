package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("听证会报告")
public class WsTzhbg extends BasePojo {
	@ChineseName("行政执法id")
	public String xzzfid;
	@ChineseName("文书名称")
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
	@ChineseName("案件名称")
	public String ajmc;
	@ChineseName("听证主持人")
	public String tzzcr;
	@ChineseName("听证员")
	public String tzy;
	@ChineseName("书记员")
	public String sjy;
	@ChineseName("摘要")
	public String zy;
	@ChineseName("听证主持人意见")
	public String tzzcryj;
	@ChineseName("听证主持人签名")
	public String tzzcrqm;
	@ChineseName("听证主持人签名日期")
	public String tzzcrqmrq;
	@ChineseName("负责人审核意见")
	public String fzrshyj;
	@ChineseName("负责人签名")
	public String fzrqm;
	@ChineseName("负责人签名日期")
	public String fzrqmrq;
	@ChineseName("版本号")
	public String version;
	public String getAjmc() {
		return ajmc;
	}
	public String getFzrqm() {
		return fzrqm;
	}

	public String getFzrqmrq() {
		return fzrqmrq;
	}

	public String getFzrshyj() {
		return fzrshyj;
	}

	public String getNcode() {
		return ncode;
	}

	public String getPcode() {
		return pcode;
	}

	public String getQyid() {
		return qyid;
	}

	public String getSjy() {
		return sjy;
	}

	public String getTbsj() {
		return tbsj;
	}

	public String getTname() {
		return tname;
	}

	public String getTzy() {
		return tzy;
	}

	public String getTzzcr() {
		return tzzcr;
	}

	public String getTzzcrqm() {
		return tzzcrqm;
	}

	public String getTzzcrqmrq() {
		return tzzcrqmrq;
	}

	public String getTzzcryj() {
		return tzzcryj;
	}

	public String getVersion() {
		return version;
	}

	public String getXzzfid() {
		return xzzfid;
	}

	public String getYcode() {
		return ycode;
	}

	public String getZy() {
		return zy;
	}

	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}

	public void setFzrqm(String fzrqm) {
		this.fzrqm = fzrqm;
	}

	public void setFzrqmrq(String fzrqmrq) {
		this.fzrqmrq = fzrqmrq;
	}

	public void setFzrshyj(String fzrshyj) {
		this.fzrshyj = fzrshyj;
	}

	public void setNcode(String ncode) {
		this.ncode = ncode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public void setQyid(String qyid) {
		this.qyid = qyid;
	}

	public void setSjy(String sjy) {
		this.sjy = sjy;
	}

	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setTzy(String tzy) {
		this.tzy = tzy;
	}

	public void setTzzcr(String tzzcr) {
		this.tzzcr = tzzcr;
	}

	public void setTzzcrqm(String tzzcrqm) {
		this.tzzcrqm = tzzcrqm;
	}

	public void setTzzcrqmrq(String tzzcrqmrq) {
		this.tzzcrqmrq = tzzcrqmrq;
	}

	public void setTzzcryj(String tzzcryj) {
		this.tzzcryj = tzzcryj;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public void setYcode(String ycode) {
		this.ycode = ycode;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

}
