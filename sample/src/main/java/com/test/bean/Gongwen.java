package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:南京智慧安监云平台
 * @类名:Gongwlz.java 
 * @描述:公文表
 * @创建人: 陈安 
 * @创建时间: 2014年11月10日下午4:25:53 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
@ChineseName("公文表;Detail;List:SHOW=gwshr,gwbt,gwfj:FUNCTION=查看,进度;")
public class Gongwen extends BasePojo{
	@ChineseName("公文标题")
	public String gwbt;
	@ChineseName("公文内容")
	public String gwnr;
	@ChineseName("公文发送人名称")
	public String fsrname;
	@ChineseName("公文审批人id集合")
	public String sprids;
	@ChineseName("公文审批人姓名字符串")
	public String gwfj;
	
	@ChineseName("公文审核人")
	public String gwshr;
	@ChineseName("公文审核人id")
	public String shrid;
	//创建时间
	public String time;
	
	public String getGwbt() {
		return gwbt;
	}
	public void setGwbt(String gwbt) {
		this.gwbt = gwbt;
	}
	public String getGwnr() {
		return gwnr;
	}
	public void setGwnr(String gwnr) {
		this.gwnr = gwnr;
	}
	public String getFsrname() {
		return fsrname;
	}
	public void setFsrname(String fsrname) {
		this.fsrname = fsrname;
	}
	public String getSprids() {
		return sprids;
	}
	public void setSprids(String sprids) {
		this.sprids = sprids;
	}
	public String getGwfj() {
		return gwfj;
	}
	public void setGwfj(String gwfj) {
		this.gwfj = gwfj;
	}
	public String getGwshr() {
		return gwshr;
	}
	public void setGwshr(String gwshr) {
		this.gwshr = gwshr;
	}
	public String getShrid() {
		return shrid;
	}
	public void setShrid(String shrid) {
		this.shrid = shrid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
