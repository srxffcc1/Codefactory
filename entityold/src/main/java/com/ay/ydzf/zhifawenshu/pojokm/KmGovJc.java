
package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;

/**
 * 政府部门检查表主表
 * @author Administrator
 *
 */
//@ChineseName("部门,专家,政府部门的督查表")
public class KmGovJc {
	@ChineseName("督查表的 唯一标识")
	public String bbId;
	@ChineseName("部门 的编号")
	public String govCode;
	@ChineseName("部门名称")
	public String govName;
	@ChineseName("负责人")
	public String govFzr;
	@ChineseName("地址")
	public String govPlace;
	@ChineseName("省")
	public String sheng;
	@ChineseName("市")
	public String shi;
	@ChineseName("县")
	public String xian;
	@ChineseName("填报人")
	public String tbPeople;
	@ChineseName("联系电话")
	public String govPhone;
	@ChineseName("督查组长名称")
	public String dczName;
	@ChineseName("填报时间")
	public String tbDate;
	@ChineseName("检查时间")
	public String jcDate;
	@ChineseName("查出一般隐患项(项)")
	public String jcybyhCount;
	@ChineseName("已整改(项)")
	public String yzgCount;
	@ChineseName("一般隐患整改率")
	public String ybyhzgl;
	@ChineseName("查出重大隐患项")
	public String jczdyhCount;
	@ChineseName("重大隐患整改(项)")
	public String zdyhzgCount;
	@ChineseName("重大隐患整改率")
	public String zdyhzgl;
	@ChineseName("限期整改(项)")
	public String xqzgCount;
	@ChineseName("检查人员名称")
	public String jcName;
	@ChineseName("部门带队责任人")
	public String govMainName;
	@ChineseName("查询问题(项)")
	public String jcQuestionCount;
	@ChineseName("已整改(项)")
	public String zgCount;
	@ChineseName("整改率")
	public String zgl;
	@ChineseName("报表类型")
	public String bbType;
	@ChineseName("部门数")
	public String departmentCOunt;
	@ChineseName("企业数")
	public String enterpriseCount;
	@ChineseName("政府数")
	public String govCount;
	@ChineseName("审核状态 0.未提交审核 1.提交审核2.审核通过 3.审核未通过")
	public String shStatus;
	@ChineseName("检查省")
	public String jcProvice;
	@ChineseName("检查市")
	public String jcCity;
	@ChineseName("检查县")
	public String jcCountry;
	@ChineseName("下发整改通知(份)")
	public String zgtzCount;
	@ChineseName("下发执法文书")
	public String zfwfCount;
	@ChineseName("查出问题和隐患(项)")
	public String jcYhCount;
	@ChineseName("结束检查时间")
	public String jsjcDate;
	@ChineseName("被督查部门")
	public String bjcDep;
	@ChineseName("监管机关编码")
	public String jgjgCode;
	/**
	 * 用到的参数
	 * 
	 */
	//前置时间
	public String firstDate;
	//后置时间
	public String lastDate;
	
	public String getFirstDate() {
		return firstDate;
	}
	
