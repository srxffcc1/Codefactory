package com.wisdomregulation.pdflink;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 主要是对字符串进行处理修正的类 6月22日修改成接口模式 增加ln型方法的增加block中前置缩进问题
 * 6月26日修改SpaceSize得bug
 * 2018-6-27 预增加字体缩小技术来适配超过得部分
 */
public class StringFactory extends AbstractStringFactory {
    public float pagewidthorg = 409.5f;

    enum TimeType {
        Long, Chinese, Normal;
    }

    @Override
    public float getStringLength(String orgstring, Font font) {//验证过
        Chunk phrase = new Chunk(orgstring, font);
        float result = 0;
        List<Chunk> mArrayList = phrase.getChunks();
        for (int i = 0; i < mArrayList.size(); i++) {
            float everyblock = ((Chunk) (mArrayList.get(i))).getWidthPoint();
            result = result + everyblock;
        }
        return result;
    }

    @Override
    public String getTime(String time, int index) {//验证过
        String result = "";
        String orgfm = getTime(time);
        if (orgfm != null && !"".equals(orgfm)) {
            String[] times = orgfm.split("-");
            if (times.length > index) {
                result = times[index].trim();
            } else {
                result = " ";
            }
        }
        return result;
    }

    @Override
    public String getTime(String time) {//格式化任意时间格式yyyy-MM-dd-HH-mm-ss 验证过
        String resulttime = "";
        if (time == null || time.equals("")) {//如果为空
            resulttime = "";
        } else {
            resulttime = getTimeUseNormalFormat(time, resulttime);
            resulttime = getTimeUseChineseFormat(time, resulttime);
            resulttime = getTimeUse_Format(time, resulttime);
        }

        return resulttime;
    }

