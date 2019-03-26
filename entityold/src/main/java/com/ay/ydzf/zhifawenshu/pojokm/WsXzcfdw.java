package com.ay.ydzf.zhifawenshu.pojokm;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

//@ChineseName("行政（当场）处罚决定书（单位）")
public class WsXzcfdw extends BasePojo {
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
	@ChineseName("被处罚单位")
	public String bcfdw;
	@ChineseName("地址")
	public String dz;
	@ChineseName("邮编")
	public String yb;
	@ChineseName("法定代表人")
	public String fddbr;
	@ChineseName("职务")
	public String zw;
	@ChineseName("联系电话")
	public String lxdh;
	@ChineseName("违法事实及证据")
	public String wfss;
	@ChineseName("违法规定")
	public String wfgd;
	@ChineseName("依据规定")
	public String yjgd;
	@ChineseName("行政处罚")
	public String xzcf;
	@ChineseName("罚款方式")
	public String fkfs;
	@ChineseName("15日内缴至")
	public String jz;
	@ChineseName("帐号")
	public String zh;
	@ChineseName("人名政府")
	public String zf;
	@ChineseName("申请单位")
	public String sqdw;
	@ChineseName("人民法院")
	public String rmfy;
	@ChineseName("执法人员一")
	public String zfryy;
	@ChineseName("执法人员二")
	public String zfrye;
	@ChineseName("当事人或委托代理人签名")
	public String dsr;
	@ChineseName("时间")
	public String sj;
	@ChineseName("是否完成")
	public String sfwc;
	@ChineseName("版本号")
	public String version;
	//地方字号
	public String dfzh;
	public String getBcfdw() {
		return bcfdw;
	} 
	public String getDsr() {
		return dsr;
	}
	
	
	
	
	public String getDz() {
		return dz;
	}
	public String getFddbr() {
		return fddbr;
	}
	public String getFkfs() {
		return fkfs;
	}
	public String getJz() {
		return jz;
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
	public String getRmfy() {
		return rmfy;
	}

	public String getSj() {
		return sj;
	}
	public String getSqdw() {
		return sqdw;
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
	public String getWfgd() {
		return wfgd;
	}
	public String getWfss() {
		return wfss;
	}
	public String getXzcf() {
		return xzcf;
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
	public String getYjgd() {
		return yjgd;
	}
	public String getZf() {
		return zf;
	}
	public String getZfrye() {
		return zfrye;
	}
	public String getZfryy() {
		return zfryy;
	}
	public String getZh() {
		return zh;
	}
	public String getZw() {
		return zw;
	}
	public void setBcfdw(String bcfdw) {
		this.bcfdw = bcfdw;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public void setFkfs(String fkfs) {
		this.fkfs = fkfs;
	}
	public void setJz(String jz) {
		this.jz = jz;
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
	public void setRmfy(String rmfy) {
		this.rmfy = rmfy;
	}

	public String getSfwc() {
		return sfwc;
	}
	public void setSfwc(String sfwc) {
		this.sfwc = sfwc;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public void setSqdw(String sqdw) {
		this.sqdw = sqdw;
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
	public void setWfgd(String wfgd) {
		this.wfgd = wfgd;
	}
	public void setWfss(String wfss) {
		this.wfss = wfss;
	}
	public void setXzcf(String xzcf) {
		this.xzcf = xzcf;
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
	public void setYjgd(String yjgd) {
		this.yjgd = yjgd;
	}
	public void setZf(String zf) {
		this.zf = zf;
	}
	public void setZfrye(String zfrye) {
		this.zfrye = zfrye;
	}
	public void setZfryy(String zfryy) {
		this.zfryy = zfryy;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getDfzh() {
		return dfzh;
	}
	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}
	
	
}
