package com.wisdomregulation.data.entitybook2017;
//先行登记保存证据审批表

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_18 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_18(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监先保审");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("案件名称");//3
	fieldnamelsitchinese.add("当事人及基本情况");//4
	fieldnamelsitchinese.add("案件基本情况");//5
	fieldnamelsitchinese.add("证据名称及数量");//6
	fieldnamelsitchinese.add("提请理由及依据");//7
	fieldnamelsitchinese.add("保存方式");//8
	fieldnamelsitchinese.add("承办人意见");//9
	fieldnamelsitchinese.add("承办人签名1");//10
	fieldnamelsitchinese.add("承办人签名2");//11
	fieldnamelsitchinese.add("承办人签名日期");//12
	fieldnamelsitchinese.add("承办机构意见");//13
	fieldnamelsitchinese.add("承办机构负责人签名");//14
	fieldnamelsitchinese.add("承办机构负责人签名日期");//15
	fieldnamelsitchinese.add("审核意见");//16
	fieldnamelsitchinese.add("审核人签名");//17
	fieldnamelsitchinese.add("审核人签名日期");//18
	fieldnamelsitchinese.add("审批意见");//19
	fieldnamelsitchinese.add("审批人签名");//20
	fieldnamelsitchinese.add("审批人签名日期");//21

}
}
