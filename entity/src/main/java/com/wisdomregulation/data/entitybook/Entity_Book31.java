package com.wisdomregulation.data.entitybook;
//强制执行申请书

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book31 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book31(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管强执");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("申请书递交的人民法院所属区域");//3//3
	fieldnamelsitchinese.add("申请时间");//4//4
	fieldnamelsitchinese.add("被申请执行人");//5//5
	fieldnamelsitchinese.add("做出了什么行政处罚决定");//6//6
	fieldnamelsitchinese.add("相关文号");//7//7
	fieldnamelsitchinese.add("相关材料");//8//8
	fieldnamelsitchinese.add("出表日期");//9//9
	fieldnamelsitchinese.add("联系人");//10//10
	fieldnamelsitchinese.add("联系电话");//11//11


}

}
