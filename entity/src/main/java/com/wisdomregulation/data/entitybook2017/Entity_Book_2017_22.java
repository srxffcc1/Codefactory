package com.wisdomregulation.data.entitybook2017;
//鉴定委托书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_22 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_22(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监鉴");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("list物品鉴定lim3_物品名称2规格型号2数量2备注");//4 以送达回执为例子 文书名称1#收件人1#地点1#日期1#方式1#送达人1#送达人2@xxx#xxx@段内#号分割 段间艾特符号分割
	fieldnamelsitchinese.add("鉴定要求");//5
	fieldnamelsitchinese.add("鉴定结果提交期限");//6
	fieldnamelsitchinese.add("联系人");//7
	fieldnamelsitchinese.add("联系电话");//8
	fieldnamelsitchinese.add("出表日期");//9

}
}
