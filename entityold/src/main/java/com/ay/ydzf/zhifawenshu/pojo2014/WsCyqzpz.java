package com.ay.ydzf.zhifawenshu.pojo2014;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

import java.util.List;

//@ChineseName("抽样取证凭证")
public class WsCyqzpz extends BasePojo{
	/**抽样**/
	public List<com.ay.ydzf.zhifawenshu.pojo2014.WsCyqz> cyqzList;
	@ChineseName("序号")
	public String xh;
	@ChineseName("证据物品名称")
	public String zjwpmc;
	@ChineseName("规格批号")
	public String ggph;
	@ChineseName("数量")
	public String sl;
	@ChineseName("行政执法id")
	public String xzzfid;
	@ChineseName("文书名称")
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
	@ChineseName("抽样取证凭证")
	public String bcydw;
	@ChineseName("现场负责人")
	public String xcfzr;
	@ChineseName("单位地址")
	public String dwdz;
	@ChineseName("联系电话")
	public String lxdh;
	@ChineseName("邮编")
	public String yb;
	@ChineseName("抽样时间初")
	public String cysjc;
	@ChineseName("抽样时间末")
	public String cysjm;
	@ChineseName("抽样地点")
	public String cydd;
	@ChineseName("现场负责人签名")
	public String xcfzrqm;
	@ChineseName("安全生产监管执法人员(签名)1")
	public String zfryqmOne;
	@ChineseName("证号1")
	public String zfryzhOne;
	@ChineseName("安全生产监管执法人员(签名)2")
	public String zfryqmTwo;
	@ChineseName("证号2")
	public String zfryzhTwo;
	@ChineseName("日期")
	public String rq;
	@ChineseName("版本号")
	public String version;
	public String getBcydw() {
		return bcydw;
	}
	public String getCydd() {
		return cydd;
	}
	public List<com.ay.ydzf.zhifawenshu.pojo2014.WsCyqz> getCyqzList() {
		return cyqzList;
	}
	public String getCysjc() {
		return cysjc;
	}
	public String getCysjm() {
		return cysjm;
	}
	public String getDwdz() {
		return dwdz;
	}
	public String getGgph() {
		return ggph;
	}
	public String getLxdh() {
		return lxdh;
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
	public String getRq() {
		return rq;
	}
	
	
	public String getSl() {
		return sl;
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
	public String getXcfzr() {
		return xcfzr;
	}
	public String getXcfzrqm() {
		return xcfzrqm;
	}
	public String getXh() {
		return xh;
	}
	public String getXzzfid() {
		return xzzfid;
	}
	public String getYb() {
		return yb;
	}
	public String getYcode() {
		return ycode;
	}
	public String getZfryqmOne() {
		return zfryqmOne;
	}
	public String getZfryqmTwo() {
		return zfryqmTwo;
	}
	public String getZfryzhOne() {
		return zfryzhOne;
	}
	public String getZfryzhTwo() {
		return zfryzhTwo;
	}
	public String getZjwpmc() {
		return zjwpmc;
	}
	public void setBcydw(String bcydw) {
		this.bcydw = bcydw;
	}
	public void setCydd(String cydd) {
		this.cydd = cydd;
	}
	public void setCyqzList(List<WsCyqz> cyqzList) {
		this.cyqzList = cyqzList;
	}
	public void setCysjc(String cysjc) {
		this.cysjc = cysjc;
	}
	public void setCysjm(String cysjm) {
		this.cysjm = cysjm;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public void setGgph(String ggph) {
		this.ggph = ggph;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
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
	public void setRq(String rq) {
		this.rq = rq;
	}
	public void setSl(String sl) {
		this.sl = sl;
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
	public void setXcfzr(String xcfzr) {
		this.xcfzr = xcfzr;
	}
	public void setXcfzrqm(String xcfzrqm) {
		this.xcfzrqm = xcfzrqm;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public void setYcode(String ycode) {
		this.ycode = ycode;
	}
	public void setZfryqmOne(String zfryqmOne) {
		this.zfryqmOne = zfryqmOne;
	}
	public void setZfryqmTwo(String zfryqmTwo) {
		this.zfryqmTwo = zfryqmTwo;
	}
	public void setZfryzhOne(String zfryzhOne) {
		this.zfryzhOne = zfryzhOne;
	}
	public void setZfryzhTwo(String zfryzhTwo) {
		this.zfryzhTwo = zfryzhTwo;
	}
	public void setZjwpmc(String zjwpmc) {
		this.zjwpmc = zjwpmc;
	}
}
