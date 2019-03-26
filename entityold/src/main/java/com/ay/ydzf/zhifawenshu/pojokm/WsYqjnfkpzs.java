package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("延期（分期）缴纳罚款批准书")
public class WsYqjnfkpzs extends BasePojo{
	@ChineseName("行政执法id")
	public String xzzfid;
	
	@ChineseName("执法文书名称")
	public String tname;

	@ChineseName("填表时间")
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
	
	@ChineseName("文号")
	public String wh;
	
	@ChineseName("金额")
	public String je;
	
	@ChineseName("缴款方式")
	public String jkfs;
	
	@ChineseName("延长截止日期")
	public String ycjzrq;
	
	@ChineseName("第几期")
	public String djq;
	
	@ChineseName("分期截止日期")
	public String fqjzrq;
	
	@ChineseName("分期缴纳金额")
	public String fqjnje;
	
	@ChineseName("尚未缴纳罚款")
	public String swjnfk;
	
	@ChineseName("日期")
	public String rq;
	
	@ChineseName("是否完成")
	public int sfwc = 1;
	
	@ChineseName("版本号")
	public String version;
	
	public String getDjq() {
		return djq;
	}
	
	public String getFkdw() {
		return fkdw;
	}

	public String getFkrq() {
		return fkrq;
	}

	public String getFqjnje() {
		return fqjnje;
	}

	public String getFqjzrq() {
		return fqjzrq;
	}

	public String getJe() {
		return je;
	}

	public String getJkfs() {
		return jkfs;
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

	public String getSwjnfk() {
		return swjnfk;
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

	public String getWh() {
		return wh;
	}

	public String getXzzfid() {
		return xzzfid;
	}

	public String getYcjzrq() {
		return ycjzrq;
	}

	public String getYcode() {
		return ycode;
	}

	public void setDjq(String djq) {
		this.djq = djq;
	}

	public void setFkdw(String fkdw) {
		this.fkdw = fkdw;
	}

	public void setFkrq(String fkrq) {
		this.fkrq = fkrq;
	}

	public void setFqjnje(String fqjnje) {
		this.fqjnje = fqjnje;
	}

	public void setFqjzrq(String fqjzrq) {
		this.fqjzrq = fqjzrq;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public void setJkfs(String jkfs) {
		this.jkfs = jkfs;
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

	public void setSwjnfk(String swjnfk) {
		this.swjnfk = swjnfk;
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

	public void setWh(String wh) {
		this.wh = wh;
	}

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public void setYcjzrq(String ycjzrq) {
		this.ycjzrq = ycjzrq;
	}

	public void setYcode(String ycode) {
		this.ycode = ycode;
	}
	
	
	
}