    private String getTimeUse_Format(String time, String resulttime) {
        try {//如果本身就是-号形式的格式化
            if (time.matches("(.+)-(.*)")) {
                if (time.matches("(.+) (.*)")) {
                    String[] headresultarray = time.split(" ");
                    String headresult = "";
                    if (headresultarray.length < 1) {
                        headresult = time;
                    } else {
                        if (time.matches("(.+) (.*)")) {
                            headresult = time.split(" ")[0];
                        } else {
                            time = time + " 00:00:00";
                            headresult = time.split(" ")[0];
                        }

                    }
                    String bodyresult = "";
                    String body = time.split(" ")[1];
                    String[] bodysplit = new String[3];
                    String[] bodysplit2 = body.split(":");
                    for (int i = 0; i < bodysplit2.length; i++) {
                        String tmp = body.split(":")[i].trim();
                        if (tmp == null || tmp.equals("") || tmp.equals("null")) {
                            bodysplit[i] = "00";
                        } else {
                            bodysplit[i] = tmp;
                        }

                    }
                    for (int i = 0; i < bodysplit.length; i++) {
                        bodyresult = bodyresult
                                + (bodysplit[i] != null ? bodysplit[i] : "00")
                                + "-";
                    }
                    if (bodyresult != null && bodyresult.length() > 0) {
                        bodyresult = bodyresult.substring(0,
                                bodyresult.length() - 1);
                    }
                    resulttime = headresult + "-" + bodyresult;
                } else {
                    String[] newtime = time.split("-");
                    String[] resultarray = new String[6];
                    for (int i = 0; i < resultarray.length; i++) {
                        if (newtime.length > i) {
                            resultarray[i] = newtime[i];
                        } else {
                            resultarray[i] = "00";
                        }
                        resulttime = resulttime + resultarray[i] + "-";
                    }
                    resulttime = resulttime.substring(0, resulttime.length() - 1);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return resulttime;
    }

    private String getTimeUseChineseFormat(String time, String resulttime) {
        try {//尝试用年月日时分秒中文来匹配
            if (time.matches("(.*年.*)|(.*月.*)|(.*日.*)|(.*时.*)|(.*分.*)|(.*秒.*)")) {
                char[] timearray = time.toCharArray();
                String nian = "";
                String yue = "";
                String ri = "";
                String shi = "";
                String fen = "";
                String miao = "";
                int start = 0;
                int end = 0;
                for (int i = 0; i < timearray.length; i++) {
                    if (Character.isDigit(timearray[i])) {

                    } else {
                        end = i;
                        try {
                            if (timearray[i] == '年') {
                                nian = time.substring(start, end);
                            }
                            if (timearray[i] == '月') {
                                yue = time.substring(start, end);

                            }
                            if (timearray[i] == '日') {
                                ri = time.substring(start, end);

                            }
                            if (timearray[i] == '时') {
                                shi = time.substring(start, end);

                            }
                            if (timearray[i] == '分') {
                                fen = time.substring(start, end);

                            }
                            if (timearray[i] == '秒') {
                                miao = time.substring(start, end);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        start = i + 1;
                    }
                }
                resulttime = nian + "-" + yue + "-" + ri + "-" + shi + "-" + fen + "-" + miao;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return resulttime;
    }

    private String getTimeUseNormalFormat(String time, String resulttime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        try {//尝试用long来解析字符串
            long longs = Long.parseLong(time);
            Date date = new Date();
            date.setTime(longs);
            resulttime = sdf.format(date).toString();
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return resulttime;
    }

    @Override
    public float formatlength(float fixlength, Font font) {//验证过
        float result = 0;
        if (fixlength % font.getSize() == 0) {
            result = fixlength;
        } else {
            float num = fixlength / font.getSize();
            result = num * font.getSize();
        }
        return result;
    }

    public String stringFormatSpaceHeadAndLastInTable(String orgin, float formatFixedlength, Font font) {
        PdfFactoryLog.println("居中文字:"+orgin+"\n"+"需要长度:"+formatFixedlength);
        StringBuilder endStringBulider = new StringBuilder();
        float nowlength = getStringLength(orgin, font);//计算当前占位
        if (nowlength < formatFixedlength) {
            int[] needarray = getSpaceJustLength(formatFixedlength - nowlength, font);//获得距离的空格
            PdfFactoryLog.println("居中前后补位"+needarray[0]+":"+needarray[1]);
            endStringBulider.append(getSpaceSize(needarray[0], font));//当小于时补齐末尾空格
            endStringBulider.append(orgin);
            endStringBulider.append(getSpaceSize(needarray[1], font));//当小于时补齐末尾空格
        } else {
            endStringBulider.append(orgin);
        }
//        endStringBulider.append('\u00a0');////不间断空格/不换行空格
        PdfFactoryLog.println("居中结果:"+endStringBulider.toString()+"&&&&&&&"+"居中后长度:"+getStringLength(endStringBulider.toString(),font));
        return endStringBulider.toString();
    }
    public String stringFormatSpaceLastInTable(String orgin, float formatFixedlength, Font font) {
        StringBuilder endStringBulider = new StringBuilder();
        endStringBulider.append(orgin);
        float nowlength = getStringLength(orgin, font);//计算当前占位
        if (nowlength < formatFixedlength) {//用1/2个字符长度来减少计算误差
            endStringBulider.append(getSpaceLength(formatFixedlength - nowlength, font));//当小于时补齐末尾空格
            endStringBulider.append('\u00a0');////不间断空格/不换行空格
        }
        return endStringBulider.toString();
    }


    @Override
    public String stringFormatSpaceHeadAndLast(String orgin, float formatFixedlength, Font font) {
        PdfFactoryLog.println("居中文字:"+orgin+"\n"+"需要长度:"+formatFixedlength);
        StringBuilder endStringBulider = new StringBuilder();
        float nowlength = getStringLength(orgin, font);//计算当前占位
        if (nowlength < formatFixedlength) {
            int[] needarray = getSpaceJustLength(formatFixedlength - nowlength, font);//获得距离的空格
            PdfFactoryLog.println("居中前后补位"+needarray[0]+":"+needarray[1]);
            endStringBulider.append(getSpaceSize(needarray[0], font));//当小于时补齐末尾空格
            endStringBulider.append(orgin);
            endStringBulider.append(getSpaceSize(needarray[1], font));//当小于时补齐末尾空格
        } else {
            endStringBulider.append(orgin);
        }
//        endStringBulider.append('\u00a0');////不间断空格/不换行空格
        PdfFactoryLog.println("居中结果:"+endStringBulider.toString()+"&&&&&&&"+"居中后长度:"+getStringLength(endStringBulider.toString(),font));
        return endStringBulider.toString();
    }
    @Override
    public String stringFormatSpaceLast(String orgin, float formatFixedlength, Font font) {
        StringBuilder endStringBulider = new StringBuilder();
        endStringBulider.append(orgin);
        float nowlength = getStringLength(orgin, font);//计算当前占位
        if (nowlength < formatFixedlength) {//用1/2个字符长度来减少计算误差
            endStringBulider.append(getSpaceLength(formatFixedlength - nowlength, font));//当小于时补齐末尾空格
//            endStringBulider.append('\u00a0');////不间断空格/不换行空格
        }
        return endStringBulider.toString();
    }


    @Override
    public String stringFormatIdentifyLn(String orgin, Font font, float firstLineIndent, float pagewidth, boolean nolastspace) {
        if (pagewidth == -1) {
            pagewidth = pagewidthorg;
        }
        String endstring = "";
        pagewidth = formatlength(pagewidth, font);
        firstLineIndent = formatlength(firstLineIndent, font);
        StringBuilder endStringBuilder = new StringBuilder();
        boolean needspecualfirst = false;//需要对首行进行特殊处理
        if (firstLineIndent > 0) {//修改这里判断是否要首行缩进
            needspecualfirst = true;
        }
        String[] orginarray = orgin.split("\n");//进行一次分割 将原始字符串中按照原始字符串中的换行符进行分割出block
        try {
            int specialchecktime = 0;//区分首行
            if (orginarray.length < 1) {
                endStringBuilder.append(orgin);
            }
            for (int i = 0; i < orginarray.length; i++) {
                if (needspecualfirst && specialchecktime == 0) {
                    specialchecktime = 1;
                    endStringBuilder.append(stringFormatWrap(orginarray[i], font, firstLineIndent, pagewidth, nolastspace));//对block进行format
                } else {
                    endStringBuilder.append(stringFormatWrap(orginarray[i], font, 0, pagewidth, nolastspace));//对block进行format
                }

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        endstring = endStringBuilder.toString();//
        if (endstring.endsWith(" \n")){//如果最后有空格可以进行去掉  注释掉暂时不这么处理
            endstring=endstring.substring(0,endstring.length()-2);
        }
//        while(endstring.endsWith(" ")){     2018 8 22日发现末尾空格不需要去掉
//            endstring=endstring.substring(0,endstring.length()-1);}
        return endstring;
    }
    @Override
    public String stringFormatWrap(String orgin, Font font, float firstLineIndent, float pagewidth, boolean nolastspace) {
        if (pagewidth == -1) {
            pagewidth = pagewidthorg;
        }
        pagewidth = formatlength(pagewidth, font);
        firstLineIndent = formatlength(firstLineIndent, font);
        StringBuilder endStringBuilder = new StringBuilder();
        try {
            char[] orginChars = orgin.toCharArray();
            int firstLineIndenttime = 0;//首行缩进次数

            StringBuilder blockbuilder = new StringBuilder();

            for (int i = 0; i < orginChars.length; i++) {
                blockbuilder.append(orginChars[i]);
                String tmpblock = blockbuilder.toString();
                float sumwidth = getStringLength(tmpblock, font);
                if (firstLineIndent > 0 && firstLineIndenttime == 0) {//说明需要首行缩进
                    if (sumwidth >= pagewidth - firstLineIndent) {//说明要换行了
                        endStringBuilder.append(blockbuilder.toString() + "\n");
                        firstLineIndenttime = 1;//确认进行过首行缩进的换行操作了
                        blockbuilder.delete(0, blockbuilder.length());//清空builder
                    }
                } else {
                    if (sumwidth >= pagewidth) {//说明要换行了
                        endStringBuilder.append(blockbuilder.toString() + "\n");
                        blockbuilder.delete(0, blockbuilder.length());//清空builder
                    }
                }
            }
            if (blockbuilder.length() > 0) {//说明最终还残留字符串 可能是一开始就没满（即首行缩进） 可能是最后的没满（即无缩进段落）
                if (firstLineIndenttime == 0) {//说明还没进行过首行缩进 1.情况为需要首行缩进但是字数没没满要求 2.不需要首行缩进的段落
                    if (firstLineIndent > 0) {//说明是首行缩进的段落
                        endStringBuilder.append(blockbuilder.toString() + (nolastspace ? "" : getSpaceLength(pagewidth - firstLineIndent - getStringLength(blockbuilder.toString(), font), font)) + "\n");//加上减去首行缩进的空格
                    } else {
                        endStringBuilder.append(blockbuilder.toString() + (nolastspace ? "" : getSpaceLength(pagewidth - getStringLength(blockbuilder.toString(), font), font)) + "\n");//加上缩进的空格
                    }
                } else {
                    if (firstLineIndent > 0) {//说明进行过首行缩进
                        endStringBuilder.append(blockbuilder.toString() + (nolastspace ? "" : getSpaceLength(pagewidth - getStringLength(blockbuilder.toString(), font), font)) + "\n");//加上缩进的空格

                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = endStringBuilder.toString();
        while (result.endsWith("\n")) {
            result = result.substring(0, result.length() - 1);
        }
        if (result.length() > 1) {
            result = result + "\n";
        }
        return result;
    }
    @Override
    public int[] getSpaceJustLength(float formatFixedlength, Font font) {
        int[] resultarray = new int[]{0, 0};//一个长度为2的数字 分别存放算出来的前后格子数量
        if (formatFixedlength < 0) {
            return resultarray;
        }
        int spacesize = 0;
        StringBuilder builder = new StringBuilder();
        while (getStringLength( builder.append(" ").toString(), font) < formatFixedlength) {//存在多加一次的可能性
            spacesize++;
        }
        int first = spacesize / 2;
        int second = spacesize - first;
        resultarray[0] = first;
        resultarray[1] = second;
        return resultarray;
    }

    public String getSpaceSize(float size, Font font) {
        return getSpaceLength(size*getStringLength(" ",font),font);
    }

    @Override
    public String getSpaceLength(float formatFixedlength, Font font) {
        if (formatFixedlength < getStringLength(" ", font)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        while (formatFixedlength-getStringLength(builder.toString(), font) >= (getStringLength(" ", font)-0.0001)) {//2018 8 22 修复 使用减法和空格站位比较进行更加精确的计算 0.0001作为精度校准
            builder.append(" ");
        }
        PdfFactoryLog.println("空格长度:"+getStringLength(builder.toString(),font)+";"+"需要长度:"+formatFixedlength);
        return builder.toString();
    }

    @Override
    public String[] stringFormatIdentifySplit(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String splitmask) {
        String[] orgarray = orgin.split(splitmask);
        String[] resultarray = new String[2];
        formatFixedlength = formatlength(formatFixedlength, font);
        float sum = 0;
        String result1 = "";//可以允许放入的完整字符 即 末尾按照分割符结束
        String result2 = "";//多余的字符串 可能要另起一页
        int resultindex = orgarray.length;
        for (int i = 0; i < orgarray.length; i++) {
            sum = sum + getStringLength(orgarray[i] + ";", font);
            if (sum > formatFixedlength) {
                resultindex = i;
                break;
            } else {
                if (sum == formatFixedlength) {
                    resultindex = i + 1;
                    break;
                } else {

                }
            }
        }
        for (int i = 0; i < resultindex; i++) {
            result1 = result1 + orgarray[i] + ";";
        }
        if (result1.length() > 1) {
            result1 = result1.substring(0, result1.length() - 1);
        }
        for (int i = resultindex; i < orgarray.length; i++) {
            result2 = result2 + orgarray[i] + ";";
        }
        if (result2.length() > 1) {
            result2 = result2.substring(0, result2.length() - 1);
        }
        resultarray[0] = result1;
        resultarray[1] = result2;
        return resultarray;
    }
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
    public String[] stringGetTwoBlockFitLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit, int blockindent){
        String[] resultarray = new String[2];//数组
        resultarray[0]="";
        resultarray[1]="";
        char[] orgarray=orgin.toCharArray();
        for(int i=0;i<orgarray.length;i++){
            float firstblocklength=getStringLength(resultarray[0]+orgarray[i],font);
            if(firstblocklength>formatFixedlength){
                resultarray[1]=resultarray[1]+orgarray[i];
            }else{
                resultarray[0]=resultarray[0]+orgarray[i];
            }
        }
        return resultarray;
    }
    @Override
    public String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit, int blockindent,boolean needlastsplit) {
        if (pagewidth == -1) {
            pagewidth = pagewidthorg;
        }
        String[] resultarray = new String[3];//最后一个带出序列
        String numberstring = "";
        String firststring = "";
        String secondstring = "";
        formatFixedlength = formatlength(formatFixedlength, font);
        pagewidth = formatlength(pagewidth, font);
        firstLineIndent = formatlength(firstLineIndent, font);
        StringBuilder firststringbuildertmp = new StringBuilder();//辅助计算长度的builder 会直接先进行计算已经填充的长度 再判断是不是要继续累加
        StringBuilder firststringbuilder = new StringBuilder();
        StringBuilder secondstringbuilder = new StringBuilder();

        PdfFactoryLog.println("----------------------------------------");
        String[] orginarray = orgin.split(blocksplit);
        if (blockindent == 0||blockindent==-2) {//对block进行首行格式化0则原始数据进入

        } else if (blockindent == -1) {//进行trim操作
            for (int i = 0; i < orginarray.length; i++) {
                orginarray[i] = orginarray[i].trim();
            }
        } else {//对block进行缩进操作
            for (int i = 0; i < orginarray.length; i++) {
                orginarray[i] = getSpaceLength(blockindent * font.getSize(), font) + orginarray[i].trim();
            }
        }
        try {
            int firstLineIndenttime = 0;//区分首行
            if (orginarray.length < 1) {//说明没有内容是空的 直接返回原始空字符串
                firststringbuilder.append(orgin);
//                firststringbuilder.append('\n');
                firststringbuildertmp.append(orgin);
//                firststringbuildertmp.append('\n');
            }
            boolean ismore = false;//判断是否累加超出
            for (int i = 0; i < orginarray.length; i++) {//for循环block
                String orgintmp = orginarray[i];
                String blockformattmp;
                if (firstLineIndent > 0 && firstLineIndenttime == 0) {//判断是否要首行缩进 获得block格式化过的值 即对block进行一次空格补足
                    blockformattmp = stringFormatWrap(orgintmp, font, firstLineIndent, pagewidth, false);
                } else {
                    blockformattmp = stringFormatWrap(orgintmp, font, 0, pagewidth, false);
                }
                firstLineIndenttime = 1;
                if (ismore) {//如果已经累加超出了就把这次block直接加到结果里
                    secondstringbuilder.append(orgintmp + "\n");//把原始的东西加入二号位
                } else {
                    if (getStringLength(firststringbuildertmp.toString() + blockformattmp, font) <= formatFixedlength) {//说明累加起来这以句之后长度还没超过
                        firststringbuildertmp.append(blockformattmp);//tmp是用来测量的
                        String odtmp = orgintmp + "\n";
                        Pattern pattern = Pattern.compile(".*?(\\d+).*");
                        Matcher matcher = pattern.matcher(odtmp);//用来匹配数字
                        if (matcher.find()) {
                            numberstring = numberstring + matcher.group(1) + ",";
                        }
                        if(blockindent==-2){
                            firststringbuilder.append(blockformattmp);//说明不是用于前期的探测阶段 已经正式打印到document上则加入换行符进行格式化
                        }else {
                            firststringbuilder.append(odtmp);//返回原始字符串 因为是块形式的最好返回原始字符
                        }
                    } else {
                        if (!ismore && getStringLength(firststringbuildertmp.toString() + orgintmp, font) <= formatFixedlength) {//追加判断一次因为已经超出了 所以肯定是当前占位里的最后一块 判断一次是不是不补足空格最后一个block是可以放的
                            firststringbuildertmp.append(blockformattmp);
                            String odtmp = orgintmp + "\n";
                            Pattern pattern = Pattern.compile(".*?(\\d+).*");
                            Matcher matcher = pattern.matcher(odtmp);//用来匹配数字
                            if (matcher.find()) {
                                numberstring = numberstring + matcher.group(1) + ",";
                            }
                            firststringbuilder.append(odtmp);//此处把原始数据放进去 不包含空格了
                        } else {//断句
                            if(needlastsplit){
                                String[] arrayenoughtandextra=stringGetTwoBlockFitLength(orgintmp,formatFixedlength-getStringLength(firststringbuildertmp.toString(), font),font,firstLineIndent,pagewidth,blocksplit,blockindent);
                                firststringbuilder.append(arrayenoughtandextra[0]);
                                secondstringbuilder.append(arrayenoughtandextra[1] + "\n");//原数据放入second 此处放原数据或者blocktmp都是可以的
                            }else{

                                secondstringbuilder.append(orgintmp + "\n");//原数据放入second 此处放原数据或者blocktmp都是可以的
                            }



                        }
                        ismore = true;
                    }
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        firststring = firststringbuilder.toString();
        secondstring = secondstringbuilder.toString();

        if ("".equals(resultarray[0])) {
            secondstring = orgin;
        } else {

        }
        {//作用是去掉最后一个的多出来的空格和换行
            while (firststring.endsWith("\n")) {
                firststring = firststring.substring(0, firststring.length() - 1);
            }
            firststring = firststring;
            while (secondstring.endsWith("\n")) {
                secondstring = secondstring.substring(0, secondstring.length() - 1);
            }
        }
        secondstring = secondstring;
        PdfFactoryLog.println("原始数据\n" + orgin);
        PdfFactoryLog.println("存的下的格式化数据----------------------------------------");
        PdfFactoryLog.println(firststring);
        PdfFactoryLog.println("存不下的格式化数据----------------------------------------");
        PdfFactoryLog.println(secondstring);
        resultarray[0] = firststring;
        if ("".equals(resultarray[0])) {
            resultarray[1] = secondstring;
        } else {
            resultarray[1] = secondstring;
        }
        resultarray[2] = numberstring.length() > 1 ? numberstring.substring(0, numberstring.length() - 1) : numberstring;
        PdfFactoryLog.println(resultarray[2]);
        PdfFactoryLog.println("数据终止----------------------------------------");
        return resultarray;
    }

    public String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, int blockindent) {
        return stringFormatIdentifyLnAndKeepLn(orgin, formatFixedlength, font, firstLineIndent, pagewidth, "\n", blockindent,false);
    }

    public String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit) {
        return stringFormatIdentifyLnAndKeepLn(orgin, formatFixedlength, font, firstLineIndent, pagewidth, "\n", 0,false);
    }



    public String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
        return stringFormatIdentifyLnAndKeepLn(orgin, formatFixedlength, font, firstLineIndent, pagewidth, -1);
    }

    @Override
    public String stringFormatFixedLengthTable(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, boolean need, float scalebeyond) {
        PdfFactoryLog.println("看看每次的字体大小"+font.getSize());
        if (pagewidth == -1) {
            pagewidth = pagewidthorg;
        }
        String endString;
        if (formatFixedlength == -1) {//待验证 -1时对长度不处理 只进行格式化
            endString = stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, true);//获得已经2阶格式化的字符串

        } else {

            StringBuilder endStringBulider = new StringBuilder();
            formatFixedlength = formatlength(formatFixedlength, font);
            firstLineIndent = formatlength(firstLineIndent, font);
            pagewidth = formatlength(pagewidth, font);
            if(scalebeyond>1f){//才需要去做这个缩放操作
                PdfFactoryLog.println("需要缩放");
                float scaletmp=getScaleSizeOfMatchOrginIfBeyond(orgin,formatFixedlength,font,firstLineIndent,pagewidth);
                PdfFactoryLog.println("缩放规格:"+scaletmp);
                if(scaletmp<scalebeyond&&scaletmp>1f){//说明需要缩放
                    //此处需要修改字体尺寸
                    float orgscale=font.getSize();
                    float needscale=(int)(orgscale/scaletmp);
                    PdfFactoryLog.println(orgscale+"到缩放字体:"+needscale);
                    font.setSize(needscale);
                    String orgresult=stringFormatFixedLengthTable(orgin,formatFixedlength,font,firstLineIndent,pagewidth,need,scalebeyond);
                    font.setSize(orgscale);
                    return orgresult;
                }else{
                    PdfFactoryLog.println("超过了还是没超过:"+scaletmp);
                }
            }
            StringBuilder orgbuilder = new StringBuilder();
            float orginrenderlength = getStringLength(orgin, font);
            boolean needcenter = false;
            if (orginrenderlength < formatFixedlength) {//当小于时才会考虑进行格式化 如果不小于
                if (formatFixedlength <= pagewidth) {//说明不存在换行啊 直接添加特定的空格就行
                    if ("".equals(orgin)||!need) {//说明空字符那就不要居中了
                        endStringBulider.append(stringFormatSpaceLastInTable(orgin, formatFixedlength, font));//修改成需要居中的
                        needcenter = false;
                    } else {
                        PdfFactoryLog.println("打印出：居中内容" + orgin + "@");
                        endStringBulider.append(stringFormatSpaceHeadAndLastInTable(orgin, formatFixedlength, font));//修改成需要居中的
                        needcenter = true;
                    }
                } else {
                    String formatstringfirst = stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, false);//获得已经2阶格式化的字符串

                    PdfFactoryLog.println("已经二阶:"+formatstringfirst);
                    float formatstringfirstlengtht = getStringLength(formatstringfirst, font);
                    if (formatFixedlength >= formatstringfirstlengtht) {
                        endStringBulider.append(stringFormatSpaceLastInTable(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
                    } else {//追加判断去掉末尾的空格之后再进行判断
                        while (formatstringfirst.endsWith("\n")) {
                            formatstringfirst = formatstringfirst.substring(0, formatstringfirst.length() - 1);
                        }
                        PdfFactoryLog.println("trim前长度" + formatstringfirst.length());
                        PdfFactoryLog.println("trim前长度" + formatstringfirst);
                        formatstringfirst = formatstringfirst;
                        PdfFactoryLog.println("trim后长度" + formatstringfirst.length());
                        PdfFactoryLog.println("trim后长度" + formatstringfirst);
                        formatstringfirstlengtht = getStringLength(formatstringfirst, font);
                        if (formatFixedlength >= formatstringfirstlengtht) {
                            endStringBulider.append(stringFormatSpaceLastInTable(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
                        } else {
                            endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin, formatFixedlength, font, firstLineIndent, pagewidth, "\n", -2,true)[0]);//获得不超过的部分 进行智能打印
                        }
                    }
                }
            } else {
                endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin, formatFixedlength, font, firstLineIndent, pagewidth,"\n", -2,true)[0]);//获得不超过的部分 进行智能打印
            }
            endString = endStringBulider.toString();
            if (needcenter&&need) {//说明是单行的 需要进行居2次补位的居中处理
                endString = stringFormatSpaceHeadAndLastInTable(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
            } else {
                endString = stringFormatSpaceLastInTable(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
            }
            endString = stringFormatSpaceLastInTable(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
            if (getStringLength(endString, font) > pagewidth - firstLineIndent) {//说明存在换行需要
                endString = stringFormatIdentifyLn(endString, font, firstLineIndent, pagewidth, true);//最后在补齐空格之后在来一次格式化 不对末尾空格进行增加
            }
            while (endString.endsWith("\n")) {
                endString = endString.substring(0, endString.length() - 1);
            }

        }
        PdfFactoryLog.println("*************************************");
        PdfFactoryLog.println("字符串长度-"+getStringLength(endString, font) + "：需求-" + formatFixedlength + "：原始字符串" + orgin + "***");
        PdfFactoryLog.println("*******" + endString + "*******");
        PdfFactoryLog.println("*************************************");
        return endString;
    }

    @Override
    public String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, boolean need,float scalebeyond) {
        PdfFactoryLog.println("看看每次的字体大小"+font.getSize());
        if(formatFixedlength<0){//用来字多长就多长
            return orgin;
        }
        if (pagewidth == -1) {
            pagewidth = pagewidthorg;
        }
        String endString;
        if (formatFixedlength == -1) {//待验证 -1时对长度不处理 只进行格式化
            endString = stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, true);//获得已经2阶格式化的字符串

        } else {

            StringBuilder endStringBulider = new StringBuilder();
            formatFixedlength = formatlength(formatFixedlength, font);
            firstLineIndent = formatlength(firstLineIndent, font);
            pagewidth = formatlength(pagewidth, font);
            if(scalebeyond>1f){//才需要去做这个缩放操作
                PdfFactoryLog.println("需要缩放");
                float scaletmp=getScaleSizeOfMatchOrginIfBeyond(orgin,formatFixedlength,font,firstLineIndent,pagewidth);
                PdfFactoryLog.println("缩放规格:"+scaletmp);
                if(scaletmp<scalebeyond&&scaletmp>1f){//说明需要缩放
                    //此处需要修改字体尺寸
                    float orgscale=font.getSize();
                    float needscale=(int)(orgscale/scaletmp);
                    PdfFactoryLog.println(orgscale+"到缩放字体:"+needscale);
                    font.setSize(needscale);
                    String orgresult=stringFormatFixedLength(orgin,formatFixedlength,font,firstLineIndent,pagewidth,need);
                    font.setSize(orgscale);
                    return orgresult;
                }else{
                    PdfFactoryLog.println("超过了还是没超过:"+scaletmp);
                }
            }
            StringBuilder orgbuilder = new StringBuilder();
            float orginrenderlength = getStringLength(orgin, font);
            boolean needcenter = false;
            if (orginrenderlength < formatFixedlength) {//当小于时才会考虑进行格式化 如果不小于
                if (formatFixedlength <= pagewidth) {//说明不存在换行啊 直接添加特定的空格就行
                    if ("".equals(orgin)||!need) {//说明空字符那就不要居中了
                        endStringBulider.append(stringFormatSpaceLast(orgin, formatFixedlength, font));//修改成需要居中的
                        needcenter = false;
                    } else {
                        PdfFactoryLog.println("打印出：居中内容" + orgin + "@");
                        endStringBulider.append(stringFormatSpaceHeadAndLast(orgin, formatFixedlength, font));//修改成需要居中的
                        needcenter = true;
                    }
                } else {
                    String formatstringfirst = stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, false);//获得已经2阶格式化的字符串

                    PdfFactoryLog.println("已经二阶:"+formatstringfirst);
                    float formatstringfirstlengtht = getStringLength(formatstringfirst, font);
                    if (formatFixedlength >= formatstringfirstlengtht) {
                        endStringBulider.append(stringFormatSpaceLast(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
                    } else {//追加判断去掉末尾的空格之后再进行判断
                        while (formatstringfirst.endsWith("\n")) {
                            formatstringfirst = formatstringfirst.substring(0, formatstringfirst.length() - 1);
                        }
                        PdfFactoryLog.println("trim前长度" + formatstringfirst.length());
                        PdfFactoryLog.println("trim前长度" + formatstringfirst);
                        formatstringfirst = formatstringfirst;
                        PdfFactoryLog.println("trim后长度" + formatstringfirst.length());
                        PdfFactoryLog.println("trim后长度" + formatstringfirst);
                        formatstringfirstlengtht = getStringLength(formatstringfirst, font);
                        if (formatFixedlength >= formatstringfirstlengtht) {
                            endStringBulider.append(stringFormatSpaceLast(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
                        } else {
                            endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin, formatFixedlength, font, firstLineIndent, pagewidth, "\n", -2,true)[0]);//获得不超过的部分 进行智能打印
                        }
                    }
                }
            } else {
                endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin, formatFixedlength, font, firstLineIndent, pagewidth,"\n", -2,true)[0]);//获得不超过的部分 进行智能打印
            }
            endString = endStringBulider.toString();
            PdfFactoryLog.println("0字符串长度-"+getStringLength(endString, font) + "：需求-" + formatFixedlength + "：原始字符串" + orgin + "***");
            if (needcenter&&need) {//说明是单行的 需要进行居2次补位的居中处理
                endString = stringFormatSpaceHeadAndLast(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
            } else {
                endString = stringFormatSpaceLast(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
            }
            endString = stringFormatSpaceLast(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
            PdfFactoryLog.println("1字符串长度-"+getStringLength(endString, font) + "：需求-" + formatFixedlength + "：原始字符串" + orgin + "***");
            if (getStringLength(endString, font) > pagewidth - firstLineIndent) {//说明存在换行需要
                endString = stringFormatIdentifyLn(endString, font, firstLineIndent, pagewidth, true);//最后在补齐空格之后在来一次格式化 不对末尾空格进行增加
                PdfFactoryLog.println("2字符串长度-"+getStringLength(endString, font) + "：需求-" + formatFixedlength + "：原始字符串" + orgin + "***");
            }
            while (endString.endsWith("\n")) {
                endString = endString.substring(0, endString.length() - 1);
            }

        }
        PdfFactoryLog.println("*************************************");
        PdfFactoryLog.println("3字符串长度-"+getStringLength(endString, font) + "：需求-" + formatFixedlength + "：原始字符串" + orgin + "***");
        PdfFactoryLog.println("*******" + endString + "*******");
        PdfFactoryLog.println("*************************************");
        return endString;
    }
    public String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, boolean need) {
        return stringFormatFixedLength(orgin,formatFixedlength,font,firstLineIndent,pagewidth,need,1f);
    }

    public String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
        return stringFormatFixedLength(orgin,formatFixedlength,font,firstLineIndent,pagewidth,true);
    }

    public String stringFormatFixedLengthNoCenter(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
        return stringFormatFixedLength(orgin,formatFixedlength,font,firstLineIndent,pagewidth,false);
    }


    public String stringFormatFixedTableLength(String orgin, float formatFixedlength, Font font) {
        return stringFormatFixedLength(orgin, formatFixedlength, font, 0, -1);
    }

    @Override
    public float getScaleSizeOfMatchOrginIfBeyond(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
//        String formatstring=stringFormatIdentifyLn(orgin,font,firstLineIndent,pagewidth,false);//获得简单格式化之后
        float orglength=getStringLength(orgin,font);//获得用font格式化之后的总长度
        if(orglength>formatFixedlength){//发现原始字符在字体加持下长度大于空间长度 此时需要进行改造

            int orgsize=orgin.toCharArray().length;//大约得出多少个字符 都按照中文字符大小来计算
            float everyblocklength=formatFixedlength/orgsize;//获得粗算的缩放后的字体大小
            float fontsize=font.getSize();
            float result=fontsize/everyblocklength;
            return result/10*8;//按照0.8来调整误差 可能造成error
        }
        return 0;
    }


    public String stringFormatFixedLength(String orgin, float formatFixedlength, Font font) {
        return stringFormatFixedLength(orgin, formatFixedlength, font, 0, -1);
    }
}
