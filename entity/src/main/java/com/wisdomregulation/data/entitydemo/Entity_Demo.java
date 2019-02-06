package com.wisdomregulation.data.entitydemo;

import com.wisdomregulation.data.entitybase.Base_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个可扩展的类
 */
public class Entity_Demo extends Base_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_Demo(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);

	}
	{
		fieldnamelsitchinese.clear();
	}

	@Override
	protected boolean canaddlist() {
		return true;
	}
}
