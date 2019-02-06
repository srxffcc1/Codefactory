package com.wisdomregulation.data.entitybook;
//整改复查意见书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book12 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book12(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管复查");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被复查单位");//3//3
	fieldnamelsitchinese.add("相关决定的文号日期");//4//4
	fieldnamelsitchinese.add("所做决定内容");//5//5
	fieldnamelsitchinese.add("安监管所属区域");//6//6
	fieldnamelsitchinese.add("行为安监管");//7//7
	fieldnamelsitchinese.add("安监管字");//8//8
	fieldnamelsitchinese.add("安监管号");//9//9
	fieldnamelsitchinese.add("提出相关意见");//10//10
	fieldnamelsitchinese.add("被复查单位负责人签名");//11//11
	fieldnamelsitchinese.add("执法人员1签名");//12//12
	fieldnamelsitchinese.add("执法人员1证号");//13//13
	fieldnamelsitchinese.add("执法人员2签名");//14//14
	fieldnamelsitchinese.add("执法人员2证号");//15//15
	fieldnamelsitchinese.add("出表日期");//16//16
}
}
