package com.test.bean;

import com.ay.framework.annotation.ChineseName;
//import com.ay.framework.core.pojo.MapPojo;
//import com.ay.framework.core.pojo.MapType;
/**
 * 
 * @项目名称:jfds2.0
 * @类名称:RescueTeams
 * @类描述:应急救援队伍;
 * @创建人:雷远亮
 * @创建时间:2014年7月16日10:34:04
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @version 2.0
 */
@ChineseName("应急救援队伍;Detail;List:SHOW=dwmc,dwlx:FUNCTION=修改,查看;")
public class RescueTeams extends MapPojo{
	/**
     * 时间：2017年9月1日 下午1:14:16
     * 作者：张传浩
     */
    private static final long serialVersionUID = -7038437879070362327L;
    @ChineseName("队伍名称")
	private String dwmc;
	@ChineseName("队伍类型;Spinner:url=data/dataAction!findByType?typeId=dwlx&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String dwlx;
	@ChineseName("队伍级别")
	private String dwjb;
	@ChineseName("队伍属性;Spinner:url=data/dataAction!findByType?typeId=dwsx&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String dwsx;
	@ChineseName("适用行业;Spinner:url=data/dataAction!findByType?typeId=syhy&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String syhy;
	@ChineseName("救援专业;Spinner:url=data/dataAction!findByType?typeId=jyzy&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String jyzy;
	@ChineseName("队伍简介")
	private String dwjj;
	@ChineseName("所属单位（部门）")
	private String ssdw;
	@ChineseName("负责人")
	private String fzr;
	@ChineseName("第二联系人")
	private String secfzr;
	@ChineseName("办公电话")
	private String bgdh;
	@ChineseName("住宅电话")
	private String zzdh;
	@ChineseName("手机号码")
	private String sjhm;
	@ChineseName("第二联系人手机号码")
	private String secsjhm;
	@ChineseName("地图标注")
	private String dtbz;
	private String dwlxName;
	private String dwjbName;
	private String dwsxName;
	private String syhyName;
	private String jyzyName;
	/*单位名称*/
	private String corpName;
	private String bmmc;
	
	@ChineseName("队伍人数")
	private String dwrs;
	
	public String getDwlxName() {
		return dwlxName;
	}
	public void setDwlxName(String dwlxName) {
		this.dwlxName = dwlxName;
	}
	public String getDwjbName() {
		return dwjbName;
	}
	public void setDwjbName(String dwjbName) {
		this.dwjbName = dwjbName;
	}
	public String getDwsxName() {
		return dwsxName;
	}
	public void setDwsxName(String dwsxName) {
		this.dwsxName = dwsxName;
	}
	public String getSyhyName() {
		return syhyName;
	}
	public void setSyhyName(String syhyName) {
		this.syhyName = syhyName;
	}
	public String getJyzyName() {
		return jyzyName;
	}
	public void setJyzyName(String jyzyName) {
		this.jyzyName = jyzyName;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getDwlx() {
		return dwlx;
	}
	public void setDwlx(String dwlx) {
		this.dwlx = dwlx;
	}
	public String getDwjb() {
		return dwjb;
	}
	public void setDwjb(String dwjb) {
		this.dwjb = dwjb;
	}
	public String getDwsx() {
		return dwsx;
	}
	public void setDwsx(String dwsx) {
		this.dwsx = dwsx;
	}
	public String getSyhy() {
		return syhy;
	}
	public void setSyhy(String syhy) {
		this.syhy = syhy;
	}
	public String getJyzy() {
		return jyzy;
	}
	public void setJyzy(String jyzy) {
		this.jyzy = jyzy;
	}
	public String getDwjj() {
		return dwjj;
	}
	public void setDwjj(String dwjj) {
		this.dwjj = dwjj;
	}
	public String getSsdw() {
		return ssdw;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}
	public String getFzr() {
		return fzr;
	}
	public void setFzr(String fzr) {
		this.fzr = fzr;
	}
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getZzdh() {
		return zzdh;
	}
	public void setZzdh(String zzdh) {
		this.zzdh = zzdh;
	}
	public String getSjhm() {
		return sjhm;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public String getDtbz() {
		return dtbz;
	}
	public void setDtbz(String dtbz) {
		this.dtbz = dtbz;
	}
	@Override
	public MapType getMapType() {
		// TODO Auto-generated method stub
		return MapType.responseteam;
	}
	public String getBmmc() {
		return bmmc;
	}
	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}
	public String getSecfzr() {
		return secfzr;
	}
	public void setSecfzr(String secfzr) {
		this.secfzr = secfzr;
	}
	public String getSecsjhm() {
		return secsjhm;
	}
	public void setSecsjhm(String secsjhm) {
		this.secsjhm = secsjhm;
	}
	public String getDwrs() {
		return dwrs;
	}
	public void setDwrs(String dwrs) {
		this.dwrs = dwrs;
	}
	
}
