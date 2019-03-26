package com.ay.ydzf.zhifawenshu.pojo2017;
import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("查封扣押决定书")
public class WsCfkyjds extends BasePojo {
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

	
	
	@ChineseName("对应企业名称")
	public String qymc;
	@ChineseName("发现的问题")
	public String xlwt;
	
	@ChineseName("依据什么法规")
	public String yjfg;
	@ChineseName("强制措施")
	public String qzcs;
	
	@ChineseName("强制措施日期前")
	public String qzrq1;
	@ChineseName("强制措施日期后")
	public String qzrq2;
	@ChineseName("人民政府1")
	public String rmzf1;
	@ChineseName("人民政府2")
	public String rmzf2;
	@ChineseName("人民法院")
	public String rmfy;
	@ChineseName("号2")
	public String hao2;
	@ChineseName("日期")
	public String rq;
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
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getXlwt() {
		return xlwt;
	}
	public void setXlwt(String xlwt) {
		this.xlwt = xlwt;
	}
	public String getYjfg() {
		return yjfg;
	}
	public void setYjfg(String yjfg) {
		this.yjfg = yjfg;
	}
	public String getQzcs() {
		return qzcs;
	}
	public void setQzcs(String qzcs) {
		this.qzcs = qzcs;
	}
	public String getQzrq1() {
		return qzrq1;
	}
	public void setQzrq1(String qzrq1) {
		this.qzrq1 = qzrq1;
	}
	public String getQzrq2() {
		return qzrq2;
	}
	public void setQzrq2(String qzrq2) {
		this.qzrq2 = qzrq2;
	}
	public String getRmzf1() {
		return rmzf1;
	}
	public void setRmzf1(String rmzf1) {
		this.rmzf1 = rmzf1;
	}
	public String getRmzf2() {
		return rmzf2;
	}
	public void setRmzf2(String rmzf2) {
		this.rmzf2 = rmzf2;
	}
	public String getRmfy() {
		return rmfy;
	}
	public void setRmfy(String rmfy) {
		this.rmfy = rmfy;
	}
	public String getHao2() {
		return hao2;
	}
	public void setHao2(String hao2) {
		this.hao2 = hao2;
	}
	public String getRq() {
		return rq;
	}
	public void setRq(String rq) {
		this.rq = rq;
	}
	
	
}
