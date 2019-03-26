package com.ay.ydzf.zhifawenshu.pojo2014;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:南京智慧安监云平台
 * @类名:Wsgl.java 
 * @描述:
 * @创建人: 杨丰智 
 * @创建时间: 2015年9月1日上午10:56:18 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
//@ChineseName("文书管理")
public class Wsgl extends BasePojo{

	@ChineseName("名称")
	public String name;
	@ChineseName("阶段")
	public String scjd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScjd() {
		return scjd;
	}
	public void setScjd(String scjd) {
		this.scjd = scjd;
	}
	
}
