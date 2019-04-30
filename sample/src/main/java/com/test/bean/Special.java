package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

/** 
 * @项目名称:zhaj2.0
 * @类名:Special.java 
 * @描述:特种作业人员信息
 * @创建人: 雷远亮 
 * @创建时间: 2014年11月13日下午1:17:21 
 * @修改人: 
 * @修改时间: 
 * @修改备注：
 * @version 2.0
 */
@ChineseName("特种作业人员信息;Detail;List:SHOW=xm,tzzylx,yxstruts:FUNCTION=修改,查看;")
public class Special extends BasePojo{
	@ChineseName("所属单位")
	public String zzjgdm;
	@ChineseName("姓名")
	public String xm;
	@ChineseName("性别")
	public String xb;
	@ChineseName("籍贯")
	public String gj;
	@ChineseName("民族")
	public String mz;
	@ChineseName("身份证件类型")
	public String sfzjlx;
	@ChineseName("证件号码")
	public String zjhm;
	@ChineseName("照片")
	public byte[] zp;
	@ChineseName("最高学历")
	public String zgxl;
	@ChineseName("最高学位")
	public String zgxw;
	@ChineseName("最后毕业院校")
	public String zhbyyx;
	@ChineseName("专业")
	public String zy;
	@ChineseName("政治面貌")
	public String zzmm;
	@ChineseName("健康状况")
	public String jkzk;
	@ChineseName("职务")
	public String zw;
	@ChineseName("职称")
	public String zc;
	@ChineseName("所在部门")
	public String szbm;
	@ChineseName("工作职责")
	public String gzzz;
	@ChineseName("特种作业类型")
	public String tzzylx;
	public String tzzylxName;
	@ChineseName("特种作业证号")
	public String tzzyzh;
	@ChineseName("培训单位")
	public String pxdw;
	@ChineseName("发证机关")
	public String fzjg;
	@ChineseName("初领日期")
	public String clrq;
	@ChineseName("复审日期")
	public String fsrq;
	@ChineseName("工作经历")
	public String gzjl;
	@ChineseName("办公电话")
	public String bgdh;
	@ChineseName("移动电话")
	public String yddh;
	@ChineseName("电子邮箱")
	public String dzyx;
	@ChineseName("进入本单位日期")
	public String jrbdwrq;
	@ChineseName("工龄")
	public String gl;
	@ChineseName("资格证书持有情况")
	public String zgzscyqk;
	@ChineseName("培训情况")
	public String pxqk;
	@ChineseName("备注")
	public String bz;
	public String xbName;
	public String mzName;
	public String sfzjlxName;
	public String zgxlName;
	public String zgxwName;
	public String zyName;
	public String zzmmName;
	public String jkzkName;
	public String zcName;
	@ChineseName("人员入职情况")
	public String ryrzqk;
	
	@ChineseName("企业id")
	public String qyid;
	@ChineseName("复审日期到期")
	public String yxstruts;
	

	public String getQyid() {
		return qyid;
	}
	public void setQyid(String qyid) {
		this.qyid = qyid;
	}
	public String getYxstruts() {
		return yxstruts;
	}
	public void setYxstruts(String yxstruts) {
		this.yxstruts = yxstruts;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getSfzjlx() {
		return sfzjlx;
	}
	public void setSfzjlx(String sfzjlx) {
		this.sfzjlx = sfzjlx;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public byte[] getZp() {
		return zp;
	}
	public void setZp(byte[] zp) {
		this.zp = zp;
	}
	public String getZgxl() {
		return zgxl;
	}
	public void setZgxl(String zgxl) {
		this.zgxl = zgxl;
	}
	public String getZgxw() {
		return zgxw;
	}
	public void setZgxw(String zgxw) {
		this.zgxw = zgxw;
	}
	public String getZhbyyx() {
		return zhbyyx;
	}
	public void setZhbyyx(String zhbyyx) {
		this.zhbyyx = zhbyyx;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getJkzk() {
		return jkzk;
	}
	public void setJkzk(String jkzk) {
		this.jkzk = jkzk;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public String getSzbm() {
		return szbm;
	}
	public void setSzbm(String szbm) {
		this.szbm = szbm;
	}
	public String getGzzz() {
		return gzzz;
	}
	public void setGzzz(String gzzz) {
		this.gzzz = gzzz;
	}
	public String getTzzylx() {
		return tzzylx;
	}
	public void setTzzylx(String tzzylx) {
		this.tzzylx = tzzylx;
	}
	public String getTzzyzh() {
		return tzzyzh;
	}
	public void setTzzyzh(String tzzyzh) {
		this.tzzyzh = tzzyzh;
	}
	public String getPxdw() {
		return pxdw;
	}
	public void setPxdw(String pxdw) {
		this.pxdw = pxdw;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public String getClrq() {
		return clrq;
	}
	public void setClrq(String clrq) {
		this.clrq = clrq;
	}
	public String getFsrq() {
		return fsrq;
	}
	public void setFsrq(String fsrq) {
		this.fsrq = fsrq;
	}
	public String getGzjl() {
		return gzjl;
	}
	public void setGzjl(String gzjl) {
		this.gzjl = gzjl;
	}
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getYddh() {
		return yddh;
	}
	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	public String getDzyx() {
		return dzyx;
	}
	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	public String getJrbdwrq() {
		return jrbdwrq;
	}
	public void setJrbdwrq(String jrbdwrq) {
		this.jrbdwrq = jrbdwrq;
	}
	public String getGl() {
		return gl;
	}
	public void setGl(String gl) {
		this.gl = gl;
	}
	public String getZgzscyqk() {
		return zgzscyqk;
	}
	public void setZgzscyqk(String zgzscyqk) {
		this.zgzscyqk = zgzscyqk;
	}
	public String getPxqk() {
		return pxqk;
	}
	public void setPxqk(String pxqk) {
		this.pxqk = pxqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXbName() {
		return xbName;
	}
	public void setXbName(String xbName) {
		this.xbName = xbName;
	}
	public String getMzName() {
		return mzName;
	}
	public void setMzName(String mzName) {
		this.mzName = mzName;
	}
	public String getSfzjlxName() {
		return sfzjlxName;
	}
	public void setSfzjlxName(String sfzjlxName) {
		this.sfzjlxName = sfzjlxName;
	}
	public String getZgxlName() {
		return zgxlName;
	}
	public void setZgxlName(String zgxlName) {
		this.zgxlName = zgxlName;
	}
	public String getZgxwName() {
		return zgxwName;
	}
	public void setZgxwName(String zgxwName) {
		this.zgxwName = zgxwName;
	}
	public String getZyName() {
		return zyName;
	}
	public void setZyName(String zyName) {
		this.zyName = zyName;
	}
	public String getZzmmName() {
		return zzmmName;
	}
	public void setZzmmName(String zzmmName) {
		this.zzmmName = zzmmName;
	}
	public String getJkzkName() {
		return jkzkName;
	}
	public void setJkzkName(String jkzkName) {
		this.jkzkName = jkzkName;
	}
	public String getZcName() {
		return zcName;
	}
	public void setZcName(String zcName) {
		this.zcName = zcName;
	}
	public String getTzzylxName() {
		return tzzylxName;
	}
	public void setTzzylxName(String tzzylxName) {
		this.tzzylxName = tzzylxName;
	}
	public String getRyrzqk() {
		return ryrzqk;
	}
	public void setRyrzqk(String ryrzqk) {
		this.ryrzqk = ryrzqk;
	}
	
}
