package com.wisdomregulation.data.entitybook;
//抽样取证凭证

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book4 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book4(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管抽");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被抽样取证单位");//3//3
	fieldnamelsitchinese.add("现场负责人");//4//4
	fieldnamelsitchinese.add("单位地址");//5//5
	fieldnamelsitchinese.add("单位联系电话");//6//6
	fieldnamelsitchinese.add("单位邮编");//7//7
	fieldnamelsitchinese.add("抽样取证开始时间");//8//8
	fieldnamelsitchinese.add("抽样取证结束时间");//9//9
	fieldnamelsitchinese.add("抽样地点");//10//10
	fieldnamelsitchinese.add("list证据lim9_序号2证据物品名称2规格及批号2数量");//11//11
	fieldnamelsitchinese.add("被抽样取证现场负责人签名");//12//12
	fieldnamelsitchinese.add("执法人员1签名");//13//13
	fieldnamelsitchinese.add("执法人员1证件号");//14//14
	fieldnamelsitchinese.add("执法人员2签名");//15//15
	fieldnamelsitchinese.add("执法人员2证件号");//16//16
	fieldnamelsitchinese.add("出表日期");//17//17

}
}
