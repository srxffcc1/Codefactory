package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;
//办案实体
public class Entity_Law extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Law(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("案件名称");//0
		fieldnamelsitchinese.add("案件来源");//1
		fieldnamelsitchinese.add("检查名字");//2
		fieldnamelsitchinese.add("检查记录id");//3
		fieldnamelsitchinese.add("来自何复查");//4
		fieldnamelsitchinese.add("来自何复查id");//5
		fieldnamelsitchinese.add("检查类型");//6
		fieldnamelsitchinese.add("检查内容");//7
		fieldnamelsitchinese.add("复查内容");//8
		fieldnamelsitchinese.add("被检查单位");//9
		fieldnamelsitchinese.add("被检查单位id");//10
		fieldnamelsitchinese.add("当前阶段");//11
		fieldnamelsitchinese.add("案件情况");//12
		fieldnamelsitchinese.add("检查人");//13
		fieldnamelsitchinese.add("立案时间");//14
		fieldnamelsitchinese.add("节案时间");//15
		fieldnamelsitchinese.add("归档时间");//16
		fieldnamelsitchinese.add("复查结果id");//17  
		fieldnamelsitchinese.add("检查人联系方式");//18
		fieldnamelsitchinese.add("检查时间");//19
		fieldnamelsitchinese.add("检查情况");//20
		fieldnamelsitchinese.add("移交人");//21
		fieldnamelsitchinese.add("复查情况");//22
		
		
	}
}
//fieldnamelsitchinese.add("案件名字");//中文字段
//fieldnamelsitchinese.add("案件来源");//6大来源
//fieldnamelsitchinese.add("检查名字");//检查名字
//fieldnamelsitchinese.add("检查id");//检查id
//fieldnamelsitchinese.add("来自何复查");//复查名字
//fieldnamelsitchinese.add("来自何复查id");//复查id
//fieldnamelsitchinese.add("检查类型");//职业卫生检查 企业安全检查
//fieldnamelsitchinese.add("检查内容");//一个id指代是检查结果Entity_Check中的检查内容字段
//fieldnamelsitchinese.add("复查内容");//一串id指代是检查结果Entity_AgainCheck中的复查项目字段
//fieldnamelsitchinese.add("被办案企业名称");
//fieldnamelsitchinese.add("企业id");
//fieldnamelsitchinese.add("案件状态");//6个状态 即阶段的意思
//fieldnamelsitchinese.add("案件情况");
//fieldnamelsitchinese.add("检查人");
//fieldnamelsitchinese.add("立案时间");
//fieldnamelsitchinese.add("节案时间");
//fieldnamelsitchinese.add("归档时间");
