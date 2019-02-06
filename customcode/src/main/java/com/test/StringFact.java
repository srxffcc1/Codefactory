package com.test;

import com.codefactory.utils.Util_File;
import com.github.promeg.pinyinhelper.Pinyin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFact {
    public static void main(String[] args) {
//        String textcontent= Util_File.inputStream2String("D:\\ApkNeed\\3DM日常2\\Sacrifices\\assets\\data\\I18n\\translations_en.properties");
//        Pattern pattern=Pattern.compile("(.*)=(.*)");
//        Matcher matcher=pattern.matcher(textcontent);
//        while(matcher.find()){
//            System.out.println(matcher.group(2));
//        }
        String gg="E1E2E3E4E5E6";
        StringBuilder sb=new StringBuilder(gg);
        for (int i = 2; i <sb.length() ; i++) {
            sb.insert(i,":");
            i++;
            i++;
        }
        System.out.println(sb.toString());
    }
}
