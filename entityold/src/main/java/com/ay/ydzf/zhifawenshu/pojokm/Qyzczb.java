package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;

@ChineseName("企业自查自报")
public class Qyzczb {



    @ChineseName("只是作为判断条件用")
    public String sun;
	@ChineseName("用户登录名")
	public String userAccount;
	
	@ChineseName("被检查部位")
	public String bjcbw;
	
	@ChineseName("检查时间")
	public String jcsj;
	@ChineseName("检查人员")
	public String jcry;
	
	@ChineseName("隐患级别")
	public String yhjb;
	
	@ChineseName("检查类别 1402450826247:企业自查  1402450853577:专家检查 1402450871365:企业联网互查")
	public String jclb;
	
	@ChineseName("隐患大类")
	public String yhdl;
	
	@ChineseName("隐患中类")
	public String yhzl;
	
	@ChineseName("整改责任部门")
	public String zgzrbm;
	
	@ChineseName("整改责任人")
	public String zgzrr;
	
	@ChineseName("计划完成时间")
	public String jhwcsj;
	
	@ChineseName("整改状态 yzg完成 wzg未完成zgz整改中")
	public String zgzt;
	
	@ChineseName("复查时间")
	public String fcsj;
	
	@ChineseName("复查人")
	public String fcr;
	
	@ChineseName("整改投入资金")
	public String zgtrzj;
	
	@ChineseName("存在问题和隐患")
	public String czwtyh;
	
	@ChineseName("存在问题和隐患备注")
	public String czwtyhbz;
	
	@ChineseName("具体情况及整改措施方案")
	public String zgcsfa;
	
	@ChineseName("验收情况")
	public String ysqk;
	
	@ChineseName("审核部门")
	public String shbm;
	
	@ChineseName("审核人")
	public String shr;
	
	@ChineseName("审核时间")
	public String shsj;
	
	@ChineseName("审核结论(0:审核不通过 1:转出 2:退回)")
	public String shjl;
	@ChineseName("审核意见")
	public String shyj;
	@ChineseName("市级")
	public String shyjcity;
	@ChineseName("区级")
	public String shyjprovince;
	
	@ChineseName("上报时间")
	public String sbsj;
	@ChineseName("上报类型(0:普通上报 1:零隐患上报)")
	public String sblx;
	
	@ChineseName("隐患当前状态(0:未上报  1:已上报未审核 2:审核不通过 3:审核通过)")
	public String dqzt;
	
	@ChineseName("隐患类型(1:企业自查隐患 2:执法检查隐患3:标准化考评发现的隐患4:专家检查,5:安评发现的隐患,6:卫评发现的隐患7:投诉举报)")
	public String yhlx;
	
	@ChineseName("企业是否自查该隐患(Y/N))")
	public String qysfzcgyh;
	

	@ChineseName("与隐患信息表关联id")
	public String fid;
	
	
	@ChineseName(" 检查时间起")
	public String beginJcsj;
	
	@ChineseName(" 检查时间止")
	public String endJcsj;
	
@ChineseName("	隐患级别 ")
	public String yhjbVal;
	
@ChineseName("	隐患类别 ")
	public String yhlbVal;
	
@ChineseName("	隐患大类 ")
	public String yhdlVal;
	
@ChineseName("	隐患中类")
	public String yhzlVal;
	
@ChineseName("	 整改状态")
	public String zgztVal;
	
@ChineseName("	检查类别 ")
	public String jclbVal;
	
@ChineseName("	审核人名称 ")
	public String shrVal;
	
@ChineseName("	用户登录名")
	public String account;
	
@ChineseName("	用户名称")
	public String userName;
	
@ChineseName("	上报时间起")
	public String beginSbsj;
	
@ChineseName("	上报时间止")
	public String endSbsj;
	
@ChineseName("	是否上报(Y/N  隐患类型:0 2代表未上报  1 3代表已上报)")
	public String sfsb;
	
@ChineseName("	审核部门名称 ")
	public String shbmVal;
	
@ChineseName("	是否重大隐患 ")
	public String sfzdyh;
	@ChineseName("待定2")
	public String lsjtAccount;
	@ChineseName("企业id")
	public String qyid;
	
