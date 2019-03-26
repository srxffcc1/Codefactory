package com.ay.ydzf.zhifawenshu.pojo2014;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("听证会报告书")
public class WsTzysb extends BasePojo{
	@ChineseName("行政执法id")
	public String xzzfid;
	@ChineseName("执法文书名称")
	public String tname;
	@ChineseName("填报时间")
	public String tbsj;
	@ChineseName("企业ID")
	public String qyid;
	@ChineseName("地方")
	public String pcode;
	@ChineseName("字")
	public String ycode;
	@ChineseName("号")
	public String ncode;
	@ChineseName("案件名称")
	public String caseName;
	@ChineseName("主持人")
	public String compere;
	@ChineseName("听证人员")
	public String hearPeople;
	@ChineseName("书记员")
	public String clerk;
	@ChineseName("听证会基本情况摘要")
	public String hearMeetContent;
	@ChineseName("主持人意见")
	public String suggestion;
	@ChineseName("负责人审核意见")
	public String changerSuggestion;
	@ChineseName("负责人签名")
	public String changer;
	@ChineseName("负责人签名时间")
	public String changerTime;
	@ChineseName("负责人")
	public String comperePeople;
	@ChineseName("负责人审核意见")
	public String compereTime;
	@ChineseName("版本号")
	public String version;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCaseName() {
		return caseName;
	}
	public String getChanger() {
		return changer;
	}
	public String getChangerSuggestion() {
		return changerSuggestion;
	}
	public String getChangerTime() {
		return changerTime;
	}
	public String getClerk() {
		return clerk;
	}
	public String getCompere() {
		return compere;
	}
	public String getComperePeople() {
		return comperePeople;
	}
	public String getCompereTime() {
		return compereTime;
	}
	public String getHearMeetContent() {
		return hearMeetContent;
	}
	public String getHearPeople() {
		return hearPeople;
	}
	public String getNcode() {
		return ncode;
	}
	public String getPcode() {
		return pcode;
	}
	public String getQyid() {
		return qyid;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public String getTbsj() {
		return tbsj;
	}
	public String getTname() {
		return tname;
	}
	public String getXzzfid() {
		return xzzfid;
	}
	public String getYcode() {
		return ycode;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public void setChangerSuggestion(String changerSuggestion) {
		this.changerSuggestion = changerSuggestion;
	}
	public void setChangerTime(String changerTime) {
		this.changerTime = changerTime;
	}
	public void setClerk(String clerk) {
		this.clerk = clerk;
	}
	public void setCompere(String compere) {
		this.compere = compere;
	}
	public void setComperePeople(String comperePeople) {
		this.comperePeople = comperePeople;
	}
	public void setCompereTime(String compereTime) {
		this.compereTime = compereTime;
	}
	public void setHearMeetContent(String hearMeetContent) {
		this.hearMeetContent = hearMeetContent;
	}
	public void setHearPeople(String hearPeople) {
		this.hearPeople = hearPeople;
	}
	public void setNcode(String ncode) {
		this.ncode = ncode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public void setQyid(String qyid) {
		this.qyid = qyid;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}
	public void setYcode(String ycode) {
		this.ycode = ycode;
	}


}
