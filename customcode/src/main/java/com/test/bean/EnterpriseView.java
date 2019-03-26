package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

@ChineseName("企业信息;Detail;List:SHOW=qymc,zzjgdm,fddbr:FUNCTION=查看;")
public class EnterpriseView extends BasePojo  {

    @ChineseName("企业名称")
    public String qymc;
    @ChineseName("工商注册号")
    public String gszch;
    @ChineseName("组织机构代码")
    public String zzjgdm;
    @ChineseName("行政区划")
    public String xzqh;
    @ChineseName("成立日期")
    public String clrq;
    @ChineseName("法定代表人")
    public String fddbr;
    @ChineseName("联系人")
    public String lxr;
    @ChineseName("联系电话")
    public String lxdh;
    @ChineseName("电子邮箱")
    public String dzyx;
    @ChineseName("联系微信号")
    public String lxwxh;
    @ChineseName("联系QQ号")
    public String lxqqh;
    @ChineseName("企业官方网站地址")
    public String qygfwzdz;
    @ChineseName("单位传真")
    public String dwcz;
    @ChineseName("主要负责人")
    public String zyfzr;
    @ChineseName("主要负责人固定电话")
    public String zyfzrgddh;
    @ChineseName("主要负责人移动电话")
    public String zyfzryddh;
    @ChineseName("主要负责人电子邮箱")
    public String zyfzrdzyx;
    @ChineseName("安全负责人")
    public String aqfzr;
    @ChineseName("安全负责人固定电话")
    public String aqfzrgddh;
    @ChineseName("安全负责人移动电话")
    public String aqfzryddh;
    @ChineseName("安全负责人电子邮箱")
    public String aqfzrdzyx;
    @ChineseName("注册地址")
    public String zcdz;
    @ChineseName("生产经营地址")
    public String scjydz;
    @ChineseName("邮政编码")
    public String yzbm;
    @ChineseName("经济类型")
    public String jjlx;
    @ChineseName("行业类别")
    public String hylb;
    @ChineseName("隶属关系")
    public String lsgx;
    @ChineseName("经营范围")
    public String jyfw;
    @ChineseName("企业经营状态")
    public String qyjyzt;
    @ChineseName("注册资金(万元)")
    public String zczj;
    @ChineseName("年销售收入(万元)")
    public String nxssr;
    @ChineseName("年利润(万元)")
    public String nlr;
    @ChineseName("资产总额（万元）")
    public String zcze;
    @ChineseName("占地面积(㎡)")
    public String zdmj;
    @ChineseName("从业人员数量")
    public String cyrysl;
    @ChineseName("特种作业人员数量")
    public String tzzyrysl;
    @ChineseName("专职安全生产管理人员数量")
    public String zzaqscglrysl;
    @ChineseName("兼职安全生产管理人员数量")
    public String jzaqscglrysl;
    @ChineseName("专职应急管理人员数量")
    public String zzyjglrysl;
    @ChineseName("注册安全工程师人员数量")
    public String zcaqgcsrys;	// 重复没用
    @ChineseName("注册安全工程师人员数量")
    public String zcaqgcsrysl;
    @ChineseName("营业执照类别")
    public String yyzzlb;
    @ChineseName("规模情况")
    public String gmqk;
    @ChineseName("企业规模")
    public String qygm;
    @ChineseName("母公司名称")
    public String sjgsmc;
    @ChineseName("集团公司名称")
    public String jtgsmc;
    @ChineseName("标准化等级")
    public String bzhdj;
    @ChineseName("安全监管等级")
    public String aqjgdj;
    @ChineseName("监管分类")
    public String jgfl;
    @ChineseName("属地安监机构")
    public String sdajjg;
    @ChineseName("是否有专门安全机构")
    public String sfyzzaqjg;
    @ChineseName("是否有专职安全人员")
    public String sfyzzaqry;
    @ChineseName("是否存在重大危险源")
    public String sfczzdwxy;

    @ChineseName("是否存在职业病危害因素")
    public String sfczzybwhys;
    @ChineseName("是否使用、存储危化品")
    public String sfsyccwhp;

    @ChineseName("企业平面图")
    public String qypmt;
    @ChineseName("隐患排查治理制度")
    public String yhpczlzd;
    @ChineseName("隐患排查治理计划")
    public String yhpczljh;
    @ChineseName("企业位置经度")
    public String qywzjd;
    @ChineseName("企业位置维度")
    public String qywzwd;
    @ChineseName("专项治理类型")
    public String zxzllx;
    @ChineseName("专项监管大类")
    public String zxjghya;
    @ChineseName("专项监管小类")
    public String zxjghyb;
    @ChineseName("备注")
    public String bz;

