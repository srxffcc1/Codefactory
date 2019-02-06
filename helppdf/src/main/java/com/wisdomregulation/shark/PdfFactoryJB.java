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
public class PdfFactoryJB extends PdfFactoryYZ {
    protected final static PdfFactoryJB pdfhelp = (PdfFactoryJB) new PdfFactoryJB().setPageSize(84f, 84f, 26f, 46f);

    public static PdfFactoryJB create() {
        return pdfhelp;
    }

    @Override
    protected PdfFactory getFactory() {
        return pdfhelp;
    }

    /**
     * 年    月    日
     * -----------------------------------------------------------
     * 共   页   第  页
     * <p>
     * //     * @param book
     */
    //立案审批表
    protected void printerEntity_Book_2017_0(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "立案审批表", "安监立");
               //document.add(space3);
                //document.add(space2);
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.8f);
                //paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案由", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 400.5f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1.5f);
                //paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("案件来源", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 288.5f, simfang2312_z5));
                phrase2.add(new Chunk("时间", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 86.0f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 1.5f);
                //paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("案件名称", simfang2312_z5));

                String ajmc = book.push();
                int i = ajmc.length();
                if (i <= 36) {
                    phrase3.add(ChunkFactory.underLine(ajmc, 385.5f, simfang2312_z5));
                } else {
                    phrase3.add(ChunkFactory.underLine(ajmc, 788.5f, simfang2312_z5,"哈哈哈", -1));
                }

                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 1.5f);
                //paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("当事人", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 308.5f, simfang2312_z5));
                phrase4.add(new Chunk("电话", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 75.0f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 1.5f);
                //paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("法定代表人/负责人", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 338.25f, simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 1.5f);
                //paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("当事人地址", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 295.0f, simfang2312_z5));
                phrase6.add(new Chunk("邮政编码", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 43.0f, simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                //document.add(space3);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[2];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[0] = 4248.0f;
                widths[1] = 4248.0f;
                table = new PdfPTable(2);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("案件基本情况：", simfang2312_z5));
                phrase7.add(ChunkFactory.tablenounderLine(book.push(), 4107.75f, simfang2312_z5, "案件基本情况：", "案件基本情况：妈妈经常批评我做事不讲效率但我却是“意见接受行动照旧”。所以总不"));
                paragraph7.add(phrase7);
                PdfPCell cell_0 = new PdfPCellBuilder();
                cell_0.addElement(paragraph7);
                cell_0.setColspan(2);
                cell_0.setFixedHeight(167.27273f);
                table.addCell(cell_0);

                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("承办人意见：", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.push(), 4440.75f, simfang2312_z5,"承办人意见：",-1));
                paragraph10.add(phrase10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase11.add(new Chunk("证号：\u00a0", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase11.add(new Chunk("\u00a0", simfang2312_z5));
                paragraph11.add(phrase11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", "承办人（签名）：", simfang2312_z5));
//                phrase12.add(new Chunk("\u00a0",simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase12.add(new Chunk("\u00a0", simfang2312_z5));
                phrase12.add(new Chunk("证号：\u00a0", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine("", 47.5f, simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase12.add(new Chunk("年", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase12.add(new Chunk("月", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase12.add(new Chunk("日", simfang2312_z5));
                paragraph12.add(phrase12);
                PdfPCell cell_1 = new PdfPCellBuilder();
                cell_1.addElement(paragraph10);
                cell_1.addElement(paragraph11);
                cell_1.addElement(paragraph12);
                cell_1.setColspan(2);
                cell_1.setFixedHeight(218.43434f);
                table.addCell(cell_1);

                Paragraph paragraph10_JBADD = new ParagraphBuilder();
                paragraph10_JBADD.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase10_JBADD = new Phrase();
                phrase10_JBADD.add(new Chunk("部门负责人意见：", simfang2312_z5));
                phrase10_JBADD.add(ChunkFactory.tablenounderLine(book.push(), 750f, simfang2312_z5,"部门负责人意见：","部门负责人意见：妈妈经常批评我做事不讲效率但我却是妈妈经常批评我做事不讲效率但我"));
                paragraph10_JBADD.add(phrase10_JBADD);
                Paragraph paragraph11_JBADD = new ParagraphBuilder();
                paragraph11_JBADD.setLeading(simfang2312_z5.getSize() * 2f);
                Paragraph paragraph12_JBADD = new ParagraphBuilder();
                paragraph12_JBADD.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase12_JBADD = new Phrase();
                phrase12_JBADD.add(new Chunk("负责人（签名）：", simfang2312_z5));
//                phrase12_JBADD.add(new Chunk("\u00a0",simfang2312_z5));
                phrase12_JBADD.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase12_JBADD.add(new Chunk("\u00a0", simfang2312_z5));
                phrase12_JBADD.add(ChunkFactory.nounderLine("", 135.5f, simfang2312_z5));
                phrase12_JBADD.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase12_JBADD.add(new Chunk("年", simfang2312_z5));
                phrase12_JBADD.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase12_JBADD.add(new Chunk("月", simfang2312_z5));
                phrase12_JBADD.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase12_JBADD.add(new Chunk("日", simfang2312_z5));
                paragraph12_JBADD.add(phrase12_JBADD);
                PdfPCell cell_JBADD_JBADD = new PdfPCellBuilder();
                cell_JBADD_JBADD.addElement(paragraph10_JBADD);
                cell_JBADD_JBADD.addElement(paragraph11_JBADD);
                cell_JBADD_JBADD.addElement(paragraph12_JBADD);
                cell_JBADD_JBADD.setColspan(2);
                cell_JBADD_JBADD.setFixedHeight(70.43434f);
                table.addCell(cell_JBADD_JBADD);


                Paragraph paragraph13 = new ParagraphBuilder();
//                paragraph13.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("审核意见：", simfang2312_z5));
                phrase13.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*30, simfang2312_z5, "审核意见：", "审核意见：妈妈经常批评我做事不讲效率但"));
                paragraph13.add(phrase13);
                Paragraph paragraph15 = new ParagraphBuilder();
//                paragraph15.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.push(), 110.25f, simfang2312_z5));
                paragraph15.add(phrase15);
                Paragraph paragraph16 = new ParagraphBuilder();
//                paragraph16.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(ChunkFactory.nounderLine("", 80.25f, simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase16.add(new Chunk("年", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("月", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("日", simfang2312_z5));
                paragraph16.add(phrase16);
                PdfPCell cell_2 = new PdfPCellBuilder();
                cell_2.addElement(paragraph13);
//                cell_2.addElement(paragraph14);
                cell_2.addElement(paragraph15);
                cell_2.addElement(paragraph16);
                cell_2.setFixedHeight(74.89899f);
                table.addCell(cell_2);
                Paragraph paragraph17 = new ParagraphBuilder();
//                paragraph17.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase17 = new Phrase();
                phrase17.add(new Chunk("审批意见：", simfang2312_z5));
                phrase17.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*30, simfang2312_z5, "审批意见：", "审核意见：妈妈经常批评我做事不讲效率但"));
                paragraph17.add(phrase17);
                Paragraph paragraph19 = new ParagraphBuilder();
//                paragraph19.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase19 = new Phrase();
                phrase19.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase19.add(ChunkFactory.tablenounderLine(book.push(), 105.0f, simfang2312_z5));
                paragraph19.add(phrase19);
                Paragraph paragraph20 = new ParagraphBuilder();
//                paragraph20.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase20 = new Phrase();
                phrase20.add(ChunkFactory.nounderLine("", 80.25f, simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase20.add(new Chunk("年", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("月", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("日", simfang2312_z5));
                paragraph20.add(phrase20);
                PdfPCell cell_3 = new PdfPCellBuilder();
                cell_3.addElement(paragraph17);
//                cell_3.addElement(paragraph18);
                cell_3.addElement(paragraph19);
                cell_3.addElement(paragraph20);
                cell_3.setFixedHeight(74.89899f);
                table.addCell(cell_3);



                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //案件处理呈批表
    protected void printerEntity_Book_2017_29(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "案件处理呈批表", "安监处呈");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));

                String ajmc = book.push();
                int i = ajmc.length();
                if (i <= 35) {
                    phrase1.add(ChunkFactory.underLine(ajmc, 370.25f, simfang2312_z5));
                } else {
                    phrase1.add(ChunkFactory.underLine(ajmc, 780.5f, simfang2312_z5,"哈哈哈哈", -1));
                }

                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[9];

//                widths[0] = 42f;
//                widths[1] = 114f;
//                widths[2] = 90f;
//                widths[3] = 23f;
//                widths[4] = 23f;
//                widths[5] = 46f;
//                widths[6] = 76f;
//                widths[7] = 42f;
//                widths[8] = 65f;

                widths[0] = 35f;  // 当事人基本情况
                widths[1] = 40f;
                widths[2] = 165f;
                widths[3] = 13f;
                widths[4] = 13f;
                widths[5] = 20f;  // 地址、职务、年龄、单位地址、联系电话
                widths[6] = 102f;
                widths[7] = 32f;
                widths[8] = 50f;
                table = new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事人基本情况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setRowspan(5);
                cell_0.setFixedHeight(28f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("被处罚单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(28f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_2.setColspan(2);
                cell_2.setFixedHeight(28f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setColspan(2);
                cell_3.setFixedHeight(28f);
                table.addCell(cell_3);

                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_4.setColspan(3);
                cell_4.setFixedHeight(28f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("法定代表人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(28f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_6.setColspan(2);
                cell_6.setFixedHeight(28f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("职务", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setColspan(2);
                cell_7.setFixedHeight(28f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_8.setFixedHeight(28f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_9.setFixedHeight(28f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_10.setFixedHeight(28f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_11.setFixedHeight(28f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_12.setColspan(2);
                cell_12.setFixedHeight(28f);
                table.addCell(cell_12);
                PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder("年龄", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_13.setColspan(2);
                cell_13.setFixedHeight(28f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_14.setFixedHeight(28f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder("性别", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_15.setFixedHeight(28f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_16.setFixedHeight(28f);
                table.addCell(cell_16);
                PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder("所在单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_17.setFixedHeight(28f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_18.setColspan(2);
                cell_18.setFixedHeight(28f);
                table.addCell(cell_18);
                PdfPCell cell_19 = new PdfPCellBuilder(new ParagraphBuilder("单位地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_19.setColspan(2);
                cell_19.setFixedHeight(28f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_20.setColspan(3);
                cell_20.setFixedHeight(28f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new ParagraphBuilder("家庭住址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_21.setFixedHeight(28f);
                table.addCell(cell_21);
                PdfPCell cell_22 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_22.setColspan(2);
                cell_22.setFixedHeight(28f);
                table.addCell(cell_22);
                PdfPCell cell_23 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_23.setColspan(2);
                cell_23.setFixedHeight(28f);
                table.addCell(cell_23);
                PdfPCell cell_24 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_24.setFixedHeight(28f);
                table.addCell(cell_24);
                PdfPCell cell_25 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_25.setFixedHeight(28f);
                table.addCell(cell_25);
                PdfPCell cell_26 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_26.setFixedHeight(28f);
                table.addCell(cell_26);
                PdfPCell cell_27 = new PdfPCellBuilder(new ParagraphBuilder("违法事实及处罚依据", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_27.setFixedHeight(134.19192f);
                table.addCell(cell_27);
                PdfPCell cell_28 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_28.setColspan(8);
                cell_28.setFixedHeight(64.19192f);
                table.addCell(cell_28);
                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("当事人的申辩意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_29.setFixedHeight(103.383835f);
                table.addCell(cell_29);
                PdfPCell cell_30 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_30.setColspan(8);
                cell_30.setFixedHeight(63.383835f);
                table.addCell(cell_30);

                PdfPCell cell_31 = new PdfPCellBuilder(new ParagraphBuilder("承办人意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31.setFixedHeight(120.83839f);
                table.addCell(cell_31);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), 3400f, simfang2312_z5, "", "                                                                        "));
                paragraph2.add(phrase2);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine("", "   ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, "      ", simfang2312_z5));
                phrase4.add(new Chunk("年", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, "      ", simfang2312_z5));
                phrase4.add(new Chunk("月", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.push(true), 2, "      ", simfang2312_z5));
                phrase4.add(new Chunk("日", simfang2312_z5));
                paragraph4.add(phrase4);
//                document.add(paragraph4);
                PdfPCell cell_32 = new PdfPCellBuilder();
                cell_32.addElement(paragraph2);
                cell_32.addElement(paragraph4);
                cell_32.setColspan(8);
                cell_32.setFixedHeight(73.83839f);
                table.addCell(cell_32);



                PdfPCell cell_31_JBADD = new PdfPCellBuilder(new ParagraphBuilder("部门负责人意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31_JBADD.setFixedHeight(60.83839f);
                table.addCell(cell_31_JBADD);
                Paragraph paragraph2_JBADD = new ParagraphBuilder();
                paragraph2_JBADD.setLeading(simfang2312_z5.getSize() * 1f);
//                paragraph2_JBADD.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2_JBADD = new Phrase();
                phrase2_JBADD.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                        ", simfang2312_z5) * 3, simfang2312_z5, "", "                                                                        "));
                paragraph2_JBADD.add(phrase2_JBADD);
                Paragraph paragraph4_JBADD = new ParagraphBuilder();
                paragraph4_JBADD.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph4_JBADD.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4_JBADD = new Phrase();
                phrase4_JBADD.add(new Chunk("负责人（签名）：", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine("", "            ", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("年", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("月", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.push(true), 2, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("日", simfang2312_z5));
                paragraph4_JBADD.add(phrase4_JBADD);
//                document.add(paragraph4_JBADD);
                PdfPCell cell_32_JBADD = new PdfPCellBuilder();
                cell_32_JBADD.addElement(paragraph2_JBADD);
                cell_32_JBADD.addElement(paragraph4_JBADD);
                cell_32_JBADD.setColspan(8);
                cell_32_JBADD.setFixedHeight(60.83839f);
                table.addCell(cell_32_JBADD);


                PdfPCell cell_33 = new PdfPCellBuilder(new ParagraphBuilder("审核\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_33.setFixedHeight(65.959595f);
                table.addCell(cell_33);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(ChunkFactory.tablenounderLine(book.push(), 356f, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我却是"));
                paragraph5.add(phrase5);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase7 = new Phrase();
                //phrase7.add(ChunkFactory.nounderLine("", 27.25f, simfang2312_z5));
                phrase7.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph7.add(phrase7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase8 = new Phrase();
                phrase8.add(ChunkFactory.nounderLine("", 60f, simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 31f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);
                PdfPCell cell_34 = new PdfPCellBuilder();
                cell_34.addElement(paragraph5);
                cell_34.addElement(paragraph7);
                cell_34.addElement(paragraph8);
                cell_34.setColspan(2);
                cell_34.setFixedHeight(65.959595f);
                table.addCell(cell_34);



                PdfPCell cell_35 = new PdfPCellBuilder(new ParagraphBuilder("审批\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_35.setColspan(2);
                cell_35.setFixedHeight(65.959595f);
                table.addCell(cell_35);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), 356f, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我但我"));
                paragraph9.add(phrase9);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                //phrase11.add(ChunkFactory.nounderLine("", 27.25f, simfang2312_z5));
                phrase11.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.nounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph11.add(phrase11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", 74f, simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 31f, simfang2312_z5));
                phrase12.add(new Chunk("年", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase12.add(new Chunk("月", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase12.add(new Chunk("日", simfang2312_z5));
                paragraph12.add(phrase12);
                PdfPCell cell_36 = new PdfPCellBuilder();
                cell_36.addElement(paragraph9);
                cell_36.addElement(paragraph11);
                cell_36.addElement(paragraph12);
                cell_36.setColspan(4);
                cell_36.setFixedHeight(65.959595f);
                table.addCell(cell_36);



                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //案件拟处理呈批表
    protected void printerEntity_Book_2017_29_1(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "案件拟处理呈批表", "安监拟处呈");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));

                String ajmc = book.push();
                int i = ajmc.length();
                if (i <= 35) {
                    phrase1.add(ChunkFactory.underLine(ajmc, 370.25f, simfang2312_z5));
                } else {
                    phrase1.add(ChunkFactory.underLine(ajmc, 780.5f, simfang2312_z5,"哈哈哈哈", -1));
                }

                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[9];
//                widths[0] = 42f;
//                widths[1] = 114f;
//                widths[2] = 90f;
//                widths[3] = 23f;
//                widths[4] = 23f;
//                widths[5] = 46f;
//                widths[6] = 76f;
//                widths[7] = 42f;
//                widths[8] = 65f;

                widths[0] = 35f;  // 当事人基本情况
                widths[1] = 40f;
                widths[2] = 165f;
                widths[3] = 13f;
                widths[4] = 13f;
                widths[5] = 20f;  // 地址、职务、年龄、单位地址、联系电话
                widths[6] = 102f;
                widths[7] = 32f;
                widths[8] = 50f;

                table = new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事人基本情况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setRowspan(5);
                cell_0.setFixedHeight(28f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("被处罚单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(28f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_2.setColspan(2);
                cell_2.setFixedHeight(28f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setColspan(2);
                cell_3.setFixedHeight(28f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_4.setColspan(3);
                cell_4.setFixedHeight(28f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("法定代表人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(28f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_6.setColspan(2);
                cell_6.setFixedHeight(28f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("职务", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setColspan(2);
                cell_7.setFixedHeight(28f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_8.setFixedHeight(28f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_9.setFixedHeight(28f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_10.setFixedHeight(28f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_11.setFixedHeight(28f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_12.setColspan(2);
                cell_12.setFixedHeight(28f);
                table.addCell(cell_12);
                PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder("年龄", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_13.setColspan(2);
                cell_13.setFixedHeight(28f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_14.setFixedHeight(28f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder("性别", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_15.setFixedHeight(28f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_16.setFixedHeight(28f);
                table.addCell(cell_16);
                PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder("所在单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_17.setFixedHeight(28f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_18.setColspan(2);
                cell_18.setFixedHeight(28f);
                table.addCell(cell_18);
                PdfPCell cell_19 = new PdfPCellBuilder(new ParagraphBuilder("单位地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_19.setColspan(2);
                cell_19.setFixedHeight(28f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_20.setColspan(3);
                cell_20.setFixedHeight(28f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new ParagraphBuilder("家庭住址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_21.setFixedHeight(28f);
                table.addCell(cell_21);
                PdfPCell cell_22 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_22.setColspan(2);
                cell_22.setFixedHeight(28f);
                table.addCell(cell_22);
                PdfPCell cell_23 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_23.setColspan(2);
                cell_23.setFixedHeight(28f);
                table.addCell(cell_23);
                PdfPCell cell_24 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_24.setFixedHeight(28f);
                table.addCell(cell_24);
                PdfPCell cell_25 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_25.setFixedHeight(28f);
                table.addCell(cell_25);
                PdfPCell cell_26 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_26.setFixedHeight(28f);
                table.addCell(cell_26);
                PdfPCell cell_27 = new PdfPCellBuilder(new ParagraphBuilder("案件调查情况及拟处理依据", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_27.setFixedHeight(137.5f);
                table.addCell(cell_27);
                PdfPCell cell_28 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_28.setColspan(8);
                cell_28.setFixedHeight(87.5f);
                table.addCell(cell_28);
//                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("当事人的申辩意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
//                cell_29.setFixedHeight(73.383835f);
//                table.addCell(cell_29);
//                PdfPCell cell_30 = new PdfPCellBuilder(new ParagraphBuilder(book.push() ,simfang2312_z5));
//                cell_30.setColspan(8);
//                cell_30.setFixedHeight(73.383835f);
//                table.addCell(cell_30);

                PdfPCell cell_31 = new PdfPCellBuilder(new ParagraphBuilder("承办人意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31.setFixedHeight(170.83839f);
                table.addCell(cell_31);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), 5300f, simfang2312_z5, "", "                                                                        "));
                paragraph2.add(phrase2);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine("", "   ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, "      ", simfang2312_z5));
                phrase4.add(new Chunk("年", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, "      ", simfang2312_z5));
                phrase4.add(new Chunk("月", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.push(true), 2, "      ", simfang2312_z5));
                phrase4.add(new Chunk("日", simfang2312_z5));
                paragraph4.add(phrase4);
//                document.add(paragraph4);
                PdfPCell cell_32 = new PdfPCellBuilder();
                cell_32.addElement(paragraph2);
                cell_32.addElement(paragraph4);
                cell_32.setColspan(8);
                cell_32.setFixedHeight(73.83839f);
                table.addCell(cell_32);

                PdfPCell cell_31_JBADD = new PdfPCellBuilder(new ParagraphBuilder("部门负责人意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31_JBADD.setFixedHeight(118.83839f);
                table.addCell(cell_31_JBADD);
                Paragraph paragraph2_JBADD = new ParagraphBuilder();
                paragraph2_JBADD.setLeading(simfang2312_z5.getSize() * 1f);
//                paragraph2_JBADD.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2_JBADD = new Phrase();
                phrase2_JBADD.add(ChunkFactory.tablenounderLine(book.push(), 3400f, simfang2312_z5, "", "                                                                        "));
                paragraph2_JBADD.add(phrase2_JBADD);
                Paragraph paragraph4_JBADD = new ParagraphBuilder();
                paragraph4_JBADD.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph4_JBADD.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4_JBADD = new Phrase();
                phrase4_JBADD.add(new Chunk("负责人（签名）：", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine("", "            ", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("年", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("月", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.push(true), 2, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("日", simfang2312_z5));
                paragraph4_JBADD.add(phrase4_JBADD);
//                document.add(paragraph4_JBADD);
                PdfPCell cell_32_JBADD = new PdfPCellBuilder();
                cell_32_JBADD.addElement(paragraph2_JBADD);
                cell_32_JBADD.addElement(paragraph4_JBADD);
                cell_32_JBADD.setColspan(8);
                cell_32_JBADD.setFixedHeight(73.83839f);
                table.addCell(cell_32_JBADD);



                PdfPCell cell_33 = new PdfPCellBuilder(new ParagraphBuilder("审核\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_33.setFixedHeight(65.959595f);
                table.addCell(cell_33);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(ChunkFactory.tablenounderLine(book.push(), 356f, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我却是"));
                paragraph5.add(phrase5);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase7 = new Phrase();
                //phrase7.add(ChunkFactory.nounderLine("", 27.25f, simfang2312_z5));
                phrase7.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph7.add(phrase7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase8 = new Phrase();
                phrase8.add(ChunkFactory.nounderLine("", 60f, simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 31f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);
                PdfPCell cell_34 = new PdfPCellBuilder();
                cell_34.addElement(paragraph5);
                cell_34.addElement(paragraph7);
                cell_34.addElement(paragraph8);
                cell_34.setColspan(2);
                cell_34.setFixedHeight(65.959595f);
                table.addCell(cell_34);
                PdfPCell cell_35 = new PdfPCellBuilder(new ParagraphBuilder("审批\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_35.setColspan(2);
                cell_35.setFixedHeight(65.959595f);
                table.addCell(cell_35);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), 356f, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我却是"));
                paragraph9.add(phrase9);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                //phrase11.add(ChunkFactory.nounderLine("", 27.25f, simfang2312_z5));
                phrase11.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.nounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph11.add(phrase11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", 74f, simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 31f, simfang2312_z5));
                phrase12.add(new Chunk("年", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase12.add(new Chunk("月", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase12.add(new Chunk("日", simfang2312_z5));
                paragraph12.add(phrase12);
                PdfPCell cell_36 = new PdfPCellBuilder();
                cell_36.addElement(paragraph9);
                cell_36.addElement(paragraph11);
                cell_36.addElement(paragraph12);
                cell_36.setColspan(4);
                cell_36.setFixedHeight(65.959595f);
                table.addCell(cell_36);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //结案审批表
    protected void printerEntity_Book_2017_45(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "结案审批表", "安监结");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));

                String ajmc = book.push();
                int i = ajmc.length();
                if (i <= 35) {
                    phrase1.add(ChunkFactory.underLine(ajmc, 370f, simfang2312_z5));
                } else {
                    phrase1.add(ChunkFactory.underLine(ajmc, 780.5f, simfang2312_z5,"哈哈哈哈", -1));
                }

                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[9];
//                widths[0] = 53f;
//                widths[1] = 72f;
//                widths[2] = 115f;
//                widths[3] = 36f;
//                widths[4] = 40f;
//                widths[5] = 8f;
//                widths[6] = 94f;
//                widths[7] = 58f;
//                widths[8] = 104f;

                widths[0] = 35f;  // 当事人基本情况
                widths[1] = 50f;
                widths[2] = 150f;
                widths[3] = 13f;
                widths[4] = 13f;
                widths[5] = 8f;  // 地址、职务、年龄、单位地址、联系电话
                widths[6] = 72f;
                widths[7] = 32f;
                widths[8] = 50f;

                table = new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事\n人基\n本情\n况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setRowspan(5);
                cell_0.setFixedHeight(32f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人\n（单位）", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(25f);
                table.addCell(cell_1);
                //PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(ChunkFactory.tablenounderLine(book.push(), 400f, simfang2312_z5,"","妈妈经常批评我做事不讲效率的")));
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setColspan(2);
                cell_3.setFixedHeight(25f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setColspan(4);
                cell_4.setFixedHeight(32f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("法定\n" +
                        "代表人\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(32f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setFixedHeight(32f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("职务", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setColspan(2);
                cell_7.setFixedHeight(32f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_8.setColspan(2);
                cell_8.setFixedHeight(32f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_9.setFixedHeight(32f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_10.setFixedHeight(32f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人\n（个人）", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_11.setFixedHeight(32f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_12.setFixedHeight(32f);
                table.addCell(cell_12);
                PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder("年龄", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_13.setColspan(2);
                cell_13.setFixedHeight(32f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_14.setColspan(2);
                cell_14.setFixedHeight(32f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder("性别", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_15.setFixedHeight(32f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_16.setFixedHeight(32f);
                table.addCell(cell_16);
                PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder("所在单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_17.setFixedHeight(32f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_18.setFixedHeight(32f);
                table.addCell(cell_18);
                PdfPCell cell_19 = new PdfPCellBuilder(new ParagraphBuilder("单位地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_19.setColspan(2);
                cell_19.setFixedHeight(32f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_20.setColspan(4);
                cell_20.setFixedHeight(32f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new ParagraphBuilder("家庭住址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_21.setFixedHeight(32f);
                table.addCell(cell_21);
                PdfPCell cell_22 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_22.setFixedHeight(32f);
                table.addCell(cell_22);
                PdfPCell cell_23 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_23.setColspan(2);
                cell_23.setFixedHeight(32f);
                table.addCell(cell_23);
                PdfPCell cell_24 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_24.setColspan(2);
                cell_24.setFixedHeight(32f);
                table.addCell(cell_24);
                PdfPCell cell_25 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_25.setFixedHeight(32f);
                table.addCell(cell_25);
                PdfPCell cell_26 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_26.setFixedHeight(32f);
                table.addCell(cell_26);
                PdfPCell cell_27 = new PdfPCellBuilder(new ParagraphBuilder("处理\n" +
                        "结果\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_27.setFixedHeight(91f);
                table.addCell(cell_27);
                PdfPCell cell_28 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_28.setColspan(8);
                cell_28.setFixedHeight(137.5f);
                table.addCell(cell_28);

                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("执行\n" +
                        "情况\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_29.setFixedHeight(151f);
                table.addCell(cell_29);

                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), 4540f, simfang2312_z5,"","妈妈经常批评我做事不讲效率但我却是妈妈经常批评我做事不讲效率但我却是妈妈"));
                paragraph2.add(phrase2);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）:", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 73.5f, simfang2312_z5));
                phrase4.add(new Chunk(" ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 57.75f, simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 80f, simfang2312_z5));
                phrase4.add(new Chunk("年", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase4.add(new Chunk("月", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase4.add(new Chunk("日", simfang2312_z5));
                paragraph4.add(phrase4);
                PdfPCell cell_30 = new PdfPCellBuilder();
                cell_30.addElement(paragraph2);
                cell_30.addElement(paragraph4);
//                cell_30.addElement(paragraph6);
                cell_30.setColspan(8);
                cell_30.setFixedHeight(123.5f);
                table.addCell(cell_30);



                PdfPCell cell_31_JBADD = new PdfPCellBuilder(new ParagraphBuilder("部门\n负责\n人意\n见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31_JBADD.setFixedHeight(73.83839f);
                table.addCell(cell_31_JBADD);
                Paragraph paragraph2_JBADD = new ParagraphBuilder();
                paragraph2_JBADD.setLeading(simfang2312_z5.getSize() * 1f);
//                paragraph2_JBADD.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2_JBADD = new Phrase();
                phrase2_JBADD.add(ChunkFactory.tablenounderLine(book.push(), 3400f, simfang2312_z5, "", "                                                                        "));
                paragraph2_JBADD.add(phrase2_JBADD);
                Paragraph paragraph4_JBADD = new ParagraphBuilder();
                paragraph4_JBADD.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph4_JBADD.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4_JBADD = new Phrase();
                phrase4_JBADD.add(new Chunk("负责人（签名）：", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine("", "                  ", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("年", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("月", simfang2312_z5));
                phrase4_JBADD.add(ChunkFactory.tablenounderLine(book.push(true), 2, "      ", simfang2312_z5));
                phrase4_JBADD.add(new Chunk("日", simfang2312_z5));
                paragraph4_JBADD.add(phrase4_JBADD);
//                document.add(paragraph4_JBADD);
                PdfPCell cell_32_JBADD = new PdfPCellBuilder();
                cell_32_JBADD.addElement(paragraph2_JBADD);
                cell_32_JBADD.addElement(paragraph4_JBADD);
                cell_32_JBADD.setColspan(8);
                cell_32_JBADD.setFixedHeight(120.83839f);
                table.addCell(cell_32_JBADD);


                PdfPCell cell_31 = new PdfPCellBuilder(new ParagraphBuilder("审核\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31.setFixedHeight(60f);
                table.addCell(cell_31);


                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(ChunkFactory.tablenounderLine(book.push(), 390f, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我将计就计"));
                paragraph13.add(phrase13);


                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph15.add(phrase15);

                Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(ChunkFactory.nounderLine("", 25f, simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase16.add(new Chunk("年", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("月", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("日", simfang2312_z5));
                paragraph16.add(phrase16);


                PdfPCell cell_32 = new PdfPCellBuilder();
                cell_32.addElement(paragraph13);
                cell_32.addElement(paragraph15);
                cell_32.addElement(paragraph16);
                cell_32.setColspan(3);
                cell_32.setFixedHeight(60f);
                table.addCell(cell_32);
                PdfPCell cell_33 = new PdfPCellBuilder(new ParagraphBuilder("审批\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_33.setColspan(2);
                cell_33.setFixedHeight(60f);
                table.addCell(cell_33);
                Paragraph paragraph17 = new ParagraphBuilder();
                paragraph17.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase17 = new Phrase();
                phrase17.add(ChunkFactory.tablenounderLine(book.push(), 290f, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但"));
                paragraph17.add(phrase17);


                Paragraph paragraph19 = new ParagraphBuilder();
                paragraph19.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase19 = new Phrase();
                phrase19.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase19.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph19.add(phrase19);
                Paragraph paragraph20 = new ParagraphBuilder();
                paragraph20.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase20 = new Phrase();
                phrase20.add(ChunkFactory.nounderLine("", 25f, simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase20.add(new Chunk("年", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("月", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("日", simfang2312_z5));
                paragraph20.add(phrase20);
                PdfPCell cell_34 = new PdfPCellBuilder();
                cell_34.addElement(paragraph17);
                cell_34.addElement(paragraph19);
                cell_34.addElement(paragraph20);
                cell_34.setColspan(3);
                cell_34.setFixedHeight(60f);
                table.addCell(cell_34);

                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //打印标题栏 字号
    protected void printerFrameWorkTitle(Base_Entity book, String title1text, String title2text, String title3text) {
        String one = book.getValue(0);
        String two = book.getValue(1);
        String three = book.getValue(2);
        try {
            final Paragraph title = new ParagraphBuilder(city + title1text, simzhongsong_zx2);// Paragraph就是段落
            //title.setLeading(90f);// 标题定值
            title.setAlignment(Element.ALIGN_CENTER);// 居中
            document.add(title);// 写入文档
            if (title2text.equals("") && title3text.equals("")) {

            } else if (!title2text.equals("") && title3text.equals("") && !title1text.equals("")) {
                final Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
                titleLine1.setLeading(12f);
                document.add(titleLine1);
                final Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
                titleLine2.setLeading(2f);
                try {
                    document.add(titleLine2);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
            } else if (!title2text.equals("") && title3text.equals("") && title1text.equals("")) {
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
            } else {
                final Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
                titleLine1.setLeading(12f);
                document.add(titleLine1);
                final Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
                titleLine2.setLeading(2f);
                try {
                    document.add(titleLine2);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);

                final Paragraph title3 = new ParagraphBuilder("（" + one
                        + " ）" + title3text + "〔" + two + "〕" + three + (book.getExtraObj() != null ? "-" + book.getExtraObj() : "")
                        + "号", simfang2312_zx3);
                title3.setLeading(25f);
                title3.setAlignment(Element.ALIGN_CENTER);
                document.add(title3);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
