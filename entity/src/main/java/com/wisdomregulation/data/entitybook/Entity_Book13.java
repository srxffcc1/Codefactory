package com.wisdomregulation.data.entitybook;
//强制措施决定书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book13 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book13(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管强措");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被检查单位");//3//3
	fieldnamelsitchinese.add("存在问题的描述");//4//4
	fieldnamelsitchinese.add("采取措施的依据");//5//5
	fieldnamelsitchinese.add("采取什么措施");//6//6
	fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//7//7
	fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//8//8
	fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//9//9
	fieldnamelsitchinese.add("出表日期");//10//10
}
}
