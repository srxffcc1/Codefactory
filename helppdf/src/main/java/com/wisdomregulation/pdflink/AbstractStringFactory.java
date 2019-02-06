package com.wisdomregulation.pdflink;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 主要是对字符串进行处理修正的抽象类
 */
public abstract class AbstractStringFactory {
    /**
     * 默认页面宽度
     */
    public float pagewidthorg = 409.5f;

    public void setPagewidthorg(float pagewidthorg) {
        this.pagewidthorg = pagewidthorg;
    }


    /**
     * 获得字符串在pdf文件中的总长度
     *
     * @param orgstring 原始字符串
     * @param font      字体
     * @return
     */
    public abstract float getStringLength(String orgstring, Font font);

    /**
     * 获得时间阶 0 对应 年 1 对象月 以此类推
     *
     * @param time  原始时间
     * @param index 阶层
     * @return
     */
    public abstract String getTime(String time, int index);

    /**
     * 格式化字符串成时间字符串 目标格式yyyy-MM-dd-HH-mm-ss
     *
     * @param time 时间字符串
     * @return
     */
    public abstract String getTime(String time);

    /**
     * 已经验证
     * 将长度格式化为字体大小的整数倍
     *
     * @param fixlength 需要格式化的长度
     * @param font      字体
     * @return
     */
    public abstract float formatlength(float fixlength, Font font);

    /**
     * 将空格补到字符前后平均
     *
     * @param orgin             需要格式化的字符串
     * @param formatFixedlength 需要格式化的需求长度
     * @param font              字体
     * @return
     */
    public abstract String stringFormatSpaceHeadAndLast(String orgin, float formatFixedlength, Font font);

    /**
     * 将空格补到字符末尾
     *
     * @param orgin             需要格式化的字符串
     * @param formatFixedlength 需要格式化的需求长度
     * @param font              字体
     * @return
     */
    public abstract String stringFormatSpaceLast(String orgin, float formatFixedlength, Font font);

    /**
     * 对换行符进行识别 格式化字符串
     *
     * @param orgin           需要格式化的字符串
     * @param font            字体
     * @param firstLineIndent 首行缩进
     * @param pagewidth       页面宽度
     * @return
     */
    public abstract String stringFormatIdentifyLn(String orgin, Font font, float firstLineIndent, float pagewidth, boolean nospace);

    /**
     * 是stringFormatIdentifyLn的辅助方法 对每个block进行2次格式化
     *
     * @param orgin           需要修正的字符串
     * @param font            字体
     * @param firstLineIndent 首行缩进 传0则为无缩进
     * @param pagewidth       页面宽度
     * @param nospace         是否需要加空格
     * @return
     */
    public abstract String stringFormatWrap(String orgin, Font font, float firstLineIndent, float pagewidth, boolean nospace);

    /**
     * 获得一个长度数组用来居中
     *
     * @param formatFixedlength 长度
     * @param font              字体
     * @return
     */
    public abstract int[] getSpaceJustLength(float formatFixedlength, Font font);

    /**
     * 获得个数级别的空格字符串
     *
     * @param size 空格数量
     * @param font 字体
     * @return
     */
    public abstract String getSpaceSize(float size, Font font);

    /**
     * 获得固定长度的空格段
     *
     * @param formatFixedlength 长度
     * @param font              字体
     * @return
     */
    public abstract String getSpaceLength(float formatFixedlength, Font font);

    /**
     * 保持block完整 按照指定分隔符分割获得可以放入指定大小的字符串 0为可以放入 1为多余
     *
     * @param orgin             需要格式化的字符
     * @param formatFixedlength 需要格式化成的长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @param splitmask         分割符号
     * @return
     */
    public abstract String[] stringFormatIdentifySplit(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String splitmask);

