package com.codefactory.utils;

import com.codefactory.abstracts.ParseBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点帮助类
 * Created by King2016 on 2017/1/17.
 */
public class Util_Node {
    /**
     * 获得原始节点下所有需要遍历的节点下的特性值 例如获得unit下的所有skill节点下的 name 输出用到的skill
     * @param node  原始节点
     * @param nodename 需要遍历的节点名
     * @param valueregex 这些节点名下的对应值
     * @return
     */
    public static List<String> getValuesINNode(ParseBase node,String nodename, String valueregex){
        List<String> skillnames=new ArrayList<String>();
        List<ParseBase> needseenodelist=node.getNodeInThisLevel(nodename);
        for (int i = 0; i <needseenodelist.size() ; i++) {

            skillnames.addAll(needseenodelist.get(i).getPropertyValueInThisLevelNode(valueregex));
        }
        return skillnames;
    }
    public static List<String> getValuesINNodeLowerCase(ParseBase node,String nodename, String valueregex){
        List<String> skillnames=new ArrayList<String>();
        List<ParseBase> needseenodelist=node.getNodeInThisLevel(nodename);
        for (int i = 0; i <needseenodelist.size() ; i++) {

            skillnames.addAll(needseenodelist.get(i).getPropertyValueInThisLevelNodeLowerCase(valueregex));
        }
        return skillnames;
    }

}
