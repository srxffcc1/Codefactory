package com.wisdomregulation.data.entitybook;
//责令限期整改指令书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book11 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book11(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管责改");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被查单位");//3//3
	fieldnamelsitchinese.add("存在问题1");//4//4
	fieldnamelsitchinese.add("存在问题2");//5//5
	fieldnamelsitchinese.add("存在问题3");//6//6
	fieldnamelsitchinese.add("存在问题4");//7//7
	fieldnamelsitchinese.add("第几项问题需期限整改");//8//8
	fieldnamelsitchinese.add("整改期限");//9//9
	fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//10//10
	fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//11//11
	fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//12//12
	fieldnamelsitchinese.add("执法人员1姓名");//13//13
	fieldnamelsitchinese.add("执法人员1证件号");//14//14
	fieldnamelsitchinese.add("执法人员2姓名");//15//15
	fieldnamelsitchinese.add("执法人员2证件号");//16//16
	fieldnamelsitchinese.add("被检查单位负责人签名");//17//17
	fieldnamelsitchinese.add("出表日期");//18//18
	fieldnamelsitchinese.add("续页");//19//19
}
}
