package com.wisdomregulation.data.entitybook;
//结案审批表

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book32 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book32(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管结");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("案件名称");//3//3
	fieldnamelsitchinese.add("被处罚单位名称");//4//4
	fieldnamelsitchinese.add("被处罚单位地址");//5//5
	fieldnamelsitchinese.add("被处罚单位的法定代表人");//6//6
	fieldnamelsitchinese.add("被处罚单位的法定代表人职务");//7//7
	fieldnamelsitchinese.add("被处罚单位邮编");//8//8
	fieldnamelsitchinese.add("被处罚人姓名");//9//9
	fieldnamelsitchinese.add("被处罚人年龄");//10//10
	fieldnamelsitchinese.add("被处罚人性别");//11//11
	fieldnamelsitchinese.add("被处罚人所在单位");//12//12
	fieldnamelsitchinese.add("被处罚人所在单位地址");//13//13
	fieldnamelsitchinese.add("被处罚人家庭住址");//14//14
	fieldnamelsitchinese.add("被处罚人联系电话");//15//15
	fieldnamelsitchinese.add("被处罚人地址邮编");//16//16
	fieldnamelsitchinese.add("处理结果");//17//17
	fieldnamelsitchinese.add("执行情况");//18//18
	fieldnamelsitchinese.add("承办人1签名");//19//19
	fieldnamelsitchinese.add("承办人2签名");//20//20
	fieldnamelsitchinese.add("承办人签名日期");//21//21
	fieldnamelsitchinese.add("审核意见");//22//22
	fieldnamelsitchinese.add("审核人签名");//23//23
	fieldnamelsitchinese.add("审核人签名日期");//24//24
	fieldnamelsitchinese.add("审批意见");//25//25
	fieldnamelsitchinese.add("审批人签名");//26//26
	fieldnamelsitchinese.add("审批人签名日期");//27//27

}
}
