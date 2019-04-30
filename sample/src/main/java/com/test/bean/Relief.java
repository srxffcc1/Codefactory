package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
//import com.ay.framework.core.pojo.MapPojo;
//import com.ay.framework.core.pojo.MapType;
/**
 * 
 * @项目名称:jfds2.0
 * @类名称:Relief
 * @类描述:应急救援物资;
 * @创建人:雷远亮
 * @创建时间:2014年7月16日10:20:17
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @version 2.0
 */
@ChineseName("应急救援物资;Detail;List:SHOW=wzmc,wzlb:FUNCTION=修改,查看;")
public class Relief extends MapPojo{
	@ChineseName("物资名称")
	private String wzmc;
	@ChineseName("物资类别;Spinner:url=data/dataAction!findByType?typeId=jywzlb&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String wzlb;
	private String wzlbName;
	@ChineseName("物资类别2;Spinner:url=data/dataAction!findByType?typeId=jywzlb&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String wzlb2;
	private String wzlbName2;
	@ChineseName("物资类别3;Spinner:url=data/dataAction!findByType?typeId=jywzlb&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String wzlb3;
	private String wzlbName3;
	@ChineseName("物资数量")
	private String wzsl;
	@ChineseName("物资型号")
	private String wzxh;
	@ChineseName("物资规格")
	private String wzgg;
	@ChineseName("购入日期")
	private String grrq;
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
	private String bmmc;



	public String getWzlb2() {
		return wzlb2;
	}

	public void setWzlb2(String wzlb2) {
		this.wzlb2 = wzlb2;
	}

	public String getWzlbName2() {
		return wzlbName2;
	}

	public void setWzlbName2(String wzlbName2) {
		this.wzlbName2 = wzlbName2;
	}

	public String getWzlb3() {
		return wzlb3;
	}

	public void setWzlb3(String wzlb3) {
		this.wzlb3 = wzlb3;
	}

	public String getWzlbName3() {
		return wzlbName3;
	}

	public void setWzlbName3(String wzlbName3) {
		this.wzlbName3 = wzlbName3;
	}

	public String getWzlbName() {
		return wzlbName;
	}
	public void setWzlbName(String wzlbName) {
		this.wzlbName = wzlbName;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getWzmc() {
		return wzmc;
	}
	public void setWzmc(String wzmc) {
		this.wzmc = wzmc;
	}
	public String getWzlb() {
		return wzlb;
	}
	public void setWzlb(String wzlb) {
		this.wzlb = wzlb;
	}
	public String getWzsl() {
		return wzsl;
	}
	public void setWzsl(String wzsl) {
		this.wzsl = wzsl;
	}
	public String getWzxh() {
		return wzxh;
	}
	public void setWzxh(String wzxh) {
		this.wzxh = wzxh;
	}
	public String getWzgg() {
		return wzgg;
	}
	public void setWzgg(String wzgg) {
		this.wzgg = wzgg;
	}
	public String getGrrq() {
		return grrq;
	}
	public void setGrrq(String grrq) {
		this.grrq = grrq;
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
		return MapType.supplies;
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
