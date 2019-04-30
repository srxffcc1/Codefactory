package com.test.bean;
import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
@ChineseName("专项应急预案;Detail;List:SHOW=planName,time:FUNCTION=修改,查看;")
@SuppressWarnings("serial")
public class SpecialPlan extends BasePojo {
	@ChineseName("是否政府预案 0不是  1是")
	public String isGov;
	public String getIsGov() {
		return isGov;
	}
	public void setIsGov(String isGov) {
		this.isGov = isGov;
	}
	public String sun;
	public String getSun() {
		return sun;
	}
	public void setSun(String sun) {
		this.sun = sun;
	}
	@ChineseName("预案名称")
	public String planName;
	@ChineseName("用来显示字符串的创建时间")
	public String time;
	@ChineseName("预案类型")
	public String planType;
	@ChineseName("事故类型;Spinner:url=data/dataAction!findDataByTypeFirstLevel.action?typeId=sglx:codekey=dataCode:namekey=dataName;")
	public String accidentType;
	@ChineseName("事故类型 代码")
	public String accidentTypeSubclass;
	@ChineseName("事故类型 中文")
	public String accidentTypeText;
	@ChineseName("事故类型 中文")
	public String accidentTypeSubclassText;
	@ChineseName("预案等级;Spinner:url=data/dataAction!findDataByTypeFirstLevel.action?typeId=yajb:codekey=dataCode:namekey=dataName;")
	public String planLevel;
	@ChineseName("预案等级 中文")
	public String planLevelText;
	@ChineseName("事故类型和危害程度分析")
	public String typeHarmAnalysis;
	@ChineseName("应急处置基本原则")
	public String basicPrinciples;
	@ChineseName("应急组织体系")
	public String emergencyOrganizationSystem;
	@ChineseName("指挥机构及职责")
	public String structureResponsibilities;
	@ChineseName("危险源监控")
	public String hazardControl;
	public String getEmergencyOrganizationSystem() {
		return emergencyOrganizationSystem;
	}
	public void setEmergencyOrganizationSystem(String emergencyOrganizationSystem) {
		this.emergencyOrganizationSystem = emergencyOrganizationSystem;
	}
	public String getSuppliesEquipment() {
		return suppliesEquipment;
	}
	public void setSuppliesEquipment(String suppliesEquipment) {
		this.suppliesEquipment = suppliesEquipment;
	}
	@ChineseName("预警行动")
	public String actionWarning;
	@ChineseName("信息报告程序")
	public String informationReportingProcedures;
	@ChineseName("响应分级")
	public String responseGrading;
	@ChineseName("响应程度")
	public String responseDegree;
	@ChineseName("处置措施")
	public String disposalMeasures;
	@ChineseName("应急物资与装备保障")
	public String suppliesEquipment;
	@ChineseName("指挥人员id")
	public String expId;
	@ChineseName("救援物资id")
	public String suppliesId;
	@ChineseName("起草部门")
	public String draftDepartment;
	@ChineseName("起草时间")
	public String draftDate;
	public String draftDepartmentName;
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
	public String getAccidentTypeSubclass() {
		return accidentTypeSubclass;
	}
	public void setAccidentTypeSubclass(String accidentTypeSubclass) {
		this.accidentTypeSubclass = accidentTypeSubclass;
	}
	public String getAccidentTypeSubclassText() {
		return accidentTypeSubclassText;
	}
	public void setAccidentTypeSubclassText(String accidentTypeSubclassText) {
		this.accidentTypeSubclassText = accidentTypeSubclassText;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	public String getAccidentTypeText() {
		return accidentTypeText;
	}
	public void setAccidentTypeText(String accidentTypeText) {
		this.accidentTypeText = accidentTypeText;
	}
	public String getPlanLevel() {
		return planLevel;
	}
	public void setPlanLevel(String planLevel) {
		this.planLevel = planLevel;
	}
	public String getPlanLevelText() {
		return planLevelText;
	}
	public void setPlanLevelText(String planLevelText) {
		this.planLevelText = planLevelText;
	}
	public String getTypeHarmAnalysis() {
		return typeHarmAnalysis;
	}
	public void setTypeHarmAnalysis(String typeHarmAnalysis) {
		this.typeHarmAnalysis = typeHarmAnalysis;
	}
	public String getBasicPrinciples() {
		return basicPrinciples;
	}
	public void setBasicPrinciples(String basicPrinciples) {
		this.basicPrinciples = basicPrinciples;
	}
	public String getStructureResponsibilities() {
		return structureResponsibilities;
	}
	public void setStructureResponsibilities(String structureResponsibilities) {
		this.structureResponsibilities = structureResponsibilities;
	}
	public String getHazardControl() {
		return hazardControl;
	}
	public void setHazardControl(String hazardControl) {
		this.hazardControl = hazardControl;
	}
	public String getActionWarning() {
		return actionWarning;
	}
	public void setActionWarning(String actionWarning) {
		this.actionWarning = actionWarning;
	}
	public String getInformationReportingProcedures() {
		return informationReportingProcedures;
	}
	public void setInformationReportingProcedures(
			String informationReportingProcedures) {
		this.informationReportingProcedures = informationReportingProcedures;
	}
	public String getResponseGrading() {
		return responseGrading;
	}
	public void setResponseGrading(String responseGrading) {
		this.responseGrading = responseGrading;
	}
	public String getResponseDegree() {
		return responseDegree;
	}
	public void setResponseDegree(String responseDegree) {
		this.responseDegree = responseDegree;
	}
	public String getDisposalMeasures() {
		return disposalMeasures;
	}
	public void setDisposalMeasures(String disposalMeasures) {
		this.disposalMeasures = disposalMeasures;
	}
	public String getExpId() {
		return expId;
	}
	public void setExpId(String expId) {
		this.expId = expId;
	}
	public String getSuppliesId() {
		return suppliesId;
	}
	public void setSuppliesId(String suppliesId) {
		this.suppliesId = suppliesId;
	}
}