	@ChineseName("部门抽查是否发现隐患(Y/N)")
	public String ccsffxyh;
	
	@ChineseName("整改完成时间")
	public String zgwcsj;
	@ChineseName("行业监管类型")
	public String zxjghyb;
	@ChineseName("行业监管类型名字")
	public String zxjghybName;
	@ChineseName("投诉人")
	public String tsr;
	@ChineseName("联系电话")
	public String tsrdh;
	
	@ChineseName("填报人")
	public String tbr;
	@ChineseName("隐患地点")
	public String yhdd;
	@ChineseName("整改完成日期")
	public String zgwcrq;
	@ChineseName("整改类型")
	public String zglx;
	@ChineseName("整改类型值")
	public String zglxVal;
	@ChineseName("是否检查")
	public String sfjc;
	@ChineseName("检查人")
	public String ccrname;
	@ChineseName("检查时间")
	public String ccsj;
	@ChineseName("检查说明")
	public String ccsm;
	
	@ChineseName("评审机构ID")
	public String psjgid;
	@ChineseName("评审机构名字")
	public String psjgName;
	
	@ChineseName("重大隐患状态")
	public String zdyhzt;
	@ChineseName("隐患整改通知")
	public String yhzgtz;
	@ChineseName("督办单位")
	public String dbdw;
	@ChineseName("复查结论")
	public String zffcjl;
	@ChineseName("复查意见")
	public String zffcyj;
	@ChineseName("复查部门")
	public String fcbm;
	@ChineseName("应急预案")
	public String yjya;
	@ChineseName("销号单位")
	public String xhdw;
	@ChineseName("销号人")
	public String xhrname;
	@ChineseName("销号日期")
	public String xhrq;
	@ChineseName("销号意见")
	public String xhyj;
	@ChineseName("销号结果")
	public String xhjg;
	@ChineseName("重大隐患级别（分为1、2、3级）")
	public String zdwxyjb;
	@ChineseName("重大隐患级别名字（分为1、2、3级）")
	public String zdwxyjbVal;
	@ChineseName("监管责任单位")
	public String jgzrdw;
	@ChineseName("监管责任人")
	public String jgzrr;
	@ChineseName("核查日期")
	public String hcrq;
	@ChineseName("核查单位")
	public String hcdw;
	@ChineseName("核查情况")
	public String hcqk;
	@ChineseName("验收结果")
	public String ysjg;

	@ChineseName("按清单排查ID")
	public String pcid;
	
	@ChineseName("按清单排查清单ID")
	public String qdid;
	
	@ChineseName("按清单排查检查项ID")
	public String qdjcxid;
	
	@ChineseName("重大隐患验收成员")
	public String yhyszj;
	@ChineseName("重大隐患验收组长")
	public String yhyszjzz;
	@ChineseName("专家验收意见")
	public String zjysyj;
	
