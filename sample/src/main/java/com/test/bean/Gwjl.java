package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:南京智慧安监云平台
 * @类名:Gwjl.java 
 * @描述:公文记录表
 * @创建人: 陈安 
 * @创建时间: 2014年11月10日下午4:55:33 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
@ChineseName("公文记录表;Detail;List:SHOW=sprname,jlzt,wcsj,spqk,spyj:FUNCTION=查看;")
public class Gwjl extends BasePojo{
	@ChineseName("审批人姓名")
	public String sprname;
	@ChineseName("记录状态")
	public String jlzt;
	@ChineseName("公文id")
	public String gwid;
	@ChineseName("完成时间")
	public String wcsj;
	@ChineseName("审批情况")
	public String spqk;
	@ChineseName("审批意见")
	public String spyj;
	
	public String sprid;
	public String getSprname() {
		return sprname;
	}
	public void setSprname(String sprname) {
		this.sprname = sprname;
	}
	public String getJlzt() {
		return jlzt;
	}
	public void setJlzt(String jlzt) {
		this.jlzt = jlzt;
	}
	public String getGwid() {
		return gwid;
	}
	public void setGwid(String gwid) {
		this.gwid = gwid;
	}
	public String getWcsj() {
		return wcsj;
	}
	public void setWcsj(String wcsj) {
		this.wcsj = wcsj;
	}
	public String getSpqk() {
		return spqk;
	}
	public void setSpqk(String spqk) {
		this.spqk = spqk;
	}
	public String getSpyj() {
		return spyj;
	}
	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}
	public String getSprid() {
		return sprid;
	}
	public void setSprid(String sprid) {
		this.sprid = sprid;
	}

}
