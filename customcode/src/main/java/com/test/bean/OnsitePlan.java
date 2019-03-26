package com.test.bean;
import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
@ChineseName("现场处理方案;Detail;List:SHOW=planName,time:FUNCTION=修改,查看;")
public class OnsitePlan extends BasePojo {
	@ChineseName("是否政府预案 0不是  1是")
	public String isGov;
	public String getIsGov() {
		return isGov;
	}
	public void setIsGov(String isGov) {
		this.isGov = isGov;
	}
	@ChineseName("只做判断用")
	public String sun;
	public String getSun() {
		return sun;
	}
	public void setSun(String sun) {
		this.sun = sun;
	}
	@ChineseName("预案名称")
	public String planName;
	@ChineseName("预案类型")
	public String planType;
	@ChineseName("事故类型;Spinner:url=data/dataAction!findDataByTypeFirstLevel.action?typeId=sglx:codekey=dataCode:namekey=dataName;")
	public String accidenttypeFather;
	@ChineseName("事故类型父级中文")
	public String accidenttypeFatherText;
	@ChineseName("事故类型子级")
	public String accidenttypeSon;
	@ChineseName("事故类型子级中文")
	public String accidenttypeSonText;
	@ChineseName("预案等级;Spinner:url=data/dataAction!findDataByTypeFirstLevel.action?typeId=yajb:codekey=dataCode:namekey=dataName;")
	public String planLevel;
	@ChineseName("预案级别中文")
	public String planLevelText;
	@ChineseName("事故特征")
	public String accidentCharacteristics;
	@ChineseName("应急组织与职责")
	public String organizeDuty;
	@ChineseName("应急处置")
	public String emergencyDisposal;
	@ChineseName("注意事项")
	public String attention;
	@ChineseName("建立时间")
	public String time;
	@ChineseName("企业的组织机构代码")
	public String draftDepartment;
	@ChineseName("企业的名称")
	public String draftDepartmentName;
	@ChineseName("起草时间")
	public String draftDate;
	@ChineseName("危险源物质")
	public String hazardousSubstance;
	public String getDraftDepartmentName() {
		return draftDepartmentName;
	}
	public void setDraftDepartmentName(String draftDepartmentName) {
		this.draftDepartmentName = draftDepartmentName;
	}
	public String getDraftDepartment() {
		return draftDepartment;
	}
	public void setDraftDepartment(String draftDepartment) {
		this.draftDepartment = draftDepartment;
	}
	public String getDraftDate() {
		return draftDate;
	}
	public void setDraftDate(String draftDate) {
		this.draftDate = draftDate;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanName() {
		return this.planName;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getPlanType() {
		return this.planType;
	}
	public void setAccidenttypeFather(String accidenttypeFather) {
		this.accidenttypeFather = accidenttypeFather;
	}
	public String getAccidenttypeFather() {
		return this.accidenttypeFather;
	}
	public void setAccidenttypeSon(String accidenttypeSon) {
		this.accidenttypeSon = accidenttypeSon;
	}
	public String getAccidenttypeSon() {
		return this.accidenttypeSon;
	}
	public String getPlanLevel() {
		return planLevel;
	}
	public void setPlanLevel(String planLevel) {
		this.planLevel = planLevel;
	}
	public void setAccidentCharacteristics(String accidentCharacteristics) {
		this.accidentCharacteristics = accidentCharacteristics;
	}
	public String getAccidentCharacteristics() {
		return this.accidentCharacteristics;
	}
	public void setOrganizeDuty(String organizeDuty) {
		this.organizeDuty = organizeDuty;
	}
	public String getOrganizeDuty() {
		return this.organizeDuty;
	}
	public void setEmergencyDisposal(String emergencyDisposal) {
		this.emergencyDisposal = emergencyDisposal;
	}
	public String getEmergencyDisposal() {
		return this.emergencyDisposal;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getAttention() {
		return this.attention;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAccidenttypeFatherText() {
		return accidenttypeFatherText;
	}
	public void setAccidenttypeFatherText(String accidenttypeFatherText) {
		this.accidenttypeFatherText = accidenttypeFatherText;
	}
	public String getAccidenttypeSonText() {
		return accidenttypeSonText;
	}
	public void setAccidenttypeSonText(String accidenttypeSonText) {
		this.accidenttypeSonText = accidenttypeSonText;
	}
	public String getPlanLevelText() {
		return planLevelText;
	}
	public void setPlanLevelText(String planLevelText) {
		this.planLevelText = planLevelText;
	}
	public String getHazardousSubstance() {
		return hazardousSubstance;
	}
	public void setHazardousSubstance(String hazardousSubstance) {
		this.hazardousSubstance = hazardousSubstance;
	}
}