package com.ay.ydzf.zhifawenshu.pojo2014;
import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("责令限期整改指令书")
public class WsZlxqzg extends BasePojo {
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
	@ChineseName("被检查单位")
	public String bjcdw;
	@ChineseName("问题1")
	public String wtOne;
	@ChineseName("问题2")
	public String wtTwo;
	@ChineseName("问题3")
	public String wtThree;
	@ChineseName("问题4")
	public String wtFour;
	@ChineseName("第几项")
	public String djx;
	@ChineseName("整改日期")
	public String zgrq;
	@ChineseName("人民政府")
	public String rmzf;
	@ChineseName("申请行政复议单位")
	public String sqdw;
	@ChineseName("人民法院")
	public String rmfy;
	@ChineseName("安全生产监管执法人员(签名)1")
	public String zfryqmOne;
	@ChineseName("安全生产监管执法人员(签名)2")
	public String zfryqmTwo;
	@ChineseName("证号1")
	public String zhOne;
	@ChineseName("证号2")
	public String zhTwo;
	@ChineseName("被检查单位负责人签名")
	public String fzrqm;
	@ChineseName("时间")
	public String sj;
	@ChineseName("是否完成")
	public String sfwc="1";
	@ChineseName("版本号")
	public String version;
	//地方字号
	public String dfzh;
	
	public String yhid;//重大隐患ID
	
	public String getBjcdw() {
		return bjcdw;
	}
	public String getDjx() {
		return djx;
	}

	public String getFzrqm() {
		return fzrqm;
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

	public String getRmfy() {
		return rmfy;
	}

	public String getRmzf() {
		return rmzf;
	}


	public String getSfwc() {
		return sfwc;
	}
	public void setSfwc(String sfwc) {
		this.sfwc = sfwc;
	}
	public String getSj() {
		return sj;
	}

	public String getSqdw() {
		return sqdw;
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

	public String getWtFour() {
		return wtFour;
	}

	public String getWtOne() {
		return wtOne;
	}

	public String getWtThree() {
		return wtThree;
	}

	public String getWtTwo() {
		return wtTwo;
	}

	public String getXzzfid() {
		return xzzfid;
	}

	public String getYcode() {
		return ycode;
	}

	public String getZfryqmOne() {
		return zfryqmOne;
	}

	public String getZfryqmTwo() {
		return zfryqmTwo;
	}

	public String getZgrq() {
		return zgrq;
	}

	public String getZhOne() {
		return zhOne;
	}

	public String getZhTwo() {
		return zhTwo;
	}

	public void setBjcdw(String bjcdw) {
		this.bjcdw = bjcdw;
	}

	public void setDjx(String djx) {
		this.djx = djx;
	}

	public void setFzrqm(String fzrqm) {
		this.fzrqm = fzrqm;
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

	public void setRmfy(String rmfy) {
		this.rmfy = rmfy;
	}

	public void setRmzf(String rmzf) {
		this.rmzf = rmzf;
	}


	public void setSj(String sj) {
		this.sj = sj;
	}

	public void setSqdw(String sqdw) {
		this.sqdw = sqdw;
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

	public void setWtFour(String wtFour) {
		this.wtFour = wtFour;
	}

	public void setWtOne(String wtOne) {
		this.wtOne = wtOne;
	}

	public void setWtThree(String wtThree) {
		this.wtThree = wtThree;
	}

	public void setWtTwo(String wtTwo) {
		this.wtTwo = wtTwo;
	}

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public void setYcode(String ycode) {
		this.ycode = ycode;
	}

	public void setZfryqmOne(String zfryqmOne) {
		this.zfryqmOne = zfryqmOne;
	}

	public void setZfryqmTwo(String zfryqmTwo) {
		this.zfryqmTwo = zfryqmTwo;
	}

	public void setZgrq(String zgrq) {
		this.zgrq = zgrq;
	}

	public void setZhOne(String zhOne) {
		this.zhOne = zhOne;
	}

	public void setZhTwo(String zhTwo) {
		this.zhTwo = zhTwo;
	}
	public String getDfzh() {
		return dfzh;
	}
	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

}
