package com.wisdomregulation.data.entitybook;
//行政（当场）处罚决定书（单位）

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book23 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book23(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管罚当");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被处罚单位");//3//3
	fieldnamelsitchinese.add("被处罚单位地址");//4//4
	fieldnamelsitchinese.add("被处罚单位邮编");//5//5
	fieldnamelsitchinese.add("被处罚单位法定代表人");//6//6
	fieldnamelsitchinese.add("被处罚单位法定代表人职务");//7//7
	fieldnamelsitchinese.add("被处罚单位法定代表人联系电话");//8//8
	fieldnamelsitchinese.add("违法事实及依据");//9//9
	fieldnamelsitchinese.add("以上事实违反了什么规定");//10//10
	fieldnamelsitchinese.add("依据什么规定作出行政处罚");//11//11
	fieldnamelsitchinese.add("作出什么行政处罚");//12//12
	fieldnamelsitchinese.add("check当场缴纳2自决定15内缴纳");//13//13 传1或者2
	fieldnamelsitchinese.add("十五日内缴纳地点");//14//14
	fieldnamelsitchinese.add("十五日内缴纳缴纳账号");//15//15
	fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//16//16
	fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//17//17
	fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//18//18
	fieldnamelsitchinese.add("执法人员1签名");//19//19
	fieldnamelsitchinese.add("执法人员2签名");//20//20
	fieldnamelsitchinese.add("当事人或委托代理人签名");//21//21
	fieldnamelsitchinese.add("出表日期");//22//22

}

}
