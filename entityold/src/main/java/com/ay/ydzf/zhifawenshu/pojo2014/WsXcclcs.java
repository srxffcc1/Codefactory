package com.ay.ydzf.zhifawenshu.pojo2014;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("现场处理措施决定书")
public class WsXcclcs extends BasePojo {
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
	@ChineseName("被检查单位")
	public String bjcdw;
	@ChineseName("检查日期")
	public String jcrq;
	@ChineseName("违法违规行为和事故隐患1")
	public String sgyhOne;
	@ChineseName("违法违规行为和事故隐患2")
	public String sgyhTwo;
	@ChineseName("违法违规行为和事故隐患3")
	public String sgyhThree;
	@ChineseName("依据")
	public String yj;
	@ChineseName("决定1")
	public String jdOne;
	@ChineseName("决定2")
	public String jdTwo;
	@ChineseName("决定3")
	public String jdThree;
	@ChineseName("人民政府")
	public String rmzf;
	@ChineseName("申请行政复议单位")
	public String sqdw;
	@ChineseName("人民法院")
	public String rmfy;
	@ChineseName("执法人员签名1")
	public String zfryqmOne;
	@ChineseName("执法人员签名2")
	public String zfryqmTwo;
	@ChineseName("证号1")
	public String zhOne;
	@ChineseName("证号2")
	public String zhTwo;
	@ChineseName("负责人签名")
	public String fzrqm;
	@ChineseName("时间")
	public String sj;
	@ChineseName("版本号")
	public String version;
	//地方字号
	public String dfzh;
	
	public String yhid;//重大隐患ID
	
	public String getBjcdw() {
		return bjcdw;
	}
	public String getFzrqm() {
		return fzrqm;
	}

	public String getJcrq() {
		return jcrq;
	}

	public String getJdOne() {
		return jdOne;
	}

	public String getJdThree() {
		return jdThree;
	}

	public String getJdTwo() {
		return jdTwo;
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

	public String getSgyhOne() {
		return sgyhOne;
	}

	public String getSgyhThree() {
		return sgyhThree;
	}

	public String getSgyhTwo() {
		return sgyhTwo;
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

	public String getXzzfid() {
		return xzzfid;
	}

	public String getYcode() {
		return ycode;
	}

	public String getYj() {
		return yj;
	}

	public String getZfryqmOne() {
		return zfryqmOne;
	}

	public String getZfryqmTwo() {
		return zfryqmTwo;
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

	public void setFzrqm(String fzrqm) {
		this.fzrqm = fzrqm;
	}

	public void setJcrq(String jcrq) {
		this.jcrq = jcrq;
	}

	public void setJdOne(String jdOne) {
		this.jdOne = jdOne;
	}

	public void setJdThree(String jdThree) {
		this.jdThree = jdThree;
	}

	public void setJdTwo(String jdTwo) {
		this.jdTwo = jdTwo;
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

	public void setSgyhOne(String sgyhOne) {
		this.sgyhOne = sgyhOne;
	}

	public void setSgyhThree(String sgyhThree) {
		this.sgyhThree = sgyhThree;
	}

	public void setSgyhTwo(String sgyhTwo) {
		this.sgyhTwo = sgyhTwo;
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

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public void setYcode(String ycode) {
		this.ycode = ycode;
	}

	public void setYj(String yj) {
		this.yj = yj;
	}

	public void setZfryqmOne(String zfryqmOne) {
		this.zfryqmOne = zfryqmOne;
	}

	public void setZfryqmTwo(String zfryqmTwo) {
		this.zfryqmTwo = zfryqmTwo;
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
	@Override
	public String toString() {
		return "WsXcclcs [bjcdw=" + bjcdw + ", fzrqm=" + fzrqm + ", jcrq="
				+ jcrq + ", jdOne=" + jdOne + ", jdThree=" + jdThree
				+ ", jdTwo=" + jdTwo + ", ncode=" + ncode + ", pcode=" + pcode
				+ ", qyid=" + qyid + ", rmfy=" + rmfy + ", rmzf=" + rmzf
				+ ", sgyhOne=" + sgyhOne + ", sgyhThree=" + sgyhThree
				+ ", sgyhTwo=" + sgyhTwo + ", sj=" + sj + ", sqdw=" + sqdw
				+ ", tbsj=" + tbsj + ", tname=" + tname + ", version="
				+ version + ", xzzfid=" + xzzfid + ", ycode=" + ycode + ", yj="
				+ yj + ", zfryqmOne=" + zfryqmOne + ", zfryqmTwo=" + zfryqmTwo
				+ ", zhOne=" + zhOne + ", zhTwo=" + zhTwo + "]";
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

}
