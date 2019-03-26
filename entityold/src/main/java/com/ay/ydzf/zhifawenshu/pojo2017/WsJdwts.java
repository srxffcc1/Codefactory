package com.ay.ydzf.zhifawenshu.pojo2017;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

import java.util.List;

//@ChineseName("鉴定委托书")
public class WsJdwts extends BasePojo{
	/**鉴定委托书内容**/
	public List<com.ay.ydzf.zhifawenshu.pojo2017.Jdwts> jdwtsList;
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
	@ChineseName("委托单位")
	public String wtdw;
	@ChineseName("物品名称")
	public String wpmc;
	@ChineseName("规格型号")
	public String ggxh;
	@ChineseName("数量")
	public String sl;
	@ChineseName("备注")
	public String bz;
	@ChineseName("鉴定要求")
	public String jdyq;
	@ChineseName("鉴定截至时间")
	public String jzsj;
	@ChineseName("日期")
	public String rq;
	@ChineseName("是否完成")
	public int sfwc=1;
	@ChineseName("鉴定委托书")
	public String version;
	public String getBz() {
		return bz;
	}
	public String getGgxh() {
		return ggxh;
	}
	
	
	public String getJdyq() {
		return jdyq;
	}
	public String getJzsj() {
		return jzsj;
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
	public int getSfwc() {
		return sfwc;
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
	public String getWpmc() {
		return wpmc;
	}
	public String getWtdw() {
		return wtdw;
	}
	public String getXzzfid() {
		return xzzfid;
	}
	public String getYcode() {
		return ycode;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	public void setJdyq(String jdyq) {
		this.jdyq = jdyq;
	}
	public void setJzsj(String jzsj) {
		this.jzsj = jzsj;
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
	public void setSfwc(int sfwc) {
		this.sfwc = sfwc;
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
	public void setWpmc(String wpmc) {
		this.wpmc = wpmc;
	}
	public void setWtdw(String wtdw) {
		this.wtdw = wtdw;
	}
	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}
	public void setYcode(String ycode) {
		this.ycode = ycode;
	}
	public List<com.ay.ydzf.zhifawenshu.pojo2017.Jdwts> getJdwtsList() {
		return jdwtsList;
	}
	public void setJdwtsList(List<com.ay.ydzf.zhifawenshu.pojo2017.Jdwts> jdwtsList) {
		this.jdwtsList = jdwtsList;
	}

}
