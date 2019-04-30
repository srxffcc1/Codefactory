package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;
@ChineseName("企业自查;Detail:PartShow=true;List=userName,jcry:FUNCTION=查看,记录;")
public class QyzczbN extends BasePojo {
    @ChineseName("时间：2014年8月18日 下午6:02:11")
    public String sun;
    @ChineseName("用户登录名")
    public String userAccount;
    @ChineseName("被检查部位")
    public String bjcbw;
    @ChineseName("检查时间")
    public String jcsj;
    @ChineseName("检查人员")
    public String jcry;
    @ChineseName("隐患级别")
    public String yhjb;
    @ChineseName("检查类别;Spinner:string=企业自查,专家检查,企业联网互查:code=1402450826247,1402450853577,1402450871365;")
    public String jclb;
    @ChineseName("隐患大类;Spinner:string=基础管理,现场管理:code=1402450901716,1402450932605;")
    public String yhdl;
    @ChineseName("隐患中类;Spinner:url=data/dataAction!findByType?parentId=-1&typeId=yhzl:codekey=dataCode:namekey=dataName;")
    public String yhzl;
    @ChineseName("整改责任部门")
    public String zgzrbm;
    @ChineseName("整改责任人")
    public String zgzrr;
    @ChineseName("整改责任人联系方式")
    public String zgzrrlxfs;
    @ChineseName("计划完成时间")
    public String jhwcsj;
    @ChineseName("整改状态;Spinner:string=已整改,未整改:code=1,0;")
    public String zgzt;
    @ChineseName("复查时间")
    public String fcsj;
    @ChineseName("复查人")
    public String fcr;
    @ChineseName("整改投入资金")
    public String zgtrzj;
    @ChineseName("存在问题和隐患")
    public String czwtyh;
    @ChineseName("存在问题和隐患备注")
    public String czwtyhbz;
    @ChineseName("具体情况及整改措施方案")
    public String zgcsfa;
    @ChineseName("验收情况")
    public String ysqk;
    @ChineseName("审核部门")
    public String shbm;
    @ChineseName("审核人")
    public String shr;
    @ChineseName("审核时间")
    public String shsj;
    @ChineseName("审核结论;Spinner:string=转出,退回:code=1,0;0:审核不通过 1:转出 2:退回")
    public String shjl;
    @ChineseName("审核意见")
    public String shyj;
    @ChineseName("区级")
    public String shyjcity;
    @ChineseName("区级")
    public String shyjprovince;
    @ChineseName("上报时间")
    public String sbsj;
    @ChineseName("上报类型;Spinner:string=普通上报,零隐患上报:code=0,1;0:普通上报 1:零隐患上报")
    public String sblx;
    @ChineseName("隐患当前状态;Spinner:string=未上报,已上报未审核,审核不通过,审核通过:code=0,1,2,3;0:未上报  1:已上报未审核 2:审核不通过 3:审核通过")
    public String dqzt;
    @ChineseName("隐患类型;Spinner:string=企业自查隐患,政府抽查:code=1,2;3;1:企业自查隐患 2:政府抽查3")
    public String yhlx;
    @ChineseName("企业是否自查该隐患Y/N")
    public String qysfzcgyh;
//    @ChineseName("新添加字段  何悦 2015-07-24")

    @ChineseName("与隐患信息表关联id")
    public String fid;
    @ChineseName(" 检查时间起")

    public String beginJcsj;
    @ChineseName(" 检查时间止")

    public String endJcsj;
    @ChineseName("隐患级别")
    public String yhjbVal;
    @ChineseName("隐患类别")
    public String yhlbVal;
    @ChineseName("隐患大类")
    public String yhdlVal;
    @ChineseName("隐患中类")
    public String yhzlVal;
    @ChineseName("整改状态")
    public String zgztVal;
    @ChineseName("检查类别")
    public String jclbVal;
    @ChineseName("审核人名称")
    public String shrVal;
    @ChineseName("用户登录名")
    public String account;
    @ChineseName("用户名称")
    public String userName;
    @ChineseName("上报时间起")
    public String beginSbsj;
    @ChineseName("上报时间止")
    public String endSbsj;
    @ChineseName("是否上报YN  隐患类型:0 2代表未上报  1 3代表已上报")
    public String sfsb;
    @ChineseName("审核部门名称")
    public String shbmVal;
    @ChineseName("是否重大隐患")
    public String sfzdyh;
    public String lsjtAccount;
    public String qyid;
    @ChineseName("部门抽查是否发现隐患(Y/N)")

    public String ccsffxyh;
    @ChineseName("整改完成时间")

    public String zgwcsj;
    @ChineseName("行业监管类型")

    public String zxjghyb;
    public String zxjghybName;
    @ChineseName("投诉人")
    public String tsr;
    @ChineseName("联系电话")
    public String tsrdh;
    @ChineseName("填报人")
    public String tbr;
    @ChineseName("隐患地点")
    public String yhdd;
    @ChineseName("整改完成日期")
    public String zgwcrq;
    @ChineseName("整改类型")
    public String zglx;
    public String zglxVal;
    @ChineseName("是否检查")
    public String sfjc;
    @ChineseName("检查人")
    public String ccrname;
    @ChineseName("检查时间")
    public String ccsj;
    @ChineseName("检查说明")
    public String ccsm;
    @ChineseName("评审机构ID")
    public String psjgid;
    public String psjgName;
//    @ChineseName("0.未上报 1.已上报未审核 2审核未通过3审核通过4已挂牌督办5整改中6整改完成等待验收7已销号8验收不通过  11区县已邀约  12区县已鉴定  13 市级已鉴定  14市级已邀约  15 省级已邀约16已邀约专家验收")

