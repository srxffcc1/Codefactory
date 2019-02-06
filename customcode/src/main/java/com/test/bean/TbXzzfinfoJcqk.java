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
@ChineseName("现场检查记录文书-检查情况信息(存储隐患信息)")
public class TbXzzfinfoJcqk extends BaseEntity<TbXzzfinfoJcqk> {
	private static final long serialVersionUID = 1L;

	/**
	 * @return 空字符串-""
	 */
	private final String STRING_EMPTY = "";

	/**
	 * 已整改
	 */
	private final String STATUS_YZG = "已整改";

	/**
	 * 未整改
	 */
	private final String STATUS_WZG = "未整改";

	/**
	 * 字符串-"0"
	 */
	private final String STRING_0 = "0";

	/**
	 * 字符串-"1"
	 */
	private final String STRING_1 = "1";


	//"行政执法记录信息表ID(外键字段)"
	private String xzzfid;

	@ChineseName("检查内容")
	private String jcnr;

	@ChineseName("检查结果(0-非隐患，1-一般隐患，2-重大隐患)")
	private String jcjg;

	@ChineseName("责令整改完成时间")
	private String zlzgwcsj;

	@ChineseName("申请延期整改完成时间")
	private String yqzgwcsj;

	@ChineseName("整改复查完成时间")
	private String zgfcwcsj;

	@ChineseName("是否整改完成(0-未完成，1-已完成)")
	private String sfzgwc;

	@ChineseName("是否责令整改(1-是，0或其他-否)")
	private String sfzlzg;
	@ChineseName("责令整改检查项序号)")
	private String zlzgxh;

	@ChineseName("编号")
	private String remarkyi;

	@ChineseName("申请延期原因")
	private String remarker;

	@ChineseName("初次整改复查意见")
	private String remarksan;

	@ChineseName("是否进入再次复查")
	private String remarksi;

	@ChineseName("再次复查是否整改完成")
	private String remarkwu;


	@ChineseName("现场处理措施结果")
	private String remarkliu;
	@ChineseName("再次整改复查意见")
	private String againfcyj;



	@ChineseName("是否整改完成 中文")
	private String sfzgwcName;
	@ChineseName("是否写入现场处理措施")
	private String xccstatus;//0不写入 1写入
	@ChineseName("再次整改现场处理措施结果")
	private String agaxcclcsjg;
	@ChineseName("再次复出是否写入现场处理措施")
	private String agaxccstatus;//0不写入 1写入

	private String xccsid;//现场措施id外键(用于存放责令整改)

	private String zczgid;//现场措施id外键(用于存放再次整改)

	// 附件id，外键关联附件，多个以逗号隔开
	private String annexid;
	
	// 附件id，外键关联附件，多个以逗号隔开(整改复查)
    private String annexidzgfc;
    
    // 附件id，外键关联附件，多个以逗号隔开(再次复查)
    private String annexidzcfc;
	
	// 排序（查询数据库用）
	private String sort;
	
	public String getXzzfid() {
		return xzzfid;
	}

	public void setXzzfid(String xzzfid) {
		this.xzzfid = xzzfid;
	}

	public String getJcnr() {
		return jcnr;
	}

	public void setJcnr(String jcnr) {
		this.jcnr = jcnr;
	}

	public String getJcjg() {
		return jcjg;
	}

	public void setJcjg(String jcjg) {
		this.jcjg = jcjg;
	}

	public String getZlzgwcsj() {
		return zlzgwcsj;
	}

	public void setZlzgwcsj(String zlzgwcsj) {
		this.zlzgwcsj = zlzgwcsj;
	}

	public String getYqzgwcsj() {
		return yqzgwcsj;
	}

	public void setYqzgwcsj(String yqzgwcsj) {
		this.yqzgwcsj = yqzgwcsj;
	}

	public String getZgfcwcsj() {
		return zgfcwcsj;
	}

	public void setZgfcwcsj(String zgfcwcsj) {
		this.zgfcwcsj = zgfcwcsj;
	}

	public String getSfzgwc() {
		return sfzgwc;
	}

	public void setSfzgwc(String sfzgwc) {
		this.sfzgwc = sfzgwc;
	}

	public String getSfzlzg() {
		return sfzlzg;
	}

	public void setSfzlzg(String sfzlzg) {
		this.sfzlzg = sfzlzg;
	}

	public String getZlzgxh() {
		return zlzgxh;
	}

	public void setZlzgxh(String zlzgxh) {
		this.zlzgxh = zlzgxh;
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

	public String getAgainfcyj() {
		return againfcyj;
	}

	public void setAgainfcyj(String againfcyj) {
		this.againfcyj = againfcyj;
	}

	public String getSfzgwcName() {
		return sfzgwcName;
	}

	public void setSfzgwcName(String sfzgwcName) {
		this.sfzgwcName = sfzgwcName;
	}

	public String getXccstatus() {
		return xccstatus;
	}

	public void setXccstatus(String xccstatus) {
		this.xccstatus = xccstatus;
	}

	public String getAgaxcclcsjg() {
		return agaxcclcsjg;
	}

	public void setAgaxcclcsjg(String agaxcclcsjg) {
		this.agaxcclcsjg = agaxcclcsjg;
	}

	public String getAgaxccstatus() {
		return agaxccstatus;
	}

	public void setAgaxccstatus(String agaxccstatus) {
		this.agaxccstatus = agaxccstatus;
	}

	public String getXccsid() {
		return xccsid;
	}

	public void setXccsid(String xccsid) {
		this.xccsid = xccsid;
	}

	public String getZczgid() {
		return zczgid;
	}

	public void setZczgid(String zczgid) {
		this.zczgid = zczgid;
	}

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSTRING_EMPTY() {
        return STRING_EMPTY;
    }

    public String getSTATUS_YZG() {
        return STATUS_YZG;
    }

    public String getSTATUS_WZG() {
        return STATUS_WZG;
    }

    public String getSTRING_0() {
        return STRING_0;
    }

    public String getSTRING_1() {
        return STRING_1;
    }

    public String getAnnexid() {
        return annexid;
    }

    public void setAnnexid(String annexid) {
        this.annexid = annexid;
    }

    public String getAnnexidzgfc() {
        return annexidzgfc;
    }

    public void setAnnexidzgfc(String annexidzgfc) {
        this.annexidzgfc = annexidzgfc;
    }

    public String getAnnexidzcfc() {
        return annexidzcfc;
    }

    public void setAnnexidzcfc(String annexidzcfc) {
        this.annexidzcfc = annexidzcfc;
    }
	
}