package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//检查任务实体
public class Entity_Check extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Check(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("所属计划");//0
		fieldnamelsitchinese.add("检查名字");//1
		fieldnamelsitchinese.add("检查类型");//2
		fieldnamelsitchinese.add("检查内容");//3
		fieldnamelsitchinese.add("企业名称");//4
		fieldnamelsitchinese.add("企业id");//5   //就是企业组织机构代码
		fieldnamelsitchinese.add("是否完成");//6 //完成这次检查
		fieldnamelsitchinese.add("发现的隐患");//7
		fieldnamelsitchinese.add("检查结果");//8
		fieldnamelsitchinese.add("是否办案");//9
		fieldnamelsitchinese.add("复查状态");//10 //当需要复查时去判断是不是完成了复查
		fieldnamelsitchinese.add("相关文书");//11
		fieldnamelsitchinese.add("检查日期");//12
		fieldnamelsitchinese.add("检查人账号");//13
		fieldnamelsitchinese.add("检查人");//14 //用户名字
		fieldnamelsitchinese.add("是否是计划内的");//15 0为临时 1为计划内
		fieldnamelsitchinese.add("是否要复查");//16 向服务端征求的一个状态位
		fieldnamelsitchinese.add("复查建议");//17 目前先放着
	}
}
//fieldnamelsitchinese.add("计划id");
//fieldnamelsitchinese.add("检查名字");//检查名字
//fieldnamelsitchinese.add("检查类型");//中文字段 职业卫生检查 还是 企业安全检查
//fieldnamelsitchinese.add("检查内容");//一个id指代是Entity_CheckHealthResult还是Entity_CheckSaveResult中的一个id字段  
//fieldnamelsitchinese.add("所检查企业名称");//企业名字
//fieldnamelsitchinese.add("企业id");//企业id
//fieldnamelsitchinese.add("检查状态");//是否已经激活状态 //三种状态 未执行 执行中 完成
//fieldnamelsitchinese.add("发现的隐患");//隐患id Dangerous xxxxx,xxxxx,xxxxx
//fieldnamelsitchinese.add("检查结果");//合格或者不合格 
//fieldnamelsitchinese.add("是否办案");//办案或者不办案
//fieldnamelsitchinese.add("是否复查");//复查或者不复查
//fieldnamelsitchinese.add("相关文书");//指的是Entity_BookList里的一串id xxxxx,xxxxxxxx,xxxxxx 
//fieldnamelsitchinese.add("检查日期");
//fieldnamelsitchinese.add("检查人账号");
//fieldnamelsitchinese.add("检查人");
//fieldnamelsitchinese.add("是否临时");
