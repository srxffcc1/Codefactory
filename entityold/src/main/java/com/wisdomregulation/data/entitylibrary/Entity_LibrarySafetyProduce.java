package com.wisdomregulation.data.entitylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;
//安全生产标准
public class Entity_LibrarySafetyProduce extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_LibrarySafetyProduce(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("标准名称");//0
		fieldnamelsitchinese.add("颁布部门");//1
		fieldnamelsitchinese.add("颁布日期");//2
		fieldnamelsitchinese.add("标准类型");//3
		fieldnamelsitchinese.add("内容");//4
		fieldnamelsitchinese.add("标准编号");//5
		fieldnamelsitchinese.add("生效日期");//6
		fieldnamelsitchinese.add("实施日期");//7
	}
}
