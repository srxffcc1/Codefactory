package com.wisdomregulation.data.entityother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;
//文书仓库
public class Entity_BookList extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_BookList(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("检查id");//0
		fieldnamelsitchinese.add("复查id");//1
		fieldnamelsitchinese.add("案件id");//2
		fieldnamelsitchinese.add("办案阶段");//3
		fieldnamelsitchinese.add("文书类型");//4
		fieldnamelsitchinese.add("文书表具体表id");//5
		fieldnamelsitchinese.add("文书表具体表中文书id");//6
		fieldnamelsitchinese.add("企业id");//7
		fieldnamelsitchinese.add("文书日期");//8
		

	}
}
//fieldnamelsitchinese.add("检查id");//检查id
//fieldnamelsitchinese.add("复查id");//检查id
//fieldnamelsitchinese.add("案件id");//检查id
//fieldnamelsitchinese.add("办案阶段");//办案阶段中文字段
//fieldnamelsitchinese.add("文书类型");//中文名 某某某文书
//fieldnamelsitchinese.add("文书表具体表id");//比如是book0还是book1
//fieldnamelsitchinese.add("文书表具体表中文书id");//比如在book0中的文书id
//fieldnamelsitchinese.add("企业id");//企业id
//fieldnamelsitchinese.add("文书日期");//企业id
