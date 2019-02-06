package com.wisdomregulation.shark;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.wisdomregulation.data.entitybase.Base_Entity;
import com.wisdomregulation.pdflink.*;

public class PdfFactoryOverTemp extends PdfFactory{
    //这段方法是单例模式的处理
    protected final static PdfFactoryOverTemp pdfhelp = new PdfFactoryOverTemp();

    public static PdfFactoryOverTemp create() {
        return pdfhelp;
    }
    @Override
    protected PdfFactory getFactory() {
        return pdfhelp;
    }
//自己实现有不一样需求要修改的文书
    @Override
    protected void printerEntity_Book_2017_0(Base_Entity book, Object image) {
        super.printerEntity_Book_2017_0(book, image);
    }
    protected void printerEntity_Book_2017_45(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();printerFrameWorkTitle(book, "安全生产行政执法文书", "结案审批表", "安监结");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 336.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[9];
                widths[0] = 53f;
                widths[1] = 72f;
                widths[2] = 115f;
                widths[3] = 36f;
                widths[4] = 40f;
                widths[5] = 8f;
                widths[6] = 94f;
                widths[7] = 58f;
                widths[8] = 104f;
                table = new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事\n人基\n本情\n况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setRowspan(5);
                cell_0.setFixedHeight(32f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人\n（单位）", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(32f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setColspan(2);
                cell_3.setFixedHeight(32f);
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
                cell_28.setFixedHeight(91f);
                table.addCell(cell_28);
                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("执行\n" +
                        "情况\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_29.setFixedHeight(91f);
                table.addCell(cell_29);

                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), 1000, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
                paragraph2.add(phrase2);


                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
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
                cell_30.setFixedHeight(91f);
                table.addCell(cell_30);
                PdfPCell cell_31 = new PdfPCellBuilder(new ParagraphBuilder("审核\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31.setFixedHeight(91f);
                table.addCell(cell_31);


                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize()*1.2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(ChunkFactory.tablenounderLine(book.push(), 208f*5, simfang2312_z5, "", 208.75f));
                paragraph13.add(phrase13);


                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize()*1.2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph15.add(phrase15);

                Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize()*1.2f);
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
                cell_32.setFixedHeight(91f);
                table.addCell(cell_32);
                PdfPCell cell_33 = new PdfPCellBuilder(new ParagraphBuilder("审批\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_33.setColspan(2);
                cell_33.setFixedHeight(91f);
                table.addCell(cell_33);
                Paragraph paragraph17 = new ParagraphBuilder();
                paragraph17.setLeading(simfang2312_z5.getSize()*1.2f);
                Phrase phrase17 = new Phrase();
                phrase17.add(ChunkFactory.tablenounderLine(book.push(), 208f*5, simfang2312_z5, "", 208.75f));
                paragraph17.add(phrase17);


                Paragraph paragraph19 = new ParagraphBuilder();
                paragraph19.setLeading(simfang2312_z5.getSize()*1.2f);
                Phrase phrase19 = new Phrase();
                phrase19.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase19.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph19.add(phrase19);
                Paragraph paragraph20 = new ParagraphBuilder();
                paragraph20.setLeading(simfang2312_z5.getSize()*1.2f);
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
                cell_34.setFixedHeight(91f);
                table.addCell(cell_34);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }
}
