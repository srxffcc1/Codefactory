package com.wisdomregulation.data.entitybook2017;
//查封扣押决定书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_7 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_7(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监查扣");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("发现问题");//4
	fieldnamelsitchinese.add("处理依据");//5
	fieldnamelsitchinese.add("强制措施");//6
	fieldnamelsitchinese.add("强制措施期限开始");//7
	fieldnamelsitchinese.add("强制措施期限结束");//8
	fieldnamelsitchinese.add("不服决定60日内可申诉人民政府");//9
	fieldnamelsitchinese.add("不服决定60日内可申诉单位");//10
	fieldnamelsitchinese.add("不服决定6个月内可申诉人民法院");//11
	fieldnamelsitchinese.add("附件《查封扣押（场所、设施、财物）清单》编号");//12
	fieldnamelsitchinese.add("出表日期");//13

}
}
