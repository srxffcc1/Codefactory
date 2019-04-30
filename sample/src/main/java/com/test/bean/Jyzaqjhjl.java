package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

@ChineseName("加油站安全列会记录;Detail;List;")
public class Jyzaqjhjl extends BasePojo {
	@ChineseName("会议地点")
	public  String  hidd;
	@ChineseName("会议主持人")
	public String  hyzcr;
	@ChineseName("记录人")
	public String jlr;
	@ChineseName("会议时间")
	public String hysj;
	@ChineseName("会议议题")
	public  String hyyt;
	@ChineseName("会议人员（签字）;Hide")
	public String hyry;
	@ChineseName("会议内容")
	public String hynr;
	@ChineseName("前期整改情况")
	public String qqzgqk;
	@ChineseName("备注")
	public String bz;
	@ChineseName("企业id;Hide")
	public String qyid;
	@ChineseName("预留字段2;Hide")
	public String ylzd2;
	@ChineseName("预留字段3;Hide")
	public String ylzd3;

	public String getQyid() {
		return qyid;
	}

	public void setQyid(String qyid) {
		this.qyid = qyid;
	}

	public String getYlzd2() {
		return ylzd2;
	}
	public void setYlzd2(String ylzd2) {
		this.ylzd2 = ylzd2;
	}
	public String getYlzd3() {
		return ylzd3;
	}
	public void setYlzd3(String ylzd3) {
		this.ylzd3 = ylzd3;
	}
	public String getHidd() {
		return hidd;
	}
	public void setHidd(String hidd) {
		this.hidd = hidd;
	}
	public String getHyzcr() {
		return hyzcr;
	}
	public void setHyzcr(String hyzcr) {
		this.hyzcr = hyzcr;
	}
	public String getJlr() {
		return jlr;
	}
	public void setJlr(String jlr) {
		this.jlr = jlr;
	}
	public String getHysj() {
		return hysj;
	}
	public void setHysj(String hysj) {
		this.hysj = hysj;
	}
	public String getHyyt() {
		return hyyt;
	}
	public void setHyyt(String hyyt) {
		this.hyyt = hyyt;
	}
	public String getHyry() {
		return hyry;
	}
	public void setHyry(String hyry) {
		this.hyry = hyry;
	}
	public String getHynr() {
		return hynr;
	}
	public void setHynr(String hynr) {
		this.hynr = hynr;
	}
	public String getQqzgqk() {
		return qqzgqk;
	}
	public void setQqzgqk(String qqzgqk) {
		this.qqzgqk = qqzgqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	

}
