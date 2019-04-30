package com.test.help;

import com.ay.framework.annotation.ChineseName;
import com.codefactory.abstracts.ParseBase;
import com.codefactory.intface.CallBack;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import com.test.bean.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Java2Xml {


    public static void main(String[] args) {
//        System.out.println("31b1d73191d49f3f1258bf4859b3266f0ec010149cef43110bd9".length());
        java2xmlfc();
//        java2textbind();
//        java2mapget();
//        java2textbind2();
//        java2listener();
//        java2book();

    }

    public static void java2book(){
        List<Object> objlist=new ArrayList<>();
        objlist.add(new Xcjcws());
        objlist.add(new Xcclws());
        objlist.add(new Zgfcws());
        objlist.add(new Zlzgws());
        for (int i = 0; i <objlist.size() ; i++) {
            Object entityName=objlist.get(i);
            String classname = entityName.getClass().getSimpleName();

            List<String> fieldlist = new ArrayList<String>();
            List<String> chinesenamelist = new ArrayList<String>();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();

//            System.out.println("result.put(\""+classname.toLowerCase()+".id\",id);");
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if (annotation == null || annotation.equals("") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {
                } else {
                    fieldlist.add(f.getName());
                    chinesenamelist.add(annotation.value().toString());
//                    System.out.println("result.put(\""+classname.toLowerCase()+"."+f.getName()+"\", "+f.getName()+".getText().toString());");
                    System.out.println("bookentity.pull("+f.getName()+".getText().toString());");
                }
            }
            System.out.println("-----------"+classname+"------------");
        }
    }
    public static void java2mapget(){
        List<Object> objlist=new ArrayList<>();
        objlist.add(new Xcjcws());
        objlist.add(new Xcclws());
        objlist.add(new Zgfcws());
        objlist.add(new Zlzgws());
        for (int i = 0; i <objlist.size() ; i++) {
            Object entityName=objlist.get(i);
            String classname = entityName.getClass().getSimpleName();

            List<String> fieldlist = new ArrayList<String>();
            List<String> chinesenamelist = new ArrayList<String>();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();

            System.out.println("result.put(\""+classname.toLowerCase()+".id\",id);");
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if (annotation == null || annotation.equals("") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {
                } else {
                    fieldlist.add(f.getName());
                    chinesenamelist.add(annotation.value().toString());
                    System.out.println("result.put(\""+classname.toLowerCase()+"."+f.getName()+"\", "+f.getName()+".getText().toString());");
                }
            }
            System.out.println("-----------"+classname+"------------");
        }
    }
    public static void java2listener(){
        List<Object> objlist=new ArrayList<>();
        objlist.add(new Xcjcws());
        objlist.add(new Xcclws());
        objlist.add(new Zgfcws());
        objlist.add(new Zlzgws());
        for (int i = 0; i <objlist.size() ; i++) {
            Object entityName=objlist.get(i);
            String classname = entityName.getClass().getSimpleName();

            List<String> fieldlist = new ArrayList<String>();
            List<String> chinesenamelist = new ArrayList<String>();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if(annotation.value().contains("时间")||annotation.value().contains("日期")){
                    fieldlist.add(f.getName());
                    chinesenamelist.add(annotation.value().toString());
                    System.out.println(""+f.getName()+".setOnClickListener(new TimeClickListener("+f.getName()+"));");
                }

            }
            System.out.println("-----------"+classname+"------------");
        }
    }
    public static void java2textbind2(){
        List<Object> objlist=new ArrayList<>();
        objlist.add(new Xcjcws());
        objlist.add(new Xcclws());
        objlist.add(new Zgfcws());
        objlist.add(new Zlzgws());
        for (int i = 0; i <objlist.size() ; i++) {
            Object entityName=objlist.get(i);
            String classname = entityName.getClass().getSimpleName();

            List<String> fieldlist = new ArrayList<String>();
            List<String> chinesenamelist = new ArrayList<String>();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if (annotation == null || annotation.equals("") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {
                } else {
                    fieldlist.add(f.getName());
                    chinesenamelist.add(annotation.value().toString());
                    System.out.println(f.getName()+".setText(jcjlbean."+f.getName()+");");
                }
            }
            System.out.println("-----------"+classname+"------------");
        }
    }
    public static void java2textbind(){
        List<Object> objlist=new ArrayList<>();
        objlist.add(new Xcjcws());
        objlist.add(new Xcclws());
        objlist.add(new Zgfcws());
        objlist.add(new Zlzgws());
        for (int i = 0; i <objlist.size() ; i++) {
            Object entityName=objlist.get(i);
            String classname = entityName.getClass().getSimpleName();

            List<String> fieldlist = new ArrayList<String>();
            List<String> chinesenamelist = new ArrayList<String>();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if (annotation == null || annotation.equals("") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {
                } else {
                    fieldlist.add(f.getName());
                    chinesenamelist.add(annotation.value().toString());
                    System.out.println(f.getName()+".setText(wenshuwebbean."+f.getName()+");");
                }
            }
            System.out.println("-----------"+classname+"------------");
        }
    }

    private static void java2xmlfc() {
        Util_File.getFiles("apps/", "", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                if (file.getName().contains("xml") || file.getName().contains("java")) {
                    System.out.println("清理:" + file.getName());
                    file.delete();
                }
            }
        });
        List<Object> objlist=new ArrayList<>();

        objlist.add(new Wxhxp());
