package com.wisdomregulation.data.entitybook;
//询问通知单

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class Entity_Book1 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book1(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管询");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("企业名称");//3//3
	fieldnamelsitchinese.add("被询问原因");//4//4
	fieldnamelsitchinese.add("接受询问时间");//5//5
	fieldnamelsitchinese.add("接受询问调查地点");//6//6
	fieldnamelsitchinese.add("check身份证2营业执照2法定代表人身份证明或者委托书2额外的所需材料选项");//7//7
	fieldnamelsitchinese.add("额外的所需材料选项内容");//8//8
	fieldnamelsitchinese.add("安全生产监督管理部门地址");//9//9
	fieldnamelsitchinese.add("联系人");//10//10
	fieldnamelsitchinese.add("联系电话");//11//11
	fieldnamelsitchinese.add("出表日期");//12//12

}
}
