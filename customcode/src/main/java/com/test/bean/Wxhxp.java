package com.test.bean;

import java.io.UnsupportedEncodingException;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:南京智慧安监云平台
 * @类名:Wxhxp.java 
 * @描述:
 * @创建人: 杨丰智 
 * @创建时间: 2015年1月6日下午1:03:42 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
@ChineseName("危险化学品重大危险源信息;Detail;List:SHOW=qymc,wxydymc:FUNCTION=查看;")
public class Wxhxp  extends BasePojo {

	public String qyzzjgdm;
	@ChineseName("企业名称")
	public String qymc;
	@ChineseName("危险源单元名称")
	public String wxydymc;
	@ChineseName("重大危险源级别")
	public String wxyjb;
	public String wxyname;
	@ChineseName("所在地区")
	public String szdq;
	@ChineseName("详细地址")
	public String xxdz;
	@ChineseName("生产经营活动类型")
	public String scjyhdlx;
	@ChineseName("生产存储产所产权")
	public String sccccscq;
	@ChineseName("主要产品")
	public String zycp;
	@ChineseName("防雷防静电设施是否定期接受检测")
	public String flfjdssdqjc;
	@ChineseName("压力容器总数")
	public String ylrqzs;
	@ChineseName("三类压力容器数量")
	public String slylrqsl;
	@ChineseName("R值")
	public String rz;
	@ChineseName("经度")
	public String jd;
	@ChineseName("纬度")
	public String wd;
	@ChineseName("备注")
	public String bz;
	
	public String sfzdwxy;//是否重大危险源
	public String fxpgdj;//风险评估等级
	public String video;
	public String jiance;
	//专项监管行业
	public String zxjglb;
	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getJiance() {
		return jiance;
	}
	public void setJiance(String jiance) {
		this.jiance = jiance;
	}
	public String getFxpgdj() {
		return fxpgdj;
	}
	public void setFxpgdj(String fxpgdj) {
		this.fxpgdj = fxpgdj;
	}
	public String getSfzdwxy() {
		return sfzdwxy;
	}
	public void setSfzdwxy(String sfzdwxy) throws UnsupportedEncodingException {
		this.sfzdwxy = sfzdwxy;
	}
	public String getWxyname() {
		return wxyname;
	}
	public void setWxyname(String wxyname) {
		this.wxyname = wxyname;
	}
	public String getQyzzjgdm() {
		return qyzzjgdm;
	}
	public void setQyzzjgdm(String qyzzjgdm) {
		this.qyzzjgdm = qyzzjgdm;
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
	
	public String getWxyjb() {
		return wxyjb;
	}
	public void setWxyjb(String wxyjb) {
		this.wxyjb = wxyjb;
	}
	public String getSzdq() {
		return szdq;
	}
	public void setSzdq(String szdq) {
		this.szdq = szdq;
	}
	public String getXxdz() {
		return xxdz;
	}
	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}
	public String getScjyhdlx() {
		return scjyhdlx;
	}
	public void setScjyhdlx(String scjyhdlx) {
		this.scjyhdlx = scjyhdlx;
	}
	public String getSccccscq() {
		return sccccscq;
	}
	public void setSccccscq(String sccccscq) {
		this.sccccscq = sccccscq;
	}
	public String getZycp() {
		return zycp;
	}
	public void setZycp(String zycp) {
		this.zycp = zycp;
	}
	public String getFlfjdssdqjc() {
		return flfjdssdqjc;
	}
	public void setFlfjdssdqjc(String flfjdssdqjc) {
		this.flfjdssdqjc = flfjdssdqjc;
	}
	public String getYlrqzs() {
		return ylrqzs;
	}
	public void setYlrqzs(String ylrqzs) {
		this.ylrqzs = ylrqzs;
	}
	public String getSlylrqsl() {
		return slylrqsl;
	}
	public void setSlylrqsl(String slylrqsl) {
		this.slylrqsl = slylrqsl;
	}
	public String getRz() {
		return rz;
	}
	public void setRz(String rz) {
		this.rz = rz;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getWd() {
		return wd;
	}
	public void setWd(String wd) {
		this.wd = wd;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getZxjglb() {
		return zxjglb;
	}
	public void setZxjglb(String zxjglb) {
		this.zxjglb = zxjglb;
	}

}