    @ChineseName("重大隐患状态")
    public String zdyhzt;
    @ChineseName("隐患整改通知")
    public String yhzgtz;
    @ChineseName("督办单位")
    public String dbdw;
    @ChineseName("复查结论")
    public String zffcjl;
    @ChineseName("复查意见")
    public String zffcyj;
    public String fcbm;
    @ChineseName("应急预案")
    public String yjya;
    @ChineseName("销号单位")
    public String xhdw;
    @ChineseName("销号人")
    public String xhrname;
    @ChineseName("销号日期")
    public String xhrq;
    @ChineseName("销号意见")
    public String xhyj;
    @ChineseName("销号结果")
    public String xhjg;
    @ChineseName("重大隐患级别;Spinner:url=data/dataAction!findByType?parentId=1402449131040&typeId=yhjb:codekey=dataCode:namekey=dataName;;（分为1、2、3级）")
    public String zdwxyjb;
    public String zdwxyjbVal;
//    @ChineseName("隐患验收信息")

    @ChineseName("监管责任单位")
    public String jgzrdw;
    @ChineseName("监管责任人")
    public String jgzrr;
    @ChineseName("核查日期")
    public String hcrq;
    @ChineseName("核查单位")
    public String hcdw;
    @ChineseName("核查情况")
    public String hcqk;
    @ChineseName("验收结果")
    public String ysjg;
    @ChineseName("按清单排查ID")
    public String pcid;
    @ChineseName("按清单排查清单ID")
    public String qdid;
    @ChineseName("按清单排查检查项ID")
    public String qdjcxid;
    @ChineseName("重大隐患验收成员")
    public String yhyszj;
    @ChineseName("重大隐患验收组长")
    public String yhyszjzz;
    @ChineseName("专家验收意见")
    public String zjysyj;
    @ChineseName("专家组长   区县级")
    public String zjzz;
    @ChineseName("重大隐患审核专家  区县级")
    public String yhpclzj;
    @ChineseName("专家组长   市级")
    public String zjzzcity;
    @ChineseName("重大隐患审核 市级")
    public String yhyszjcity;
    @ChineseName("专家组长   省级")
    public String zjzzprovince;
    @ChineseName("重大隐患审核 省级")
    public String yhyszprovince;
    @ChineseName("预计投入资金")
    public String yjtrzj;
    @ChineseName("判断是否归档   一般隐患（已整改） 重大隐患（已销号）9：已归档")
    public String gdzt;
    @ChineseName("设为不上报  0  上报1")
    public String bsb;
    @ChineseName("治理目标任务")
    public String zlmbrw;
    @ChineseName("经费物质落实")
    public String jfwzls;
    @ChineseName("治理要求")
    public String zlyq;
    @ChineseName("安全措施和预案")
    public String aqcsyya;
    @ChineseName("0未上报 1上报 2鉴定不通过 3已分配处理4推送企业")
    public String tsjbyhZt;
    @ChineseName("查询码")
    public String cxm;
    @ChineseName("投诉举报处理部门")
    public String tsjbclbm;
    @ChineseName("鉴定意见")
    public String tsjbyhjdyj;
    @ChineseName("1:快速登记2排查清单3快速导入")
    public String yhly;
    @ChineseName("存储快速导入关联id")
    public String ksdrid;
    @ChineseName("区县邀约情况  0不邀约 1邀约专家2邀约机构")
    public String qxyyqk;
    @ChineseName("市邀约情况  0不邀约 1邀约专家2邀约机构")
    public String cityyyqk;
    @ChineseName("省邀约情况  0不邀约 1邀约专家2邀约机构")
    public String provinceyyqk;
    @ChineseName("活动情况id、机构项目id等")
    public String hdqkid;
    @ChineseName("可视状态  1可视  0不可视")
    public String viewzt;
    @ChineseName("机构名称")
    public String jgname;
    @ChineseName("机构名称")
    public String jgnameArea;
    @ChineseName("机构名称")
    public String jgnameProvince;
    @ChineseName("是否邀约专家0 不邀约  1邀约")
    public String sfyyzj;
    @ChineseName("企业邀约情况 1邀约专家2邀约机构")
    public String qyyyqk;
    @ChineseName("企业邀约专家组长")
    public String qyzjzz;
    @ChineseName("企业邀约专家成员")
    public String qyzjcy;
    @ChineseName("企业邀约机构名称")
    public String qyjgname;
    @ChineseName("企业专家鉴定意见")
    public String qyyj;
    @ChineseName("执法检查检查部门")
    public String jcbm;
    @ChineseName("机构项目隐患信息新增字段")
    public String zynl;
    public String zynlName;
    @ChineseName("有无隐患")
    public String ywyh;
    @ChineseName("是否提出整改意见")
    public String sftczgyj;
    @ChineseName("整改情况说明，可不填，未完成整改的需要说明原因")
    public String zgqksm;
    @ChineseName("是否逾期")

    public String sfyq;
    public String sfyqF;
    public String sfyqS;
}
