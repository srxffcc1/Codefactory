package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("罚款催缴通知书")
public class WsFkcjtzs extends BasePojo{
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
	
	@ChineseName("罚款单位")
	public String fkdw;
	
	@ChineseName("罚款日期")
	public String fkrq;
	
	@ChineseName("罚款书号")
	public String fkh;
	
	@ChineseName("交款日期")
	public String jkrq;
	
	@ChineseName("交款处")
	public String jkc;
	
	@ChineseName("日期")
	public String rq;
	
	@ChineseName("是否完成")
	public int sfwc=1;
	
	@ChineseName("版本号")
	public String version;
	
	public String getFkdw() {
		return fkdw;
	}
	
	public String getFkh() {
		return fkh;
	}

	public String getFkrq() {
		return fkrq;
	}

	public String getJkc() {
		return jkc;
	}

	public String getJkrq() {
		return jkrq;
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

	public String getRq() {
		return rq;
	}

	public int getSfwc() {
		return sfwc;
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

	public void setFkdw(String fkdw) {
		this.fkdw = fkdw;
	}

	public void setFkh(String fkh) {
		this.fkh = fkh;
	}

	public void setFkrq(String fkrq) {
		this.fkrq = fkrq;
	}

	public void setJkc(String jkc) {
		this.jkc = jkc;
	}

	public void setJkrq(String jkrq) {
		this.jkrq = jkrq;
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

	public void setRq(String rq) {
		this.rq = rq;
	}

	public void setSfwc(int sfwc) {
		this.sfwc = sfwc;
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
	
	

}
