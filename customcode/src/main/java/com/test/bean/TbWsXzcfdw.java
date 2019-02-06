package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.ydzf.zhifawenshu.pojoTZ.BaseEntity;

/**
 * ClassName:TbZhiFaRenYuan
 * 所属功能模块: 
 * 功能描述:	 
 *
 * @author   By JrdsFrame Generate V1.0
 * @since    Ver 1.0
 * @Date	 2017年6月2日 上午10:38:53
 */
//("行政（当场）处罚决定书（单位）")
public class TbWsXzcfdw extends BaseEntity<TbWsXzcfdw> {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    @ChineseName("行政执法id")
	private String xzzfid;
	//("文书名称")
	private String tname;
	@ChineseName("填报时间")
	private String tbsj;
	@ChineseName("企业ID")
	private String qyid;
	@ChineseName("地方")
	private String pcode;
	@ChineseName("字")
	private String ycode;
	@ChineseName("号")
	private String ncode;
	@ChineseName("被处罚单位")
	private String bcfdw;
	@ChineseName("地址")
	private String dz;
	@ChineseName("邮编")
	private String yb;
	@ChineseName("法定代表人")
	private String fddbr;
	@ChineseName("职务")
	private String zw;
	@ChineseName("联系电话")
	private String lxdh;
	@ChineseName("违法事实及证据")
	private String wfss;
	@ChineseName("违法规定")
	private String wfgd;
	@ChineseName("依据规定")
	private String yjgd;
	@ChineseName("行政处罚")
	private String xzcf;
	@ChineseName("罚款方式")
	private String fkfs;//0,当场缴纳 1,账号缴纳
	@ChineseName("15日内缴至")
	private String jz;
	@ChineseName("帐号")
	private String zh;
	@ChineseName("人名政府")
	private String zf;
	@ChineseName("申请单位")
	private String sqdw;
	@ChineseName("人民法院")
	private String rmfy;
	@ChineseName("执法人员一")
	private String zfryy;
	@ChineseName("执法人员二")
	private String zfrye;
	@ChineseName("当事人或委托代理人签名")
	private String dsr;
	@ChineseName("时间")
	private String sj;
	@ChineseName("是否完成")
	private String sfwc;
	@ChineseName("版本号")
	private String version;
	@ChineseName("地方字号")
	private String dfzh;
	
	// 检查开始时间（暂存字段，查询用）
    private String dateFrom;
    
    // 检查结束时间（暂存字段，查询用）
    private String dateTo;
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
    public String getDateFrom() {
        return dateFrom;
    }
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }
    public String getDateTo() {
        return dateTo;
    }
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
    @Override
    public String toString() {
        return "TbWsXzcfdw [xzzfid=" + xzzfid + ", tname=" + tname + ", tbsj=" + tbsj + ", qyid=" + qyid + ", pcode="
                + pcode + ", ycode=" + ycode + ", ncode=" + ncode + ", bcfdw=" + bcfdw + ", dz=" + dz + ", yb=" + yb
                + ", fddbr=" + fddbr + ", zw=" + zw + ", lxdh=" + lxdh + ", wfss=" + wfss + ", wfgd=" + wfgd + ", yjgd="
                + yjgd + ", xzcf=" + xzcf + ", fkfs=" + fkfs + ", jz=" + jz + ", zh=" + zh + ", zf=" + zf + ", sqdw="
                + sqdw + ", rmfy=" + rmfy + ", zfryy=" + zfryy + ", zfrye=" + zfrye + ", dsr=" + dsr + ", sj=" + sj
                + ", sfwc=" + sfwc + ", version=" + version + ", dfzh=" + dfzh + "]";
    }
	
}