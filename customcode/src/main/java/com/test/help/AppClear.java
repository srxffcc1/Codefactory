package com.test.help;

import com.codefactory.intface.CallBack;
import com.codefactory.utils.Util_File;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppClear {
    public static boolean needdelete=true;
    public static void main(String[] args) {
        String apppath="D:\\AppAy3.0\\Aynj\\jianyeyidongzhifa_feidisanfang_j";
        deleteLayout(apppath);
        deletePng(apppath);
//        String sss=Util_File.inputStream2String("D:\\AppAy3.0\\AyJn\\app\\src\\main\\java\\com\\android\\yidongzhifa\\activity\\AnjianxinxiFenleiActivity.java");
//        Pattern pattern=Pattern.compile(".*R\\.drawable\\.(.*?)[\\)|,|;|\\}]");
//        Matcher matcher=pattern.matcher(sss);
//        while (matcher.find()){
//            String resultlayout=matcher.group(1);
//            System.out.println(resultlayout);
//        }
    }

    private static void deleteLayout(String mainpath) {
        String javapath=mainpath+"\\src\\main";
        String layoutpath=mainpath+"\\src\\main\\res\\layout";
        final Map<String,Boolean> javalauout=new HashMap<>();//保存在JAVA中引用过的layout
        Util_File.getFiles(javapath, ".*\\.java", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String filecontent=Util_File.inputStream2String(file);
//                String filecontent="R.layout.simple_list_item_1, new String[]{\"name\"}";
                Pattern pattern=Pattern.compile("R\\.layout\\.(.*?)[\\)|,]");
                Matcher matcher=pattern.matcher(filecontent);
                while (matcher.find()){
                    String resultlayout=matcher.group(1).split(",")[0].trim();
                    javalauout.put(resultlayout,true);
                }
            }
        });
//        List<String> allneedlayout=new ArrayList<>();
//        Iterator<Map.Entry<String,Boolean>> entries = javalauout.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<String,Boolean> entry = entries.next();
//            allneedlayout.add(entry.getKey());
//        }
        Map<String,Boolean> tmplist=getAllXml(layoutpath, javalauout);
        while (tmplist.size()>0){
            javalauout.putAll(tmplist);
            tmplist=getAllXml(layoutpath, javalauout);
        }


        Util_File.getFiles(layoutpath, ".*\\.xml", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String filename=file.getName().split("\\.")[0];
                if(javalauout.get(filename)==null||!javalauout.get(filename)){
                    System.err.println("删除的xml文件:"+file.getAbsolutePath());
                    if(needdelete){
                        file.delete();
                    }
                }
            }
        });

        System.out.println("layout清理完毕");
    }

    private static Map<String,Boolean>  getAllXml(String layoutpath, Map<String,Boolean> allneedlayout) {
        Map<String,Boolean> result=new HashMap<>();
        Iterator<Map.Entry<String,Boolean>> entries = allneedlayout.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String,Boolean> entry = entries.next();
            if(new File(layoutpath+"\\"+entry.getKey()+".xml").exists()){
                String xmlcontent= Util_File.inputStream2String(layoutpath+"\\"+entry.getKey()+".xml");
                if(xmlcontent.contains("@id")){
//                    System.err.println("可能出现的坑："+entry.getKey());
                }
                Pattern pattern=Pattern.compile("\\\".*@layout/(.*).*?\\\"");
                Matcher matcher=pattern.matcher(xmlcontent);
                while (matcher.find()){
//                    System.out.println(matcher.group(1));
                    if(allneedlayout.get(matcher.group(1).trim())==null||!allneedlayout.get(matcher.group(1).trim())){
//                        System.out.println("补充:"+matcher.group(1).trim());
                        result.put(matcher.group(1).trim(),true);
                    }
                }
            }
        }
        return result;
    }

    private static void deletePng(String mainpath) {

        String javapath=mainpath+"\\src\\main";
        String pngpath=mainpath+"\\src\\main\\res";
        final Map<String,Boolean> pnglauout=new HashMap<>();//保存中间有引用过layout的;
        Util_File.getFiles(javapath, ".*\\.xml", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String filecontent=Util_File.inputStream2String(file);
                Pattern pattern=Pattern.compile("@.*drawable/(.*?)\\\"");
                Matcher matcher=pattern.matcher(filecontent);
                while (matcher.find()){
                    String resultlayout=matcher.group(1).split("\"")[0].trim();
//                    System.out.println("存在的图片:"+resultlayout);
                    pnglauout.put(resultlayout,true);
                }
            }
        });
        Util_File.getFiles(javapath, ".*\\.java", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String filecontent=Util_File.inputStream2String(file);
                Pattern pattern=Pattern.compile(".*R\\.drawable\\.(.*?)[\\)|,|;|\\}]");
                Matcher matcher=pattern.matcher(filecontent);
                while (matcher.find()){
                    String resultlayout=matcher.group(1).split("\\)|,|;|\\}")[0].trim();
//                    System.out.println("存在的图片:"+resultlayout);
                    pnglauout.put(resultlayout,true);
                }
            }
        });
        Util_File.getFiles(pngpath, ".*\\.png|jpg|jpeg", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String filename=file.getName().split("\\.")[0];
                if(pnglauout.get(filename)==null||!pnglauout.get(filename)){
                    System.err.println("删除的图片文件:"+file.getAbsolutePath());
                    if(needdelete){
                        file.delete();
                    }
                }else {
//                    System.out.println("检索图片文件:"+file.getAbsolutePath());
                }
            }
        });

        System.out.println("图片清理完毕");
    }
}
