package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//点位模拟量与企业关系
public class Entity_Bomb extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Bomb(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("企业id");//0 使用组织机构代码
		fieldnamelsitchinese.add("关系类型");//1
		fieldnamelsitchinese.add("点位或模拟量名称");//2
		fieldnamelsitchinese.add("点位视频地址");//3
		fieldnamelsitchinese.add("模拟量数据地址");//4
		fieldnamelsitchinese.add("企业名字");//5


	}
}
//fieldnamelsitchinese.add("企业id");
//fieldnamelsitchinese.add("关系类型");//说明此处书模拟量还是点位 1或者2 1为点位 2为模拟量
//fieldnamelsitchinese.add("点位或模拟量名称");
//fieldnamelsitchinese.add("点位视频地址");
//fieldnamelsitchinese.add("模拟量数据地址");
//fieldnamelsitchinese.add("企业名字");