    @ChineseName("现用作审核意见")
    public String czhm;
    @ChineseName("行政区划省")
    public String xzqhs;
    @ChineseName("行政区划区县")
    public String xzqhqx;
    @ChineseName("行政区划街道")
    public String xzqhjd;
    @ChineseName("行政区划社区")
    public String xzqhsq;
    @ChineseName("专项治理类别")
    public String zxzllb;
    @ChineseName("分类监管")
    public String fljg;
    @ChineseName("法定代表人固话")
    public String fddbrgddh;
    @ChineseName("法定代表人手机")
    public String fddbrsj;
    @ChineseName("监管部门树")
    public String dept;
    @ChineseName("显示的部门")
    public String showDept;
    @ChineseName("是否有隶属集团")
    public String sfylsjt;
    @ChineseName("隶属集团名称")
    public String lsjtmc;
    @ChineseName("是否是集团")
    public String clique;
    @ChineseName("行业类别小类")
    public String hylbxl;
    @ChineseName("经济类型小类")
    public String jjlxxl;
    @ChineseName("监管行业大类")
    public String jghydl;
    @ChineseName("监管行业小类")
    public String jghyxl;

    public String jd;

    public String wd;

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getGszch() {
        return gszch;
    }

    public void setGszch(String gszch) {
        this.gszch = gszch;
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getClrq() {
        return clrq;
    }

    public void setClrq(String clrq) {
        this.clrq = clrq;
    }

    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getDzyx() {
        return dzyx;
    }

    public void setDzyx(String dzyx) {
        this.dzyx = dzyx;
    }

    public String getLxwxh() {
        return lxwxh;
    }

    public void setLxwxh(String lxwxh) {
        this.lxwxh = lxwxh;
    }

    public String getLxqqh() {
        return lxqqh;
    }

    public void setLxqqh(String lxqqh) {
        this.lxqqh = lxqqh;
    }

    public String getQygfwzdz() {
        return qygfwzdz;
    }

    public void setQygfwzdz(String qygfwzdz) {
        this.qygfwzdz = qygfwzdz;
    }

    public String getDwcz() {
        return dwcz;
    }

    public void setDwcz(String dwcz) {
        this.dwcz = dwcz;
    }

    public String getZyfzr() {
        return zyfzr;
    }

    public void setZyfzr(String zyfzr) {
        this.zyfzr = zyfzr;
    }

    public String getZyfzrgddh() {
        return zyfzrgddh;
    }

    public void setZyfzrgddh(String zyfzrgddh) {
        this.zyfzrgddh = zyfzrgddh;
    }

    public String getZyfzryddh() {
        return zyfzryddh;
    }

    public void setZyfzryddh(String zyfzryddh) {
        this.zyfzryddh = zyfzryddh;
    }

    public String getZyfzrdzyx() {
        return zyfzrdzyx;
    }

    public void setZyfzrdzyx(String zyfzrdzyx) {
        this.zyfzrdzyx = zyfzrdzyx;
    }

    public String getAqfzr() {
        return aqfzr;
    }

    public void setAqfzr(String aqfzr) {
        this.aqfzr = aqfzr;
    }

    public String getAqfzrgddh() {
        return aqfzrgddh;
    }

    public void setAqfzrgddh(String aqfzrgddh) {
        this.aqfzrgddh = aqfzrgddh;
    }

    public String getAqfzryddh() {
        return aqfzryddh;
    }

    public void setAqfzryddh(String aqfzryddh) {
        this.aqfzryddh = aqfzryddh;
    }

    public String getAqfzrdzyx() {
        return aqfzrdzyx;
    }

    public void setAqfzrdzyx(String aqfzrdzyx) {
        this.aqfzrdzyx = aqfzrdzyx;
    }

    public String getZcdz() {
        return zcdz;
    }

    public void setZcdz(String zcdz) {
        this.zcdz = zcdz;
    }

    public String getScjydz() {
        return scjydz;
    }

    public void setScjydz(String scjydz) {
        this.scjydz = scjydz;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public String getHylb() {
        return hylb;
    }

    public void setHylb(String hylb) {
        this.hylb = hylb;
    }

    public String getLsgx() {
        return lsgx;
    }

    public void setLsgx(String lsgx) {
        this.lsgx = lsgx;
    }

    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    public String getQyjyzt() {
        return qyjyzt;
    }

    public void setQyjyzt(String qyjyzt) {
        this.qyjyzt = qyjyzt;
    }

    public String getZczj() {
        return zczj;
    }

    public void setZczj(String zczj) {
        this.zczj = zczj;
    }

    public String getNxssr() {
        return nxssr;
    }

    public void setNxssr(String nxssr) {
        this.nxssr = nxssr;
    }

    public String getNlr() {
        return nlr;
    }

    public void setNlr(String nlr) {
        this.nlr = nlr;
    }

    public String getZcze() {
        return zcze;
    }

    public void setZcze(String zcze) {
        this.zcze = zcze;
    }

    public String getZdmj() {
        return zdmj;
    }

    public void setZdmj(String zdmj) {
        this.zdmj = zdmj;
    }

    public String getCyrysl() {
        return cyrysl;
    }

    public void setCyrysl(String cyrysl) {
        this.cyrysl = cyrysl;
    }

    public String getTzzyrysl() {
        return tzzyrysl;
    }

    public void setTzzyrysl(String tzzyrysl) {
        this.tzzyrysl = tzzyrysl;
    }

    public String getZzaqscglrysl() {
        return zzaqscglrysl;
    }

    public void setZzaqscglrysl(String zzaqscglrysl) {
        this.zzaqscglrysl = zzaqscglrysl;
    }

    public String getJzaqscglrysl() {
        return jzaqscglrysl;
    }

    public void setJzaqscglrysl(String jzaqscglrysl) {
        this.jzaqscglrysl = jzaqscglrysl;
    }

    public String getZzyjglrysl() {
        return zzyjglrysl;
    }

    public void setZzyjglrysl(String zzyjglrysl) {
        this.zzyjglrysl = zzyjglrysl;
    }

    public String getZcaqgcsrys() {
        return zcaqgcsrys;
    }

    public void setZcaqgcsrys(String zcaqgcsrys) {
        this.zcaqgcsrys = zcaqgcsrys;
    }

    public String getZcaqgcsrysl() {
        return zcaqgcsrysl;
    }

    public void setZcaqgcsrysl(String zcaqgcsrysl) {
        this.zcaqgcsrysl = zcaqgcsrysl;
    }

    public String getYyzzlb() {
        return yyzzlb;
    }

    public void setYyzzlb(String yyzzlb) {
        this.yyzzlb = yyzzlb;
    }

    public String getGmqk() {
        return gmqk;
    }

    public void setGmqk(String gmqk) {
        this.gmqk = gmqk;
    }

    public String getQygm() {
        return qygm;
    }

    public void setQygm(String qygm) {
        this.qygm = qygm;
    }

    public String getSjgsmc() {
        return sjgsmc;
    }

    public void setSjgsmc(String sjgsmc) {
        this.sjgsmc = sjgsmc;
    }

    public String getJtgsmc() {
        return jtgsmc;
    }

    public void setJtgsmc(String jtgsmc) {
        this.jtgsmc = jtgsmc;
    }

    public String getBzhdj() {
        return bzhdj;
    }

    public void setBzhdj(String bzhdj) {
        this.bzhdj = bzhdj;
    }

    public String getAqjgdj() {
        return aqjgdj;
    }

    public void setAqjgdj(String aqjgdj) {
        this.aqjgdj = aqjgdj;
    }

    public String getJgfl() {
        return jgfl;
    }

    public void setJgfl(String jgfl) {
        this.jgfl = jgfl;
    }

    public String getSdajjg() {
        return sdajjg;
    }

    public void setSdajjg(String sdajjg) {
        this.sdajjg = sdajjg;
    }

    public String getSfyzzaqjg() {
        return sfyzzaqjg;
    }

    public void setSfyzzaqjg(String sfyzzaqjg) {
        this.sfyzzaqjg = sfyzzaqjg;
    }

    public String getSfyzzaqry() {
        return sfyzzaqry;
    }

    public void setSfyzzaqry(String sfyzzaqry) {
        this.sfyzzaqry = sfyzzaqry;
    }

    public String getSfczzdwxy() {
        return sfczzdwxy;
    }

    public void setSfczzdwxy(String sfczzdwxy) {
        this.sfczzdwxy = sfczzdwxy;
    }

    public String getSfczzybwhys() {
        return sfczzybwhys;
    }

    public void setSfczzybwhys(String sfczzybwhys) {
        this.sfczzybwhys = sfczzybwhys;
    }

    public String getSfsyccwhp() {
        return sfsyccwhp;
    }

    public void setSfsyccwhp(String sfsyccwhp) {
        this.sfsyccwhp = sfsyccwhp;
    }

    public String getQypmt() {
        return qypmt;
    }

    public void setQypmt(String qypmt) {
        this.qypmt = qypmt;
    }

    public String getYhpczlzd() {
        return yhpczlzd;
    }

    public void setYhpczlzd(String yhpczlzd) {
        this.yhpczlzd = yhpczlzd;
    }

    public String getYhpczljh() {
        return yhpczljh;
    }

    public void setYhpczljh(String yhpczljh) {
        this.yhpczljh = yhpczljh;
    }

    public String getQywzjd() {
        return qywzjd;
    }

    public void setQywzjd(String qywzjd) {
        this.qywzjd = qywzjd;
    }

    public String getQywzwd() {
        return qywzwd;
    }

    public void setQywzwd(String qywzwd) {
        this.qywzwd = qywzwd;
    }

    public String getZxzllx() {
        return zxzllx;
    }

    public void setZxzllx(String zxzllx) {
        this.zxzllx = zxzllx;
    }



    public String getZxjghya() {
        return zxjghya;
    }

    public void setZxjghya(String zxjghya) {
        this.zxjghya = zxjghya;
    }

    public String getZxjghyb() {
        return zxjghyb;
    }

    public void setZxjghyb(String zxjghyb) {
        this.zxjghyb = zxjghyb;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCzhm() {
        return czhm;
    }

    public void setCzhm(String czhm) {
        this.czhm = czhm;
    }

    public String getXzqhs() {
        return xzqhs;
    }

    public void setXzqhs(String xzqhs) {
        this.xzqhs = xzqhs;
    }

    public String getXzqhqx() {
        return xzqhqx;
    }

    public void setXzqhqx(String xzqhqx) {
        this.xzqhqx = xzqhqx;
    }

    public String getXzqhjd() {
        return xzqhjd;
    }

    public void setXzqhjd(String xzqhjd) {
        this.xzqhjd = xzqhjd;
    }

    public String getXzqhsq() {
        return xzqhsq;
    }

    public void setXzqhsq(String xzqhsq) {
        this.xzqhsq = xzqhsq;
    }

    public String getZxzllb() {
        return zxzllb;
    }

    public void setZxzllb(String zxzllb) {
        this.zxzllb = zxzllb;
    }

    public String getFljg() {
        return fljg;
    }

    public void setFljg(String fljg) {
        this.fljg = fljg;
    }

    public String getFddbrgddh() {
        return fddbrgddh;
    }

    public void setFddbrgddh(String fddbrgddh) {
        this.fddbrgddh = fddbrgddh;
    }

    public String getFddbrsj() {
        return fddbrsj;
    }

    public void setFddbrsj(String fddbrsj) {
        this.fddbrsj = fddbrsj;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getShowDept() {
        return showDept;
    }

    public void setShowDept(String showDept) {
        this.showDept = showDept;
    }

    public String getSfylsjt() {
        return sfylsjt;
    }

    public void setSfylsjt(String sfylsjt) {
        this.sfylsjt = sfylsjt;
    }

    public String getLsjtmc() {
        return lsjtmc;
    }

    public void setLsjtmc(String lsjtmc) {
        this.lsjtmc = lsjtmc;
    }

    public String getClique() {
        return clique;
    }

    public void setClique(String clique) {
        this.clique = clique;
    }

    public String getHylbxl() {
        return hylbxl;
    }

    public void setHylbxl(String hylbxl) {
        this.hylbxl = hylbxl;
    }

    public String getJjlxxl() {
        return jjlxxl;
    }

    public void setJjlxxl(String jjlxxl) {
        this.jjlxxl = jjlxxl;
    }

    public String getJghydl() {
        return jghydl;
    }

    public void setJghydl(String jghydl) {
        this.jghydl = jghydl;
    }

    public String getJghyxl() {
        return jghyxl;
    }

    public void setJghyxl(String jghyxl) {
        this.jghyxl = jghyxl;
    }


}
