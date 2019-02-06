package com.wisdomregulation.data.entitybook;
//先行登记保存证据通知单

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book6 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book6(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管先保通");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被通知企业或单位名称");//3//3
	fieldnamelsitchinese.add("涉嫌行为");//4//4
	fieldnamelsitchinese.add("请单位在何时");//5//5
	fieldnamelsitchinese.add("请单位到何地");//6//6
	fieldnamelsitchinese.add("被通知人或通知单位负责人签名");//7//7
	fieldnamelsitchinese.add("出表日期");//8//8

}
}
