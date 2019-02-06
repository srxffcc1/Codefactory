//package com.wisdomregulation.pdflink;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.SplitCharacter;
//import com.itextpdf.text.pdf.PdfChunk;
//
//import static com.wisdomregulation.pdflink.StringFactory.*;
//
///**
// * 本类 是 pdf打印的帮助类
// */
//@Deprecated
//public class Help_Pdf_Help extends ChunkFactory{
//    public static Chunk underLineChunk(String text, float length, Font font, float firstLineIndent, float pagewidth)  {
//        length=length*font.getSize()/2;
//        Chunk targetChunk = null;
//        try {
//            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedLengthNoCenter(text, length, font, firstLineIndent, pagewidth), font).setUnderline(-1f, -1f)
//                    .setSplitCharacter(new SplitCharacterFix());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return targetChunk;
//    }
//    public static Chunk underLineChunk(String text, float length, Font font)  {
//        length=length*(font.getSize()/2);
//        Chunk targetChunk = null;
//        try {
//            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedLengthNoCenter(text, length, font, -1, -1), font).setUnderline(-1f, -1f)
//                    .setSplitCharacter(new SplitCharacterFix());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return targetChunk;
//    }
//
//    public static Chunk nounderLineChunk(String text, float length, Font font) {
//        length=length*(font.getSize()/2);
//        Chunk targetChunk = null;
//        try {
//            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedLengthNoCenter(text, length, font, -1, -1), font)
//                    .setSplitCharacter(new SplitCharacterFix());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return targetChunk;
//    }
//}
