package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
//import com.ay.framework.core.pojo.MapPojo;
//import com.ay.framework.core.pojo.MapType;
/**
 * 
 * @项目名称:jfds2.0
 * @类名称:CommunicationAgency
 * @类描述:通信保障机构;
 * @创建人:雷远亮
 * @创建时间:2014年7月16日10:27:02
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @version 2.0
 */
@ChineseName("通信保障机构;Detail;List:SHOW=jgmc,fzrxm:FUNCTION=修改,查看;")
public class CommunicationAgency extends MapPojo{
	@ChineseName("机构名称")
	private String jgmc;
	@ChineseName("机构代码")
	private String jgdm;
	@ChineseName("机构类别")
	private String jglb;
	@ChineseName("隶属关系")
	private String lsgx;
	@ChineseName("注册日期")
	private String zcrq;
	@ChineseName("占地面积(m2)")
	private String zdmj;
	@ChineseName("建筑面积(m2)")
	private String jjmj;
	@ChineseName("救援车辆（辆）")
	private String jycl;
	@ChineseName("机构情况介绍")
	private String jgqkjs;
	@ChineseName("机构详细地址")
	private String jgxxdz;
	@ChineseName("所属单位（部门）")
	private String ssdw;
	@ChineseName("负责人姓名")
	private String fzrxm;
	@ChineseName("负责人联系方式")
	private String fzrlxfs;
	@ChineseName("联系人姓名")
	private String lxrxm;
	@ChineseName("联系人联系方式")
	private String lxrlxfs;
	@ChineseName("地图标注")
	private String dtbz;
	/*单位名称*/
	private String corpName;
	private String jglbName;
	private String lsgxName;
	public String getJglbName() {
		return jglbName;
	}
	public void setJglbName(String jglbName) {
		this.jglbName = jglbName;
	}
	public String getLsgxName() {
		return lsgxName;
	}
	public void setLsgxName(String lsgxName) {
		this.lsgxName = lsgxName;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getJglb() {
		return jglb;
	}
	public void setJglb(String jglb) {
		this.jglb = jglb;
	}
	public String getLsgx() {
		return lsgx;
	}
	public void setLsgx(String lsgx) {
		this.lsgx = lsgx;
	}
	public String getZcrq() {
		return zcrq;
	}
	public void setZcrq(String zcrq) {
		this.zcrq = zcrq;
	}
	public String getZdmj() {
		return zdmj;
	}
	public void setZdmj(String zdmj) {
		this.zdmj = zdmj;
	}
	public String getJjmj() {
		return jjmj;
	}
	public void setJjmj(String jjmj) {
		this.jjmj = jjmj;
	}
	public String getJycl() {
		return jycl;
	}
	public void setJycl(String jycl) {
		this.jycl = jycl;
	}
	public String getJgqkjs() {
		return jgqkjs;
	}
	public void setJgqkjs(String jgqkjs) {
		this.jgqkjs = jgqkjs;
	}
	public String getJgxxdz() {
		return jgxxdz;
	}
	public void setJgxxdz(String jgxxdz) {
		this.jgxxdz = jgxxdz;
	}
	public String getSsdw() {
		return ssdw;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}
	public String getFzrxm() {
		return fzrxm;
	}
	public void setFzrxm(String fzrxm) {
		this.fzrxm = fzrxm;
	}
	public String getFzrlxfs() {
		return fzrlxfs;
	}
	public void setFzrlxfs(String fzrlxfs) {
		this.fzrlxfs = fzrlxfs;
	}
	public String getLxrxm() {
		return lxrxm;
	}
	public void setLxrxm(String lxrxm) {
		this.lxrxm = lxrxm;
	}
	public String getLxrlxfs() {
		return lxrlxfs;
	}
	public void setLxrlxfs(String lxrlxfs) {
		this.lxrlxfs = lxrlxfs;
	}
	public String getDtbz() {
		return dtbz;
	}
	public void setDtbz(String dtbz) {
		this.dtbz = dtbz;
	}
	
	@Override
	public MapType getMapType() {
		return MapType.communication;
	}

}
