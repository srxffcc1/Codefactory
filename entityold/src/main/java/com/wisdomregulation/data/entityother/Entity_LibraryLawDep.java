package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;
//法律依据和 执法依据 关系库
public class Entity_LibraryLawDep extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_LibraryLawDep(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();//需要id特别注明为线上id
		fieldnamelsitchinese.add("法规内容");//0//
		fieldnamelsitchinese.add("法规名字");//1//
		fieldnamelsitchinese.add("检查项属性");//2// 用来得到检查项可以选的 法律列表
		
		
	}
}
