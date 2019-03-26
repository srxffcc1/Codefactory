package com.wisdomregulation.data.entitybook;
//罚款催缴通知书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book27 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book27(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管催");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被要求单位");//3//3
	fieldnamelsitchinese.add("通知发出时间");//4//4
	fieldnamelsitchinese.add("行政文书处罚决定书文书号");//5//5
	fieldnamelsitchinese.add("罚款缴纳期限日期");//6//6
	fieldnamelsitchinese.add("罚款缴纳地址");//7//7
	fieldnamelsitchinese.add("出表日期");//8//8

}

}
