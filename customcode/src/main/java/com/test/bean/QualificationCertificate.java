package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
/**
 * 
 * @项目名称:jfds2.0
 * @类名称:QualificationCertificate
 * @类描述:资质许可证书;
 * @创建人:施海明
 * @创建时间:2014年11月26日 9:23:14
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @version 2.0
 */
@SuppressWarnings("all")
@ChineseName("资质许可证书;Detail;List:SHOW=zsbh,zsmc,zsyxqz:FUNCTION=修改,查看;")
public class QualificationCertificate extends BasePojo {
	@ChineseName("企业名称")
	public String qymc;

	@ChineseName("组织机构代码")
	public String zzjgdm;
	
	public String getZzjgdm() {
		return zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	@ChineseName("证书编号")
	public String zsbh;
	
	@ChineseName("证书名称")
	public String zsmc;
	
	@ChineseName("资质类别")
	public String zzlb;
	public String zzlbName;
	
	@ChineseName("资质内容")
	public String zznr;
	
	@ChineseName("发证机关")
	public String fzjg;
	
	@ChineseName("发证日期")
	public String fzrq;
	
	@ChineseName("证书有效期起")
	public String zsyxqq;
	
	@ChineseName("证书有效期止")
	public String zsyxqz;
	
	@ChineseName("证书状态")
	public String zszt;
	public String zsztName;
	
	@ChineseName("相关附件")
	public String xgfj;
	
	@ChineseName("备注")
	public String bz;
	
	public String yxstruts;//有效状态



	public String getYxstruts() {
		return yxstruts;
	}

	public void setYxstruts(String yxstruts) {
		this.yxstruts = yxstruts;
	}

	public String getZzlbName() {
		return zzlbName;
	}

	public void setZzlbName(String zzlbName) {
		this.zzlbName = zzlbName;
	}

	public String getZsztName() {
		return zsztName;
	}

	public void setZsztName(String zsztName) {
		this.zsztName = zsztName;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getZsbh() {
		return zsbh;
	}

	public void setZsbh(String zsbh) {
		this.zsbh = zsbh;
	}

	public String getZsmc() {
		return zsmc;
	}

	public void setZsmc(String zsmc) {
		this.zsmc = zsmc;
	}

	public String getZzlb() {
		return zzlb;
	}

	public void setZzlb(String zzlb) {
		this.zzlb = zzlb;
	}

	public String getZznr() {
		return zznr;
	}

	public void setZznr(String zznr) {
		this.zznr = zznr;
	}

	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	public String getFzrq() {
		return fzrq;
	}

	public void setFzrq(String fzrq) {
		this.fzrq = fzrq;
	}

	public String getZsyxqq() {
		return zsyxqq;
	}

	public void setZsyxqq(String zsyxqq) {
		this.zsyxqq = zsyxqq;
	}

	public String getZsyxqz() {
		return zsyxqz;
	}

	public void setZsyxqz(String zsyxqz) {
		this.zsyxqz = zsyxqz;
	}

	public String getZszt() {
		return zszt;
	}

	public void setZszt(String zszt) {
		this.zszt = zszt;
	}

	public String getXgfj() {
		return xgfj;
	}

	public void setXgfj(String xgfj) {
		this.xgfj = xgfj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
