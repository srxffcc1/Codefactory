package com.wisdomregulation.data.entitybook;
//延期（分期）缴纳罚款批准书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book29 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book29(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管缴批");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被处罚单位名称");//3//3
	fieldnamelsitchinese.add("发出处罚决定书日期");//4//4
	fieldnamelsitchinese.add("发出处罚决定书文号");//5//5
	fieldnamelsitchinese.add("罚款金额（大写）");//6//6
	fieldnamelsitchinese.add("check延期缴纳罚款2分期缴纳罚款");//7//7  传1或者2
	fieldnamelsitchinese.add("延期缴纳罚款期限日期（大写）");//8//8
	fieldnamelsitchinese.add("分期第几期");//9//9
	fieldnamelsitchinese.add("分期第几期的缴纳期限日期（大写）");//10//10
	fieldnamelsitchinese.add("分期第几期缴纳金额数量（大写）");//11//11
	fieldnamelsitchinese.add("分期未缴纳罚款金额（大写）");//12//12
	fieldnamelsitchinese.add("出表日期");//13//13

}

}