	@ChineseName("专家组长   区县级")
	public String zjzz;
	@ChineseName("重大隐患审核专家  区县级")
	public String yhpclzj;
	@ChineseName("专家组长   市级")
	public String zjzzcity;
	@ChineseName("重大隐患审核 市级")
	public String yhyszjcity;
	@ChineseName("专家组长   省级")
	public String zjzzprovince;
	@ChineseName("重大隐患审核 省级")
	public String yhyszprovince;
	@ChineseName("预计投入资金")
	public String yjtrzj;
	@ChineseName("判断是否归档   一般隐患（已整改） 重大隐患（已销号）9：已归档")
	public String gdzt;
	@ChineseName("设为不上报  0  上报1")
	public String bsb;
	@ChineseName("治理目标任务")
	public String zlmbrw;
	@ChineseName("经费物质落实")
	public String jfwzls;
	@ChineseName("治理要求")
	public String zlyq;
	@ChineseName("安全措施和预案")
	public String aqcsyya;
	@ChineseName("0未上报 1上报 2鉴定不通过 3已分配处理4推送企业")
	public String tsjbyhZt;
	@ChineseName("查询码")
	public String cxm;
	@ChineseName("投诉举报处理部门")
	public String tsjbclbm;
	@ChineseName("鉴定意见")
	public String tsjbyhjdyj;
	@ChineseName("1:快速登记2排查清单3快速导入")
	public String yhly;
	@ChineseName("存储快速导入关联id")
	public String ksdrid;
	@ChineseName("区县邀约情况  0不邀约 1邀约专家2邀约机构")
	public String qxyyqk;
	@ChineseName("市邀约情况  0不邀约 1邀约专家2邀约机构")
	public String cityyyqk;
	@ChineseName("省邀约情况  0不邀约 1邀约专家2邀约机构")
	public String provinceyyqk;
	@ChineseName("活动情况id、机构项目id等")
	public String hdqkid;
	@ChineseName("可视状态  1可视  0不可视")
	public String viewzt;
	@ChineseName("机构名称")
	public String jgname;
	@ChineseName("机构区")
	public String jgnameArea;
	@ChineseName("机构省")
	public String jgnameProvince;
	@ChineseName("是否邀约专家0 不邀约  1邀约")
	public String sfyyzj;
	@ChineseName("企业邀约情况 1邀约专家2邀约机构")
	public String qyyyqk;
	@ChineseName("企业邀约专家组长")
	public String qyzjzz;
	@ChineseName("企业邀约专家成员")
	public String qyzjcy;
	@ChineseName("企业邀约机构名称")
	public String qyjgname;
	@ChineseName("企业专家鉴定意见")
	public String qyyj;
	@ChineseName("执法检查检查部门")
	public String jcbm;
	@ChineseName("待定含义")
	public String	act;
	@ChineseName(" 隐患相关的专业能力")
	public String zynl;
	@ChineseName(" 隐患相关的专业能力名字")
	public String zynlName;
	@ChineseName("有无隐患")
	public String ywyh;
	@ChineseName("是否提出整改意见")
	public String sftczgyj;
	@ChineseName("整改情况说明，可不填，未完成整改的需要说明原因")
	public String zgqksm;
	
	
	public String getZynlName() {
		return zynlName;
	}

	public void setZynlName(String zynlName) {
		this.zynlName = zynlName;
	}

	public String getZynl() {
		return zynl;
	}

	public void setZynl(String zynl) {
		this.zynl = zynl;
	}

	public String getYwyh() {
		return ywyh;
	}

	public void setYwyh(String ywyh) {
		this.ywyh = ywyh;
	}

	public String getSftczgyj() {
		return sftczgyj;
	}

	public void setSftczgyj(String sftczgyj) {
		this.sftczgyj = sftczgyj;
	}

	public String getZgqksm() {
		return zgqksm;
	}

	public void setZgqksm(String zgqksm) {
		this.zgqksm = zgqksm;
	}

	public String getJcbm() {
		return jcbm;
	}

	public void setJcbm(String jcbm) {
		this.jcbm = jcbm;
	}

	public String getQyyj() {
		return qyyj;
	}

	public void setQyyj(String qyyj) {
		this.qyyj = qyyj;
	}

	public String getQyyyqk() {
		return qyyyqk;
	}

	public void setQyyyqk(String qyyyqk) {
		this.qyyyqk = qyyyqk;
	}
	
	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getQyzjzz() {
		return qyzjzz;
	}

	public void setQyzjzz(String qyzjzz) {
		this.qyzjzz = qyzjzz;
	}

	public String getQyzjcy() {
		return qyzjcy;
	}

	public void setQyzjcy(String qyzjcy) {
		this.qyzjcy = qyzjcy;
	}

	public String getQyjgname() {
		return qyjgname;
	}

	public void setQyjgname(String qyjgname) {
		this.qyjgname = qyjgname;
	}

	public String getSfyyzj() {
		return sfyyzj;
	}

	public void setSfyyzj(String sfyyzj) {
		this.sfyyzj = sfyyzj;
	}

	public String getJgnameArea() {
		return jgnameArea;
	}

	public void setJgnameArea(String jgnameArea) {
		this.jgnameArea = jgnameArea;
	}

	public String getJgnameProvince() {
		return jgnameProvince;
	}

	public void setJgnameProvince(String jgnameProvince) {
		this.jgnameProvince = jgnameProvince;
	}

	public String getJgname() {
		return jgname;
	}

	public void setJgname(String jgname) {
		this.jgname = jgname;
	}

	public String getViewzt() {
		return viewzt;
	}

	public void setViewzt(String viewzt) {
		this.viewzt = viewzt;
	}

