package com.test.bean;

import com.ay.framework.annotation.ChineseName;
//import com.ay.framework.core.pojo.MapPojo;
//import com.ay.framework.core.pojo.MapType;
/**
 * 
 * @项目名称:jfds2.0
 * @类名称:RescueEquipment
 * @类描述:应急救援装备;
 * @创建人:雷远亮
 * @创建时间:2014年7月16日10:27:02
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @version 2.0
 */
@ChineseName("应急救援装备;Detail;List:SHOW=zbmc,zblb:FUNCTION=修改,查看;")
public class RescueEquipment extends MapPojo{
	/**
     * 时间：2017年9月1日 下午12:51:13
     * 作者：张传浩
     */
    private static final long serialVersionUID = -6266446371104601295L;
    @ChineseName("装备名称")
	private String zbmc;
	@ChineseName("装备类别;Spinner:url=data/dataAction!findByType?typeId=yjjyzblb&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String zblb;
	@ChineseName("装备数量")
	private String zbsl;
	@ChineseName("装备型号")
	private String zbxh;
	@ChineseName("装备规格")
	private String zbgg;
	@ChineseName("购入日期")
	private String grqq;
	@ChineseName("生产厂家")
	private String sccj;
	@ChineseName("出厂日期")
	private String ccrq;
	@ChineseName("有效期至")
	private String yxqz;
	@ChineseName("用途说明")
	private String ytsm;
	@ChineseName("性能说明")
	private String xnsm;
	@ChineseName("所属单位（部门）")
	private String ssdw;
	@ChineseName("存放地点")
	private String cfdd;
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
	/*单位名称*/
	private String corpName;
	private String zblbName;
	private String bmmc;
	
	public String getZblbName() {
		return zblbName;
	}
	public void setZblbName(String zblbName) {
		this.zblbName = zblbName;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getZbmc() {
		return zbmc;
	}
	public void setZbmc(String zbmc) {
		this.zbmc = zbmc;
	}
	public String getZblb() {
		return zblb;
	}
	public void setZblb(String zblb) {
		this.zblb = zblb;
	}
	public String getZbsl() {
		return zbsl;
	}
	public void setZbsl(String zbsl) {
		this.zbsl = zbsl;
	}
	public String getZbxh() {
		return zbxh;
	}
	public void setZbxh(String zbxh) {
		this.zbxh = zbxh;
	}
	public String getZbgg() {
		return zbgg;
	}
	public void setZbgg(String zbgg) {
		this.zbgg = zbgg;
	}
	public String getGrqq() {
		return grqq;
	}
	public void setGrqq(String grqq) {
		this.grqq = grqq;
	}
	public String getSccj() {
		return sccj;
	}
	public void setSccj(String sccj) {
		this.sccj = sccj;
	}
	public String getCcrq() {
		return ccrq;
	}
	public void setCcrq(String ccrq) {
		this.ccrq = ccrq;
	}
	public String getYxqz() {
		return yxqz;
	}
	public void setYxqz(String yxqz) {
		this.yxqz = yxqz;
	}
	public String getYtsm() {
		return ytsm;
	}
	public void setYtsm(String ytsm) {
		this.ytsm = ytsm;
	}
	public String getXnsm() {
		return xnsm;
	}
	public void setXnsm(String xnsm) {
		this.xnsm = xnsm;
	}
	public String getSsdw() {
		return ssdw;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}
	public String getCfdd() {
		return cfdd;
	}
	public void setCfdd(String cfdd) {
		this.cfdd = cfdd;
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
		return MapType.rescueequipment;
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
	
}
