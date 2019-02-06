package com.test.bean;

import com.ay.framework.annotation.ChineseName;

@ChineseName("行政执法信息;List:SHOW=qymc,jcsj:FUNCTION=查看,修改,阶段操作;")
public class TbXzzfinfo  {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
	 *企业id
	 */
	private String qyid;

	/**
	 *检查类型大类（从元数据读取）
	 */
	private String jclxDl;

	/**
	 *检查类型小类（从元数据读取）
	 */
	private String jclxXl;

	/**
	 *检查时间
	 */
	private String jcsj;

	/**
	 *检查人员
	 */
	private String jcry;
	
	/**
     *检查部门
     */
    private String jcbm;

	/**
	 *检查状态(0-已完成检查；1-现场检查记录阶段；2-责令整改阶段；3-企业回复阶段；4-整改复查阶段；5-再次整改复查阶段；6-立案；)
	 */
	private String jczt;

	/**
	 *企业回复附件id
	 */
	private String qihffjid;

	/**
	 *企业延期申请附件id
	 */
	private String yqsqfjid;

	/**
	 *企业名称
	 */
	private String qymc;

	/**
     *企业属地
     */
    private String qysd;
    
    /**
     *企业行业类别
     */
    private String qyhylb;
	
	/**
	 *企业地址
	 */
	private String remarkyi;

	/**
	 *企业法人
	 */
	private String remarker;

	/**
	 *企业法人职务
	 */
	private String remarksan;

	/**
	 *企业法人手机
	 */
	private String remarksi;

	/**
	 *责令整改时间或延期整改时间
	 */
	private String remarkwu;

	/**
	 *是否 并处过
	 */
	private String remarkliu;

	/**
	 *是否 再次复查过
	 */
	private String isAgainZgfc;

	/**
	 *检查情况开头描述
	 */
	private String jcqkkt;

	/**
	 *检查情况结尾后缀
	 */
	private String jcqkjw;

	// 检查开始时间（暂存字段，查询用）
	private String dateFrom;
	
	// 检查结束时间（暂存字段，查询用）
	private String dateTo;

	private String startWsh;//文书号开始（暂存字段，查询用）

	private String entWsh;//文书号截止（暂存字段，查询用）

	private String zfwsName;//用于判断子表名称（暂存字段，查询用）

	public String getZfwsName() {
		return zfwsName;
	}

	public void setZfwsName(String zfwsName) {
		this.zfwsName = zfwsName;
	}

	public String getStartWsh() {
		return startWsh;
	}

	public void setStartWsh(String startWsh) {
		this.startWsh = startWsh;
	}

	public String getEntWsh() {
		return entWsh;
	}

	public void setEntWsh(String entWsh) {
		this.entWsh = entWsh;
	}

	/**
	 * 行政区划id
	 */
	private String xzqhid;

	public String getXzqhid() {
		return xzqhid;
	}

	public void setXzqhid(String xzqhid) {
		this.xzqhid = xzqhid;
	}

	public String getQyid() {
		return qyid;
	}
	public void setQyid(String qyid) {
		this.qyid = qyid;
	}

	public String getJclxDl() {
		return jclxDl;
	}

	public void setJclxDl(String jclxDl) {
		this.jclxDl = jclxDl;
	}

	public String getJclxXl() {
		return jclxXl;
	}

	public void setJclxXl(String jclxXl) {
		this.jclxXl = jclxXl;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getJcry() {
		return jcry;
	}

	public void setJcry(String jcry) {
		this.jcry = jcry;
	}

	public String getJczt() {
		return jczt;
	}

	public void setJczt(String jczt) {
		this.jczt = jczt;
	}

	public String getQihffjid() {
		return qihffjid;
	}

	public void setQihffjid(String qihffjid) {
		this.qihffjid = qihffjid;
	}

	public String getYqsqfjid() {
		return yqsqfjid;
	}

	public void setYqsqfjid(String yqsqfjid) {
		this.yqsqfjid = yqsqfjid;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
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

	public String getIsAgainZgfc() {
		return isAgainZgfc;
	}

	public void setIsAgainZgfc(String isAgainZgfc) {
		this.isAgainZgfc = isAgainZgfc;
	}

	public String getJcqkkt() {
		return jcqkkt;
	}

	public void setJcqkkt(String jcqkkt) {
		this.jcqkkt = jcqkkt;
	}

	public String getJcqkjw() {
		return jcqkjw;
	}

	public void setJcqkjw(String jcqkjw) {
		this.jcqkjw = jcqkjw;
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
    public String getJcbm() {
        return jcbm;
    }
    public void setJcbm(String jcbm) {
        this.jcbm = jcbm;
    }
    public String getQysd() {
        return qysd;
    }
    public void setQysd(String qysd) {
        this.qysd = qysd;
    }
    public String getQyhylb() {
        return qyhylb;
    }
    public void setQyhylb(String qyhylb) {
        this.qyhylb = qyhylb;
    }
    @Override
    public String toString() {
        return "TbXzzfinfo [qyid=" + qyid + ", jclxDl=" + jclxDl + ", jclxXl=" + jclxXl + ", jcsj=" + jcsj + ", jcry="
                + jcry + ", jcbm=" + jcbm + ", jczt=" + jczt + ", qihffjid=" + qihffjid + ", yqsqfjid=" + yqsqfjid
                + ", qymc=" + qymc + ", qysd=" + qysd + ", qyhylb=" + qyhylb + ", remarkyi=" + remarkyi + ", remarker="
                + remarker + ", remarksan=" + remarksan + ", remarksi=" + remarksi + ", remarkwu=" + remarkwu
                + ", remarkliu=" + remarkliu + ", isAgainZgfc=" + isAgainZgfc + ", jcqkkt=" + jcqkkt + ", jcqkjw="
                + jcqkjw + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
    }
	
}