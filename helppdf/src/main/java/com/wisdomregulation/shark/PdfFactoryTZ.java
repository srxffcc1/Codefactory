package com.wisdomregulation.shark;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
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
public class PdfFactoryTZ extends PdfFactoryYZ {


    protected final static PdfFactoryTZ pdfhelp = (PdfFactoryTZ) new PdfFactoryTZ().setPostmark("泰州市安全生产监督管理局（公章）");

    public static PdfFactoryTZ create() {
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
     *
     * @param
     */
    protected void printerFrameWorkDate(String date) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space1);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(date, 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(date, 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(date, 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(paragraph10);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(space2);
            document.add(space1);
            document.add(bottomLine1);
//            final Paragraph paragraph11 = new ParagraphBuilder();
//            Phrase phrase12 = new Phrase();
//            phrase12.add(ChunkFactory.tablenounderLine("", 300,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            paragraph11.add(phrase12);
//            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 安全生产监督管理部门（印章）
     * 年    月    日
     * -----------------------------------------------------------------
     * 本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。
     * <p>
     * 共   页  第  页
     *
     * @param book
     */
    protected void printerFrameWorkG1(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);

            final Paragraph paragraph9 = new ParagraphBuilder();
            paragraph9.setLeading(24f);
            paragraph9.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase10 = new Phrase();
            phrase10.add(new Chunk(getPostmark(), simfang2312_z5));
//            phrase10.add(ChunkFactory.nounderLine(book.getValue("监督管理局"), 170f, simfang2312_z5));
            //toMeasurefloat(phrase10);
            paragraph9.add(phrase10);
            document.add(paragraph9);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.push(true), 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(space2);
            document.add(paragraph10);
            document.add(space2);
            document.add(space2);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(bottomLine1);
            final Paragraph paragraph13 = new ParagraphBuilder();
            paragraph10.setFirstLineIndent(0f);
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase13 = new Phrase();

            phrase13.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。", simfang2312_z5));
            phrase13.add(ChunkFactory.tablenounderLine("", 18, simfang2312_z5));
            paragraph13.add(phrase13);
            document.add(paragraph13);

//            final Paragraph paragraph11 = new ParagraphBuilder();
//            Phrase phrase12 = new Phrase();
//            phrase12.add(ChunkFactory.tablenounderLine("", 298,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            paragraph11.add(phrase12);
//            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void printerFrameWorkG5(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            final Paragraph paragraph9 = new ParagraphBuilder();
            paragraph9.setLeading(24f);
            paragraph9.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase10 = new Phrase();
            //phrase10.add(new Chunk(getPostmark(), simfang2312_z5));
            phrase10.add(ChunkFactory.nounderLine(book.getValue("监督管理局"), 170f, simfang2312_z5));
            //toMeasurefloat(phrase10);
            paragraph9.add(phrase10);
            document.add(paragraph9);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.push(true), 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(space2);
            document.add(paragraph10);
            document.add(space2);
            document.add(space2);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(bottomLine1);
            final Paragraph paragraph13 = new ParagraphBuilder();
            paragraph10.setFirstLineIndent(0f);
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase13 = new Phrase();

            phrase13.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。", simfang2312_z5));
            phrase13.add(ChunkFactory.tablenounderLine("", 18, simfang2312_z5));
            paragraph13.add(phrase13);
            document.add(paragraph13);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 安全生产监督管理部门（印章）
     * 年    月    日
     * -----------------------------------------------------------------
     * 本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。
     * <p>
     * 共   页  第  页
     *
     * @param book
     */
    protected void printerFrameWorkG1_2(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setFirstLineIndent(0f);
            paragraph10.setLeading(15f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);

            document.add(space2);
            document.add(space2);
            final Paragraph bottomLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(bottomLine1);

            Phrase phrase11 = new Phrase();
            phrase11.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine("", 18, simfang2312_z5));
            paragraph10.add(phrase11);
            document.add(paragraph10);

            final Paragraph paragraph11 = new ParagraphBuilder();
            Phrase phrase12 = new Phrase();
            phrase12.add(ChunkFactory.tablenounderLine("", 298,
                    simfang2312_z5));
            phrase12.add(new Chunk("共", simfang2312_z5));
            phrase12.add(ChunkFactory.tablenounderLine("", 21,
                    simfang2312_z5));
            phrase12.add(new Chunk("页", simfang2312_z5));
            phrase12.add(ChunkFactory.tablenounderLine("", 21,
                    simfang2312_z5));
            phrase12.add(new Chunk("第", simfang2312_z5));
            phrase12.add(ChunkFactory.tablenounderLine("", 21,
                    simfang2312_z5));
            phrase12.add(new Chunk("页", simfang2312_z5));
//            paragraph11.add(phrase12);
            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void printerFrameWorkG1_3(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setFirstLineIndent(0f);
            paragraph10.setLeading(15f);
            paragraph10.setAlignment(Element.ALIGN_LEFT);

            document.add(space2);
            document.add(space2);
            final Paragraph bottomLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(bottomLine1);

            Phrase phrase11 = new Phrase();
            phrase11.add(new Chunk("本页填写不下的内容或者需绘制勘验图的，可另附页。", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine("", 18, simfang2312_z5));
            paragraph10.add(phrase11);
            document.add(paragraph10);

//            final Paragraph paragraph11 = new ParagraphBuilder();
//            Phrase phrase12 = new Phrase();
//            phrase12.add(ChunkFactory.tablenounderLine("", 298,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            paragraph11.add(phrase12);
//            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 安全生产监督管理部门（印章）
     * 年  月  日
     *
     * @param book
     */

    /**
     * ------------------------------------------------------------------------
     * 本文书一式两份：一份由安全生产监督管理部门备案，一份交被取证人（单位）。
     *
     * @param book
     */

    protected void printerFrameWorkG4(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            final Paragraph paragraph9 = new ParagraphBuilder();
            paragraph9.setLeading(24f);
            paragraph9.setAlignment(Element.ALIGN_RIGHT);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);

            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.push(true), 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(paragraph10);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(bottomLine1);
//            final Paragraph paragraph11 = new ParagraphBuilder();
//            Phrase phrase12 = new Phrase();
////            phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被复查单位。",
////                    simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 300,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//
//            paragraph11.add(phrase12);
//
//            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    protected void printerFrameWorkTitle(Base_Entity book, String title1text, String title2text, String title3text) {
        String one=book.getValue(0);
        String two=book.getValue(1);
        String three=book.getValue(2);
        try {
            final Paragraph title = new ParagraphBuilder(city + title1text, simzhongsong_zx2);// Paragraph就是段落
            title.setLeading(40f);// 标题定值
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
                        + " ）" + title3text + "〔" + two + "〕" + three
                        + "号", simfang2312_zx3);
                title3.setLeading(30f);
                title3.setAlignment(Element.ALIGN_CENTER);
                document.add(title3);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    //现场检查记录
    protected void printerEntity_Book_2017_2(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();printerFrameWorkTitle(book, "安全生产行政执法文书", "现场检查记录", "安监检记");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2.5f);
                Phrase phrase1 = new Phrase();
                document.add(space3);
                phrase1.add(new Chunk("被检查单位", simfang2312_z5));
                phrase1.add(ChunkFactoryNoCenter.underLine(book.push(), 360.75f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2.5f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地址", simfang2312_z5));
                phrase2.add(ChunkFactoryNoCenter.underLine(book.push(), 390f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2.5f);
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
                paragraph4.setLeading(simfang2312_z5.getSize() * 2.5f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("检查场所", simfang2312_z5));
                phrase4.add(ChunkFactoryNoCenter.underLine(book.push(), 357.0f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2.5f);
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
                paragraph6.setLeading(simfang2312_z5.getSize() * 2.5f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("我们是", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase6.add(new Chunk("安全生产监督管理局行政执法人员", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase6.add(new Chunk("、", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase6.add(new Chunk("\u00a0，\n", simfang2312_z5));
                phrase6.add(new Chunk("证件号码为", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase6.add(new Chunk("、", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase6.add(new Chunk("，这是我们的证件（出示证件\u00a0）\u00a0。", simfang2312_z5));
                phrase6.add(new Chunk("现依法对你单位进行现场检查，请予以配合。", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.push(), 4000f, simfang2312_z5, 7 * simfang2312_z5.getSize(), -1,"\n",0,true);
                phrase7.add(new Chunk("检查情况：", simfang2312_z5));
//                PdfFactoryLog.println("检查情况:"+array[0]);
//                PdfFactoryLog.println("+++++++++++++++++++++++++");
                phrase7.add(ChunkFactory.underLine(array[0], 4000f, simfang2312_z5, 7 * simfang2312_z5.getSize(), -1));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                document.add(space4);
                final Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2.5f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("检查人员（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 76f, simfang2312_z5));
                phrase14.add(ChunkFactory.nounderLine("", 5.25f, simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 76f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                final Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 3f);
//                paragraph16.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(new Chunk("被检查单位现场负责人（签名）：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph16.add(phrase16);
                document.add(paragraph16);
//                printerFrameWorkDate(book);
//                document.add(space4);
//                document.add(space3);
//                document.add(space3);
//                document.add(space3);
//                document.add(space4);
//                document.add(space2);
//                document.add(space2);
                printerFrameWorkDate(book.getValue("出表日期"));
                //printerFrameWorkPic(book.getExtraSeal());         // 现场检查记录不需要签章
                document.newPage();// 结束保存

                String str = array[1];
//                StringBuilder sb = new StringBuilder();
//                for (String s : array) {
//                    sb.append(s);
//                }
                book.put("续页", str);
                if (!book.getValue("续页").equals("")) {
                    printerContinue(book, postmaskimage, new IPdfBack() {
                        @Override
                        public void writeError() {
                        }

                        @Override
                        public void writeStart() {
                        }

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
                    }, 10645);

                }
                try {
                    Object[] collects= (Object[]) book.getExtraImage();
                    if(collects!=null){
                        printerCollect(book,collects);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //行政（当场）处罚决定书（单位）
    protected void printerEntity_Book_2017_31(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政（当场）处罚决定书（单位）", "安监罚当");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.7f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被处罚单位：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 346.5f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1.7f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地址：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 231.0f, simfang2312_z5));
                phrase2.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 1.7f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("法定代表人（负责人）：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                phrase3.add(new Chunk("职务：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase3.add(new Chunk("联系电话：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 1.7f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("违法事实及证据：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 555.5f, simfang2312_z5, "空格违法事实及证据：", -1));
                phrase4.add(new Chunk("（此栏不够，可另附页）", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);

                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.7f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("以上事实违反了", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 1120.0f, simfang2312_z5, simfang2312_z5.getSize() * 9, -1));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.7f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("的规定，依据", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 1120.0f, simfang2312_z5, simfang2312_z5.getSize() * 6, -1));
                phrase8.add(new Chunk("的规定，决定给予", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 306.0f, simfang2312_z5));
                phrase8.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.7f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("罚款的履行方式和期限（见打√处）：", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.7f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase10 = new Phrase();

                phrase10.add(new Chunk("当场缴纳", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.7f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase11 = new Phrase();

                book.push();
                RadioCheckField bt10 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 418, 10), "Yes0db298f77760414bb6d386f989b105ac",
                        ChunkFactory.getCheck(book.getValue(13), 1));
                bt10.setCheckType(RadioCheckField.TYPE_CHECK);
                bt10.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt10.setBorderColor(BaseColor.BLACK);
                bt10.setChecked(true);
                PdfFormField ck10 = bt10.getCheckField();
                dpfwPdfWriter.addAnnotation(ck10);
                RadioCheckField bt11 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 398, 10), "Yesf440958418a14abb8e0a74e500d463ce",
                        ChunkFactory.getCheck(book.getValue(13), 2));
                bt11.setCheckType(RadioCheckField.TYPE_CHECK);
                bt11.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt11.setBorderColor(BaseColor.BLACK);
                bt11.setChecked(true);
                PdfFormField ck11 = bt11.getCheckField();
                dpfwPdfWriter.addAnnotation(ck11);


                phrase11.add(new Chunk("自收到本决定书之日起15日内缴至", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 210.0f, simfang2312_z5));
                phrase11.add(new Chunk("，账号", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                phrase11.add(new Chunk("，到期不缴每日按罚款数额的3%加处罚款。", simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 1.7f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("如果不服本处罚决定，可以依法在60日内向", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase12.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 204.75f, simfang2312_z5));
                phrase12.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                phrase12.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。", simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 1.7f);
//                paragraph13.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), "            ", simfang2312_z5));
                phrase13.add(ChunkFactory.nounderLine("", "  ", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), "            ", simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 1.7f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("当事人或者委托代理人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                printerFrameWorkG2(book);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);

                document.newPage();// 结束保存
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

    //先 行 登 记 保 存 证 据 清 单

}
