package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

@ChineseName("工作汇报;Detail;List:SHOW=theme,planName:FUNCTION=修改,查看,汇报;")
public class WorkReport extends BasePojo {
	//汇报
	@ChineseName("主题")
	private String theme;
	@ChineseName("汇报类型;Spinner:string=月度,季度,半年度,年度;")
	private String reportType;
	@ChineseName("汇报内容")
	private String reportContent;
	@ChineseName("相关问题")
	private String problem;
	@ChineseName("资源申请")
	private String resourceApply;
	@ChineseName("备注")
	private String reportBz;
	//计划
	@ChineseName("计划名称")
	private String planName;
	@ChineseName("计划类型;Spinner:string=月度,季度,半年度,年度;")
	private String planType;
	@ChineseName("是否需要协同;Spinner:string=是,否;")
	private String isNeedHelp;
	@ChineseName("计划完成率")
	private String completionRate;
	@ChineseName("计划详情")
	private String planDetial;
	@ChineseName("备注")
	private String planBz;
	
	//审批
	@ChineseName("审批意见")
	private String spyj;
	@ChineseName("是否审批")
	private String spzt;
	
	
	@ChineseName("起草人")
	private String reporter;
	@ChineseName("起草时间")
	private String reportTime;
	
	@ChineseName("备用")
	private String byzd;
	@ChineseName("备用2")
	private String byzd2;
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getResourceApply() {
		return resourceApply;
	}
	public void setResourceApply(String resourceApply) {
		this.resourceApply = resourceApply;
	}
	public String getReportBz() {
		return reportBz;
	}
	public void setReportBz(String reportBz) {
		this.reportBz = reportBz;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getIsNeedHelp() {
		return isNeedHelp;
	}
	public void setIsNeedHelp(String isNeedHelp) {
		this.isNeedHelp = isNeedHelp;
	}
	public String getCompletionRate() {
		return completionRate;
	}
	public void setCompletionRate(String completionRate) {
		this.completionRate = completionRate;
	}
	public String getPlanDetial() {
		return planDetial;
	}
	public void setPlanDetial(String planDetial) {
		this.planDetial = planDetial;
	}
	public String getPlanBz() {
		return planBz;
	}
	public void setPlanBz(String planBz) {
		this.planBz = planBz;
	}
	public String getSpyj() {
		return spyj;
	}
	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}
	public String getSpzt() {
		return spzt;
	}
	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getByzd() {
		return byzd;
	}
	public void setByzd(String byzd) {
		this.byzd = byzd;
	}
	public String getByzd2() {
		return byzd2;
	}
	public void setByzd2(String byzd2) {
		this.byzd2 = byzd2;
	}
	
}
