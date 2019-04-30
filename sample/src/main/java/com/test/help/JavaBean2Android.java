package com.test.help;

import com.ay.framework.annotation.ChineseName;
import com.codefactory.intface.CallBack;
import com.codefactory.utils.Util_File;
import com.test.bean.*;
import utils.bean.LineMenu;
import utils.Shop_Detail;
import utils.Shop_List;
import utils.bean.ModeBean;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//将实体类生成新增 修改 查看 的页面 代码 完成前置工作70%
public class JavaBean2Android {

//    private static Map<String, String> modcontents =new HashMap<>();
//    private static Map<String, String> modurl =new HashMap<>();
    public static void main(String[] args) {
//        String javaorg = Util_File.inputStream2String("Detail_Activity_Wxhxp.java");
//        String[] javaorgarray = javaorg.split("\n");
//        for (int i = 0; i < javaorgarray.length; i++) {
//            if (javaorgarray[i].trim().equals("") || javaorgarray[i].trim().matches("(.*)TODO(.*)") || javaorgarray[i].trim().matches("(.*)Override(.*)")) {
//
//            } else {
//                System.out.println("+\"" + javaorgarray[i].trim().replace("\"", "\\\"") + "\\n\"");
//            }
//
//        }
        clearFile();
        List<ModeBean> beanlist=new ArrayList<>();
        beanlist.clear();
//        //配置模式Bean来获得几种简单模式例如:update模式的提交url为qyzczb/qyzczbAction!update并且只要收集入下所示的字段也就是说控件展示只要展示这些 应对特别庞大的实体类时有用
        //添加一个业务
//        beanlist.add(new ModeBean("zfccybyh-tj","qyzczb/qyzczbAction!bmjcAdd","qyzczb.id: 09cc6f57864d4c70b70e8688a6cdf04b\n" +
//                "qyzczb.yhjb: 1402448977893\n" +
//                "qyzczb.yhlx: 2\n" +
//                "qyzczb.gdzt: \n" +
//                "qyzczb.sbsj: \n" +
//                "qyzczb.otm: -1\n" +
//                "qyzczb.tbr: 黄凯钧\n" +
//                "qyzczb.userAccount: 0668c73dbad24f9b81e37b260acf6f75\n" +
//                "qyzczb.qyid: 0668c73dbad24f9b81e37b260acf6f75\n" +
//                "qyzczb.shbm: 5d2d07c0a1724c47bb8901875b335f8b\n" +
//                "qyzczb.userName: 福建中景石化有限公司\n" +
//                "qyzczb.jcsj: 2019-03-14\n" +
//                "qyzczb.jcry: 测试人员\n" +
//                "qyzczb.jcrs: 3\n" +
//                "qyzczb.fkrq: 2019-03-14"));
//
//        parse(new Qyzczb(),beanlist);//实体和业务串
//        parseQyYingJi(beanlist);
//        parseQyzczb(beanlist);
//        parseQyya(beanlist);

//        parseQyyj2(beanlist);

//        beanlist.add(new ModeBean("EnterpriseView-ck","enterpriseView/enterpriseViewAction!getById",""));
//        parse(new EnterpriseView(),beanlist);
//        beanlist.add(new ModeBean("SpecialView-ck","specialView/specialViewAction!getById",""));
//        parse(new SpecialView(),beanlist);
//        beanlist.add(new ModeBean("Wxhxp-ck","wxhxp/wxhxpAction!getById",""));
//        parse(new Wxhxp(),beanlist);
//        beanlist.add(new ModeBean("Zdwxywzxx-ck","zdwxywzxx/zdwxywzxxAction!getById",""));
//        parse(new Zdwxywzxx(),beanlist);



        beanlist.add(new ModeBean("Gwjl-ck","gwjl/gwjlAction!getByid",""));
        parse(new Gwjl(),beanlist);
        beanlist.add(new ModeBean("Gongwen-ck","gongwen/gongwenAction!getById",""));
        parse(new Gongwen(),beanlist);
        beanlist.add(new ModeBean("Tonggao-ck","tonggao/tonggaoAction!getById",""));
        parse(new Tonggao(),beanlist);
        beanlist.add(new ModeBean("TonggaoGroup-ck","tonggaoGroup/tonggaoGroupAction!getById",""));
        parse(new TonggaoGroup(),beanlist);

    }

    public static void parseQyyj2(List<ModeBean> beanlist) {
        beanlist.add(new ModeBean("medicalSecurity-tj","medicalSecurity/medicalSecurityAction!add","medicalSecurity.id: \n" +
                "medicalSecurity.ssdw: gov\n" +
                "medicalSecurity.jgmc: 机构名称\n" +
                "medicalSecurity.jglb: ZYLB46A00\n" +
                "medicalSecurity.yljgdj: sjtd\n" +
                "medicalSecurity.fzrmc: 负责人姓名\n" +
                "medicalSecurity.fzrlxfs: 负责人联系方式\n" +
                "medicalSecurity.lxrxm: 联系人姓名\n" +
                "medicalSecurity.lxrlxfs: 联系人联系方式\n" +
                "medicalSecurity.jycl: 133\n" +
                "medicalSecurity.cws: 233\n" +
                "medicalSecurity.jgxxdz: 机构详细地址\n" +
                "medicalSecurity.jgqkjs: 机构情况介绍"));
        beanlist.add(new ModeBean("medicalSecurity-xg","medicalSecurity/medicalSecurityAction!update","medicalSecurity.id: \n" +
                "medicalSecurity.ssdw: gov\n" +
                "medicalSecurity.jgmc: 机构名称\n" +
                "medicalSecurity.jglb: ZYLB46A00\n" +
                "medicalSecurity.yljgdj: sjtd\n" +
                "medicalSecurity.fzrmc: 负责人姓名\n" +
                "medicalSecurity.fzrlxfs: 负责人联系方式\n" +
                "medicalSecurity.lxrxm: 联系人姓名\n" +
                "medicalSecurity.lxrlxfs: 联系人联系方式\n" +
                "medicalSecurity.jycl: 133\n" +
                "medicalSecurity.cws: 233\n" +
                "medicalSecurity.jgxxdz: 机构详细地址\n" +
                "medicalSecurity.jgqkjs: 机构情况介绍"));
        beanlist.add(new ModeBean("medicalSecurity-ck","medicalSecurity/medicalSecurityAction!getById","medicalSecurity.id: \n" +
                "medicalSecurity.ssdw: gov\n" +
                "medicalSecurity.jgmc: 机构名称\n" +
                "medicalSecurity.jglb: ZYLB46A00\n" +
                "medicalSecurity.yljgdj: sjtd\n" +
                "medicalSecurity.fzrmc: 负责人姓名\n" +
                "medicalSecurity.fzrlxfs: 负责人联系方式\n" +
                "medicalSecurity.lxrxm: 联系人姓名\n" +
                "medicalSecurity.lxrlxfs: 联系人联系方式\n" +
                "medicalSecurity.jycl: 133\n" +
                "medicalSecurity.cws: 233\n" +
                "medicalSecurity.jgxxdz: 机构详细地址\n" +
                "medicalSecurity.jgqkjs: 机构情况介绍"));
        parse(new MedicalSecurity(),beanlist);
        beanlist.add(new ModeBean("technicalSupport-tj","technicalSupport/technicalSupportAction!add","technicalSupport.id: \n" +
                "technicalSupport.ssdw: gov\n" +
                "technicalSupport.jgmc: 机构名称\n" +
                "technicalSupport.jgdm: 机构代\n" +
                "technicalSupport.jglb: zhb\n" +
                "technicalSupport.lsgx: sheng\n" +
                "technicalSupport.zdmj: 333\n" +
                "technicalSupport.jjmj: 333\n" +
                "technicalSupport.zgzs: 333\n" +
                "technicalSupport.jszcrys: 333\n" +
                "technicalSupport.fzrxm: 负责人姓名\n" +
                "technicalSupport.fzrlxfs: 13404217650\n" +
                "technicalSupport.lxrxm: 联系人姓名\n" +
                "technicalSupport.lxrlxfs: 13404217658\n" +
                "technicalSupport.zcrq: 2019-03-15\n" +
                "technicalSupport.jgxxdz: 机构详细地址\n" +
                "technicalSupport.jgqkjs: 机构情况介绍"));
        beanlist.add(new ModeBean("technicalSupport-xg","technicalSupport/technicalSupportAction!update","technicalSupport.id: \n" +
                "technicalSupport.ssdw: gov\n" +
                "technicalSupport.jgmc: 机构名称\n" +
                "technicalSupport.jgdm: 机构代\n" +
                "technicalSupport.jglb: zhb\n" +
                "technicalSupport.lsgx: sheng\n" +
                "technicalSupport.zdmj: 333\n" +
                "technicalSupport.jjmj: 333\n" +
                "technicalSupport.zgzs: 333\n" +
                "technicalSupport.jszcrys: 333\n" +
                "technicalSupport.fzrxm: 负责人姓名\n" +
                "technicalSupport.fzrlxfs: 13404217650\n" +
                "technicalSupport.lxrxm: 联系人姓名\n" +
                "technicalSupport.lxrlxfs: 13404217658\n" +
                "technicalSupport.zcrq: 2019-03-15\n" +
                "technicalSupport.jgxxdz: 机构详细地址\n" +
                "technicalSupport.jgqkjs: 机构情况介绍"));
        beanlist.add(new ModeBean("technicalSupport-ck","technicalSupport/technicalSupportAction!getById","technicalSupport.id: \n" +
                "technicalSupport.ssdw: gov\n" +
                "technicalSupport.jgmc: 机构名称\n" +
                "technicalSupport.jgdm: 机构代\n" +
                "technicalSupport.jglb: zhb\n" +
                "technicalSupport.lsgx: sheng\n" +
                "technicalSupport.zdmj: 333\n" +
                "technicalSupport.jjmj: 333\n" +
                "technicalSupport.zgzs: 333\n" +
                "technicalSupport.jszcrys: 333\n" +
                "technicalSupport.fzrxm: 负责人姓名\n" +
                "technicalSupport.fzrlxfs: 13404217650\n" +
                "technicalSupport.lxrxm: 联系人姓名\n" +
                "technicalSupport.lxrlxfs: 13404217658\n" +
                "technicalSupport.zcrq: 2019-03-15\n" +
                "technicalSupport.jgxxdz: 机构详细地址\n" +
                "technicalSupport.jgqkjs: 机构情况介绍"));
        parse(new TechnicalSupport(),beanlist);
    }

