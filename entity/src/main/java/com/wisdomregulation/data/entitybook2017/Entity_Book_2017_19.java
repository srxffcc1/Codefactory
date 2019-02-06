package com.wisdomregulation.data.entitybook2017;
//先行登记保存证据通知书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_19 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_19(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监先保通");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被通知单位");//3
	fieldnamelsitchinese.add("你单位涉嫌行为");//4
	fieldnamelsitchinese.add("注意事项");//5
	fieldnamelsitchinese.add("接受处理决定日期");//6
	fieldnamelsitchinese.add("接受什么处理决定");//7
	fieldnamelsitchinese.add("出表日期");//8
	fieldnamelsitchinese.add("被通知人或者被通知单位负责人签名");//9

}
}
