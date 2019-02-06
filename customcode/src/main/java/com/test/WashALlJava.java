package com.test;

import com.codefactory.intface.CallBack;
import com.codefactory.utils.Util_File;
import utils.Shop_Wash;
import utils.Util_String;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 清洗所有java文件类 private转public 注解干掉 方法干掉 只留变量
 */
public class WashALlJava {
    public static void main(String[] args) {
        Util_File.getFiles("D:\\App\\entity", ".+\\.java", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String fileorg = Util_File.inputStream2String(file);
                fileorg = fileorg.replace("private", "public");
                Pattern pattern = Pattern.compile("@((?!ChineseName).)+");
                Matcher matcher = pattern.matcher(fileorg);
                while (matcher.find()) {
                    ;
                    fileorg = fileorg.replaceFirst(Util_String.washString(matcher.group(0)), "");
                }
                pattern = Pattern.compile("public ((?!class).)+\\{[\\s\\S]*?\\}");
                matcher = pattern.matcher(fileorg);
                while (matcher.find()) {
                    System.out.println(matcher.group(0));
                    fileorg = fileorg.replaceFirst(Util_String.washString(matcher.group(0)), "");
                }
                fileorg= Shop_Wash.washBeanString(fileorg);
                Util_File.string2Stream(fileorg, file.getAbsolutePath());
            }
        });
        System.out.println("end");
    }
}
