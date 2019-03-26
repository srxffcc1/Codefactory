package com.wisdomregulation.data.entitybook2017;
//先行登记保存证据处理决定书

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_21 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_21(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监先保处");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("被检查单位");//3
	fieldnamelsitchinese.add("登记日期");//4
	fieldnamelsitchinese.add("登记物品");//5
	fieldnamelsitchinese.add("先行登记保存书所属安监局");//6
	fieldnamelsitchinese.add("先行登记保存书字");//7
	fieldnamelsitchinese.add("先行登记保存书号");//8
	fieldnamelsitchinese.add("处理决定");//9
	fieldnamelsitchinese.add("不服决定60日内可申诉人民政府");//10
	fieldnamelsitchinese.add("不服决定60日内可申诉单位");//11
	fieldnamelsitchinese.add("不服决定6个月内可申诉人民法院");//12
	fieldnamelsitchinese.add("出表日期");//13

}
}