	public String getSheng() {
		return sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	public String getShi() {
		return shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getXian() {
		return xian;
	}

	public void setXian(String xian) {
		this.xian = xian;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getBbId() {
		return bbId;
	}
	public void setBbId(String bbId) {
		this.bbId = bbId;
	}
	public String getGovCode() {
		return govCode;
	}
	public void setGovCode(String govCode) {
		this.govCode = govCode;
	}
	public String getGovName() {
		return govName;
	}
	public void setGovName(String govName) {
		this.govName = govName;
	}
	public String getGovFzr() {
		return govFzr;
	}
	public void setGovFzr(String govFzr) {
		this.govFzr = govFzr;
	}
	public String getGovPlace() {
		return govPlace;
	}
	public void setGovPlace(String govPlace) {
		this.govPlace = govPlace;
	}
	public String getTbPeople() {
		return tbPeople;
	}
	public void setTbPeople(String tbPeople) {
		this.tbPeople = tbPeople;
	}
	public String getGovPhone() {
		return govPhone;
	}
	public void setGovPhone(String govPhone) {
		this.govPhone = govPhone;
	}
	public String getDczName() {
		return dczName;
	}
	public void setDczName(String dczName) {
		this.dczName = dczName;
	}
	public String getTbDate() {
		return tbDate;
	}
	public void setTbDate(String tbDate) {
		this.tbDate = tbDate;
	}
	public String getJcDate() {
		return jcDate;
	}
	public void setJcDate(String jcDate) {
		this.jcDate = jcDate;
	}
	public String getJcybyhCount() {
		return jcybyhCount;
	}
	public void setJcybyhCount(String jcybyhCount) {
		this.jcybyhCount = jcybyhCount;
	}
	public String getYzgCount() {
		return yzgCount;
	}
	public void setYzgCount(String yzgCount) {
		this.yzgCount = yzgCount;
	}
	public String getYbyhzgl() {
		return ybyhzgl;
	}
	public void setYbyhzgl(String ybyhzgl) {
		this.ybyhzgl = ybyhzgl;
	}
	public String getJczdyhCount() {
		return jczdyhCount;
	}
	public void setJczdyhCount(String jczdyhCount) {
		this.jczdyhCount = jczdyhCount;
	}
	public String getZdyhzgCount() {
		return zdyhzgCount;
	}
	public void setZdyhzgCount(String zdyhzgCount) {
		this.zdyhzgCount = zdyhzgCount;
	}
	public String getZdyhzgl() {
		return zdyhzgl;
	}
	public void setZdyhzgl(String zdyhzgl) {
		this.zdyhzgl = zdyhzgl;
	}
	public String getXqzgCount() {
		return xqzgCount;
	}
	public void setXqzgCount(String xqzgCount) {
		this.xqzgCount = xqzgCount;
	}
	public String getJcName() {
		return jcName;
	}
	public void setJcName(String jcName) {
		this.jcName = jcName;
	}
	public String getGovMainName() {
		return govMainName;
	}
	public void setGovMainName(String govMainName) {
		this.govMainName = govMainName;
	}
	public String getJcQuestionCount() {
		return jcQuestionCount;
	}
	public void setJcQuestionCount(String jcQuestionCount) {
		this.jcQuestionCount = jcQuestionCount;
	}
	public String getZgCount() {
		return zgCount;
	}
	public void setZgCount(String zgCount) {
		this.zgCount = zgCount;
	}
	public String getZgl() {
		return zgl;
	}
	public void setZgl(String zgl) {
		this.zgl = zgl;
	}
	public String getBbType() {
		return bbType;
	}
	public void setBbType(String bbType) {
		this.bbType = bbType;
	}
	public String getDepartmentCOunt() {
		return departmentCOunt;
	}
	public void setDepartmentCOunt(String departmentCOunt) {
		this.departmentCOunt = departmentCOunt;
	}
	public String getEnterpriseCount() {
		return enterpriseCount;
	}
	public void setEnterpriseCount(String enterpriseCount) {
		this.enterpriseCount = enterpriseCount;
	}
	public String getGovCount() {
		return govCount;
	}
	public void setGovCount(String govCount) {
		this.govCount = govCount;
	}
	public String getShStatus() {
		return shStatus;
	}
	public void setShStatus(String shStatus) {
		this.shStatus = shStatus;
	}
	public String getJcProvice() {
		return jcProvice;
	}
	public void setJcProvice(String jcProvice) {
		this.jcProvice = jcProvice;
	}
	public String getJcCity() {
		return jcCity;
	}
	public void setJcCity(String jcCity) {
		this.jcCity = jcCity;
	}
	public String getJcCountry() {
		return jcCountry;
	}
	public void setJcCountry(String jcCountry) {
		this.jcCountry = jcCountry;
	}
	public String getZgtzCount() {
		return zgtzCount;
	}
	public void setZgtzCount(String zgtzCount) {
		this.zgtzCount = zgtzCount;
	}
	public String getZfwfCount() {
		return zfwfCount;
	}
	public void setZfwfCount(String zfwfCount) {
		this.zfwfCount = zfwfCount;
	}
	public String getJcYhCount() {
		return jcYhCount;
	}
	public void setJcYhCount(String jcYhCount) {
		this.jcYhCount = jcYhCount;
	}
	public String getJsjcDate() {
		return jsjcDate;
	}
	public void setJsjcDate(String jsjcDate) {
		this.jsjcDate = jsjcDate;
	}
	public String getBjcDep() {
		return bjcDep;
	}
	public void setBjcDep(String bjcDep) {
		this.bjcDep = bjcDep;
	}
	public String getJgjgCode() {
		return jgjgCode;
	}
	public void setJgjgCode(String jgjgCode) {
		this.jgjgCode = jgjgCode;
	}
	
	
}
