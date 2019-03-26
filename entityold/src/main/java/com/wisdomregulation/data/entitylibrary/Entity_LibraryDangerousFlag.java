package com.wisdomregulation.data.entitylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

//危险品化学
public class Entity_LibraryDangerousFlag extends DateBase_Entity {
	private  List<String> fieldnamelsitchinese=new ArrayList<String>();
	private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
	public Entity_LibraryDangerousFlag(){
		super.initsuper(fieldnamelsitchinese, fieldvaluemap);
	}
	{
		fieldnamelsitchinese.clear();
		fieldnamelsitchinese.add("化学品中文名");//0
		fieldnamelsitchinese.add("化学品英文名");//1
		fieldnamelsitchinese.add("分子式");//2
		fieldnamelsitchinese.add("分子量");//3
		fieldnamelsitchinese.add("外观与形状");//4
		fieldnamelsitchinese.add("侵入途经");//5
		fieldnamelsitchinese.add("生产企业");//6
		fieldnamelsitchinese.add("健康危害");//7
		fieldnamelsitchinese.add("吸入");//8
		fieldnamelsitchinese.add("食入");//9
		fieldnamelsitchinese.add("皮肤接触");//10
		fieldnamelsitchinese.add("手防护");//11
		fieldnamelsitchinese.add("呼吸系统保护");//12
		fieldnamelsitchinese.add("眼睛接触");//13
		fieldnamelsitchinese.add("眼镜保护");//14
		fieldnamelsitchinese.add("防护服");//15
		fieldnamelsitchinese.add("爆炸下限");//16
		fieldnamelsitchinese.add("燃烧上限");//17
		fieldnamelsitchinese.add("主要用途");//18
		fieldnamelsitchinese.add("工程控制");//19
		fieldnamelsitchinese.add("生产临界量");//20
		fieldnamelsitchinese.add("贮存临界量");//21
		fieldnamelsitchinese.add("接触限值");//22
		fieldnamelsitchinese.add("临界压力");//23
		fieldnamelsitchinese.add("泄漏处置");//24
		fieldnamelsitchinese.add("储运注意事项");//25
		fieldnamelsitchinese.add("少量泄漏隔离半径");//26
		fieldnamelsitchinese.add("大量泄漏隔离半径");//27
		fieldnamelsitchinese.add("少量泄漏白天疏散半径");//28
		fieldnamelsitchinese.add("大量泄漏白天疏散半径");//29
		fieldnamelsitchinese.add("少量泄漏夜间疏散半径");//30
		fieldnamelsitchinese.add("大量泄漏夜间疏散半径");//31
		fieldnamelsitchinese.add("燃烧热");//32
		fieldnamelsitchinese.add("避免接触的条件");//33
		fieldnamelsitchinese.add("稳定性");//34
		fieldnamelsitchinese.add("燃烧性");//35
		fieldnamelsitchinese.add("毒性");//36
		fieldnamelsitchinese.add("溶解性");//37
		fieldnamelsitchinese.add("闪点");//38
		fieldnamelsitchinese.add("熔点");//39
		fieldnamelsitchinese.add("沸点");//40
		fieldnamelsitchinese.add("自燃温度");//41
		fieldnamelsitchinese.add("临界温度");//42
		fieldnamelsitchinese.add("危险特征");//43
		fieldnamelsitchinese.add("危险品类别");//44
		fieldnamelsitchinese.add("危险品货物包装标志");//45
		fieldnamelsitchinese.add("包装类别");//46
		fieldnamelsitchinese.add("燃烧分解产物");//47
		fieldnamelsitchinese.add("灭火方法");//48
		fieldnamelsitchinese.add("禁忌物");//49
		fieldnamelsitchinese.add("聚合危害");//50
		fieldnamelsitchinese.add("IMDG规则页码");//51
		fieldnamelsitchinese.add("监规火险分级");//52
		fieldnamelsitchinese.add("CAS号");//53
		fieldnamelsitchinese.add("RTECS号");//54
		fieldnamelsitchinese.add("UN编号");//55
		fieldnamelsitchinese.add("危险货物编号");//56
		fieldnamelsitchinese.add("相对密度水");//57
		fieldnamelsitchinese.add("相对密度空气");//58
		fieldnamelsitchinese.add("饱和蒸汽水");//59
		fieldnamelsitchinese.add("其他");//60





	}
}
