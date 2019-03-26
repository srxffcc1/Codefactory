package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("先行登记保存证据通知书")
public class WsXxdjtzs extends BasePojo{
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
	@ChineseName("被处罚单位")
	public String bcfdw;
	@ChineseName("违法行为")
	public String wfxw;
	@ChineseName("决定日期")
	public String jdrq;
	@ChineseName("登记处")
	public String djc;
	@ChineseName("日期")
	public String rq;
	@ChineseName("负责人签名")
	public String fzrqm;
	@ChineseName("是否完成")
	public int sfwc=1;
	@ChineseName("版本号")
	public String version;
	public String getBcfdw() {
		return bcfdw;
	}
	public String getDjc() {
		return djc;
	}
	
	public String getFzrqm() {
		return fzrqm;
	}
	public String getJdrq() {
		return jdrq;
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
	public String getWfxw() {
		return wfxw;
	}
	public String getXzzfid() {
		return xzzfid;
	}
	public String getYcode() {
		return ycode;
	}
	public void setBcfdw(String bcfdw) {
		this.bcfdw = bcfdw;
	}
	public void setDjc(String djc) {
		this.djc = djc;
	}
	public void setFzrqm(String fzrqm) {
		this.fzrqm = fzrqm;
	}
	public void setJdrq(String jdrq) {
		this.jdrq = jdrq;
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
	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}
	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}
	public void setYcode(String ycode) {
		this.ycode = ycode;
	}
	
	
}
