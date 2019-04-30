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
@ChineseName("现场检查记录文书")
public class TbZfwsXcjc extends BaseEntity<TbZfwsXcjc> {
	private static final long serialVersionUID = 1L;

	@ChineseName("行政执法记录信息表ID(外键字段)")
	private String xzzfid;

	@ChineseName("文书编号1")
	private String wsbhyi;

	@ChineseName("文书编号2")
	private String wsbher;

	@ChineseName("文书编号3")
	private String wsbhsan;

	@ChineseName("文书编号4")
	private String wsbhsi;
	@ChineseName("文书编号5")
	private String wsbhwu;

	@ChineseName("检查场所")
	private String jccs;

	@ChineseName("检查开始时间")
	private String jcsjks;

	@ChineseName("检查结束时间")
	private String jcsjjs;

	@ChineseName("检查机构名称")
	private String jcjgmc;

	@ChineseName("执法人员1")
	private String zfryyi;

	@ChineseName("执法人员证件号码1")
	private String zfrybhyi;

	@ChineseName("执法人员2")
	private String zfryer;

	@ChineseName("执法人员证件号码2")
	private String zfrybher;

	@ChineseName("被检查单位负责人签名")
	private String bcdwfzrqm;

	@ChineseName("上传附件id")
	private String fjid;

	@ChineseName("被检查单位地址")
	private String remarkyi;

	@ChineseName("被检查负责人")
	private String remarker;

	@ChineseName("被检查负责人职务")
	private String remarksan;

	@ChineseName("被检查负责人联系电话")
	private String remarksi;

	@ChineseName("检查人员签名")
	private String remarkwu;

	@ChineseName("被检查现场负责人签名")
	private String remarkliu;

	@ChineseName("文书编号1 名称")
	private String wsbhyiName;

	@ChineseName("检查机构中文名称")
	private String jcjgmcName;


	@ChineseName("企业名称")
	private String qymc;
	
	@ChineseName("检查时间")
	private String jcsj;
	
	public String getXzzfid() {
		return xzzfid;
	}

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public String getWsbhyi() {
		return wsbhyi;
	}

	public void setWsbhyi(String wsbhyi) {
		this.wsbhyi = wsbhyi;
	}

	public String getWsbher() {
		return wsbher;
	}

	public void setWsbher(String wsbher) {
		this.wsbher = wsbher;
	}

	public String getWsbhsan() {
		return wsbhsan;
	}

	public void setWsbhsan(String wsbhsan) {
		this.wsbhsan = wsbhsan;
	}

	public String getWsbhsi() {
		return wsbhsi;
	}

	public void setWsbhsi(String wsbhsi) {
		this.wsbhsi = wsbhsi;
	}

	public String getJccs() {
		return jccs;
	}

	public void setJccs(String jccs) {
		this.jccs = jccs;
	}

	public String getJcsjks() {
		return jcsjks;
	}

	public void setJcsjks(String jcsjks) {
		this.jcsjks = jcsjks;
	}

	public String getJcsjjs() {
		return jcsjjs;
	}

	public void setJcsjjs(String jcsjjs) {
		this.jcsjjs = jcsjjs;
	}

	public String getJcjgmc() {
		return jcjgmc;
	}

	public void setJcjgmc(String jcjgmc) {
		this.jcjgmc = jcjgmc;
	}

	public String getZfryyi() {
		return zfryyi;
	}

	public void setZfryyi(String zfryyi) {
		this.zfryyi = zfryyi;
	}

	public String getZfrybhyi() {
		return zfrybhyi;
	}

	public void setZfrybhyi(String zfrybhyi) {
		this.zfrybhyi = zfrybhyi;
	}

	public String getZfryer() {
		return zfryer;
	}

	public void setZfryer(String zfryer) {
		this.zfryer = zfryer;
	}

	public String getZfrybher() {
		return zfrybher;
	}

	public void setZfrybher(String zfrybher) {
		this.zfrybher = zfrybher;
	}

	public String getBcdwfzrqm() {
		return bcdwfzrqm;
	}

	public void setBcdwfzrqm(String bcdwfzrqm) {
		this.bcdwfzrqm = bcdwfzrqm;
	}

	public String getFjid() {
		return fjid;
	}

	public void setFjid(String fjid) {
		this.fjid = fjid;
	}

	public String getRemarkyi() {
		return remarkyi;
	}

	public void setRemarkyi(String remarkyi) {
		this.remarkyi = remarkyi;
	}

	public String getRemarker() {
		return remarker;
	}

	public void setRemarker(String remarker) {
		this.remarker = remarker;
	}

	public String getRemarksan() {
		return remarksan;
	}

	public void setRemarksan(String remarksan) {
		this.remarksan = remarksan;
	}

	public String getRemarksi() {
		return remarksi;
	}

	public void setRemarksi(String remarksi) {
		this.remarksi = remarksi;
	}

	public String getRemarkwu() {
		return remarkwu;
	}

	public void setRemarkwu(String remarkwu) {
		this.remarkwu = remarkwu;
	}

	public String getRemarkliu() {
		return remarkliu;
	}

	public void setRemarkliu(String remarkliu) {
		this.remarkliu = remarkliu;
	}

	public String getWsbhyiName() {
		return wsbhyiName;
	}

	public void setWsbhyiName(String wsbhyiName) {
		this.wsbhyiName = wsbhyiName;
	}

	public String getJcjgmcName() {
		return jcjgmcName;
	}

	public void setJcjgmcName(String jcjgmcName) {
		this.jcjgmcName = jcjgmcName;
	}

	public String getWsbhwu() {
		return wsbhwu;
	}

	public void setWsbhwu(String wsbhwu) {
		this.wsbhwu = wsbhwu;
	}

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getJcsj() {
        return jcsj;
    }

    public void setJcsj(String jcsj) {
        this.jcsj = jcsj;
    }

    @Override
    public String toString() {
        return "TbZfwsXcjc [xzzfid=" + xzzfid + ", wsbhyi=" + wsbhyi + ", wsbher=" + wsbher + ", wsbhsan=" + wsbhsan
                + ", wsbhsi=" + wsbhsi + ", wsbhwu=" + wsbhwu + ", jccs=" + jccs + ", jcsjks=" + jcsjks + ", jcsjjs="
                + jcsjjs + ", jcjgmc=" + jcjgmc + ", zfryyi=" + zfryyi + ", zfrybhyi=" + zfrybhyi + ", zfryer=" + zfryer
                + ", zfrybher=" + zfrybher + ", bcdwfzrqm=" + bcdwfzrqm + ", fjid=" + fjid + ", remarkyi=" + remarkyi
                + ", remarker=" + remarker + ", remarksan=" + remarksan + ", remarksi=" + remarksi + ", remarkwu="
                + remarkwu + ", remarkliu=" + remarkliu + ", wsbhyiName=" + wsbhyiName + ", jcjgmcName=" + jcjgmcName
                + ", qymc=" + qymc + ", jcsj=" + jcsj + "]";
    }

}