	public String getHdqkid() {
		return hdqkid;
	}

	public void setHdqkid(String hdqkid) {
		this.hdqkid = hdqkid;
	}

	public String getQxyyqk() {
		return qxyyqk;
	}

	public void setQxyyqk(String qxyyqk) {
		this.qxyyqk = qxyyqk;
	}

	public String getCityyyqk() {
		return cityyyqk;
	}

	public void setCityyyqk(String cityyyqk) {
		this.cityyyqk = cityyyqk;
	}

	public String getProvinceyyqk() {
		return provinceyyqk;
	}

	public void setProvinceyyqk(String provinceyyqk) {
		this.provinceyyqk = provinceyyqk;
	}

	public String getZjysyj() {
		return zjysyj;
	}

	public void setZjysyj(String zjysyj) {
		this.zjysyj = zjysyj;
	}

	public String getShyjcity() {
		return shyjcity;
	}

	public void setShyjcity(String shyjcity) {
		this.shyjcity = shyjcity;
	}

	public String getShyjprovince() {
		return shyjprovince;
	}

	public void setShyjprovince(String shyjprovince) {
		this.shyjprovince = shyjprovince;
	}

	public String getYhyszjzz() {
		return yhyszjzz;
	}

	public void setYhyszjzz(String yhyszjzz) {
		this.yhyszjzz = yhyszjzz;
	}

	public String getZjzzcity() {
		return zjzzcity;
	}

	public void setZjzzcity(String zjzzcity) {
		this.zjzzcity = zjzzcity;
	}

	public String getYhyszjcity() {
		return yhyszjcity;
	}

	public void setYhyszjcity(String yhyszjcity) {
		this.yhyszjcity = yhyszjcity;
	}

	public String getZjzzprovince() {
		return zjzzprovince;
	}

	public void setZjzzprovince(String zjzzprovince) {
		this.zjzzprovince = zjzzprovince;
	}

	public String getYhyszprovince() {
		return yhyszprovince;
	}

	public void setYhyszprovince(String yhyszprovince) {
		this.yhyszprovince = yhyszprovince;
	}

	public String getYhly() {
		return yhly;
	}

	public void setYhly(String yhly) {
		this.yhly = yhly;
	}

	public String getZjzz() {
		return zjzz;
	}

	public void setZjzz(String zjzz) {
		this.zjzz = zjzz;
	}

	public String getTsjbyhjdyj() {
		return tsjbyhjdyj;
	}

	public void setTsjbyhjdyj(String tsjbyhjdyj) {
		this.tsjbyhjdyj = tsjbyhjdyj;
	}

	public String getTsjbclbm() {
		return tsjbclbm;
	}

	public void setTsjbclbm(String tsjbclbm) {
		this.tsjbclbm = tsjbclbm;
	}

	public String getCxm() {
		return cxm;
	}

	public void setCxm(String cxm) {
		this.cxm = cxm;
	}

	public String getTsjbyhZt() {
		return tsjbyhZt;
	}

	public void setTsjbyhZt(String tsjbyhZt) {
		this.tsjbyhZt = tsjbyhZt;
	}

	public String getZlmbrw() {
		return zlmbrw;
	}

	public void setZlmbrw(String zlmbrw) {
		this.zlmbrw = zlmbrw;
	}

	public String getJfwzls() {
		return jfwzls;
	}

	public void setJfwzls(String jfwzls) {
		this.jfwzls = jfwzls;
	}

	public String getZlyq() {
		return zlyq;
	}

	public void setZlyq(String zlyq) {
		this.zlyq = zlyq;
	}

	public String getAqcsyya() {
		return aqcsyya;
	}

	public void setAqcsyya(String aqcsyya) {
		this.aqcsyya = aqcsyya;
	}

	public String getBsb() {
		return bsb;
	}

	public void setBsb(String bsb) {
		this.bsb = bsb;
	}

	public String getGdzt() {
		return gdzt;
	}

	public void setGdzt(String gdzt) {
		this.gdzt = gdzt;
	}
	
	public String getYjtrzj() {
		return yjtrzj;
	}

	public void setYjtrzj(String yjtrzj) {
		this.yjtrzj = yjtrzj;
	}

