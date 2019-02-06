package com.wisdomregulation.data.entitybook2017;
//现场处理措施决定书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_3 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_3(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监现决");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("检查时间");//4
	fieldnamelsitchinese.add("发现隐患");//5
	fieldnamelsitchinese.add("处理依据");//6
	fieldnamelsitchinese.add("处理决定");//7
	fieldnamelsitchinese.add("不服决定60日内可申诉人民政府");//8
	fieldnamelsitchinese.add("不服决定60日内可申诉单位");//9
	fieldnamelsitchinese.add("不服决定6个月内可申诉人民法院");//10
	fieldnamelsitchinese.add("执法人员1签名");//11
	fieldnamelsitchinese.add("执法人员1证号");//12
	fieldnamelsitchinese.add("执法人员2签名");//13
	fieldnamelsitchinese.add("执法人员2证号");//14
	fieldnamelsitchinese.add("被检查单位负责人签名");//15
	fieldnamelsitchinese.add("出表日期");//16

}
}
