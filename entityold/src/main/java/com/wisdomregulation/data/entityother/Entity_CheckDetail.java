package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//检查内容实体
public class Entity_CheckDetail extends DateBase_Entity {
	private List<String> fieldnamelsitchinese=new ArrayList<String>();
	private Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_CheckDetail(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("所检查企业名称");//23

		fieldnamelsitchinese.add("关联检查项");//1  // 执法依据 id
		fieldnamelsitchinese.add("检查内容");//2
		fieldnamelsitchinese.add("检查要求");//3
		fieldnamelsitchinese.add("检查方法");//4

		fieldnamelsitchinese.add("法律依据");//5
		fieldnamelsitchinese.add("执法依据");//6
		fieldnamelsitchinese.add("检查结果");//7
		fieldnamelsitchinese.add("违法行为");//8
		fieldnamelsitchinese.add("处罚种类和幅度");//9
		fieldnamelsitchinese.add("行政处罚");//10
		fieldnamelsitchinese.add("来自何结果项目");//11
		fieldnamelsitchinese.add("整改方式");//12
		fieldnamelsitchinese.add("整改期限");//13
		fieldnamelsitchinese.add("整改意见");//14
		fieldnamelsitchinese.add("隐患级别");//15  需要传的
		fieldnamelsitchinese.add("隐患描述");//16 

		fieldnamelsitchinese.add("检查类型");//17
		fieldnamelsitchinese.add("检查项目明细中文上层");//18
		fieldnamelsitchinese.add("所属计划");//19
		fieldnamelsitchinese.add("复查id");//20
		fieldnamelsitchinese.add("整改结果");//21
		fieldnamelsitchinese.add("负责人");//22
		fieldnamelsitchinese.add("检查项目明细");//0
		fieldnamelsitchinese.add("来自何检查id");//24
		fieldnamelsitchinese.add("所属企业");//25 //需要传的
		fieldnamelsitchinese.add("检查时间");//26
		fieldnamelsitchinese.add("检查人员");//27
		fieldnamelsitchinese.add("隐患整改前图片");//28
		fieldnamelsitchinese.add("隐患整改后图片");//29
		fieldnamelsitchinese.add("证据采集");//30
		fieldnamelsitchinese.add("隐患类型");//31  //目前先中类
		fieldnamelsitchinese.add("标准");//32
		fieldnamelsitchinese.add("整改措施");//33
		fieldnamelsitchinese.add("整改方案");//34
		fieldnamelsitchinese.add("是否上报");//35
		fieldnamelsitchinese.add("整改人");//36
		fieldnamelsitchinese.add("整改建议");//37
		fieldnamelsitchinese.add("是否整改完成");//38 需要
		fieldnamelsitchinese.add("整改完成时间");//39
		fieldnamelsitchinese.add("上次复查时间");//40
		fieldnamelsitchinese.add("复查描述");//41
		fieldnamelsitchinese.add("隐患来源");//42
		fieldnamelsitchinese.add("相关证据");//43
		fieldnamelsitchinese.add("整改落实资金");//44
		fieldnamelsitchinese.add("审核状态");//45

	}
}
//fieldnamelsitchinese.add("检查项目明细");//即保存于Result中哪个字段
//fieldnamelsitchinese.add("检查项目明细中文");//即保存于哪个字段中文
//fieldnamelsitchinese.add("检查内容");//中文字段内容
//fieldnamelsitchinese.add("检查要求");//中文字段
//fieldnamelsitchinese.add("检查方法");//中文字段
//fieldnamelsitchinese.add("执法依据");//中文字段 与检查项目相关
//fieldnamelsitchinese.add("法律依据");//中文字段 某条法律
//fieldnamelsitchinese.add("检查结果");//一般隐患或者无隐患 或者重大隐患
//fieldnamelsitchinese.add("违法行为");//中文字段
//fieldnamelsitchinese.add("处罚种类和幅度");//中文字段
//fieldnamelsitchinese.add("行政处罚");//中文字段
//fieldnamelsitchinese.add("隐患描述");//中文字段
//fieldnamelsitchinese.add("整改方式");//立即整改 或者 期限整改
//fieldnamelsitchinese.add("整改期限");//时间
//fieldnamelsitchinese.add("整改意见");//中文字段
//fieldnamelsitchinese.add("证据采集");//中文字段
//fieldnamelsitchinese.add("来自何结果项目");//指对应的ResultID
