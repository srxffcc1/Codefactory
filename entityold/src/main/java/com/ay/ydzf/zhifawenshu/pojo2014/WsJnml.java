package com.ay.ydzf.zhifawenshu.pojo2014;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

import java.util.List;

//@ChineseName("卷内目录")
public class WsJnml extends BasePojo{
	/**卷内目录内容**/
	public List<com.ay.ydzf.zhifawenshu.pojo2014.Jnml> jnmlList;
	@ChineseName("行政执法id")
	public String xzzfid;
	
	@ChineseName("执法文书名称")
	public String tname;

	@ChineseName("填报时间")
	public String tbsj;

	@ChineseName("企业ID")
	public String qyid;
	
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
	
	@ChineseName("版本号")
	public String version;
	
	public String getBz() {
		return bz;
	}
	
	public String getQyid() {
		return qyid;
	}

	public String getRq() {
		return rq;
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

	public String getWjmcbh() {
		return wjmcbh;
	}

	public String getXh() {
		return xh;
	}

	public String getXzzfid() {
		return xzzfid;
	}

	public String getYh() {
		return yh;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public void setQyid(String qyid) {
		this.qyid = qyid;
	}

	public void setRq(String rq) {
		this.rq = rq;
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

	public void setWjmcbh(String wjmcbh) {
		this.wjmcbh = wjmcbh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public void setYh(String yh) {
		this.yh = yh;
	}

	public List<com.ay.ydzf.zhifawenshu.pojo2014.Jnml> getJnmlList() {
		return jnmlList;
	}

	public void setJnmlList(List<Jnml> jnmlList) {
		this.jnmlList = jnmlList;
	}
	
}
