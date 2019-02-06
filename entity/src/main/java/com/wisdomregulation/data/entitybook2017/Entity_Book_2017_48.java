package com.wisdomregulation.data.entitybook2017;
//先 行 登 记 保 存 证 据 清 单

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_48 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_48(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("null安监管立");//0
	fieldnamelsitchinese.add("null字");//1
	fieldnamelsitchinese.add("null号");//2
	fieldnamelsitchinese.add("list清单lim10_序号2证据名称2规格型号2产地2成色2单位2价格2数量2备注");//3 以送达回执为例子 文书名称1#收件人1#地点1#日期1#方式1#送达人1#送达人2@xxx#xxx@段内#号分割 段间艾特符号分割
	fieldnamelsitchinese.add("被通知人签名");//4
	fieldnamelsitchinese.add("承办人1签名");//5
	fieldnamelsitchinese.add("承办人2签名");//5

}
}
