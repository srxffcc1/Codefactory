package com.wisdomregulation.data.entitybook2017;
//询问通知书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_14 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_14(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监询");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被询问单位");//3
	fieldnamelsitchinese.add("询问原因");//4
	fieldnamelsitchinese.add("询问时间");//5
	fieldnamelsitchinese.add("接受询问地点");//6
	fieldnamelsitchinese.add("check身份证2营业执照2法定代表人身份证明或者委托书2自定义");//7
	fieldnamelsitchinese.add("自定义填写项");//8
	fieldnamelsitchinese.add("安全生产监督管理部门地址");//9
	fieldnamelsitchinese.add("联系人");//10
	fieldnamelsitchinese.add("联系电话");//11
	fieldnamelsitchinese.add("出表日期");//12

}
}
