package com.wisdomregulation.data.entitybookjb;
//立案审批表

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_0 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_0(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管立");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("案由");//3
	fieldnamelsitchinese.add("案件来源");//4
	fieldnamelsitchinese.add("案件发生时间");//5
	fieldnamelsitchinese.add("案件名称");//6
	fieldnamelsitchinese.add("当事人");//7
	fieldnamelsitchinese.add("当事人电话");//8
	fieldnamelsitchinese.add("法定代表人或负责人");//9
	fieldnamelsitchinese.add("当事人地址");//10
	fieldnamelsitchinese.add("当事人邮政编码");//11
	fieldnamelsitchinese.add("案件基本情况");//12




	fieldnamelsitchinese.add("承办人意见");//13
	fieldnamelsitchinese.add("承办人1签名");//14
	fieldnamelsitchinese.add("承办人1证号");//15
	fieldnamelsitchinese.add("承办人2签名");//16
	fieldnamelsitchinese.add("承办人2证号");//17
	fieldnamelsitchinese.add("承办人签名日期");//18//18


	fieldnamelsitchinese.add("负责人意见");//19
	fieldnamelsitchinese.add("负责人签名");//20
	fieldnamelsitchinese.add("负责人签名日期");//22


	fieldnamelsitchinese.add("审核意见");//19
	fieldnamelsitchinese.add("审核人签名");//20
	fieldnamelsitchinese.add("审核人签名日期");//21
	fieldnamelsitchinese.add("审批意见");//22
	fieldnamelsitchinese.add("审批人签名");//23
	fieldnamelsitchinese.add("审批人签名日期");//24
}
}
