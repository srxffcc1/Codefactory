package com.wisdomregulation.data.entitylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//安全生产法规
public class Entity_LibrarySafetyProduceLaw extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_LibrarySafetyProduceLaw(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("法规名称");//0
		fieldnamelsitchinese.add("法规类型");//1
		fieldnamelsitchinese.add("法规编号");//2
		fieldnamelsitchinese.add("颁布地区");//3
		fieldnamelsitchinese.add("颁布部门");//4
		fieldnamelsitchinese.add("颁布日期");//5
		fieldnamelsitchinese.add("内容");//6
		fieldnamelsitchinese.add("生效日期");//7
		fieldnamelsitchinese.add("实施日期");//8

	}
}
