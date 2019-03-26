package com.ay.ydzf.zhifawenshu.pojo2014;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("询问通知书")
public class WsXwtz extends BasePojo{
	@ChineseName("行政执法id")
	public String xzzfid;
	@ChineseName("执法文书名称")
	public String tname;
	@ChineseName("填报时间")
	public String tbsj;
	@ChineseName("企业ID")
	public String qyid;
	@ChineseName("地方")
	public String pcode;
	@ChineseName("字")
	public String ycode;
	@ChineseName("号")
	public String ncode;
	@ChineseName("被检查人")
	public String bjcr;
	@ChineseName("原因")
	public String yy;
	@ChineseName("询问时间")
	public String xwsj;
	@ChineseName("询问地点")
	public String xwdd;
	@ChineseName("材料类别")
	public String cllb;
	@ChineseName("自定义材料")
	public String zdycl;
	@ChineseName("管理部门地址")
	public String glbmdz;
	@ChineseName("联系人")
	public String lxr;
	@ChineseName("联系电话")
	public String lxdh;
	@ChineseName("时间")
	public String sj;
	@ChineseName("是否完成")
	public int sfwc=1;
	@ChineseName("版本")
	public String version;
	public String getBjcr() {
		return bjcr;
	}
	public String getCllb() {
		return cllb;
	}
	
	
	public String getGlbmdz() {
		return glbmdz;
	}
	public String getLxdh() {
		return lxdh;
	}
	public String getLxr() {
		return lxr;
	}
	public String getNcode() {
		return ncode;
	}
	public String getPcode() {
		return pcode;
	}
	public String getQyid() {
		return qyid;
	}
	public int getSfwc() {
		return sfwc;
	}
	public String getSj() {
		return sj;
	}
	public String getTbsj() {
		return tbsj;
	}
	public String getTname() {
		return tname;
	}
	public String getVersion() {
		return version;
	}
	public String getXwdd() {
		return xwdd;
	}
	public String getXwsj() {
		return xwsj;
	}
	public String getXzzfid() {
		return xzzfid;
	}
	public String getYcode() {
		return ycode;
	}
	public String getYy() {
		return yy;
	}
	public String getZdycl() {
		return zdycl;
	}
	public void setBjcr(String bjcr) {
		this.bjcr = bjcr;
	}
	public void setCllb(String cllb) {
		this.cllb = cllb;
	}
	public void setGlbmdz(String glbmdz) {
		this.glbmdz = glbmdz;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public void setNcode(String ncode) {
		this.ncode = ncode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public void setQyid(String qyid) {
		this.qyid = qyid;
	}
	public void setSfwc(int sfwc) {
		this.sfwc = sfwc;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setXwdd(String xwdd) {
		this.xwdd = xwdd;
	}
	public void setXwsj(String xwsj) {
		this.xwsj = xwsj;
	}
	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}
	public void setYcode(String ycode) {
		this.ycode = ycode;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
	public void setZdycl(String zdycl) {
		this.zdycl = zdycl;
	}
	
	
}
