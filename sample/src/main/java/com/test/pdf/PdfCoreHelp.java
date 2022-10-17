package com.test.pdf;


        import utils.Util_Pdf;

public class PdfCoreHelp {
    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }
    public static void test1(){//对于没有表格的doc
        Util_Pdf.word2pdfall("D:\\App\\Codefactory\\2017doc\\2016年执法文件式样_7.doc",12);
    }
    public static void test2(){//对于有表格的就需要两个都使用
        Util_Pdf.word2pdfall("D:\\App\\Codefactory\\2017doc\\2016年执法文件式样_3.doc",12);
//        Util_Pdf.word2pdftablecode("D:\\App\\Codefactory\\2017doc\\2016年执法文件式样_3.doc");
    }

}
