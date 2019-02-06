package com.test;

import com.codefactory.intface.CallBack;
import com.codefactory.utils.Util_File;
import utils.Util_String;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldNumber {
    private static List<String> fieldnamelsitchinese = new ArrayList<String>();

    public static void main(String[] args) {
        Util_File.getFiles("D:\\App\\Tmp", "", new CallBack() {
            @Override
            public void back(Object... object) {
                File file= (File) object[0];
                System.out.println(file.getName());
                String filecontent= Util_File.inputStream2String(file);
                Pattern p = Pattern.compile("fieldnamelsitchinese.add\\((.*)\\);");
                Matcher m=p.matcher(filecontent);
                int index=0;
                while (m.find()){
                    String tmpstring=m.group();
                    filecontent=filecontent.replaceFirst(Util_String.washString(tmpstring),tmpstring+"//"+index);
                    index++;
                }
                Util_File.string2Stream(filecontent,file.getAbsolutePath());
            }
        });
    }

    private static void dep() {
        fieldnamelsitchinese.add("安监管罚当");//0
        fieldnamelsitchinese.add("字");//1
        fieldnamelsitchinese.add("号");//2
        fieldnamelsitchinese.add("被处罚单位");//3
        fieldnamelsitchinese.add("被处罚单位地址");//4
        fieldnamelsitchinese.add("被处罚单位邮编");//5
        fieldnamelsitchinese.add("被处罚单位法定代表人");//6
        fieldnamelsitchinese.add("被处罚单位法定代表人职务");//7
        fieldnamelsitchinese.add("被处罚单位法定代表人联系电话");//8
        fieldnamelsitchinese.add("违法事实及依据");//9
        fieldnamelsitchinese.add("以上事实违反了什么规定");//10
        fieldnamelsitchinese.add("依据什么规定作出行政处罚");//11
        fieldnamelsitchinese.add("作出什么行政处罚");//12
        fieldnamelsitchinese.add("check当场缴纳,自决定15内缴纳");//13
        fieldnamelsitchinese.add("十五日内缴纳地点");//15
        fieldnamelsitchinese.add("十五日内缴纳缴纳账号");//16
        fieldnamelsitchinese.add("不服决定可在60日内申诉的人民政府");//17
        fieldnamelsitchinese.add("不服决定可在60日内申诉的部门");//18
        fieldnamelsitchinese.add("不服决定可在3个月内进行行政诉讼的人民法院");//19
        fieldnamelsitchinese.add("执法人员1签名");//20
        fieldnamelsitchinese.add("执法人员2签名");//21
        fieldnamelsitchinese.add("当事人或委托代理人签名");//22
        fieldnamelsitchinese.add("出表日期");//23

        for (int i = 0; i < fieldnamelsitchinese.size(); i++) {
            System.out.println("fieldnamelsitchinese.add(\"" + fieldnamelsitchinese.get(i) + "\");//" + i + "");
        }
    }
}
