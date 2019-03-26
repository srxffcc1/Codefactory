package com.test.bean;
import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
@ChineseName("综合应急预案实体类;Detail;List:SHOW=planName,time:FUNCTION=修改,查看;")
public class ComprehensivePlan extends BasePojo {
	@ChineseName("时间：2017年9月7日 下午9:18:56")
	public String isGov;
	@ChineseName("只做判断用（孙小康）")
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
	public String accidentType;
	@ChineseName("事故类型代码——子类")
	public String accidentTypeSubclass;
	@ChineseName("事故类型")
	public String accidentTypeText;
	@ChineseName("事故类型")
	public String accidentTypeSubclassText;
	@ChineseName("预案等级;Spinner:url=data/dataAction!findDataByTypeFirstLevel.action?typeId=yajb:codekey=dataCode:namekey=dataName;")
	public String planLevel;
	@ChineseName("预案等级")
	public String planLevelText;
	@ChineseName("预案创建时间")
	public String time;
	@ChineseName("编制目的*")
	public String planContentBzmd;
	@ChineseName("编制依据*")
	public String planContentBzyj;
	@ChineseName("适用范围*")
	public String planContentSyfw;
	@ChineseName("应急预案体系*")
	public String planContentYjyatx;
	@ChineseName("工作原则*")
	public String planContentYjgzyz;
	@ChineseName("(应急救援)生产经营单位概况*")
	public String planContentScjydw;
	@ChineseName("危险源与风险分析*")
	public String planContentWxyyfxfx;
	@ChineseName("应急组织体系*")
	public String planContentYjzztx;
	@ChineseName("指挥机构及职责*")
	public String planContentZhjgzz;
	@ChineseName("危险源监控*")
	public String planContentWxyjg;
	@ChineseName("预警行动*")
	public String planContentYjxd;
	@ChineseName("信息报告与处置*")
	public String planContentXxbgycz;
	@ChineseName("响应分级*")
	public String planContentXyfj;
	@ChineseName("响应程序*")
	public String planContentXycy;
	@ChineseName("应急结束*")
	public String planContentYjjs;
	@ChineseName("信息发布*")
	public String planContentXxfb;
	@ChineseName("后期处置*")
	public String planContentHqcz;
	@ChineseName("通信与信息保障*")
	public String planContentTxyxxbz;
	@ChineseName("预案内容")
	public String planContentYjdwbz;
	@ChineseName("预案内容")
	public String planContentYjwzzbbz;
	@ChineseName("预案内容")
	public String planContentJfbz;
	@ChineseName("预案内容")
	public String planContentQtbz;
	@ChineseName("培训*")
	public String planContentPx;
	@ChineseName("演练*")
	public String planContentYl;
	@ChineseName("奖惩*")
	public String planContentJc;
	@ChineseName("术语和定义*")
	public String planContentSyhdy;
	@ChineseName("应急预案备案*")
	public String planContentYjyaba;
	@ChineseName("维护和更新*")
	public String planContentWhhgx;
	@ChineseName("制定和解释*")
	public String planContentZdyjs;
	@ChineseName("预案内容")
	public String planContentYjyass;
	@ChineseName("起草部门的组织机构代码")
	public String draftDepartment;
	@ChineseName("起草部门")
	public String draftDepartmentName;
	@ChineseName("起草时间")
	public String draftDate;
	@ChineseName("编制单位")
	public String bzdw;
}

