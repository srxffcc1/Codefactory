package com.wisdomregulation.data.entitybook;
//询问笔录

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book2 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book2(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("null1");//0//0
	fieldnamelsitchinese.add("null2");//1//1
	fieldnamelsitchinese.add("null3");//2//2
	fieldnamelsitchinese.add("询问开始时间");//3//3
	fieldnamelsitchinese.add("询问结束时间");//4//4
	fieldnamelsitchinese.add("第几次询问");//5//5
	fieldnamelsitchinese.add("询问地点");//6//6
	fieldnamelsitchinese.add("被询问人姓名");//7//7
	fieldnamelsitchinese.add("被询问人性别");//8//8
	fieldnamelsitchinese.add("被询问人年龄");//9//9
	fieldnamelsitchinese.add("被询问人身份证号");//10//10
	fieldnamelsitchinese.add("被询问人工作单位");//11//11
	fieldnamelsitchinese.add("被询问人职务");//12//12
	fieldnamelsitchinese.add("被询问人住址");//13//13
	fieldnamelsitchinese.add("被询问人电话");//14//14
	fieldnamelsitchinese.add("询问人姓名");//15//15
	fieldnamelsitchinese.add("询问人单位及职务");//16//16
	fieldnamelsitchinese.add("记录人姓名");//17//17
	fieldnamelsitchinese.add("记录人单位及职务");//18//18
	fieldnamelsitchinese.add("在场人姓名");//19//19
	fieldnamelsitchinese.add("安全生产监督管理局所属区域");//20//20
	fieldnamelsitchinese.add("执法人员1");//21//21
	fieldnamelsitchinese.add("执法人员2");//22//22
	fieldnamelsitchinese.add("证件号1");//23//23
	fieldnamelsitchinese.add("证件号2");//24//24
	fieldnamelsitchinese.add("有关问题");//25//25
	fieldnamelsitchinese.add("询问记录");//26//26
	fieldnamelsitchinese.add("询问人签名");//27//27
	fieldnamelsitchinese.add("记录人签名");//28//28
	fieldnamelsitchinese.add("被询问人签名");//29//29
	fieldnamelsitchinese.add("出表日期");//30//30

}

}
