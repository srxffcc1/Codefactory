package com.wisdomregulation.data.entitybook;
//行政处罚集体讨论记录

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book22 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book22(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("null1");//0//0
	fieldnamelsitchinese.add("null2");//1//1
	fieldnamelsitchinese.add("null3");//2//2
	fieldnamelsitchinese.add("案件名称");//3//3
	fieldnamelsitchinese.add("讨论开始时间");//4//4
	fieldnamelsitchinese.add("讨论结束时间");//5//5
	fieldnamelsitchinese.add("讨论地点");//6//6
	fieldnamelsitchinese.add("主持人");//7//7
	fieldnamelsitchinese.add("汇报人");//8//8
	fieldnamelsitchinese.add("记录人");//9//9
	fieldnamelsitchinese.add("出席人员姓名及职务");//10//10
	fieldnamelsitchinese.add("讨论内容");//11//11
	fieldnamelsitchinese.add("讨论记录");//12//12
	fieldnamelsitchinese.add("结论性意见");//13//13
	fieldnamelsitchinese.add("出席人员签名");//14//14
}

}
