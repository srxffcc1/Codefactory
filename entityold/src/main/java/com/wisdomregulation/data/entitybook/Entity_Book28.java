package com.wisdomregulation.data.entitybook;
//延期（分期）缴纳罚款审批表

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book28 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book28(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("null1");//0//0
	fieldnamelsitchinese.add("null2");//1//1
	fieldnamelsitchinese.add("null3");//2//2
	fieldnamelsitchinese.add("案件名称");//3//3
	fieldnamelsitchinese.add("处罚决定书文号");//4//4
	fieldnamelsitchinese.add("当事人姓名");//5//5
	fieldnamelsitchinese.add("当事人地址");//6//6
	fieldnamelsitchinese.add("违法事实及处罚决定");//7//7
	fieldnamelsitchinese.add("当事人申请延期（分期）缴纳罚款的理由");//8//8
	fieldnamelsitchinese.add("承办人意见");//9//9
	fieldnamelsitchinese.add("承办人1签名");//10//10
	fieldnamelsitchinese.add("承办人2签名");//11//11
	fieldnamelsitchinese.add("承办人签名日期");//12//12
	fieldnamelsitchinese.add("审核意见");//13//13
	fieldnamelsitchinese.add("审核人签名");//14//14
	fieldnamelsitchinese.add("审核人签名日期");//15//15
	fieldnamelsitchinese.add("审批意见");//16//16
	fieldnamelsitchinese.add("审批人签名");//17//17
	fieldnamelsitchinese.add("审批人签名日期");//18//18

}

}
