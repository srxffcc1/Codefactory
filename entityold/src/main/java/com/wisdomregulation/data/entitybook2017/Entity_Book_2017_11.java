package com.wisdomregulation.data.entitybook2017;
//停止供电（供应民用爆炸物品）通知书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_11 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_11(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监停供通");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被停单位");//3
	fieldnamelsitchinese.add("安全事故原因");//4
	fieldnamelsitchinese.add("决定日期");//5
	fieldnamelsitchinese.add("决定内容");//6
	fieldnamelsitchinese.add("采取措施");//7
	fieldnamelsitchinese.add("配合日期");//8
	fieldnamelsitchinese.add("配合行为");//9
	fieldnamelsitchinese.add("出表日期");//10

}
}
