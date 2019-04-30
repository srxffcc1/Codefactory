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
@ChineseName("责令限期整改指令书")
public class TbZfwsZlzg extends BaseEntity<TbZfwsZlzg> {
	private static final long serialVersionUID = 1L;

	@ChineseName("行政执法记录信息表ID")
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

	@ChineseName("检查机构名称1（从元数据读取）")
	private String jcjgyi;

	@ChineseName("检查机构名称2（从元数据读取）")
	private String jcjger;

	@ChineseName("检查机构名称3（从元数据读取）")
	private String jcjgsan;

	@ChineseName("执法人员1")
	private String zfryyi;

	@ChineseName("执法人员1证件号码")
	private String zfrybhyi;

	@ChineseName("执法人员2")
	private String zfryer;

	@ChineseName("执法人员2证件号码")
	private String zfrybher;

	@ChineseName("被检查单位负责人签名")
	private String bcdwfzrqm;

	@ChineseName("责令整改文书时间")
	private String zlzgwssj;

	@ChineseName("预留字段1")
	private String remarkyi;

	@ChineseName("预留字段2")
	private String remarker;

	@ChineseName("预留字段3")
	private String remarksan;

	@ChineseName("预留字段4")
	private String remarksi;

	@ChineseName("预留字段5")
	private String remarkwu;

	@ChineseName("预留字段6")
	private String remarkliu;

	@ChineseName("文书编号1中文名")
	private String wsbhyiName;

	@ChineseName("检查机构1中文名")
	private String jcjgyiName;

	@ChineseName("检查机构2中文名")
	private String jcjgerName;

	@ChineseName("检查机构3中文名")
	private String jcjgsanName;

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

	public String getJcjgyi() {
		return jcjgyi;
	}

	public void setJcjgyi(String jcjgyi) {
		this.jcjgyi = jcjgyi;
	}

	public String getJcjger() {
		return jcjger;
	}

	public void setJcjger(String jcjger) {
		this.jcjger = jcjger;
	}

	public String getJcjgsan() {
		return jcjgsan;
	}

	public void setJcjgsan(String jcjgsan) {
		this.jcjgsan = jcjgsan;
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

	public String getZlzgwssj() {
		return zlzgwssj;
	}

	public void setZlzgwssj(String zlzgwssj) {
		this.zlzgwssj = zlzgwssj;
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

	public String getJcjgyiName() {
		return jcjgyiName;
	}

	public void setJcjgyiName(String jcjgyiName) {
		this.jcjgyiName = jcjgyiName;
	}

	public String getJcjgerName() {
		return jcjgerName;
	}

	public void setJcjgerName(String jcjgerName) {
		this.jcjgerName = jcjgerName;
	}

	public String getJcjgsanName() {
		return jcjgsanName;
	}

	public void setJcjgsanName(String jcjgsanName) {
		this.jcjgsanName = jcjgsanName;
	}

	public String getWsbhwu() {
		return wsbhwu;
	}

	public void setWsbhwu(String wsbhwu) {
		this.wsbhwu = wsbhwu;
	}

    @Override
    public String toString() {
        return "TbZfwsZlzg [xzzfid=" + xzzfid + ", wsbhyi=" + wsbhyi + ", wsbher=" + wsbher + ", wsbhsan=" + wsbhsan
                + ", wsbhsi=" + wsbhsi + ", wsbhwu=" + wsbhwu + ", jcjgyi=" + jcjgyi + ", jcjger=" + jcjger
                + ", jcjgsan=" + jcjgsan + ", zfryyi=" + zfryyi + ", zfrybhyi=" + zfrybhyi + ", zfryer=" + zfryer
                + ", zfrybher=" + zfrybher + ", bcdwfzrqm=" + bcdwfzrqm + ", zlzgwssj=" + zlzgwssj + ", remarkyi="
                + remarkyi + ", remarker=" + remarker + ", remarksan=" + remarksan + ", remarksi=" + remarksi
                + ", remarkwu=" + remarkwu + ", remarkliu=" + remarkliu + ", wsbhyiName=" + wsbhyiName + ", jcjgyiName="
                + jcjgyiName + ", jcjgerName=" + jcjgerName + ", jcjgsanName=" + jcjgsanName + "]";
    }
	
}