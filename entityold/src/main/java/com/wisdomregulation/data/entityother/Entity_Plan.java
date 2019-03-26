package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//计划实体
public class Entity_Plan extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Plan(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("检查区域");//0 填写的是id
		fieldnamelsitchinese.add("检查时间");//1 
		fieldnamelsitchinese.add("检查类型");//2//就是检查类型
		fieldnamelsitchinese.add("检查人");//3 计划的监察人是个集合 给的id是指明负责检查的人的标识
		fieldnamelsitchinese.add("所属计划id");//4
		fieldnamelsitchinese.add("是否完成");//5
		fieldnamelsitchinese.add("检查人名字");//6  用于在用户登录时获得 与用户名相关的区域计划
		
	}
}
//fieldnamelsitchinese.add("计划名字");
//fieldnamelsitchinese.add("计划状态");
//fieldnamelsitchinese.add("计划开始时间");
//fieldnamelsitchinese.add("计划结束时间");
//fieldnamelsitchinese.add("计划区域");
//fieldnamelsitchinese.add("执法计划类型");
//fieldnamelsitchinese.add("负责单位");
//fieldnamelsitchinese.add("负责人");
//fieldnamelsitchinese.add("负责单位名称");
//fieldnamelsitchinese.add("负责人名称");
