package com.wisdomregulation.data.entitybook2017;
//责令限期整改指令书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_4 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_4(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管立");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("存在问题");//4
	fieldnamelsitchinese.add("对第几项进行整改");//5
	fieldnamelsitchinese.add("整改期限");//6
	fieldnamelsitchinese.add("不服决定60日内可申诉人民政府");//7
	fieldnamelsitchinese.add("不服决定60日内可申诉单位");//8
	fieldnamelsitchinese.add("不服决定6个月内可申诉人民法院");//9
	fieldnamelsitchinese.add("执法人员1签名");//10
	fieldnamelsitchinese.add("执法人员1证号");//11
	fieldnamelsitchinese.add("执法人员2签名");//12
	fieldnamelsitchinese.add("执法人员2证号");//13
	fieldnamelsitchinese.add("被检查单位负责人签名");//14
	fieldnamelsitchinese.add("出表日期");//15

}
}
