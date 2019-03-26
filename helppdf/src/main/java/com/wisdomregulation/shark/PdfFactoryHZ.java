package com.wisdomregulation.shark;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.wisdomregulation.data.entitybase.Base_Entity;
import com.wisdomregulation.pdflink.*;

/**
 * 2017年新文书模板绘制
 * 一页高度大概695按695算 宽度大概409.5左右 一般即78个单字符 39个中文 409.5/10.5=39  所以设置length尽量用5.25的倍数
 * ps:一行的最大长度为79个数字 即414.75个单位 但是因为中文大小的关系 一行只能放39个单位的中文 一般为409.5个单位
 * 页边距 分别为 84 84 72 72 A4纸
 */
public class PdfFactoryHZ extends PdfFactory {

    protected final static PdfFactoryHZ pdfhelp = (PdfFactoryHZ) new PdfFactoryHZ().setPostmark("淮安市洪泽区安全生产监督管理局");

    public static PdfFactoryHZ create() {
        return pdfhelp;
    }

    public  void clear(){
        PdfFactory needclear=getFactory();
        needclear=null;
    }
    @Override
    protected PdfFactory getFactory() {
        return pdfhelp;
    }

    //现场检查方案

    //现场检查记录
    protected void printerEntity_Book_2017_2(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "现场检查记录", "安监检记");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被检查单位", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 351.75f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地址", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 378.0f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("法定代表人（负责人）", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase3.add(new Chunk("职务", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase3.add(new Chunk("联系电话", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("检查场所", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 357.0f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("检查时间", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 57.75f, simfang2312_z5));
                phrase5.add(new Chunk("年", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("月", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("日", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase5.add(new Chunk("时", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("分至", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("月", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase5.add(new Chunk("日", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase5.add(new Chunk("时", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("分", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("我们是", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase6.add(new Chunk("安全生产监督管理局行政执法人员", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push() + book.push(), 140f, simfang2312_z5, 0, -1, 9f));
                phrase6.add(new Chunk("证件号码为", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push() + book.push(), 210f, simfang2312_z5, 0, -1, 3f));
                phrase6.add(new Chunk("，这是我们的证件（出示证件\u00a0）\u00a0。", simfang2312_z5));
                phrase6.add(new Chunk("现依法对你单位进行现场检查，请予以配合。", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.push(), 2688f, simfang2312_z5, 7 * simfang2312_z5.getSize(), -1);
                phrase7.add(new Chunk("检查情况：", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(array[0], 2688f, simfang2312_z5, 7 * simfang2312_z5.getSize(), -1));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                final Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("检查人员（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push() + book.push(), 182f, simfang2312_z5, 0, -1, 3f));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                final Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph16.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(new Chunk("被检查单位现场负责人（签名）：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph16.add(phrase16);
                document.add(paragraph16);
                document.add(space3);
                document.add(space3);
                document.add(space3);
                document.add(space3);
                document.add(space3);
                document.add(space3);
                document.add(space3);
                document.add(space3);
                document.add(space3);
//                printerFrameWorkDate(book);
                printerFrameWorkDate(book.getValue("出表日期"));
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

                String str = array[1];
//                StringBuilder sb = new StringBuilder();
//                for (String s : array) {
//                    sb.append(s);
//                }
                book.put("续页", str);
                if (!book.getValue("续页").equals("")) {
                    printerContinue(book, postmaskimage, new IPdfBackAdapter() {

                        @Override
                        public void writeEnd() {
                            try {
                                document.add(paragraph14);
                                document.add(paragraph16);
                                printerFrameWorkDate(book.getValue("出表日期"));
                            } catch (DocumentException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 11000);
                }
            }
        });

    }

    //现场处理措施决定书
    protected void printerEntity_Book_2017_3(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "现场处理措施决定书", "安监现决");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 231.25f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日现场检查时，发现你单位有下列违法违规行为和事故隐患：", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(0);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("", simfang2312_z5));
                book.push();
//                String chuliyiju="";
//                String chuliyiju2="";

                String faxianyinhuan = "";
                String chulijueding = "";
                String faxianyinhuan2 = "";
                String chulijueding2 = "";
                String chuliyijuorg = book.getValue("处理依据");
                String[] array1 = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("发现隐患"), 1628f, simfang2312_z5, 0, -1);
                String[] array2 = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("处理决定"), 1628f, simfang2312_z5, 0, -1);
                int chuliyijuindextmp = 0;
//                PdfFactoryLog.println("发现隐患1:\n"+array1[0]);
//                PdfFactoryLog.println("************************");
//                PdfFactoryLog.println("处理决定1:\n"+array2[0]);
//                PdfFactoryLog.println("************************");
//                PdfFactoryLog.println("发现隐患放不下1:\n"+array1[1]);
//                PdfFactoryLog.println("************************");
//                PdfFactoryLog.println("处理决定放不下1:\n"+array2[1]);
//                PdfFactoryLog.println("************************");
                if (array1[0].equals("") || array2[0].equals("")) {
                    faxianyinhuan = array1[0];
                    faxianyinhuan2 = array1[1];
                    chulijueding = array2[0];
                    chulijueding2 = array2[1];
//                    chuliyiju="";
//                    chuliyiju2="";
                } else {
                    if (array1[0].split("\n").length >= array2[0].split("\n").length) {
                        chulijueding = array2[0];
                        chulijueding2 = array2[1];
                        String[] tmp1 = array1[0].split("\n");
                        String[] tmp2 = array2[0].split("\n");
//                        String[] tmp3=chuliyijuorg.split(";");
//                        chuliyijuindextmp=tmp2.length;
                        for (int i = 0; i < tmp2.length; i++) {
                            faxianyinhuan += tmp1[i] + "\n";
                        }
                        for (int i = tmp2.length; i < tmp1.length; i++) {
                            faxianyinhuan2 += tmp1[i] + "\n";
                        }
                        faxianyinhuan2 = faxianyinhuan2 + array1[1];
                    } else {
                        faxianyinhuan = array1[0];
                        faxianyinhuan2 = array1[1];
                        String[] tmp1 = array1[0].split("\n");
                        String[] tmp2 = array2[0].split("\n");
//                        chuliyijuindextmp=tmp1.length;
                        for (int i = 0; i < tmp1.length; i++) {
                            chulijueding += tmp2[i] + "\n";
                        }
                        for (int i = tmp1.length; i < tmp2.length; i++) {
                            chulijueding2 += tmp2[i] + "\n";
                        }
                        chulijueding2 = chulijueding2 + array2[1];
                    }
                }
//                String[] tmp3=chuliyijuorg.split(";");
//                for (int i = 0; i < chuliyijuindextmp; i++) {
//                    chuliyiju+=tmp3[i]+";";
//                }
//                for (int i = chuliyijuindextmp; i <tmp3.length ; i++) {
//                    chuliyiju2+=tmp3[i]+";";
//                }

//                PdfFactoryLog.println("发现隐患:\n"+faxianyinhuan);
//                PdfFactoryLog.println("************************");
//                PdfFactoryLog.println("处理决定:\n"+chulijueding);
//                PdfFactoryLog.println("************************");
//                PdfFactoryLog.println("发现隐患放不下:\n"+faxianyinhuan2);
//                PdfFactoryLog.println("************************");
//                PdfFactoryLog.println("处理决定放不下:\n"+chulijueding2);
//                PdfFactoryLog.println("************************");

                phrase3.add(ChunkFactory.underLine(faxianyinhuan, 1628f, simfang2312_z5, 0, -1));
                paragraph3.add(phrase3);
                document.add(paragraph3);
//                Paragraph paragraph3 = new ParagraphBuilder();
//                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("1．", simfang2312_z5));
//                phrase3.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase3.add(new Chunk("；", simfang2312_z5));
//                paragraph3.add(phrase3);
//                document.add(paragraph3);
//                Paragraph paragraph4 = new ParagraphBuilder();
//                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("2．", simfang2312_z5));
//                phrase4.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase4.add(new Chunk("；", simfang2312_z5));
//                paragraph4.add(phrase4);
//                document.add(paragraph4);
//                Paragraph paragraph5 = new ParagraphBuilder();
//                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("3．", simfang2312_z5));
//                phrase5.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
//                phrase5.add(new Chunk("。（此栏不够，可另附页）", simfang2312_z5));
//                paragraph5.add(phrase5);
//                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("以上存在的问题无法保证安全生产，依据", simfang2312_z5));


                book.push();
                phrase6.add(ChunkFactory.underLine(chuliyijuorg, 420f, simfang2312_z5, 20 * simfang2312_z5.getSize(), -1));
                phrase6.add(new Chunk("的规定，现作出如下现场处理决定：", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(0);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("", simfang2312_z5));
                book.push();
                phrase8.add(ChunkFactory.underLine(chulijueding, 1628f, simfang2312_z5, 0, -1));
                paragraph8.add(phrase8);
                document.add(paragraph8);
//                Paragraph paragraph8 = new ParagraphBuilder();
//                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("1．", simfang2312_z5));
//                phrase8.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase8.add(new Chunk("；", simfang2312_z5));
//                paragraph8.add(phrase8);
//                document.add(paragraph8);
//                Paragraph paragraph9 = new ParagraphBuilder();
//                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("2．", simfang2312_z5));
//                phrase9.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase9.add(new Chunk("；", simfang2312_z5));
//                paragraph9.add(phrase9);
//                document.add(paragraph9);
//                Paragraph paragraph10 = new ParagraphBuilder();
//                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("3．", simfang2312_z5));
//                phrase10.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
//                phrase10.add(new Chunk("。（此栏不够，可另附页）", simfang2312_z5));
//                paragraph10.add(phrase10);
//                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase11.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 130.25f, simfang2312_z5));
                phrase11.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase11.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase12.add(new Chunk("证号：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph13.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(ChunkFactory.nounderLine("", "安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase13.add(new Chunk("证号：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph14.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("被检查单位负责人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                printerFrameWorkG1(book);
                // 电子签章
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
                if (!"".equals(chulijueding2) || !"".equals(faxianyinhuan2)) {
                    Base_Entity extra = book.copy();
                    extra.put("发现隐患", faxianyinhuan2);
                    extra.put("处理决定", chulijueding2);
//                    extra.put("处理依据",chuliyiju2);
                    printerEntity_Book_2017_3(extra, postmaskimage);

                }

            }
        });
    }

    //责令限期整改指令书
    protected void printerEntity_Book_2017_4(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "责令限期整改指令书", "安监责改");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 173.25f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("经查，你单位存在下列问题：", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(0);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("", simfang2312_z5));
                book.push();
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("存在问题"), 2438f, simfang2312_z5, 0, -1);
                String findQuestion1 = array[0];
                String findQuestion2 = array[1];
                phrase3.add(ChunkFactory.underLine(findQuestion1, 2438f, simfang2312_z5, 0, -1));
                paragraph3.add(phrase3);
                document.add(paragraph3);
//                Paragraph paragraph3 = new ParagraphBuilder();
//                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("1．", simfang2312_z5));
//                phrase3.add(ChunkFactory.underLine(book.pushloop(), 388.5f, simfang2312_z5));
//                paragraph3.add(phrase3);
//                document.add(paragraph3);
//                Paragraph paragraph4 = new ParagraphBuilder();
//                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("2．", simfang2312_z5));
//                phrase4.add(ChunkFactory.underLine(book.pushloop(), 383.25f, simfang2312_z5));
//                paragraph4.add(phrase4);
//                document.add(paragraph4);
//                Paragraph paragraph5 = new ParagraphBuilder();
//                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("3．", simfang2312_z5));
//                phrase5.add(ChunkFactory.underLine(book.push(), 651f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格3．", simfang2312_z5), -1));
//                phrase5.add(new Chunk("（此栏不够，可另附页）。", simfang2312_z5));
//                paragraph5.add(phrase5);
//                document.add(paragraph5);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("现责令你单位对上述第", simfang2312_z5));
                String[] numberarray = book.push().split(";");
                String timeorg = book.push();
                String[] timearray = timeorg.split(";");
                for (int i = 0; i < numberarray.length; i++) {
                    phrase7.add(new Chunk("第", simfang2312_z5));
                    phrase7.add(ChunkFactory.underLine(numberarray[i], 36.75f, simfang2312_z5));//手动判断第几项 要期限内
                    phrase7.add(new Chunk("项问题于", simfang2312_z5));
                    phrase7.add(ChunkFactory.underLine(timearray[i], 0, 42.0f, simfang2312_z5));
                    phrase7.add(new Chunk("年", simfang2312_z5));
                    phrase7.add(ChunkFactory.underLine(timearray[i], 1, 15.75f, simfang2312_z5));
                    phrase7.add(new Chunk("月", simfang2312_z5));
                    phrase7.add(ChunkFactory.underLine(timearray[i], 2, 15.75f, simfang2312_z5));
                    phrase7.add(new Chunk("日前整改完毕，", simfang2312_z5));
                }

                phrase7.add(new Chunk("达到有关法律法规规章和标准规定的要求。由此造成事故的，依法追究有关人员的责任。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("整改期间，你单位应当采取措施，确保安全生产。对安全生产违法行为，将依法予以行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("如果不服本指令，可以依法在60日内向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 183.75f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格如果不服本指令，可以依法在60日内向人民政府或者", simfang2312_z5) + 57.75f, -1));
                phrase9.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("人民法院提起行政诉讼，但本指令不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);

                document.add(space4);
                document.add(space4);
//                document.add(space4);
//                document.add(space3);


                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase11.add(new Chunk("证号：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", 180f, simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase12.add(new Chunk("证号：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph13.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("被检查单位负责人（签名）：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                printerFrameWorkG1(book);
                // 电子签章
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

                if (!"".equals(findQuestion2)) {

                    Base_Entity extra = book.copy();
                    extra.put("存在问题", findQuestion2);
//                    String str = findQuestion2;
//                    book.put("续页", str);
                    if (book.getExtraObj() != null) {
                        int ex = (Integer) book.getExtraObj();
                        extra.setExtraObj(ex + 1);
                    } else {
                        extra.setExtraObj(1);
                    }
                    printerEntity_Book_2017_4(extra, postmaskimage);
                }

//                if(!"".equals(findQuestion2)){
//                    Base_Entity extra = book.copy();
//                    extra.put("存在问题", findQuestion2);
//                    printerEntity_Book_2017_4(extra, postmaskimage);
//                }
            }
        });

    }

    //整改复查意见书
    protected void printerEntity_Book_2017_5(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                document.add(space2);
                document.add(space2);
                printerFrameWorkTitle(book, "安全生产行政执法文书", "整改复查意见书", "安监复查");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2.5f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 152.25f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2.5f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日作出了", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 211.0f, simfang2312_z5));
                phrase2.add(new Chunk("的决定[(", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), 15.75f, simfang2312_z5));
                phrase2.add(new Chunk(")安监", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("〔", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), 30f, simfang2312_z5));
                phrase2.add(new Chunk("〕(", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), 15.75f, simfang2312_z5));
                phrase2.add(new Chunk(")号],经对你单位整改情况进行复查，提出如下意见：\n", simfang2312_z5));
                book.push();
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("复查意见"), 2040f, simfang2312_z5, 0, -1);
                String suggestion1 = array[0];
                String suggestion2 = array[1];
                phrase2.add(ChunkFactory.underLine(suggestion1, 2040f, simfang2312_z5));
                phrase2.add(new Chunk("。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2.5f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                paragraph9.add(phrase9);
                document.add(paragraph9);
                document.add(space4);
                document.add(space4);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2.5f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("被复查单位负责人（签名）：", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 3f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase11.add(new Chunk("证号：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2.5f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", "安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase12.add(new Chunk("证号：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                document.add(space4);
                printerFrameWorkG1(book);
                // 电子签章
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

                if (!"".equals(suggestion2)) {
                    Base_Entity extra = book.copy();
                    extra.put("复查意见", suggestion2);
                    printerEntity_Book_2017_5(extra, postmaskimage);
                }
            }
        });

    }

    //行政强制审批表

    //查封扣押决定书

    //查封扣押（场所、设施、财物）清单

    //延长查封扣押期限决定书

    //查封扣押处理决定书

    //停止供电（供应民用爆炸物品）通知书

    //停止供电（供应民用爆炸物品）决定书

    //恢复供电（供应民用爆炸物品）通知书

    //询问通知书

    //询问笔录

    //勘验笔录

    //抽样取证凭证

    //先行登记保存证据审批表

    //先行登记保存证据通知书

    //先行登记保存证据处理审批表

    //先行登记保存证据处理决定书

    //鉴定委托书

    //行政处罚告知书


    //行政处罚告知书
    protected void printerEntity_Book_2017_23(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                if(book.getExtraObj()!=null){
                    printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚告知书（单位）", "安监罚告");
                }else{//说明是个人
                    printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚告知书（个人）", "安监罚告");
                }
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("现查明，你（单位）存在下列行为：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 646.75f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格现查明，你（单位）存在下列行为：", simfang2312_z5), -1));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("以上事实主要证据如下：", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 672.75f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格以上事实主要证据如下：", simfang2312_z5), -1));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("以上行为违反了", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 320.25f, simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("的规定，依据", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 351.75f, simfang2312_z5));
                phrase8.add(new Chunk("的规定，拟对你（单位）作出", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 225.75f, simfang2312_z5));
                phrase8.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("如对上述处罚有异议，根据《中华人民共和国行政处罚法》第三十一条和第三十二条的规定，你（单位）有权在收到本告知书之日起3日内向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("安全生产监督管理部门进行陈述和申辩，逾期不提出申请的，视为放弃上述权利。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("安全生产监督管理部门地址：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 225.75f, simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("联系人：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase12.add(new Chunk("联系电话：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase12.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                printerFrameWorkG2(book);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //当事人陈述申辩笔录

    //行政处罚听证告知书

    //行政处罚听证会通知书

    //听证笔录

    //听证会报告书

    //案件处理呈批表

    //行政处罚集体讨论记录

    //行政（当场）处罚决定书（单位）

    //行政（当场）处罚决定书（个人）

    //行政处罚决定书（单位）

    //行政处罚决定书（个人）

    //缴纳罚款催告书

    //加处罚款决定书

    //延期（分期）缴纳罚款审批表

    //延期（分期）缴纳罚款批准书

    //文书送达回执

    //行政强制执行事先催告书

    //强制执行申请书

    //案件移送审批表

    //案件移送书

    //案件延期审批表

    //结案审批表

    //案卷（首页）

    //卷内目录
    protected void printerEntity_Book_2017_46(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                document.add(space1);

                final Paragraph title = new ParagraphBuilder();// Paragraph就是段落
                title.setLeading(1f);// 段落距离
                title.setSpacingBefore(25f);// 段落留白
                title.setAlignment(Element.ALIGN_CENTER);// 居中
                Phrase titlePhrase = new Phrase();
                titlePhrase.add(ChunkFactory.underLine(book.push(), "呼和浩特", simhei_z1));
                titlePhrase.add(new Chunk(getDepartment(), simhei_z1));
                title.add(titlePhrase);
                document.add(title);// 写入文档
                document.add(space2);
                document.add(space1);
                document.add(space2);
                document.add(space2);
                final Paragraph title2 = new ParagraphBuilder("安全生产违法案件", simkai2312_z1);
                title2.setLeading(1f);
                title2.setSpacingBefore(15f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
                document.add(space2);
                document.add(space1);
                document.add(space2);
                document.add(space2);
                final Paragraph title3 = new ParagraphBuilder("案卷（首页）", simkai2312_z1);
                title3.setLeading(1f);
                title3.setSpacingBefore(15f);
                title3.setAlignment(Element.ALIGN_CENTER);
                document.add(title3);
                document.add(space2);
                document.add(space2);
                final Paragraph title4 = new ParagraphBuilder("(   " + book.push() + " )安监案〔  " + book.push() + "〕"
                        + book.push() + "号", simfang2312_z3);
                title4.setLeading(1f);
                title4.setSpacingBefore(25f);
                title4.setAlignment(Element.ALIGN_CENTER);
                document.add(title4);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                final Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setAlignment(Element.ALIGN_LEFT);
//                paragraph1.setFirstLineIndent(2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z3));
                phrase1.add(ChunkFactory.underLine(book.push(), 335, simfang2312_z3,"案件名称：", -1, 9f));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                PdfPTable table = null;
                float[] widths = new float[2];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[0] = 817.0f;
                widths[1] = 8129.0f;
                table = new PdfPTable(2);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("案\n由", simfang2312_z3).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_0.setFixedHeight(107.57576f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z3));
                cell_1.setFixedHeight(107.57576f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("处\n理\n" +
                        "结\n果\n", simfang2312_z3).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_2.setFixedHeight(128.38383f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z3));
                cell_3.setFixedHeight(228.38383f);
                table.addCell(cell_3);
                document.add(table);
                document.add(space1);
                final Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setAlignment(Element.ALIGN_LEFT);
//                paragraph2.setIndentationLeft(24f);
                paragraph2.setLeading(24f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("立案：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 0, 36, simfang2312_z3));
                phrase4.add(new Chunk("年", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 1, 36, simfang2312_z3));
                phrase4.add(new Chunk("月", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(true), 2, 36, simfang2312_z3));
                phrase4.add(new Chunk("日", simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("结案：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 0, 36, simfang2312_z3));
                phrase4.add(new Chunk("年", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 1, 36, simfang2312_z3));
                phrase4.add(new Chunk("月", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(true), 2, 36, simfang2312_z3));
                phrase4.add(new Chunk("日", simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("承办人：", simfang2312_z3));
                phrase4.add(ChunkFactoryNoCenter.underLine(book.push()+book.push(), 300, simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("归档日期：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 0, 36, simfang2312_z3));
                phrase4.add(new Chunk("年", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 1, 36, simfang2312_z3));
                phrase4.add(new Chunk("月", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(true), 2, 36, simfang2312_z3));
                phrase4.add(new Chunk("日", simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("归档号：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(), 84, simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("保存期限：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(), 84, simfang2312_z3));
                paragraph2.add(phrase4);
                document.add(paragraph2);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }


    //先 行 登 记 保 存 证 据 清 单

}
