package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//通讯录
public class Entity_Contact extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Contact(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("联系人名字");//0
		fieldnamelsitchinese.add("联系人性别");//1
		fieldnamelsitchinese.add("联系人部门");//2
		fieldnamelsitchinese.add("联系人职位");//3
		fieldnamelsitchinese.add("联系人固话");//4
		fieldnamelsitchinese.add("联系人手机");//5
		

	}
}
//fieldnamelsitchinese.add("联系人名字");
//fieldnamelsitchinese.add("联系人性别");
//fieldnamelsitchinese.add("联系人部门");
//fieldnamelsitchinese.add("联系人职位");
//fieldnamelsitchinese.add("联系人固话");
//fieldnamelsitchinese.add("联系人手机");