//        objlist.add(new Xcjcws());
//        objlist.add(new Zgfcws());
//        objlist.add(new Zlzgws());
        for (int i = 0; i <objlist.size() ; i++) {
            Object entityName=objlist.get(i);
            String classname = entityName.getClass().getSimpleName();
            ParseBase layoutxml = new XmlNode().build().parse(Util_File.inputStream2String("D:\\AppAy3.0\\Pdf\\templete\\templete_layout.xml"));
            ParseBase cellline = new XmlNode().build().parse(Util_File.inputStream2String("D:\\AppAy3.0\\Pdf\\templete\\templete_line.xml"));
            List<String> fieldlist = new ArrayList<String>();
            List<String> chinesenamelist = new ArrayList<String>();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if (annotation == null || annotation.equals("") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {
                } else {
                    String fieldname= f.getName();
                    String annotationstring=annotation.value().toString();
                    String firstannotionstring=annotationstring.split(";")[0];
                    ParseBase cellfindtextview=cellline.findNodeByProperty("android:id=\"@\\+id/linetext\"").copy();
                    ParseBase cellfindview=cellline.findNodeByProperty("android:id=\"@\\+id/lineview\"").copy();
                    ParseBase cellfindedit=cellline.findNodeByProperty("android:id=\"@\\+id/lineeditext\"").copy();
                    ParseBase cellfindspinner=cellline.findNodeByProperty("android:id=\"@\\+id/linespinner\"").copy();
                    if(annotationstring.contains("Spinner")){
                        ParseBase text=cellfindspinner.findNodeByProperty("android:id=\"@\\+id/text\"");
                        ParseBase value=cellfindspinner.findNodeByProperty("android:id=\"@\\+id/value\"");

                        cellfindspinner.addProperty("android:id","@+id/linespinner_"+ fieldname +"");
                        cellfindview.addProperty("android:id","@+id/lineview_"+fieldname+"");
                        text.addProperty("android:id","@+id/"+fieldname+"_text");
                        text.addProperty("android:text",firstannotionstring+":");
                        value.addProperty("android:id","@+id/"+fieldname);
                        layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/sublayout\"",cellfindspinner,cellfindview);
                    } else if(annotationstring.contains("TextView")){

                    }else{
                        ParseBase text=cellfindedit.findNodeByProperty("android:id=\"@\\+id/text\"");
                        ParseBase value=cellfindedit.findNodeByProperty("android:id=\"@\\+id/value\"");

                        cellfindedit.addProperty("android:id","@+id/lineeditext_"+ fieldname +"");
                        cellfindview.addProperty("android:id","@+id/lineview_"+fieldname+"");
                        text.addProperty("android:id","@+id/"+fieldname+"_text");
                        text.addProperty("android:text",firstannotionstring+":");
                        value.addProperty("android:id","@+id/"+fieldname);
                        if(firstannotionstring.contains("时间")||firstannotionstring.contains("日期")){
                            value.addProperty("android:focusable","false");
                        }
                        layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/sublayout\"",cellfindedit,cellfindview);
                    }

                    fieldlist.add(fieldname);
                    chinesenamelist.add(firstannotionstring);
                }
            }
            Util_File.string2Stream(layoutxml.getEntityString(), "apps/res/layout/detail_activity_" + classname.toLowerCase() + ".xml");
        }
    }
}
