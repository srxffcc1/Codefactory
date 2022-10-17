package utils;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by King6rf on 2017/7/16. 将word转成我们用的那种itext代码的工具类
 */
public class Util_Pdf {
    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }
    public static void test1(){//对于没有表格的doc
        Util_Pdf.word2pdfall("D:\\App\\Codefactory\\2017doc\\2016年执法文件式样_7.doc",12);
    }
    public static void test2(){//对于有表格的就需要两个都使用
        Util_Pdf.word2pdfall("D:\\App\\Codefactory\\2017doc\\2016年执法文件式样_3.doc",12);
        Util_Pdf.word2pdftablecode("D:\\App\\Codefactory\\2017doc\\2016年执法文件式样_3.doc");
    }
    /**
     * 将doc文本内容转成pdf特定书写语句
     *
     * @param docpath
     * @param textsize
     */
    public static void word2pdfall(String docpath, float textsize) {
        String body = word2string(docpath);
//        System.out.println(body);
        Pattern specialtitle = Pattern.compile("(\\d)+(.*)\n");
        Matcher matcher = specialtitle.matcher(body);
        int length = 0;
        int startindex = 0;
        if (matcher.find()) {
            if (matcher.start() == 0) {
                startindex = 2;
            }
        }
        String[] bodys = body.split("\n");


        if (body.matches("[\\s\\S]*（    ）(.*?)〔    〕[\\s\\S]*")) {
            length = 3;
        } else {
            length = 2;
        }
//            System.out.println(bodys.length);
        String[] body1 = new String[length];
        for (int i = 0; i < length; i++) {
            body1[i] = bodys[i + startindex];
//            System.out.println(body1[i]);
        }
        String[] body2 = new String[bodys.length - length - startindex + 1];
        System.out.println(body2.length);
        for (int i = 0; i < bodys.length - length - startindex; i++) {
            body2[i] = bodys[length + i + startindex];
//            System.out.println(body2[i]);
        }
        wordtitle2pdfcode(body1);
        word2pdfcode(body2, 0, textsize);
        System.out.println("printerFrameWorkPic(image);");
        System.out.println("document.newPage();// 结束保存");
    }

    /**
     * word转string 如果有表格要注意
     *
     * @param docPath
     * @return
     */
    public static String word2string(String docPath) {
        XWPFDocument doc = null;
        try {
            InputStream is = new FileInputStream(docPath);
            doc = new XWPFDocument(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String text = extractor.getText();
        return text;
    }

    /**
     * 将标题转成pdf语句
     *
     * @param titles
     */
    public static void wordtitle2pdfcode(String[] titles) {
        if (titles.length == 3) {
            String title1 = titles[0].trim();
            String title2 = titles[1].trim();
            String title3 = titles[2].trim();
            Pattern p3 = Pattern.compile(".*）(.*?)〔.*号");
            Matcher m3 = p3.matcher(title3);
            if (m3.find()) {
                title3 = m3.group(1);
            }
            System.out.println(
                    "final Paragraph title = new Paragraph(\"" + title1 + "\", simzhongsong_zx2);// Paragraph就是段落\n" +
                    "title.setLeading(1f);// 段落距离\n" +
                    "title.setAlignment(Element.ALIGN_CENTER);// 居中\n" +
                    "document.add(title);// 写入文档\n" +
                    "final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行\n" +
                    "titleLine1.setLeading(1f);\n" +
                    "titleLine1.setSpacingBefore(5f);\n" +
                    "document.add(titleLine1);\n" +
                    "final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));\n" +
                    "titleLine2.setLeading(1f);\n" +
                    "titleLine2.setSpacingBefore(1f);\n" +
                    "document.add(titleLine2);\n" +
                    "final Paragraph title2 = new Paragraph(\"" + title2 + "\", simzhongsong_zx2);\n" +
                    "title2.setLeading(1f);\n" +
                    "title2.setSpacingBefore(17f);\n" +
                    "title2.setAlignment(Element.ALIGN_CENTER);\n" +
                    "document.add(title2);\n" +
                    "final Paragraph title3 = new Paragraph(\"( \" + book.getValue(0) + \" )" + title3 + "〔\" + book.getValue(1) + \"〕\"+ book.getValue(2) + \"号\", simfang2312_zx3);\n" +
                    "title3.setLeading(1f);\n" +
                    "title3.setSpacingBefore(34f);\n" +
                    "title3.setAlignment(Element.ALIGN_CENTER);\n" +
                    "document.add(title3);");
        } else {
            String title1 = titles[0].trim();
            String title2 = titles[1].trim();
            System.out.println("final Paragraph title = new Paragraph(\"" + title1 + "\", simzhongsong_zx2);// Paragraph就是段落\n" +
                    "title.setLeading(1f);// 段落距离\n" +
                    "title.setAlignment(Element.ALIGN_CENTER);// 居中\n" +
                    "document.add(title);// 写入文档\n" +
                    "final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行\n" +
                    "titleLine1.setLeading(1f);\n" +
                    "titleLine1.setSpacingBefore(5f);\n" +
                    "document.add(titleLine1);\n" +
                    "final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));\n" +
                    "titleLine2.setLeading(1f);\n" +
                    "titleLine2.setSpacingBefore(1f);\n" +
                    "document.add(titleLine2);\n" +
                    "final Paragraph title2 = new Paragraph(\"" + title2 + "\", simzhongsong_zx2);\n" +
                    "title2.setLeading(1f);\n" +
                    "title2.setSpacingBefore(17f);\n" +
                    "title2.setAlignment(Element.ALIGN_CENTER);\n" +
                    "document.add(title2);");
        }
    }

    /**
     * 分配数组任务
     *
     * @param wordstring
     * @param paragraphnameindex
     * @param textsize
     */
    public static void word2pdfcode(String[] wordstring, int paragraphnameindex, float textsize) {
        for (int i = 0; i < wordstring.length; i++) {
            word2pdfcode(wordstring[i], (paragraphnameindex + i), textsize);
        }
    }

    /**
     * 实体数组
     *
     * @param wordstrings
     */
    public static void word2entity(String[] wordstrings) {
        for (int i = 0; i < wordstrings.length; i++) {
            word2entity(wordstrings[i]);
        }
    }

    /**
     * 利用doc内容初步书写book实体
     *
     * @param wordstring
     */
    public static void word2entity(String wordstring) {
        wordstring = wordstring.replaceAll("\t", "\n");
        if (wordstring.contains("\n")) {
            String[] wordstring2 = wordstring.split("\n");
            word2entity(wordstring2);
        } else {
            wordstring = wordstring.replaceAll("\n", "");
            char[] wordarray = wordstring.toCharArray();
            char tmpnow = '\u0000';
            float spacelength = 0;
            int splitindexstart = 0;
            for (int i = 0; i < wordarray.length; i++) {
                if ((int) wordarray[i] == 0 || (int) wordarray[i] == 32 || (int) wordarray[i] == 12288) {
                    //获得空余区
                    if (i != 0 && (tmpnow != 0 && (int) tmpnow != 32 && (int) tmpnow != 12288)) {//前一位也不是空格 则需要输出
                        String tmptext = wordstring.substring(splitindexstart, i).replace("□", "").replace(":", "").replace("：", "");
                        System.out.println("fieldnamelsitchinese.add(\"" + tmptext + "\");");
                        splitindexstart = i;
                    }
                    if (i + 1 == wordarray.length) {

                        splitindexstart = i;
                        spacelength = 0;
                    }
                } else {
                    if (i != 0 && ((int) tmpnow == 0 || (int) tmpnow == 32 || (int) tmpnow == 12288)) {//说明前一位是空格 且不是头
                        splitindexstart = i;
                        spacelength = 0;
                    }
                    if (i + 1 == wordarray.length && ((int) tmpnow == 0 || (int) tmpnow == 32 || (int) tmpnow == 12288)) {


                        splitindexstart = i;
                    }
                    if (i + 1 == wordarray.length) {
                        String tmptext = wordstring.substring(splitindexstart, i + 1).replace("□", "").replace(":", "").replace("：", "");

                        System.out.println("fieldnamelsitchinese.add(\"" + tmptext + "\");");
                        splitindexstart = i;
                    }
                    //获得有字区域
                }
                tmpnow = wordarray[i];
            }
        }
    }

    /**
     * 详细的转化书写成pdf语句
     *
     * @param wordstring
     * @param paragraphnameindex
     * @param textsize
     */
    public static void word2pdfcode(String wordstring, int paragraphnameindex, float textsize) {

        if (wordstring != null) {
            if (wordstring.contains("\n")) {
                String[] wordstring2 = wordstring.split("\n");
                word2pdfcode(wordstring2, paragraphnameindex, textsize);
            } else {
                if (textsize == -1) {
                    textsize = 10.5f;
                }
                wordstring = wordstring.replaceAll("\n", "");
                System.out.println("Paragraph paragraph" + paragraphnameindex + "=new Paragraph();\n" +
                        "paragraph" + paragraphnameindex + ".setLeading(simfang2312_z5.getSize()*2f);\n" +
                        "paragraph" + paragraphnameindex + ".setFirstLineIndent(simfang2312_z5.getSize()*2f);");
                System.out.println("Phrase phrase" + paragraphnameindex + "=new Phrase();");
                char[] wordarray = wordstring.toCharArray();
                char tmpnow = '\u0000';
                float spacelength = 0;
                int splitindexstart = 0;
                for (int i = 0; i < wordarray.length; i++) {
                    if ((int) wordarray[i] == 0 || (int) wordarray[i] == 32 || (int) wordarray[i] == 12288) {
                        //获得空余区
                        if (i != 0 && ((int) tmpnow != 0 && (int) tmpnow != 32 && (int) tmpnow != 12288)) {//前一位也不是空格 则需要输出
                            String tmptext = wordstring.substring(splitindexstart, i).replace("□", "");
                            System.out.println("phrase" + paragraphnameindex + ".add(new Chunk(\"" + tmptext + "\",simfang2312_z5));");
                            splitindexstart = i;
                        }
                        if (i + 1 == wordarray.length) {
                            System.out.println("phrase" + paragraphnameindex + ".add(Pdf_Format.underLine(\"\"," + spacelength + "f,simfang2312_z5));");
                            splitindexstart = i;
                            spacelength = 0;
                        }
                        spacelength = spacelength + textsize / 2;
                    } else {
                        if (wordarray[i] == '□') {//说明是checkbox
                            String id = UUID.randomUUID().toString().replaceAll("-", "");

                            System.out.println("RadioCheckField bt" + paragraphnameindex + " = new RadioCheckField(dpfwPdfWriter,\n" +
                                    "Pdf_Format.setCheckBoxArea(105, " + (375 - 24 * paragraphnameindex) + ", 10), \"Yes" + id + "\",\n" +
                                    "getCheck(\"\", 1));\n" +
                                    "bt" + paragraphnameindex + ".setCheckType(RadioCheckField.TYPE_CHECK);\n" +
                                    "bt" + paragraphnameindex + ".setBorderWidth(BaseField.BORDER_WIDTH_THIN);\n" +
                                    "bt" + paragraphnameindex + ".setBorderColor(BaseColor.BLACK);\n" +
                                    "bt" + paragraphnameindex + ".setChecked(true);\n" +
                                    "PdfFormField ck" + paragraphnameindex + " = bt" + paragraphnameindex + ".getCheckField();\n" +
                                    "dpfwPdfWriter.addAnnotation(ck" + paragraphnameindex + ");");
                            ;
                        }
                        if (i != 0 && ((int) tmpnow == 0 || (int) tmpnow == 32 || (int) tmpnow == 12288)) {//说明前一位是空格 且不是头
                            System.out.println("phrase" + paragraphnameindex + ".add(Pdf_Format.underLine(\"\"," + spacelength + "f,simfang2312_z5));");
                            splitindexstart = i;
                            spacelength = 0;
                        }
                        if (i + 1 == wordarray.length && ((int) tmpnow == 0 || (int) tmpnow == 32 || (int) tmpnow == 12288)) {

                            splitindexstart = i;
                        }
                        if (i + 1 == wordarray.length) {
                            String tmptext = wordstring.substring(splitindexstart, i + 1).replace("□", "");
                            System.out.println("phrase" + paragraphnameindex + ".add(new Chunk(\"" + tmptext + "\",simfang2312_z5));");
                            splitindexstart = i;
                        }
                        //获得有字区域
                    }
                    tmpnow = wordarray[i];
                }
                System.out.println("paragraph" + paragraphnameindex + ".add(phrase" + paragraphnameindex + ");");
                System.out.println("document.add(paragraph" + paragraphnameindex + ");");
            }
        }


    }

    /**
     * 读取doc文件里的表格内容对表格进行绘制
     *
     * @param wordpath
     */
    public static void word2pdftablecode(String wordpath) {


        try {
            XWPFDocument documentdoc = new XWPFDocument(new FileInputStream(wordpath));
            List<XWPFTable> tabledocs = documentdoc.getTables();

            System.out.println("PdfPTable table=null;");
            for (XWPFTable tabledoc : tabledocs) {
                // 获取表格的行
                List<XWPFTableRow> rowdocs = tabledoc.getRows();
                int tablecount = getRealCol(rowdocs.get(0).getTableCells());

                getWidths(rowdocs, tablecount);
                System.out.println("table=new PdfPTable(" + tablecount + ");");
                System.out.println("table.setWidthPercentage(100f);");
                System.out.println("table.setWidths(widths);");
                int x = 0;
                int addi = 0;
                for (int i = 0; i < rowdocs.size(); i++) {
                    int height = rowdocs.get(i).getHeight();
                    List<XWPFTableCell> tabledocCells = rowdocs.get(i).getTableCells();
                    for (int j = 0; j < tabledocCells.size(); j++) {
                        CTTcPr tcpr = tabledocCells.get(j).getCTTc().getTcPr();
                        if (tcpr.getVMerge() != null && tcpr.getVMerge().getVal() == null) {//说明是合并行 不add
                            continue;
                        }
                        System.out.println("PdfPCell cell_" + x + "=new PdfPCell();");
                        if (tcpr.getVMerge() == null) {//说明这是正常行
                        }
                        if (tcpr.getGridSpan() != null) {
                            int shouldcol = tcpr.getGridSpan().getVal().intValue();
                            System.out.println("cell_" + x + ".setColspan(" + shouldcol + ");");
                        }
                        if (tcpr.getVMerge() != null && tcpr.getVMerge().getVal() != null && tcpr.getVMerge().getVal().toString() == "restart") {//说明我要合并了
                            int shouldrow = getShouldSetRow(rowdocs, i, j);
                            System.out.println("cell_" + x + ".setRowspan(" + shouldrow + ");");
                        }
                        float heighttmp = (float) (height / 19.8);
                        System.out.println("cell_" + x + ".setFixedHeight(" + heighttmp + "f);");
                        System.out.println("table.addCell(cell_" + x + ");");
                        x++;
                    }
                }
                System.out.println("document.add(table);");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获得宽度数组
     *
     * @param rowdocs
     * @param tablecount
     */
    public static void getWidths(List<XWPFTableRow> rowdocs, int tablecount) {
        System.out.println("float[] widths=new float[" + tablecount + "];");
        for (int i = 0; i < tablecount; i++) {
            System.out.println("widths[" + i + "]=1f;");
        }
        for (int i = 0; i < rowdocs.size(); i++) {
            if (rowdocs.get(i).getTableCells().size() == tablecount) {

                for (int j = 0; j < tablecount; j++) {
                    float tmp = rowdocs.get(i).getTableCells().get(j).getCTTc().getTcPr().getTcW().getW().intValue();
                    System.out.println("widths[" + j + "]=" + tmp + "f;");
                }
                break;
            }
        }
    }


//    public static boolean isContainChinese(String str) {
//
//        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
//        Matcher m = p.matcher(str);
//        if (m.find()) {
//            return true;
//        }
//        return false;
//    }

    /**
     * 获得应该合并几行 setRowspan
     *
     * @param rows
     * @param i
     * @param j
     * @return
     */
    public static int getShouldSetRow(List<XWPFTableRow> rows, int i, int j) {
        int result = 1;
        for (int k = i + 1; k < rows.size(); k++) {
            List<XWPFTableCell> tableCells = rows.get(k).getTableCells();
            if (j + 1 <= tableCells.size()) {
                CTTcPr tcpr = tableCells.get(j).getCTTc().getTcPr();
                if (tcpr.getVMerge() == null) {//说明这是正常行
                    break;
                }
                if (tcpr.getVMerge() != null && tcpr.getVMerge().getVal() != null && tcpr.getVMerge().getVal().toString() == "restart") {//是其他的合并行了
                    break;
                }
                if (tcpr.getVMerge().getVal() == null) {
                    result++;
                }
            }
        }
        return result;
    }

//    public static int getRealRow(List<XWPFTableRow> rows) {
//        System.out.println("开始");
//        int result = 0;
//        for (int i = 0; i < rows.size(); i++) {
//            result = getRealRow(rows.get(i)) + result;
//        }
//        return result;
//    }

//    public static int getRealRow(XWPFTableRow row) {
//        boolean isallalone = true;//判断是不是都是非行合并
//        int result = 0;
//        List<XWPFTableCell> tableCells = row.getTableCells();
//        for (int i = 0; i < tableCells.size(); i++) {
//            CTTcPr tcpr = tableCells.get(i).getCTTc().getTcPr();
//
//            if (tcpr.getVMerge() != null && tcpr.getVMerge().getVal() == null) {
//                return 0;
//            }
//            if (tcpr.getVMerge() != null && tcpr.getVMerge().getVal() != null && tcpr.getVMerge().getVal().toString() == "restart") {
//
//                isallalone = true;
//            }
//
//
//        }
//        if (isallalone) {
//            result = 1;
//        }
//        System.out.println(result);
//        return result;
//    }

    /**
     * 获得真实列数 全部拆分出来
     *
     * @param tableCells
     * @return
     */
    public static int getRealCol(List<XWPFTableCell> tableCells) {
        int realrow = 0;
        for (int i = 0; i < tableCells.size(); i++) {
            realrow = (tableCells.get(i).getCTTc().getTcPr().getGridSpan() == null ? 1 : tableCells.get(i).getCTTc().getTcPr().getGridSpan().getVal().intValue()) + realrow;
        }
        return realrow;
    }
}
