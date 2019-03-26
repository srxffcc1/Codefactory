package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("送达回执内容")
public class Sdhz extends BasePojo{
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
	@ChineseName("文书ID")
	public String wsid;

	/**填写的顺序（序号）**/
	public String txxh;
	public String getWsmc() {
		return wsmc;
	}
	public void setWsmc(String wsmc) {
		this.wsmc = wsmc;
	}
	public String getSjrqm() {
		return sjrqm;
	}
	public void setSjrqm(String sjrqm) {
		this.sjrqm = sjrqm;
	}
	public String getSddd() {
		return sddd;
	}
	public void setSddd(String sddd) {
		this.sddd = sddd;
	}
	public String getSdrq() {
		return sdrq;
	}
	public void setSdrq(String sdrq) {
		this.sdrq = sdrq;
	}
	public String getSdfs() {
		return sdfs;
	}
	public void setSdfs(String sdfs) {
		this.sdfs = sdfs;
	}
	public String getSdr() {
		return sdr;
	}
	public void setSdr(String sdr) {
		this.sdr = sdr;
	}
	public String getWsid() {
		return wsid;
	}
	public void setWsid(String wsid) {
		this.wsid = wsid;
	}
	public String getTxxh() {
		return txxh;
	}
	public void setTxxh(String txxh) {
		this.txxh = txxh;
	}
	
}
