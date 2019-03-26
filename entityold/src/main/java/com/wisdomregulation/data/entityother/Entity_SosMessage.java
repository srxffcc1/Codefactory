package com.wisdomregulation.data.entityother;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//预警消息
public class Entity_SosMessage extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_SosMessage(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("预警标题");//0
		fieldnamelsitchinese.add("预警类型");//1
		fieldnamelsitchinese.add("报警企业");//8
		fieldnamelsitchinese.add("点位名称");//2
		fieldnamelsitchinese.add("知晓人员");//4
		fieldnamelsitchinese.add("报警级别");//5
		fieldnamelsitchinese.add("报警值");//6
		fieldnamelsitchinese.add("报警时间");//7
		
	}
}

