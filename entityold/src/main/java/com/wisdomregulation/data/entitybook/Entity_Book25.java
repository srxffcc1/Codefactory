package com.wisdomregulation.data.entitybook;
//行政处罚决定书（单位）

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book25 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book25(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管罚");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被处罚单位名称");//3//3
	fieldnamelsitchinese.add("被处罚单位地址");//4//4
	fieldnamelsitchinese.add("被处罚单位邮编");//5//5
	fieldnamelsitchinese.add("被处罚单位法定代表人");//6//6
	fieldnamelsitchinese.add("被处罚单位法定代表人职务");//7//7
	fieldnamelsitchinese.add("被处罚单位法定代表人联系电话");//8//8
	fieldnamelsitchinese.add("违法事实及依据");//9//9
	fieldnamelsitchinese.add("违法了什么规定");//10//10
	fieldnamelsitchinese.add("依据什么规定进行处罚");//11//11
	fieldnamelsitchinese.add("给予了什么行政处罚");//12//12
	fieldnamelsitchinese.add("收到决定书15日内到什么地点");//13//13
	fieldnamelsitchinese.add("收到决定书15日内缴纳账号");//14//14
	fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//15//15
	fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//16//16
	fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//17//17
	fieldnamelsitchinese.add("出表日期");//18//18

}

}
