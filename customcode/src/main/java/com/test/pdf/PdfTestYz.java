package com.test.pdf;

import com.wisdomregulation.data.entitybase.Base_Entity;
import com.wisdomregulation.data.entitybook2017.*;
import com.wisdomregulation.pdflink.IPdfBack;
import com.wisdomregulation.shark.PdfFactoryYZ;

public class PdfTestYz {
    public static void main(String[] args) {
        print37book2017();
    }

    private static void print37book2017() {
		final Base_Entity bookentity0 = new Entity_Book_2017_0();
		final Base_Entity bookentity1 = new Entity_Book_2017_1();
        final Base_Entity bookentity2 = new Entity_Book_2017_2();
        final Base_Entity bookentity3 = new Entity_Book_2017_3().put("发现隐患","1、测试检查2\n" +
                "2、测试检查3\n3、啊剋").put("处理决定","1、111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
                "2、1111111111111111111111111111111111111111111111111111\n3、阿克苏记得哈");
        final Base_Entity bookentity4 = new Entity_Book_2017_4()
                .put("对第几项进行整改","1-2;2-4")
                .put("整改期限","2018-7-16;2018-7-17")
                ;
        final Base_Entity bookentity5 = new Entity_Book_2017_5().put("复查意见","1、特种人员台账未更新。\n" +
                "     2、特种人员台账未更新。特种人员台账未更新。特种人员台账未更新。特种人员台" +
                "账未更新。\n" +
                "    3、特种人员台账未更新。特种人员台账未更新。特种人员台账未更新。特种人员台" +
                "账未更新。特种人员台账未更新。\n" +
                " 4、特种人员台账未更新。特种人员台账未更新。特种人员台账未更新。\n" +
                "    5、特种人员台账未更新。\n" +
                "   6、安全生产隐患拍照台账未更细。。。。。。。小大家都发搜索时\n" +
                "   7、部分焊接缺少接地保护\n" +
                "   8、流动周缺少鞥说好千瓦色特种人员台账未更新。特种人员台账未更新。特种人员台账未更新。特种人员台账未更新。特种人员台账未更新。特种人员台账未更新。\n"+
                "   7、部分焊接缺少接地保护\n" +
                "   7、部分焊接缺少接地保护\n" +
                "   7、部分焊接缺少接地保护\n");
		final Base_Entity bookentity6 = new Entity_Book_2017_6();
        final Base_Entity bookentity7 = new Entity_Book_2017_7();
        final Base_Entity bookentity8 = new Entity_Book_2017_8();
        final Base_Entity bookentity9 = new Entity_Book_2017_9();
        final Base_Entity bookentity10 = new Entity_Book_2017_10();
        final Base_Entity bookentity11 = new Entity_Book_2017_11();
        final Base_Entity bookentity12 = new Entity_Book_2017_12();
        final Base_Entity bookentity13 = new Entity_Book_2017_13();
        final Base_Entity bookentity14 = new Entity_Book_2017_14();
        final Base_Entity bookentity15 = new Entity_Book_2017_15();
        final Base_Entity bookentity16 = new Entity_Book_2017_16();
        final Base_Entity bookentity17 = new Entity_Book_2017_17();
        final Base_Entity bookentity18 = new Entity_Book_2017_18();
        final Base_Entity bookentity19 = new Entity_Book_2017_19();
        final Base_Entity bookentity20 = new Entity_Book_2017_20();
        final Base_Entity bookentity21 = new Entity_Book_2017_21();
        final Base_Entity bookentity22 = new Entity_Book_2017_22();
        final Base_Entity bookentity23 = new Entity_Book_2017_23();
        final Base_Entity bookentity24 = new Entity_Book_2017_24();
        final Base_Entity bookentity25 = new Entity_Book_2017_25();
        final Base_Entity bookentity26 = new Entity_Book_2017_26();
        final Base_Entity bookentity27 = new Entity_Book_2017_27();
        final Base_Entity bookentity28 = new Entity_Book_2017_28();
        final Base_Entity bookentity29 = new Entity_Book_2017_29();
        final Base_Entity bookentity30 = new Entity_Book_2017_30();
        final Base_Entity bookentity31 = new Entity_Book_2017_31();
//                .put("以上事实违反了什么规定","万物复苏已经了，桃树在蒙蒙细雨中又开始了新的生活。它贪婪地吮吸着春天那清新、甜润的露珠，慢慢地滋长出一条又一条逗人喜爱嫩枝儿，长出一个又一个褐绿色的芽苞儿．吐出一片又一片叶芽儿")
//                .put("依据什么规定","万物复苏已经了，桃树在蒙蒙细雨中又开始了新的生活。它贪婪地吮吸着春天那清新、甜润的露珠，慢慢地滋长出一条又一条逗人喜爱嫩枝儿，长出一个又一个褐绿色的芽苞儿．吐出一片又一片叶芽儿");
        final Base_Entity bookentity32 = new Entity_Book_2017_32();
        final Base_Entity bookentity33 = new Entity_Book_2017_33();
        final Base_Entity bookentity34 = new Entity_Book_2017_34();
        final Base_Entity bookentity35 = new Entity_Book_2017_35();
        final Base_Entity bookentity36 = new Entity_Book_2017_36();
        final Base_Entity bookentity37 = new Entity_Book_2017_37();
        final Base_Entity bookentity38 = new Entity_Book_2017_38();
        final Base_Entity bookentity39 = new Entity_Book_2017_39();
        final Base_Entity bookentity40 = new Entity_Book_2017_40();
        final Base_Entity bookentity41 = new Entity_Book_2017_41();
        final Base_Entity bookentity42 = new Entity_Book_2017_42();
        final Base_Entity bookentity43 = new Entity_Book_2017_43();
        final Base_Entity bookentity44 = new Entity_Book_2017_44();
        final Base_Entity bookentity45 = new Entity_Book_2017_45();
        final Base_Entity bookentity46 = new Entity_Book_2017_46();
        final Base_Entity bookentity47 = new Entity_Book_2017_47();
        final Base_Entity bookentity48 = new Entity_Book_2017_48();
        PdfFactoryYZ.create().setFileout("testYZ.pdf");
        PdfFactoryYZ.create().setTTFpath("/Font");
        PdfFactoryYZ.create().open();
//        PdfFactoryYZ.create().printerMaster(bookentity0);
//        PdfFactoryYZ.create().printerMaster(bookentity1);
//        PdfFactoryYZ.create().printerMaster(bookentity2);
        PdfFactoryYZ.create().printerMaster(bookentity3);
        PdfFactoryYZ.create().printerMaster(bookentity4);
        PdfFactoryYZ.create().printerMaster(bookentity5);
//        PdfFactoryYZ.create().printerMaster(bookentity6);
//        PdfFactoryYZ.create().printerMaster(bookentity7);
//        PdfFactoryYZ.create().printerMaster(bookentity8);
//        PdfFactoryYZ.create().printerMaster(bookentity9);
//        PdfFactoryYZ.create().printerMaster(bookentity10);
//        PdfFactoryYZ.create().printerMaster(bookentity11);
//        PdfFactoryYZ.create().printerMaster(bookentity12);
//        PdfFactoryYZ.create().printerMaster(bookentity13);
//        PdfFactoryYZ.create().printerMaster(bookentity14);
//        PdfFactoryYZ.create().printerMaster(bookentity15);
//        PdfFactoryYZ.create().printerMaster(bookentity16);
//        PdfFactoryYZ.create().printerMaster(bookentity17);
//        PdfFactoryYZ.create().printerMaster(bookentity18);
//        PdfFactoryYZ.create().printerMaster(bookentity19);
//        PdfFactoryYZ.create().printerMaster(bookentity20);
//        PdfFactoryYZ.create().printerMaster(bookentity21);
//        PdfFactoryYZ.create().printerMaster(bookentity22);
//        PdfFactoryYZ.create().printerMaster(bookentity23);
//        PdfFactoryYZ.create().printerMaster(bookentity24);
//        PdfFactoryYZ.create().printerMaster(bookentity25);
//        PdfFactoryYZ.create().printerMaster(bookentity26);
//        PdfFactoryYZ.create().printerMaster(bookentity27);
//        PdfFactoryYZ.create().printerMaster(bookentity28);
//        PdfFactoryYZ.create().printerMaster(bookentity29);
//        PdfFactoryYZ.create().printerMaster(bookentity30);
        PdfFactoryYZ.create().printerMaster(bookentity31);
//        PdfFactoryYZ.create().printerMaster(bookentity32);
//        PdfFactoryYZ.create().printerMaster(bookentity33);
//        PdfFactoryYZ.create().printerMaster(bookentity34);
//        PdfFactoryYZ.create().printerMaster(bookentity35);
//        PdfFactoryYZ.create().printerMaster(bookentity36);
//        PdfFactoryYZ.create().printerMaster(bookentity37);
//        PdfFactoryYZ.create().printerMaster(bookentity38);
//        PdfFactoryYZ.create().printerMaster(bookentity39);
//        PdfFactoryYZ.create().printerMaster(bookentity40);
//        PdfFactoryYZ.create().printerMaster(bookentity41);
//        PdfFactoryYZ.create().printerMaster(bookentity42);
//        PdfFactoryYZ.create().printerMaster(bookentity43);
//        PdfFactoryYZ.create().printerMaster(bookentity44);
//        PdfFactoryYZ.create().printerMaster(bookentity45);
//        PdfFactoryYZ.create().printerMaster(bookentity46);
//        PdfFactoryYZ.create().printerMaster(bookentity47);
//        PdfFactoryYZ.create().printerMaster(bookentity48);
        PdfFactoryYZ.create().closeOnMainThread(new IPdfBack() {
            @Override
            public void writeError() {

            }

            @Override
            public void writeStart() {

            }

            @Override
            public void writeEnd() {
                System.out.println("printerOver");
            }
        });
    }
}
