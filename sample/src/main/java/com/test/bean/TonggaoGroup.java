package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/**
 * 通知公告分组
 * @author CYH
 * 2015年9月22日
 */
@SuppressWarnings("serial")
@ChineseName("通知公告分组;Detail;List:SHOW=uname,fddbr,isview:FUNCTION=查看;")
public class TonggaoGroup extends BasePojo {
	@ChineseName("公告id")
	public String fid;
	@ChineseName("用户id")
	public String uid;
	@ChineseName("所属地区")
	public String ssdq;
	@ChineseName("专项监管行业")
	public String jghy;
	@ChineseName("是否查看")
	public String isview;
	@ChineseName("备注")
	public String descs;
	
	@ChineseName("用户名")
	public String uname;
	@ChineseName("生产经营地址")
	public String scjydz;
	@ChineseName("法定代表人")
	public String fddbr;
	@ChineseName("联系电话")
	public String lxdh;
	
	public String account;
	
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getIsview() {
		return isview;
	}
	public void setIsview(String isview) {
		this.isview = isview;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public String getSsdq() {
		return ssdq;
	}
	public void setSsdq(String ssdq) {
		this.ssdq = ssdq;
	}
	public String getJghy() {
		return jghy;
	}
	public void setJghy(String jghy) {
		this.jghy = jghy;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getScjydz() {
		return scjydz;
	}
	public void setScjydz(String scjydz) {
		this.scjydz = scjydz;
	}
	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