    public static void parseQyya(List<ModeBean> beanlist) {
        beanlist.add(new ModeBean("qyzhyjya-ck","energencyPlan/comprehensivePlanAction!getById",
                "comprehensivePlan.id: d2dfba814a6f4f09b3b17373ee13c84b\n" +
                        "comprehensivePlan.isGov: 0\n" +
                        "comprehensivePlan.planName: 测试预案\n" +
                        "comprehensivePlan.planType: 综合预案\n" +
                        "comprehensivePlan.accidentType: 01fc64894b3f4c1bbc94c6b51f9b57e7\n" +
                        "comprehensivePlan.planLevel: fd01e79944464409976de40cba6e691b\n" +
                        "comprehensivePlan.draftDate: 2019-03-14\n" +
                        "comprehensivePlan.planContentBzmd: 编制目的\n" +
                        "comprehensivePlan.planContentBzyj: 编制依据\n" +
                        "comprehensivePlan.planContentSyfw: 适用范围\n" +
                        "comprehensivePlan.planContentYjyatx: 应急预案体\n" +
                        "comprehensivePlan.planContentYjgzyz: 应急工作原则\n" +
                        "comprehensivePlan.planContentScjydw: 生产经营单位概况\n" +
                        "comprehensivePlan.planContentWxyyfxfx: 危险源与风险分析\n" +
                        "comprehensivePlan.planContentYjzztx: 应急组织体系\n" +
                        "comprehensivePlan.planContentZhjgzz: 指挥机构及职责\n" +
                        "comprehensivePlan.planContentWxyjg: 危险源监控\n" +
                        "comprehensivePlan.planContentYjxd: 预警行动\n" +
                        "comprehensivePlan.planContentXxbgycz: 信息报告与处置\n" +
                        "comprehensivePlan.planContentXyfj: 响应分级\n" +
                        "comprehensivePlan.planContentXycy: 响应程序\n" +
                        "comprehensivePlan.planContentYjjs: 应急结束\n" +
                        "comprehensivePlan.planContentXxfb: 信息发布\n" +
                        "comprehensivePlan.planContentHqcz: 后期处置\n" +
                        "comprehensivePlan.planContentTxyxxbz: 通信与信息保障\n" +
                        "comprehensivePlan.planContentPx: 培训\n" +
                        "comprehensivePlan.planContentYl: 演练\n" +
                        "comprehensivePlan.planContentJc: 奖惩\n" +
                        "comprehensivePlan.planContentSyhdy: 术语和定\n" +
                        "comprehensivePlan.planContentYjyaba: 应急预案备案\n" +
                        "comprehensivePlan.planContentWhhgx: 维护和更新\n" +
                        "comprehensivePlan.planContentZdyjs: 制定和解释")
        .setExtraHide("draftDepartment"));
        beanlist.add(new ModeBean("qyzhyjya-xg","energencyPlan/comprehensivePlanAction!update","comprehensivePlan.id: e8047a549b72473ea89d39fb3516d251\n" +
                "comprehensivePlan.planName: 测试员\n" +
                "comprehensivePlan.planType: 综合预案\n" +
                "comprehensivePlan.accidentType: 916ce6cff2ee4f0dbe9208fe20a51855\n" +
                "comprehensivePlan.accidentType: 01fc64894b3f4c1bbc94c6b51f9b57e7\n" +
                "comprehensivePlan.accidentType: 656e07156c5a4b09bf58d402379c9702\n" +
                "comprehensivePlan.accidentType: 01fc64894b3f4c1bbc94c6b51f9b57e7\n" +
                "comprehensivePlan.accidentType: f317ffb575b34b4b9ffecbd5e7aa4d67\n" +
                "comprehensivePlan.planLevel: fd01e79944464409976de40cba6e691b\n" +
                "comprehensivePlan.draftDepartmentName: 福州江阴建滔化工码头有限公司\n" +
                "comprehensivePlan.draftDate: 2019-03-08\n" +
                "comprehensivePlan.planContentBzmd: 333\n" +
                "comprehensivePlan.planContentBzyj: \n" +
                "comprehensivePlan.planContentSyfw: 444\n" +
                "comprehensivePlan.planContentYjyatx: 555\n" +
                "comprehensivePlan.planContentYjgzyz: \n" +
                "comprehensivePlan.planContentScjydw: \n" +
                "comprehensivePlan.planContentWxyyfxfx: \n" +
                "comprehensivePlan.planContentYjzztx: \n" +
                "comprehensivePlan.planContentZhjgzz: \n" +
                "comprehensivePlan.planContentWxyjg: \n" +
                "comprehensivePlan.planContentYjxd: \n" +
                "comprehensivePlan.planContentXxbgycz: \n" +
                "comprehensivePlan.planContentXyfj: \n" +
                "comprehensivePlan.planContentXycy: \n" +
                "comprehensivePlan.planContentYjjs: \n" +
                "comprehensivePlan.planContentXxfb: \n" +
                "comprehensivePlan.planContentHqcz: \n" +
                "comprehensivePlan.planContentTxyxxbz: \n" +
                "comprehensivePlan.planContentPx: \n" +
                "comprehensivePlan.planContentYl: \n" +
                "comprehensivePlan.planContentJc: \n" +
                "comprehensivePlan.planContentSyhdy: \n" +
                "comprehensivePlan.planContentYjyaba: \n" +
                "comprehensivePlan.planContentWhhgx: \n" +
                "comprehensivePlan.planContentZdyjs: "));
        beanlist.add(new ModeBean("qyzhyjya-tj","energencyPlan/comprehensivePlanAction!add",
                "comprehensivePlan.id: d2dfba814a6f4f09b3b17373ee13c84b\n" +
                "comprehensivePlan.isGov: 0\n" +
                "comprehensivePlan.planName: 测试预案\n" +
                "comprehensivePlan.planType: 综合预案\n" +
                "comprehensivePlan.accidentType: 01fc64894b3f4c1bbc94c6b51f9b57e7\n" +
                "comprehensivePlan.planLevel: fd01e79944464409976de40cba6e691b\n" +
                "comprehensivePlan.draftDate: 2019-03-14\n" +
                "comprehensivePlan.planContentBzmd: 编制目的\n" +
                "comprehensivePlan.planContentBzyj: 编制依据\n" +
                "comprehensivePlan.planContentSyfw: 适用范围\n" +
                "comprehensivePlan.planContentYjyatx: 应急预案体\n" +
                "comprehensivePlan.planContentYjgzyz: 应急工作原则\n" +
                "comprehensivePlan.planContentScjydw: 生产经营单位概况\n" +
                "comprehensivePlan.planContentWxyyfxfx: 危险源与风险分析\n" +
                "comprehensivePlan.planContentYjzztx: 应急组织体系\n" +
                "comprehensivePlan.planContentZhjgzz: 指挥机构及职责\n" +
                "comprehensivePlan.planContentWxyjg: 危险源监控\n" +
                "comprehensivePlan.planContentYjxd: 预警行动\n" +
                "comprehensivePlan.planContentXxbgycz: 信息报告与处置\n" +
                "comprehensivePlan.planContentXyfj: 响应分级\n" +
                "comprehensivePlan.planContentXycy: 响应程序\n" +
                "comprehensivePlan.planContentYjjs: 应急结束\n" +
                "comprehensivePlan.planContentXxfb: 信息发布\n" +
                "comprehensivePlan.planContentHqcz: 后期处置\n" +
                "comprehensivePlan.planContentTxyxxbz: 通信与信息保障\n" +
                "comprehensivePlan.planContentPx: 培训\n" +
                "comprehensivePlan.planContentYl: 演练\n" +
                "comprehensivePlan.planContentJc: 奖惩\n" +
                "comprehensivePlan.planContentSyhdy: 术语和定\n" +
                "comprehensivePlan.planContentYjyaba: 应急预案备案\n" +
                "comprehensivePlan.planContentWhhgx: 维护和更新\n" +
                "comprehensivePlan.planContentZdyjs: 制定和解释"));
        parse(new ComprehensivePlan(),beanlist);
        beanlist.add(new ModeBean("qyzxyjya-tj","specialPlan/specialPlanAction!add","specialPlan.id: 05e67b9285204a5db0ee09840956d276\n" +
                "specialPlan.isGov: 0\n" +
                "specialPlan.draftDepartment: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "specialPlan.planName: 44444\n" +
                "specialPlan.planType: 专项应急预案\n" +
                "specialPlan.accidentType: 01fc64894b3f4c1bbc94c6b51f9b57e7\n" +
                "specialPlan.planLevel: 98d0a496092840bea89dde41718f5be8\n" +
                "specialPlan.draftDate: 2019-03-06\n" +
                "specialPlan.typeHarmAnalysis: \n" +
                "specialPlan.basicPrinciples: \n" +
                "specialPlan.emergencyOrganizationSystem: \n" +
                "specialPlan.structureResponsibilities: \n" +
                "specialPlan.hazardControl: \n" +
                "specialPlan.actionWarning: \n" +
                "specialPlan.informationReportingProcedures: \n" +
                "specialPlan.responseGrading: \n" +
                "specialPlan.responseDegree: \n" +
                "specialPlan.disposalMeasures: \n" +
                "specialPlan.suppliesEquipment: "));
        beanlist.add(new ModeBean("qyzxyjya-ck","specialPlan/specialPlanAction!getById","specialPlan.id: 05e67b9285204a5db0ee09840956d276\n" +
                "specialPlan.isGov: 0\n" +
                "specialPlan.draftDepartment: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "specialPlan.planName: 44444\n" +
                "specialPlan.planType: 专项应急预案\n" +
                "specialPlan.accidentType: 01fc64894b3f4c1bbc94c6b51f9b57e7\n" +
                "specialPlan.planLevel: 98d0a496092840bea89dde41718f5be8\n" +
                "specialPlan.draftDate: 2019-03-06\n" +
                "specialPlan.typeHarmAnalysis: \n" +
                "specialPlan.basicPrinciples: \n" +
                "specialPlan.emergencyOrganizationSystem: \n" +
                "specialPlan.structureResponsibilities: \n" +
                "specialPlan.hazardControl: \n" +
                "specialPlan.actionWarning: \n" +
                "specialPlan.informationReportingProcedures: \n" +
                "specialPlan.responseGrading: \n" +
                "specialPlan.responseDegree: \n" +
                "specialPlan.disposalMeasures: \n" +
                "specialPlan.suppliesEquipment: ").setExtraHide("draftDepartment"));
        beanlist.add(new ModeBean("qyzxyjya-xg","specialPlan/specialPlanAction!update","specialPlan.id: 05e67b9285204a5db0ee09840956d276\n" +
                "specialPlan.planName: 44444\n" +
                "specialPlan.planType: 专项应急预案\n" +
                "specialPlan.accidentType: 01fc64894b3f4c1bbc94c6b51f9b57e7\n" +
                "specialPlan.planLevel: 98d0a496092840bea89dde41718f5be8\n" +
                "specialPlan.draftDate: 2019-03-06\n" +
                "specialPlan.typeHarmAnalysis: 1\n" +
                "specialPlan.basicPrinciples: 2\n" +
                "specialPlan.emergencyOrganizationSystem: \n" +
                "specialPlan.structureResponsibilities: 3\n" +
                "specialPlan.hazardControl: \n" +
                "specialPlan.actionWarning: 4\n" +
                "specialPlan.informationReportingProcedures: 5\n" +
                "specialPlan.responseGrading: 6\n" +
                "specialPlan.responseDegree: 7\n" +
                "specialPlan.disposalMeasures: 8\n" +
                "specialPlan.suppliesEquipment: 11"));
        parse(new SpecialPlan(),beanlist);
        beanlist.add(new ModeBean("qyxcczya-tj","tbPlanDisposal/tbPlanDisposalAction!add","onsitePlan.id: 51b20a059500494f88ca1aa6332512a4\n" +
                "onsitePlan.isGov: 0\n" +
                "onsitePlan.draftDepartment: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "onsitePlan.planName: 65555\n" +
                "onsitePlan.planType: 现场处置方案\n" +
                "onsitePlan.accidenttypeFather: 840df56256924eb08514ed50d5cc5280\n" +
                "onsitePlan.planLevel: fd01e79944464409976de40cba6e691b\n" +
                "onsitePlan.draftDate: 2019-03-14\n" +
                "onsitePlan.hazardousSubstance: 6666\n" +
                "onsitePlan.accidentCharacteristics: 11\n" +
                "onsitePlan.organizeDuty: 222\n" +
                "onsitePlan.emergencyDisposal: 33344\n" +
                "onsitePlan.attention: 555"));
        beanlist.add(new ModeBean("qyxcczya-xg","tbPlanDisposal/tbPlanDisposalAction!update","onsitePlan.id: 51b20a059500494f88ca1aa6332512a4\n" +
                "onsitePlan.planName: 65555\n" +
                "onsitePlan.planType: 现场处置方案\n" +
                "onsitePlan.accidenttypeFather: 840df56256924eb08514ed50d5cc5280\n" +
                "onsitePlan.planLevel: fd01e79944464409976de40cba6e691b\n" +
                "onsitePlan.draftDate: 2019-03-14\n" +
                "onsitePlan.hazardousSubstance: 6666\n" +
                "onsitePlan.accidentCharacteristics: 11\n" +
                "onsitePlan.organizeDuty: 222\n" +
                "onsitePlan.emergencyDisposal: 33344\n" +
                "onsitePlan.attention: 555"));
        beanlist.add(new ModeBean("qyxcczya-ck","tbPlanDisposal/tbPlanDisposalAction!getById","onsitePlan.id: 51b20a059500494f88ca1aa6332512a4\n" +
                "onsitePlan.planName: 65555\n" +
                "onsitePlan.planType: 现场处置方案\n" +
                "onsitePlan.accidenttypeFather: 840df56256924eb08514ed50d5cc5280\n" +
                "onsitePlan.planLevel: fd01e79944464409976de40cba6e691b\n" +
                "onsitePlan.draftDate: 2019-03-14\n" +
                "onsitePlan.hazardousSubstance: 6666\n" +
                "onsitePlan.accidentCharacteristics: 11\n" +
                "onsitePlan.organizeDuty: 222\n" +
                "onsitePlan.emergencyDisposal: 33344\n" +
                "onsitePlan.attention: 555").setExtraHide("draftDepartment"));
        parse(new OnsitePlan(),beanlist);
    }

