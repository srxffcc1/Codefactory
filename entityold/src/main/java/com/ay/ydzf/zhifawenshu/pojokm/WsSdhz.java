package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("文书送达回执")
public class WsSdhz extends BasePojo{
	public String sdhzList;//服务端只负责存储 解析这个字段交给前端
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
	@ChineseName("案件名称")
	public String ajmc;
	@ChineseName("受送达单位（个人）")
	public String ssddw;
	@ChineseName("送达文书名称、文号")
	public String wsmc;
	@ChineseName("收件人签名或者盖章")
	public String sjrqm;
	@ChineseName("送达地点")
	public String sddd;
	@ChineseName("送达日期")
    public String sdrq;
	@ChineseName("送达方式")
	public String sdfs;
	@ChineseName("送达个人")
	public String sdr;
	@ChineseName("备注")
	public String bz;
	@ChineseName("版本号")
	public String version;
	public String getAjmc() {
		return ajmc;
	}
	public String getBz() {
		return bz;
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
	public String getSddd() {
		return sddd;
	}
	public String getSdfs() {
		return sdfs;
	}
	public String getSdr() {
		return sdr;
	}
	public String getSdrq() {
		return sdrq;
	}
	public String getSjrqm() {
		return sjrqm;
	}
	public String getSsddw() {
		return ssddw;
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
	public String getWsmc() {
		return wsmc;
	}
	public String getXzzfid() {
		return xzzfid;
	}
	public String getYcode() {
		return ycode;
	}
	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
	public void setSddd(String sddd) {
		this.sddd = sddd;
	}
	public void setSdfs(String sdfs) {
		this.sdfs = sdfs;
	}
	public void setSdr(String sdr) {
		this.sdr = sdr;
	}
	public void setSdrq(String sdrq) {
		this.sdrq = sdrq;
	}
	public void setSjrqm(String sjrqm) {
		this.sjrqm = sjrqm;
	}
	public void setSsddw(String ssddw) {
		this.ssddw = ssddw;
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
	public void setWsmc(String wsmc) {
		this.wsmc = wsmc;
	}
	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}
	public void setYcode(String ycode) {
		this.ycode = ycode;
	}
	public String getSdhzList() {
		return sdhzList;
	}
	public void setSdhzList(String sdhzList) {
		this.sdhzList = sdhzList;
	}
	
	
}
