package com.wisdomregulation.data.entitybook;
//现场处理措施决定书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book10 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book10(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管现决");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被检查单位");//3//3
	fieldnamelsitchinese.add("被检查时间");//4//4
	fieldnamelsitchinese.add("发现的违规行为和事故隐患1");//5//5
	fieldnamelsitchinese.add("发现的违规行为和事故隐患2");//6//6
	fieldnamelsitchinese.add("发现的违规行为和事故隐患3");//7//7
	fieldnamelsitchinese.add("依据某规定");//8//8
	fieldnamelsitchinese.add("做出的现场处理决定1");//9//9
	fieldnamelsitchinese.add("做出的现场处理决定2");//10//10
	fieldnamelsitchinese.add("做出的现场处理决定3");//11//11
	fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//12//12
	fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//13//13
	fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//14//14
	fieldnamelsitchinese.add("执法人员1姓名");//15//15
	fieldnamelsitchinese.add("执法人员1证件号");//16//16
	fieldnamelsitchinese.add("执法人员2姓名");//17//17
	fieldnamelsitchinese.add("执法人员2证件号");//18//18
	fieldnamelsitchinese.add("被检查单位负责人签名");//19//19
	fieldnamelsitchinese.add("出表日期");//20//20

}
}
