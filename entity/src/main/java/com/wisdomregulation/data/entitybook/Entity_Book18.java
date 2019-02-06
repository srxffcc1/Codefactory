package com.wisdomregulation.data.entitybook;
//听证会通知书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book18 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book18(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管听通");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("申请单位的名称");//3//3
	fieldnamelsitchinese.add("关于什么案件的名称");//4//4
	fieldnamelsitchinese.add("听证会议时间");//5//5
	fieldnamelsitchinese.add("听证会地点");//6//6
	fieldnamelsitchinese.add("听证主持人姓名");//7//7
	fieldnamelsitchinese.add("听证主持人职务");//8//8
	fieldnamelsitchinese.add("听证员1姓名");//9//9
	fieldnamelsitchinese.add("听证员1职务");//10//10
	fieldnamelsitchinese.add("听证员2姓名");//11//11
	fieldnamelsitchinese.add("听证员2职务");//12//12
	fieldnamelsitchinese.add("书记员姓名");//13//13
	fieldnamelsitchinese.add("书记员职务");//14//14
	fieldnamelsitchinese.add("通知发布日期");//15//15
	fieldnamelsitchinese.add("安全生产监督管理局部门地址");//16//16
	fieldnamelsitchinese.add("安全生产监督管理局部门邮编");//17//17
	fieldnamelsitchinese.add("安全生产监督管理局部门联系人");//18//18
	fieldnamelsitchinese.add("安全生产监督管理局部门联系电话");//19//19

}

}
