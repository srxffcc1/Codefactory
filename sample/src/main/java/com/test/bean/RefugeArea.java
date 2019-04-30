package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
//import com.ay.framework.core.pojo.MapPojo;
//import com.ay.framework.core.pojo.MapType;
/**
 * 
 * @项目名称:jfds2.0
 * @类名称:RefugeArea
 * @类描述:应急避难场区;
 * @创建人:雷远亮
 * @创建时间:2014年7月16日10:34:04
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @version 2.0
 */
@ChineseName("应急避难场区;Detail;List:SHOW=cqmc,cqlx:FUNCTION=修改,查看;")
public class RefugeArea extends MapPojo{
	@ChineseName("场区名称")
	private String cqmc;
	@ChineseName("场区类型;Spinner:url=data/dataAction!findByType?typeId=bncs&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String cqlx;
	@ChineseName("场区地址")
	private String cqdz;
	@ChineseName("场区面积(m2)")
	private String cqmj;
	@ChineseName("场区容量")
	private String cqrl;
	@ChineseName("场区简介")
	private String cqjj;
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
	/*单位名称*/
	private String corpName;
	private String cqlxName;
	private String bmmc;
	
	public String getCqlxName() {
		return cqlxName;
	}
	public void setCqlxName(String cqlxName) {
		this.cqlxName = cqlxName;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getCqmc() {
		return cqmc;
	}
	public void setCqmc(String cqmc) {
		this.cqmc = cqmc;
	}
	public String getCqlx() {
		return cqlx;
	}
	public void setCqlx(String cqlx) {
		this.cqlx = cqlx;
	}
	public String getCqdz() {
		return cqdz;
	}
	public void setCqdz(String cqdz) {
		this.cqdz = cqdz;
	}
	public String getCqmj() {
		return cqmj;
	}
	public void setCqmj(String cqmj) {
		this.cqmj = cqmj;
	}
	public String getCqrl() {
		return cqrl;
	}
	public void setCqrl(String cqrl) {
		this.cqrl = cqrl;
	}
	public String getCqjj() {
		return cqjj;
	}
	public void setCqjj(String cqjj) {
		this.cqjj = cqjj;
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
		return MapType.shelter;
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
