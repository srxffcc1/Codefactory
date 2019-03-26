package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;
//大计划实体
public class Entity_BigPlan extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_BigPlan(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("执法计划名称");//0
		fieldnamelsitchinese.add("执法计划类型");//1
		fieldnamelsitchinese.add("检查类别");//2
		fieldnamelsitchinese.add("检查时间起");//3
		fieldnamelsitchinese.add("检查时间至");//4
		fieldnamelsitchinese.add("负责人名称");//5
		fieldnamelsitchinese.add("负责单位");//6
		fieldnamelsitchinese.add("负责人");//7
		fieldnamelsitchinese.add("负责单位名称");//8
		fieldnamelsitchinese.add("计划状态");//9
		
	}
}

