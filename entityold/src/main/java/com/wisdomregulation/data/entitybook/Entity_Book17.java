package com.wisdomregulation.data.entitybook;
//听证告知书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book17 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book17(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管听告");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被查单位");//3//3
	fieldnamelsitchinese.add("被查行为条目");//4//4
	fieldnamelsitchinese.add("被查行为违反了什么规定");//5//5
	fieldnamelsitchinese.add("依据什么规定来处罚");//6//6
	fieldnamelsitchinese.add("作出了什么处罚");//7//7
	fieldnamelsitchinese.add("可提出听证申请的安全生产监督管理局所属区域");//8//8
	fieldnamelsitchinese.add("安全生产监督管理局部门地址");//9//9
	fieldnamelsitchinese.add("安全生产监督管理局部门联系人");//10//10
	fieldnamelsitchinese.add("安全生产监督管理局部门联系电话");//11//11
	fieldnamelsitchinese.add("安全生产监督管理局部门邮编");//12//12
	fieldnamelsitchinese.add("出表日期");//13//13
}

}
