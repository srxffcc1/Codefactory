package com.wisdomregulation.data.entitybook2017;
//行政强制执行事先催告书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_40 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_40(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监执行催告");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("决定日期");//4
	fieldnamelsitchinese.add("未履行内容");//5
	fieldnamelsitchinese.add("check期限罚款2立即履行决定");//6 传1或者2
	fieldnamelsitchinese.add("罚款缴纳期限");//7
	fieldnamelsitchinese.add("罚款金额");//8
	fieldnamelsitchinese.add("加处罚款");//9
	fieldnamelsitchinese.add("合计罚款");//10
	fieldnamelsitchinese.add("加处罚款缴纳处");//11
	fieldnamelsitchinese.add("立即履行决定内容");//12
	fieldnamelsitchinese.add("出表日期");//13

}
}
