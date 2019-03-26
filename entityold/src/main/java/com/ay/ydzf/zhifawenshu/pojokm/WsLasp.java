package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("立案审批表")
public class WsLasp extends BasePojo {
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
	@ChineseName("案件")
	public String ay;
	@ChineseName("案件来源")
	public String ajly;
	@ChineseName("时间")
	public String sj;
	@ChineseName("案件名称")
	public String ajmc;
	@ChineseName("当事人")
	public String dsr;
	@ChineseName("电话")
	public String dh;
	@ChineseName("当事人情况")
	public String dsrqk;
	@ChineseName("当事人地址")
	public String dsrdz;
	@ChineseName("邮政编码")
	public String yzbm;
	@ChineseName("案件基本情况")
	public String ajqk;
	@ChineseName("承办人意见")
	public String cbryj;
	@ChineseName("承办人签字1")
	public String cbrqzy;
	@ChineseName("承办人签字2")
	public String cbrqze;
	@ChineseName("证号1")
	public String zhy;
	@ChineseName("证号2")
	public String zhe;
	@ChineseName("承办时间")
	public String cbsj;
	@ChineseName("审核意见")
	public String shyj;
	@ChineseName("审批意见")
	public String spyj;
	@ChineseName("审核人")
	public String shre;
	@ChineseName("审批人")
	public String spr;
	@ChineseName("审核时间")
	public String shsj;
	@ChineseName("审批时间")
	public String spsj;
	@ChineseName("版本号")
	public String version;
	public String getAjly() {
		return ajly;
	}
	public String getAjmc() {
		return ajmc;
	}
	
	public String getAjqk() {
		return ajqk;
	}
	public String getAy() {
		return ay;
	}
	public String getCbrqze() {
		return cbrqze;
	}
	public String getCbrqzy() {
		return cbrqzy;
	}
	public String getCbryj() {
		return cbryj;
	}
	public String getCbsj() {
		return cbsj;
	}
	public String getDh() {
		return dh;
	}
	public String getDsr() {
		return dsr;
	}
	public String getDsrdz() {
		return dsrdz;
	}
	public String getDsrqk() {
		return dsrqk;
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
	public String getShre() {
		return shre;
	}
	public String getShsj() {
		return shsj;
	}
	public String getShyj() {
		return shyj;
	}
	public String getSj() {
		return sj;
	}
	public String getSpr() {
		return spr;
	}
	public String getSpsj() {
		return spsj;
	}
	public String getSpyj() {
		return spyj;
	}
	public String getTbsj() {
		return tbsj;
	}
	public String getTname() {
		return tname;
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
	public String getYzbm() {
		return yzbm;
	}
	public String getZhe() {
		return zhe;
	}
	public String getZhy() {
		return zhy;
	}
	public void setAjly(String ajly) {
		this.ajly = ajly;
	}
	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}
	public void setAjqk(String ajqk) {
		this.ajqk = ajqk;
	}
	public void setAy(String ay) {
		this.ay = ay;
	}
	public void setCbrqze(String cbrqze) {
		this.cbrqze = cbrqze;
	}
	public void setCbrqzy(String cbrqzy) {
		this.cbrqzy = cbrqzy;
	}
	public void setCbryj(String cbryj) {
		this.cbryj = cbryj;
	}
	public void setCbsj(String cbsj) {
		this.cbsj = cbsj;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public void setDsrdz(String dsrdz) {
		this.dsrdz = dsrdz;
	}
	public void setDsrqk(String dsrqk) {
		this.dsrqk = dsrqk;
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
	public void setShre(String shre) {
		this.shre = shre;
	}
	public void setShsj(String shsj) {
		this.shsj = shsj;
	}
	public void setShyj(String shyj) {
		this.shyj = shyj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public void setSpr(String spr) {
		this.spr = spr;
	}
	public void setSpsj(String spsj) {
		this.spsj = spsj;
	}
	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}
	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	public void setZhe(String zhe) {
		this.zhe = zhe;
	}
	public void setZhy(String zhy) {
		this.zhy = zhy;
	}
	
	
	
}