    public static void parseQyzczb(List<ModeBean> beanlist) {
        beanlist.add(new ModeBean("zfccybyh-ck","qyzczb/qyzczbAction!getById","{\"id\":\"7baa9eed94234c6cbde4983e6e9417a0\",\"status\":\"1\",\"created\":\"10a858e63dd3491086420e646482a690\",\"createdDept\":null,\"createTime\":1551768548000,\"updated\":\"10a858e63dd3491086420e646482a690\",\"updateTime\":1551768548000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"bf2e4b54fa23439fa5c66b6a0abf8ee0\",\"bjcbw\":null,\"jcsj\":\"2019-01-17\",\"jcry\":\"郭清煌、蔡闽，刘纪鹏\",\"yhjb\":\"1402448977893\",\"jclb\":null,\"yhdl\":null,\"yhzl\":null,\"zgzrbm\":null,\"zgzrr\":null,\"jhwcsj\":null,\"zgzt\":null,\"fcsj\":null,\"fcr\":null,\"zgtrzj\":null,\"czwtyh\":null,\"czwtyhbz\":null,\"zgcsfa\":null,\"ysqk\":null,\"shbm\":\"5d2d07c0a1724c47bb8901875b335f8b\",\"shr\":\"10a858e63dd3491086420e646482a690\",\"shsj\":\"2019-03-05 14:49:08\",\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-03-05 14:49:08\",\"sblx\":null,\"dqzt\":null,\"yhlx\":\"2\",\"qysfzcgyh\":null,\"fid\":null,\"jcrs\":\"3\",\"fkrq\":\"2019-02-17\",\"otm\":\"-1\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"一般隐患\",\"yhlbVal\":null,\"yhdlVal\":\"\",\"yhzlVal\":\"\",\"zgztVal\":\"\",\"jclbVal\":\"\",\"shrVal\":\"黄凯钧\",\"account\":null,\"userName\":\"福州东进世美肯科技有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":\"江阴化工区应救援中心\",\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"bf2e4b54fa23439fa5c66b6a0abf8ee0\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"危险化学品生产企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":\"黄凯钧\",\"yhdd\":null,\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":\"\",\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":null,\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":\"\",\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":\"\",\"bsb\":\"1\",\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":\"\",\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"zgqk\":null}")
                .setExtraHide("userAccount,yhjb,shr,shbm,yhlx,otm,bsb"));
        beanlist.add(new ModeBean("zfccybyh-xg","qyzczb/qyzczbAction!update","qyzczb.id: 7baa9eed94234c6cbde4983e6e9417a0\n" +
                "qyzczb.sbsj: 2019-03-05 14:49:08\n" +
                "qyzczb.tbr: 黄凯钧\n" +
                "qyzczb.userName: 福州东进世美肯科技有限公司\n" +
                "qyzczb.jcsj: 2019-01-17\n" +
                "qyzczb.jcry: 郭清煌、蔡闽，刘纪鹏\n" +
                "qyzczb.jcrs: 4\n" +
                "qyzczb.fkrq: 2019-02-17"));
        beanlist.add(new ModeBean("zfccybyh-jcjl-ck","qyzczb/qyzczbAction!getById","{\"id\":\"94958850ea7c43a0927e54d617d53777\",\"status\":\"1\",\"created\":\"10a858e63dd3491086420e646482a690\",\"createdDept\":null,\"createTime\":1551769232000,\"updated\":\"10a858e63dd3491086420e646482a690\",\"updateTime\":1551854139000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"bf2e4b54fa23439fa5c66b6a0abf8ee0\",\"bjcbw\":\"喷淋塔\",\"jcsj\":\"2019-01-17\",\"jcry\":\"郭清煌、蔡闽，刘纪鹏\",\"yhjb\":\"1402448977893\",\"jclb\":null,\"yhdl\":\"1402450932605\",\"yhzl\":\"1402451758659\",\"zgzrbm\":null,\"zgzrr\":null,\"jhwcsj\":\"2019-02-17\",\"zgzt\":\"0\",\"fcsj\":\"2019-03-06\",\"fcr\":\"市安监局\",\"zgtrzj\":null,\"czwtyh\":\"喷淋塔控制柜外壳未重复接地\",\"czwtyhbz\":null,\"zgcsfa\":null,\"ysqk\":null,\"shbm\":\"5d2d07c0a1724c47bb8901875b335f8b\",\"shr\":\"10a858e63dd3491086420e646482a690\",\"shsj\":\"2019-03-05 15:00:32\",\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-03-05 15:00:32\",\"sblx\":null,\"dqzt\":null,\"yhlx\":\"2\",\"qysfzcgyh\":null,\"fid\":null,\"jcrs\":\"3\",\"fkrq\":\"2019-02-17\",\"otm\":\"7baa9eed94234c6cbde4983e6e9417a0\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"一般隐患\",\"yhlbVal\":null,\"yhdlVal\":\"现场管理\",\"yhzlVal\":\"设备设施（生产设备设施及工艺）\",\"zgztVal\":\"长江\",\"jclbVal\":\"\",\"shrVal\":\"黄凯钧\",\"account\":null,\"userName\":\"福州东进世美肯科技有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":\"江阴化工区应救援中心\",\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"bf2e4b54fa23439fa5c66b6a0abf8ee0\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"危险化学品生产企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":\"黄凯钧\",\"yhdd\":\"喷淋塔\",\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":\"\",\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":null,\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":\"111\",\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":\"\",\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":\"\",\"bsb\":\"1\",\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":\"\",\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"zgqk\":null}"));
        beanlist.add(new ModeBean("zfccybyh-jcjl-zg","qyzczb/qyzczbAction!zgwc","qyzczb.id: b121354ae4034a5db02ea92a9b961c25\n" +
                "qyzczb.zffcjl: \n" +
                "qyzczb.fcr: 市安监局\n" +
                "qyzczb.fcsj: 2019-03-27\n" +
                "qyzczb.zgzt: 0\n" +
                "qyzczb.zffcyj: 3333"));
        beanlist.add(new ModeBean("zfccybyh-jcjl-xg","qyzczb/qyzczbAction!update","qyzczb.id: b121354ae4034a5db02ea92a9b961c25\n" +
                "qyzczb.sbsj: 2019-03-05 14:58:50\n" +
                "qyzczb.tbr: 黄凯钧\n" +
                "qyzczb.userAccount: bf2e4b54fa23439fa5c66b6a0abf8ee0\n" +
                "qyzczb.qyid: bf2e4b54fa23439fa5c66b6a0abf8ee0\n" +
                "qyzczb.userName: 福州东进世美肯科技有限公司\n" +
                "qyzczb.jcsj: 2019-01-17\n" +
                "qyzczb.jcry: 郭清煌、蔡闽，刘纪鹏\n" +
                "qyzczb.yhdd: 甲类仓库\n" +
                "qyzczb.bjcbw: 甲类仓库\n" +
                "qyzczb.jhwcsj: 2019-02-17\n" +
                "qyzczb.zgzt: 0\n" +
                "qyzczb.yhdl: 1402450932605\n" +
                "qyzczb.yhzl: 1402451717878\n" +
                "qyzczb.czwtyh: 甲类仓库门口开关箱外壳未重复接地88").setExtraHide("userAccount"));
        beanlist.add(new ModeBean("zfcczdyh-ck","qyzczb/qyzczbAction!getById","{\"id\":\"688819941bdc46d3a7d367a5509c1769\",\"status\":\"1\",\"created\":\"10a858e63dd3491086420e646482a690\",\"createdDept\":null,\"createTime\":1551339314000,\"updated\":\"10a858e63dd3491086420e646482a690\",\"updateTime\":1551339314000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"0668c73dbad24f9b81e37b260acf6f75\",\"bjcbw\":null,\"jcsj\":\"2019-01-16\",\"jcry\":\"测试人员\",\"yhjb\":\"1402449069883\",\"jclb\":null,\"yhdl\":null,\"yhzl\":null,\"zgzrbm\":null,\"zgzrr\":null,\"jhwcsj\":null,\"zgzt\":null,\"fcsj\":null,\"fcr\":null,\"zgtrzj\":null,\"czwtyh\":null,\"czwtyhbz\":null,\"zgcsfa\":null,\"ysqk\":null,\"shbm\":\"5d2d07c0a1724c47bb8901875b335f8b\",\"shr\":\"10a858e63dd3491086420e646482a690\",\"shsj\":\"2019-02-28 15:35:14\",\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-02-28 15:35:14\",\"sblx\":null,\"dqzt\":null,\"yhlx\":\"2\",\"qysfzcgyh\":null,\"fid\":null,\"jcrs\":\"2\",\"fkrq\":\"2019-02-20\",\"otm\":\"-1\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"重大隐患\",\"yhlbVal\":null,\"yhdlVal\":\"\",\"yhzlVal\":\"\",\"zgztVal\":\"\",\"jclbVal\":\"\",\"shrVal\":\"黄凯钧\",\"account\":null,\"userName\":\"福建中景石化有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":\"江阴化工区应救援中心\",\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"0668c73dbad24f9b81e37b260acf6f75\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"危险化学品仓储企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":\"黄凯钧\",\"yhdd\":null,\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":\"\",\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":\"7\",\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":\"\",\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":\"0\",\"bsb\":\"1\",\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":\"\",\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"zgqk\":null}")
                .setExtraHide("userAccount,yhjb,shr,shbm,yhlx,otm,bsb"));
        beanlist.add(new ModeBean("zfcczdyh-xg","qyzczb/qyzczbAction!update","qyzczb.id: 688819941bdc46d3a7d367a5509c1769\n" +
                "qyzczb.sbsj: 2019-02-28 15:35:14\n" +
                "qyzczb.tbr: 黄凯钧\n" +
                "qyzczb.userName: 福建中景石化有限公司\n" +
                "qyzczb.jcsj: 2019-01-16\n" +
                "qyzczb.jcry: 测试人员\n" +
                "qyzczb.jcrs: 3\n" +
                "qyzczb.fkrq: 2019-02-20"));
        beanlist.add(new ModeBean("zfcczdyh-jcjl-ck","qyzczb/qyzczbAction!getById","{\"id\":\"176cce8812d14444aaa3b4930ba310cf\",\"status\":\"1\",\"created\":\"10a858e63dd3491086420e646482a690\",\"createdDept\":null,\"createTime\":1551421738000,\"updated\":\"10a858e63dd3491086420e646482a690\",\"updateTime\":1551855035000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"0668c73dbad24f9b81e37b260acf6f75\",\"bjcbw\":\"测试隐患部位\",\"jcsj\":\"2019-01-16\",\"jcry\":\"测试人员\",\"yhjb\":\"1402449069883\",\"jclb\":null,\"yhdl\":\"1402450932605\",\"yhzl\":\"1402451760659\",\"zgzrbm\":null,\"zgzrr\":null,\"jhwcsj\":\"2019-02-20\",\"zgzt\":\"0\",\"fcsj\":null,\"fcr\":null,\"zgtrzj\":null,\"czwtyh\":\"测试隐患数据44\",\"czwtyhbz\":null,\"zgcsfa\":null,\"ysqk\":null,\"shbm\":\"5d2d07c0a1724c47bb8901875b335f8b\",\"shr\":\"10a858e63dd3491086420e646482a690\",\"shsj\":\"2019-03-01 14:28:58\",\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-03-01 14:28:58\",\"sblx\":null,\"dqzt\":null,\"yhlx\":\"2\",\"qysfzcgyh\":null,\"fid\":null,\"jcrs\":\"2\",\"fkrq\":\"2019-02-20\",\"otm\":\"688819941bdc46d3a7d367a5509c1769\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"重大隐患\",\"yhlbVal\":null,\"yhdlVal\":\"现场管理\",\"yhzlVal\":\"原辅物料、产品\",\"zgztVal\":\"长江\",\"jclbVal\":\"\",\"shrVal\":\"黄凯钧\",\"account\":null,\"userName\":\"福建中景石化有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":\"江阴化工区应救援中心\",\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"0668c73dbad24f9b81e37b260acf6f75\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"危险化学品仓储企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":\"黄凯钧\",\"yhdd\":\"测试隐患地点\",\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":\"\",\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":\"1\",\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":\"\",\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":\"0\",\"bsb\":\"1\",\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":\"\",\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"zgqk\":null}"));
        beanlist.add(new ModeBean("zfcczdyh-jcjl-xg","qyzczb/qyzczbAction!update","qyzczb.id: 176cce8812d14444aaa3b4930ba310cf\n" +
                "qyzczb.sbsj: 2019-03-01 14:28:58\n" +
                "qyzczb.yhdd: 测试隐患地点\n" +
                "qyzczb.bjcbw: 测试隐患部位\n" +
                "qyzczb.jhwcsj: 2019-02-20\n" +
                "qyzczb.zgzt: 0\n" +
                "qyzczb.yhdl: 1402450932605\n" +
                "qyzczb.yhzl: 1402451760659\n" +
                "qyzczb.czwtyh: 测试隐患数据445"));
        beanlist.add(new ModeBean("zfcczdyh-jcjl-gpdb","qyzczb/qyzczbAction!update",
                "qyzczb.zdyhzt: 3\n" +
                "qyzczb.yhlx: 2\n" +
                "qyzczb.id: 176cce8812d14444aaa3b4930ba310cf\n" +
                "qyzczb.qyid: 0668c73dbad24f9b81e37b260acf6f75\n" +
                "qyzczb.dqzt: 3\n" +
                "qyzczb.zdwxyjb: zdyhejyh756464\n" +
                "qyzczb.ccrname: 333\n" +
                "qyzczb.ccsj: 2019-02-25\n" +
                "qyzczb.dbdw: 444\n" +
                "qyzczb.ccsm: 2019-03-14").setExtraHide("yhlx,dqzt,zdyhzt"));
        beanlist.add(new ModeBean("zfccybyh-tj",
                "qyzczb/qyzczbAction!bmjcAdd",
                "qyzczb.id: a0939da6a9194a669db28cb753329a57\n" +
                "qyzczb.yhjb: 1402448977893\n" +
                "qyzczb.yhlx: 2\n" +
                "qyzczb.gdzt: \n" +
                "qyzczb.sbsj: \n" +
                "qyzczb.otm: -1\n" +
                "qyzczb.tbr: 黄凯钧\n" +
                "qyzczb.userAccount: 0668c73dbad24f9b81e37b260acf6f75\n" +
                "qyzczb.qyid: 0668c73dbad24f9b81e37b260acf6f75\n" +
                "qyzczb.shbm: 5d2d07c0a1724c47bb8901875b335f8b\n" +
                "qyzczb.userName: 福建中景石化有限公司\n" +
                "qyzczb.jcsj: 2019-03-05\n" +
                "qyzczb.jcry: 郭清煌、蔡闽，刘纪鹏\n" +
                "qyzczb.jcrs: 3\n" +
                "qyzczb.fkrq: 2019-03-07").setExtraHide("userAccount,yhjb,yhlx,gdzt,sbsj,shbm,otm"));
        beanlist.add(new ModeBean("zfcczdyh-tj","qyzczb/qyzczbAction!bmjcAdd","qyzczb.id: eee8d149479740c699ba98b9ccbf2f3d\n" +
                "qyzczb.yhjb: 1402449069883\n" +
                "qyzczb.yhlx: 2\n" +
                "qyzczb.gdzt: 0\n" +
                "qyzczb.sbsj: \n" +
                "qyzczb.otm: -1\n" +
                "qyzczb.tbr: 黄凯钧\n" +
                "qyzczb.userAccount: 3a276f037a404a16966f23e13cc27165\n" +
                "qyzczb.qyid: 3a276f037a404a16966f23e13cc27165\n" +
                "qyzczb.shbm: 5d2d07c0a1724c47bb8901875b335f8b\n" +
                "qyzczb.userName: 福建省福抗药业股份有限公司\n" +
                "qyzczb.jcsj: 2019-03-07\n" +
                "qyzczb.jcry: 测试人员\n" +
                "qyzczb.jcrs: 4\n" +
                "qyzczb.fkrq: 2019-03-07"));
        beanlist.add(new ModeBean("zfcczdyh-jcjl-tj","qyzczb/qyzczbAction!bmjcAdd",
                "qyzczb.id: 55f131617edf44c5b3a222524a6462fa\n" +
                "qyzczb.yhjb: 1402448977893\n" +
                "qyzczb.yhlx: 2\n" +
                "qyzczb.gdzt: \n" +
                "qyzczb.sbsj: \n" +
                "qyzczb.otm: a0939da6a9194a669db28cb753329a57\n" +
                "qyzczb.yhdd: 测试隐患地点\n" +
                "qyzczb.bjcbw: 测试隐患部位\n" +
                "qyzczb.jhwcsj: 2019-03-07\n" +
                "qyzczb.zgzt: 0\n" +
                "qyzczb.yhdl: 1402450901716\n" +
                "qyzczb.yhzl: 1402451227916\n" +
                "qyzczb.czwtyh: iooiiiii"));
        beanlist.add(new ModeBean("zfccybyh-jcjl-tj","qyzczb/qyzczbAction!bmjcAdd","qyzczb.id: 55f131617edf44c5b3a222524a6462fa\n" +
                "qyzczb.yhjb: 1402448977893\n" +
                "qyzczb.yhlx: 2\n" +
                "qyzczb.gdzt: \n" +
                "qyzczb.sbsj: \n" +
                "qyzczb.otm: a0939da6a9194a669db28cb753329a57\n" +
                "qyzczb.yhdd: 测试隐患地点\n" +
                "qyzczb.bjcbw: 测试隐患部位\n" +
                "qyzczb.jhwcsj: 2019-03-07\n" +
                "qyzczb.zgzt: 0\n" +
                "qyzczb.yhdl: 1402450901716\n" +
                "qyzczb.yhzl: 1402451227916\n" +
                "qyzczb.czwtyh: iooiiiii"));
        beanlist.add(new ModeBean("zfccyhgd-ck","qyzczb/qyzczbAction!getById","{\"id\":\"a9805eae5deb42c8921fcfe3227e05bd\",\"status\":\"1\",\"created\":\"10a858e63dd3491086420e646482a690\",\"createdDept\":null,\"createTime\":1551424248000,\"updated\":\"10a858e63dd3491086420e646482a690\",\"updateTime\":1551424267000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"0668c73dbad24f9b81e37b260acf6f75\",\"bjcbw\":null,\"jcsj\":\"2019-01-16\",\"jcry\":\"测试人员2\",\"yhjb\":\"1402448977893\",\"jclb\":null,\"yhdl\":null,\"yhzl\":null,\"zgzrbm\":null,\"zgzrr\":null,\"jhwcsj\":null,\"zgzt\":null,\"fcsj\":null,\"fcr\":null,\"zgtrzj\":null,\"czwtyh\":null,\"czwtyhbz\":null,\"zgcsfa\":null,\"ysqk\":null,\"shbm\":\"5d2d07c0a1724c47bb8901875b335f8b\",\"shr\":\"10a858e63dd3491086420e646482a690\",\"shsj\":\"2019-03-01 15:10:48\",\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-03-01 15:10:48\",\"sblx\":null,\"dqzt\":null,\"yhlx\":\"2\",\"qysfzcgyh\":null,\"fid\":null,\"jcrs\":\"3\",\"fkrq\":\"2019-02-20\",\"otm\":\"-1\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"一般隐患\",\"yhlbVal\":null,\"yhdlVal\":\"\",\"yhzlVal\":\"\",\"zgztVal\":\"\",\"jclbVal\":\"\",\"shrVal\":\"黄凯钧\",\"account\":null,\"userName\":\"福建中景石化有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":\"江阴化工区应救援中心\",\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"0668c73dbad24f9b81e37b260acf6f75\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"危险化学品仓储企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":\"黄凯钧\",\"yhdd\":null,\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":\"\",\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":null,\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":\"\",\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":\"9\",\"bsb\":\"1\",\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":\"\",\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"zgqk\":null}")
                .setExtraHide("userAccount,yhjb,shr,shbm,yhlx,otm,bsb"));
        beanlist.add(new ModeBean("zfccyhgd-jcjl-ck","qyzczb/qyzczbAction!getById","{\"id\":\"a9805eae5deb42c8921fcfe3227e05bd\",\"status\":\"1\",\"created\":\"10a858e63dd3491086420e646482a690\",\"createdDept\":null,\"createTime\":1551424248000,\"updated\":\"10a858e63dd3491086420e646482a690\",\"updateTime\":1551424267000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"0668c73dbad24f9b81e37b260acf6f75\",\"bjcbw\":null,\"jcsj\":\"2019-01-16\",\"jcry\":\"测试人员2\",\"yhjb\":\"1402448977893\",\"jclb\":null,\"yhdl\":null,\"yhzl\":null,\"zgzrbm\":null,\"zgzrr\":null,\"jhwcsj\":null,\"zgzt\":null,\"fcsj\":null,\"fcr\":null,\"zgtrzj\":null,\"czwtyh\":null,\"czwtyhbz\":null,\"zgcsfa\":null,\"ysqk\":null,\"shbm\":\"5d2d07c0a1724c47bb8901875b335f8b\",\"shr\":\"10a858e63dd3491086420e646482a690\",\"shsj\":\"2019-03-01 15:10:48\",\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-03-01 15:10:48\",\"sblx\":null,\"dqzt\":null,\"yhlx\":\"2\",\"qysfzcgyh\":null,\"fid\":null,\"jcrs\":\"3\",\"fkrq\":\"2019-02-20\",\"otm\":\"-1\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"一般隐患\",\"yhlbVal\":null,\"yhdlVal\":\"\",\"yhzlVal\":\"\",\"zgztVal\":\"\",\"jclbVal\":\"\",\"shrVal\":\"黄凯钧\",\"account\":null,\"userName\":\"福建中景石化有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":\"江阴化工区应救援中心\",\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"0668c73dbad24f9b81e37b260acf6f75\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"危险化学品仓储企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":\"黄凯钧\",\"yhdd\":null,\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":\"\",\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":null,\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":\"\",\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":\"9\",\"bsb\":\"1\",\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":\"\",\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"zgqk\":null}"));
        parse(new Qyzczb(),beanlist);

        beanlist.add(new ModeBean("qyzcybyh-ck","qyzczbN/qyzczbNAction!getById","{\"id\":\"f7d9bd16024c49769225e3448b2ddae9\",\"status\":\"1\",\"created\":\"e4819804241c41f4a56171c92c67b353\",\"createdDept\":null,\"createTime\":1551753711000,\"updated\":\"e4819804241c41f4a56171c92c67b353\",\"updateTime\":1551753795000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"e4819804241c41f4a56171c92c67b353\",\"bjcbw\":\"电解装置\",\"jcsj\":\"2019-03-05\",\"jcry\":\"杨工\",\"yhjb\":\"1402448977893\",\"jclb\":\"1402450826247\",\"yhdl\":\"1402450932605\",\"yhzl\":\"1402451758659\",\"zgzrbm\":\"烧碱车间\",\"zgzrr\":\"程彪\",\"zgzrrlxfs\":\"2086\",\"jhwcsj\":\"2019-03-14\",\"zgzt\":\"1\",\"fcsj\":\"2019-03-07\",\"fcr\":\"杨工\",\"zgtrzj\":\"0\",\"czwtyh\":\"机泵故障\",\"czwtyhbz\":null,\"zgcsfa\":\"修复或更换机泵\",\"ysqk\":null,\"shbm\":\"e4819804241c41f4a56171c92c67b353\",\"shr\":\"e4819804241c41f4a56171c92c67b353\",\"shsj\":\"2019-03-05\",\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-03-05\",\"sblx\":\"0\",\"dqzt\":\"3\",\"yhlx\":\"1\",\"qysfzcgyh\":null,\"fid\":null,\"yhgs\":null,\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"一般隐患\",\"yhlbVal\":null,\"yhdlVal\":\"现场管理\",\"yhzlVal\":\"设备设施（生产设备设施及工艺）\",\"zgztVal\":\"已整改\",\"jclbVal\":\"班组检查\",\"shrVal\":\"福建省东南电化股份有限公司\",\"account\":null,\"userName\":\"福建省东南电化股份有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":null,\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"e4819804241c41f4a56171c92c67b353\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"危险化学品经营带存储企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":null,\"yhdd\":null,\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":null,\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":null,\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":null,\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":null,\"bsb\":null,\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":null,\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"sfyq\":null,\"sfyqF\":null,\"sfyqS\":null}"));
        beanlist.add(new ModeBean("qyzczdyh-ck","qyzczbN/qyzczbNAction!getById","{\"id\":\"3e2dcef739ce45b8a180cb0a66ac797a\",\"status\":\"1\",\"created\":\"0668c73dbad24f9b81e37b260acf6f75\",\"createdDept\":null,\"createTime\":1551662772000,\"updated\":\"0668c73dbad24f9b81e37b260acf6f75\",\"updateTime\":1551662804000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"0668c73dbad24f9b81e37b260acf6f75\",\"bjcbw\":\"罐区S-2\",\"jcsj\":\"2019-03-05\",\"jcry\":\"检察人员\",\"yhjb\":\"1402449069883\",\"jclb\":\"1402450826247\",\"yhdl\":\"1402450901716\",\"yhzl\":\"1402451227916\",\"zgzrbm\":\"整改责任部门\",\"zgzrr\":\"整改责任人\",\"zgzrrlxfs\":\"13111111111\",\"jhwcsj\":\"2019-03-06\",\"zgzt\":\"0\",\"fcsj\":\"\",\"fcr\":\"\",\"zgtrzj\":\"333.00\",\"czwtyh\":\"333\",\"czwtyhbz\":null,\"zgcsfa\":\"333\",\"ysqk\":null,\"shbm\":\"0668c73dbad24f9b81e37b260acf6f75\",\"shr\":null,\"shsj\":null,\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":\"2019-03-04\",\"sblx\":\"0\",\"dqzt\":\"1\",\"yhlx\":\"1\",\"qysfzcgyh\":null,\"fid\":null,\"yhgs\":\"2\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"重大隐患\",\"yhlbVal\":null,\"yhdlVal\":\"基础管理\",\"yhzlVal\":\"安全生产责任制\",\"zgztVal\":\"未整改\",\"yhgsVal\":\"环保\",\"jclbVal\":\"班组检查\",\"shrVal\":null,\"account\":null,\"userName\":\"福建中景石化有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":null,\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"0668c73dbad24f9b81e37b260acf6f75\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"其他企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":null,\"yhdd\":null,\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":null,\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":null,\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":null,\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":null,\"bsb\":null,\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":null,\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"sfyq\":null,\"sfyqF\":null,\"sfyqS\":null}"));

        parse(new QyzczbN(),beanlist);
        beanlist.add(new ModeBean("qyzczbyh-ck","qyzczbN/qyzczbNAction!getById","{\"id\":\"73307e937d28464299023c754dde8bf7\",\"status\":\"1\",\"created\":\"5c6bf34df59a495bb2310895a93e6df4\",\"createdDept\":null,\"createTime\":1552459569000,\"updated\":\"5c6bf34df59a495bb2310895a93e6df4\",\"updateTime\":1552467082000,\"diysql\":null,\"org\":null,\"orgTree\":null,\"condition\":null,\"noWatch\":\"N\",\"noPagination\":\"N\",\"definitionKey\":null,\"actProcessInstanceId\":null,\"reviewTaskList\":null,\"sun\":null,\"userAccount\":\"5c6bf34df59a495bb2310895a93e6df4\",\"bjcbw\":\"被检查部位\",\"jcsj\":\"2019-03-13\",\"jcry\":\"检查人员\",\"yhjb\":\"1402448977893\",\"jclb\":\"1402450826247\",\"yhdl\":\"1402450901716\",\"yhzl\":\"1402cdvd020447\",\"zgzrbm\":\"责任部门\",\"zgzrr\":\"责任人\",\"zgzrrlxfs\":\"责任人联系方式\",\"jhwcsj\":\"2019-03-14\",\"zgzt\":\"0\",\"fcsj\":\"\",\"fcr\":\"\",\"zgtrzj\":\"0\",\"czwtyh\":\"存在问题1\",\"czwtyhbz\":null,\"zgcsfa\":\"方案\",\"ysqk\":null,\"shbm\":null,\"shr\":null,\"shsj\":null,\"shjl\":null,\"shyj\":null,\"shyjcity\":null,\"shyjprovince\":null,\"sbsj\":null,\"sblx\":null,\"dqzt\":\"0\",\"yhlx\":\"1\",\"qysfzcgyh\":null,\"fid\":null,\"yhgs\":\"2\",\"beginJcsj\":null,\"endJcsj\":null,\"yhjbVal\":\"一般隐患\",\"yhlbVal\":null,\"yhdlVal\":\"基础管理\",\"yhzlVal\":\"安全操作规程\",\"zgztVal\":\"未整改\",\"yhgsVal\":\"环保\",\"jclbVal\":\"班组检查\",\"shrVal\":null,\"account\":null,\"userName\":\"福州江阴建滔化工码头有限公司\",\"beginSbsj\":null,\"endSbsj\":null,\"sfsb\":null,\"shbmVal\":null,\"sfzdyh\":null,\"lsjtAccount\":null,\"qyid\":\"5c6bf34df59a495bb2310895a93e6df4\",\"ccsffxyh\":null,\"zgwcsj\":null,\"zxjghyb\":null,\"zxjghybName\":\"其他企业\",\"tsr\":null,\"tsrdh\":null,\"tbr\":null,\"yhdd\":null,\"zgwcrq\":null,\"zglx\":null,\"zglxVal\":null,\"sfjc\":null,\"ccrname\":null,\"ccsj\":null,\"ccsm\":null,\"psjgid\":null,\"psjgName\":null,\"zdyhzt\":null,\"yhzgtz\":null,\"dbdw\":null,\"zffcjl\":null,\"zffcyj\":null,\"fcbm\":null,\"yjya\":null,\"xhdw\":null,\"xhrname\":null,\"xhrq\":null,\"xhyj\":null,\"xhjg\":null,\"zdwxyjb\":null,\"zdwxyjbVal\":null,\"jgzrdw\":null,\"jgzrr\":null,\"hcrq\":null,\"hcdw\":null,\"hcqk\":null,\"ysjg\":null,\"pcid\":null,\"qdid\":null,\"qdjcxid\":null,\"yhyszj\":null,\"yhyszjzz\":null,\"zjysyj\":null,\"zjzz\":null,\"yhpclzj\":null,\"zjzzcity\":null,\"yhyszjcity\":null,\"zjzzprovince\":null,\"yhyszprovince\":null,\"yjtrzj\":null,\"gdzt\":null,\"bsb\":null,\"zlmbrw\":null,\"jfwzls\":null,\"zlyq\":null,\"aqcsyya\":null,\"tsjbyhZt\":null,\"cxm\":null,\"tsjbclbm\":null,\"tsjbyhjdyj\":null,\"yhly\":null,\"ksdrid\":null,\"qxyyqk\":null,\"cityyyqk\":null,\"provinceyyqk\":null,\"hdqkid\":null,\"viewzt\":null,\"jgname\":null,\"jgnameArea\":null,\"jgnameProvince\":null,\"sfyyzj\":null,\"qyyyqk\":null,\"qyzjzz\":null,\"qyzjcy\":null,\"qyjgname\":null,\"qyyj\":null,\"jcbm\":null,\"zynl\":null,\"zynlName\":null,\"ywyh\":null,\"sftczgyj\":null,\"zgqksm\":null,\"sfyq\":null,\"sfyqF\":null,\"sfyqS\":null}").setExtraHide("userAccount,yhjb,yhlx,gdzt,sbsj,shbm,otm"));
        beanlist.add(new ModeBean("qyzczbyh-tj","qyzczbN/qyzczbNAction!add","qyzczbN.id: 73307e937d28464299023c754dde8bf7\n" +
                "qyzczbN.bjcbw: 被检查部位\n" +
                "qyzczbN.jcsj: 2019-03-13\n" +
                "qyzczbN.jcry: 检查人员\n" +
                "qyzczbN.jclb: 1402450826247\n" +
                "qyzczbN.yhdl: 1402450901716\n" +
                "qyzczbN.yhzl: 1402cdvd020447\n" +
                "qyzczbN.zgzrbm: 责任部门\n" +
                "qyzczbN.zgzrr: 责任人\n" +
                "qyzczbN.zgzrrlxfs: 责任人联系方式\n" +
                "qyzczbN.yhgs: 2\n" +
                "qyzczbN.jhwcsj: 2019-03-14\n" +
                "qyzczbN.zgzt: 0\n" +
                "qyzczbN.yhjb: 1402448977893\n" +
                "qyzczbN.zgtrzj: 0\n" +
                "qyzczbN.czwtyh: 存在问题\n" +
                "qyzczbN.zgcsfa: 方案\n" +
                "qyzczbN.fcsj: \n" +
                "qyzczbN.fcr: "));
        beanlist.add(new ModeBean("qyzczbyh-xg","qyzczbN/qyzczbNAction!update","qyzczbN.id: 73307e937d28464299023c754dde8bf7\n" +
                "qyzczbN.bjcbw: 被检查部位\n" +
                "qyzczbN.jcsj: 2019-03-13\n" +
                "qyzczbN.jcry: 检查人员\n" +
                "qyzczbN.jclb: 1402450826247\n" +
                "qyzczbN.yhdl: 1402450901716\n" +
                "qyzczbN.yhzl: 1402cdvd020447\n" +
                "qyzczbN.zgzrbm: 责任部门\n" +
                "qyzczbN.zgzrr: 责任人\n" +
                "qyzczbN.zgzrrlxfs: 责任人联系方式\n" +
                "qyzczbN.yhgs: 2\n" +
                "qyzczbN.jhwcsj: 2019-03-14\n" +
                "qyzczbN.zgzt: 0\n" +
                "qyzczbN.zgtrzj: 0\n" +
                "qyzczbN.czwtyh: 存在问题1\n" +
                "qyzczbN.zgcsfa: 方案\n" +
                "qyzczbN.fcsj: \n" +
                "qyzczbN.fcr: "));
        beanlist.add(new ModeBean("qyzczbyh-zg","qyzczbN/qyzczbNAction!zgwc","qyzczbN.id: d46a8607f9754324ad4e5f1b72ab8594\n" +
                "qyzczbN.zgtrzj: 1231313.00\n" +
                "qyzczbN.zgcsfa: 2323\n" +
                "qyzczbN.fcr: 复查人\n" +
                "qyzczbN.fcsj: 2019-02-27"));
        parse(new QyzczbN(),beanlist);
    }

