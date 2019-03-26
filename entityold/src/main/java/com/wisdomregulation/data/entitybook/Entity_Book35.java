package com.wisdomregulation.data.entitybook;
//案卷首页

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book35 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book35(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管案");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("安监管部门所属区域");//3//3
	fieldnamelsitchinese.add("案件名称");//4//4
	fieldnamelsitchinese.add("案由");//5//5
	fieldnamelsitchinese.add("处理结果");//6//6
	fieldnamelsitchinese.add("立案日期");//7//7
	fieldnamelsitchinese.add("结案日期");//8//8
	fieldnamelsitchinese.add("承办人1姓名");//9//9
	fieldnamelsitchinese.add("承办人2姓名");//10//10
	fieldnamelsitchinese.add("归档日期");//11//11
	fieldnamelsitchinese.add("归档号");//12//12
	fieldnamelsitchinese.add("保存期限日期");//13//13

}
}
