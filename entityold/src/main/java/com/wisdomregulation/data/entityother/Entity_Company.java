package com.wisdomregulation.data.entityother;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;
//企业信息实体
public class Entity_Company extends DateBase_Entity {
	private List<String> fieldnamelsitchinese=new ArrayList<String>();
	private Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Company(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}

{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("企业名称");//0
	fieldnamelsitchinese.add("企业详细地址");//1
	fieldnamelsitchinese.add("企业经纬度");//2
	fieldnamelsitchinese.add("最新检查时间");//3
	fieldnamelsitchinese.add("生产经营地址");//4
	fieldnamelsitchinese.add("是否有隶属集团");//5
	fieldnamelsitchinese.add("经营范围");//6
	fieldnamelsitchinese.add("企业位置经度");//7
	fieldnamelsitchinese.add("主要负责人");//8
	fieldnamelsitchinese.add("主要负责人固定电话");//9
	fieldnamelsitchinese.add("所在区县");//10
	fieldnamelsitchinese.add("邮政编码");//11
	fieldnamelsitchinese.add("安全负责人电子邮箱");//12
	fieldnamelsitchinese.add("安全负责人移动电话");//13
	fieldnamelsitchinese.add("特种作业人员数量");//14
	fieldnamelsitchinese.add("注册安全工程师人员数量");//15
	fieldnamelsitchinese.add("监管行业小类");//16
	fieldnamelsitchinese.add("电子邮箱");//17
	fieldnamelsitchinese.add("专项监管小类");//18
	fieldnamelsitchinese.add("注册地址");//19
	fieldnamelsitchinese.add("专项监管大类");//20
	fieldnamelsitchinese.add("主要负责人电子邮箱");//21
	fieldnamelsitchinese.add("所在街道");//22
	fieldnamelsitchinese.add("行政区划省");//23
	fieldnamelsitchinese.add("隶属关系");//24
	fieldnamelsitchinese.add("工商注册号");//25
	fieldnamelsitchinese.add("企业位置纬度");//26
	fieldnamelsitchinese.add("规模情况");//27
	fieldnamelsitchinese.add("监管分类");//28
	fieldnamelsitchinese.add("主要负责人移动电话");//29
	fieldnamelsitchinese.add("安全负责人固定电话");//30
	fieldnamelsitchinese.add("行业类别");//31
	fieldnamelsitchinese.add("企业规模");//32
	fieldnamelsitchinese.add("行业类别小类");//33
	fieldnamelsitchinese.add("经济类型小类");//34
	fieldnamelsitchinese.add("法定代表人");//35
	fieldnamelsitchinese.add("企业自评等级");//36
	fieldnamelsitchinese.add("组织机构代码");//37  需要注意
	fieldnamelsitchinese.add("专职安全生产管理人员数量");//38
	fieldnamelsitchinese.add("经济类型");//39
	fieldnamelsitchinese.add("行政区划市");//40
	fieldnamelsitchinese.add("注册资金（万）");//41
	fieldnamelsitchinese.add("是否是集团");//42
	fieldnamelsitchinese.add("联系电话");//43
	fieldnamelsitchinese.add("隶属集团名称");//44
	fieldnamelsitchinese.add("成立日期");//45
	fieldnamelsitchinese.add("安全负责人");//46
	fieldnamelsitchinese.add("从业人员数量");//47
	fieldnamelsitchinese.add("专项治理类型");//48
	fieldnamelsitchinese.add("主管部门");//49
}
}
//fieldnamelsitchinese.add("企业名称");
//fieldnamelsitchinese.add("企业详细地址");
//fieldnamelsitchinese.add("企业经纬度");
//fieldnamelsitchinese.add("最新检查时间");
//fieldnamelsitchinese.add("工商注册号");
//fieldnamelsitchinese.add("组织机构代码");
//fieldnamelsitchinese.add("行政区划");
//fieldnamelsitchinese.add("成立日期");
//fieldnamelsitchinese.add("法定代表人");
//fieldnamelsitchinese.add("联系人");
//fieldnamelsitchinese.add("联系电话");
//fieldnamelsitchinese.add("电子邮箱");
//fieldnamelsitchinese.add("联系微信号");
//fieldnamelsitchinese.add("联系QQ号");
//fieldnamelsitchinese.add("企业官方网站地址");
//fieldnamelsitchinese.add("单位传真");
//fieldnamelsitchinese.add("主要负责人");
//fieldnamelsitchinese.add("主要负责人固定电话");
//fieldnamelsitchinese.add("主要负责人移动电话");
//fieldnamelsitchinese.add("主要负责人电子邮箱");
//fieldnamelsitchinese.add("安全负责人");
//fieldnamelsitchinese.add("安全负责人固定电话");
//fieldnamelsitchinese.add("安全负责人移动电话");
//fieldnamelsitchinese.add("安全负责人电子邮箱");
//fieldnamelsitchinese.add("注册地址");
//fieldnamelsitchinese.add("生产经营地址");
//fieldnamelsitchinese.add("邮政编码");
//fieldnamelsitchinese.add("经济类型");
//fieldnamelsitchinese.add("行业类别");;
//fieldnamelsitchinese.add("隶属关系");
//fieldnamelsitchinese.add("经营范围");
//fieldnamelsitchinese.add("企业经营状态");
//fieldnamelsitchinese.add("注册资金（万元）");
//fieldnamelsitchinese.add("年销售收入（万元）");
//fieldnamelsitchinese.add("年利润（万元）");
//fieldnamelsitchinese.add("资产总额（万元）");
//fieldnamelsitchinese.add("占地面积（㎡）");
//fieldnamelsitchinese.add("从业人员数量");
//fieldnamelsitchinese.add("特种作业人员数量");
//fieldnamelsitchinese.add("专职安全生产管理人员数量");
//fieldnamelsitchinese.add("兼职安全生产管理人员数量");
//fieldnamelsitchinese.add("专职应急管理人员数量");
//fieldnamelsitchinese.add("注册安全工程师人员数量");
//fieldnamelsitchinese.add("营业执照类别");
//fieldnamelsitchinese.add("规模情况");
//fieldnamelsitchinese.add("企业规模");
//fieldnamelsitchinese.add("母公司名称");
//fieldnamelsitchinese.add("集团公司名称");
//fieldnamelsitchinese.add("标准化等级");
//fieldnamelsitchinese.add("安全监管等级");
//fieldnamelsitchinese.add("监管分类");
//fieldnamelsitchinese.add("属地安监机构");
//fieldnamelsitchinese.add("是否有专门安全机构");
//fieldnamelsitchinese.add("是否有专职安全人员");
//fieldnamelsitchinese.add("是否存在重大危险源");
//fieldnamelsitchinese.add("企业平面图");
//fieldnamelsitchinese.add("隐患排查治理制度");
//fieldnamelsitchinese.add("隐患排查治理计划");
//fieldnamelsitchinese.add("专项治理类型");
//fieldnamelsitchinese.add("专项监管大类");
//fieldnamelsitchinese.add("专项监管小类");
//fieldnamelsitchinese.add("备注");
//fieldnamelsitchinese.add("现用作审核意见");
//fieldnamelsitchinese.add("行政区划省");
//fieldnamelsitchinese.add("行政区划区县");
//fieldnamelsitchinese.add("行政区划街道");
//fieldnamelsitchinese.add("专项治理类别");
//fieldnamelsitchinese.add("分类监管");
//fieldnamelsitchinese.add("法定代表人固话");
//fieldnamelsitchinese.add("法定代表人手机");
//fieldnamelsitchinese.add("监管部门树");
//fieldnamelsitchinese.add("显示的部门");
//fieldnamelsitchinese.add("是否有隶属集团");
//fieldnamelsitchinese.add("隶属集团名称");
//fieldnamelsitchinese.add("是否是集团");
//fieldnamelsitchinese.add("行业类别小类");
//fieldnamelsitchinese.add("经济类型小类");
//fieldnamelsitchinese.add("监管行业大类");
//fieldnamelsitchinese.add("监管行业小类");
