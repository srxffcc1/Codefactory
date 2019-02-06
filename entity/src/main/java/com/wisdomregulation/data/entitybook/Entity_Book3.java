package com.wisdomregulation.data.entitybook;
//勘查笔录

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book3 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book3(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管勘");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("勘验开始时间");//3//3
	fieldnamelsitchinese.add("勘验结束时间");//4//4
	fieldnamelsitchinese.add("勘验场所");//5//5
	fieldnamelsitchinese.add("勘验天气情况");//6//6
	fieldnamelsitchinese.add("勘验人1姓名");//7//7
	fieldnamelsitchinese.add("勘验人1单位及职务");//8//8
	fieldnamelsitchinese.add("勘验人2姓名");//9//9
	fieldnamelsitchinese.add("勘验人2单位及职务");//10//10
	fieldnamelsitchinese.add("当事人1姓名");//11//11
	fieldnamelsitchinese.add("当事人1单位及职务");//12//12
	fieldnamelsitchinese.add("当事人2姓名");//13//13
	fieldnamelsitchinese.add("当事人2单位及职务");//14//14
	fieldnamelsitchinese.add("被邀请人姓名");//15//15
	fieldnamelsitchinese.add("被邀请人单位及职务");//16//16
	fieldnamelsitchinese.add("记录人姓名");//17//17
	fieldnamelsitchinese.add("记录人单位及职务");//18//18
	fieldnamelsitchinese.add("安全生产监管理局所属区域");//19//19
	fieldnamelsitchinese.add("执法人员1姓名");//20//20
	fieldnamelsitchinese.add("执法人员2姓名");//21//21
	fieldnamelsitchinese.add("执法人员1证件号");//22//22
	fieldnamelsitchinese.add("执法人员2证件号");//23//23
	fieldnamelsitchinese.add("勘验情况");//24//24
	fieldnamelsitchinese.add("勘验人1签名");//25//25
	fieldnamelsitchinese.add("勘验人2签名");//26//26
	fieldnamelsitchinese.add("当事人1签名");//27//27
	fieldnamelsitchinese.add("当事人1联系方式");//28//28
	fieldnamelsitchinese.add("当事人2签名");//29//29
	fieldnamelsitchinese.add("当事人2联系方式");//30//30
	fieldnamelsitchinese.add("被邀请人签名");//31//31
	fieldnamelsitchinese.add("被邀请人联系方式");//32//32

}

}
