package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
//import com.ay.framework.core.pojo.MapPojo;
//import com.ay.framework.core.pojo.MapType;

/**
 * 
 * @项目名称:jfds2.0
 * @类名称:SafetyExperts
 * @类描述:安全生产专家;
 * @创建人:雷远亮
 * @创建时间:2014年7月16日10:34:04
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @version 2.0
 */
@ChineseName("安全生产专家;Detail;List:SHOW=xm,lxdh:FUNCTION=修改,查看;")
public class SafetyExperts extends MapPojo {
	@ChineseName("姓名")
	private String xm;
	@ChineseName("性别;Spinner:url=data/dataAction!findByType?typeId=22d229c9278745c0b909b108011ba6f3&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String xb;
	@ChineseName("出生年月")
	private String csny;
	@ChineseName("身份证号")
	private String sfzh;
	@ChineseName("学历")
	private String xl;
	@ChineseName("照片")
	private byte[] zp;
	@ChineseName("专业")
	private String zy;
	@ChineseName("专家类别;Spinner:url=data/dataAction!findByType?typeId=zjlb&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String zjlb;
	@ChineseName("工作组别")
	private String gzzb;
	
	@ChineseName("专业技术特长")
	private String zyjstc;
	@ChineseName("专家简介")
	private String zjjj;
	@ChineseName("所属单位（部门）")
	private String ssdw;
	@ChineseName("单位地址")
	private String dwdz;
	@ChineseName("现任职务")
	private String xrzw;
	@ChineseName("办公电话")
	private String bgdh;
	@ChineseName("联系电话")
	private String lxdh;
	@ChineseName("电子邮箱")
	private String dzyx;
	@ChineseName("家庭住址")
	private String jtzz;
	@ChineseName("住宅电话")
	private String zzdh;
	@ChineseName("地图标注")
	private String dtbz;
	@ChineseName("类型")
	private String type;//0--综合理论组；1--应急处理组；2--日常指导组
	@ChineseName("聘用机构")
	private String pyjg;
	@ChineseName("籍贯")
	private String jg;
	@ChineseName("民族")
	private String mz;
	@ChineseName("技术职称;Spinner:url=data/dataAction!findByType?typeId=zc&parentId=-1:codekey=dataCode:namekey=dataName;")
	private String jszc;
	@ChineseName("人员履历")
	private String ryll;
	@ChineseName("身份证件类型")
	private String sfzjlx;
	@ChineseName("学位")
	private String zgxw;
	@ChineseName("毕业院校")
	private String byyx;
	@ChineseName("政治面貌")
	private String zzmm;
	@ChineseName("专家类型")
	private String zjlx;//最新文档概念同类别对调
	@ChineseName("擅长事故类型")
	private String scsglx;
	@ChineseName("参与事故处理经历")
	private String cysgcljl;
	@ChineseName("备注")
	private String bz;
	
	@ChineseName("行业领域")
	private String hyly;
	@ChineseName("专业类别")
	private String zylb;
	@ChineseName("现从事专业")
	private String xcszy;
	@ChineseName("监管行业")
	private String jghy;
	
	/*以下是不进行持久化 下拉框*/
	private String xbName;
	private String xlName;
	private String zyName;
	private String gzzbName;
	private String zjlbName;
	public String getXbName() {
		return xbName;
	}
	public void setXbName(String xbName) {
		this.xbName = xbName;
	}
	public String getXlName() {
		return xlName;
	}
	public void setXlName(String xlName) {
		this.xlName = xlName;
	}
	public String getZyName() {
		return zyName;
	}
	public void setZyName(String zyName) {
		this.zyName = zyName;
	}
	public String getGzzbName() {
		return gzzbName;
	}
	public void setGzzbName(String gzzbName) {
		this.gzzbName = gzzbName;
	}
	public String getZjlbName() {
		return zjlbName;
	}
	public void setZjlbName(String zjlbName) {
		this.zjlbName = zjlbName;
	}
	public String getPyjg() {
		return pyjg;
	}
	public void setPyjg(String pyjg) {
		this.pyjg = pyjg;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getCsny() {
		return csny;
	}
	public void setCsny(String csny) {
		this.csny = csny;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getZjlb() {
		return zjlb;
	}
	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}
	public String getGzzb() {
		return gzzb;
	}
	public void setGzzb(String gzzb) {
		this.gzzb = gzzb;
	}
	public String getZjjj() {
		return zjjj;
	}
	public void setZjjj(String zjjj) {
		this.zjjj = zjjj;
	}
	public String getSsdw() {
		return ssdw;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getXrzw() {
		return xrzw;
	}
	public void setXrzw(String xrzw) {
		this.xrzw = xrzw;
	}
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getDzyx() {
		return dzyx;
	}
	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	public String getJtzz() {
		return jtzz;
	}
	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}
	public String getZzdh() {
		return zzdh;
	}
	public void setZzdh(String zzdh) {
		this.zzdh = zzdh;
	}
	public String getDtbz() {
		return dtbz;
	}
	public void setDtbz(String dtbz) {
		this.dtbz = dtbz;
	}
	public byte[] getZp() {
		return zp;
	}
	public void setZp(byte[] zp) {
		this.zp = zp;
	}
	public String getZyjstc() {
		return zyjstc;
	}
	public void setZyjstc(String zyjstc) {
		this.zyjstc = zyjstc;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	@Override
	public MapType getMapType() {
		// TODO Auto-generated method stub
		return MapType.expert;
	}
	
	
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getJszc() {
		return jszc;
	}
	public void setJszc(String jszc) {
		this.jszc = jszc;
	}
	public String getRyll() {
		return ryll;
	}
	public void setRyll(String ryll) {
		this.ryll = ryll;
	}
	public String getSfzjlx() {
		return sfzjlx;
	}
	public void setSfzjlx(String sfzjlx) {
		this.sfzjlx = sfzjlx;
	}
	public String getByyx() {
		return byyx;
	}
	public void setByyx(String byyx) {
		this.byyx = byyx;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public String getScsglx() {
		return scsglx;
	}
	public void setScsglx(String scsglx) {
		this.scsglx = scsglx;
	}
	public String getCysgcljl() {
		return cysgcljl;
	}
	public void setCysgcljl(String cysgcljl) {
		this.cysgcljl = cysgcljl;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getZgxw() {
		return zgxw;
	}
	public void setZgxw(String zgxw) {
		this.zgxw = zgxw;
	}
	public String getHyly() {
		return hyly;
	}
	public void setHyly(String hyly) {
		this.hyly = hyly;
	}
	public String getZylb() {
		return zylb;
	}
	public void setZylb(String zylb) {
		this.zylb = zylb;
	}
	public String getXcszy() {
		return xcszy;
	}
	public void setXcszy(String xcszy) {
		this.xcszy = xcszy;
	}
	public String getJghy() {
		return jghy;
	}
	public void setJghy(String jghy) {
		this.jghy = jghy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
