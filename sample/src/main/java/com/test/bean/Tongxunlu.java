package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:南京智慧安监云平台
 * @类名:Tongxunlu.java 
 * @描述:通讯录
 * @创建人: 陈安 
 * @创建时间: 2014年11月5日下午2:58:46 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
@ChineseName("通讯录;Detail;List:SHOW=name,dept:FUNCTION=修改,查看;")
public class Tongxunlu extends BasePojo {
	@ChineseName("姓名")
	private String name;
	private String nameId;
	@ChineseName("所在部门")
	private String dept;
	@ChineseName("所在部门id")
	private String deptid;
	@ChineseName("性别")
	private String sex;
	@ChineseName("旧联系电话")
	private String oldtel;
	@ChineseName("联系电话")
	private String tel;
	@ChineseName("QQ")
	private String qq;
	@ChineseName("电子邮箱")
	private String email;
	@ChineseName("现居住地址")
	private String address;
	@ChineseName("备注")
	private String marker;
	@ChineseName("所在区或市")
	private String szqs;
	@ChineseName("职务")
	private String zw;
	@ChineseName("部门类型")
	private String bmtype;
	@ChineseName("办公室内线")
	private String telnx;
	@ChineseName("办公室外线")
	private String telwx;
	
	private String type;
		
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOldtel() {
		return oldtel;
	}
	public void setOldtel(String oldtel) {
		this.oldtel = oldtel;
	}
	public String getBmtype() {
		return bmtype;
	}
	public void setBmtype(String bmtype) {
		this.bmtype = bmtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getSzqs() {
		return szqs;
	}
	public void setSzqs(String szqs) {
		this.szqs = szqs;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getTelnx() {
		return telnx;
	}
	public void setTelnx(String telnx) {
		this.telnx = telnx;
	}
	public String getTelwx() {
		return telwx;
	}
	public void setTelwx(String telwx) {
		this.telwx = telwx;
	}
	public String getNameId() {
		return nameId;
	}
	public void setNameId(String nameId) {
		this.nameId = nameId;
	}
	
}