    /**
     * 获得格式化的字符串并且截取到指定长度  返回一个数组 0为可以放入的按照长度区分的 1为多余的 皆为完整的句子 由needlastsplit控制是否打断末尾句
     *
     * @param orgin             需要格式化的字符
     * @param formatFixedlength 需要格式化成的长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @param blocksplit        分隔符
     * @param blockindent       需要的block缩进
     * @param needlastsplit     需要末尾进行last分割吗
     * @return
     */
    public abstract String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit, int blockindent,boolean needlastsplit);

    /**
     * 获得格式化的字符串并且截取到指定长度 不打断分割符的block 返回一个数组 0为可以放入的按照长度区分的 1为多余的 皆为完整的句子
     *
     * @param orgin             需要格式化的字符
     * @param formatFixedlength 需要格式化成的长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @param blockindent       需要的block缩进
     * @return
     */
    public abstract String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, int blockindent);

    /**
     * 获得格式化的字符串并且截取到指定长度 不打断分割符的block 返回一个数组 0为可以放入的按照长度区分的 1为多余的 皆为完整的句子
     *
     * @param orgin             需要格式化的字符
     * @param formatFixedlength 需要格式化成的长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @param blocksplit        分隔符
     * @return
     */
    public abstract String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit);

    /**
     * 获得格式化的字符串并且截取到指定长度 不打断分割符的block 返回一个数组 0为可以放入的按照长度区分的 1为多余的 皆为完整的句子
     *
     * @param orgin             需要格式化的字符
     * @param formatFixedlength 需要格式化成的长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @return
     */
    public abstract String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth);
    /**
     * 获得符合条件的字符串 包括了识别换行符 以及内容自动换行 会进行相应的居中处理
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @param needcenter        是否需要居中处理
     * @param scalebeyond       缩放倍数
     * @return
     */
    public abstract String stringFormatFixedLengthTable(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, boolean needcenter, float scalebeyond);
    /**
     * 获得符合条件的字符串 包括了识别换行符 以及内容自动换行 会进行相应的居中处理
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @param needcenter        是否需要居中处理
     * @param scalebeyond       缩放倍数
     * @return
     */
    public abstract String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, boolean needcenter, float scalebeyond);

    /**
     * 获得符合条件的字符串 包括了识别换行符 以及内容自动换行 会进行相应的居中处理
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @param needcenter        是否需要居中处理
     * @return
     */
    public abstract String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, boolean needcenter);

    /**
     * 获得符合条件的字符串 包括了识别换行符 以及内容自动换行 会进行相应的居中处理
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @return
     */
    public abstract String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth);

    /**
     * 获得符合条件的字符串 包括了识别换行符 以及内容自动换行 会进行相应的居中处理
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     * @return
     */
    public abstract String stringFormatFixedLength(String orgin, float formatFixedlength, Font font);
    /**
     * 把字符串分割成2段一段适配长度的一段超出的
     * @param orgin  原始字符
     * @param formatFixedlength 需要适配的长度
     * @param font 字体
     * @param firstLineIndent 首行缩进（无用字段）
     * @param pagewidth    页宽（无用字段）
     * @param blocksplit   分割符（无用）
     * @param blockindent block头部空格（无用）
     * @return
     */
    public abstract String[] stringGetTwoBlockFitLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit, int blockindent);
    /**
     * 获得符合条件的字符串 包括了识别换行符 以及内容自动换行 不进行居中处理
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @return
     */
    public abstract String stringFormatFixedLengthNoCenter(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth);

    /**
     * 获得符合条件的字符串 包括了识别换行符 以及内容自动换行-用于表格
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     */
    public abstract String stringFormatFixedTableLength(String orgin, float formatFixedlength, Font font);

    /**
     * 当文字确实超出时 需求又是将文字缩小以放入长度区间
     *
     * @param orgin             字符串
     * @param formatFixedlength 需要格式化的最终长度
     * @param font              字体
     * @param firstLineIndent   首行缩进
     * @param pagewidth         页面宽度
     * @return
     */
    public abstract float getScaleSizeOfMatchOrginIfBeyond(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth);
}
