//package com.test.pdf;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class PdfNewTest {
//    private static Font fontChineseNormalsimfang12;
//    private static Font fontChineseBoldsimfang16;
//    private static Font fontChineseBoldsimhei15;
//    private static Font fontChineseBoldsimhei20;
//    private static Font fontChineseBoldsimhei19;
//    private static Font fontChineseBoldsimhei17;
//    private static BaseFont bfSongChinese;
//    private static BaseFont bfHeiChinese;
//
//    public static void main(String[] args) {
//        print();
////		print4();
//    }
//
//    public static void print4() {
//        try {
////			bfSongChinese = BaseFont.createFont("simfang.ttf",
////					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
////			bfHeiChinese = BaseFont.createFont("simhei.ttf",
////					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
////			fontChineseNormalsimfang12 = new Font(bfSongChinese, 12, Font.NORMAL,
////					BaseColor.BLACK);
////			fontChineseBoldsimfang16 = new Font(bfSongChinese, 16, Font.BOLD,
////					BaseColor.BLACK);
////			fontChineseBoldsimhei15 = new Font(bfHeiChinese, 15, Font.BOLD,
////					BaseColor.BLACK);
////			fontChineseBoldsimhei19 = new Font(bfHeiChinese, 19, Font.NORMAL,
////					BaseColor.BLACK);
////			fontChineseBoldsimhei17 = new Font(bfHeiChinese, 17, Font.NORMAL,
////					BaseColor.BLACK);
////			fontChineseBoldsimhei20 = new Font(bfHeiChinese, 20, Font.BOLD,
////					BaseColor.BLACK);
//            FileOutputStream out = new FileOutputStream("pdf.pdf");
//            Document document = new Document();
//
//            PdfWriter.getInstance(document, out);
//            document.open();
//            PdfPTable table = new PdfPTable(1);
//
//            PdfPCell rowCell1 = new PdfPCell();
//            rowCell1.setFixedHeight(230f);
//            final Paragraph tableParagraph1 = new Paragraph();
//            Phrase rowCell1P = new Phrase(new Chunk("666666666666666666666666").setUnderline(-1, -1));
//            tableParagraph1.add(rowCell1P);
//            rowCell1.addElement(tableParagraph1);
//
//            table.addCell(rowCell1);
//            document.add(table);
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static void toMeasurefloat(Phrase phrase1) {
//        float result = 0;
//        java.util.List<Chunk> mArrayList1 = phrase1.getChunks();
//        for (int i = 0; i < mArrayList1.size(); i++) {
//            float everyblock = ((Chunk) (mArrayList1.get(i))).getWidthPoint();
//            result = result + everyblock;
//        }
//        System.out.println(result);
//    }
//
//    public static void print3() {
//        try {
//            FileOutputStream out = new FileOutputStream("line.pdf");
//
//            Document document = new Document();
//
//            PdfWriter.getInstance(document, out);
//            document.open();
//            Phrase pp = new Phrase("312312312535735476536745637547635476376457635746536745673547635476354763576453");
//            Paragraph p1 = new Paragraph("");
//            p1.add(pp);
//            toMeasurefloat(pp);
//            document.add(p1);
//
//
//            document.close();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public static void print2() {
//        try {
//            FileOutputStream out = new FileOutputStream("insertPage.pdf");
//
//            Document document = new Document();
//
//            PdfWriter.getInstance(document, out);
//
//            document.open();
//            document.add(new Paragraph("1 page"));
//
//            document.newPage();
//            document.add(new Paragraph("2 page"));
//
//            document.newPage();
//            document.add(new Paragraph("3 page"));
//
//            document.close();
//
//            PdfReader reader = new PdfReader("insertPage.pdf");
//            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("insertPage2.pdf"));
//            stamper.insertPage(2, reader.getPageSize(1));
//            PdfContentByte canvas = stamper.getOverContent(2);
//            ColumnText.showTextAligned(canvas,
//                    Element.ALIGN_LEFT, new Phrase("Hello people!"), 36, 540, 0);
//            stamper.close();
//            reader.close();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public static void print() {
//
//        try {
//            FileOutputStream out = new FileOutputStream("newtest.pdf");
//            Document document = new Document();
//            fontChineseNormalsimfang12 = FontFactory.getFont("D:\\Users\\apple\\安元" + "/simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 3, Font.NORMAL,
//                    BaseColor.BLACK);
//            fontChineseBoldsimfang16 = FontFactory.getFont("D:\\Users\\apple\\安元" + "/simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 16, Font.NORMAL,
//                    BaseColor.BLACK);
//            PdfWriter.getInstance(document, out);
////	public Font(final BaseFont bf, final float size, final int style, final BaseColor color) {
////                this.baseFont = bf;
////                this.size = size;
////                this.style = style;
////                this.color = color;
////            }
//
//            Font needscale=new Font(fontChineseNormalsimfang12.getBaseFont(),10,fontChineseNormalsimfang12.getStyle(),fontChineseNormalsimfang12.getColor());
//            document.open();
//            document.open();
//            Chunk chunk1 = new Chunk("测试吧",new FontBuilder2(fontChineseNormalsimfang12).setSize(30).build()).setUnderline(-1, -1);
//            Chunk chunk2 = new Chunk("超级测试吧",needscale).setUnderline(-1, -1);
//            Phrase pargraph1 = new Phrase();
//            pargraph1.add(chunk1);
//            pargraph1.add(chunk2);
//            document.add(pargraph1);
//            document.close();
//
//            System.out.println("完毕");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
