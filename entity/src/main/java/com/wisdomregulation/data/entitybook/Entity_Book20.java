package com.wisdomregulation.data.entitybook;
//听证会报告书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book20 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book20(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管听报");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("案件名称");//3//3
	fieldnamelsitchinese.add("听证主持人");//4//4
	fieldnamelsitchinese.add("听证员");//5//5
	fieldnamelsitchinese.add("书记员");//6//6
	fieldnamelsitchinese.add("听证会基本笔录");//7//7
	fieldnamelsitchinese.add("听证支持人意见");//8//8
	fieldnamelsitchinese.add("听证主持人签名");//9//9
	fieldnamelsitchinese.add("听证主持人签名日期");//10//10
	fieldnamelsitchinese.add("负责人审核意见");//11//11
	fieldnamelsitchinese.add("负责人签名");//12//12
	fieldnamelsitchinese.add("负责人签名日期");//13//13

}

}
