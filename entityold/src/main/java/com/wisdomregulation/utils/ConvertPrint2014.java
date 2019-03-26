package com.wisdomregulation.utils;

import com.ay.ydzf.zhifawenshu.pojo2014.*;
import com.wisdomregulation.data.entitybase.DateBase_Entity;
import com.wisdomregulation.staticlib.Static_BookLib;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by King6rf on 2017/4/25.
 */
public class ConvertPrint2014 implements IConvertPrint2014 {
    private static final ConvertPrint2014 CONVERT_PRINT = new ConvertPrint2014();

    private ConvertPrint2014() {

    }

    public static ConvertPrint2014 getInstance() {
        return CONVERT_PRINT;
    }

    @Override
    public Object bookentity2webobject(DateBase_Entity bookentity) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object webobject = null;
        int index = Integer.parseInt(bookentity.getClass().getSimpleName().replace("Entity_Book", ""));
        String webobjectname = Static_BookLib.WEBBOOKNAME[index];
        webobject = Class.forName("com.ay.ydzf.zhifawenshu.pojo2014." + webobjectname).newInstance();
        if (webobjectname.equals("WsAjsy")) {
            ((WsAjsy) webobject).glj = bookentity.push();
            ((WsAjsy) webobject).pcode = bookentity.push();
            ((WsAjsy) webobject).ycode = bookentity.push();
            ((WsAjsy) webobject).ncode = bookentity.push();
            ((WsAjsy) webobject).ajmc = bookentity.push();
            ((WsAjsy) webobject).ay = bookentity.push();
            ((WsAjsy) webobject).cljg = bookentity.push();
            ((WsAjsy) webobject).larq = bookentity.push();
            ((WsAjsy) webobject).jarq = bookentity.push();
            ((WsAjsy) webobject).cbrqm_one = bookentity.push();
            ((WsAjsy) webobject).cbrqm_two = bookentity.push();
            ((WsAjsy) webobject).gdrq = bookentity.push();
            ((WsAjsy) webobject).gdh = bookentity.push();
            ((WsAjsy) webobject).bcqx = bookentity.push();
            ((WsAjsy) webobject).rq = bookentity.push();
            ((WsAjsy) webobject).version = bookentity.push();
            ((WsAjsy) webobject).tbsj = bookentity.push();
        }
        //-------WsAjclcp-------("案件处理呈批表")
        else if(webobjectname.equals("WsAjclcp")){
            //("地方")
            ((WsAjclcp) webobject).pcode= bookentity.push();
            //("字")
            ((WsAjclcp) webobject).ycode= bookentity.push();
            //("号")
            ((WsAjclcp) webobject).ncode= bookentity.push();
            //("案件名称")
            ((WsAjclcp) webobject).ajmc= bookentity.push();
            //("被处罚单位")
            ((WsAjclcp) webobject).bcfdw= bookentity.push();
            //("地址")
            ((WsAjclcp) webobject).dz= bookentity.push();
            //("法定代表人")
            ((WsAjclcp) webobject).fddbr= bookentity.push();
            //("职务")
            ((WsAjclcp) webobject).zw= bookentity.push();
            //("单位邮编")
            ((WsAjclcp) webobject).dwyb= bookentity.push();
            //("被处罚人")
            ((WsAjclcp) webobject).bcfr= bookentity.push();
            //("年龄")
            ((WsAjclcp) webobject).nl= bookentity.push();
            //("性别")
            ((WsAjclcp) webobject).xb= bookentity.push();
            //("所在单位")
            ((WsAjclcp) webobject).szdw= bookentity.push();
            //("单位地址")
            ((WsAjclcp) webobject).dwdz= bookentity.push();
            //("家庭住址")
            ((WsAjclcp) webobject).jtzz= bookentity.push();
            //("联系电话")
            ((WsAjclcp) webobject).lxdh= bookentity.push();
            //("家庭邮编")
            ((WsAjclcp) webobject).jtyb= bookentity.push();
            //("违法事实及处罚依据")
            ((WsAjclcp) webobject).wfss= bookentity.push();
            //("当事人申辩意见")
            ((WsAjclcp) webobject).dsrsbyj= bookentity.push();
            //("承办人意见")
            ((WsAjclcp) webobject).cbryj= bookentity.push();
            //("承办人签名1")
            ((WsAjclcp) webobject).cbrqmy= bookentity.push();
            //("承办人签名2")
            ((WsAjclcp) webobject).cbrqme= bookentity.push();
            //("承办人签名时间")
            ((WsAjclcp) webobject).cbrqmsj= bookentity.push();
            //("审核意见")
            ((WsAjclcp) webobject).shyj= bookentity.push();
            //("审核人签名")
            ((WsAjclcp) webobject).shrqm= bookentity.push();
            //("审核时间")
            ((WsAjclcp) webobject).shsj= bookentity.push();
            //("审批意见")
            ((WsAjclcp) webobject).spyj= bookentity.push();
            //("审批人签名")
            ((WsAjclcp) webobject).sprqm= bookentity.push();
            //("审批时间")
            ((WsAjclcp) webobject).spsj= bookentity.push();
        }
        //-------WsAjyss-------
        else if (webobjectname.equals("WsAjyss")) {
            ((WsAjyss) webobject).pcode = bookentity.push();
            ((WsAjyss) webobject).ycode = bookentity.push();
            ((WsAjyss) webobject).ncode = bookentity.push();
            ((WsAjyss) webobject).ysdw = bookentity.push();
            ((WsAjyss) webobject).larq = bookentity.push();
            ((WsAjyss) webobject).aj = bookentity.push();
            ((WsAjyss) webobject).fx = bookentity.push();
            ((WsAjyss) webobject).gd = bookentity.push();
            ((WsAjyss) webobject).cl = bookentity.push();
            ((WsAjyss) webobject).jf = bookentity.push();
            ((WsAjyss) webobject).jy = bookentity.push();
            ((WsAjyss) webobject).rq = bookentity.push();
            ((WsAjyss) webobject).version = bookentity.push();
            ((WsAjyss) webobject).tbsj = bookentity.push();
        }
        //-------WsAjysspb-------
        else if (webobjectname.equals("WsAjysspb")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsAjysspb) webobject).ajmc = bookentity.push();
            ((WsAjysspb) webobject).dsr = bookentity.push();
            ((WsAjysspb) webobject).dz = bookentity.push();
            ((WsAjysspb) webobject).sysjg = bookentity.push();
            ((WsAjysspb) webobject).aqjj = bookentity.push();
            ((WsAjysspb) webobject).ysly = bookentity.push();
            ((WsAjysspb) webobject).cbryj = bookentity.push();
            ((WsAjysspb) webobject).cbrqm_one = bookentity.push();
            ((WsAjysspb) webobject).cbrqm_two = bookentity.push();
            ((WsAjysspb) webobject).cbrqmrq = bookentity.push();
            ((WsAjysspb) webobject).shyj = bookentity.push();
            ((WsAjysspb) webobject).shrqm = bookentity.push();
            ((WsAjysspb) webobject).shrqmrq = bookentity.push();
            ((WsAjysspb) webobject).spyj = bookentity.push();
            ((WsAjysspb) webobject).sprqm = bookentity.push();
            ((WsAjysspb) webobject).sprqmrq = bookentity.push();
            ((WsAjysspb) webobject).version = bookentity.push();
            ((WsAjysspb) webobject).tbsj = bookentity.push();
        }
        //-------WsDsrcssbbl-------
        else if (webobjectname.equals("WsDsrcssbbl")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsDsrcssbbl) webobject).sjc = bookentity.push();
            ((WsDsrcssbbl) webobject).sjm = bookentity.push();
            ((WsDsrcssbbl) webobject).dd = bookentity.push();
            ((WsDsrcssbbl) webobject).cssbr = bookentity.push();
            ((WsDsrcssbbl) webobject).sbrxb = bookentity.push();
            ((WsDsrcssbbl) webobject).sbrzw = bookentity.push();
            ((WsDsrcssbbl) webobject).sbrdw = bookentity.push();
            ((WsDsrcssbbl) webobject).sbrdh = bookentity.push();
            ((WsDsrcssbbl) webobject).sbrlxdz = bookentity.push();
            ((WsDsrcssbbl) webobject).sbryb = bookentity.push();
            ((WsDsrcssbbl) webobject).cbr = bookentity.push();
            ((WsDsrcssbbl) webobject).jlr = bookentity.push();
            ((WsDsrcssbbl) webobject).glj = bookentity.push();
            ((WsDsrcssbbl) webobject).zfryOne = bookentity.push();
            ((WsDsrcssbbl) webobject).zfryTwo = bookentity.push();
            ((WsDsrcssbbl) webobject).zfryzhOne = bookentity.push();
            ((WsDsrcssbbl) webobject).zfryzhTwo = bookentity.push();
            ((WsDsrcssbbl) webobject).aj = bookentity.push();
            ((WsDsrcssbbl) webobject).cssbjl = bookentity.push();
            ((WsDsrcssbbl) webobject).cssbrqm = bookentity.push();
            ((WsDsrcssbbl) webobject).cbrqm = bookentity.push();
            ((WsDsrcssbbl) webobject).jlrqm = bookentity.push();
            ((WsDsrcssbbl) webobject).rq = bookentity.push();
            ((WsDsrcssbbl) webobject).tbsj = bookentity.push();
        }
        //-------WsFkcjtzs-------
        else if (webobjectname.equals("WsFkcjtzs")) {
            ((WsFkcjtzs) webobject).pcode = bookentity.push();
            ((WsFkcjtzs) webobject).ycode = bookentity.push();
            ((WsFkcjtzs) webobject).ncode = bookentity.push();
            ((WsFkcjtzs) webobject).fkdw = bookentity.push();
            ((WsFkcjtzs) webobject).fkrq = bookentity.push();
            ((WsFkcjtzs) webobject).fkh = bookentity.push();
            ((WsFkcjtzs) webobject).jkrq = bookentity.push();
            ((WsFkcjtzs) webobject).jkc = bookentity.push();
            ((WsFkcjtzs) webobject).rq = bookentity.push();
            ((WsFkcjtzs) webobject).version = bookentity.push();
            ((WsFkcjtzs) webobject).tbsj = bookentity.push();
        }
        //-------WsJaspb-------
        else if (webobjectname.equals("WsJaspb")) {
            ((WsJaspb) webobject).pcode = bookentity.push();
            ((WsJaspb) webobject).ycode = bookentity.push();
            ((WsJaspb) webobject).ncode = bookentity.push();
            ((WsJaspb) webobject).ajmc = bookentity.push();
            ((WsJaspb) webobject).bcfdw = bookentity.push();
            ((WsJaspb) webobject).bcfdwdz = bookentity.push();
            ((WsJaspb) webobject).fddbr = bookentity.push();
            ((WsJaspb) webobject).fddbrzw = bookentity.push();
            ((WsJaspb) webobject).fddbryb = bookentity.push();
            ((WsJaspb) webobject).bcfr = bookentity.push();
            ((WsJaspb) webobject).bcfrnl = bookentity.push();
            ((WsJaspb) webobject).bcfrxb = bookentity.push();
            ((WsJaspb) webobject).bcfrdw = bookentity.push();
            ((WsJaspb) webobject).bcfrdwzz = bookentity.push();
            ((WsJaspb) webobject).bcfrjtzz = bookentity.push();
            ((WsJaspb) webobject).bcfrlxdh = bookentity.push();
            ((WsJaspb) webobject).bcfryb = bookentity.push();
            ((WsJaspb) webobject).cljg = bookentity.push();
            ((WsJaspb) webobject).zxqk = bookentity.push();
            ((WsJaspb) webobject).cbrqm_one = bookentity.push();
            ((WsJaspb) webobject).cbrqm_two = bookentity.push();
            ((WsJaspb) webobject).cbrqmrq = bookentity.push();
            ((WsJaspb) webobject).shyj = bookentity.push();
            ((WsJaspb) webobject).shrqm = bookentity.push();
            ((WsJaspb) webobject).shrqmrq = bookentity.push();
            ((WsJaspb) webobject).spyj = bookentity.push();
            ((WsJaspb) webobject).sprqm = bookentity.push();
            ((WsJaspb) webobject).sprqmrq = bookentity.push();
            ((WsJaspb) webobject).version = bookentity.push();
            ((WsJaspb) webobject).tbsj = bookentity.push();
        }
        //-------WsKybl-------
        else if (webobjectname.equals("WsKybl")) {
            ((WsKybl) webobject).pcode = bookentity.push();
            ((WsKybl) webobject).ycode = bookentity.push();
            ((WsKybl) webobject).ncode = bookentity.push();
            ((WsKybl) webobject).kysjc = bookentity.push();
            ((WsKybl) webobject).kysjm = bookentity.push();
            ((WsKybl) webobject).kycs = bookentity.push();
            ((WsKybl) webobject).tqqk = bookentity.push();
            ((WsKybl) webobject).kyrOne = bookentity.push();
            ((WsKybl) webobject).kyrzwOne = bookentity.push();
            ((WsKybl) webobject).kyrTwo = bookentity.push();
            ((WsKybl) webobject).kyrzwTwo = bookentity.push();
            ((WsKybl) webobject).dsrOne = bookentity.push();
            ((WsKybl) webobject).dsrzwOne = bookentity.push();
            ((WsKybl) webobject).dsrTwo = bookentity.push();
            ((WsKybl) webobject).dsrzwTwo = bookentity.push();
            ((WsKybl) webobject).byqr = bookentity.push();
            ((WsKybl) webobject).byqrzw = bookentity.push();
            ((WsKybl) webobject).jlr = bookentity.push();
            ((WsKybl) webobject).jlrzw = bookentity.push();
            ((WsKybl) webobject).glj = bookentity.push();
            ((WsKybl) webobject).zfryOne = bookentity.push();
            ((WsKybl) webobject).zfryTwo = bookentity.push();
            ((WsKybl) webobject).zhOne = bookentity.push();
            ((WsKybl) webobject).zhTwo = bookentity.push();
            ((WsKybl) webobject).kyqk = bookentity.push();
            ((WsKybl) webobject).kyrqmOne = bookentity.push();
            ((WsKybl) webobject).kyrqmTwo = bookentity.push();
            ((WsKybl) webobject).dsrqmOne = bookentity.push();
            ((WsKybl) webobject).dsrlxdhOne = bookentity.push();
            ((WsKybl) webobject).dsrqmTwo = bookentity.push();
            ((WsKybl) webobject).dsrlxdhTwo = bookentity.push();
            ((WsKybl) webobject).byqrqm = bookentity.push();
            ((WsKybl) webobject).byqrlxdh = bookentity.push();
            ((WsKybl) webobject).tbsj = bookentity.push();
        }
        //-------WsLasp-------
        else if (webobjectname.equals("WsLasp")) {
            ((WsLasp) webobject).pcode = bookentity.push();
            ((WsLasp) webobject).ycode = bookentity.push();
            ((WsLasp) webobject).ncode = bookentity.push();
            ((WsLasp) webobject).ay = bookentity.push();
            ((WsLasp) webobject).ajly = bookentity.push();
            ((WsLasp) webobject).sj = bookentity.push();
            ((WsLasp) webobject).ajmc = bookentity.push();
            ((WsLasp) webobject).dsr = bookentity.push();
            ((WsLasp) webobject).dh = bookentity.push();
            ((WsLasp) webobject).dsrqk = bookentity.push();
            ((WsLasp) webobject).dsrdz = bookentity.push();
            ((WsLasp) webobject).yzbm = bookentity.push();
            ((WsLasp) webobject).ajqk = bookentity.push();
            ((WsLasp) webobject).cbryj = bookentity.push();
            ((WsLasp) webobject).cbrqzy = bookentity.push();
            ((WsLasp) webobject).zhy = bookentity.push();
            ((WsLasp) webobject).cbrqze = bookentity.push();
            ((WsLasp) webobject).zhe = bookentity.push();
            ((WsLasp) webobject).cbsj = bookentity.push();
            ((WsLasp) webobject).shyj = bookentity.push();
            ((WsLasp) webobject).shre = bookentity.push();
            ((WsLasp) webobject).shsj = bookentity.push();
            ((WsLasp) webobject).spyj = bookentity.push();
            ((WsLasp) webobject).spr = bookentity.push();
            ((WsLasp) webobject).spsj = bookentity.push();
            ((WsLasp) webobject).version = bookentity.push();
            ((WsLasp) webobject).tbsj = bookentity.push();
        }
        //-------WsQzcs-------
        else if (webobjectname.equals("WsQzcs")) {
            ((WsQzcs) webobject).pcode = bookentity.push();
            ((WsQzcs) webobject).ycode = bookentity.push();
            ((WsQzcs) webobject).ncode = bookentity.push();
            ((WsQzcs) webobject).bjcdw = bookentity.push();
            ((WsQzcs) webobject).wt = bookentity.push();
            ((WsQzcs) webobject).yj = bookentity.push();
            ((WsQzcs) webobject).qzcs = bookentity.push();
            ((WsQzcs) webobject).rmzf = bookentity.push();
            ((WsQzcs) webobject).sqdw = bookentity.push();
            ((WsQzcs) webobject).rmfy = bookentity.push();
            ((WsQzcs) webobject).sj = bookentity.push();
            ((WsQzcs) webobject).dfzh = bookentity.push();
            ((WsQzcs) webobject).tbsj = bookentity.push();
        }
        //-------WsQzzxsqs-------
        else if (webobjectname.equals("WsQzzxsqs")) {
            ((WsQzzxsqs) webobject).pcode = bookentity.push();
            ((WsQzzxsqs) webobject).ycode = bookentity.push();
            ((WsQzzxsqs) webobject).ncode = bookentity.push();
            ((WsQzzxsqs) webobject).rmfy = bookentity.push();
            ((WsQzzxsqs) webobject).cfrq = bookentity.push();
            ((WsQzzxsqs) webobject).sqzxr = bookentity.push();
            ((WsQzzxsqs) webobject).cfjd = bookentity.push();
            ((WsQzzxsqs) webobject).wh = bookentity.push();
            ((WsQzzxsqs) webobject).ygcl = bookentity.push();
            ((WsQzzxsqs) webobject).rq = bookentity.push();
            ((WsQzzxsqs) webobject).lxr = bookentity.push();
            ((WsQzzxsqs) webobject).lxdh = bookentity.push();
            ((WsQzzxsqs) webobject).version = bookentity.push();
            ((WsQzzxsqs) webobject).tbsj = bookentity.push();
        }
        //-------WsTzbl-------
        else if (webobjectname.equals("WsTzbl")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsTzbl) webobject).ajmc = bookentity.push();
            ((WsTzbl) webobject).zctzjg = bookentity.push();
            ((WsTzbl) webobject).dd = bookentity.push();
            ((WsTzbl) webobject).tzsjc = bookentity.push();
            ((WsTzbl) webobject).tzsjm = bookentity.push();
            ((WsTzbl) webobject).tzzcr = bookentity.push();
            ((WsTzbl) webobject).tzy = bookentity.push();
            ((WsTzbl) webobject).sjy = bookentity.push();
            ((WsTzbl) webobject).dcryOne = bookentity.push();
            ((WsTzbl) webobject).dcryzhOne = bookentity.push();
            ((WsTzbl) webobject).dcryTwo = bookentity.push();
            ((WsTzbl) webobject).dcryzhTwo = bookentity.push();
            ((WsTzbl) webobject).fddbrxm = bookentity.push();
            ((WsTzbl) webobject).fddbrxb = bookentity.push();
            ((WsTzbl) webobject).fddbrnl = bookentity.push();
            ((WsTzbl) webobject).gzdwzw = bookentity.push();
            ((WsTzbl) webobject).wtdlrOne = bookentity.push();
            ((WsTzbl) webobject).wtdlrxbOne = bookentity.push();
            ((WsTzbl) webobject).wtdlrnlOne = bookentity.push();
            ((WsTzbl) webobject).wtdlrdwOne = bookentity.push();
            ((WsTzbl) webobject).wtdlrTwo = bookentity.push();
            ((WsTzbl) webobject).wtdlrxbTwo = bookentity.push();
            ((WsTzbl) webobject).wtdlrnlTwo = bookentity.push();
            ((WsTzbl) webobject).wtdlrdwTwo = bookentity.push();
            ((WsTzbl) webobject).dsr = bookentity.push();
            ((WsTzbl) webobject).qtcyry = bookentity.push();
            ((WsTzbl) webobject).tzjl = bookentity.push();
            ((WsTzbl) webobject).dbrqm = bookentity.push();
            ((WsTzbl) webobject).zcrqm = bookentity.push();
            ((WsTzbl) webobject).sjyqm = bookentity.push();
            ((WsTzbl) webobject).rq = bookentity.push();
            ((WsTzbl) webobject).tbsj = bookentity.push();
        }
        //-------WsTzgzs-------
        else if (webobjectname.equals("WsTzgzs")) {
            ((WsTzgzs) webobject).pcode = bookentity.push();
            ((WsTzgzs) webobject).ycode = bookentity.push();
            ((WsTzgzs) webobject).ncode = bookentity.push();
            ((WsTzgzs) webobject).cfdw = bookentity.push();
            ((WsTzgzs) webobject).wfxw = bookentity.push();
            ((WsTzgzs) webobject).gd = bookentity.push();
            ((WsTzgzs) webobject).yj = bookentity.push();
            ((WsTzgzs) webobject).xzcf = bookentity.push();
            ((WsTzgzs) webobject).glbm = bookentity.push();
            ((WsTzgzs) webobject).bmdz = bookentity.push();
            ((WsTzgzs) webobject).bmlxr = bookentity.push();
            ((WsTzgzs) webobject).bmlxdh = bookentity.push();
            ((WsTzgzs) webobject).bmyb = bookentity.push();
            ((WsTzgzs) webobject).rq = bookentity.push();
            ((WsTzgzs) webobject).tbsj = bookentity.push();
        }
        //-------WsTzhbg-------
        else if (webobjectname.equals("WsTzhbg")) {
            ((WsTzhbg) webobject).pcode = bookentity.push();
            ((WsTzhbg) webobject).ycode = bookentity.push();
            ((WsTzhbg) webobject).ncode = bookentity.push();
            ((WsTzhbg) webobject).ajmc = bookentity.push();
            ((WsTzhbg) webobject).tzzcr = bookentity.push();
            ((WsTzhbg) webobject).tzy = bookentity.push();
            ((WsTzhbg) webobject).sjy = bookentity.push();
            ((WsTzhbg) webobject).zy = bookentity.push();
            ((WsTzhbg) webobject).tzzcryj = bookentity.push();
            ((WsTzhbg) webobject).tzzcrqm = bookentity.push();
            ((WsTzhbg) webobject).tzzcrqmrq = bookentity.push();
            ((WsTzhbg) webobject).fzrshyj = bookentity.push();
            ((WsTzhbg) webobject).fzrqm = bookentity.push();
            ((WsTzhbg) webobject).fzrqmrq = bookentity.push();
            ((WsTzhbg) webobject).tbsj = bookentity.push();
        }
        //-------WsTzhtzs-------
        else if (webobjectname.equals("WsTzhtzs")) {
            ((WsTzhtzs) webobject).pcode = bookentity.push();
            ((WsTzhtzs) webobject).ycode = bookentity.push();
            ((WsTzhtzs) webobject).ncode = bookentity.push();
            ((WsTzhtzs) webobject).cfdw = bookentity.push();
            ((WsTzhtzs) webobject).aj = bookentity.push();
            ((WsTzhtzs) webobject).sj = bookentity.push();
            ((WsTzhtzs) webobject).hydd = bookentity.push();
            ((WsTzhtzs) webobject).zcrxm = bookentity.push();
            ((WsTzhtzs) webobject).zcrzw = bookentity.push();
            ((WsTzhtzs) webobject).tzyxmOne = bookentity.push();
            ((WsTzhtzs) webobject).tzyzwOne = bookentity.push();
            ((WsTzhtzs) webobject).tzyxmTwo = bookentity.push();
            ((WsTzhtzs) webobject).tzyzwTwo = bookentity.push();
            ((WsTzhtzs) webobject).sjyxm = bookentity.push();
            ((WsTzhtzs) webobject).sjyzw = bookentity.push();
            ((WsTzhtzs) webobject).rq = bookentity.push();
            ((WsTzhtzs) webobject).bmdz = bookentity.push();
            ((WsTzhtzs) webobject).bmlxr = bookentity.push();
            ((WsTzhtzs) webobject).bmlxdh = bookentity.push();
            ((WsTzhtzs) webobject).bmyb = bookentity.push();

        }
        //-------WsXcclcs-------
        else if (webobjectname.equals("WsXcclcs")) {
            ((WsXcclcs) webobject).pcode = bookentity.push();
            ((WsXcclcs) webobject).ycode = bookentity.push();
            ((WsXcclcs) webobject).ncode = bookentity.push();
            ((WsXcclcs) webobject).bjcdw = bookentity.push();
            ((WsXcclcs) webobject).jcrq = bookentity.push();
            ((WsXcclcs) webobject).sgyhOne = bookentity.push();
            ((WsXcclcs) webobject).sgyhTwo = bookentity.push();
            ((WsXcclcs) webobject).sgyhThree = bookentity.push();
            ((WsXcclcs) webobject).yj = bookentity.push();
            ((WsXcclcs) webobject).jdOne = bookentity.push();
            ((WsXcclcs) webobject).jdTwo = bookentity.push();
            ((WsXcclcs) webobject).jdThree = bookentity.push();
            ((WsXcclcs) webobject).rmzf = bookentity.push();
            ((WsXcclcs) webobject).sqdw = bookentity.push();
            ((WsXcclcs) webobject).rmfy = bookentity.push();
            ((WsXcclcs) webobject).zfryqmOne = bookentity.push();
            ((WsXcclcs) webobject).zfryqmTwo = bookentity.push();
            ((WsXcclcs) webobject).zhOne = bookentity.push();
            ((WsXcclcs) webobject).zhTwo = bookentity.push();
            ((WsXcclcs) webobject).fzrqm = bookentity.push();
            ((WsXcclcs) webobject).sj = bookentity.push();
            ((WsXcclcs) webobject).dfzh = bookentity.push();
            ((WsXcclcs) webobject).tbsj = bookentity.push();
        }
        //-------WsXcjc-------
        else if (webobjectname.equals("WsXcjc")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsXcjc) webobject).bjcdw = bookentity.push();
            ((WsXcjc) webobject).dz = bookentity.push();
            ((WsXcjc) webobject).fzr = bookentity.push();
            ((WsXcjc) webobject).zw = bookentity.push();
            ((WsXcjc) webobject).lxdh = bookentity.push();
            ((WsXcjc) webobject).jccs = bookentity.push();
            ((WsXcjc) webobject).jcsjc = bookentity.push();
            ((WsXcjc) webobject).jcsjm = bookentity.push();
            ((WsXcjc) webobject).glj = bookentity.push();
            ((WsXcjc) webobject).zfryy = bookentity.push();
            ((WsXcjc) webobject).zfrye = bookentity.push();
            ((WsXcjc) webobject).zjhmy = bookentity.push();
            ((WsXcjc) webobject).zjhme = bookentity.push();
            ((WsXcjc) webobject).jcqk = bookentity.push();
            ((WsXcjc) webobject).jcryqmy = bookentity.push();
            ((WsXcjc) webobject).jcryqme = bookentity.push();
            ((WsXcjc) webobject).bjcfzr = bookentity.push();
            ((WsXcjc) webobject).sj = bookentity.push();
            ((WsXcjc) webobject).tbsj = bookentity.push();
        }
        //-------WsXwbl-------
        else if (webobjectname.equals("WsXwbl")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsXwbl) webobject).xwsjc = bookentity.push();
            ((WsXwbl) webobject).xwsjm = bookentity.push();
            ((WsXwbl) webobject).xwcs = bookentity.push();
            ((WsXwbl) webobject).xwdd = bookentity.push();
            ((WsXwbl) webobject).bxwrxm = bookentity.push();
            ((WsXwbl) webobject).bxwrxb = bookentity.push();
            ((WsXwbl) webobject).bxwrnl = bookentity.push();
            ((WsXwbl) webobject).bxwrzjh = bookentity.push();
            ((WsXwbl) webobject).bxwrdw = bookentity.push();
            ((WsXwbl) webobject).bxwrzw = bookentity.push();
            ((WsXwbl) webobject).bxwrzz = bookentity.push();
            ((WsXwbl) webobject).bxwrdh = bookentity.push();
            ((WsXwbl) webobject).xwr = bookentity.push();
            ((WsXwbl) webobject).xwrdwzw = bookentity.push();
            ((WsXwbl) webobject).jlr = bookentity.push();
            ((WsXwbl) webobject).jlrdwzw = bookentity.push();
            ((WsXwbl) webobject).zcr = bookentity.push();
            ((WsXwbl) webobject).glj = bookentity.push();
            ((WsXwbl) webobject).zfryOne = bookentity.push();
            ((WsXwbl) webobject).zfryTwo = bookentity.push();
            ((WsXwbl) webobject).zhOne = bookentity.push();
            ((WsXwbl) webobject).zhTwo = bookentity.push();
            ((WsXwbl) webobject).wt = bookentity.push();
            ((WsXwbl) webobject).xwjl = bookentity.push();
            ((WsXwbl) webobject).xwrqm = bookentity.push();
            ((WsXwbl) webobject).jlrqm = bookentity.push();
            ((WsXwbl) webobject).bxwrqm = bookentity.push();
            ((WsXwbl) webobject).rq = bookentity.push();
            ((WsXwbl) webobject).tbsj = bookentity.push();
        }
        //-------WsXwtz-------
        else if (webobjectname.equals("WsXwtz")) {
            ((WsXwtz) webobject).pcode = bookentity.push();
            ((WsXwtz) webobject).ycode = bookentity.push();
            ((WsXwtz) webobject).ncode = bookentity.push();
            ((WsXwtz) webobject).bjcr = bookentity.push();
            ((WsXwtz) webobject).yy = bookentity.push();
            ((WsXwtz) webobject).xwsj = bookentity.push();
            ((WsXwtz) webobject).xwdd = bookentity.push();
            ((WsXwtz) webobject).cllb = bookentity.push();
            ((WsXwtz) webobject).zdycl = bookentity.push();
            ((WsXwtz) webobject).glbmdz = bookentity.push();
            ((WsXwtz) webobject).lxr = bookentity.push();
            ((WsXwtz) webobject).lxdh = bookentity.push();
            ((WsXwtz) webobject).sj = bookentity.push();
            ((WsXwtz) webobject).version = bookentity.push();
            ((WsXwtz) webobject).tbsj = bookentity.push();
        }
        //-------WsXxdjbc-------
        else if (webobjectname.equals("WsXxdjbc")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsXxdjbc) webobject).ajmc = bookentity.push();
            ((WsXxdjbc) webobject).dsrjbqk = bookentity.push();
            ((WsXxdjbc) webobject).ajjbqk = bookentity.push();
            ((WsXxdjbc) webobject).zjmcjsl = bookentity.push();
            ((WsXxdjbc) webobject).tqlyjyj = bookentity.push();
            ((WsXxdjbc) webobject).bcfs = bookentity.push();
            ((WsXxdjbc) webobject).cbryj = bookentity.push();
            ((WsXxdjbc) webobject).cbrqm = bookentity.push();
            ((WsXxdjbc) webobject).cbrsj = bookentity.push();
            ((WsXxdjbc) webobject).bmfzryj = bookentity.push();
            ((WsXxdjbc) webobject).bmfzrqm = bookentity.push();
            ((WsXxdjbc) webobject).bmfzrsj = bookentity.push();
            ((WsXxdjbc) webobject).jgfzryj = bookentity.push();
            ((WsXxdjbc) webobject).jgfzrqm = bookentity.push();
            ((WsXxdjbc) webobject).jgfzrsj = bookentity.push();
            ((WsXxdjbc) webobject).tbsj = bookentity.push();
        }
        //-------WsXxdjcljds-------
        else if (webobjectname.equals("WsXxdjcljds")) {
            ((WsXxdjcljds) webobject).pcode = bookentity.push();
            ((WsXxdjcljds) webobject).ycode = bookentity.push();
            ((WsXxdjcljds) webobject).ncode = bookentity.push();
            ((WsXxdjcljds) webobject).bdjdw = bookentity.push();
            ((WsXxdjcljds) webobject).djrq = bookentity.push();
            ((WsXxdjcljds) webobject).djwp = bookentity.push();
            ((WsXxdjcljds) webobject).jpcode = bookentity.push();
            ((WsXxdjcljds) webobject).jycode = bookentity.push();
            ((WsXxdjcljds) webobject).jncode = bookentity.push();
            ((WsXxdjcljds) webobject).cl = bookentity.push();
            ((WsXxdjcljds) webobject).rmzf = bookentity.push();
            ((WsXxdjcljds) webobject).sqdw = bookentity.push();
            ((WsXxdjcljds) webobject).rmfy = bookentity.push();
            ((WsXxdjcljds) webobject).rq = bookentity.push();
            ((WsXxdjcljds) webobject).tbsj = bookentity.push();
        }
        //-------WsXxdjclspb-------
        else if (webobjectname.equals("WsXxdjclspb")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsXxdjclspb) webobject).ajmc = bookentity.push();
            ((WsXxdjclspb) webobject).dsrqk = bookentity.push();
            ((WsXxdjclspb) webobject).ajjbqk = bookentity.push();
            ((WsXxdjclspb) webobject).zjmcsl = bookentity.push();
            ((WsXxdjclspb) webobject).tqlyyj = bookentity.push();
            ((WsXxdjclspb) webobject).cbryj = bookentity.push();
            ((WsXxdjclspb) webobject).cbrqm = bookentity.push();
            ((WsXxdjclspb) webobject).cbrqmrq = bookentity.push();
            ((WsXxdjclspb) webobject).bmfzryj = bookentity.push();
            ((WsXxdjclspb) webobject).bmfzrqm = bookentity.push();
            ((WsXxdjclspb) webobject).bmfzrqmrq = bookentity.push();
            ((WsXxdjclspb) webobject).jgfzryj = bookentity.push();
            ((WsXxdjclspb) webobject).jgfzrqm = bookentity.push();
            ((WsXxdjclspb) webobject).jgfzrqmrq = bookentity.push();
            ((WsXxdjclspb) webobject).tbsj = bookentity.push();
        }
        //-------WsXxdjtzs-------
        else if (webobjectname.equals("WsXxdjtzs")) {
            ((WsXxdjtzs) webobject).pcode = bookentity.push();
            ((WsXxdjtzs) webobject).ycode = bookentity.push();
            ((WsXxdjtzs) webobject).ncode = bookentity.push();
            ((WsXxdjtzs) webobject).bcfdw = bookentity.push();
            ((WsXxdjtzs) webobject).wfxw = bookentity.push();
            ((WsXxdjtzs) webobject).jdrq = bookentity.push();
            ((WsXxdjtzs) webobject).djc = bookentity.push();
            ((WsXxdjtzs) webobject).fzrqm = bookentity.push();
            ((WsXxdjtzs) webobject).rq = bookentity.push();
        }
        //-------WsXzcfdw-------
        else if (webobjectname.equals("WsXzcfdw")) {
            ((WsXzcfdw) webobject).pcode = bookentity.push();
            ((WsXzcfdw) webobject).ycode = bookentity.push();
            ((WsXzcfdw) webobject).ncode = bookentity.push();
            ((WsXzcfdw) webobject).bcfdw = bookentity.push();
            ((WsXzcfdw) webobject).dz = bookentity.push();
            ((WsXzcfdw) webobject).yb = bookentity.push();
            ((WsXzcfdw) webobject).fddbr = bookentity.push();
            ((WsXzcfdw) webobject).zw = bookentity.push();
            ((WsXzcfdw) webobject).lxdh = bookentity.push();
            ((WsXzcfdw) webobject).wfss = bookentity.push();
            ((WsXzcfdw) webobject).wfgd = bookentity.push();
            ((WsXzcfdw) webobject).yjgd = bookentity.push();
            ((WsXzcfdw) webobject).xzcf = bookentity.push();
            ((WsXzcfdw) webobject).fkfs = bookentity.push();
            ((WsXzcfdw) webobject).jz = bookentity.push();
            ((WsXzcfdw) webobject).zh = bookentity.push();
            ((WsXzcfdw) webobject).zf = bookentity.push();
            ((WsXzcfdw) webobject).sqdw = bookentity.push();
            ((WsXzcfdw) webobject).rmfy = bookentity.push();
            ((WsXzcfdw) webobject).zfryy = bookentity.push();
            ((WsXzcfdw) webobject).zfrye = bookentity.push();
            ((WsXzcfdw) webobject).dsr = bookentity.push();
            ((WsXzcfdw) webobject).sj = bookentity.push();
            ((WsXzcfdw) webobject).version = bookentity.push();
            ((WsXzcfdw) webobject).dfzh = bookentity.push();
            ((WsXzcfdw) webobject).tbsj = bookentity.push();
        }
        //-------WsXzcfgr-------
        else if (webobjectname.equals("WsXzcfgr")) {
            ((WsXzcfgr) webobject).pcode = bookentity.push();
            ((WsXzcfgr) webobject).ycode = bookentity.push();
            ((WsXzcfgr) webobject).ncode = bookentity.push();
            ((WsXzcfgr) webobject).bcfr = bookentity.push();
            ((WsXzcfgr) webobject).xb = bookentity.push();
            ((WsXzcfgr) webobject).nl = bookentity.push();
            ((WsXzcfgr) webobject).sfzh = bookentity.push();
            ((WsXzcfgr) webobject).jtzz = bookentity.push();
            ((WsXzcfgr) webobject).szdw = bookentity.push();
            ((WsXzcfgr) webobject).zw = bookentity.push();
            ((WsXzcfgr) webobject).dwdz = bookentity.push();
            ((WsXzcfgr) webobject).lxdh = bookentity.push();
            ((WsXzcfgr) webobject).wfss = bookentity.push();
            ((WsXzcfgr) webobject).wfgd = bookentity.push();
            ((WsXzcfgr) webobject).yjgd = bookentity.push();
            ((WsXzcfgr) webobject).xzcf = bookentity.push();
            ((WsXzcfgr) webobject).fkfs = bookentity.push();
            ((WsXzcfgr) webobject).jz = bookentity.push();
            ((WsXzcfgr) webobject).zh = bookentity.push();
            ((WsXzcfgr) webobject).zf = bookentity.push();
            ((WsXzcfgr) webobject).sqdw = bookentity.push();
            ((WsXzcfgr) webobject).rmfy = bookentity.push();
            ((WsXzcfgr) webobject).zfryy = bookentity.push();
            ((WsXzcfgr) webobject).zfrye = bookentity.push();
            ((WsXzcfgr) webobject).dsr = bookentity.push();
            ((WsXzcfgr) webobject).sj = bookentity.push();
            ((WsXzcfgr) webobject).version = bookentity.push();
            ((WsXzcfgr) webobject).tbsj = bookentity.push();
        }
        //-------WsXzcfgzs-------
        else if (webobjectname.equals("WsXzcfgzs")) {
            ((WsXzcfgzs) webobject).pcode = bookentity.push();
            ((WsXzcfgzs) webobject).ycode = bookentity.push();
            ((WsXzcfgzs) webobject).ncode = bookentity.push();
            ((WsXzcfgzs) webobject).cfdw = bookentity.push();
            ((WsXzcfgzs) webobject).wfxw = bookentity.push();
            ((WsXzcfgzs) webobject).gd = bookentity.push();
            ((WsXzcfgzs) webobject).yj = bookentity.push();
            ((WsXzcfgzs) webobject).xzcf = bookentity.push();
            ((WsXzcfgzs) webobject).glbm = bookentity.push();
            ((WsXzcfgzs) webobject).bmdz = bookentity.push();
            ((WsXzcfgzs) webobject).bmlxr = bookentity.push();
            ((WsXzcfgzs) webobject).bmlxdh = bookentity.push();
            ((WsXzcfgzs) webobject).bmyb = bookentity.push();
            ((WsXzcfgzs) webobject).rq = bookentity.push();
            ((WsXzcfgzs) webobject).tbsj = bookentity.push();
        }
        //-------WsXzcfjdsdw-------
        else if (webobjectname.equals("WsXzcfjdsdw")) {
            ((WsXzcfjdsdw) webobject).pcode = bookentity.push();
            ((WsXzcfjdsdw) webobject).ycode = bookentity.push();
            ((WsXzcfjdsdw) webobject).ncode = bookentity.push();
            ((WsXzcfjdsdw) webobject).bcfdw = bookentity.push();
            ((WsXzcfjdsdw) webobject).dz = bookentity.push();
            ((WsXzcfjdsdw) webobject).yb = bookentity.push();
            ((WsXzcfjdsdw) webobject).fddbr = bookentity.push();
            ((WsXzcfjdsdw) webobject).fddbrzw = bookentity.push();
            ((WsXzcfjdsdw) webobject).fddbrlxdh = bookentity.push();
            ((WsXzcfjdsdw) webobject).wfsszj = bookentity.push();
            ((WsXzcfjdsdw) webobject).gd = bookentity.push();
            ((WsXzcfjdsdw) webobject).yj = bookentity.push();
            ((WsXzcfjdsdw) webobject).xzcf = bookentity.push();
            ((WsXzcfjdsdw) webobject).jz = bookentity.push();
            ((WsXzcfjdsdw) webobject).zh = bookentity.push();
            ((WsXzcfjdsdw) webobject).rmzf = bookentity.push();
            ((WsXzcfjdsdw) webobject).sqdw = bookentity.push();
            ((WsXzcfjdsdw) webobject).rmfy = bookentity.push();
            ((WsXzcfjdsdw) webobject).rq = bookentity.push();
            ((WsXzcfjdsdw) webobject).version = bookentity.push();
            ((WsXzcfjdsdw) webobject).tbsj = bookentity.push();
        }
        //-------WsXzcfjdsgr-------
        else if (webobjectname.equals("WsXzcfjdsgr")) {
            ((WsXzcfjdsgr) webobject).pcode = bookentity.push();
            ((WsXzcfjdsgr) webobject).ycode = bookentity.push();
            ((WsXzcfjdsgr) webobject).ncode = bookentity.push();
            ((WsXzcfjdsgr) webobject).bcfr = bookentity.push();
            ((WsXzcfjdsgr) webobject).xb = bookentity.push();
            ((WsXzcfjdsgr) webobject).nl = bookentity.push();
            ((WsXzcfjdsgr) webobject).lxdh = bookentity.push();
            ((WsXzcfjdsgr) webobject).jtzz = bookentity.push();
            ((WsXzcfjdsgr) webobject).szdw = bookentity.push();
            ((WsXzcfjdsgr) webobject).zw = bookentity.push();
            ((WsXzcfjdsgr) webobject).dwdz = bookentity.push();
            ((WsXzcfjdsgr) webobject).yb = bookentity.push();
            ((WsXzcfjdsgr) webobject).wfsszj = bookentity.push();
            ((WsXzcfjdsgr) webobject).gd = bookentity.push();
            ((WsXzcfjdsgr) webobject).yj = bookentity.push();
            ((WsXzcfjdsgr) webobject).xzcf = bookentity.push();
            ((WsXzcfjdsgr) webobject).jz = bookentity.push();
            ((WsXzcfjdsgr) webobject).zh = bookentity.push();
            ((WsXzcfjdsgr) webobject).rmzf = bookentity.push();
            ((WsXzcfjdsgr) webobject).sqdw = bookentity.push();
            ((WsXzcfjdsgr) webobject).rmfy = bookentity.push();
            ((WsXzcfjdsgr) webobject).rq = bookentity.push();
            ((WsXzcfjdsgr) webobject).version = bookentity.push();
            ((WsXzcfjdsgr) webobject).tbsj = bookentity.push();
        }
        //-------WsXzcftljl-------
        else if (webobjectname.equals("WsXzcftljl")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsXzcftljl) webobject).ajmc = bookentity.push();
            ((WsXzcftljl) webobject).tlsjc = bookentity.push();
            ((WsXzcftljl) webobject).tlsjm = bookentity.push();
            ((WsXzcftljl) webobject).dd = bookentity.push();
            ((WsXzcftljl) webobject).zcr = bookentity.push();
            ((WsXzcftljl) webobject).hbr = bookentity.push();
            ((WsXzcftljl) webobject).jlr = bookentity.push();
            ((WsXzcftljl) webobject).cxry = bookentity.push();
            ((WsXzcftljl) webobject).tlnr = bookentity.push();
            ((WsXzcftljl) webobject).tljl = bookentity.push();
            ((WsXzcftljl) webobject).jlxyj = bookentity.push();
            ((WsXzcftljl) webobject).cxrqm = bookentity.push();
            ((WsXzcftljl) webobject).tbsj = bookentity.push();
        }
        //-------WsYqjnfkpzs-------
        else if (webobjectname.equals("WsYqjnfkpzs")) {
            ((WsYqjnfkpzs) webobject).pcode = bookentity.push();
            ((WsYqjnfkpzs) webobject).ycode = bookentity.push();
            ((WsYqjnfkpzs) webobject).ncode = bookentity.push();
            ((WsYqjnfkpzs) webobject).fkdw = bookentity.push();
            ((WsYqjnfkpzs) webobject).fkrq = bookentity.push();
            ((WsYqjnfkpzs) webobject).wh = bookentity.push();
            ((WsYqjnfkpzs) webobject).je = bookentity.push();
            ((WsYqjnfkpzs) webobject).jkfs = bookentity.push();
            ((WsYqjnfkpzs) webobject).ycjzrq = bookentity.push();
            ((WsYqjnfkpzs) webobject).djq = bookentity.push();
            ((WsYqjnfkpzs) webobject).fqjzrq = bookentity.push();
            ((WsYqjnfkpzs) webobject).fqjnje = bookentity.push();
            ((WsYqjnfkpzs) webobject).swjnfk = bookentity.push();
            ((WsYqjnfkpzs) webobject).rq = bookentity.push();
            ((WsYqjnfkpzs) webobject).version = bookentity.push();
            ((WsYqjnfkpzs) webobject).tbsj = bookentity.push();
        }
        //-------WsYqjnfkspb-------
        else if (webobjectname.equals("WsYqjnfkspb")) {
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsYqjnfkspb) webobject).ajmc = bookentity.push();
            ((WsYqjnfkspb) webobject).wh = bookentity.push();
            ((WsYqjnfkspb) webobject).dsr = bookentity.push();
            ((WsYqjnfkspb) webobject).dz = bookentity.push();
            ((WsYqjnfkspb) webobject).wfss = bookentity.push();
            ((WsYqjnfkspb) webobject).ly = bookentity.push();
            ((WsYqjnfkspb) webobject).cbryj = bookentity.push();
            ((WsYqjnfkspb) webobject).cbrqm_one = bookentity.push();
            ((WsYqjnfkspb) webobject).cbrqm_two = bookentity.push();
            ((WsYqjnfkspb) webobject).cbrqmrq = bookentity.push();
            ((WsYqjnfkspb) webobject).shyj = bookentity.push();
            ((WsYqjnfkspb) webobject).shrqm = bookentity.push();
            ((WsYqjnfkspb) webobject).shrqmrq = bookentity.push();
            ((WsYqjnfkspb) webobject).spyj = bookentity.push();
            ((WsYqjnfkspb) webobject).sprqm = bookentity.push();
            ((WsYqjnfkspb) webobject).sprqmrq = bookentity.push();


        }
        //-------WsZgfc-------
        else if (webobjectname.equals("WsZgfc")) {
            ((WsZgfc) webobject).pcode = bookentity.push();
            ((WsZgfc) webobject).ycode = bookentity.push();
            ((WsZgfc) webobject).ncode = bookentity.push();
            ((WsZgfc) webobject).bjcdw = bookentity.push();
            ((WsZgfc) webobject).jcsj = bookentity.push();
            ((WsZgfc) webobject).jd = bookentity.push();
            ((WsZgfc) webobject).jpcode = bookentity.push();
            bookentity.push();
            ((WsZgfc) webobject).jycode = bookentity.push();
            ((WsZgfc) webobject).jncode = bookentity.push();
            ((WsZgfc) webobject).yj = bookentity.push();
            ((WsZgfc) webobject).fzr = bookentity.push();
            ((WsZgfc) webobject).zfryy = bookentity.push();
            ((WsZgfc) webobject).zfrye = bookentity.push();
            ((WsZgfc) webobject).zhy = bookentity.push();
            ((WsZgfc) webobject).zhe = bookentity.push();
            ((WsZgfc) webobject).sj = bookentity.push();
            ((WsZgfc) webobject).dfzh = bookentity.push();
            ((WsZgfc) webobject).tbsj = bookentity.push();
        }
        //-------WsZlxqzg-------
        else if (webobjectname.equals("WsZlxqzg")) {
            ((WsZlxqzg) webobject).pcode = bookentity.push();
            ((WsZlxqzg) webobject).ycode = bookentity.push();
            ((WsZlxqzg) webobject).ncode = bookentity.push();
            ((WsZlxqzg) webobject).bjcdw = bookentity.push();
            ((WsZlxqzg) webobject).wtOne = bookentity.push();
            ((WsZlxqzg) webobject).wtTwo = bookentity.push();
            ((WsZlxqzg) webobject).wtThree = bookentity.push();
            ((WsZlxqzg) webobject).wtFour = bookentity.push();
            ((WsZlxqzg) webobject).djx = bookentity.push();
            ((WsZlxqzg) webobject).zgrq = bookentity.push();
            ((WsZlxqzg) webobject).rmzf = bookentity.push();
            ((WsZlxqzg) webobject).sqdw = bookentity.push();
            ((WsZlxqzg) webobject).rmfy = bookentity.push();
            ((WsZlxqzg) webobject).zfryqmOne = bookentity.push();
            ((WsZlxqzg) webobject).zfryqmTwo = bookentity.push();
            ((WsZlxqzg) webobject).zhOne = bookentity.push();
            ((WsZlxqzg) webobject).zhTwo = bookentity.push();
            ((WsZlxqzg) webobject).fzrqm = bookentity.push();
            ((WsZlxqzg) webobject).sj = bookentity.push();
            ((WsZlxqzg) webobject).dfzh = bookentity.push();
            ((WsZlxqzg) webobject).tbsj = bookentity.push();
        }
        //-------WsCyqzpz-------
        else if (webobjectname.equals("WsCyqzpz")) {
            //------WsCyqzpz-Entity_Book4-------


            ((WsCyqzpz) webobject).pcode = bookentity.push();
            ((WsCyqzpz) webobject).ycode = bookentity.push();
            ((WsCyqzpz) webobject).ncode = bookentity.push();
            ((WsCyqzpz) webobject).bcydw = bookentity.push();
            ((WsCyqzpz) webobject).xcfzr = bookentity.push();
            ((WsCyqzpz) webobject).dwdz = bookentity.push();
            ((WsCyqzpz) webobject).lxdh = bookentity.push();
            ((WsCyqzpz) webobject).yb = bookentity.push();
            ((WsCyqzpz) webobject).cysjc = bookentity.push();
            ((WsCyqzpz) webobject).cysjm = bookentity.push();
            ((WsCyqzpz) webobject).cydd = bookentity.push();
            ((WsCyqzpz) webobject).cyqzList = stringlist(bookentity.push(), Static_BookLib.WEBBOOKNAMECHILD[index]);
            ((WsCyqzpz) webobject).xcfzrqm = bookentity.push();
            ((WsCyqzpz) webobject).zfryqmOne = bookentity.push();
            ((WsCyqzpz) webobject).zfryzhOne = bookentity.push();
            ((WsCyqzpz) webobject).zfryqmTwo = bookentity.push();
            ((WsCyqzpz) webobject).zfryzhTwo = bookentity.push();
            ((WsCyqzpz) webobject).rq = bookentity.push();

        }
        //-------WsJdwts-------
        else if (webobjectname.equals("WsJdwts")) {
            //------WsJdwts-Entity_Book14-------

            ((WsJdwts) webobject).pcode = bookentity.push();
            ((WsJdwts) webobject).ycode = bookentity.push();
            ((WsJdwts) webobject).ncode = bookentity.push();
            ((WsJdwts) webobject).wtdw = bookentity.push();
            ((WsJdwts) webobject).jdwtsList = stringlist(bookentity.push(), Static_BookLib.WEBBOOKNAMECHILD[index]);
            ((WsJdwts) webobject).jdyq = bookentity.push();
            ((WsJdwts) webobject).jzsj = bookentity.push();
            ((WsJdwts) webobject).rq = bookentity.push();
        }
        //-------WsJnml-------
        else if (webobjectname.equals("WsJnml")) {
            //------WsJnml-Entity_Book36-------
            bookentity.push();
            bookentity.push();
            bookentity.push();
            ((WsJnml) webobject).jnmlList = stringlist(bookentity.push(), Static_BookLib.WEBBOOKNAMECHILD[index]);

        }
        //-------WsSdhz-------
        else if (webobjectname.equals("WsSdhz")) {
            //------WsSdhz-Entity_Book30-------

            ((WsSdhz) webobject).pcode = bookentity.push();
            ((WsSdhz) webobject).ycode = bookentity.push();
            ((WsSdhz) webobject).ncode = bookentity.push();
            ((WsSdhz) webobject).ajmc = bookentity.push();
            ((WsSdhz) webobject).ssddw = bookentity.push();
            ((WsSdhz) webobject).sdhzList = stringlist(bookentity.push(), Static_BookLib.WEBBOOKNAMECHILD[index]);
            ((WsSdhz) webobject).bz = bookentity.push();
        }

        return webobject;
    }

    @Override
    public DateBase_Entity webobject2bookentity(Object webobject) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        DateBase_Entity bookentity = null;
        for (int i = 0; i < Static_BookLib.WEBBOOKNAME.length; i++) {
            String webobjectname = webobject.getClass().getSimpleName();
            if (Static_BookLib.WEBBOOKNAME[i].equals(webobjectname)) {
                bookentity = (DateBase_Entity) Class.forName("com.wisdomregulation.data.entitybook.Entity_Book" + i).newInstance();
                if (webobject.getClass().getSimpleName().equals("WsAjsy")) {
                    bookentity.pull(((WsAjsy) webobject).glj + "");
                    bookentity.pull(((WsAjsy) webobject).pcode + "");
                    bookentity.pull(((WsAjsy) webobject).ycode + "");
                    bookentity.pull(((WsAjsy) webobject).ncode + "");
                    bookentity.pull(((WsAjsy) webobject).ajmc + "");
                    bookentity.pull(((WsAjsy) webobject).ay + "");
                    bookentity.pull(((WsAjsy) webobject).cljg + "");
                    bookentity.pull(((WsAjsy) webobject).larq + "");
                    bookentity.pull(((WsAjsy) webobject).jarq + "");
                    bookentity.pull(((WsAjsy) webobject).cbrqm_one + "");
                    bookentity.pull(((WsAjsy) webobject).cbrqm_two + "");
                    bookentity.pull(((WsAjsy) webobject).gdrq + "");
                    bookentity.pull(((WsAjsy) webobject).gdh + "");
                    bookentity.pull(((WsAjsy) webobject).bcqx + "");
                    bookentity.pull(((WsAjsy) webobject).rq + "");
                    bookentity.pull(((WsAjsy) webobject).version + "");
                    bookentity.pull(((WsAjsy) webobject).tbsj + "");
                }
                //-------WsAjyss-------
                else if (webobject.getClass().getSimpleName().equals("WsAjyss")) {
                    bookentity.pull(((WsAjyss) webobject).pcode + "");
                    bookentity.pull(((WsAjyss) webobject).ycode + "");
                    bookentity.pull(((WsAjyss) webobject).ncode + "");
                    bookentity.pull(((WsAjyss) webobject).ysdw + "");
                    bookentity.pull(((WsAjyss) webobject).larq + "");
                    bookentity.pull(((WsAjyss) webobject).aj + "");
                    bookentity.pull(((WsAjyss) webobject).fx + "");
                    bookentity.pull(((WsAjyss) webobject).gd + "");
                    bookentity.pull(((WsAjyss) webobject).cl + "");
                    bookentity.pull(((WsAjyss) webobject).jf + "");
                    bookentity.pull(((WsAjyss) webobject).jy + "");
                    bookentity.pull(((WsAjyss) webobject).rq + "");
                    bookentity.pull(((WsAjyss) webobject).version + "");
                    bookentity.pull(((WsAjyss) webobject).tbsj + "");
                }
                //-------WsAjysspb-------
                else if (webobject.getClass().getSimpleName().equals("WsAjclcp")) {
                    bookentity.pull(((WsAjclcp) webobject).pcode + "");
                    //("字")
                    bookentity.pull(((WsAjclcp) webobject).ycode + "");
                    //("号")
                    bookentity.pull(((WsAjclcp) webobject).ncode + "");
                    //("案件名称")
                    bookentity.pull(((WsAjclcp) webobject).ajmc + "");
                    //("被处罚单位")
                    bookentity.pull(((WsAjclcp) webobject).bcfdw + "");
                    //("地址")
                    bookentity.pull(((WsAjclcp) webobject).dz + "");
                    //("法定代表人")
                    bookentity.pull(((WsAjclcp) webobject).fddbr + "");
                    //("职务")
                    bookentity.pull(((WsAjclcp) webobject).zw + "");
                    //("单位邮编")
                    bookentity.pull(((WsAjclcp) webobject).dwyb + "");
                    //("被处罚人")
                    bookentity.pull(((WsAjclcp) webobject).bcfr + "");
                    //("年龄")
                    bookentity.pull(((WsAjclcp) webobject).nl + "");
                    //("性别")
                    bookentity.pull(((WsAjclcp) webobject).xb + "");
                    //("所在单位")
                    bookentity.pull(((WsAjclcp) webobject).szdw + "");
                    //("单位地址")
                    bookentity.pull(((WsAjclcp) webobject).dwdz + "");
                    //("家庭住址")
                    bookentity.pull(((WsAjclcp) webobject).jtzz + "");
                    //("联系电话")
                    bookentity.pull(((WsAjclcp) webobject).lxdh + "");
                    //("家庭邮编")
                    bookentity.pull(((WsAjclcp) webobject).jtyb + "");
                    //("违法事实及处罚依据")
                    bookentity.pull(((WsAjclcp) webobject).wfss + "");
                    //("当事人申辩意见")
                    bookentity.pull(((WsAjclcp) webobject).dsrsbyj + "");
                    //("承办人意见")
                    bookentity.pull(((WsAjclcp) webobject).cbryj + "");
                    //("承办人签名1")
                    bookentity.pull(((WsAjclcp) webobject).cbrqmy + "");
                    //("承办人签名2")
                    bookentity.pull(((WsAjclcp) webobject).cbrqme + "");
                    //("承办人签名时间")
                    bookentity.pull(((WsAjclcp) webobject).cbrqmsj + "");
                    //("审核意见")
                    bookentity.pull(((WsAjclcp) webobject).shyj + "");
                    //("审核人签名")
                    bookentity.pull(((WsAjclcp) webobject).shrqm + "");
                    //("审核时间")
                    bookentity.pull(((WsAjclcp) webobject).shsj + "");
                    //("审批意见")
                    bookentity.pull(((WsAjclcp) webobject).spyj + "");
                    //("审批人签名")
                    bookentity.pull(((WsAjclcp) webobject).sprqm + "");
                    //("审批时间")
                    bookentity.pull(((WsAjclcp) webobject).spsj + "");

                }
                //-------WsAjysspb-------
                else if (webobject.getClass().getSimpleName().equals("WsAjysspb")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsAjysspb) webobject).ajmc + "");
                    bookentity.pull(((WsAjysspb) webobject).dsr + "");
                    bookentity.pull(((WsAjysspb) webobject).dz + "");
                    bookentity.pull(((WsAjysspb) webobject).sysjg + "");
                    bookentity.pull(((WsAjysspb) webobject).aqjj + "");
                    bookentity.pull(((WsAjysspb) webobject).ysly + "");
                    bookentity.pull(((WsAjysspb) webobject).cbryj + "");
                    bookentity.pull(((WsAjysspb) webobject).cbrqm_one + "");
                    bookentity.pull(((WsAjysspb) webobject).cbrqm_two + "");
                    bookentity.pull(((WsAjysspb) webobject).cbrqmrq + "");
                    bookentity.pull(((WsAjysspb) webobject).shyj + "");
                    bookentity.pull(((WsAjysspb) webobject).shrqm + "");
                    bookentity.pull(((WsAjysspb) webobject).shrqmrq + "");
                    bookentity.pull(((WsAjysspb) webobject).spyj + "");
                    bookentity.pull(((WsAjysspb) webobject).sprqm + "");
                    bookentity.pull(((WsAjysspb) webobject).sprqmrq + "");
                    bookentity.pull(((WsAjysspb) webobject).version + "");
                    bookentity.pull(((WsAjysspb) webobject).tbsj + "");
                }
                //-------WsDsrcssbbl-------
                else if (webobject.getClass().getSimpleName().equals("WsDsrcssbbl")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsDsrcssbbl) webobject).sjc + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).sjm + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).dd + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).cssbr + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).sbrxb + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).sbrzw + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).sbrdw + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).sbrdh + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).sbrlxdz + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).sbryb + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).cbr + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).jlr + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).glj + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).zfryOne + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).zfryTwo + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).zfryzhOne + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).zfryzhTwo + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).aj + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).cssbjl + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).cssbrqm + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).cbrqm + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).jlrqm + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).rq + "");
                    bookentity.pull(((WsDsrcssbbl) webobject).tbsj + "");
                }
                //-------WsFkcjtzs-------
                else if (webobject.getClass().getSimpleName().equals("WsFkcjtzs")) {
                    bookentity.pull(((WsFkcjtzs) webobject).pcode + "");
                    bookentity.pull(((WsFkcjtzs) webobject).ycode + "");
                    bookentity.pull(((WsFkcjtzs) webobject).ncode + "");
                    bookentity.pull(((WsFkcjtzs) webobject).fkdw + "");
                    bookentity.pull(((WsFkcjtzs) webobject).fkrq + "");
                    bookentity.pull(((WsFkcjtzs) webobject).fkh + "");
                    bookentity.pull(((WsFkcjtzs) webobject).jkrq + "");
                    bookentity.pull(((WsFkcjtzs) webobject).jkc + "");
                    bookentity.pull(((WsFkcjtzs) webobject).rq + "");
                    bookentity.pull(((WsFkcjtzs) webobject).version + "");
                    bookentity.pull(((WsFkcjtzs) webobject).tbsj + "");
                }
                //-------WsJaspb-------
                else if (webobject.getClass().getSimpleName().equals("WsJaspb")) {
                    bookentity.pull(((WsJaspb) webobject).pcode + "");
                    bookentity.pull(((WsJaspb) webobject).ycode + "");
                    bookentity.pull(((WsJaspb) webobject).ncode + "");
                    bookentity.pull(((WsJaspb) webobject).ajmc + "");
                    bookentity.pull(((WsJaspb) webobject).bcfdw + "");
                    bookentity.pull(((WsJaspb) webobject).bcfdwdz + "");
                    bookentity.pull(((WsJaspb) webobject).fddbr + "");
                    bookentity.pull(((WsJaspb) webobject).fddbrzw + "");
                    bookentity.pull(((WsJaspb) webobject).fddbryb + "");
                    bookentity.pull(((WsJaspb) webobject).bcfr + "");
                    bookentity.pull(((WsJaspb) webobject).bcfrnl + "");
                    bookentity.pull(((WsJaspb) webobject).bcfrxb + "");
                    bookentity.pull(((WsJaspb) webobject).bcfrdw + "");
                    bookentity.pull(((WsJaspb) webobject).bcfrdwzz + "");
                    bookentity.pull(((WsJaspb) webobject).bcfrjtzz + "");
                    bookentity.pull(((WsJaspb) webobject).bcfrlxdh + "");
                    bookentity.pull(((WsJaspb) webobject).bcfryb + "");
                    bookentity.pull(((WsJaspb) webobject).cljg + "");
                    bookentity.pull(((WsJaspb) webobject).zxqk + "");
                    bookentity.pull(((WsJaspb) webobject).cbrqm_one + "");
                    bookentity.pull(((WsJaspb) webobject).cbrqm_two + "");
                    bookentity.pull(((WsJaspb) webobject).cbrqmrq + "");
                    bookentity.pull(((WsJaspb) webobject).shyj + "");
                    bookentity.pull(((WsJaspb) webobject).shrqm + "");
                    bookentity.pull(((WsJaspb) webobject).shrqmrq + "");
                    bookentity.pull(((WsJaspb) webobject).spyj + "");
                    bookentity.pull(((WsJaspb) webobject).sprqm + "");
                    bookentity.pull(((WsJaspb) webobject).sprqmrq + "");
                    bookentity.pull(((WsJaspb) webobject).version + "");
                    bookentity.pull(((WsJaspb) webobject).tbsj + "");
                }
                //-------WsKybl-------
                else if (webobject.getClass().getSimpleName().equals("WsKybl")) {
                    bookentity.pull(((WsKybl) webobject).pcode + "");
                    bookentity.pull(((WsKybl) webobject).ycode + "");
                    bookentity.pull(((WsKybl) webobject).ncode + "");
                    bookentity.pull(((WsKybl) webobject).kysjc + "");
                    bookentity.pull(((WsKybl) webobject).kysjm + "");
                    bookentity.pull(((WsKybl) webobject).kycs + "");
                    bookentity.pull(((WsKybl) webobject).tqqk + "");
                    bookentity.pull(((WsKybl) webobject).kyrOne + "");
                    bookentity.pull(((WsKybl) webobject).kyrzwOne + "");
                    bookentity.pull(((WsKybl) webobject).kyrTwo + "");
                    bookentity.pull(((WsKybl) webobject).kyrzwTwo + "");
                    bookentity.pull(((WsKybl) webobject).dsrOne + "");
                    bookentity.pull(((WsKybl) webobject).dsrzwOne + "");
                    bookentity.pull(((WsKybl) webobject).dsrTwo + "");
                    bookentity.pull(((WsKybl) webobject).dsrzwTwo + "");
                    bookentity.pull(((WsKybl) webobject).byqr + "");
                    bookentity.pull(((WsKybl) webobject).byqrzw + "");
                    bookentity.pull(((WsKybl) webobject).jlr + "");
                    bookentity.pull(((WsKybl) webobject).jlrzw + "");
                    bookentity.pull(((WsKybl) webobject).glj + "");
                    bookentity.pull(((WsKybl) webobject).zfryOne + "");
                    bookentity.pull(((WsKybl) webobject).zfryTwo + "");
                    bookentity.pull(((WsKybl) webobject).zhOne + "");
                    bookentity.pull(((WsKybl) webobject).zhTwo + "");
                    bookentity.pull(((WsKybl) webobject).kyqk + "");
                    bookentity.pull(((WsKybl) webobject).kyrqmOne + "");
                    bookentity.pull(((WsKybl) webobject).kyrqmTwo + "");
                    bookentity.pull(((WsKybl) webobject).dsrqmOne + "");
                    bookentity.pull(((WsKybl) webobject).dsrlxdhOne + "");
                    bookentity.pull(((WsKybl) webobject).dsrqmTwo + "");
                    bookentity.pull(((WsKybl) webobject).dsrlxdhTwo + "");
                    bookentity.pull(((WsKybl) webobject).byqrqm + "");
                    bookentity.pull(((WsKybl) webobject).byqrlxdh + "");
                    bookentity.pull(((WsKybl) webobject).tbsj + "");
                }
                //-------WsLasp-------
                else if (webobject.getClass().getSimpleName().equals("WsLasp")) {
                    bookentity.pull(((WsLasp) webobject).pcode + "");
                    bookentity.pull(((WsLasp) webobject).ycode + "");
                    bookentity.pull(((WsLasp) webobject).ncode + "");
                    bookentity.pull(((WsLasp) webobject).ay + "");
                    bookentity.pull(((WsLasp) webobject).ajly + "");
                    bookentity.pull(((WsLasp) webobject).sj + "");
                    bookentity.pull(((WsLasp) webobject).ajmc + "");
                    bookentity.pull(((WsLasp) webobject).dsr + "");
                    bookentity.pull(((WsLasp) webobject).dh + "");
                    bookentity.pull(((WsLasp) webobject).dsrqk + "");
                    bookentity.pull(((WsLasp) webobject).dsrdz + "");
                    bookentity.pull(((WsLasp) webobject).yzbm + "");
                    bookentity.pull(((WsLasp) webobject).ajqk + "");
                    bookentity.pull(((WsLasp) webobject).cbryj + "");
                    bookentity.pull(((WsLasp) webobject).cbrqzy + "");
                    bookentity.pull(((WsLasp) webobject).zhy + "");
                    bookentity.pull(((WsLasp) webobject).cbrqze + "");
                    bookentity.pull(((WsLasp) webobject).zhe + "");
                    bookentity.pull(((WsLasp) webobject).cbsj + "");
                    bookentity.pull(((WsLasp) webobject).shyj + "");
                    bookentity.pull(((WsLasp) webobject).shre + "");
                    bookentity.pull(((WsLasp) webobject).shsj + "");
                    bookentity.pull(((WsLasp) webobject).spyj + "");
                    bookentity.pull(((WsLasp) webobject).spr + "");
                    bookentity.pull(((WsLasp) webobject).spsj + "");
                    bookentity.pull(((WsLasp) webobject).version + "");
                    bookentity.pull(((WsLasp) webobject).tbsj + "");
                }
                //-------WsQzcs-------
                else if (webobject.getClass().getSimpleName().equals("WsQzcs")) {
                    bookentity.pull(((WsQzcs) webobject).pcode + "");
                    bookentity.pull(((WsQzcs) webobject).ycode + "");
                    bookentity.pull(((WsQzcs) webobject).ncode + "");
                    bookentity.pull(((WsQzcs) webobject).bjcdw + "");
                    bookentity.pull(((WsQzcs) webobject).wt + "");
                    bookentity.pull(((WsQzcs) webobject).yj + "");
                    bookentity.pull(((WsQzcs) webobject).qzcs + "");
                    bookentity.pull(((WsQzcs) webobject).rmzf + "");
                    bookentity.pull(((WsQzcs) webobject).sqdw + "");
                    bookentity.pull(((WsQzcs) webobject).rmfy + "");
                    bookentity.pull(((WsQzcs) webobject).sj + "");
                    bookentity.pull(((WsQzcs) webobject).dfzh + "");
                    bookentity.pull(((WsQzcs) webobject).tbsj + "");
                }
                //-------WsQzzxsqs-------
                else if (webobject.getClass().getSimpleName().equals("WsQzzxsqs")) {
                    bookentity.pull(((WsQzzxsqs) webobject).pcode + "");
                    bookentity.pull(((WsQzzxsqs) webobject).ycode + "");
                    bookentity.pull(((WsQzzxsqs) webobject).ncode + "");
                    bookentity.pull(((WsQzzxsqs) webobject).rmfy + "");
                    bookentity.pull(((WsQzzxsqs) webobject).cfrq + "");
                    bookentity.pull(((WsQzzxsqs) webobject).sqzxr + "");
                    bookentity.pull(((WsQzzxsqs) webobject).cfjd + "");
                    bookentity.pull(((WsQzzxsqs) webobject).wh + "");
                    bookentity.pull(((WsQzzxsqs) webobject).ygcl + "");
                    bookentity.pull(((WsQzzxsqs) webobject).rq + "");
                    bookentity.pull(((WsQzzxsqs) webobject).lxr + "");
                    bookentity.pull(((WsQzzxsqs) webobject).lxdh + "");
                    bookentity.pull(((WsQzzxsqs) webobject).version + "");
                    bookentity.pull(((WsQzzxsqs) webobject).tbsj + "");
                }
                //-------WsTzbl-------
                else if (webobject.getClass().getSimpleName().equals("WsTzbl")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsTzbl) webobject).ajmc + "");
                    bookentity.pull(((WsTzbl) webobject).zctzjg + "");
                    bookentity.pull(((WsTzbl) webobject).dd + "");
                    bookentity.pull(((WsTzbl) webobject).tzsjc + "");
                    bookentity.pull(((WsTzbl) webobject).tzsjm + "");
                    bookentity.pull(((WsTzbl) webobject).tzzcr + "");
                    bookentity.pull(((WsTzbl) webobject).tzy + "");
                    bookentity.pull(((WsTzbl) webobject).sjy + "");
                    bookentity.pull(((WsTzbl) webobject).dcryOne + "");
                    bookentity.pull(((WsTzbl) webobject).dcryzhOne + "");
                    bookentity.pull(((WsTzbl) webobject).dcryTwo + "");
                    bookentity.pull(((WsTzbl) webobject).dcryzhTwo + "");
                    bookentity.pull(((WsTzbl) webobject).fddbrxm + "");
                    bookentity.pull(((WsTzbl) webobject).fddbrxb + "");
                    bookentity.pull(((WsTzbl) webobject).fddbrnl + "");
                    bookentity.pull(((WsTzbl) webobject).gzdwzw + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrOne + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrxbOne + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrnlOne + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrdwOne + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrTwo + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrxbTwo + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrnlTwo + "");
                    bookentity.pull(((WsTzbl) webobject).wtdlrdwTwo + "");
                    bookentity.pull(((WsTzbl) webobject).dsr + "");
                    bookentity.pull(((WsTzbl) webobject).qtcyry + "");
                    bookentity.pull(((WsTzbl) webobject).tzjl + "");
                    bookentity.pull(((WsTzbl) webobject).dbrqm + "");
                    bookentity.pull(((WsTzbl) webobject).zcrqm + "");
                    bookentity.pull(((WsTzbl) webobject).sjyqm + "");
                    bookentity.pull(((WsTzbl) webobject).rq + "");
                    bookentity.pull(((WsTzbl) webobject).tbsj + "");
                }
                //-------WsTzgzs-------
                else if (webobject.getClass().getSimpleName().equals("WsTzgzs")) {
                    bookentity.pull(((WsTzgzs) webobject).pcode + "");
                    bookentity.pull(((WsTzgzs) webobject).ycode + "");
                    bookentity.pull(((WsTzgzs) webobject).ncode + "");
                    bookentity.pull(((WsTzgzs) webobject).cfdw + "");
                    bookentity.pull(((WsTzgzs) webobject).wfxw + "");
                    bookentity.pull(((WsTzgzs) webobject).gd + "");
                    bookentity.pull(((WsTzgzs) webobject).yj + "");
                    bookentity.pull(((WsTzgzs) webobject).xzcf + "");
                    bookentity.pull(((WsTzgzs) webobject).glbm + "");
                    bookentity.pull(((WsTzgzs) webobject).bmdz + "");
                    bookentity.pull(((WsTzgzs) webobject).bmlxr + "");
                    bookentity.pull(((WsTzgzs) webobject).bmlxdh + "");
                    bookentity.pull(((WsTzgzs) webobject).bmyb + "");
                    bookentity.pull(((WsTzgzs) webobject).rq + "");
                    bookentity.pull(((WsTzgzs) webobject).tbsj + "");
                }
                //-------WsTzhbg-------
                else if (webobject.getClass().getSimpleName().equals("WsTzhbg")) {
                    bookentity.pull(((WsTzhbg) webobject).pcode + "");
                    bookentity.pull(((WsTzhbg) webobject).ycode + "");
                    bookentity.pull(((WsTzhbg) webobject).ncode + "");
                    bookentity.pull(((WsTzhbg) webobject).ajmc + "");
                    bookentity.pull(((WsTzhbg) webobject).tzzcr + "");
                    bookentity.pull(((WsTzhbg) webobject).tzy + "");
                    bookentity.pull(((WsTzhbg) webobject).sjy + "");
                    bookentity.pull(((WsTzhbg) webobject).zy + "");
                    bookentity.pull(((WsTzhbg) webobject).tzzcryj + "");
                    bookentity.pull(((WsTzhbg) webobject).tzzcrqm + "");
                    bookentity.pull(((WsTzhbg) webobject).tzzcrqmrq + "");
                    bookentity.pull(((WsTzhbg) webobject).fzrshyj + "");
                    bookentity.pull(((WsTzhbg) webobject).fzrqm + "");
                    bookentity.pull(((WsTzhbg) webobject).fzrqmrq + "");
                    bookentity.pull(((WsTzhbg) webobject).tbsj + "");
                }
                //-------WsTzhtzs-------
                else if (webobject.getClass().getSimpleName().equals("WsTzhtzs")) {
                    bookentity.pull(((WsTzhtzs) webobject).pcode + "");
                    bookentity.pull(((WsTzhtzs) webobject).ycode + "");
                    bookentity.pull(((WsTzhtzs) webobject).ncode + "");
                    bookentity.pull(((WsTzhtzs) webobject).cfdw + "");
                    bookentity.pull(((WsTzhtzs) webobject).aj + "");
                    bookentity.pull(((WsTzhtzs) webobject).sj + "");
                    bookentity.pull(((WsTzhtzs) webobject).hydd + "");
                    bookentity.pull(((WsTzhtzs) webobject).zcrxm + "");
                    bookentity.pull(((WsTzhtzs) webobject).zcrzw + "");
                    bookentity.pull(((WsTzhtzs) webobject).tzyxmOne + "");
                    bookentity.pull(((WsTzhtzs) webobject).tzyzwOne + "");
                    bookentity.pull(((WsTzhtzs) webobject).tzyxmTwo + "");
                    bookentity.pull(((WsTzhtzs) webobject).tzyzwTwo + "");
                    bookentity.pull(((WsTzhtzs) webobject).sjyxm + "");
                    bookentity.pull(((WsTzhtzs) webobject).sjyzw + "");
                    bookentity.pull(((WsTzhtzs) webobject).rq + "");
                    bookentity.pull(((WsTzhtzs) webobject).bmdz + "");
                    bookentity.pull(((WsTzhtzs) webobject).bmlxr + "");
                    bookentity.pull(((WsTzhtzs) webobject).bmlxdh + "");
                    bookentity.pull(((WsTzhtzs) webobject).bmyb + "");

                }
                //-------WsXcclcs-------
                else if (webobject.getClass().getSimpleName().equals("WsXcclcs")) {
                    bookentity.pull(((WsXcclcs) webobject).pcode + "");
                    bookentity.pull(((WsXcclcs) webobject).ycode + "");
                    bookentity.pull(((WsXcclcs) webobject).ncode + "");
                    bookentity.pull(((WsXcclcs) webobject).bjcdw + "");
                    bookentity.pull(((WsXcclcs) webobject).jcrq + "");
                    bookentity.pull(((WsXcclcs) webobject).sgyhOne + "");
                    bookentity.pull(((WsXcclcs) webobject).sgyhTwo + "");
                    bookentity.pull(((WsXcclcs) webobject).sgyhThree + "");
                    bookentity.pull(((WsXcclcs) webobject).yj + "");
                    bookentity.pull(((WsXcclcs) webobject).jdOne + "");
                    bookentity.pull(((WsXcclcs) webobject).jdTwo + "");
                    bookentity.pull(((WsXcclcs) webobject).jdThree + "");
                    bookentity.pull(((WsXcclcs) webobject).rmzf + "");
                    bookentity.pull(((WsXcclcs) webobject).sqdw + "");
                    bookentity.pull(((WsXcclcs) webobject).rmfy + "");
                    bookentity.pull(((WsXcclcs) webobject).zfryqmOne + "");
                    bookentity.pull(((WsXcclcs) webobject).zfryqmTwo + "");
                    bookentity.pull(((WsXcclcs) webobject).zhOne + "");
                    bookentity.pull(((WsXcclcs) webobject).zhTwo + "");
                    bookentity.pull(((WsXcclcs) webobject).fzrqm + "");
                    bookentity.pull(((WsXcclcs) webobject).sj + "");
                    bookentity.pull(((WsXcclcs) webobject).dfzh + "");
                    bookentity.pull(((WsXcclcs) webobject).tbsj + "");
                }
                //-------WsXcjc-------
                else if (webobject.getClass().getSimpleName().equals("WsXcjc")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsXcjc) webobject).bjcdw + "");
                    bookentity.pull(((WsXcjc) webobject).dz + "");
                    bookentity.pull(((WsXcjc) webobject).fzr + "");
                    bookentity.pull(((WsXcjc) webobject).zw + "");
                    bookentity.pull(((WsXcjc) webobject).lxdh + "");
                    bookentity.pull(((WsXcjc) webobject).jccs + "");
                    bookentity.pull(((WsXcjc) webobject).jcsjc + "");
                    bookentity.pull(((WsXcjc) webobject).jcsjm + "");
                    bookentity.pull(((WsXcjc) webobject).glj + "");
                    bookentity.pull(((WsXcjc) webobject).zfryy + "");
                    bookentity.pull(((WsXcjc) webobject).zfrye + "");
                    bookentity.pull(((WsXcjc) webobject).zjhmy + "");
                    bookentity.pull(((WsXcjc) webobject).zjhme + "");
                    bookentity.pull(((WsXcjc) webobject).jcqk + "");
                    bookentity.pull(((WsXcjc) webobject).jcryqmy + "");
                    bookentity.pull(((WsXcjc) webobject).jcryqme + "");
                    bookentity.pull(((WsXcjc) webobject).bjcfzr + "");
                    bookentity.pull(((WsXcjc) webobject).sj + "");
                    bookentity.pull(((WsXcjc) webobject).tbsj + "");
                }
                //-------WsXwbl-------
                else if (webobject.getClass().getSimpleName().equals("WsXwbl")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsXwbl) webobject).xwsjc + "");
                    bookentity.pull(((WsXwbl) webobject).xwsjm + "");
                    bookentity.pull(((WsXwbl) webobject).xwcs + "");
                    bookentity.pull(((WsXwbl) webobject).xwdd + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrxm + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrxb + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrnl + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrzjh + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrdw + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrzw + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrzz + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrdh + "");
                    bookentity.pull(((WsXwbl) webobject).xwr + "");
                    bookentity.pull(((WsXwbl) webobject).xwrdwzw + "");
                    bookentity.pull(((WsXwbl) webobject).jlr + "");
                    bookentity.pull(((WsXwbl) webobject).jlrdwzw + "");
                    bookentity.pull(((WsXwbl) webobject).zcr + "");
                    bookentity.pull(((WsXwbl) webobject).glj + "");
                    bookentity.pull(((WsXwbl) webobject).zfryOne + "");
                    bookentity.pull(((WsXwbl) webobject).zfryTwo + "");
                    bookentity.pull(((WsXwbl) webobject).zhOne + "");
                    bookentity.pull(((WsXwbl) webobject).zhTwo + "");
                    bookentity.pull(((WsXwbl) webobject).wt + "");
                    bookentity.pull(((WsXwbl) webobject).xwjl + "");
                    bookentity.pull(((WsXwbl) webobject).xwrqm + "");
                    bookentity.pull(((WsXwbl) webobject).jlrqm + "");
                    bookentity.pull(((WsXwbl) webobject).bxwrqm + "");
                    bookentity.pull(((WsXwbl) webobject).rq + "");
                    bookentity.pull(((WsXwbl) webobject).tbsj + "");
                }
                //-------WsXwtz-------
                else if (webobject.getClass().getSimpleName().equals("WsXwtz")) {
                    bookentity.pull(((WsXwtz) webobject).pcode + "");
                    bookentity.pull(((WsXwtz) webobject).ycode + "");
                    bookentity.pull(((WsXwtz) webobject).ncode + "");
                    bookentity.pull(((WsXwtz) webobject).bjcr + "");
                    bookentity.pull(((WsXwtz) webobject).yy + "");
                    bookentity.pull(((WsXwtz) webobject).xwsj + "");
                    bookentity.pull(((WsXwtz) webobject).xwdd + "");
                    bookentity.pull(((WsXwtz) webobject).cllb + "");
                    bookentity.pull(((WsXwtz) webobject).zdycl + "");
                    bookentity.pull(((WsXwtz) webobject).glbmdz + "");
                    bookentity.pull(((WsXwtz) webobject).lxr + "");
                    bookentity.pull(((WsXwtz) webobject).lxdh + "");
                    bookentity.pull(((WsXwtz) webobject).sj + "");
                    bookentity.pull(((WsXwtz) webobject).version + "");
                    bookentity.pull(((WsXwtz) webobject).tbsj + "");
                }
                //-------WsXxdjbc-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjbc")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsXxdjbc) webobject).ajmc + "");
                    bookentity.pull(((WsXxdjbc) webobject).dsrjbqk + "");
                    bookentity.pull(((WsXxdjbc) webobject).ajjbqk + "");
                    bookentity.pull(((WsXxdjbc) webobject).zjmcjsl + "");
                    bookentity.pull(((WsXxdjbc) webobject).tqlyjyj + "");
                    bookentity.pull(((WsXxdjbc) webobject).bcfs + "");
                    bookentity.pull(((WsXxdjbc) webobject).cbryj + "");
                    bookentity.pull(((WsXxdjbc) webobject).cbrqm + "");
                    bookentity.pull(((WsXxdjbc) webobject).cbrsj + "");
                    bookentity.pull(((WsXxdjbc) webobject).bmfzryj + "");
                    bookentity.pull(((WsXxdjbc) webobject).bmfzrqm + "");
                    bookentity.pull(((WsXxdjbc) webobject).bmfzrsj + "");
                    bookentity.pull(((WsXxdjbc) webobject).jgfzryj + "");
                    bookentity.pull(((WsXxdjbc) webobject).jgfzrqm + "");
                    bookentity.pull(((WsXxdjbc) webobject).jgfzrsj + "");
                    bookentity.pull(((WsXxdjbc) webobject).tbsj + "");
                }
                //-------WsXxdjcljds-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjcljds")) {
                    bookentity.pull(((WsXxdjcljds) webobject).pcode + "");
                    bookentity.pull(((WsXxdjcljds) webobject).ycode + "");
                    bookentity.pull(((WsXxdjcljds) webobject).ncode + "");
                    bookentity.pull(((WsXxdjcljds) webobject).bdjdw + "");
                    bookentity.pull(((WsXxdjcljds) webobject).djrq + "");
                    bookentity.pull(((WsXxdjcljds) webobject).djwp + "");
                    bookentity.pull(((WsXxdjcljds) webobject).jpcode + "");
                    bookentity.pull(((WsXxdjcljds) webobject).jycode + "");
                    bookentity.pull(((WsXxdjcljds) webobject).jncode + "");
                    bookentity.pull(((WsXxdjcljds) webobject).cl + "");
                    bookentity.pull(((WsXxdjcljds) webobject).rmzf + "");
                    bookentity.pull(((WsXxdjcljds) webobject).sqdw + "");
                    bookentity.pull(((WsXxdjcljds) webobject).rmfy + "");
                    bookentity.pull(((WsXxdjcljds) webobject).rq + "");
                    bookentity.pull(((WsXxdjcljds) webobject).tbsj + "");
                }
                //-------WsXxdjclspb-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjclspb")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsXxdjclspb) webobject).ajmc + "");
                    bookentity.pull(((WsXxdjclspb) webobject).dsrqk + "");
                    bookentity.pull(((WsXxdjclspb) webobject).ajjbqk + "");
                    bookentity.pull(((WsXxdjclspb) webobject).zjmcsl + "");
                    bookentity.pull(((WsXxdjclspb) webobject).tqlyyj + "");
                    bookentity.pull(((WsXxdjclspb) webobject).cbryj + "");
                    bookentity.pull(((WsXxdjclspb) webobject).cbrqm + "");
                    bookentity.pull(((WsXxdjclspb) webobject).cbrqmrq + "");
                    bookentity.pull(((WsXxdjclspb) webobject).bmfzryj + "");
                    bookentity.pull(((WsXxdjclspb) webobject).bmfzrqm + "");
                    bookentity.pull(((WsXxdjclspb) webobject).bmfzrqmrq + "");
                    bookentity.pull(((WsXxdjclspb) webobject).jgfzryj + "");
                    bookentity.pull(((WsXxdjclspb) webobject).jgfzrqm + "");
                    bookentity.pull(((WsXxdjclspb) webobject).jgfzrqmrq + "");
                    bookentity.pull(((WsXxdjclspb) webobject).tbsj + "");
                }
                //-------WsXxdjtzs-------
                else if (webobject.getClass().getSimpleName().equals("WsXxdjtzs")) {
                    bookentity.pull(((WsXxdjtzs) webobject).pcode + "");
                    bookentity.pull(((WsXxdjtzs) webobject).ycode + "");
                    bookentity.pull(((WsXxdjtzs) webobject).ncode + "");
                    bookentity.pull(((WsXxdjtzs) webobject).bcfdw + "");
                    bookentity.pull(((WsXxdjtzs) webobject).wfxw + "");
                    bookentity.pull(((WsXxdjtzs) webobject).jdrq + "");
                    bookentity.pull(((WsXxdjtzs) webobject).djc + "");
                    bookentity.pull(((WsXxdjtzs) webobject).fzrqm + "");
                    bookentity.pull(((WsXxdjtzs) webobject).rq + "");
                }
                //-------WsXzcfdw-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfdw")) {
                    bookentity.pull(((WsXzcfdw) webobject).pcode + "");
                    bookentity.pull(((WsXzcfdw) webobject).ycode + "");
                    bookentity.pull(((WsXzcfdw) webobject).ncode + "");
                    bookentity.pull(((WsXzcfdw) webobject).bcfdw + "");
                    bookentity.pull(((WsXzcfdw) webobject).dz + "");
                    bookentity.pull(((WsXzcfdw) webobject).yb + "");
                    bookentity.pull(((WsXzcfdw) webobject).fddbr + "");
                    bookentity.pull(((WsXzcfdw) webobject).zw + "");
                    bookentity.pull(((WsXzcfdw) webobject).lxdh + "");
                    bookentity.pull(((WsXzcfdw) webobject).wfss + "");
                    bookentity.pull(((WsXzcfdw) webobject).wfgd + "");
                    bookentity.pull(((WsXzcfdw) webobject).yjgd + "");
                    bookentity.pull(((WsXzcfdw) webobject).xzcf + "");
                    bookentity.pull(((WsXzcfdw) webobject).fkfs + "");
                    bookentity.pull(((WsXzcfdw) webobject).jz + "");
                    bookentity.pull(((WsXzcfdw) webobject).zh + "");
                    bookentity.pull(((WsXzcfdw) webobject).zf + "");
                    bookentity.pull(((WsXzcfdw) webobject).sqdw + "");
                    bookentity.pull(((WsXzcfdw) webobject).rmfy + "");
                    bookentity.pull(((WsXzcfdw) webobject).zfryy + "");
                    bookentity.pull(((WsXzcfdw) webobject).zfrye + "");
                    bookentity.pull(((WsXzcfdw) webobject).dsr + "");
                    bookentity.pull(((WsXzcfdw) webobject).sj + "");
                    bookentity.pull(((WsXzcfdw) webobject).version + "");
                    bookentity.pull(((WsXzcfdw) webobject).dfzh + "");
                    bookentity.pull(((WsXzcfdw) webobject).tbsj + "");
                }
                //-------WsXzcfgr-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfgr")) {
                    bookentity.pull(((WsXzcfgr) webobject).pcode + "");
                    bookentity.pull(((WsXzcfgr) webobject).ycode + "");
                    bookentity.pull(((WsXzcfgr) webobject).ncode + "");
                    bookentity.pull(((WsXzcfgr) webobject).bcfr + "");
                    bookentity.pull(((WsXzcfgr) webobject).xb + "");
                    bookentity.pull(((WsXzcfgr) webobject).nl + "");
                    bookentity.pull(((WsXzcfgr) webobject).sfzh + "");
                    bookentity.pull(((WsXzcfgr) webobject).jtzz + "");
                    bookentity.pull(((WsXzcfgr) webobject).szdw + "");
                    bookentity.pull(((WsXzcfgr) webobject).zw + "");
                    bookentity.pull(((WsXzcfgr) webobject).dwdz + "");
                    bookentity.pull(((WsXzcfgr) webobject).lxdh + "");
                    bookentity.pull(((WsXzcfgr) webobject).wfss + "");
                    bookentity.pull(((WsXzcfgr) webobject).wfgd + "");
                    bookentity.pull(((WsXzcfgr) webobject).yjgd + "");
                    bookentity.pull(((WsXzcfgr) webobject).xzcf + "");
                    bookentity.pull(((WsXzcfgr) webobject).fkfs + "");
                    bookentity.pull(((WsXzcfgr) webobject).jz + "");
                    bookentity.pull(((WsXzcfgr) webobject).zh + "");
                    bookentity.pull(((WsXzcfgr) webobject).zf + "");
                    bookentity.pull(((WsXzcfgr) webobject).sqdw + "");
                    bookentity.pull(((WsXzcfgr) webobject).rmfy + "");
                    bookentity.pull(((WsXzcfgr) webobject).zfryy + "");
                    bookentity.pull(((WsXzcfgr) webobject).zfrye + "");
                    bookentity.pull(((WsXzcfgr) webobject).dsr + "");
                    bookentity.pull(((WsXzcfgr) webobject).sj + "");
                    bookentity.pull(((WsXzcfgr) webobject).version + "");
                    bookentity.pull(((WsXzcfgr) webobject).tbsj + "");
                }
                //-------WsXzcfgzs-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfgzs")) {
                    bookentity.pull(((WsXzcfgzs) webobject).pcode + "");
                    bookentity.pull(((WsXzcfgzs) webobject).ycode + "");
                    bookentity.pull(((WsXzcfgzs) webobject).ncode + "");
                    bookentity.pull(((WsXzcfgzs) webobject).cfdw + "");
                    bookentity.pull(((WsXzcfgzs) webobject).wfxw + "");
                    bookentity.pull(((WsXzcfgzs) webobject).gd + "");
                    bookentity.pull(((WsXzcfgzs) webobject).yj + "");
                    bookentity.pull(((WsXzcfgzs) webobject).xzcf + "");
                    bookentity.pull(((WsXzcfgzs) webobject).glbm + "");
                    bookentity.pull(((WsXzcfgzs) webobject).bmdz + "");
                    bookentity.pull(((WsXzcfgzs) webobject).bmlxr + "");
                    bookentity.pull(((WsXzcfgzs) webobject).bmlxdh + "");
                    bookentity.pull(((WsXzcfgzs) webobject).bmyb + "");
                    bookentity.pull(((WsXzcfgzs) webobject).rq + "");
                    bookentity.pull(((WsXzcfgzs) webobject).tbsj + "");
                }
                //-------WsXzcfjdsdw-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfjdsdw")) {
                    bookentity.pull(((WsXzcfjdsdw) webobject).pcode + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).ycode + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).ncode + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).bcfdw + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).dz + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).yb + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).fddbr + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).fddbrzw + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).fddbrlxdh + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).wfsszj + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).gd + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).yj + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).xzcf + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).jz + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).zh + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).rmzf + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).sqdw + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).rmfy + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).rq + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).version + "");
                    bookentity.pull(((WsXzcfjdsdw) webobject).tbsj + "");
                }
                //-------WsXzcfjdsgr-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcfjdsgr")) {
                    bookentity.pull(((WsXzcfjdsgr) webobject).pcode + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).ycode + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).ncode + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).bcfr + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).xb + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).nl + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).lxdh + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).jtzz + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).szdw + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).zw + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).dwdz + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).yb + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).wfsszj + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).gd + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).yj + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).xzcf + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).jz + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).zh + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).rmzf + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).sqdw + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).rmfy + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).rq + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).version + "");
                    bookentity.pull(((WsXzcfjdsgr) webobject).tbsj + "");
                }
                //-------WsXzcftljl-------
                else if (webobject.getClass().getSimpleName().equals("WsXzcftljl")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsXzcftljl) webobject).ajmc + "");
                    bookentity.pull(((WsXzcftljl) webobject).tlsjc + "");
                    bookentity.pull(((WsXzcftljl) webobject).tlsjm + "");
                    bookentity.pull(((WsXzcftljl) webobject).dd + "");
                    bookentity.pull(((WsXzcftljl) webobject).zcr + "");
                    bookentity.pull(((WsXzcftljl) webobject).hbr + "");
                    bookentity.pull(((WsXzcftljl) webobject).jlr + "");
                    bookentity.pull(((WsXzcftljl) webobject).cxry + "");
                    bookentity.pull(((WsXzcftljl) webobject).tlnr + "");
                    bookentity.pull(((WsXzcftljl) webobject).tljl + "");
                    bookentity.pull(((WsXzcftljl) webobject).jlxyj + "");
                    bookentity.pull(((WsXzcftljl) webobject).cxrqm + "");
                    bookentity.pull(((WsXzcftljl) webobject).tbsj + "");
                }
                //-------WsYqjnfkpzs-------
                else if (webobject.getClass().getSimpleName().equals("WsYqjnfkpzs")) {
                    bookentity.pull(((WsYqjnfkpzs) webobject).pcode + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).ycode + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).ncode + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).fkdw + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).fkrq + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).wh + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).je + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).jkfs + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).ycjzrq + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).djq + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).fqjzrq + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).fqjnje + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).swjnfk + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).rq + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).version + "");
                    bookentity.pull(((WsYqjnfkpzs) webobject).tbsj + "");
                }
                //-------WsYqjnfkspb-------
                else if (webobject.getClass().getSimpleName().equals("WsYqjnfkspb")) {
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(((WsYqjnfkspb) webobject).ajmc + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).wh + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).dsr + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).dz + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).wfss + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).ly + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).cbryj + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).cbrqm_one + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).cbrqm_two + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).cbrqmrq + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).shyj + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).shrqm + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).shrqmrq + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).spyj + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).sprqm + "");
                    bookentity.pull(((WsYqjnfkspb) webobject).sprqmrq + "");


                }
                //-------WsZgfc-------
                else if (webobject.getClass().getSimpleName().equals("WsZgfc")) {
                    bookentity.pull(((WsZgfc) webobject).pcode + "");
                    bookentity.pull(((WsZgfc) webobject).ycode + "");
                    bookentity.pull(((WsZgfc) webobject).ncode + "");
                    bookentity.pull(((WsZgfc) webobject).bjcdw + "");
                    bookentity.pull(((WsZgfc) webobject).jcsj + "");
                    bookentity.pull(((WsZgfc) webobject).jd + "");
                    bookentity.pull(((WsZgfc) webobject).jpcode + "");
                    bookentity.pull("");
                    bookentity.pull(((WsZgfc) webobject).jycode + "");
                    bookentity.pull(((WsZgfc) webobject).jncode + "");
                    bookentity.pull(((WsZgfc) webobject).yj + "");
                    bookentity.pull(((WsZgfc) webobject).fzr + "");
                    bookentity.pull(((WsZgfc) webobject).zfryy + "");
                    bookentity.pull(((WsZgfc) webobject).zfrye + "");
                    bookentity.pull(((WsZgfc) webobject).zhy + "");
                    bookentity.pull(((WsZgfc) webobject).zhe + "");
                    bookentity.pull(((WsZgfc) webobject).sj + "");
                    bookentity.pull(((WsZgfc) webobject).dfzh + "");
                    bookentity.pull(((WsZgfc) webobject).tbsj + "");
                }
                //-------WsZlxqzg-------
                else if (webobject.getClass().getSimpleName().equals("WsZlxqzg")) {
                    bookentity.pull(((WsZlxqzg) webobject).pcode + "");
                    bookentity.pull(((WsZlxqzg) webobject).ycode + "");
                    bookentity.pull(((WsZlxqzg) webobject).ncode + "");
                    bookentity.pull(((WsZlxqzg) webobject).bjcdw + "");
                    bookentity.pull(((WsZlxqzg) webobject).wtOne + "");
                    bookentity.pull(((WsZlxqzg) webobject).wtTwo + "");
                    bookentity.pull(((WsZlxqzg) webobject).wtThree + "");
                    bookentity.pull(((WsZlxqzg) webobject).wtFour + "");
                    bookentity.pull(((WsZlxqzg) webobject).djx + "");
                    bookentity.pull(((WsZlxqzg) webobject).zgrq + "");
                    bookentity.pull(((WsZlxqzg) webobject).rmzf + "");
                    bookentity.pull(((WsZlxqzg) webobject).sqdw + "");
                    bookentity.pull(((WsZlxqzg) webobject).rmfy + "");
                    bookentity.pull(((WsZlxqzg) webobject).zfryqmOne + "");
                    bookentity.pull(((WsZlxqzg) webobject).zfryqmTwo + "");
                    bookentity.pull(((WsZlxqzg) webobject).zhOne + "");
                    bookentity.pull(((WsZlxqzg) webobject).zhTwo + "");
                    bookentity.pull(((WsZlxqzg) webobject).fzrqm + "");
                    bookentity.pull(((WsZlxqzg) webobject).sj + "");
                    bookentity.pull(((WsZlxqzg) webobject).dfzh + "");
                    bookentity.pull(((WsZlxqzg) webobject).tbsj + "");
                }
                //-------WsCyqzpz-------
                else if (webobject.getClass().getSimpleName().equals("WsCyqzpz")) {
                    //------WsCyqzpz-Entity_Book4-------


                    bookentity.pull(((WsCyqzpz) webobject).pcode + "");
                    bookentity.pull(((WsCyqzpz) webobject).ycode + "");
                    bookentity.pull(((WsCyqzpz) webobject).ncode + "");
                    bookentity.pull(((WsCyqzpz) webobject).bcydw + "");
                    bookentity.pull(((WsCyqzpz) webobject).xcfzr + "");
                    bookentity.pull(((WsCyqzpz) webobject).dwdz + "");
                    bookentity.pull(((WsCyqzpz) webobject).lxdh + "");
                    bookentity.pull(((WsCyqzpz) webobject).yb + "");
                    bookentity.pull(((WsCyqzpz) webobject).cysjc + "");
                    bookentity.pull(((WsCyqzpz) webobject).cysjm + "");
                    bookentity.pull(((WsCyqzpz) webobject).cydd + "");
                    bookentity.pull(list2string(((WsCyqzpz) webobject).cyqzList) + "");
                    bookentity.pull(((WsCyqzpz) webobject).xcfzrqm + "");
                    bookentity.pull(((WsCyqzpz) webobject).zfryqmOne + "");
                    bookentity.pull(((WsCyqzpz) webobject).zfryzhOne + "");
                    bookentity.pull(((WsCyqzpz) webobject).zfryqmTwo + "");
                    bookentity.pull(((WsCyqzpz) webobject).zfryzhTwo + "");
                    bookentity.pull(((WsCyqzpz) webobject).rq + "");

                }
                //-------WsJdwts-------
                else if (webobject.getClass().getSimpleName().equals("WsJdwts")) {
                    //------WsJdwts-Entity_Book14-------

                    bookentity.pull(((WsJdwts) webobject).pcode + "");
                    bookentity.pull(((WsJdwts) webobject).ycode + "");
                    bookentity.pull(((WsJdwts) webobject).ncode + "");
                    bookentity.pull(((WsJdwts) webobject).wtdw + "");
                    bookentity.pull(list2string(((WsJdwts) webobject).jdwtsList )+ "");
                    bookentity.pull(((WsJdwts) webobject).jdyq + "");
                    bookentity.pull(((WsJdwts) webobject).jzsj + "");
                    bookentity.pull(((WsJdwts) webobject).rq + "");
                }
                //-------WsJnml-------
                else if (webobject.getClass().getSimpleName().equals("WsJnml")) {
                    //------WsJnml-Entity_Book36-------
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull("");
                    bookentity.pull(list2string(((WsJnml) webobject).jnmlList) + "");

                }
                //-------WsSdhz-------
                else if (webobject.getClass().getSimpleName().equals("WsSdhz")) {
                    //------WsSdhz-Entity_Book30-------

                    bookentity.pull(((WsSdhz) webobject).pcode + "");
                    bookentity.pull(((WsSdhz) webobject).ycode + "");
                    bookentity.pull(((WsSdhz) webobject).ncode + "");
                    bookentity.pull(((WsSdhz) webobject).ajmc + "");
                    bookentity.pull(((WsSdhz) webobject).ssddw + "");
                    bookentity.pull(list2string(((WsSdhz) webobject).sdhzList) + "");
                    bookentity.pull(((WsSdhz) webobject).bz + "");
                }
                break;
            }
        }


        return bookentity;
    }

    @Override
    public String list2string(List list) {
        String string = "";
        for (int i = 0; i < list.size(); i++) {
            Object webobject = list.get(i);
            String webobjectname = webobject.getClass().getSimpleName();
            String stringtmp = "";
//-------WsCyqz-------
            if (webobjectname.equals("WsCyqz")) {
                stringtmp = stringtmp
                        + ((WsCyqz) webobject).xh + "#"
                        + ((WsCyqz) webobject).zjwpmc + "#"
                        + ((WsCyqz) webobject).ggph + "#"
                        + ((WsCyqz) webobject).sl + "#"

                ;
            }
//-------Jdwts-------
            else if (webobjectname.equals("Jdwts")) {
                stringtmp = stringtmp
                        + ((Jdwts) webobject).wpmc + "#"
                        + ((Jdwts) webobject).ggxh + "#"
                        + ((Jdwts) webobject).sl + "#"
                        + ((Jdwts) webobject).bz + "#"

                ;
            }
//-------Sdhz-------
            else if (webobjectname.equals("Sdhz")) {
                stringtmp = stringtmp
                        + ((Sdhz) webobject).wsmc + "#"
                        + ((Sdhz) webobject).sjrqm + "#"
                        + ((Sdhz) webobject).sddd + "#"
                        + ((Sdhz) webobject).sdrq + "#"
                        + ((Sdhz) webobject).sdfs + "#"
                        + ((Sdhz) webobject).sdr + "#"

                ;
            }
//-------Jnml-------
            else if (webobjectname.equals("Jnml")) {
                stringtmp = stringtmp
                        + ((Jnml) webobject).xh + "#"
                        + ((Jnml) webobject).wjmcbh + "#"
                        + ((Jnml) webobject).rq + "#"
                        + ((Jnml) webobject).yh + "#"
                        + ((Jnml) webobject).bz + "#"

                ;
            }
            if (stringtmp.length() > 1) {
                stringtmp = stringtmp.substring(0, stringtmp.length() - 1);//去掉最后一位#
            }
            string = string + stringtmp + "@";
        }
        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);//去掉最后一位@
        }
        return string;
    }

    @Override
    public List stringlist(String string, String webobjectname) {
        List list = new ArrayList();
        String[] listitem = null;
        if (string.contains("@")) {
            listitem = string.split("@");
            for (int i = 0; i < listitem.length; i++) {
                String[] listitemitem = listitem[i].split("#");
                Object webobject = null;
                try {
                    webobject = Class.forName("com.ay.ydzf.zhifawenshu.pojo2014." + webobjectname).newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int j = 0;

//-------WsCyqz-------
                 if (webobjectname.equals("WsCyqz")) {
                    ((WsCyqz) webobject).xh = listitemitem[j++];
                    ((WsCyqz) webobject).zjwpmc = listitemitem[j++];
                    ((WsCyqz) webobject).ggph = listitemitem[j++];
                    ((WsCyqz) webobject).sl = listitemitem[j++];


                }
//-------Jdwts-------
                else if (webobjectname.equals("Jdwts")) {

                    ((Jdwts) webobject).wpmc = listitemitem[j++];
                    ((Jdwts) webobject).ggxh = listitemitem[j++];
                    ((Jdwts) webobject).sl = listitemitem[j++];
                    ((Jdwts) webobject).bz = listitemitem[j++];


                }
//-------Sdhz-------
                else if (webobjectname.equals("Sdhz")) {
                    ((Sdhz) webobject).wsmc = listitemitem[j++];
                    ((Sdhz) webobject).sjrqm = listitemitem[j++];
                    ((Sdhz) webobject).sddd = listitemitem[j++];
                    ((Sdhz) webobject).sdrq = listitemitem[j++];
                    ((Sdhz) webobject).sdfs = listitemitem[j++];
                    ((Sdhz) webobject).sdr = listitemitem[j++];


                }
//-------Jnml-------
                else if (webobjectname.equals("Jnml")) {
                    ((Jnml) webobject).xh = listitemitem[j++];
                    ((Jnml) webobject).wjmcbh = listitemitem[j++];
                    ((Jnml) webobject).rq = listitemitem[j++];
                    ((Jnml) webobject).yh = listitemitem[j++];
                    ((Jnml) webobject).bz = listitemitem[j++];


                }
                list.add(webobject);

            }

        }

        return list;
    }
    public List getChildFieldList(String field){
        List childfieldlist=new ArrayList();
        String org = field;
        String result = "";
        String[] orgarray = org.split("_");
        String[] orgarray2 = orgarray[1].split("2");
        for (int i = 0; i < orgarray2.length; i++) {
            childfieldlist.add(orgarray2[i].trim());
        }

        return childfieldlist;
    }

//    public  Intent getWenshuIntent(Activity activity, int wenshuint) throws ClassNotFoundException{
//        if(wenshuint==4||wenshuint==14||wenshuint==30||wenshuint==36){
//            return null;
//        }else{
//            return  new Intent(activity, Class.forName("com.activity.Activity_Detail_"+WEBBOOKNAME2017[wenshuint]));
//        }
//
//    }
//    public  Intent getWenshuIntent(Activity activity,String wenname) throws ClassNotFoundException{
//        for (int i = 0; i < BOOKNAMELIST.length; i++) {
//            if(i==4||i==14||i==30||i==36){
//            }else{
//                if(BOOKNAMELIST2017[i].equals(wenname)){
//                    return  new Intent(activity, Class.forName("com.activity.Activity_Detail_"+WEBBOOKNAME2017[i]));
//                }
//
//            }
//        }
//        return null;
//
//
//    }

}

interface IConvertPrint2014 {

    /**
     * 将bookentity转化为网络端的webobject
     * @param bookentity 用户app端打印展现用的实体类
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public  Object bookentity2webobject(DateBase_Entity bookentity) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    /**
     * 将网络端的webobject转化为bookentity
     * @param webobject  从web端解析到的实体类
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public DateBase_Entity webobject2bookentity(Object webobject) throws InstantiationException, IllegalAccessException, ClassNotFoundException;

    /**
     * list转化为打印类的string
     * @param list
     * @return
     */
    public String list2string(List list);

    /**
     * 打印类的string转成list
     * @param string
     * @param webobjectname
     * @return
     */
    public List stringlist(String string, String webobjectname);
}
