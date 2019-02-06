package com.wisdomregulation.data.entitybook2017;
//查封扣押处理决定书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_10 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_10(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监查扣处");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被查扣单位");//3
	fieldnamelsitchinese.add("决定日期");//4
	fieldnamelsitchinese.add("查封扣押决定书文号所属安监管");//5
	fieldnamelsitchinese.add("查封扣押决定书文号字");//6
	fieldnamelsitchinese.add("查封扣押决定书文号号");//7
	fieldnamelsitchinese.add("被处罚行为");//8
	fieldnamelsitchinese.add("强制措施");//9
	fieldnamelsitchinese.add("依据的法律法规");//10
	fieldnamelsitchinese.add("处理决定");//11
	fieldnamelsitchinese.add("不服决定60日内可申诉人民政府");//12
	fieldnamelsitchinese.add("不服决定60日内可申诉单位");//13
	fieldnamelsitchinese.add("不服决定6个月内可申诉人民法院");//14
	fieldnamelsitchinese.add("出表日期");//15

}
}
