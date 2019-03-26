package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:南京智慧安监云平台
 * @类名:Zdwxywzxx.java 
 * @描述:
 * @创建人: 杨丰智 
 * @创建时间: 2015年1月6日下午1:27:44 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
@ChineseName("重大危险源危险物质信息;Detail;List:SHOW=qymc,wxydymc:FUNCTION=查看;")
public class Zdwxywzxx extends BasePojo{

	@ChineseName("危险化学品id")
	public String wxhxpId;
	@ChineseName("企业名称")
	public String qymc;
	@ChineseName("危险源单元名称")
	public String wxydymc;
	@ChineseName("危险化学品名称")
	public String wxhxpmc;
	public String wzid;//物质id
	@ChineseName("是否剧毒化学品")
	public String sfjdhxp;
	@ChineseName("危规号")
	public String wgh;
	@ChineseName("所处装置（或区域）")
	public String sczz;
	@ChineseName("存在量（吨或m³）")
	public String czl;
	@ChineseName("临界量（吨或m³）")
	public String ljl;
	@ChineseName("校正系数")
	public String jzxs;
	@ChineseName("Qi")
	public String qz;
	@ChineseName("涉及危险工艺")
	public String sjwxgy;
	@ChineseName("操作人员情况")
	public String czryqk;
	@ChineseName("运输注意事项")
	public String yszysx;
	@ChineseName("备注")
	public String bz;
	
	public String getWzid() {
		return wzid;
	}
	public void setWzid(String wzid) {
		this.wzid = wzid;
	}
	public String getWxhxpId() {
		return wxhxpId;
	}
	public void setWxhxpId(String wxhxpId) {
		this.wxhxpId = wxhxpId;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getWxydymc() {
		return wxydymc;
	}
	public void setWxydymc(String wxydymc) {
		this.wxydymc = wxydymc;
	}
	public String getWxhxpmc() {
		return wxhxpmc;
	}
	public void setWxhxpmc(String wxhxpmc) {
		this.wxhxpmc = wxhxpmc;
	}
	public String getSfjdhxp() {
		return sfjdhxp;
	}
	public void setSfjdhxp(String sfjdhxp) {
		this.sfjdhxp = sfjdhxp;
	}
	public String getWgh() {
		return wgh;
	}
	public void setWgh(String wgh) {
		this.wgh = wgh;
	}
	public String getSczz() {
		return sczz;
	}
	public void setSczz(String sczz) {
		this.sczz = sczz;
	}
	public String getCzl() {
		return czl;
	}
	public void setCzl(String czl) {
		this.czl = czl;
	}
	public String getLjl() {
		return ljl;
	}
	public void setLjl(String ljl) {
		this.ljl = ljl;
	}
	public String getJzxs() {
		return jzxs;
	}
	public void setJzxs(String jzxs) {
		this.jzxs = jzxs;
	}
	public String getQz() {
		return qz;
	}
	public void setQz(String qz) {
		this.qz = qz;
	}
	public String getSjwxgy() {
		return sjwxgy;
	}
	public void setSjwxgy(String sjwxgy) {
		this.sjwxgy = sjwxgy;
	}
	public String getCzryqk() {
		return czryqk;
	}
	public void setCzryqk(String czryqk) {
		this.czryqk = czryqk;
	}
	public String getYszysx() {
		return yszysx;
	}
	public void setYszysx(String yszysx) {
		this.yszysx = yszysx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