	public String getYhpclzj() {
		return yhpclzj;
	}

	public void setYhpclzj(String yhpclzj) {
		this.yhpclzj = yhpclzj;
	}

	public String getYhyszj() {
		return yhyszj;
	}

	public void setYhyszj(String yhyszj) {
		this.yhyszj = yhyszj;
	}

	public String getJgzrdw() {
		return jgzrdw;
	}

	public void setJgzrdw(String jgzrdw) {
		this.jgzrdw = jgzrdw;
	}

	public String getJgzrr() {
		return jgzrr;
	}

	public void setJgzrr(String jgzrr) {
		this.jgzrr = jgzrr;
	}

	public String getHcrq() {
		return hcrq;
	}

	public void setHcrq(String hcrq) {
		this.hcrq = hcrq;
	}

	public String getHcdw() {
		return hcdw;
	}

	public void setHcdw(String hcdw) {
		this.hcdw = hcdw;
	}

	public String getHcqk() {
		return hcqk;
	}

	public void setHcqk(String hcqk) {
		this.hcqk = hcqk;
	}

	public String getYsjg() {
		return ysjg;
	}

	public void setYsjg(String ysjg) {
		this.ysjg = ysjg;
	}

	public String getZdwxyjbVal() {
		return zdwxyjbVal;
	}

	public void setZdwxyjbVal(String zdwxyjbVal) {
		this.zdwxyjbVal = zdwxyjbVal;
	}

	public String getZdwxyjb() {
		return zdwxyjb;
	}

	public void setZdwxyjb(String zdwxyjb) {
		this.zdwxyjb = zdwxyjb;
	}

	public String getXhdw() {
		return xhdw;
	}

	public void setXhdw(String xhdw) {
		this.xhdw = xhdw;
	}

	

	public String getXhrname() {
		return xhrname;
	}

	public void setXhrname(String xhrname) {
		this.xhrname = xhrname;
	}

	public String getXhrq() {
		return xhrq;
	}

	public void setXhrq(String xhrq) {
		this.xhrq = xhrq;
	}

	public String getXhyj() {
		return xhyj;
	}

	public void setXhyj(String xhyj) {
		this.xhyj = xhyj;
	}

	public String getXhjg() {
		return xhjg;
	}

	public void setXhjg(String xhjg) {
		this.xhjg = xhjg;
	}

	public String getYjya() {
		return yjya;
	}

	public void setYjya(String yjya) {
		this.yjya = yjya;
	}

	public String getFcbm() {
		return fcbm;
	}

	public void setFcbm(String fcbm) {
		this.fcbm = fcbm;
	}

	public String getDbdw() {
		return dbdw;
	}

	public void setDbdw(String dbdw) {
		this.dbdw = dbdw;
	}

	public String getZffcjl() {
		return zffcjl;
	}

	public void setZffcjl(String zffcjl) {
		this.zffcjl = zffcjl;
	}

	public String getZffcyj() {
		return zffcyj;
	}

	public void setZffcyj(String zffcyj) {
		this.zffcyj = zffcyj;
	}

	public String getYhzgtz() {
		return yhzgtz;
	}

	public void setYhzgtz(String yhzgtz) {
		this.yhzgtz = yhzgtz;
	}

	public String getZdyhzt() {
		return zdyhzt;
	}

	public void setZdyhzt(String zdyhzt) {
		this.zdyhzt = zdyhzt;
	}

	public String getPsjgName() {
		return psjgName;
	}

	public void setPsjgName(String psjgName) {
		this.psjgName = psjgName;
	}

	public String getPsjgid() {
		return psjgid;
	}

	public void setPsjgid(String psjgid) {
		this.psjgid = psjgid;
	}

	public String getSfjc() {
		return sfjc;
	}

	public void setSfjc(String sfjc) {
		this.sfjc = sfjc;
	}

	public String getCcrname() {
		return ccrname;
	}

	public void setCcrname(String ccrname) {
		this.ccrname = ccrname;
	}

	public String getCcsj() {
		return ccsj;
	}

	public void setCcsj(String ccsj) {
		this.ccsj = ccsj;
	}

	public String getCcsm() {
		return ccsm;
	}

	public void setCcsm(String ccsm) {
		this.ccsm = ccsm;
	}

