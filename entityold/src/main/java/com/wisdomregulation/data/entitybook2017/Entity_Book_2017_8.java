package com.wisdomregulation.data.entitybook2017;
//查封扣押（场所、设施、财物）清单

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_8 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_8(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("null安监管立");//0
	fieldnamelsitchinese.add("null字");//1
	fieldnamelsitchinese.add("清单编号");//2
	fieldnamelsitchinese.add("list查封扣押lim10_编号2名称2规格型号或者地址2单位2数量或者面积2备注");//3
	fieldnamelsitchinese.add("当事人签名");//4
	fieldnamelsitchinese.add("当事人签名日期");//5
	fieldnamelsitchinese.add("执法人员1签名");//6
	fieldnamelsitchinese.add("执法人员1证号");//7
	fieldnamelsitchinese.add("执法人员1签名日期");//8
	fieldnamelsitchinese.add("执法人员2签名");//9
	fieldnamelsitchinese.add("执法人员2证号");//10
	fieldnamelsitchinese.add("执法人员2签名日期");//11

}
}
