package com.wisdomregulation.data.entitylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//隐患排查
public class Entity_LibraryDangerousCheck extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_LibraryDangerousCheck(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("隐患排查名字");//0
		fieldnamelsitchinese.add("自查标准具体内容");//1
		fieldnamelsitchinese.add("IV四级隐患自查标准");//2
		fieldnamelsitchinese.add("III三级隐患自查标准");//3
		fieldnamelsitchinese.add("II二级隐患自查标准");//4
		fieldnamelsitchinese.add("I一级隐患自查标准");//5
		fieldnamelsitchinese.add("监督行业大类");//6
		fieldnamelsitchinese.add("参考依据");//7
		fieldnamelsitchinese.add("监督行业小类");//8
	}
}
