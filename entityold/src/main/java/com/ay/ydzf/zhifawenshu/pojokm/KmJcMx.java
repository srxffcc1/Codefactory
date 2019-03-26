package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;

/**
 * 督查表明细表
 * @author Administrator
 *
 */
//@ChineseName("部门专项,专家检查,政府综合督查报表明细表")
public class KmJcMx {
	@ChineseName("主键id")
	public String id;
	@ChineseName("关联督查表主表")
	public String govJcCode;
	@ChineseName("隐患名称")
	public String yhmc;
	@ChineseName("省")
	public String mxProvice;
	@ChineseName("州,市")
	public String mxCity;
	@ChineseName("县")
	public String mxCountry;
	@ChineseName("被督查部门名称")
	public String bjcName;
	@ChineseName("企业或部门id")
	public String yOgCode;
	@ChineseName("负责人")
	public String fzPeople;
	@ChineseName("交办时间")
	public String jbDate;
	@ChineseName("整改完成时间")
	public String zgwcDate;
	@ChineseName("报同级安委办时间")
	public String btjanbDate;
	@ChineseName("是否通报政府负责人")
	public String sftbfzr;
	@ChineseName("企业所在地")
	public String qyPlace;
	@ChineseName("负责办理单位")
	public String fzblDepartment;
	@ChineseName("隐患级别")
	public String yhLevle;
	@ChineseName("隐患明细Id 关联隐患明细表")
	public String yhCode;
	
	public String getYhmc() {
		return yhmc;
	}
	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}
	public String getGovJcCode() {
		return govJcCode;
	}
	public void setGovJcCode(String govJcCode) {
		this.govJcCode = govJcCode;
	}
	public String getMxProvice() {
		return mxProvice;
	}
	public void setMxProvice(String mxProvice) {
		this.mxProvice = mxProvice;
	}
	public String getMxCity() {
		return mxCity;
	}
	public void setMxCity(String mxCity) {
		this.mxCity = mxCity;
	}
	public String getMxCountry() {
		return mxCountry;
	}
	public void setMxCountry(String mxCountry) {
		this.mxCountry = mxCountry;
	}
	public String getBjcName() {
		return bjcName;
	}
	public void setBjcName(String bjcName) {
		this.bjcName = bjcName;
	}
	public String getyOgCode() {
		return yOgCode;
	}
	public void setyOgCode(String yOgCode) {
		this.yOgCode = yOgCode;
	}
	public String getFzPeople() {
		return fzPeople;
	}
	public void setFzPeople(String fzPeople) {
		this.fzPeople = fzPeople;
	}
	public String getJbDate() {
		return jbDate;
	}
	public void setJbDate(String jbDate) {
		this.jbDate = jbDate;
	}
	public String getZgwcDate() {
		return zgwcDate;
	}
	public void setZgwcDate(String zgwcDate) {
		this.zgwcDate = zgwcDate;
	}
	public String getBtjanbDate() {
		return btjanbDate;
	}
	public void setBtjanbDate(String btjanbDate) {
		this.btjanbDate = btjanbDate;
	}
	public String getSftbfzr() {
		return sftbfzr;
	}
	public void setSftbfzr(String sftbfzr) {
		this.sftbfzr = sftbfzr;
	}
	public String getQyPlace() {
		return qyPlace;
	}
	public void setQyPlace(String qyPlace) {
		this.qyPlace = qyPlace;
	}
	public String getFzblDepartment() {
		return fzblDepartment;
	}
	public void setFzblDepartment(String fzblDepartment) {
		this.fzblDepartment = fzblDepartment;
	}
	public String getYhLevle() {
		return yhLevle;
	}
	public void setYhLevle(String yhLevle) {
		this.yhLevle = yhLevle;
	}
	public String getYhCode() {
		return yhCode;
	}
	public void setYhCode(String yhCode) {
		this.yhCode = yhCode;
	}
}
