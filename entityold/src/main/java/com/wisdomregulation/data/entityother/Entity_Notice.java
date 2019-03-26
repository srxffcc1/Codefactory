package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//通讯录
public class Entity_Notice extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Notice(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{		
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("文件标题");//0
		fieldnamelsitchinese.add("文件内容");//1
		fieldnamelsitchinese.add("发布人");//2
		fieldnamelsitchinese.add("发布时间");//3
		

	}
}
//fieldnamelsitchinese.add("文件标题");
//fieldnamelsitchinese.add("文件内容");
//fieldnamelsitchinese.add("发布人");
//fieldnamelsitchinese.add("发布时间");