    public static void parseQyYingJi(List<ModeBean> beanlist) {
        beanlist.add(new ModeBean("relief-tj","relief/reliefAction!add","relief.id: \n" +
                "relief.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "relief.wzmc: 物质名称\n" +
                "relief.wzlb: 010000\n" +
                "relief.wzlb2: 010200\n" +
                "relief.wzlb3: 010201\n" +
                "relief.wzsl: 444\n" +
                "relief.wzxh: 物资型号\n" +
                "relief.wzgg: 物资规格\n" +
                "relief.sccj: 生产厂家\n" +
                "relief.ccrq: 2019-04-06\n" +
                "relief.grrq: 2019-03-16\n" +
                "relief.yxqz: 2019-03-16\n" +
                "relief.cfdd: 存放地点\n" +
                "relief.fzr: 主要负责人\n" +
                "relief.sjhm: 18611111111\n" +
                "relief.secfzr: 第二联系人\n" +
                "relief.secsjhm: 18622222222\n" +
                "relief.ytsm: 用途说明\n" +
                "relief.xnsm: 性能说明"));
        beanlist.add(new ModeBean("relief-xg","relief/reliefAction!update","relief.id: \n" +
                "relief.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "relief.wzmc: 物质名称\n" +
                "relief.wzlb: 010000\n" +
                "relief.wzlb2: 010200\n" +
                "relief.wzlb3: 010201\n" +
                "relief.wzsl: 444\n" +
                "relief.wzxh: 物资型号\n" +
                "relief.wzgg: 物资规格\n" +
                "relief.sccj: 生产厂家\n" +
                "relief.ccrq: 2019-04-06\n" +
                "relief.grrq: 2019-03-16\n" +
                "relief.yxqz: 2019-03-16\n" +
                "relief.cfdd: 存放地点\n" +
                "relief.fzr: 主要负责人\n" +
                "relief.sjhm: 18611111111\n" +
                "relief.secfzr: 第二联系人\n" +
                "relief.secsjhm: 18622222222\n" +
                "relief.ytsm: 用途说明\n" +
                "relief.xnsm: 性能说明"));
        beanlist.add(new ModeBean("relief-ck","relief/reliefAction!getById","relief.id: \n" +
                "relief.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "relief.wzmc: 物质名称\n" +
                "relief.wzlb: 010000\n" +
                "relief.wzlb2: 010200\n" +
                "relief.wzlb3: 010201\n" +
                "relief.wzsl: 444\n" +
                "relief.wzxh: 物资型号\n" +
                "relief.wzgg: 物资规格\n" +
                "relief.sccj: 生产厂家\n" +
                "relief.ccrq: 2019-04-06\n" +
                "relief.grrq: 2019-03-16\n" +
                "relief.yxqz: 2019-03-16\n" +
                "relief.cfdd: 存放地点\n" +
                "relief.fzr: 主要负责人\n" +
                "relief.sjhm: 18611111111\n" +
                "relief.secfzr: 第二联系人\n" +
                "relief.secsjhm: 18622222222\n" +
                "relief.ytsm: 用途说明\n" +
                "relief.xnsm: 性能说明"));
        parse(new Relief(),beanlist);//实体和业务串

        beanlist.add(new ModeBean("rescueEquipment-tj","rescueEquipment/rescueEquipmentAction!add","rescueEquipment.id: \n" +
                "rescueEquipment.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "rescueEquipment.zbmc: 装备名称2\n" +
                "rescueEquipment.zblb: ZBLB01000000\n" +
                "rescueEquipment.zbsl: 1223\n" +
                "rescueEquipment.zbxh: 装备型号\n" +
                "rescueEquipment.zbgg: 规格\n" +
                "rescueEquipment.sccj: 生产厂家\n" +
                "rescueEquipment.grqq: 2019-03-15\n" +
                "rescueEquipment.ccrq: 2019-03-15\n" +
                "rescueEquipment.yxqz: 2019-03-15\n" +
                "rescueEquipment.cfdd: 存档地点\n" +
                "rescueEquipment.fzr: 主要负责人\n" +
                "rescueEquipment.sjhm: 13404217689\n" +
                "rescueEquipment.secfzr: 第二联系人\n" +
                "rescueEquipment.secsjhm: 13511698765\n" +
                "rescueEquipment.ytsm: 用途说明\n" +
                "rescueEquipment.xnsm: 性能说明"));
        beanlist.add(new ModeBean("rescueEquipment-xg","rescueEquipment/rescueEquipmentAction!update","rescueEquipment.id: \n" +
                "rescueEquipment.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "rescueEquipment.zbmc: 装备名称2\n" +
                "rescueEquipment.zblb: ZBLB01000000\n" +
                "rescueEquipment.zbsl: 1223\n" +
                "rescueEquipment.zbxh: 装备型号\n" +
                "rescueEquipment.zbgg: 规格\n" +
                "rescueEquipment.sccj: 生产厂家\n" +
                "rescueEquipment.grqq: 2019-03-15\n" +
                "rescueEquipment.ccrq: 2019-03-15\n" +
                "rescueEquipment.yxqz: 2019-03-15\n" +
                "rescueEquipment.cfdd: 存档地点\n" +
                "rescueEquipment.fzr: 主要负责人\n" +
                "rescueEquipment.sjhm: 13404217689\n" +
                "rescueEquipment.secfzr: 第二联系人\n" +
                "rescueEquipment.secsjhm: 13511698765\n" +
                "rescueEquipment.ytsm: 用途说明\n" +
                "rescueEquipment.xnsm: 性能说明"));
        beanlist.add(new ModeBean("rescueEquipment-ck","rescueEquipment/rescueEquipmentAction!getById","rescueEquipment.id: \n" +
                "rescueEquipment.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "rescueEquipment.zbmc: 装备名称2\n" +
                "rescueEquipment.zblb: ZBLB01000000\n" +
                "rescueEquipment.zbsl: 1223\n" +
                "rescueEquipment.zbxh: 装备型号\n" +
                "rescueEquipment.zbgg: 规格\n" +
                "rescueEquipment.sccj: 生产厂家\n" +
                "rescueEquipment.grqq: 2019-03-15\n" +
                "rescueEquipment.ccrq: 2019-03-15\n" +
                "rescueEquipment.yxqz: 2019-03-15\n" +
                "rescueEquipment.cfdd: 存档地点\n" +
                "rescueEquipment.fzr: 主要负责人\n" +
                "rescueEquipment.sjhm: 13404217689\n" +
                "rescueEquipment.secfzr: 第二联系人\n" +
                "rescueEquipment.secsjhm: 13511698765\n" +
                "rescueEquipment.ytsm: 用途说明\n" +
                "rescueEquipment.xnsm: 性能说明"));
        parse(new RescueEquipment(),beanlist);//实体和业务串

        beanlist.add(new ModeBean("rescueTeams-tj","rescueTeams/rescueTeamsAction!add","rescueTeams.id: \n" +
                "rescueTeams.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "rescueTeams.dwmc: 队伍名称2\n" +
                "rescueTeams.dwlx: xfdw\n" +
                "rescueTeams.dwrs: 4444\n" +
                "rescueTeams.dwsx: zyyjjydw\n" +
                "rescueTeams.syhy: MK02\n" +
                "rescueTeams.jyzy: jy\n" +
                "rescueTeams.fzr: 主要负责人\n" +
                "rescueTeams.sjhm: 13404217759\n" +
                "rescueTeams.secfzr: 第二任\n" +
                "rescueTeams.secsjhm: 13511609878\n" +
                "rescueTeams.dwjj: 队伍简介"));
        beanlist.add(new ModeBean("rescueTeams-xg","rescueTeams/rescueTeamsAction!update","rescueTeams.id: \n" +
                "rescueTeams.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "rescueTeams.dwmc: 队伍名称2\n" +
                "rescueTeams.dwlx: xfdw\n" +
                "rescueTeams.dwrs: 4444\n" +
                "rescueTeams.dwsx: zyyjjydw\n" +
                "rescueTeams.syhy: MK02\n" +
                "rescueTeams.jyzy: jy\n" +
                "rescueTeams.fzr: 主要负责人\n" +
                "rescueTeams.sjhm: 13404217759\n" +
                "rescueTeams.secfzr: 第二任\n" +
                "rescueTeams.secsjhm: 13511609878\n" +
                "rescueTeams.dwjj: 队伍简介"));
        beanlist.add(new ModeBean("rescueTeams-ck","rescueTeams/rescueTeamsAction!getById","rescueTeams.id: \n" +
                "rescueTeams.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "rescueTeams.dwmc: 队伍名称2\n" +
                "rescueTeams.dwlx: xfdw\n" +
                "rescueTeams.dwrs: 4444\n" +
                "rescueTeams.dwsx: zyyjjydw\n" +
                "rescueTeams.syhy: MK02\n" +
                "rescueTeams.jyzy: jy\n" +
                "rescueTeams.fzr: 主要负责人\n" +
                "rescueTeams.sjhm: 13404217759\n" +
                "rescueTeams.secfzr: 第二任\n" +
                "rescueTeams.secsjhm: 13511609878\n" +
                "rescueTeams.dwjj: 队伍简介"));
        parse(new RescueTeams(),beanlist);//实体和业务串

        beanlist.add(new ModeBean("safetyExpert-tj","safetyExperts/safetyExpertsAction!add","safetyExperts.id: \n" +
                "safetyExperts.ssdw: ent\n" +
                "safetyExperts.type: \n" +
                "safetyExperts.xm: 姓名\n" +
                "safetyExperts.xb: 1\n" +
                "safetyExperts.csny: 2019-03-15\n" +
                "safetyExperts.lxdh: 13404217759\n" +
                "safetyExperts.zjlb: hgl\n" +
                "safetyExperts.jszc: 001\n" +
                "safetyExperts.zjjj: 专家简介"));
        beanlist.add(new ModeBean("safetyExpert-xg","safetyExperts/safetyExpertsAction!update","safetyExperts.id: \n" +
                "safetyExperts.ssdw: ent\n" +
                "safetyExperts.type: \n" +
                "safetyExperts.xm: 姓名\n" +
                "safetyExperts.xb: 1\n" +
                "safetyExperts.csny: 2019-03-15\n" +
                "safetyExperts.lxdh: 13404217759\n" +
                "safetyExperts.zjlb: hgl\n" +
                "safetyExperts.jszc: 001\n" +
                "safetyExperts.zjjj: 专家简介"));
        beanlist.add(new ModeBean("safetyExpert-ck","safetyExperts/safetyExpertsAction!getById","safetyExperts.id: \n" +
                "safetyExperts.ssdw: ent\n" +
                "safetyExperts.type: \n" +
                "safetyExperts.xm: 姓名\n" +
                "safetyExperts.xb: 1\n" +
                "safetyExperts.csny: 2019-03-15\n" +
                "safetyExperts.lxdh: 13404217759\n" +
                "safetyExperts.zjlb: hgl\n" +
                "safetyExperts.jszc: 001\n" +
                "safetyExperts.zjjj: 专家简介"));
        parse(new SafetyExperts(),beanlist);//实体和业务串

        beanlist.add(new ModeBean("refugeArea-tj","refugeArea/refugeAreaAction!add","refugeArea.id: \n" +
                "refugeArea.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "refugeArea.cqmc: 场区名称\n" +
                "refugeArea.cqlx: 47A00\n" +
                "refugeArea.cqrl: 3333\n" +
                "refugeArea.cqmj: 3333\n" +
                "refugeArea.fzr: 主要负责人\n" +
                "refugeArea.sjhm: 13404216548\n" +
                "refugeArea.secfzr: 第二联系人\n" +
                "refugeArea.secsjhm: 13500048198\n" +
                "refugeArea.cqdz: 厂区地址\n" +
                "refugeArea.cqjj: 厂区简介"));
        beanlist.add(new ModeBean("refugeArea-xg","refugeArea/refugeAreaAction!update","refugeArea.id: \n" +
                "refugeArea.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "refugeArea.cqmc: 场区名称\n" +
                "refugeArea.cqlx: 47A00\n" +
                "refugeArea.cqrl: 3333\n" +
                "refugeArea.cqmj: 3333\n" +
                "refugeArea.fzr: 主要负责人\n" +
                "refugeArea.sjhm: 13404216548\n" +
                "refugeArea.secfzr: 第二联系人\n" +
                "refugeArea.secsjhm: 13500048198\n" +
                "refugeArea.cqdz: 厂区地址\n" +
                "refugeArea.cqjj: 厂区简介"));
        beanlist.add(new ModeBean("refugeArea-ck","refugeArea/refugeAreaAction!getById","refugeArea.id: \n" +
                "refugeArea.ssdw: 5c6bf34df59a495bb2310895a93e6df4\n" +
                "refugeArea.cqmc: 场区名称\n" +
                "refugeArea.cqlx: 47A00\n" +
                "refugeArea.cqrl: 3333\n" +
                "refugeArea.cqmj: 3333\n" +
                "refugeArea.fzr: 主要负责人\n" +
                "refugeArea.sjhm: 13404216548\n" +
                "refugeArea.secfzr: 第二联系人\n" +
                "refugeArea.secsjhm: 13500048198\n" +
                "refugeArea.cqdz: 厂区地址\n" +
                "refugeArea.cqjj: 厂区简介"));
        parse(new RefugeArea(),beanlist);//实体和业务串
    }

