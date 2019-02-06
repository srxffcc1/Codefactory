package com.wisdomregulation.data.entitybook;
//文书送达回执

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book30 extends Base_Entity {
private  List<String> fieldnamelsitchinese=new ArrayList<String>();
private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book30(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监管回");//0//0
	fieldnamelsitchinese.add("字");//1//1
	fieldnamelsitchinese.add("号");//2//2
	fieldnamelsitchinese.add("案件名称");//3//3
	fieldnamelsitchinese.add("受送达单位（个人）名称");//4//4
	fieldnamelsitchinese.add("list文书lim12_送达文书名称、文号2收件人签名2送达地点2送达日期2送达方式2送达人");//5//5
	fieldnamelsitchinese.add("备注");//6//6

}
}
