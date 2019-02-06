package com.wisdomregulation.data.entitybook2017;
//文书送达回执

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity_Book_2017_39 extends Base_Entity {
private List<String> fieldnamelsitchinese=new ArrayList<String>();
private Map<String,String> fieldvaluemap=new HashMap<String, String>();
public Entity_Book_2017_39(){
	super.initsuper(fieldnamelsitchinese, fieldvaluemap);
}
{
	fieldnamelsitchinese.clear();
	fieldnamelsitchinese.add("安监回");//0
	fieldnamelsitchinese.add("字");//1
	fieldnamelsitchinese.add("号");//2
	fieldnamelsitchinese.add("案件名称");//3
	fieldnamelsitchinese.add("受送达单位个人");//4
	fieldnamelsitchinese.add("list送达回执lim5_送达文书名称文号2收件人签名或者盖章2送达地点2送达地点2送达日期2送达人一2送达人二");//5 以送达回执为例子 文书名称1#收件人1#地点1#日期1#方式1#送达人1#送达人2@xxx#xxx@段内#号分割 段间艾特符号分割
	fieldnamelsitchinese.add("备注");//6
}
}
