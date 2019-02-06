package com.wisdomregulation.pdflink;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.SplitCharacter;
import com.itextpdf.text.pdf.PdfChunk;



/**
 * 本类 是 pdf打印的帮助类
 */
public class ChunkFactory {

    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @param scalebeyond 缩放倍数
     * @return
     */
    public static Chunk underLine(String text, float length, Font font, float firstLineIndent, float pagewidth,float scalebeyond) {
        float orgscale=font.getSize();
        float needscale=orgscale;
        Chunk targetChunk = null;
        if(scalebeyond>1f){//才需要去做这个缩放操作
            float scaletmp=StringFactoryBuild.build().getScaleSizeOfMatchOrginIfBeyond(text,length,font,firstLineIndent,pagewidth);
            PdfFactoryLog.println("Chunk缩放规格:"+scaletmp);
            if(scaletmp<scalebeyond&&scaletmp>1f){//说明需要缩放
                //此处需要修改字体尺寸
                needscale =(int)(orgscale/scaletmp);
                PdfFactoryLog.println("Chunk目标字体"+needscale);
            }else{

            }
        }
        try {
            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedLength(text, length, new FontBuilder(font).setSize(orgscale).build(), firstLineIndent, pagewidth,true,scalebeyond), new FontBuilder(font).setSize(needscale).build()).setUnderline(-1f, -1f)
                    .setSplitCharacter(new SplitCharacterFix());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetChunk;
    }
    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @param scalebeyond 缩放倍数
     * @return
     */
    public static Chunk underLine(String text, float length, Font font, String  firstLineIndent, float pagewidth,float scalebeyond) {
        return underLine( text,  length,  font,  StringFactoryBuild.build().getStringLength(firstLineIndent,font),  pagewidth, scalebeyond);
    }
    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @return
     */
    public static Chunk underLine(String text, float length, Font font, float firstLineIndent, float pagewidth) {
        return underLine(text,length,font,firstLineIndent,pagewidth,1f);
    }
    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @return
     */
    public static Chunk underLine(String text, String length, Font font, String firstLineIndent, float pagewidth) {
        return underLine(text,StringFactoryBuild.build().getStringLength(length,font),font,StringFactoryBuild.build().getStringLength(firstLineIndent,font),pagewidth);
    }
    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @return
     */
    public static Chunk underLine(String text, float length, Font font, String firstLineIndent, float pagewidth) {
        return underLine(text,length,font,StringFactoryBuild.build().getStringLength(firstLineIndent,font),pagewidth);
    }
    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @return
     */
    public static Chunk underLine(String text, String length, Font font) {
        return underLine(text,StringFactoryBuild.build().getStringLength(length,font),font,0,-1f);
    }
    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @return
     */
    public static Chunk underLine(String text, float length, Font font) {
        return underLine(text,length,font,0,-1f);
    }
    /**
     * 获得格式化字符串的Chunk 带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @return
     */
    public static Chunk underLine(String text, int timeindex, float length, Font font) {
        return underLine(StringFactoryBuild.build().getTime(text, timeindex), length, font);
    }
    /**
     * 获得格式化字符串的Chunk 不带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @param scalebeyond 缩放倍数
     * @return
     */
    public static Chunk nounderLine(String text, float length, Font font, float firstLineIndent, float pagewidth,float scalebeyond) {
        float orgscale=font.getSize();
        float needscale=orgscale;
        Chunk targetChunk = null;
        if(scalebeyond>1f){//才需要去做这个缩放操作
            float scaletmp=StringFactoryBuild.build().getScaleSizeOfMatchOrginIfBeyond(text,length,font,firstLineIndent,pagewidth);
            //PdfFactoryLog.println("Chunk缩放规格:"+scaletmp);
            if(scaletmp<scalebeyond&&scaletmp>1f){//说明需要缩放
                //此处需要修改字体尺寸
                needscale =(int)(orgscale/scaletmp);
//                PdfFactoryLog.println("Chunk目标字体"+needscale);
            }else{

            }
        }
        try {
            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedLength(text, length, new FontBuilder(font).setSize(orgscale).build(), firstLineIndent, pagewidth,true,scalebeyond), new FontBuilder(font).setSize(needscale).build())
                    .setSplitCharacter(new SplitCharacterFix());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetChunk;
    }
    /**
     * 获得格式化字符串的Chunk 不带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @return
     */
    public static Chunk nounderLine(String text, float length, Font font, float firstLineIndent, float pagewidth) {
        return nounderLine(text,length,font,firstLineIndent,pagewidth,1f);
    }
    /**
     * 获得格式化字符串的Chunk 不带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth 页面宽度
     * @return
     */
    public static Chunk nounderLine(String text, float length, Font font, String firstLineIndent, float pagewidth) {
        return nounderLine(text,length,font,StringFactoryBuild.build().getStringLength(firstLineIndent,font),pagewidth);
    }
    /**
     * 获得格式化字符串的Chunk 不带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @return
     */
    public static Chunk nounderLine(String text, String length, Font font) {
        return nounderLine(text,StringFactoryBuild.build().getStringLength(length,font),font,0,-1);
    }
    /**
     * 获得格式化字符串的Chunk 不带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @return
     */
    public static Chunk nounderLine(String text, float length, Font font) {
        return nounderLine(text,length,font,0,-1);
    }
    /**
     * 获得格式化字符串的Chunk 不带下划线
     * @param text 字符串
     * @param length 格式化长度
     * @param font 字体
     * @return
     */
    public static Chunk nounderLine(String text, int timeindex, float length, Font font) {
        return nounderLine(StringFactoryBuild.build().getTime(text, timeindex), length, font);
    }
    /**
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @return
     */
    public static Chunk tablenounderLine(String text, float length, Font font) {
        Chunk targetChunk = null;
        try {
            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedTableLength(text, length, font), font);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return targetChunk;
    }
    /**
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @return
     */
    public static Chunk tablenounderLine(String text, String length, Font font) {
        return tablenounderLine(text, StringFactoryBuild.build().getStringLength(length,font), font);
    }
    /**
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @return
     */
    public static Chunk tablenounderLine(String text, int timeindex, String length, Font font) {
        return tablenounderLine(StringFactoryBuild.build().getTime(text, timeindex), length, font);
    }
    /**
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @return
     */
    public static Chunk tablenounderLine(String text, int timeindex, float length, Font font) {

        return tablenounderLine(StringFactoryBuild.build().getTime(text, timeindex), length, font);
    }
    /**
     *
     * 表格中有下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @param scalebeyond 允许的缩放倍数
     * @return
     */
    public static Chunk tableunderLine(String text, float length, Font font, float firstLineIndent, float pagewidth,float scalebeyond) {
        float orgscale=font.getSize();
        float needscale=orgscale;
        Chunk targetChunk = null;
        if(scalebeyond>1f){//才需要去做这个缩放操作
            float scaletmp=StringFactoryBuild.build().getScaleSizeOfMatchOrginIfBeyond(text,length,font,firstLineIndent,pagewidth);
            //PdfFactoryLog.println("Chunk缩放规格:"+scaletmp);
            if(scaletmp<scalebeyond&&scaletmp>1f){//说明需要缩放
                //此处需要修改字体尺寸
                needscale =(int)(orgscale/scaletmp);
//                PdfFactoryLog.println("Chunk目标字体"+needscale);
            }else{

            }
        }
        try {
            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedLengthTable(text, length, new FontBuilder(font).setSize(orgscale).build(), firstLineIndent, pagewidth,true,scalebeyond), new FontBuilder(font).setSize(needscale).build()).setUnderline(-1f, -1f);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return targetChunk;
    }
    /**
     *
     * 表格中有下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @return
     */
    public static Chunk tableunderLine(String text, float length, Font font, float firstLineIndent, float pagewidth) {
        return tableunderLine(text,length,font,firstLineIndent,pagewidth,1f);
    }
    /**
     *
     * 表格中有下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @return
     */
    public static Chunk tableunderLine(String text, float length, Font font) {
        return tableunderLine(text,length,font,0,-1);
    }
    /**
     *
     * 表格中有下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @return
     */
    public static Chunk tableunderLine(String text, String length, Font font) {
        return tableunderLine(text,StringFactoryBuild.build().getStringLength(length,font),font);
    }
    /**
     *
     * 表格中有下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @return
     */
    public static Chunk tableunderLine(String text, float length, Font font, String firstLineIndent, String pagewidth) {
        return tableunderLine(text,length,font,StringFactoryBuild.build().getStringLength(firstLineIndent,font),StringFactoryBuild.build().getStringLength(pagewidth,font));

    }
    /**
     *
     * 表格中有下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @return
     */
    public static Chunk tableunderLine(String text, float length, Font font, String firstLineIndent, float pagewidth) {
        return tableunderLine(text,length,font,StringFactoryBuild.build().getStringLength(firstLineIndent,font),pagewidth);
    }
    /**
     *
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @return
     */
    public static Chunk tablenounderLine(String text, float length, Font font, float firstLineIndent, float pagewidth) {
        Chunk targetChunk = null;
        try {
            targetChunk = new Chunk(StringFactoryBuild.build().stringFormatFixedLength(text, length, font, firstLineIndent, pagewidth), font);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return targetChunk;
    }
    /**
     *
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @return
     */
    public static Chunk tablenounderLine(String text, float length, Font font, String firstLineIndent, String pagewidth) {
        return tablenounderLine(text,length,font,StringFactoryBuild.build().getStringLength(firstLineIndent,font),StringFactoryBuild.build().getStringLength(pagewidth,font));
    }
    /**
     *
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @return
     */
    public static Chunk tablenounderLine(String text, float length, Font font, String firstLineIndent, float pagewidth) {
        return tablenounderLine(text,length,font,StringFactoryBuild.build().getStringLength(firstLineIndent,font),pagewidth);
    }
    /**
     *
     * 表格中无下划线的块
     * @param text 字符串
     * @param length 长度
     * @param font 字体
     * @param firstLineIndent
     * @param pagewidth
     * @return
     */
    public static Chunk tablenounderLine(String text, String length, Font font, float firstLineIndent, float pagewidth) {
        return tablenounderLine(text,StringFactoryBuild.build().getStringLength(length,font),font,firstLineIndent,pagewidth);
    }
    /**
     * 转换checkbox坐标
     * @param leftXPoint 按照左下角为0来进行计算 x
     * @param leftYPoint 按照左下角为0来进行计算 x
     * @param borderlength 宽度
     * @return
     */
    public static Rectangle setCheckBoxArea(float leftXPoint, float leftYPoint, float borderlength) {
        float leftx = leftXPoint;
        float lefty = leftYPoint + borderlength;
        float rightx = leftXPoint + borderlength;
        float righty = leftYPoint;
        Rectangle endRectangle = new Rectangle(leftx, lefty, rightx, righty);
        return endRectangle;
    }

    /**
     * index 服务端保存的数字 1234
     * @param value
     * @param index
     * @return
     */
    public static String getCheck(String value, int index) {
        String result = "Off";
        if (value.equals(index + "")) {
            result = "On";
        }
        if (value.equals("我") && index == 1) {
            result = "On";
        }
        //PdfFactoryLog.println("返回check:" + result);
        return result;
    }

    /**
     * 修复的分割类
     */
    static class SplitCharacterFix implements  SplitCharacter{

        @Override
        public boolean isSplitCharacter(int arg0, int arg1, int arg2, char[] arg3,
                                        PdfChunk[] arg4) {
            char c;
            if (arg4 == null)
                c = arg3[arg1];
            else
                c = (char) arg4[Math.min(arg1, arg4.length - 1)].getUnicodeEquivalent(arg3[arg1]);
            if (c <= ' ' || c == '-') {
                return true;
            }
            if (c < 0x2e80)
                return true;
            return true;
//				    return ((c >= 0x2e80 && c < 0xd7a0)
//				    || (c >= 0xf900 && c < 0xfb00)
//				    || (c >= 0xfe30 && c < 0xfe50)
//				    || (c >= 0xff61 && c < 0xffa0));
        }
    }
}
