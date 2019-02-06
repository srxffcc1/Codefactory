package com.test.help;

import com.ay.framework.annotation.ChineseName;
import com.codefactory.intface.CallBack;
import com.codefactory.utils.Util_File;
import com.test.bean.JcjlItem;
import com.test.bean.Jyzaqjhjl;
import com.test.bean.TbXzzfinfo;
import com.test.bean.Wxhxp;
import utils.bean.LineMenu;
import utils.Shop_Detail;
import utils.Shop_List;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JavaBean2Android {
    public static void main(String[] args) {
//        String javaorg = Util_File.inputStream2String("Detail_Activity_Wxhxp.java");
//        String[] javaorgarray = javaorg.split("\n");
//        for (int i = 0; i < javaorgarray.length; i++) {
//            if (javaorgarray[i].trim().equals("") || javaorgarray[i].trim().matches("(.*)TODO(.*)") || javaorgarray[i].trim().matches("(.*)Override(.*)")) {
//
//            } else {
//                System.out.println("+\"" + javaorgarray[i].trim().replace("\"", "\\\"") + "\\n\"");
//            }
//
//        }

        clearFile();
        parse(new JcjlItem());


    }
    public static void parse(Object... objects){
        for (int i = 0; i <objects.length ; i++) {
            Object entityName=objects[i];
            String classname = entityName.getClass().getSimpleName();
            Class c = entityName.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            ChineseName annotationorg = (ChineseName) c.getAnnotation(ChineseName.class);
            String annotationorgstring=annotationorg.value();
            List<LineMenu> lineMenus=new ArrayList<>();
            for (Field f : declaredFields) {
                ChineseName annotation = f.getAnnotation(ChineseName.class);
                if (annotation == null || annotation.equals("") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {
                } else {
                    LineMenu menu=new LineMenu(annotation.value(),f.getName());
                    lineMenus.add(menu);

                }
            }
            if(annotationorgstring.contains("Detail")){
                new Shop_Detail(annotationorgstring).parse(classname,lineMenus);
            }
            if(annotationorgstring.contains("List")){
                new Shop_List(annotationorgstring).parse(classname,lineMenus);
            }
        }
    }


    private static void clearFile() {
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
    }

}
