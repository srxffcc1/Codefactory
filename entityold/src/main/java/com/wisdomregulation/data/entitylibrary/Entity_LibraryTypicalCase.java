package com.wisdomregulation.data.entitylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//典型事故案例
public class Entity_LibraryTypicalCase extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_LibraryTypicalCase(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("事故标题");//0
		fieldnamelsitchinese.add("涉及行业");//1
		fieldnamelsitchinese.add("事故类型");//2
		fieldnamelsitchinese.add("事故模型");//3
		fieldnamelsitchinese.add("发生日期");//4
		fieldnamelsitchinese.add("财产损失");//5
		fieldnamelsitchinese.add("预防措施");//6
		fieldnamelsitchinese.add("事故起因");//7
		fieldnamelsitchinese.add("发生地点");//8
		fieldnamelsitchinese.add("轻伤人数");//9
		fieldnamelsitchinese.add("重伤人数");//10
		fieldnamelsitchinese.add("死亡人数");//11
	}
}
