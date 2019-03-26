package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("听证会通知书")
public class WsTzhtzs extends BasePojo {
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
	@ChineseName("处罚单位")
	public String cfdw;
	@ChineseName("案件")
	public String aj;
	@ChineseName("时间")
	public String sj;
	@ChineseName("会议地点")
	public String hydd;
	@ChineseName("主持人姓名")
	public String zcrxm;
	@ChineseName("主持人职务")
	public String zcrzw;
	@ChineseName("听证员姓名1")
	public String tzyxmOne;
	@ChineseName("听证员1职务")
	public String tzyzwOne;
	@ChineseName("听证员姓名1")
	public String tzyxmTwo;
	@ChineseName("听证员2职务")
	public String tzyzwTwo;
	@ChineseName("书记员姓名")
	public String sjyxm;
	@ChineseName("书记员职务")
	public String sjyzw;
	@ChineseName("部门地址")
	public String bmdz;
	@ChineseName("部门联系人")
	public String bmlxr;
	@ChineseName("部门联系电话")
	public String bmlxdh;
	@ChineseName("部门邮编")
	public String bmyb;
	@ChineseName("日期")
	public String rq;
	@ChineseName("是否完成")
	public int sfwc=1;
	@ChineseName("版本号")
	public String version;
	public String getAj() {
		return aj;
	}
	public String getBmdz() {
		return bmdz;
	}

	public String getBmlxdh() {
		return bmlxdh;
	}

	public String getBmlxr() {
		return bmlxr;
	}

	public String getBmyb() {
		return bmyb;
	}

	public String getCfdw() {
		return cfdw;
	}

	public String getHydd() {
		return hydd;
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

	public String getSj() {
		return sj;
	}

	public String getSjyxm() {
		return sjyxm;
	}

	public String getSjyzw() {
		return sjyzw;
	}

	public String getTbsj() {
		return tbsj;
	}

	public String getTname() {
		return tname;
	}

	public String getTzyxmOne() {
		return tzyxmOne;
	}

	public String getTzyxmTwo() {
		return tzyxmTwo;
	}

	public String getTzyzwOne() {
		return tzyzwOne;
	}

	public String getTzyzwTwo() {
		return tzyzwTwo;
	}

	public String getVersion() {
		return version;
	}

	public String getXzzfid() {
		return xzzfid;
	}

	public String getYcode() {
		return ycode;
	}

	public String getZcrxm() {
		return zcrxm;
	}

	public String getZcrzw() {
		return zcrzw;
	}

	public void setAj(String aj) {
		this.aj = aj;
	}

	public void setBmdz(String bmdz) {
		this.bmdz = bmdz;
	}

	public void setBmlxdh(String bmlxdh) {
		this.bmlxdh = bmlxdh;
	}

	public void setBmlxr(String bmlxr) {
		this.bmlxr = bmlxr;
	}

	public void setBmyb(String bmyb) {
		this.bmyb = bmyb;
	}

	public void setCfdw(String cfdw) {
		this.cfdw = cfdw;
	}

	public void setHydd(String hydd) {
		this.hydd = hydd;
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

	public void setSj(String sj) {
		this.sj = sj;
	}

	public void setSjyxm(String sjyxm) {
		this.sjyxm = sjyxm;
	}

	public void setSjyzw(String sjyzw) {
		this.sjyzw = sjyzw;
	}

	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setTzyxmOne(String tzyxmOne) {
		this.tzyxmOne = tzyxmOne;
	}

	public void setTzyxmTwo(String tzyxmTwo) {
		this.tzyxmTwo = tzyxmTwo;
	}

	public void setTzyzwOne(String tzyzwOne) {
		this.tzyzwOne = tzyzwOne;
	}

	public void setTzyzwTwo(String tzyzwTwo) {
		this.tzyzwTwo = tzyzwTwo;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public void setYcode(String ycode) {
		this.ycode = ycode;
	}

	public void setZcrxm(String zcrxm) {
		this.zcrxm = zcrxm;
	}

	public void setZcrzw(String zcrzw) {
		this.zcrzw = zcrzw;
	}

}
