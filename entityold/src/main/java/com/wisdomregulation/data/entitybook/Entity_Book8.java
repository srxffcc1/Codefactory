package com.wisdomregulation.data.entitybook;
//先行登记保存证据处理决定书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book8 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book8(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管先保处");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被保存物品的单位名称");//3//3
	fieldnamelsitchinese.add("保存日期");//4//4
	fieldnamelsitchinese.add("被保存物品名称");//5//5
	fieldnamelsitchinese.add("安监管区域");//6//6
	fieldnamelsitchinese.add("安监管先保通字");//7//7
	fieldnamelsitchinese.add("安监管先保通号");//8//8
	fieldnamelsitchinese.add("处理方式");//9//9
	fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//10//10
	fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//11//11
	fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//12//12
	fieldnamelsitchinese.add("出表日期");//13//13

}
}
