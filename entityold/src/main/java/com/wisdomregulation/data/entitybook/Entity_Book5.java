package com.wisdomregulation.data.entitybook;
//先行登记保存证据审批表

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book5 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book5(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("null1");//0//0
	fieldnamelsitchinese.add("null2");//1//1
	fieldnamelsitchinese.add("null3");//2//2
	fieldnamelsitchinese.add("案件名称");//3//3
	fieldnamelsitchinese.add("当事人及基本情况");//4//4
	fieldnamelsitchinese.add("案件基本情况");//5//5
	fieldnamelsitchinese.add("证据名称及数量");//6//6
	fieldnamelsitchinese.add("提请理由及依据");//7//7
	fieldnamelsitchinese.add("保存方式");//8//8
	fieldnamelsitchinese.add("承办人意见");//9//9
	fieldnamelsitchinese.add("承办人签名");//10//10
	fieldnamelsitchinese.add("承办人签名日期");//11//11
	fieldnamelsitchinese.add("部门负责人意见");//12//12
	fieldnamelsitchinese.add("部门负责人签名");//13//13
	fieldnamelsitchinese.add("部门负责人签名日期");//14//14
	fieldnamelsitchinese.add("相关负责人意见");//15//15
	fieldnamelsitchinese.add("相关负责人签名");//16//16
	fieldnamelsitchinese.add("相关负责人签名日期");//17//17

}
}
