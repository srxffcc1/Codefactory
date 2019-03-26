package com.wisdomregulation.utils;

import com.ay.ydzf.zhifawenshu.pojokm.*;
import com.wisdomregulation.data.entitybase.DateBase_Entity;
import com.wisdomregulation.staticlib.Static_BookLib;

public class ConvertPrintkm implements IConvertPrintkm{


    @Override
    public Object bookentity2webobject(Object bookentity) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object wenshuobject=null;

        DateBase_Entity orgentity= (DateBase_Entity) bookentity;
        int index=Integer.parseInt(bookentity.getClass().getSimpleName().replace("Entity_Book",""));
        String wenshuobjectstring= Static_BookLib.WEBBOOKNAME[index];
        wenshuobject=Class.forName("com.ay.ydzf.zhifawenshu.pojokm." + wenshuobjectstring).newInstance();
        if (wenshuobjectstring.equals("WsAjsy")) {
            ((WsAjsy) wenshuobject).glj = orgentity.push();
            ((WsAjsy) wenshuobject).pcode = orgentity.push();
            ((WsAjsy) wenshuobject).ycode = orgentity.push();
            ((WsAjsy) wenshuobject).ncode = orgentity.push();
            ((WsAjsy) wenshuobject).ajmc = orgentity.push();
            ((WsAjsy) wenshuobject).ay = orgentity.push();
            ((WsAjsy) wenshuobject).cljg = orgentity.push();
            ((WsAjsy) wenshuobject).larq = orgentity.push();
            ((WsAjsy) wenshuobject).jarq = orgentity.push();
            ((WsAjsy) wenshuobject).cbrqm_one = orgentity.push();
            ((WsAjsy) wenshuobject).cbrqm_two = orgentity.push();
            ((WsAjsy) wenshuobject).gdrq = orgentity.push();
            ((WsAjsy) wenshuobject).gdh = orgentity.push();
            ((WsAjsy) wenshuobject).bcqx = orgentity.push();
            ((WsAjsy) wenshuobject).rq = orgentity.push();
            ((WsAjsy) wenshuobject).version = orgentity.push();
            ((WsAjsy) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsAjclcp-------("案件处理呈批表")
        else if(wenshuobjectstring.equals("WsAjclcp")){
            //("地方")
            ((WsAjclcp) wenshuobject).pcode= orgentity.push();
            //("字")
            ((WsAjclcp) wenshuobject).ycode= orgentity.push();
            //("号")
            ((WsAjclcp) wenshuobject).ncode= orgentity.push();
            //("案件名称")
            ((WsAjclcp) wenshuobject).ajmc= orgentity.push();
            //("被处罚单位")
            ((WsAjclcp) wenshuobject).bcfdw= orgentity.push();
            //("地址")
            ((WsAjclcp) wenshuobject).dz= orgentity.push();
            //("法定代表人")
            ((WsAjclcp) wenshuobject).fddbr= orgentity.push();
            //("职务")
            ((WsAjclcp) wenshuobject).zw= orgentity.push();
            //("单位邮编")
            ((WsAjclcp) wenshuobject).dwyb= orgentity.push();
            //("被处罚人")
            ((WsAjclcp) wenshuobject).bcfr= orgentity.push();
            //("年龄")
            ((WsAjclcp) wenshuobject).nl= orgentity.push();
            //("性别")
            ((WsAjclcp) wenshuobject).xb= orgentity.push();
            //("所在单位")
            ((WsAjclcp) wenshuobject).szdw= orgentity.push();
            //("单位地址")
            ((WsAjclcp) wenshuobject).dwdz= orgentity.push();
            //("家庭住址")
            ((WsAjclcp) wenshuobject).jtzz= orgentity.push();
            //("联系电话")
            ((WsAjclcp) wenshuobject).lxdh= orgentity.push();
            //("家庭邮编")
            ((WsAjclcp) wenshuobject).jtyb= orgentity.push();
            //("违法事实及处罚依据")
            ((WsAjclcp) wenshuobject).wfss= orgentity.push();
            //("当事人申辩意见")
            ((WsAjclcp) wenshuobject).dsrsbyj= orgentity.push();
            //("承办人意见")
            ((WsAjclcp) wenshuobject).cbryj= orgentity.push();
            //("承办人签名1")
            ((WsAjclcp) wenshuobject).cbrqmy= orgentity.push();
            //("承办人签名2")
            ((WsAjclcp) wenshuobject).cbrqme= orgentity.push();
            //("承办人签名时间")
            ((WsAjclcp) wenshuobject).cbrqmsj= orgentity.push();
            //("审核意见")
            ((WsAjclcp) wenshuobject).shyj= orgentity.push();
            //("审核人签名")
            ((WsAjclcp) wenshuobject).shrqm= orgentity.push();
            //("审核时间")
            ((WsAjclcp) wenshuobject).shsj= orgentity.push();
            //("审批意见")
            ((WsAjclcp) wenshuobject).spyj= orgentity.push();
            //("审批人签名")
            ((WsAjclcp) wenshuobject).sprqm= orgentity.push();
            //("审批时间")
            ((WsAjclcp) wenshuobject).spsj= orgentity.push();
        }
        //-------WsAjyss-------
        else if (wenshuobjectstring.equals("WsAjyss")) {
            ((WsAjyss) wenshuobject).pcode = orgentity.push();
            ((WsAjyss) wenshuobject).ycode = orgentity.push();
            ((WsAjyss) wenshuobject).ncode = orgentity.push();
            ((WsAjyss) wenshuobject).ysdw = orgentity.push();
            ((WsAjyss) wenshuobject).larq = orgentity.push();
            ((WsAjyss) wenshuobject).aj = orgentity.push();
            ((WsAjyss) wenshuobject).fx = orgentity.push();
            ((WsAjyss) wenshuobject).gd = orgentity.push();
            ((WsAjyss) wenshuobject).cl = orgentity.push();
            ((WsAjyss) wenshuobject).jf = orgentity.push();
            ((WsAjyss) wenshuobject).jy = orgentity.push();
            ((WsAjyss) wenshuobject).rq = orgentity.push();
            ((WsAjyss) wenshuobject).version = orgentity.push();
            ((WsAjyss) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsAjysspb-------
        else if (wenshuobjectstring.equals("WsAjysspb")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsAjysspb) wenshuobject).ajmc = orgentity.push();
            ((WsAjysspb) wenshuobject).dsr = orgentity.push();
            ((WsAjysspb) wenshuobject).dz = orgentity.push();
            ((WsAjysspb) wenshuobject).sysjg = orgentity.push();
            ((WsAjysspb) wenshuobject).aqjj = orgentity.push();
            ((WsAjysspb) wenshuobject).ysly = orgentity.push();
            ((WsAjysspb) wenshuobject).cbryj = orgentity.push();
            ((WsAjysspb) wenshuobject).cbrqm_one = orgentity.push();
            ((WsAjysspb) wenshuobject).cbrqm_two = orgentity.push();
            ((WsAjysspb) wenshuobject).cbrqmrq = orgentity.push();
            ((WsAjysspb) wenshuobject).shyj = orgentity.push();
            ((WsAjysspb) wenshuobject).shrqm = orgentity.push();
            ((WsAjysspb) wenshuobject).shrqmrq = orgentity.push();
            ((WsAjysspb) wenshuobject).spyj = orgentity.push();
            ((WsAjysspb) wenshuobject).sprqm = orgentity.push();
            ((WsAjysspb) wenshuobject).sprqmrq = orgentity.push();
            ((WsAjysspb) wenshuobject).version = orgentity.push();
            ((WsAjysspb) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsDsrcssbbl-------
        else if (wenshuobjectstring.equals("WsDsrcssbbl")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sjc = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sjm = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).dd = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).cssbr = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sbrxb = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sbrzw = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sbrdw = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sbrdh = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sbrlxdz = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).sbryb = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).cbr = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).jlr = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).glj = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).zfryOne = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).zfryTwo = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).zfryzhOne = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).zfryzhTwo = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).aj = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).cssbjl = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).cssbrqm = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).cbrqm = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).jlrqm = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).rq = orgentity.push();
            ((WsDsrcssbbl) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsFkcjtzs-------
        else if (wenshuobjectstring.equals("WsFkcjtzs")) {
            ((WsFkcjtzs) wenshuobject).pcode = orgentity.push();
            ((WsFkcjtzs) wenshuobject).ycode = orgentity.push();
            ((WsFkcjtzs) wenshuobject).ncode = orgentity.push();
            ((WsFkcjtzs) wenshuobject).fkdw = orgentity.push();
            ((WsFkcjtzs) wenshuobject).fkrq = orgentity.push();
            ((WsFkcjtzs) wenshuobject).fkh = orgentity.push();
            ((WsFkcjtzs) wenshuobject).jkrq = orgentity.push();
            ((WsFkcjtzs) wenshuobject).jkc = orgentity.push();
            ((WsFkcjtzs) wenshuobject).rq = orgentity.push();
            ((WsFkcjtzs) wenshuobject).version = orgentity.push();
            ((WsFkcjtzs) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsJaspb-------
        else if (wenshuobjectstring.equals("WsJaspb")) {
            ((WsJaspb) wenshuobject).pcode = orgentity.push();
            ((WsJaspb) wenshuobject).ycode = orgentity.push();
            ((WsJaspb) wenshuobject).ncode = orgentity.push();
            ((WsJaspb) wenshuobject).ajmc = orgentity.push();
            ((WsJaspb) wenshuobject).bcfdw = orgentity.push();
            ((WsJaspb) wenshuobject).bcfdwdz = orgentity.push();
            ((WsJaspb) wenshuobject).fddbr = orgentity.push();
            ((WsJaspb) wenshuobject).fddbrzw = orgentity.push();
            ((WsJaspb) wenshuobject).fddbryb = orgentity.push();
            ((WsJaspb) wenshuobject).bcfr = orgentity.push();
            ((WsJaspb) wenshuobject).bcfrnl = orgentity.push();
            ((WsJaspb) wenshuobject).bcfrxb = orgentity.push();
            ((WsJaspb) wenshuobject).bcfrdw = orgentity.push();
            ((WsJaspb) wenshuobject).bcfrdwzz = orgentity.push();
            ((WsJaspb) wenshuobject).bcfrjtzz = orgentity.push();
            ((WsJaspb) wenshuobject).bcfrlxdh = orgentity.push();
            ((WsJaspb) wenshuobject).bcfryb = orgentity.push();
            ((WsJaspb) wenshuobject).cljg = orgentity.push();
            ((WsJaspb) wenshuobject).zxqk = orgentity.push();
            ((WsJaspb) wenshuobject).cbrqm_one = orgentity.push();
            ((WsJaspb) wenshuobject).cbrqm_two = orgentity.push();
            ((WsJaspb) wenshuobject).cbrqmrq = orgentity.push();
            ((WsJaspb) wenshuobject).shyj = orgentity.push();
            ((WsJaspb) wenshuobject).shrqm = orgentity.push();
            ((WsJaspb) wenshuobject).shrqmrq = orgentity.push();
            ((WsJaspb) wenshuobject).spyj = orgentity.push();
            ((WsJaspb) wenshuobject).sprqm = orgentity.push();
            ((WsJaspb) wenshuobject).sprqmrq = orgentity.push();
            ((WsJaspb) wenshuobject).version = orgentity.push();
            ((WsJaspb) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsKybl-------
        else if (wenshuobjectstring.equals("WsKybl")) {
            ((WsKybl) wenshuobject).pcode = orgentity.push();
            ((WsKybl) wenshuobject).ycode = orgentity.push();
            ((WsKybl) wenshuobject).ncode = orgentity.push();
            ((WsKybl) wenshuobject).kysjc = orgentity.push();
            ((WsKybl) wenshuobject).kysjm = orgentity.push();
            ((WsKybl) wenshuobject).kycs = orgentity.push();
            ((WsKybl) wenshuobject).tqqk = orgentity.push();
            ((WsKybl) wenshuobject).kyrOne = orgentity.push();
            ((WsKybl) wenshuobject).kyrzwOne = orgentity.push();
            ((WsKybl) wenshuobject).kyrTwo = orgentity.push();
            ((WsKybl) wenshuobject).kyrzwTwo = orgentity.push();
            ((WsKybl) wenshuobject).dsrOne = orgentity.push();
            ((WsKybl) wenshuobject).dsrzwOne = orgentity.push();
            ((WsKybl) wenshuobject).dsrTwo = orgentity.push();
            ((WsKybl) wenshuobject).dsrzwTwo = orgentity.push();
            ((WsKybl) wenshuobject).byqr = orgentity.push();
            ((WsKybl) wenshuobject).byqrzw = orgentity.push();
            ((WsKybl) wenshuobject).jlr = orgentity.push();
            ((WsKybl) wenshuobject).jlrzw = orgentity.push();
            ((WsKybl) wenshuobject).glj = orgentity.push();
            ((WsKybl) wenshuobject).zfryOne = orgentity.push();
            ((WsKybl) wenshuobject).zfryTwo = orgentity.push();
            ((WsKybl) wenshuobject).zhOne = orgentity.push();
            ((WsKybl) wenshuobject).zhTwo = orgentity.push();
            ((WsKybl) wenshuobject).kyqk = orgentity.push();
            ((WsKybl) wenshuobject).kyrqmOne = orgentity.push();
            ((WsKybl) wenshuobject).kyrqmTwo = orgentity.push();
            ((WsKybl) wenshuobject).dsrqmOne = orgentity.push();
            ((WsKybl) wenshuobject).dsrlxdhOne = orgentity.push();
            ((WsKybl) wenshuobject).dsrqmTwo = orgentity.push();
            ((WsKybl) wenshuobject).dsrlxdhTwo = orgentity.push();
            ((WsKybl) wenshuobject).byqrqm = orgentity.push();
            ((WsKybl) wenshuobject).byqrlxdh = orgentity.push();
            ((WsKybl) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsLasp-------
        else if (wenshuobjectstring.equals("WsLasp")) {
            ((WsLasp) wenshuobject).pcode = orgentity.push();
            ((WsLasp) wenshuobject).ycode = orgentity.push();
            ((WsLasp) wenshuobject).ncode = orgentity.push();
            ((WsLasp) wenshuobject).ay = orgentity.push();
            ((WsLasp) wenshuobject).ajly = orgentity.push();
            ((WsLasp) wenshuobject).sj = orgentity.push();
            ((WsLasp) wenshuobject).ajmc = orgentity.push();
            ((WsLasp) wenshuobject).dsr = orgentity.push();
            ((WsLasp) wenshuobject).dh = orgentity.push();
            ((WsLasp) wenshuobject).dsrqk = orgentity.push();
            ((WsLasp) wenshuobject).dsrdz = orgentity.push();
            ((WsLasp) wenshuobject).yzbm = orgentity.push();
            ((WsLasp) wenshuobject).ajqk = orgentity.push();
            ((WsLasp) wenshuobject).cbryj = orgentity.push();
            ((WsLasp) wenshuobject).cbrqzy = orgentity.push();
            ((WsLasp) wenshuobject).zhy = orgentity.push();
            ((WsLasp) wenshuobject).cbrqze = orgentity.push();
            ((WsLasp) wenshuobject).zhe = orgentity.push();
            ((WsLasp) wenshuobject).cbsj = orgentity.push();
            ((WsLasp) wenshuobject).shyj = orgentity.push();
            ((WsLasp) wenshuobject).shre = orgentity.push();
            ((WsLasp) wenshuobject).shsj = orgentity.push();
            ((WsLasp) wenshuobject).spyj = orgentity.push();
            ((WsLasp) wenshuobject).spr = orgentity.push();
            ((WsLasp) wenshuobject).spsj = orgentity.push();
            ((WsLasp) wenshuobject).version = orgentity.push();
            ((WsLasp) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsQzcs-------
        else if (wenshuobjectstring.equals("WsQzcs")) {
            ((WsQzcs) wenshuobject).pcode = orgentity.push();
            ((WsQzcs) wenshuobject).ycode = orgentity.push();
            ((WsQzcs) wenshuobject).ncode = orgentity.push();
            ((WsQzcs) wenshuobject).bjcdw = orgentity.push();
            ((WsQzcs) wenshuobject).wt = orgentity.push();
            ((WsQzcs) wenshuobject).yj = orgentity.push();
            ((WsQzcs) wenshuobject).qzcs = orgentity.push();
            ((WsQzcs) wenshuobject).rmzf = orgentity.push();
            ((WsQzcs) wenshuobject).sqdw = orgentity.push();
            ((WsQzcs) wenshuobject).rmfy = orgentity.push();
            ((WsQzcs) wenshuobject).sj = orgentity.push();
            ((WsQzcs) wenshuobject).dfzh = orgentity.push();
            ((WsQzcs) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsQzzxsqs-------
        else if (wenshuobjectstring.equals("WsQzzxsqs")) {
            ((WsQzzxsqs) wenshuobject).pcode = orgentity.push();
            ((WsQzzxsqs) wenshuobject).ycode = orgentity.push();
            ((WsQzzxsqs) wenshuobject).ncode = orgentity.push();
            ((WsQzzxsqs) wenshuobject).rmfy = orgentity.push();
            ((WsQzzxsqs) wenshuobject).cfrq = orgentity.push();
            ((WsQzzxsqs) wenshuobject).sqzxr = orgentity.push();
            ((WsQzzxsqs) wenshuobject).cfjd = orgentity.push();
            ((WsQzzxsqs) wenshuobject).wh = orgentity.push();
            ((WsQzzxsqs) wenshuobject).ygcl = orgentity.push();
            ((WsQzzxsqs) wenshuobject).rq = orgentity.push();
            ((WsQzzxsqs) wenshuobject).lxr = orgentity.push();
            ((WsQzzxsqs) wenshuobject).lxdh = orgentity.push();
            ((WsQzzxsqs) wenshuobject).version = orgentity.push();
            ((WsQzzxsqs) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsTzbl-------
        else if (wenshuobjectstring.equals("WsTzbl")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsTzbl) wenshuobject).ajmc = orgentity.push();
            ((WsTzbl) wenshuobject).zctzjg = orgentity.push();
            ((WsTzbl) wenshuobject).dd = orgentity.push();
            ((WsTzbl) wenshuobject).tzsjc = orgentity.push();
            ((WsTzbl) wenshuobject).tzsjm = orgentity.push();
            ((WsTzbl) wenshuobject).tzzcr = orgentity.push();
            ((WsTzbl) wenshuobject).tzy = orgentity.push();
            ((WsTzbl) wenshuobject).sjy = orgentity.push();
            ((WsTzbl) wenshuobject).dcryOne = orgentity.push();
            ((WsTzbl) wenshuobject).dcryzhOne = orgentity.push();
            ((WsTzbl) wenshuobject).dcryTwo = orgentity.push();
            ((WsTzbl) wenshuobject).dcryzhTwo = orgentity.push();
            ((WsTzbl) wenshuobject).fddbrxm = orgentity.push();
            ((WsTzbl) wenshuobject).fddbrxb = orgentity.push();
            ((WsTzbl) wenshuobject).fddbrnl = orgentity.push();
            ((WsTzbl) wenshuobject).gzdwzw = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrOne = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrxbOne = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrnlOne = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrdwOne = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrTwo = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrxbTwo = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrnlTwo = orgentity.push();
            ((WsTzbl) wenshuobject).wtdlrdwTwo = orgentity.push();
            ((WsTzbl) wenshuobject).dsr = orgentity.push();
            ((WsTzbl) wenshuobject).qtcyry = orgentity.push();
            ((WsTzbl) wenshuobject).tzjl = orgentity.push();
            ((WsTzbl) wenshuobject).dbrqm = orgentity.push();
            ((WsTzbl) wenshuobject).zcrqm = orgentity.push();
            ((WsTzbl) wenshuobject).sjyqm = orgentity.push();
            ((WsTzbl) wenshuobject).rq = orgentity.push();
            ((WsTzbl) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsTzgzs-------
        else if (wenshuobjectstring.equals("WsTzgzs")) {
            ((WsTzgzs) wenshuobject).pcode = orgentity.push();
            ((WsTzgzs) wenshuobject).ycode = orgentity.push();
            ((WsTzgzs) wenshuobject).ncode = orgentity.push();
            ((WsTzgzs) wenshuobject).cfdw = orgentity.push();
            ((WsTzgzs) wenshuobject).wfxw = orgentity.push();
            ((WsTzgzs) wenshuobject).gd = orgentity.push();
            ((WsTzgzs) wenshuobject).yj = orgentity.push();
            ((WsTzgzs) wenshuobject).xzcf = orgentity.push();
            ((WsTzgzs) wenshuobject).glbm = orgentity.push();
            ((WsTzgzs) wenshuobject).bmdz = orgentity.push();
            ((WsTzgzs) wenshuobject).bmlxr = orgentity.push();
            ((WsTzgzs) wenshuobject).bmlxdh = orgentity.push();
            ((WsTzgzs) wenshuobject).bmyb = orgentity.push();
            ((WsTzgzs) wenshuobject).rq = orgentity.push();
            ((WsTzgzs) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsTzhbg-------
        else if (wenshuobjectstring.equals("WsTzhbg")) {
            ((WsTzhbg) wenshuobject).pcode = orgentity.push();
            ((WsTzhbg) wenshuobject).ycode = orgentity.push();
            ((WsTzhbg) wenshuobject).ncode = orgentity.push();
            ((WsTzhbg) wenshuobject).ajmc = orgentity.push();
            ((WsTzhbg) wenshuobject).tzzcr = orgentity.push();
            ((WsTzhbg) wenshuobject).tzy = orgentity.push();
            ((WsTzhbg) wenshuobject).sjy = orgentity.push();
            ((WsTzhbg) wenshuobject).zy = orgentity.push();
            ((WsTzhbg) wenshuobject).tzzcryj = orgentity.push();
            ((WsTzhbg) wenshuobject).tzzcrqm = orgentity.push();
            ((WsTzhbg) wenshuobject).tzzcrqmrq = orgentity.push();
            ((WsTzhbg) wenshuobject).fzrshyj = orgentity.push();
            ((WsTzhbg) wenshuobject).fzrqm = orgentity.push();
            ((WsTzhbg) wenshuobject).fzrqmrq = orgentity.push();
            ((WsTzhbg) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsTzhtzs-------
        else if (wenshuobjectstring.equals("WsTzhtzs")) {
            ((WsTzhtzs) wenshuobject).pcode = orgentity.push();
            ((WsTzhtzs) wenshuobject).ycode = orgentity.push();
            ((WsTzhtzs) wenshuobject).ncode = orgentity.push();
            ((WsTzhtzs) wenshuobject).cfdw = orgentity.push();
            ((WsTzhtzs) wenshuobject).aj = orgentity.push();
            ((WsTzhtzs) wenshuobject).sj = orgentity.push();
            ((WsTzhtzs) wenshuobject).hydd = orgentity.push();
            ((WsTzhtzs) wenshuobject).zcrxm = orgentity.push();
            ((WsTzhtzs) wenshuobject).zcrzw = orgentity.push();
            ((WsTzhtzs) wenshuobject).tzyxmOne = orgentity.push();
            ((WsTzhtzs) wenshuobject).tzyzwOne = orgentity.push();
            ((WsTzhtzs) wenshuobject).tzyxmTwo = orgentity.push();
            ((WsTzhtzs) wenshuobject).tzyzwTwo = orgentity.push();
            ((WsTzhtzs) wenshuobject).sjyxm = orgentity.push();
            ((WsTzhtzs) wenshuobject).sjyzw = orgentity.push();
            ((WsTzhtzs) wenshuobject).rq = orgentity.push();
            ((WsTzhtzs) wenshuobject).bmdz = orgentity.push();
            ((WsTzhtzs) wenshuobject).bmlxr = orgentity.push();
            ((WsTzhtzs) wenshuobject).bmlxdh = orgentity.push();
            ((WsTzhtzs) wenshuobject).bmyb = orgentity.push();

        }
        //-------WsXcclcs-------
        else if (wenshuobjectstring.equals("WsXcclcs")) {
            ((WsXcclcs) wenshuobject).pcode = orgentity.push();
            ((WsXcclcs) wenshuobject).ycode = orgentity.push();
            ((WsXcclcs) wenshuobject).ncode = orgentity.push();
            ((WsXcclcs) wenshuobject).bjcdw = orgentity.push();
            ((WsXcclcs) wenshuobject).jcrq = orgentity.push();
            ((WsXcclcs) wenshuobject).sgyhOne = orgentity.push();
            ((WsXcclcs) wenshuobject).sgyhTwo = orgentity.push();
            ((WsXcclcs) wenshuobject).sgyhThree = orgentity.push();
            ((WsXcclcs) wenshuobject).yj = orgentity.push();
            ((WsXcclcs) wenshuobject).jdOne = orgentity.push();
            ((WsXcclcs) wenshuobject).jdTwo = orgentity.push();
            ((WsXcclcs) wenshuobject).jdThree = orgentity.push();
            ((WsXcclcs) wenshuobject).rmzf = orgentity.push();
            ((WsXcclcs) wenshuobject).sqdw = orgentity.push();
            ((WsXcclcs) wenshuobject).rmfy = orgentity.push();
            ((WsXcclcs) wenshuobject).zfryqmOne = orgentity.push();
            ((WsXcclcs) wenshuobject).zfryqmTwo = orgentity.push();
            ((WsXcclcs) wenshuobject).zhOne = orgentity.push();
            ((WsXcclcs) wenshuobject).zhTwo = orgentity.push();
            ((WsXcclcs) wenshuobject).fzrqm = orgentity.push();
            ((WsXcclcs) wenshuobject).sj = orgentity.push();
            ((WsXcclcs) wenshuobject).dfzh = orgentity.push();
            ((WsXcclcs) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXcjc-------
        else if (wenshuobjectstring.equals("WsXcjc")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsXcjc) wenshuobject).bjcdw = orgentity.push();
            ((WsXcjc) wenshuobject).dz = orgentity.push();
            ((WsXcjc) wenshuobject).fzr = orgentity.push();
            ((WsXcjc) wenshuobject).zw = orgentity.push();
            ((WsXcjc) wenshuobject).lxdh = orgentity.push();
            ((WsXcjc) wenshuobject).jccs = orgentity.push();
            ((WsXcjc) wenshuobject).jcsjc = orgentity.push();
            ((WsXcjc) wenshuobject).jcsjm = orgentity.push();
            ((WsXcjc) wenshuobject).glj = orgentity.push();
            ((WsXcjc) wenshuobject).zfryy = orgentity.push();
            ((WsXcjc) wenshuobject).zfrye = orgentity.push();
            ((WsXcjc) wenshuobject).zjhmy = orgentity.push();
            ((WsXcjc) wenshuobject).zjhme = orgentity.push();
            ((WsXcjc) wenshuobject).jcqk = orgentity.push();
            ((WsXcjc) wenshuobject).jcryqmy = orgentity.push();
            ((WsXcjc) wenshuobject).jcryqme = orgentity.push();
            ((WsXcjc) wenshuobject).bjcfzr = orgentity.push();
            ((WsXcjc) wenshuobject).sj = orgentity.push();
            ((WsXcjc) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXwbl-------
        else if (wenshuobjectstring.equals("WsXwbl")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsXwbl) wenshuobject).xwsjc = orgentity.push();
            ((WsXwbl) wenshuobject).xwsjm = orgentity.push();
            ((WsXwbl) wenshuobject).xwcs = orgentity.push();
            ((WsXwbl) wenshuobject).xwdd = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrxm = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrxb = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrnl = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrzjh = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrdw = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrzw = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrzz = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrdh = orgentity.push();
            ((WsXwbl) wenshuobject).xwr = orgentity.push();
            ((WsXwbl) wenshuobject).xwrdwzw = orgentity.push();
            ((WsXwbl) wenshuobject).jlr = orgentity.push();
            ((WsXwbl) wenshuobject).jlrdwzw = orgentity.push();
            ((WsXwbl) wenshuobject).zcr = orgentity.push();
            ((WsXwbl) wenshuobject).glj = orgentity.push();
            ((WsXwbl) wenshuobject).zfryOne = orgentity.push();
            ((WsXwbl) wenshuobject).zfryTwo = orgentity.push();
            ((WsXwbl) wenshuobject).zhOne = orgentity.push();
            ((WsXwbl) wenshuobject).zhTwo = orgentity.push();
            ((WsXwbl) wenshuobject).wt = orgentity.push();
            ((WsXwbl) wenshuobject).xwjl = orgentity.push();
            ((WsXwbl) wenshuobject).xwrqm = orgentity.push();
            ((WsXwbl) wenshuobject).jlrqm = orgentity.push();
            ((WsXwbl) wenshuobject).bxwrqm = orgentity.push();
            ((WsXwbl) wenshuobject).rq = orgentity.push();
            ((WsXwbl) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXwtz-------
        else if (wenshuobjectstring.equals("WsXwtz")) {
            ((WsXwtz) wenshuobject).pcode = orgentity.push();
            ((WsXwtz) wenshuobject).ycode = orgentity.push();
            ((WsXwtz) wenshuobject).ncode = orgentity.push();
            ((WsXwtz) wenshuobject).bjcr = orgentity.push();
            ((WsXwtz) wenshuobject).yy = orgentity.push();
            ((WsXwtz) wenshuobject).xwsj = orgentity.push();
            ((WsXwtz) wenshuobject).xwdd = orgentity.push();
            ((WsXwtz) wenshuobject).cllb = orgentity.push();
            ((WsXwtz) wenshuobject).zdycl = orgentity.push();
            ((WsXwtz) wenshuobject).glbmdz = orgentity.push();
            ((WsXwtz) wenshuobject).lxr = orgentity.push();
            ((WsXwtz) wenshuobject).lxdh = orgentity.push();
            ((WsXwtz) wenshuobject).sj = orgentity.push();
            ((WsXwtz) wenshuobject).version = orgentity.push();
            ((WsXwtz) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXxdjbc-------
        else if (wenshuobjectstring.equals("WsXxdjbc")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsXxdjbc) wenshuobject).ajmc = orgentity.push();
            ((WsXxdjbc) wenshuobject).dsrjbqk = orgentity.push();
            ((WsXxdjbc) wenshuobject).ajjbqk = orgentity.push();
            ((WsXxdjbc) wenshuobject).zjmcjsl = orgentity.push();
            ((WsXxdjbc) wenshuobject).tqlyjyj = orgentity.push();
            ((WsXxdjbc) wenshuobject).bcfs = orgentity.push();
            ((WsXxdjbc) wenshuobject).cbryj = orgentity.push();
            ((WsXxdjbc) wenshuobject).cbrqm = orgentity.push();
            ((WsXxdjbc) wenshuobject).cbrsj = orgentity.push();
            ((WsXxdjbc) wenshuobject).bmfzryj = orgentity.push();
            ((WsXxdjbc) wenshuobject).bmfzrqm = orgentity.push();
            ((WsXxdjbc) wenshuobject).bmfzrsj = orgentity.push();
            ((WsXxdjbc) wenshuobject).jgfzryj = orgentity.push();
            ((WsXxdjbc) wenshuobject).jgfzrqm = orgentity.push();
            ((WsXxdjbc) wenshuobject).jgfzrsj = orgentity.push();
            ((WsXxdjbc) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXxdjcljds-------
        else if (wenshuobjectstring.equals("WsXxdjcljds")) {
            ((WsXxdjcljds) wenshuobject).pcode = orgentity.push();
            ((WsXxdjcljds) wenshuobject).ycode = orgentity.push();
            ((WsXxdjcljds) wenshuobject).ncode = orgentity.push();
            ((WsXxdjcljds) wenshuobject).bdjdw = orgentity.push();
            ((WsXxdjcljds) wenshuobject).djrq = orgentity.push();
            ((WsXxdjcljds) wenshuobject).djwp = orgentity.push();
            ((WsXxdjcljds) wenshuobject).jpcode = orgentity.push();
            ((WsXxdjcljds) wenshuobject).jycode = orgentity.push();
            ((WsXxdjcljds) wenshuobject).jncode = orgentity.push();
            ((WsXxdjcljds) wenshuobject).cl = orgentity.push();
            ((WsXxdjcljds) wenshuobject).rmzf = orgentity.push();
            ((WsXxdjcljds) wenshuobject).sqdw = orgentity.push();
            ((WsXxdjcljds) wenshuobject).rmfy = orgentity.push();
            ((WsXxdjcljds) wenshuobject).rq = orgentity.push();
            ((WsXxdjcljds) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXxdjclspb-------
        else if (wenshuobjectstring.equals("WsXxdjclspb")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsXxdjclspb) wenshuobject).ajmc = orgentity.push();
            ((WsXxdjclspb) wenshuobject).dsrqk = orgentity.push();
            ((WsXxdjclspb) wenshuobject).ajjbqk = orgentity.push();
            ((WsXxdjclspb) wenshuobject).zjmcsl = orgentity.push();
            ((WsXxdjclspb) wenshuobject).tqlyyj = orgentity.push();
            ((WsXxdjclspb) wenshuobject).cbryj = orgentity.push();
            ((WsXxdjclspb) wenshuobject).cbrqm = orgentity.push();
            ((WsXxdjclspb) wenshuobject).cbrqmrq = orgentity.push();
            ((WsXxdjclspb) wenshuobject).bmfzryj = orgentity.push();
            ((WsXxdjclspb) wenshuobject).bmfzrqm = orgentity.push();
            ((WsXxdjclspb) wenshuobject).bmfzrqmrq = orgentity.push();
            ((WsXxdjclspb) wenshuobject).jgfzryj = orgentity.push();
            ((WsXxdjclspb) wenshuobject).jgfzrqm = orgentity.push();
            ((WsXxdjclspb) wenshuobject).jgfzrqmrq = orgentity.push();
            ((WsXxdjclspb) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXxdjtzs-------
        else if (wenshuobjectstring.equals("WsXxdjtzs")) {
            ((WsXxdjtzs) wenshuobject).pcode = orgentity.push();
            ((WsXxdjtzs) wenshuobject).ycode = orgentity.push();
            ((WsXxdjtzs) wenshuobject).ncode = orgentity.push();
            ((WsXxdjtzs) wenshuobject).bcfdw = orgentity.push();
            ((WsXxdjtzs) wenshuobject).wfxw = orgentity.push();
            ((WsXxdjtzs) wenshuobject).jdrq = orgentity.push();
            ((WsXxdjtzs) wenshuobject).djc = orgentity.push();
            ((WsXxdjtzs) wenshuobject).fzrqm = orgentity.push();
            ((WsXxdjtzs) wenshuobject).rq = orgentity.push();
        }
        //-------WsXzcfdw-------
        else if (wenshuobjectstring.equals("WsXzcfdw")) {
            ((WsXzcfdw) wenshuobject).pcode = orgentity.push();
            ((WsXzcfdw) wenshuobject).ycode = orgentity.push();
            ((WsXzcfdw) wenshuobject).ncode = orgentity.push();
            ((WsXzcfdw) wenshuobject).bcfdw = orgentity.push();
            ((WsXzcfdw) wenshuobject).dz = orgentity.push();
            ((WsXzcfdw) wenshuobject).yb = orgentity.push();
            ((WsXzcfdw) wenshuobject).fddbr = orgentity.push();
            ((WsXzcfdw) wenshuobject).zw = orgentity.push();
            ((WsXzcfdw) wenshuobject).lxdh = orgentity.push();
            ((WsXzcfdw) wenshuobject).wfss = orgentity.push();
            ((WsXzcfdw) wenshuobject).wfgd = orgentity.push();
            ((WsXzcfdw) wenshuobject).yjgd = orgentity.push();
            ((WsXzcfdw) wenshuobject).xzcf = orgentity.push();
            ((WsXzcfdw) wenshuobject).fkfs = orgentity.push();
            ((WsXzcfdw) wenshuobject).jz = orgentity.push();
            ((WsXzcfdw) wenshuobject).zh = orgentity.push();
            ((WsXzcfdw) wenshuobject).zf = orgentity.push();
            ((WsXzcfdw) wenshuobject).sqdw = orgentity.push();
            ((WsXzcfdw) wenshuobject).rmfy = orgentity.push();
            ((WsXzcfdw) wenshuobject).zfryy = orgentity.push();
            ((WsXzcfdw) wenshuobject).zfrye = orgentity.push();
            ((WsXzcfdw) wenshuobject).dsr = orgentity.push();
            ((WsXzcfdw) wenshuobject).sj = orgentity.push();
            ((WsXzcfdw) wenshuobject).version = orgentity.push();
            ((WsXzcfdw) wenshuobject).dfzh = orgentity.push();
            ((WsXzcfdw) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXzcfgr-------
        else if (wenshuobjectstring.equals("WsXzcfgr")) {
            ((WsXzcfgr) wenshuobject).pcode = orgentity.push();
            ((WsXzcfgr) wenshuobject).ycode = orgentity.push();
            ((WsXzcfgr) wenshuobject).ncode = orgentity.push();
            ((WsXzcfgr) wenshuobject).bcfr = orgentity.push();
            ((WsXzcfgr) wenshuobject).xb = orgentity.push();
            ((WsXzcfgr) wenshuobject).nl = orgentity.push();
            ((WsXzcfgr) wenshuobject).sfzh = orgentity.push();
            ((WsXzcfgr) wenshuobject).jtzz = orgentity.push();
            ((WsXzcfgr) wenshuobject).szdw = orgentity.push();
            ((WsXzcfgr) wenshuobject).zw = orgentity.push();
            ((WsXzcfgr) wenshuobject).dwdz = orgentity.push();
            ((WsXzcfgr) wenshuobject).lxdh = orgentity.push();
            ((WsXzcfgr) wenshuobject).wfss = orgentity.push();
            ((WsXzcfgr) wenshuobject).wfgd = orgentity.push();
            ((WsXzcfgr) wenshuobject).yjgd = orgentity.push();
            ((WsXzcfgr) wenshuobject).xzcf = orgentity.push();
            ((WsXzcfgr) wenshuobject).fkfs = orgentity.push();
            ((WsXzcfgr) wenshuobject).jz = orgentity.push();
            ((WsXzcfgr) wenshuobject).zh = orgentity.push();
            ((WsXzcfgr) wenshuobject).zf = orgentity.push();
            ((WsXzcfgr) wenshuobject).sqdw = orgentity.push();
            ((WsXzcfgr) wenshuobject).rmfy = orgentity.push();
            ((WsXzcfgr) wenshuobject).zfryy = orgentity.push();
            ((WsXzcfgr) wenshuobject).zfrye = orgentity.push();
            ((WsXzcfgr) wenshuobject).dsr = orgentity.push();
            ((WsXzcfgr) wenshuobject).sj = orgentity.push();
            ((WsXzcfgr) wenshuobject).version = orgentity.push();
            ((WsXzcfgr) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXzcfgzs-------
        else if (wenshuobjectstring.equals("WsXzcfgzs")) {
            ((WsXzcfgzs) wenshuobject).pcode = orgentity.push();
            ((WsXzcfgzs) wenshuobject).ycode = orgentity.push();
            ((WsXzcfgzs) wenshuobject).ncode = orgentity.push();
            ((WsXzcfgzs) wenshuobject).cfdw = orgentity.push();
            ((WsXzcfgzs) wenshuobject).wfxw = orgentity.push();
            ((WsXzcfgzs) wenshuobject).gd = orgentity.push();
            ((WsXzcfgzs) wenshuobject).yj = orgentity.push();
            ((WsXzcfgzs) wenshuobject).xzcf = orgentity.push();
            ((WsXzcfgzs) wenshuobject).glbm = orgentity.push();
            ((WsXzcfgzs) wenshuobject).bmdz = orgentity.push();
            ((WsXzcfgzs) wenshuobject).bmlxr = orgentity.push();
            ((WsXzcfgzs) wenshuobject).bmlxdh = orgentity.push();
            ((WsXzcfgzs) wenshuobject).bmyb = orgentity.push();
            ((WsXzcfgzs) wenshuobject).rq = orgentity.push();
            ((WsXzcfgzs) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXzcfjdsdw-------
        else if (wenshuobjectstring.equals("WsXzcfjdsdw")) {
            ((WsXzcfjdsdw) wenshuobject).pcode = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).ycode = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).ncode = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).bcfdw = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).dz = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).yb = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).fddbr = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).fddbrzw = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).fddbrlxdh = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).wfsszj = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).gd = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).yj = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).xzcf = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).jz = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).zh = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).rmzf = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).sqdw = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).rmfy = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).rq = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).version = orgentity.push();
            ((WsXzcfjdsdw) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXzcfjdsgr-------
        else if (wenshuobjectstring.equals("WsXzcfjdsgr")) {
            ((WsXzcfjdsgr) wenshuobject).pcode = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).ycode = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).ncode = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).bcfr = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).xb = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).nl = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).lxdh = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).jtzz = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).szdw = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).zw = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).dwdz = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).yb = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).wfsszj = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).gd = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).yj = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).xzcf = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).jz = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).zh = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).rmzf = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).sqdw = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).rmfy = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).rq = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).version = orgentity.push();
            ((WsXzcfjdsgr) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsXzcftljl-------
        else if (wenshuobjectstring.equals("WsXzcftljl")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsXzcftljl) wenshuobject).ajmc = orgentity.push();
            ((WsXzcftljl) wenshuobject).tlsjc = orgentity.push();
            ((WsXzcftljl) wenshuobject).tlsjm = orgentity.push();
            ((WsXzcftljl) wenshuobject).dd = orgentity.push();
            ((WsXzcftljl) wenshuobject).zcr = orgentity.push();
            ((WsXzcftljl) wenshuobject).hbr = orgentity.push();
            ((WsXzcftljl) wenshuobject).jlr = orgentity.push();
            ((WsXzcftljl) wenshuobject).cxry = orgentity.push();
            ((WsXzcftljl) wenshuobject).tlnr = orgentity.push();
            ((WsXzcftljl) wenshuobject).tljl = orgentity.push();
            ((WsXzcftljl) wenshuobject).jlxyj = orgentity.push();
            ((WsXzcftljl) wenshuobject).cxrqm = orgentity.push();
            ((WsXzcftljl) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsYqjnfkpzs-------
        else if (wenshuobjectstring.equals("WsYqjnfkpzs")) {
            ((WsYqjnfkpzs) wenshuobject).pcode = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).ycode = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).ncode = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).fkdw = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).fkrq = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).wh = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).je = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).jkfs = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).ycjzrq = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).djq = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).fqjzrq = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).fqjnje = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).swjnfk = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).rq = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).version = orgentity.push();
            ((WsYqjnfkpzs) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsYqjnfkspb-------
        else if (wenshuobjectstring.equals("WsYqjnfkspb")) {
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsYqjnfkspb) wenshuobject).ajmc = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).wh = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).dsr = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).dz = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).wfss = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).ly = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).cbryj = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).cbrqm_one = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).cbrqm_two = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).cbrqmrq = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).shyj = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).shrqm = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).shrqmrq = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).spyj = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).sprqm = orgentity.push();
            ((WsYqjnfkspb) wenshuobject).sprqmrq = orgentity.push();


        }
        //-------WsZgfc-------
        else if (wenshuobjectstring.equals("WsZgfc")) {
            ((WsZgfc) wenshuobject).pcode = orgentity.push();
            ((WsZgfc) wenshuobject).ycode = orgentity.push();
            ((WsZgfc) wenshuobject).ncode = orgentity.push();
            ((WsZgfc) wenshuobject).bjcdw = orgentity.push();
            ((WsZgfc) wenshuobject).jcsj = orgentity.push();
            ((WsZgfc) wenshuobject).jd = orgentity.push();
            ((WsZgfc) wenshuobject).jpcode = orgentity.push();
            orgentity.push();
            ((WsZgfc) wenshuobject).jycode = orgentity.push();
            ((WsZgfc) wenshuobject).jncode = orgentity.push();
            ((WsZgfc) wenshuobject).yj = orgentity.push();
            ((WsZgfc) wenshuobject).fzr = orgentity.push();
            ((WsZgfc) wenshuobject).zfryy = orgentity.push();
            ((WsZgfc) wenshuobject).zfrye = orgentity.push();
            ((WsZgfc) wenshuobject).zhy = orgentity.push();
            ((WsZgfc) wenshuobject).zhe = orgentity.push();
            ((WsZgfc) wenshuobject).sj = orgentity.push();
            ((WsZgfc) wenshuobject).dfzh = orgentity.push();
            ((WsZgfc) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsZlxqzg-------
        else if (wenshuobjectstring.equals("WsZlxqzg")) {
            ((WsZlxqzg) wenshuobject).pcode = orgentity.push();
            ((WsZlxqzg) wenshuobject).ycode = orgentity.push();
            ((WsZlxqzg) wenshuobject).ncode = orgentity.push();
            ((WsZlxqzg) wenshuobject).bjcdw = orgentity.push();
            ((WsZlxqzg) wenshuobject).wtOne = orgentity.push();
            ((WsZlxqzg) wenshuobject).wtTwo = orgentity.push();
            ((WsZlxqzg) wenshuobject).wtThree = orgentity.push();
            ((WsZlxqzg) wenshuobject).wtFour = orgentity.push();
            ((WsZlxqzg) wenshuobject).djx = orgentity.push();
            ((WsZlxqzg) wenshuobject).zgrq = orgentity.push();
            ((WsZlxqzg) wenshuobject).rmzf = orgentity.push();
            ((WsZlxqzg) wenshuobject).sqdw = orgentity.push();
            ((WsZlxqzg) wenshuobject).rmfy = orgentity.push();
            ((WsZlxqzg) wenshuobject).zfryqmOne = orgentity.push();
            ((WsZlxqzg) wenshuobject).zfryqmTwo = orgentity.push();
            ((WsZlxqzg) wenshuobject).zhOne = orgentity.push();
            ((WsZlxqzg) wenshuobject).zhTwo = orgentity.push();
            ((WsZlxqzg) wenshuobject).fzrqm = orgentity.push();
            ((WsZlxqzg) wenshuobject).sj = orgentity.push();
            ((WsZlxqzg) wenshuobject).dfzh = orgentity.push();
            ((WsZlxqzg) wenshuobject).tbsj = orgentity.push();
        }
        //-------WsCyqzpz-------
        else if (wenshuobjectstring.equals("WsCyqzpz")) {
            //------WsCyqzpz-Entity_Book4-------


            ((WsCyqzpz) wenshuobject).pcode = orgentity.push();
            ((WsCyqzpz) wenshuobject).ycode = orgentity.push();
            ((WsCyqzpz) wenshuobject).ncode = orgentity.push();
            ((WsCyqzpz) wenshuobject).bcydw = orgentity.push();
            ((WsCyqzpz) wenshuobject).xcfzr = orgentity.push();
            ((WsCyqzpz) wenshuobject).dwdz = orgentity.push();
            ((WsCyqzpz) wenshuobject).lxdh = orgentity.push();
            ((WsCyqzpz) wenshuobject).yb = orgentity.push();
            ((WsCyqzpz) wenshuobject).cysjc = orgentity.push();
            ((WsCyqzpz) wenshuobject).cysjm = orgentity.push();
            ((WsCyqzpz) wenshuobject).cydd = orgentity.push();
            ((WsCyqzpz) wenshuobject).cyqzList = orgentity.push();
            ((WsCyqzpz) wenshuobject).xcfzrqm = orgentity.push();
            ((WsCyqzpz) wenshuobject).zfryqmOne = orgentity.push();
            ((WsCyqzpz) wenshuobject).zfryzhOne = orgentity.push();
            ((WsCyqzpz) wenshuobject).zfryqmTwo = orgentity.push();
            ((WsCyqzpz) wenshuobject).zfryzhTwo = orgentity.push();
            ((WsCyqzpz) wenshuobject).rq = orgentity.push();

        }
        //-------WsJdwts-------
        else if (wenshuobjectstring.equals("WsJdwts")) {
            //------WsJdwts-Entity_Book14-------

            ((WsJdwts) wenshuobject).pcode = orgentity.push();
            ((WsJdwts) wenshuobject).ycode = orgentity.push();
            ((WsJdwts) wenshuobject).ncode = orgentity.push();
            ((WsJdwts) wenshuobject).wtdw = orgentity.push();
            ((WsJdwts) wenshuobject).jdwtsList = orgentity.push();
            ((WsJdwts) wenshuobject).jdyq = orgentity.push();
            ((WsJdwts) wenshuobject).jzsj = orgentity.push();
            ((WsJdwts) wenshuobject).rq = orgentity.push();
        }
        //-------WsJnml-------
        else if (wenshuobjectstring.equals("WsJnml")) {
            //------WsJnml-Entity_Book36-------
            orgentity.push();
            orgentity.push();
            orgentity.push();
            ((WsJnml) wenshuobject).jnmlList = orgentity.push();

        }
        //-------WsSdhz-------
        else if (wenshuobjectstring.equals("WsSdhz")) {
            //------WsSdhz-Entity_Book30-------

            ((WsSdhz) wenshuobject).pcode = orgentity.push();
            ((WsSdhz) wenshuobject).ycode = orgentity.push();
            ((WsSdhz) wenshuobject).ncode = orgentity.push();
            ((WsSdhz) wenshuobject).ajmc = orgentity.push();
            ((WsSdhz) wenshuobject).ssddw = orgentity.push();
            ((WsSdhz) wenshuobject).sdhzList = orgentity.push();
            ((WsSdhz) wenshuobject).bz = orgentity.push();
        }
        return wenshuobject;
    }

    @Override
    public DateBase_Entity webobject2bookentity(Object webobject) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        DateBase_Entity orgentity = null;
        for (int i = 0; i < Static_BookLib.WEBBOOKNAME.length; i++) {
            if (Static_BookLib.WEBBOOKNAME[i].equals(webobject.getClass().getSimpleName())) {
                orgentity = (DateBase_Entity) Class.forName("com.wisdomregulation.data.entitybook.Entity_Book" + i).newInstance();
                //-------WsAjsy-------
                if (webobject.getClass().getSimpleName().equals("WsAjsy")) {
                    orgentity.pull(((WsAjsy) webobject).glj + "");
                    orgentity.pull(((WsAjsy) webobject).pcode + "");
                    orgentity.pull(((WsAjsy) webobject).ycode + "");
                    orgentity.pull(((WsAjsy) webobject).ncode + "");
                    orgentity.pull(((WsAjsy) webobject).ajmc + "");
                    orgentity.pull(((WsAjsy) webobject).ay + "");
                    orgentity.pull(((WsAjsy) webobject).cljg + "");
                    orgentity.pull(((WsAjsy) webobject).larq + "");
                    orgentity.pull(((WsAjsy) webobject).jarq + "");
                    orgentity.pull(((WsAjsy) webobject).cbrqm_one + "");
                    orgentity.pull(((WsAjsy) webobject).cbrqm_two + "");
                    orgentity.pull(((WsAjsy) webobject).gdrq + "");
                    orgentity.pull(((WsAjsy) webobject).gdh + "");
                    orgentity.pull(((WsAjsy) webobject).bcqx + "");
                    orgentity.pull(((WsAjsy) webobject).rq + "");
                    orgentity.pull(((WsAjsy) webobject).version + "");
                    orgentity.pull(((WsAjsy) webobject).tbsj + "");
                }
                //-------WsAjyss-------
                else if (webobject.getClass().getSimpleName().equals("WsAjyss")) {
                    orgentity.pull(((WsAjyss) webobject).pcode + "");
                    orgentity.pull(((WsAjyss) webobject).ycode + "");
                    orgentity.pull(((WsAjyss) webobject).ncode + "");
                    orgentity.pull(((WsAjyss) webobject).ysdw + "");
                    orgentity.pull(((WsAjyss) webobject).larq + "");
                    orgentity.pull(((WsAjyss) webobject).aj + "");
                    orgentity.pull(((WsAjyss) webobject).fx + "");
                    orgentity.pull(((WsAjyss) webobject).gd + "");
                    orgentity.pull(((WsAjyss) webobject).cl + "");
                    orgentity.pull(((WsAjyss) webobject).jf + "");
                    orgentity.pull(((WsAjyss) webobject).jy + "");
                    orgentity.pull(((WsAjyss) webobject).rq + "");
                    orgentity.pull(((WsAjyss) webobject).version + "");
                    orgentity.pull(((WsAjyss) webobject).tbsj + "");
                }
                //-------WsAjysspb-------
                else if (webobject.getClass().getSimpleName().equals("WsAjclcp")) {
                    orgentity.pull(((WsAjclcp) webobject).pcode + "");
                    //("字")
                    orgentity.pull(((WsAjclcp) webobject).ycode + "");
                    //("号")
                    orgentity.pull(((WsAjclcp) webobject).ncode + "");
                    //("案件名称")
                    orgentity.pull(((WsAjclcp) webobject).ajmc + "");
                    //("被处罚单位")
                    orgentity.pull(((WsAjclcp) webobject).bcfdw + "");
                    //("地址")
                    orgentity.pull(((WsAjclcp) webobject).dz + "");
                    //("法定代表人")
                    orgentity.pull(((WsAjclcp) webobject).fddbr + "");
                    //("职务")
                    orgentity.pull(((WsAjclcp) webobject).zw + "");
                    //("单位邮编")
                    orgentity.pull(((WsAjclcp) webobject).dwyb + "");
                    //("被处罚人")
                    orgentity.pull(((WsAjclcp) webobject).bcfr + "");
                    //("年龄")
                    orgentity.pull(((WsAjclcp) webobject).nl + "");
                    //("性别")
                    orgentity.pull(((WsAjclcp) webobject).xb + "");
                    //("所在单位")
                    orgentity.pull(((WsAjclcp) webobject).szdw + "");
                    //("单位地址")
                    orgentity.pull(((WsAjclcp) webobject).dwdz + "");
                    //("家庭住址")
                    orgentity.pull(((WsAjclcp) webobject).jtzz + "");
                    //("联系电话")
                    orgentity.pull(((WsAjclcp) webobject).lxdh + "");
                    //("家庭邮编")
                    orgentity.pull(((WsAjclcp) webobject).jtyb + "");
                    //("违法事实及处罚依据")
                    orgentity.pull(((WsAjclcp) webobject).wfss + "");
                    //("当事人申辩意见")
                    orgentity.pull(((WsAjclcp) webobject).dsrsbyj + "");
                    //("承办人意见")
                    orgentity.pull(((WsAjclcp) webobject).cbryj + "");
                    //("承办人签名1")
                    orgentity.pull(((WsAjclcp) webobject).cbrqmy + "");
                    //("承办人签名2")
                    orgentity.pull(((WsAjclcp) webobject).cbrqme + "");
                    //("承办人签名时间")
                    orgentity.pull(((WsAjclcp) webobject).cbrqmsj + "");
                    //("审核意见")
                    orgentity.pull(((WsAjclcp) webobject).shyj + "");
                    //("审核人签名")
                    orgentity.pull(((WsAjclcp) webobject).shrqm + "");
                    //("审核时间")
                    orgentity.pull(((WsAjclcp) webobject).shsj + "");
                    //("审批意见")
                    orgentity.pull(((WsAjclcp) webobject).spyj + "");
                    //("审批人签名")
                    orgentity.pull(((WsAjclcp) webobject).sprqm + "");
                    //("审批时间")
                    orgentity.pull(((WsAjclcp) webobject).spsj + "");

                }
                //-------WsAjysspb-------
                else if (webobject.getClass().getSimpleName().equals("WsAjysspb")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsAjysspb) webobject).ajmc + "");
                    orgentity.pull(((WsAjysspb) webobject).dsr + "");
                    orgentity.pull(((WsAjysspb) webobject).dz + "");
                    orgentity.pull(((WsAjysspb) webobject).sysjg + "");
                    orgentity.pull(((WsAjysspb) webobject).aqjj + "");
                    orgentity.pull(((WsAjysspb) webobject).ysly + "");
                    orgentity.pull(((WsAjysspb) webobject).cbryj + "");
                    orgentity.pull(((WsAjysspb) webobject).cbrqm_one + "");
                    orgentity.pull(((WsAjysspb) webobject).cbrqm_two + "");
                    orgentity.pull(((WsAjysspb) webobject).cbrqmrq + "");
                    orgentity.pull(((WsAjysspb) webobject).shyj + "");
                    orgentity.pull(((WsAjysspb) webobject).shrqm + "");
                    orgentity.pull(((WsAjysspb) webobject).shrqmrq + "");
                    orgentity.pull(((WsAjysspb) webobject).spyj + "");
                    orgentity.pull(((WsAjysspb) webobject).sprqm + "");
                    orgentity.pull(((WsAjysspb) webobject).sprqmrq + "");
                    orgentity.pull(((WsAjysspb) webobject).version + "");
                    orgentity.pull(((WsAjysspb) webobject).tbsj + "");
                }
                //-------WsDsrcssbbl-------
                else if (webobject.getClass().getSimpleName().equals("WsDsrcssbbl")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsDsrcssbbl) webobject).sjc + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).sjm + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).dd + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).cssbr + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).sbrxb + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).sbrzw + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).sbrdw + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).sbrdh + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).sbrlxdz + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).sbryb + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).cbr + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).jlr + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).glj + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).zfryOne + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).zfryTwo + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).zfryzhOne + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).zfryzhTwo + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).aj + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).cssbjl + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).cssbrqm + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).cbrqm + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).jlrqm + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).rq + "");
                    orgentity.pull(((WsDsrcssbbl) webobject).tbsj + "");
                }
                //-------WsFkcjtzs-------
                else if (webobject.getClass().getSimpleName().equals("WsFkcjtzs")) {
                    orgentity.pull(((WsFkcjtzs) webobject).pcode + "");
                    orgentity.pull(((WsFkcjtzs) webobject).ycode + "");
                    orgentity.pull(((WsFkcjtzs) webobject).ncode + "");
                    orgentity.pull(((WsFkcjtzs) webobject).fkdw + "");
                    orgentity.pull(((WsFkcjtzs) webobject).fkrq + "");
                    orgentity.pull(((WsFkcjtzs) webobject).fkh + "");
                    orgentity.pull(((WsFkcjtzs) webobject).jkrq + "");
                    orgentity.pull(((WsFkcjtzs) webobject).jkc + "");
                    orgentity.pull(((WsFkcjtzs) webobject).rq + "");
                    orgentity.pull(((WsFkcjtzs) webobject).version + "");
                    orgentity.pull(((WsFkcjtzs) webobject).tbsj + "");
                }
                //-------WsJaspb-------
                else if (webobject.getClass().getSimpleName().equals("WsJaspb")) {
                    orgentity.pull(((WsJaspb) webobject).pcode + "");
                    orgentity.pull(((WsJaspb) webobject).ycode + "");
                    orgentity.pull(((WsJaspb) webobject).ncode + "");
                    orgentity.pull(((WsJaspb) webobject).ajmc + "");
                    orgentity.pull(((WsJaspb) webobject).bcfdw + "");
                    orgentity.pull(((WsJaspb) webobject).bcfdwdz + "");
                    orgentity.pull(((WsJaspb) webobject).fddbr + "");
                    orgentity.pull(((WsJaspb) webobject).fddbrzw + "");
                    orgentity.pull(((WsJaspb) webobject).fddbryb + "");
                    orgentity.pull(((WsJaspb) webobject).bcfr + "");
                    orgentity.pull(((WsJaspb) webobject).bcfrnl + "");
                    orgentity.pull(((WsJaspb) webobject).bcfrxb + "");
                    orgentity.pull(((WsJaspb) webobject).bcfrdw + "");
                    orgentity.pull(((WsJaspb) webobject).bcfrdwzz + "");
                    orgentity.pull(((WsJaspb) webobject).bcfrjtzz + "");
                    orgentity.pull(((WsJaspb) webobject).bcfrlxdh + "");
                    orgentity.pull(((WsJaspb) webobject).bcfryb + "");
                    orgentity.pull(((WsJaspb) webobject).cljg + "");
                    orgentity.pull(((WsJaspb) webobject).zxqk + "");
                    orgentity.pull(((WsJaspb) webobject).cbrqm_one + "");
                    orgentity.pull(((WsJaspb) webobject).cbrqm_two + "");
                    orgentity.pull(((WsJaspb) webobject).cbrqmrq + "");
                    orgentity.pull(((WsJaspb) webobject).shyj + "");
                    orgentity.pull(((WsJaspb) webobject).shrqm + "");
                    orgentity.pull(((WsJaspb) webobject).shrqmrq + "");
                    orgentity.pull(((WsJaspb) webobject).spyj + "");
                    orgentity.pull(((WsJaspb) webobject).sprqm + "");
                    orgentity.pull(((WsJaspb) webobject).sprqmrq + "");
                    orgentity.pull(((WsJaspb) webobject).version + "");
                    orgentity.pull(((WsJaspb) webobject).tbsj + "");
                }
                //-------WsKybl-------
                else if (webobject.getClass().getSimpleName().equals("WsKybl")) {
                    orgentity.pull(((WsKybl) webobject).pcode + "");
                    orgentity.pull(((WsKybl) webobject).ycode + "");
                    orgentity.pull(((WsKybl) webobject).ncode + "");
                    orgentity.pull(((WsKybl) webobject).kysjc + "");
                    orgentity.pull(((WsKybl) webobject).kysjm + "");
                    orgentity.pull(((WsKybl) webobject).kycs + "");
                    orgentity.pull(((WsKybl) webobject).tqqk + "");
                    orgentity.pull(((WsKybl) webobject).kyrOne + "");
                    orgentity.pull(((WsKybl) webobject).kyrzwOne + "");
                    orgentity.pull(((WsKybl) webobject).kyrTwo + "");
                    orgentity.pull(((WsKybl) webobject).kyrzwTwo + "");
                    orgentity.pull(((WsKybl) webobject).dsrOne + "");
                    orgentity.pull(((WsKybl) webobject).dsrzwOne + "");
                    orgentity.pull(((WsKybl) webobject).dsrTwo + "");
                    orgentity.pull(((WsKybl) webobject).dsrzwTwo + "");
                    orgentity.pull(((WsKybl) webobject).byqr + "");
                    orgentity.pull(((WsKybl) webobject).byqrzw + "");
                    orgentity.pull(((WsKybl) webobject).jlr + "");
                    orgentity.pull(((WsKybl) webobject).jlrzw + "");
                    orgentity.pull(((WsKybl) webobject).glj + "");
                    orgentity.pull(((WsKybl) webobject).zfryOne + "");
                    orgentity.pull(((WsKybl) webobject).zfryTwo + "");
                    orgentity.pull(((WsKybl) webobject).zhOne + "");
                    orgentity.pull(((WsKybl) webobject).zhTwo + "");
                    orgentity.pull(((WsKybl) webobject).kyqk + "");
                    orgentity.pull(((WsKybl) webobject).kyrqmOne + "");
                    orgentity.pull(((WsKybl) webobject).kyrqmTwo + "");
                    orgentity.pull(((WsKybl) webobject).dsrqmOne + "");
                    orgentity.pull(((WsKybl) webobject).dsrlxdhOne + "");
                    orgentity.pull(((WsKybl) webobject).dsrqmTwo + "");
                    orgentity.pull(((WsKybl) webobject).dsrlxdhTwo + "");
                    orgentity.pull(((WsKybl) webobject).byqrqm + "");
                    orgentity.pull(((WsKybl) webobject).byqrlxdh + "");
                    orgentity.pull(((WsKybl) webobject).tbsj + "");
                }
                //-------WsLasp-------
                else if (webobject.getClass().getSimpleName().equals("WsLasp")) {
                    orgentity.pull(((WsLasp) webobject).pcode + "");
                    orgentity.pull(((WsLasp) webobject).ycode + "");
                    orgentity.pull(((WsLasp) webobject).ncode + "");
                    orgentity.pull(((WsLasp) webobject).ay + "");
                    orgentity.pull(((WsLasp) webobject).ajly + "");
                    orgentity.pull(((WsLasp) webobject).sj + "");
                    orgentity.pull(((WsLasp) webobject).ajmc + "");
                    orgentity.pull(((WsLasp) webobject).dsr + "");
                    orgentity.pull(((WsLasp) webobject).dh + "");
                    orgentity.pull(((WsLasp) webobject).dsrqk + "");
                    orgentity.pull(((WsLasp) webobject).dsrdz + "");
                    orgentity.pull(((WsLasp) webobject).yzbm + "");
                    orgentity.pull(((WsLasp) webobject).ajqk + "");
                    orgentity.pull(((WsLasp) webobject).cbryj + "");
                    orgentity.pull(((WsLasp) webobject).cbrqzy + "");
                    orgentity.pull(((WsLasp) webobject).zhy + "");
                    orgentity.pull(((WsLasp) webobject).cbrqze + "");
                    orgentity.pull(((WsLasp) webobject).zhe + "");
                    orgentity.pull(((WsLasp) webobject).cbsj + "");
                    orgentity.pull(((WsLasp) webobject).shyj + "");
                    orgentity.pull(((WsLasp) webobject).shre + "");
                    orgentity.pull(((WsLasp) webobject).shsj + "");
                    orgentity.pull(((WsLasp) webobject).spyj + "");
                    orgentity.pull(((WsLasp) webobject).spr + "");
                    orgentity.pull(((WsLasp) webobject).spsj + "");
                    orgentity.pull(((WsLasp) webobject).version + "");
                    orgentity.pull(((WsLasp) webobject).tbsj + "");
                }
                //-------WsQzcs-------
                else if (webobject.getClass().getSimpleName().equals("WsQzcs")) {
                    orgentity.pull(((WsQzcs) webobject).pcode + "");
                    orgentity.pull(((WsQzcs) webobject).ycode + "");
                    orgentity.pull(((WsQzcs) webobject).ncode + "");
                    orgentity.pull(((WsQzcs) webobject).bjcdw + "");
                    orgentity.pull(((WsQzcs) webobject).wt + "");
                    orgentity.pull(((WsQzcs) webobject).yj + "");
                    orgentity.pull(((WsQzcs) webobject).qzcs + "");
                    orgentity.pull(((WsQzcs) webobject).rmzf + "");
                    orgentity.pull(((WsQzcs) webobject).sqdw + "");
                    orgentity.pull(((WsQzcs) webobject).rmfy + "");
                    orgentity.pull(((WsQzcs) webobject).sj + "");
                    orgentity.pull(((WsQzcs) webobject).dfzh + "");
                    orgentity.pull(((WsQzcs) webobject).tbsj + "");
                }
                //-------WsQzzxsqs-------
                else if (webobject.getClass().getSimpleName().equals("WsQzzxsqs")) {
                    orgentity.pull(((WsQzzxsqs) webobject).pcode + "");
                    orgentity.pull(((WsQzzxsqs) webobject).ycode + "");
                    orgentity.pull(((WsQzzxsqs) webobject).ncode + "");
                    orgentity.pull(((WsQzzxsqs) webobject).rmfy + "");
                    orgentity.pull(((WsQzzxsqs) webobject).cfrq + "");
                    orgentity.pull(((WsQzzxsqs) webobject).sqzxr + "");
                    orgentity.pull(((WsQzzxsqs) webobject).cfjd + "");
                    orgentity.pull(((WsQzzxsqs) webobject).wh + "");
                    orgentity.pull(((WsQzzxsqs) webobject).ygcl + "");
                    orgentity.pull(((WsQzzxsqs) webobject).rq + "");
                    orgentity.pull(((WsQzzxsqs) webobject).lxr + "");
                    orgentity.pull(((WsQzzxsqs) webobject).lxdh + "");
                    orgentity.pull(((WsQzzxsqs) webobject).version + "");
                    orgentity.pull(((WsQzzxsqs) webobject).tbsj + "");
                }
                //-------WsTzbl-------
                else if (webobject.getClass().getSimpleName().equals("WsTzbl")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsTzbl) webobject).ajmc + "");
                    orgentity.pull(((WsTzbl) webobject).zctzjg + "");
                    orgentity.pull(((WsTzbl) webobject).dd + "");
                    orgentity.pull(((WsTzbl) webobject).tzsjc + "");
                    orgentity.pull(((WsTzbl) webobject).tzsjm + "");
                    orgentity.pull(((WsTzbl) webobject).tzzcr + "");
                    orgentity.pull(((WsTzbl) webobject).tzy + "");
                    orgentity.pull(((WsTzbl) webobject).sjy + "");
                    orgentity.pull(((WsTzbl) webobject).dcryOne + "");
                    orgentity.pull(((WsTzbl) webobject).dcryzhOne + "");
                    orgentity.pull(((WsTzbl) webobject).dcryTwo + "");
                    orgentity.pull(((WsTzbl) webobject).dcryzhTwo + "");
                    orgentity.pull(((WsTzbl) webobject).fddbrxm + "");
                    orgentity.pull(((WsTzbl) webobject).fddbrxb + "");
                    orgentity.pull(((WsTzbl) webobject).fddbrnl + "");
                    orgentity.pull(((WsTzbl) webobject).gzdwzw + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrOne + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrxbOne + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrnlOne + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrdwOne + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrTwo + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrxbTwo + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrnlTwo + "");
                    orgentity.pull(((WsTzbl) webobject).wtdlrdwTwo + "");
                    orgentity.pull(((WsTzbl) webobject).dsr + "");
                    orgentity.pull(((WsTzbl) webobject).qtcyry + "");
                    orgentity.pull(((WsTzbl) webobject).tzjl + "");
                    orgentity.pull(((WsTzbl) webobject).dbrqm + "");
                    orgentity.pull(((WsTzbl) webobject).zcrqm + "");
                    orgentity.pull(((WsTzbl) webobject).sjyqm + "");
                    orgentity.pull(((WsTzbl) webobject).rq + "");
                    orgentity.pull(((WsTzbl) webobject).tbsj + "");
                }
                //-------WsTzgzs-------
                else if (webobject.getClass().getSimpleName().equals("WsTzgzs")) {
                    orgentity.pull(((WsTzgzs) webobject).pcode + "");
                    orgentity.pull(((WsTzgzs) webobject).ycode + "");
                    orgentity.pull(((WsTzgzs) webobject).ncode + "");
                    orgentity.pull(((WsTzgzs) webobject).cfdw + "");
                    orgentity.pull(((WsTzgzs) webobject).wfxw + "");
                    orgentity.pull(((WsTzgzs) webobject).gd + "");
                    orgentity.pull(((WsTzgzs) webobject).yj + "");
                    orgentity.pull(((WsTzgzs) webobject).xzcf + "");
                    orgentity.pull(((WsTzgzs) webobject).glbm + "");
                    orgentity.pull(((WsTzgzs) webobject).bmdz + "");
                    orgentity.pull(((WsTzgzs) webobject).bmlxr + "");
                    orgentity.pull(((WsTzgzs) webobject).bmlxdh + "");
                    orgentity.pull(((WsTzgzs) webobject).bmyb + "");
                    orgentity.pull(((WsTzgzs) webobject).rq + "");
                    orgentity.pull(((WsTzgzs) webobject).tbsj + "");
                }
                //-------WsTzhbg-------
                else if (webobject.getClass().getSimpleName().equals("WsTzhbg")) {
                    orgentity.pull(((WsTzhbg) webobject).pcode + "");
                    orgentity.pull(((WsTzhbg) webobject).ycode + "");
                    orgentity.pull(((WsTzhbg) webobject).ncode + "");
                    orgentity.pull(((WsTzhbg) webobject).ajmc + "");
                    orgentity.pull(((WsTzhbg) webobject).tzzcr + "");
                    orgentity.pull(((WsTzhbg) webobject).tzy + "");
                    orgentity.pull(((WsTzhbg) webobject).sjy + "");
                    orgentity.pull(((WsTzhbg) webobject).zy + "");
                    orgentity.pull(((WsTzhbg) webobject).tzzcryj + "");
                    orgentity.pull(((WsTzhbg) webobject).tzzcrqm + "");
                    orgentity.pull(((WsTzhbg) webobject).tzzcrqmrq + "");
                    orgentity.pull(((WsTzhbg) webobject).fzrshyj + "");
                    orgentity.pull(((WsTzhbg) webobject).fzrqm + "");
                    orgentity.pull(((WsTzhbg) webobject).fzrqmrq + "");
                    orgentity.pull(((WsTzhbg) webobject).tbsj + "");
                }
                //-------WsTzhtzs-------
                else if (webobject.getClass().getSimpleName().equals("WsTzhtzs")) {
                    orgentity.pull(((WsTzhtzs) webobject).pcode + "");
                    orgentity.pull(((WsTzhtzs) webobject).ycode + "");
                    orgentity.pull(((WsTzhtzs) webobject).ncode + "");
                    orgentity.pull(((WsTzhtzs) webobject).cfdw + "");
                    orgentity.pull(((WsTzhtzs) webobject).aj + "");
                    orgentity.pull(((WsTzhtzs) webobject).sj + "");
                    orgentity.pull(((WsTzhtzs) webobject).hydd + "");
                    orgentity.pull(((WsTzhtzs) webobject).zcrxm + "");
                    orgentity.pull(((WsTzhtzs) webobject).zcrzw + "");
                    orgentity.pull(((WsTzhtzs) webobject).tzyxmOne + "");
                    orgentity.pull(((WsTzhtzs) webobject).tzyzwOne + "");
                    orgentity.pull(((WsTzhtzs) webobject).tzyxmTwo + "");
                    orgentity.pull(((WsTzhtzs) webobject).tzyzwTwo + "");
                    orgentity.pull(((WsTzhtzs) webobject).sjyxm + "");
                    orgentity.pull(((WsTzhtzs) webobject).sjyzw + "");
                    orgentity.pull(((WsTzhtzs) webobject).rq + "");
                    orgentity.pull(((WsTzhtzs) webobject).bmdz + "");
                    orgentity.pull(((WsTzhtzs) webobject).bmlxr + "");
                    orgentity.pull(((WsTzhtzs) webobject).bmlxdh + "");
                    orgentity.pull(((WsTzhtzs) webobject).bmyb + "");

                }
                //-------WsXcclcs-------
                else if (webobject.getClass().getSimpleName().equals("WsXcclcs")) {
                    orgentity.pull(((WsXcclcs) webobject).pcode + "");
                    orgentity.pull(((WsXcclcs) webobject).ycode + "");
                    orgentity.pull(((WsXcclcs) webobject).ncode + "");
                    orgentity.pull(((WsXcclcs) webobject).bjcdw + "");
                    orgentity.pull(((WsXcclcs) webobject).jcrq + "");
                    orgentity.pull(((WsXcclcs) webobject).sgyhOne + "");
                    orgentity.pull(((WsXcclcs) webobject).sgyhTwo + "");
                    orgentity.pull(((WsXcclcs) webobject).sgyhThree + "");
                    orgentity.pull(((WsXcclcs) webobject).yj + "");
                    orgentity.pull(((WsXcclcs) webobject).jdOne + "");
                    orgentity.pull(((WsXcclcs) webobject).jdTwo + "");
                    orgentity.pull(((WsXcclcs) webobject).jdThree + "");
                    orgentity.pull(((WsXcclcs) webobject).rmzf + "");
                    orgentity.pull(((WsXcclcs) webobject).sqdw + "");
                    orgentity.pull(((WsXcclcs) webobject).rmfy + "");
                    orgentity.pull(((WsXcclcs) webobject).zfryqmOne + "");
                    orgentity.pull(((WsXcclcs) webobject).zfryqmTwo + "");
                    orgentity.pull(((WsXcclcs) webobject).zhOne + "");
                    orgentity.pull(((WsXcclcs) webobject).zhTwo + "");
                    orgentity.pull(((WsXcclcs) webobject).fzrqm + "");
                    orgentity.pull(((WsXcclcs) webobject).sj + "");
                    orgentity.pull(((WsXcclcs) webobject).dfzh + "");
                    orgentity.pull(((WsXcclcs) webobject).tbsj + "");
                }
                //-------WsXcjc-------
                else if (webobject.getClass().getSimpleName().equals("WsXcjc")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsXcjc) webobject).bjcdw + "");
                    orgentity.pull(((WsXcjc) webobject).dz + "");
                    orgentity.pull(((WsXcjc) webobject).fzr + "");
                    orgentity.pull(((WsXcjc) webobject).zw + "");
                    orgentity.pull(((WsXcjc) webobject).lxdh + "");
                    orgentity.pull(((WsXcjc) webobject).jccs + "");
                    orgentity.pull(((WsXcjc) webobject).jcsjc + "");
                    orgentity.pull(((WsXcjc) webobject).jcsjm + "");
                    orgentity.pull(((WsXcjc) webobject).glj + "");
                    orgentity.pull(((WsXcjc) webobject).zfryy + "");
                    orgentity.pull(((WsXcjc) webobject).zfrye + "");
                    orgentity.pull(((WsXcjc) webobject).zjhmy + "");
                    orgentity.pull(((WsXcjc) webobject).zjhme + "");
                    orgentity.pull(((WsXcjc) webobject).jcqk + "");
                    orgentity.pull(((WsXcjc) webobject).jcryqmy + "");
                    orgentity.pull(((WsXcjc) webobject).jcryqme + "");
                    orgentity.pull(((WsXcjc) webobject).bjcfzr + "");
                    orgentity.pull(((WsXcjc) webobject).sj + "");
                    orgentity.pull(((WsXcjc) webobject).tbsj + "");
                }
                //-------WsXwbl-------
                else if (webobject.getClass().getSimpleName().equals("WsXwbl")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsXwbl) webobject).xwsjc + "");
                    orgentity.pull(((WsXwbl) webobject).xwsjm + "");
                    orgentity.pull(((WsXwbl) webobject).xwcs + "");
                    orgentity.pull(((WsXwbl) webobject).xwdd + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrxm + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrxb + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrnl + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrzjh + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrdw + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrzw + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrzz + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrdh + "");
                    orgentity.pull(((WsXwbl) webobject).xwr + "");
                    orgentity.pull(((WsXwbl) webobject).xwrdwzw + "");
                    orgentity.pull(((WsXwbl) webobject).jlr + "");
                    orgentity.pull(((WsXwbl) webobject).jlrdwzw + "");
                    orgentity.pull(((WsXwbl) webobject).zcr + "");
                    orgentity.pull(((WsXwbl) webobject).glj + "");
                    orgentity.pull(((WsXwbl) webobject).zfryOne + "");
                    orgentity.pull(((WsXwbl) webobject).zfryTwo + "");
                    orgentity.pull(((WsXwbl) webobject).zhOne + "");
                    orgentity.pull(((WsXwbl) webobject).zhTwo + "");
                    orgentity.pull(((WsXwbl) webobject).wt + "");
                    orgentity.pull(((WsXwbl) webobject).xwjl + "");
                    orgentity.pull(((WsXwbl) webobject).xwrqm + "");
                    orgentity.pull(((WsXwbl) webobject).jlrqm + "");
                    orgentity.pull(((WsXwbl) webobject).bxwrqm + "");
                    orgentity.pull(((WsXwbl) webobject).rq + "");
                    orgentity.pull(((WsXwbl) webobject).tbsj + "");
                }
                //-------WsXwtz-------
                else if (webobject.getClass().getSimpleName().equals("WsXwtz")) {
                    orgentity.pull(((WsXwtz) webobject).pcode + "");
                    orgentity.pull(((WsXwtz) webobject).ycode + "");
                    orgentity.pull(((WsXwtz) webobject).ncode + "");
                    orgentity.pull(((WsXwtz) webobject).bjcr + "");
                    orgentity.pull(((WsXwtz) webobject).yy + "");
                    orgentity.pull(((WsXwtz) webobject).xwsj + "");
                    orgentity.pull(((WsXwtz) webobject).xwdd + "");
                    orgentity.pull(((WsXwtz) webobject).cllb + "");
                    orgentity.pull(((WsXwtz) webobject).zdycl + "");
                    orgentity.pull(((WsXwtz) webobject).glbmdz + "");
                    orgentity.pull(((WsXwtz) webobject).lxr + "");
                    orgentity.pull(((WsXwtz) webobject).lxdh + "");
                    orgentity.pull(((WsXwtz) webobject).sj + "");
                    orgentity.pull(((WsXwtz) webobject).version + "");
                    orgentity.pull(((WsXwtz) webobject).tbsj + "");
                }
                //-------WsXxdjbc-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjbc")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsXxdjbc) webobject).ajmc + "");
                    orgentity.pull(((WsXxdjbc) webobject).dsrjbqk + "");
                    orgentity.pull(((WsXxdjbc) webobject).ajjbqk + "");
                    orgentity.pull(((WsXxdjbc) webobject).zjmcjsl + "");
                    orgentity.pull(((WsXxdjbc) webobject).tqlyjyj + "");
                    orgentity.pull(((WsXxdjbc) webobject).bcfs + "");
                    orgentity.pull(((WsXxdjbc) webobject).cbryj + "");
                    orgentity.pull(((WsXxdjbc) webobject).cbrqm + "");
                    orgentity.pull(((WsXxdjbc) webobject).cbrsj + "");
                    orgentity.pull(((WsXxdjbc) webobject).bmfzryj + "");
                    orgentity.pull(((WsXxdjbc) webobject).bmfzrqm + "");
                    orgentity.pull(((WsXxdjbc) webobject).bmfzrsj + "");
                    orgentity.pull(((WsXxdjbc) webobject).jgfzryj + "");
                    orgentity.pull(((WsXxdjbc) webobject).jgfzrqm + "");
                    orgentity.pull(((WsXxdjbc) webobject).jgfzrsj + "");
                    orgentity.pull(((WsXxdjbc) webobject).tbsj + "");
                }
                //-------WsXxdjcljds-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjcljds")) {
                    orgentity.pull(((WsXxdjcljds) webobject).pcode + "");
                    orgentity.pull(((WsXxdjcljds) webobject).ycode + "");
                    orgentity.pull(((WsXxdjcljds) webobject).ncode + "");
                    orgentity.pull(((WsXxdjcljds) webobject).bdjdw + "");
                    orgentity.pull(((WsXxdjcljds) webobject).djrq + "");
                    orgentity.pull(((WsXxdjcljds) webobject).djwp + "");
                    orgentity.pull(((WsXxdjcljds) webobject).jpcode + "");
                    orgentity.pull(((WsXxdjcljds) webobject).jycode + "");
                    orgentity.pull(((WsXxdjcljds) webobject).jncode + "");
                    orgentity.pull(((WsXxdjcljds) webobject).cl + "");
                    orgentity.pull(((WsXxdjcljds) webobject).rmzf + "");
                    orgentity.pull(((WsXxdjcljds) webobject).sqdw + "");
                    orgentity.pull(((WsXxdjcljds) webobject).rmfy + "");
                    orgentity.pull(((WsXxdjcljds) webobject).rq + "");
                    orgentity.pull(((WsXxdjcljds) webobject).tbsj + "");
                }
                //-------WsXxdjclspb-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjclspb")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsXxdjclspb) webobject).ajmc + "");
                    orgentity.pull(((WsXxdjclspb) webobject).dsrqk + "");
                    orgentity.pull(((WsXxdjclspb) webobject).ajjbqk + "");
                    orgentity.pull(((WsXxdjclspb) webobject).zjmcsl + "");
                    orgentity.pull(((WsXxdjclspb) webobject).tqlyyj + "");
                    orgentity.pull(((WsXxdjclspb) webobject).cbryj + "");
                    orgentity.pull(((WsXxdjclspb) webobject).cbrqm + "");
                    orgentity.pull(((WsXxdjclspb) webobject).cbrqmrq + "");
                    orgentity.pull(((WsXxdjclspb) webobject).bmfzryj + "");
                    orgentity.pull(((WsXxdjclspb) webobject).bmfzrqm + "");
                    orgentity.pull(((WsXxdjclspb) webobject).bmfzrqmrq + "");
                    orgentity.pull(((WsXxdjclspb) webobject).jgfzryj + "");
                    orgentity.pull(((WsXxdjclspb) webobject).jgfzrqm + "");
                    orgentity.pull(((WsXxdjclspb) webobject).jgfzrqmrq + "");
                    orgentity.pull(((WsXxdjclspb) webobject).tbsj + "");
                }
                //-------WsXxdjtzs-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjtzs")) {
                    orgentity.pull(((WsXxdjtzs) webobject).pcode + "");
                    orgentity.pull(((WsXxdjtzs) webobject).ycode + "");
                    orgentity.pull(((WsXxdjtzs) webobject).ncode + "");
                    orgentity.pull(((WsXxdjtzs) webobject).bcfdw + "");
                    orgentity.pull(((WsXxdjtzs) webobject).wfxw + "");
                    orgentity.pull(((WsXxdjtzs) webobject).jdrq + "");
                    orgentity.pull(((WsXxdjtzs) webobject).djc + "");
                    orgentity.pull(((WsXxdjtzs) webobject).fzrqm + "");
                    orgentity.pull(((WsXxdjtzs) webobject).rq + "");
                }
                //-------WsXzcfdw-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfdw")) {
                    orgentity.pull(((WsXzcfdw) webobject).pcode + "");
                    orgentity.pull(((WsXzcfdw) webobject).ycode + "");
                    orgentity.pull(((WsXzcfdw) webobject).ncode + "");
                    orgentity.pull(((WsXzcfdw) webobject).bcfdw + "");
                    orgentity.pull(((WsXzcfdw) webobject).dz + "");
                    orgentity.pull(((WsXzcfdw) webobject).yb + "");
                    orgentity.pull(((WsXzcfdw) webobject).fddbr + "");
                    orgentity.pull(((WsXzcfdw) webobject).zw + "");
                    orgentity.pull(((WsXzcfdw) webobject).lxdh + "");
                    orgentity.pull(((WsXzcfdw) webobject).wfss + "");
                    orgentity.pull(((WsXzcfdw) webobject).wfgd + "");
                    orgentity.pull(((WsXzcfdw) webobject).yjgd + "");
                    orgentity.pull(((WsXzcfdw) webobject).xzcf + "");
                    orgentity.pull(((WsXzcfdw) webobject).fkfs + "");
                    orgentity.pull(((WsXzcfdw) webobject).jz + "");
                    orgentity.pull(((WsXzcfdw) webobject).zh + "");
                    orgentity.pull(((WsXzcfdw) webobject).zf + "");
                    orgentity.pull(((WsXzcfdw) webobject).sqdw + "");
                    orgentity.pull(((WsXzcfdw) webobject).rmfy + "");
                    orgentity.pull(((WsXzcfdw) webobject).zfryy + "");
                    orgentity.pull(((WsXzcfdw) webobject).zfrye + "");
                    orgentity.pull(((WsXzcfdw) webobject).dsr + "");
                    orgentity.pull(((WsXzcfdw) webobject).sj + "");
                    orgentity.pull(((WsXzcfdw) webobject).version + "");
                    orgentity.pull(((WsXzcfdw) webobject).dfzh + "");
                    orgentity.pull(((WsXzcfdw) webobject).tbsj + "");
                }
                //-------WsXzcfgr-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfgr")) {
                    orgentity.pull(((WsXzcfgr) webobject).pcode + "");
                    orgentity.pull(((WsXzcfgr) webobject).ycode + "");
                    orgentity.pull(((WsXzcfgr) webobject).ncode + "");
                    orgentity.pull(((WsXzcfgr) webobject).bcfr + "");
                    orgentity.pull(((WsXzcfgr) webobject).xb + "");
                    orgentity.pull(((WsXzcfgr) webobject).nl + "");
                    orgentity.pull(((WsXzcfgr) webobject).sfzh + "");
                    orgentity.pull(((WsXzcfgr) webobject).jtzz + "");
                    orgentity.pull(((WsXzcfgr) webobject).szdw + "");
                    orgentity.pull(((WsXzcfgr) webobject).zw + "");
                    orgentity.pull(((WsXzcfgr) webobject).dwdz + "");
                    orgentity.pull(((WsXzcfgr) webobject).lxdh + "");
                    orgentity.pull(((WsXzcfgr) webobject).wfss + "");
                    orgentity.pull(((WsXzcfgr) webobject).wfgd + "");
                    orgentity.pull(((WsXzcfgr) webobject).yjgd + "");
                    orgentity.pull(((WsXzcfgr) webobject).xzcf + "");
                    orgentity.pull(((WsXzcfgr) webobject).fkfs + "");
                    orgentity.pull(((WsXzcfgr) webobject).jz + "");
                    orgentity.pull(((WsXzcfgr) webobject).zh + "");
                    orgentity.pull(((WsXzcfgr) webobject).zf + "");
                    orgentity.pull(((WsXzcfgr) webobject).sqdw + "");
                    orgentity.pull(((WsXzcfgr) webobject).rmfy + "");
                    orgentity.pull(((WsXzcfgr) webobject).zfryy + "");
                    orgentity.pull(((WsXzcfgr) webobject).zfrye + "");
                    orgentity.pull(((WsXzcfgr) webobject).dsr + "");
                    orgentity.pull(((WsXzcfgr) webobject).sj + "");
                    orgentity.pull(((WsXzcfgr) webobject).version + "");
                    orgentity.pull(((WsXzcfgr) webobject).tbsj + "");
                }
                //-------WsXzcfgzs-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfgzs")) {
                    orgentity.pull(((WsXzcfgzs) webobject).pcode + "");
                    orgentity.pull(((WsXzcfgzs) webobject).ycode + "");
                    orgentity.pull(((WsXzcfgzs) webobject).ncode + "");
                    orgentity.pull(((WsXzcfgzs) webobject).cfdw + "");
                    orgentity.pull(((WsXzcfgzs) webobject).wfxw + "");
                    orgentity.pull(((WsXzcfgzs) webobject).gd + "");
                    orgentity.pull(((WsXzcfgzs) webobject).yj + "");
                    orgentity.pull(((WsXzcfgzs) webobject).xzcf + "");
                    orgentity.pull(((WsXzcfgzs) webobject).glbm + "");
                    orgentity.pull(((WsXzcfgzs) webobject).bmdz + "");
                    orgentity.pull(((WsXzcfgzs) webobject).bmlxr + "");
                    orgentity.pull(((WsXzcfgzs) webobject).bmlxdh + "");
                    orgentity.pull(((WsXzcfgzs) webobject).bmyb + "");
                    orgentity.pull(((WsXzcfgzs) webobject).rq + "");
                    orgentity.pull(((WsXzcfgzs) webobject).tbsj + "");
                }
                //-------WsXzcfjdsdw-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfjdsdw")) {
                    orgentity.pull(((WsXzcfjdsdw) webobject).pcode + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).ycode + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).ncode + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).bcfdw + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).dz + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).yb + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).fddbr + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).fddbrzw + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).fddbrlxdh + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).wfsszj + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).gd + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).yj + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).xzcf + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).jz + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).zh + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).rmzf + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).sqdw + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).rmfy + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).rq + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).version + "");
                    orgentity.pull(((WsXzcfjdsdw) webobject).tbsj + "");
                }
                //-------WsXzcfjdsgr-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfjdsgr")) {
                    orgentity.pull(((WsXzcfjdsgr) webobject).pcode + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).ycode + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).ncode + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).bcfr + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).xb + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).nl + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).lxdh + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).jtzz + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).szdw + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).zw + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).dwdz + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).yb + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).wfsszj + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).gd + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).yj + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).xzcf + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).jz + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).zh + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).rmzf + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).sqdw + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).rmfy + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).rq + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).version + "");
                    orgentity.pull(((WsXzcfjdsgr) webobject).tbsj + "");
                }
                //-------WsXzcftljl-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcftljl")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsXzcftljl) webobject).ajmc + "");
                    orgentity.pull(((WsXzcftljl) webobject).tlsjc + "");
                    orgentity.pull(((WsXzcftljl) webobject).tlsjm + "");
                    orgentity.pull(((WsXzcftljl) webobject).dd + "");
                    orgentity.pull(((WsXzcftljl) webobject).zcr + "");
                    orgentity.pull(((WsXzcftljl) webobject).hbr + "");
                    orgentity.pull(((WsXzcftljl) webobject).jlr + "");
                    orgentity.pull(((WsXzcftljl) webobject).cxry + "");
                    orgentity.pull(((WsXzcftljl) webobject).tlnr + "");
                    orgentity.pull(((WsXzcftljl) webobject).tljl + "");
                    orgentity.pull(((WsXzcftljl) webobject).jlxyj + "");
                    orgentity.pull(((WsXzcftljl) webobject).cxrqm + "");
                    orgentity.pull(((WsXzcftljl) webobject).tbsj + "");
                }
                //-------WsYqjnfkpzs-------
                else if (webobject.getClass().getSimpleName().equals("WsYqjnfkpzs")) {
                    orgentity.pull(((WsYqjnfkpzs) webobject).pcode + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).ycode + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).ncode + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).fkdw + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).fkrq + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).wh + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).je + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).jkfs + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).ycjzrq + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).djq + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).fqjzrq + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).fqjnje + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).swjnfk + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).rq + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).version + "");
                    orgentity.pull(((WsYqjnfkpzs) webobject).tbsj + "");
                }
                //-------WsYqjnfkspb-------
                else if (webobject.getClass().getSimpleName().equals("WsYqjnfkspb")) {
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsYqjnfkspb) webobject).ajmc + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).wh + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).dsr + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).dz + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).wfss + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).ly + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).cbryj + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).cbrqm_one + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).cbrqm_two + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).cbrqmrq + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).shyj + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).shrqm + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).shrqmrq + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).spyj + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).sprqm + "");
                    orgentity.pull(((WsYqjnfkspb) webobject).sprqmrq + "");


                }
                //-------WsZgfc-------
                else if (webobject.getClass().getSimpleName().equals("WsZgfc")) {
                    orgentity.pull(((WsZgfc) webobject).pcode + "");
                    orgentity.pull(((WsZgfc) webobject).ycode + "");
                    orgentity.pull(((WsZgfc) webobject).ncode + "");
                    orgentity.pull(((WsZgfc) webobject).bjcdw + "");
                    orgentity.pull(((WsZgfc) webobject).jcsj + "");
                    orgentity.pull(((WsZgfc) webobject).jd + "");
                    orgentity.pull(((WsZgfc) webobject).jpcode + "");
                    orgentity.pull("");
                    orgentity.pull(((WsZgfc) webobject).jycode + "");
                    orgentity.pull(((WsZgfc) webobject).jncode + "");
                    orgentity.pull(((WsZgfc) webobject).yj + "");
                    orgentity.pull(((WsZgfc) webobject).fzr + "");
                    orgentity.pull(((WsZgfc) webobject).zfryy + "");
                    orgentity.pull(((WsZgfc) webobject).zfrye + "");
                    orgentity.pull(((WsZgfc) webobject).zhy + "");
                    orgentity.pull(((WsZgfc) webobject).zhe + "");
                    orgentity.pull(((WsZgfc) webobject).sj + "");
                    orgentity.pull(((WsZgfc) webobject).dfzh + "");
                    orgentity.pull(((WsZgfc) webobject).tbsj + "");
                }
                //-------WsZlxqzg-------
                else if (webobject.getClass().getSimpleName().equals("WsZlxqzg")) {
                    orgentity.pull(((WsZlxqzg) webobject).pcode + "");
                    orgentity.pull(((WsZlxqzg) webobject).ycode + "");
                    orgentity.pull(((WsZlxqzg) webobject).ncode + "");
                    orgentity.pull(((WsZlxqzg) webobject).bjcdw + "");
                    orgentity.pull(((WsZlxqzg) webobject).wtOne + "");
                    orgentity.pull(((WsZlxqzg) webobject).wtTwo + "");
                    orgentity.pull(((WsZlxqzg) webobject).wtThree + "");
                    orgentity.pull(((WsZlxqzg) webobject).wtFour + "");
                    orgentity.pull(((WsZlxqzg) webobject).djx + "");
                    orgentity.pull(((WsZlxqzg) webobject).zgrq + "");
                    orgentity.pull(((WsZlxqzg) webobject).rmzf + "");
                    orgentity.pull(((WsZlxqzg) webobject).sqdw + "");
                    orgentity.pull(((WsZlxqzg) webobject).rmfy + "");
                    orgentity.pull(((WsZlxqzg) webobject).zfryqmOne + "");
                    orgentity.pull(((WsZlxqzg) webobject).zfryqmTwo + "");
                    orgentity.pull(((WsZlxqzg) webobject).zhOne + "");
                    orgentity.pull(((WsZlxqzg) webobject).zhTwo + "");
                    orgentity.pull(((WsZlxqzg) webobject).fzrqm + "");
                    orgentity.pull(((WsZlxqzg) webobject).sj + "");
                    orgentity.pull(((WsZlxqzg) webobject).dfzh + "");
                    orgentity.pull(((WsZlxqzg) webobject).tbsj + "");
                }
                //-------WsCyqzpz-------
                else if (webobject.getClass().getSimpleName().equals("WsCyqzpz")) {
                    //------WsCyqzpz-Entity_Book4-------


                    orgentity.pull(((WsCyqzpz) webobject).pcode + "");
                    orgentity.pull(((WsCyqzpz) webobject).ycode + "");
                    orgentity.pull(((WsCyqzpz) webobject).ncode + "");
                    orgentity.pull(((WsCyqzpz) webobject).bcydw + "");
                    orgentity.pull(((WsCyqzpz) webobject).xcfzr + "");
                    orgentity.pull(((WsCyqzpz) webobject).dwdz + "");
                    orgentity.pull(((WsCyqzpz) webobject).lxdh + "");
                    orgentity.pull(((WsCyqzpz) webobject).yb + "");
                    orgentity.pull(((WsCyqzpz) webobject).cysjc + "");
                    orgentity.pull(((WsCyqzpz) webobject).cysjm + "");
                    orgentity.pull(((WsCyqzpz) webobject).cydd + "");
                    orgentity.pull(((WsCyqzpz) webobject).cyqzList + "");
                    orgentity.pull(((WsCyqzpz) webobject).xcfzrqm + "");
                    orgentity.pull(((WsCyqzpz) webobject).zfryqmOne + "");
                    orgentity.pull(((WsCyqzpz) webobject).zfryzhOne + "");
                    orgentity.pull(((WsCyqzpz) webobject).zfryqmTwo + "");
                    orgentity.pull(((WsCyqzpz) webobject).zfryzhTwo + "");
                    orgentity.pull(((WsCyqzpz) webobject).rq + "");

                }
                //-------WsJdwts-------
                else if (webobject.getClass().getSimpleName().equals("WsJdwts")) {
                    //------WsJdwts-Entity_Book14-------

                    orgentity.pull(((WsJdwts) webobject).pcode + "");
                    orgentity.pull(((WsJdwts) webobject).ycode + "");
                    orgentity.pull(((WsJdwts) webobject).ncode + "");
                    orgentity.pull(((WsJdwts) webobject).wtdw + "");
                    orgentity.pull(((WsJdwts) webobject).jdwtsList + "");
                    orgentity.pull(((WsJdwts) webobject).jdyq + "");
                    orgentity.pull(((WsJdwts) webobject).jzsj + "");
                    orgentity.pull(((WsJdwts) webobject).rq + "");
                }
                //-------WsJnml-------
                else if (webobject.getClass().getSimpleName().equals("WsJnml")) {
                    //------WsJnml-Entity_Book36-------
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull("");
                    orgentity.pull(((WsJnml) webobject).jnmlList + "");

                }
                //-------WsSdhz-------
                else if (webobject.getClass().getSimpleName().equals("WsSdhz")) {
                    //------WsSdhz-Entity_Book30-------

                    orgentity.pull(((WsSdhz) webobject).pcode + "");
                    orgentity.pull(((WsSdhz) webobject).ycode + "");
                    orgentity.pull(((WsSdhz) webobject).ncode + "");
                    orgentity.pull(((WsSdhz) webobject).ajmc + "");
                    orgentity.pull(((WsSdhz) webobject).ssddw + "");
                    orgentity.pull(((WsSdhz) webobject).sdhzList + "");
                    orgentity.pull(((WsSdhz) webobject).bz + "");
                }



            }
        }
        return orgentity;
    }
}
interface IConvertPrintkm {

    /**
     * 将bookentity转化为网络端的webobject
     * @param bookentity 用户app端打印展现用的实体类
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public  Object bookentity2webobject(Object bookentity) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    /**
     * 将网络端的webobject转化为bookentity
     * @param webobject  从web端解析到的实体类
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public DateBase_Entity webobject2bookentity(Object webobject) throws InstantiationException, IllegalAccessException, ClassNotFoundException;


}