    public static void parse(Object objects,List<ModeBean> beanlist){
            Object entityName=objects;
            String classname = entityName.getClass().getSimpleName();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            ChineseName annotationorg = (ChineseName) c.getAnnotation(ChineseName.class);
            String annotationorgstring=annotationorg.value();
            List<LineMenu> lineMenus=new ArrayList<>();
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if (annotation == null || annotation.equals("") ) {
                    LineMenu menu=new LineMenu("",f.getName());
                    lineMenus.add(menu);
                } else {
                    LineMenu menu=new LineMenu(annotation.value(),f.getName());
                    lineMenus.add(menu);

                }
            }
            if(annotationorgstring.contains("Detail")){
                new Shop_Detail(annotationorgstring)
                        .setBeanlist(beanlist)
                        .parse(classname,lineMenus,"version,tbsj,tname,xzzfid,qyid,sfwc");
            }
            if(annotationorgstring.contains("List")){
                new Shop_List(annotationorgstring).parse(classname,lineMenus);
            }
        beanlist.clear();

    }


    private static void clearFile() {
        Util_File.getFiles("apps/", "", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                if (file.getName().contains("xml") || file.getName().contains("java")) {
                    System.out.println("清理:" + file.getName());
                    file.delete();
                }
            }
        });
    }

}