	public String getZglxVal() {
		return zglxVal;
	}

	public void setZglxVal(String zglxVal) {
		this.zglxVal = zglxVal;
	}

	public String getTbr() {
		return tbr;
	}

	public void setTbr(String tbr) {
		this.tbr = tbr;
	}

	public String getYhdd() {
		return yhdd;
	}

	public void setYhdd(String yhdd) {
		this.yhdd = yhdd;
	}

	public String getZgwcrq() {
		return zgwcrq;
	}

	public void setZgwcrq(String zgwcrq) {
		this.zgwcrq = zgwcrq;
	}

	public String getZglx() {
		return zglx;
	}

	public void setZglx(String zglx) {
		this.zglx = zglx;
	}

	public String getTsr() {
		return tsr;
	}

	public void setTsr(String tsr) {
		this.tsr = tsr;
	}

	

	public String getTsrdh() {
		return tsrdh;
	}

	public void setTsrdh(String tsrdh) {
		this.tsrdh = tsrdh;
	}

	public String getZxjghyb() {
		return zxjghyb;
	}

	public void setZxjghyb(String zxjghyb) {
		this.zxjghyb = zxjghyb;
	}

	public String getZxjghybName() {
		return zxjghybName;
	}

	public void setZxjghybName(String zxjghybName) {
		this.zxjghybName = zxjghybName;
	}

	public String getCcsffxyh() {
		return ccsffxyh;
	}

	public void setCcsffxyh(String ccsffxyh) {
		this.ccsffxyh = ccsffxyh;
	}

	public String getZgwcsj() {
		return zgwcsj;
	}

	public void setZgwcsj(String zgwcsj) {
		this.zgwcsj = zgwcsj;
	}

	public String getQyid() {
		return qyid;
	}

