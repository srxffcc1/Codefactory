package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:南京智慧安监云平台
 * @类名:Tonggao.java 
 * @描述:通知公告
 * @创建人: 陈安 
 * @创建时间: 2014年11月5日下午6:03:14 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
@ChineseName("通知公告;Detail;List:SHOW=ggbt,ggnr,fbr,time:FUNCTION=查看,删除,政府查阅;")
public class Tonggao extends BasePojo{
	@ChineseName("公告标题")
	public String ggbt;
	@ChineseName("公告内容")
	public String ggnr;
	@ChineseName("发布人")
	public String fbr;
	@ChineseName("接收人")
	public String jsr;
	@ChineseName("地区")
	public String area;
	@ChineseName("发布时间")
	public String time;
	@ChineseName("所属部门")
	public String dept;
	@ChineseName("所属地区")
	public String ssdq;
	@ChineseName("监管行业")
	public String jghy;
	@ChineseName("登录名")
	public String account;

	//政府端所选用户部门ids
	public String checkDeptIds;
	//企业端所选地区codes
	public String checkSsdqCodes;
	//企业端所选监管行业codes
	public String checkJghyCodes;
	
	//算选企业信息列表id
	public String checkEntUserIds;
	//是否自己发文
	public String sfzj;
	
	public String sjrid;
	
	public String getGgbt() {
		return ggbt;
	}
	public void setGgbt(String ggbt) {
		this.ggbt = ggbt;
	}
	public String getGgnr() {
		return ggnr;
	}
	public void setGgnr(String ggnr) {
		this.ggnr = ggnr;
	}
	public String getFbr() {
		return fbr;
	}
	public void setFbr(String fbr) {
		this.fbr = fbr;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getJsr() {
		return jsr;
	}
	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSsdq() {
		return ssdq;
	}
	public void setSsdq(String ssdq) {
		this.ssdq = ssdq;
	}
	public String getJghy() {
		return jghy;
	}
	public void setJghy(String jghy) {
		this.jghy = jghy;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCheckDeptIds() {
		return checkDeptIds;
	}
	public void setCheckDeptIds(String checkDeptIds) {
		this.checkDeptIds = checkDeptIds;
	}
	public String getCheckSsdqCodes() {
		return checkSsdqCodes;
	}
	public void setCheckSsdqCodes(String checkSsdqCodes) {
		this.checkSsdqCodes = checkSsdqCodes;
	}
	public String getCheckJghyCodes() {
		return checkJghyCodes;
	}
	public void setCheckJghyCodes(String checkJghyCodes) {
		this.checkJghyCodes = checkJghyCodes;
	}
	public String getCheckEntUserIds() {
		return checkEntUserIds;
	}
	public void setCheckEntUserIds(String checkEntUserIds) {
		this.checkEntUserIds = checkEntUserIds;
	}
	public String getSfzj() {
		return sfzj;
	}
	public void setSfzj(String sfzj) {
		this.sfzj = sfzj;
	}
	public String getSjrid() {
		return sjrid;
	}
	public void setSjrid(String sjrid) {
		this.sjrid = sjrid;
	}
	
}
