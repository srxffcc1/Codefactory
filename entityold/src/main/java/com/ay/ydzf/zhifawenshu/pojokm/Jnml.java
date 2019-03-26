package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("卷内目录内容")
public class Jnml extends BasePojo{
	@ChineseName("序号")
	public String xh;
	
	@ChineseName("文件名称及编号")
	public String wjmcbh;
	
	@ChineseName("日期")
	public String rq;

	@ChineseName("页号")
	public String yh;

	@ChineseName("备注")
	public String bz;

	@ChineseName("文书ID")
	public String wsid;

	@ChineseName("填写的顺序（序号）")
	public String txxh;

	public String getBz() {
		return bz;
	}

	public String getRq() {
		return rq;
	}

	public String getTxxh() {
		return txxh;
	}

	public String getWjmcbh() {
		return wjmcbh;
	}

	public String getWsid() {
		return wsid;
	}

	public String getXh() {
		return xh;
	}

	public String getYh() {
		return yh;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public void setRq(String rq) {
		this.rq = rq;
	}

	public void setTxxh(String txxh) {
		this.txxh = txxh;
	}
	
	public void setWjmcbh(String wjmcbh) {
		this.wjmcbh = wjmcbh;
	}
	
	public void setWsid(String wsid) {
		this.wsid = wsid;
	}
	
	public void setXh(String xh) {
		this.xh = xh;
	}
	
	public void setYh(String yh) {
		this.yh = yh;
	}	
}
