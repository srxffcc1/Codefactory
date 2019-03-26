package com.wisdomregulation.data.entitylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//检查内容和要求关系实体 即执法依据库
public class Entity_LibraryLawDependence extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_LibraryLawDependence(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();//id会付给检查项 用于结合检查id和检查项id找到这条检查项记录
		fieldnamelsitchinese.add("行业类型");//0//检查类型中文
		fieldnamelsitchinese.add("检查项目一级");//1//
		fieldnamelsitchinese.add("检查项目二级");//2//
		fieldnamelsitchinese.add("检查项目三级");//3//
		fieldnamelsitchinese.add("检查项目四级");//4//
		fieldnamelsitchinese.add("检查要求");//5
		fieldnamelsitchinese.add("检查内容");//6
		fieldnamelsitchinese.add("检查方法");//7
		fieldnamelsitchinese.add("执法依据关联");//8//  可选法律


	}
}
