package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("抽样取证")
public class WsCyqz extends BasePojo{
	@ChineseName("序号")
	public String xh;
	@ChineseName("证据物品名称")
	public String zjwpmc;
	@ChineseName("规格批号")
	public String ggph;
	@ChineseName("数量")
	public String sl;
	@ChineseName("文书ID")
	public String wsid;
	/**填写的顺序（序号）**/
	public String txxh;
	public String getGgph() {
		return ggph;
	}
	public String getSl() {
		return sl;
	}
	public String getTxxh() {
		return txxh;
	}
	public String getWsid() {
		return wsid;
	}
	public String getXh() {
		return xh;
	}
	public String getZjwpmc() {
		return zjwpmc;
	}
	public void setGgph(String ggph) {
		this.ggph = ggph;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public void setTxxh(String txxh) {
		this.txxh = txxh;
	}
	public void setWsid(String wsid) {
		this.wsid = wsid;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public void setZjwpmc(String zjwpmc) {
		this.zjwpmc = zjwpmc;
	}
}
