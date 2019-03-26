package com.wisdomregulation.data.entitybook;
//案件移送书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book34 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book34(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管移");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("受移送单位机关名称");//3//3
	fieldnamelsitchinese.add("移送日期");//4//4
	fieldnamelsitchinese.add("被移送案件");//5//5
	fieldnamelsitchinese.add("调查发现哪些时间超出本机关管辖范围");//6//6
	fieldnamelsitchinese.add("根据什么规定");//7//7
	fieldnamelsitchinese.add("附案件相关材料");//8//8
	fieldnamelsitchinese.add("材料份数");//9//9
	fieldnamelsitchinese.add("材料页数");//10//10
	fieldnamelsitchinese.add("出表日期");//11//11
}
}
