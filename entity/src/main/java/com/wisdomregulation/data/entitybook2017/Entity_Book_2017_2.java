package com.wisdomregulation.data.entitybook2017;
//现场检查记录

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_2 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_2(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监检记");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("单位地址");//4
	fieldnamelsitchinese.add("单位法定代表人或负责人");//5
	fieldnamelsitchinese.add("代表人职务");//6
	fieldnamelsitchinese.add("代表人联系电话");//7
	fieldnamelsitchinese.add("检查场所");//8
	fieldnamelsitchinese.add("检查时间开始");//9
	fieldnamelsitchinese.add("检查时间结束");//10
	fieldnamelsitchinese.add("所属安全生产监督管理局");//11
	fieldnamelsitchinese.add("执法人员姓名1");//12
	fieldnamelsitchinese.add("执法人员姓名2");//13
	fieldnamelsitchinese.add("执法人员证件号1");//14
	fieldnamelsitchinese.add("执法人员证件号2");//15
	fieldnamelsitchinese.add("检查情况");//16
	fieldnamelsitchinese.add("检查人员签名1");//17
	fieldnamelsitchinese.add("检查人员签名2");//18
	fieldnamelsitchinese.add("被检查单位现场负责人签名");//19
	fieldnamelsitchinese.add("出表日期");//20

}
}
