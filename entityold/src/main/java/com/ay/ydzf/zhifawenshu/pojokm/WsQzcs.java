package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;


//@ChineseName("强制措施决定书")
public class WsQzcs  extends BasePojo{
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
	@ChineseName("问题")
	public String wt;
	@ChineseName("依据")
	public String yj;
	@ChineseName("强制措施")
	public String qzcs;
	@ChineseName("人民政府")
	public String rmzf;
	@ChineseName("申请行政复议单位")
	public String sqdw;
	@ChineseName("人民法院")
	public String rmfy;
	@ChineseName("时间")
	public String sj;
	@ChineseName("版本")
	public String version;
	//地方字号
	public String dfzh;
	
	public String getBjcdw() {
		return bjcdw;
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
	public String getQzcs() {
		return qzcs;
	}
	public String getRmfy() {
		return rmfy;
	}
	public String getRmzf() {
		return rmzf;
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
	public String getWt() {
		return wt;
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
	public void setBjcdw(String bjcdw) {
		this.bjcdw = bjcdw;
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
	public void setQzcs(String qzcs) {
		this.qzcs = qzcs;
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
	public void setWt(String wt) {
		this.wt = wt;
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
	public String getDfzh() {
		return dfzh;
	}
	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}
	
	
	
}
