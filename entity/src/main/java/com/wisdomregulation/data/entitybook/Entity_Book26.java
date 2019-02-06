package com.wisdomregulation.data.entitybook;
//行政处罚决定书（个人）

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book26 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book26(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管罚");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("被处罚人姓名");//3//3
	fieldnamelsitchinese.add("被处罚人性别");//4//4
	fieldnamelsitchinese.add("被处罚人年龄");//5//5
	fieldnamelsitchinese.add("被处罚人联系电话");//6//6
	fieldnamelsitchinese.add("被处罚人家庭住址");//7//7
	fieldnamelsitchinese.add("被处罚人所在单位名称");//8//8
	fieldnamelsitchinese.add("被处罚人职务");//9//9
	fieldnamelsitchinese.add("被处罚人单位地址");//10//10
	fieldnamelsitchinese.add("被处罚人单位邮编");//11//11
	fieldnamelsitchinese.add("违法事实及依据");//12//12
	fieldnamelsitchinese.add("违法了什么规定");//13//13
	fieldnamelsitchinese.add("依据什么规定进行处罚");//14//14
	fieldnamelsitchinese.add("给予了什么行政处罚");//15//15
	fieldnamelsitchinese.add("收到决定书15日内到什么地点");//16//16
	fieldnamelsitchinese.add("收到决定书15日内缴纳账号");//17//17
	fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//18//18
	fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//19//19
	fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//20//20
	fieldnamelsitchinese.add("出表日期");//21//21

}

}
