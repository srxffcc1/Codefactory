package com.wisdomregulation.data.entitybook2017;
//现场检查方案

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_1 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_1(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监检查");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("被检查单位地址");//4
	fieldnamelsitchinese.add("被检查单位联系人");//5
	fieldnamelsitchinese.add("被检查单位所属行业");//6
	fieldnamelsitchinese.add("检查时间");//7
	fieldnamelsitchinese.add("行政执法人员");//8
	fieldnamelsitchinese.add("检查内容");//9
	fieldnamelsitchinese.add("检查方式");//10
	fieldnamelsitchinese.add("审核意见");//11
	fieldnamelsitchinese.add("审核人签名");//12
	fieldnamelsitchinese.add("审核人签名日期");//13
	fieldnamelsitchinese.add("审批意见");//14
	fieldnamelsitchinese.add("审批人签名");//15
	fieldnamelsitchinese.add("审批人签名日期");//16
	fieldnamelsitchinese.add("备注");//17

}
}
