package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("鉴定委托书内容")
public class Jdwts extends BasePojo{
	@ChineseName("物品名称")
	public String wpmc;
	@ChineseName("规格型号")
	public String ggxh;
	@ChineseName("数量")
	public String sl;
	@ChineseName("备注")
	public String bz;
	@ChineseName("文书ID")
	public String wsid;
	@ChineseName("填写的顺序（序号）")
	public String txxh;
	public String getWpmc() {
		return wpmc;
	}
	public void setWpmc(String wpmc) {
		this.wpmc = wpmc;
	}
	public String getGgxh() {
		return ggxh;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
