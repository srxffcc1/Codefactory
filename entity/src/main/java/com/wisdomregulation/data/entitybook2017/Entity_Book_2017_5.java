package com.wisdomregulation.data.entitybook2017;
//整改复查意见书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_5 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_5(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监复查");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被复查单位");//3
	fieldnamelsitchinese.add("决定日期");//4
	fieldnamelsitchinese.add("做出的决定");//5
	fieldnamelsitchinese.add("所属安监管");//6
	fieldnamelsitchinese.add("决定文号安监行为");//7
	fieldnamelsitchinese.add("决定文号字");//8
	fieldnamelsitchinese.add("决定文号号");//9
	fieldnamelsitchinese.add("复查意见");//10
	fieldnamelsitchinese.add("被复查单位负责人签名");//11
	fieldnamelsitchinese.add("执法人员1签名");//12
	fieldnamelsitchinese.add("执法人员1证号");//13
	fieldnamelsitchinese.add("执法人员2签名");//14
	fieldnamelsitchinese.add("执法人员2证号");//15
	fieldnamelsitchinese.add("出表日期");//16

}
}
