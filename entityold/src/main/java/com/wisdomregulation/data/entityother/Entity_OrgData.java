package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//元数据实体
public class Entity_OrgData extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_OrgData(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();//id字段与数据库一致
		fieldnamelsitchinese.add("父id");//0
		fieldnamelsitchinese.add("类型id");//1用来区分数据类型 比如可能是区县类型
		fieldnamelsitchinese.add("元数据数据码");//2比如企业信息里有部分是数据码
		fieldnamelsitchinese.add("元数据名");//3数据名字
	}
}
