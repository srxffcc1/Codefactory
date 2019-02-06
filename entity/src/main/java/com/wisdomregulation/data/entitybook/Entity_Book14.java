package com.wisdomregulation.data.entitybook;
//鉴定委托书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book14 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book14(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管鉴");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被委托单位");//3//3
	fieldnamelsitchinese.add("list鉴定物品lim5_物品名称2规格型号2数量2备注");//4//4
	fieldnamelsitchinese.add("鉴定要求");//5//5
	fieldnamelsitchinese.add("提交结果期限日期");//6//6
	fieldnamelsitchinese.add("出表日期");//7//7
}
}
