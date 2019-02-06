package com.wisdomregulation.data.entitybook2017;
//延期（分期）缴纳罚款批准书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_38 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_38(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监缴批");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被检查单位");//3//3
	fieldnamelsitchinese.add("行政处罚决定书日期");//4//4
	fieldnamelsitchinese.add("行政处罚决定书文号");//5//5
	fieldnamelsitchinese.add("罚款金额大写");//6//6
	fieldnamelsitchinese.add("check延期缴纳2分期缴纳");//7//7  传1或者2
	fieldnamelsitchinese.add("延长到的期限");//8//8
	fieldnamelsitchinese.add("分期第几期");//9//9
	fieldnamelsitchinese.add("分期期限");//10//10
	fieldnamelsitchinese.add("需缴纳罚款数量");//11//11
	fieldnamelsitchinese.add("尚未缴纳数量");//12
	fieldnamelsitchinese.add("出表日期");//13

}
}
