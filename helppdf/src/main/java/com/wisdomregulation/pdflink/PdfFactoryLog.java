package com.wisdomregulation.pdflink;
//打印的适配类
public class PdfFactoryLog {
    public static boolean needlog=false;
    public static void println(Object obj){
        if(needlog){
            System.out.println(obj);
        }

    }
    public static void print(Object obj){
        if(needlog){
            System.out.print(obj);
        }
    }
}