	public void setQyid(String qyid) {
		this.qyid = qyid;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getBjcbw() {
		return bjcbw;
	}

	public void setBjcbw(String bjcbw) {
		this.bjcbw = bjcbw;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getJcry() {
		return jcry;
	}

	public void setJcry(String jcry) {
		this.jcry = jcry;
	}

	public String getYhjb() {
		return yhjb;
	}

	public void setYhjb(String yhjb) {
		this.yhjb = yhjb;
	}

	public String getJclb() {
		return jclb;
	}

	public void setJclb(String jclb) {
		this.jclb = jclb;
	}

	public String getYhdl() {
		return yhdl;
	}

	public void setYhdl(String yhdl) {
		this.yhdl = yhdl;
	}

	public String getYhzl() {
		return yhzl;
	}

	public void setYhzl(String yhzl) {
		this.yhzl = yhzl;
	}

	public String getZgzrbm() {
		return zgzrbm;
	}

	public void setZgzrbm(String zgzrbm) {
		this.zgzrbm = zgzrbm;
	}

	public String getZgzrr() {
		return zgzrr;
	}

	public void setZgzrr(String zgzrr) {
		this.zgzrr = zgzrr;
	}

	public String getJhwcsj() {
		return jhwcsj;
	}

	public void setJhwcsj(String jhwcsj) {
		this.jhwcsj = jhwcsj;
	}

	public String getZgzt() {
		return zgzt;
	}

	public void setZgzt(String zgzt) {
		this.zgzt = zgzt;
	}

	public String getFcsj() {
		return fcsj;
	}

	public void setFcsj(String fcsj) {
		this.fcsj = fcsj;
	}

	public String getFcr() {
		return fcr;
	}

	public void setFcr(String fcr) {
		this.fcr = fcr;
	}

	public String getZgtrzj() {
		return zgtrzj;
	}

	public void setZgtrzj(String zgtrzj) {
		this.zgtrzj = zgtrzj;
	}

	public String getCzwtyh() {
		return czwtyh;
	}

	public void setCzwtyh(String czwtyh) {
		this.czwtyh = czwtyh;
	}

	public String getCzwtyhbz() {
		return czwtyhbz;
	}

	public void setCzwtyhbz(String czwtyhbz) {
		this.czwtyhbz = czwtyhbz;
	}

	public String getZgcsfa() {
		return zgcsfa;
	}

	public void setZgcsfa(String zgcsfa) {
		this.zgcsfa = zgcsfa;
	}

	public String getYsqk() {
		return ysqk;
	}

	public void setYsqk(String ysqk) {
		this.ysqk = ysqk;
	}

	public String getShbm() {
		return shbm;
	}

	public void setShbm(String shbm) {
		this.shbm = shbm;
	}

	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public String getShsj() {
		return shsj;
	}

	public void setShsj(String shsj) {
		this.shsj = shsj;
	}

	public String getShjl() {
		return shjl;
	}

	public void setShjl(String shjl) {
		this.shjl = shjl;
	}

	public String getShyj() {
		return shyj;
	}

	public void setShyj(String shyj) {
		this.shyj = shyj;
	}

	public String getSbsj() {
		return sbsj;
	}

	public void setSbsj(String sbsj) {
		this.sbsj = sbsj;
	}

	public String getSblx() {
		return sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public String getDqzt() {
		return dqzt;
	}

	public void setDqzt(String dqzt) {
		this.dqzt = dqzt;
	}

	public String getYhlx() {
		return yhlx;
	}

	public void setYhlx(String yhlx) {
		this.yhlx = yhlx;
	}

	public String getQysfzcgyh() {
		return qysfzcgyh;
	}

	public void setQysfzcgyh(String qysfzcgyh) {
		this.qysfzcgyh = qysfzcgyh;
	}

	public String getBeginJcsj() {
		return beginJcsj;
	}

	public void setBeginJcsj(String beginJcsj) {
		this.beginJcsj = beginJcsj;
	}

	public String getEndJcsj() {
		return endJcsj;
	}

	public void setEndJcsj(String endJcsj) {
		this.endJcsj = endJcsj;
	}

	public String getYhjbVal() {
		return yhjbVal;
	}

	public void setYhjbVal(String yhjbVal) {
		this.yhjbVal = yhjbVal;
	}

	public String getYhlbVal() {
		return yhlbVal;
	}

	public void setYhlbVal(String yhlbVal) {
		this.yhlbVal = yhlbVal;
	}

	public String getYhdlVal() {
		return yhdlVal;
	}

	public void setYhdlVal(String yhdlVal) {
		this.yhdlVal = yhdlVal;
	}

	public String getYhzlVal() {
		return yhzlVal;
	}

	public void setYhzlVal(String yhzlVal) {
		this.yhzlVal = yhzlVal;
	}

	public String getZgztVal() {
		return zgztVal;
	}

	public void setZgztVal(String zgztVal) {
		this.zgztVal = zgztVal;
	}

	public String getShrVal() {
		return shrVal;
	}

	public void setShrVal(String shrVal) {
		this.shrVal = shrVal;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBeginSbsj() {
		return beginSbsj;
	}

	public void setBeginSbsj(String beginSbsj) {
		this.beginSbsj = beginSbsj;
	}

	public String getEndSbsj() {
		return endSbsj;
	}

	public void setEndSbsj(String endSbsj) {
		this.endSbsj = endSbsj;
	}

	public String getJclbVal() {
		return jclbVal;
	}

	public void setJclbVal(String jclbVal) {
		this.jclbVal = jclbVal;
	}

	public String getSfsb() {
		return sfsb;
	}

	public void setSfsb(String sfsb) {
		this.sfsb = sfsb;
	}

	public String getShbmVal() {
		return shbmVal;
	}

	public void setShbmVal(String shbmVal) {
		this.shbmVal = shbmVal;
	}

	public String getLsjtAccount() {
		return lsjtAccount;
	}

	public void setLsjtAccount(String lsjtAccount) {
		this.lsjtAccount = lsjtAccount;
	}

	public String getSfzdyh() {
		return sfzdyh;
	}

	public void setSfzdyh(String sfzdyh) {
		this.sfzdyh = sfzdyh;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}



	public String getQdid() {
		return qdid;
	}

	public void setQdid(String qdid) {
		this.qdid = qdid;
	}

	public String getQdjcxid() {
		return qdjcxid;
	}

	public void setQdjcxid(String qdjcxid) {
		this.qdjcxid = qdjcxid;
	}

	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public String getKsdrid() {
		return ksdrid;
	}

	public void setKsdrid(String ksdrid) {
		this.ksdrid = ksdrid;
	}
    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

}

