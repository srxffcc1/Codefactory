package com.codefactory.utils;

import com.codefactory.abstracts.ParseBase;
import utils.Util_String;

import java.util.List;
import java.util.Random;

public class Util_Dat {
	
/**
 * 封装一个设置guid的方法
 * @param orgparent
 * @return
 */
public static ParseBase setRandomuid(ParseBase orgparent){
	orgparent.addProperty("\t<STRING>UNIT_GUID", Util_String.getRandomGuid());
	return orgparent;
}

/**
 * 封装一个设置guid的方法
 * @param orgparent
 * @return
 */
public static ParseBase moveEffectHold(ParseBase orgparent,int holdint){
	List<ParseBase> listeffect=orgparent.getNodeInThisLevel("EFFECT");
	if(listeffect.size()>holdint){
		for (int i = 2; i < listeffect.size(); i++) {
			String hashcode=listeffect.get(i).getHashCode();
			orgparent.removeNode("EFFECT", hashcode);
		}
	}
	
	return orgparent;
}

/**
 * 名字批量生成
 * @param orgparent
 * @param nameorg
 * @param index
 * @return
 */
public static ParseBase setNameArray(ParseBase orgparent,String nameorg,int index){
	index=index+1;
	orgparent.addProperty("\t<STRING>NAME", nameorg+"_"+index);
	return orgparent;
}

/**
 * 设置等级 掉落区间 
 * @param orgparent
 * @param index
 * @return
 */
public static ParseBase setLevel(ParseBase orgparent,int index){
	index=index+1;
	Random random = new Random();
	int indexfinal=index*10;
	int indexfinal1=index*10-5;
	int indexfinal2=index*10+10+1;
	orgparent.addProperty("\t<INTEGER>LEVEL", ""+(indexfinal+(-random.nextInt(6)+3)));
	orgparent.addProperty("\t<INTEGER>MINLEVEL", ""+(indexfinal1+(-random.nextInt(6)+3)));
	orgparent.addProperty("\t<INTEGER>MAXLEVEL", ""+(indexfinal2+(-random.nextInt(6)+3)));
	return orgparent;
}

/**
 * 随机4+1种基础属性
 * @param orgparent
 * @param index
 * @return
 */
public static ParseBase setRandomEffectBase(ParseBase orgparent){
	Random random=new Random();
	orgparent.addProperty("\t<INTEGER>DAMAGE_PHYSICAL", ""+(random.nextInt(23)));
	orgparent.addProperty("\t<INTEGER>DAMAGE_ELECTRIC", ""+(random.nextInt(30)));
	orgparent.addProperty("\t<INTEGER>DAMAGE_POISON", ""+(random.nextInt(30)));
	orgparent.addProperty("\t<INTEGER>DAMAGE_ICE", ""+(random.nextInt(30)));
	orgparent.addProperty("\t<INTEGER>DAMAGE_FIRE", ""+(random.nextInt(30)));
	return orgparent;
}


/**
 * 随机属性需求
 * @param orgparent
 * @param index
 * @return
 */
public static ParseBase setRandomRequire(ParseBase orgparent){
	Random random=new Random();
	orgparent.addProperty("\t<INTEGER>STRENGTH_REQUIRED", ""+(random.nextInt(50)+1));
	orgparent.addProperty("\t<INTEGER>MAGIC_REQUIRED", ""+(random.nextInt(50)+1));
	orgparent.addProperty("\t<INTEGER>DEFENSE_REQUIRED", ""+(random.nextInt(50)+1));
	orgparent.addProperty("\t<INTEGER>DEXTERITY_REQUIRED", ""+(random.nextInt(50)+1));
	return orgparent;
}


/**
 * 随机稀有度
 * @param orgparent
 * @param index
 * @return
 */
public static ParseBase setRandomRarity(ParseBase orgparent){
	Random random=new Random();
	orgparent.addProperty("\t<INTEGER>RARITY", ""+(random.nextInt(100)+10));
	return orgparent;
}
}
