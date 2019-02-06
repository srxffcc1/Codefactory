//package com.wisdomregulation.pdflink;
//
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Font;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
//@Deprecated
//public class StringFactoryOrg2018621 extends AbstractStringFactory {
//    public  float pagewidthorg = 409.5f;
//
//    enum TimeType {
//        Long, Chinese, Normal;
//    }
//
//
//    public  float getStringLength(String orgstring, Font font) {
//        Chunk phrase = new Chunk(orgstring, font);
//        float result = 0;
//        List<Chunk> mArrayList = phrase.getChunks();
//        for (int i = 0; i < mArrayList.size(); i++) {
//            float everyblock = ((Chunk) (mArrayList.get(i))).getWidthPoint();
//            result = result + everyblock;
//        }
//        return result;
//    }
//
//
//    public  String getTime(String time, int index) {
////        //PdfFactoryLog.println(time+":"+index);
//        String result = "";
//        String orgfm = getTime(time);
////        //PdfFactoryLog.println("time:"+orgfm);
//        if (orgfm != null && !"".equals(orgfm)) {
//            String[] times = orgfm.split("-");
//            if (times.length > index) {
//                result = times[index].trim();
//            } else {
//                result = " ";
//            }
//        }
////        //PdfFactoryLog.println("返回时间"+result);
//        return result;
//    }
//
//
//    public  String getTime(String time) {//格式化任意时间格式yyyy-MM-dd-HH-mm-ss
//        String resulttime = "";
//        if (time == null || time.equals("")) {//如果为空
////            //PdfFactoryLog.println("时间为空:"+time);
//            resulttime = "";
//        } else {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//            try {//尝试用long来解析字符串
//                long longs = Long.parseLong(time);
//                Date date = new Date();
//                date.setTime(longs);
//                resulttime = sdf.format(date).toString();
//            } catch (NumberFormatException e) {
////            e.printStackTrace();
//            }
//            try {//尝试用年月日时分秒中文来匹配
//                if (time.matches("(.*年.*)|(.*月.*)|(.*日.*)|(.*时.*)|(.*分.*)|(.*秒.*)")) {
//                    char[] timearray = time.toCharArray();
//                    String nian = "";
//                    String yue = "";
//                    String ri = "";
//                    String shi = "";
//                    String fen = "";
//                    String miao = "";
//                    int start = 0;
//                    int end = 0;
//                    for (int i = 0; i < timearray.length; i++) {
//                        if (Character.isDigit(timearray[i])) {
//
//                        } else {
//                            end = i;
//                            try {
//                                if (timearray[i] == '年') {
//                                    nian = time.substring(start, end);
//                                }
//                                if (timearray[i] == '月') {
//                                    yue = time.substring(start, end);
//
//                                }
//                                if (timearray[i] == '日') {
//                                    ri = time.substring(start, end);
//
//                                }
//                                if (timearray[i] == '时') {
//                                    shi = time.substring(start, end);
//
//                                }
//                                if (timearray[i] == '分') {
//                                    fen = time.substring(start, end);
//
//                                }
//                                if (timearray[i] == '秒') {
//                                    miao = time.substring(start, end);
//
//                                }
//                            } catch (Exception e) {
////                                //PdfFactoryLog.println("start:"+start+",end:"+end);
//                                e.printStackTrace();
//                            }
//                            start = i + 1;
//                        }
//                    }
//                    resulttime = nian + "-" + yue + "-" + ri + "-" + shi + "-" + fen + "-" + miao;
////                //PdfFactoryLog.println(nian+"年"+yue+"月"+ri+"日"+shi+"时"+fen+"分"+miao+"秒");
//                }
//
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//            try {//如果本身就是-号形式的格式化
//                if (time.matches("(.+)-(.*)")) {
//                    if (time.matches("(.+) (.*)")) {
//                        String[] headresultarray = time.split(" ");
//                        String headresult = "";
//                        if (headresultarray.length < 1) {
//                            headresult = time;
//                        } else {
//                            if (time.matches("(.+) (.*)")) {
//                                headresult = time.split(" ")[0];
//                            } else {
//                                time = time + " 00:00:00";
//                                headresult = time.split(" ")[0];
//                            }
//
//                        }
//
//                        String bodyresult = "";
//                        String body = time.split(" ")[1];
//                        String[] bodysplit = new String[3];
//                        String[] bodysplit2 = body.split(":");
//                        for (int i = 0; i < bodysplit2.length; i++) {
//                            String tmp = body.split(":")[i].trim();
//                            if (tmp == null || tmp.equals("") || tmp.equals("null")) {
//                                bodysplit[i] = "00";
//                            } else {
//                                bodysplit[i] = tmp;
//                            }
//
//                        }
//                        for (int i = 0; i < bodysplit.length; i++) {
//                            bodyresult = bodyresult
//                                    + (bodysplit[i] != null ? bodysplit[i] : "00")
//                                    + "-";
//                        }
//                        if (bodyresult != null && bodyresult.length() > 0) {
//                            bodyresult = bodyresult.substring(0,
//                                    bodyresult.length() - 1);
//                        }
//                        resulttime = headresult + "-" + bodyresult;
//                    } else {
//                        String[] newtime = time.split("-");
//                        String[] resultarray = new String[6];
//                        for (int i = 0; i < resultarray.length; i++) {
//                            if (newtime.length > i) {
//                                resultarray[i] = newtime[i];
//                            } else {
//                                resultarray[i] = "00";
//                            }
//                            resulttime = resulttime + resultarray[i] + "-";
//                        }
//
//                        resulttime = resulttime.substring(0, resulttime.length() - 1);
//                    }
//
//                }
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return resulttime;
//    }
//
//
//    public  float formatlength(float fixlength, Font font) {
//        float result = 0;
//        if (fixlength % font.getSize() == 0) {
//            result = fixlength;
//        } else {
//            float num = fixlength / font.getSize();
//            result = num * font.getSize();
//        }
//        return result;
//    }
//
//    public  String stringFormatSpaceHeadAndLast(String orgin, float formatFixedlength, Font font) {
//        StringBuilder endStringBulider = new StringBuilder();
//        float nowlength = getStringLength(orgin, font);//计算当前占位
//        if (nowlength < formatFixedlength) {
//            int[] needarray=getSpaceJustLength(formatFixedlength - nowlength, font);//获得距离的空格
//            PdfFactoryLog.println("居中前后补位"+needarray[0]+":"+needarray[1]);
//            endStringBulider.append(getSpaceSize(needarray[0], font));//当小于时补齐末尾空格
//            endStringBulider.append(orgin);
//            endStringBulider.append(getSpaceSize(needarray[1], font));//当小于时补齐末尾空格
//        }else{
//            endStringBulider.append(orgin);
//        }
//        endStringBulider.append('\u00a0');////不间断空格/不换行空格
//        return endStringBulider.toString();
//    }
//
//    public  String stringFormatSpaceLast(String orgin, float formatFixedlength, Font font) {
//        StringBuilder endStringBulider = new StringBuilder();
//        endStringBulider.append(orgin);
//        float nowlength = getStringLength(orgin, font);//计算当前占位
//        if (nowlength < formatFixedlength) {
//            endStringBulider.append(getSpaceLength(formatFixedlength - nowlength, font));//当小于时补齐末尾空格
//        }
//        endStringBulider.append('\u00a0');////不间断空格/不换行空格
//        return endStringBulider.toString();
//    }
//
//
//    public  String stringFormatIdentifyLn(String orgin, Font font, float firstLineIndent, float pagewidth, boolean nolastspace) {
//        if (pagewidth == -1) {
//            pagewidth = pagewidthorg;
//        }
//        String endstring = "";
//        pagewidth = formatlength(pagewidth, font);
//        firstLineIndent = formatlength(firstLineIndent, font);
//        StringBuilder endStringBuilder = new StringBuilder();
//        boolean needspecualfirst = false;//需要对首行进行特殊处理
//        if (firstLineIndent > 0) {//修改这里判断是否要首行缩进 待验证
//            needspecualfirst = true;
//        }
//        String[] orginarray = orgin.split("\n");//换行符不用转义
//        try {
//            int specialchecktime = 0;//区分首行
//            if (orginarray.length < 1) {
//                endStringBuilder.append(orgin);
//            }
//            for (int i = 0; i < orginarray.length; i++) {
//                if (needspecualfirst && specialchecktime == 0) {
//                    specialchecktime = 1;
//                    endStringBuilder.append(stringFormatWrap(orginarray[i], font, firstLineIndent, pagewidth, nolastspace));
//                } else {
//                    endStringBuilder.append(stringFormatWrap(orginarray[i], font, 0, pagewidth, nolastspace));
//                }
//
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        endstring = endStringBuilder.toString();
//
//        return endstring;
//    }
//
//
//    public  String stringFormatWrap(String orgin, Font font, float firstLineIndent, float pagewidth, boolean nolastspace) {
//        if (pagewidth == -1) {
//            pagewidth = pagewidthorg;
//        }
//        pagewidth = formatlength(pagewidth, font);
//        firstLineIndent = formatlength(firstLineIndent, font);
//        StringBuilder endStringBuilder = new StringBuilder();
//        String orginCharge = "";
//        try {
//            char[] orginChars = orgin.toCharArray();
//            int firstLineIndenttime = 0;//首行缩进次数
//
//            StringBuilder blockbuilder = new StringBuilder();
//
//            for (int i = 0; i < orginChars.length; i++) {
//                blockbuilder.append(orginChars[i]);
//                String tmpblock = blockbuilder.toString();
//                float sumwidth = getStringLength(tmpblock, font);
//                if (firstLineIndent > 0 && firstLineIndenttime == 0) {//说明需要首行缩进
//                    if (sumwidth >= pagewidth - firstLineIndent) {//说明要换行了
//                        endStringBuilder.append(blockbuilder.toString() + "\n");
//                        firstLineIndenttime = 1;//确认进行过首行缩进的换行操作了
//                        blockbuilder.delete(0, blockbuilder.length());//清空builder
//                    }
//                } else {
//                    if (sumwidth >= pagewidth) {//说明要换行了
//                        endStringBuilder.append(blockbuilder.toString() + "\n");
//                        blockbuilder.delete(0, blockbuilder.length());//清空builder
//                    }
//                }
//            }
//            if (blockbuilder.length() > 0) {//说明最终还残留字符串 可能是一开始就没满（即首行缩进） 可能是最后的没满（即无缩进段落）
//                if (firstLineIndenttime == 0) {//说明还没进行过首行缩进 1.情况为需要首行缩进但是字数没没满要求 2.不需要首行缩进的段落
//                    if (firstLineIndent > 0) {//说明是首行缩进的段落
//                        endStringBuilder.append(blockbuilder.toString() + (nolastspace ? "" : getSpaceLength(pagewidth - firstLineIndent - getStringLength(blockbuilder.toString(), font), font)) + "\n");//说明加上减去首行缩进的空格
//                    } else {
//                        endStringBuilder.append(blockbuilder.toString() + (nolastspace ? "" : getSpaceLength(pagewidth - getStringLength(blockbuilder.toString(), font), font)) + "\n");//说明加上缩进的空格
//                    }
//                } else {
//                    if (firstLineIndent > 0) {//说明进行过首行缩进
//                        endStringBuilder.append(blockbuilder.toString() + (nolastspace ? "" : getSpaceLength(pagewidth - getStringLength(blockbuilder.toString(), font), font)) + "\n");//说明加上缩进的空格
//
//                    }
//
//                }
//
//
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String result = endStringBuilder.toString();
//        while (result.endsWith("\n")) {
//            result = result.substring(0, result.length() - 1);
//        }
//        if (result.length() > 1) {
//            result = result + "\n";
//        }
//        return result;
//    }
//
//    public  int[] getSpaceJustLength(float formatFixedlength, Font font) {
//        int[] resultarray=new int[]{0,0};//一个长度为2的数字 分别存放算出来的前后格子数量
//        if (formatFixedlength < 0) {
//            return resultarray;
//        }
//        int spacesize=0;
//        StringBuilder builder = new StringBuilder();
//        while (getStringLength(builder.toString(), font) < formatFixedlength) {//存在多加一次的可能性
//            builder.append(' ');
//            spacesize++;
//        }
//        int first=spacesize/2;
//        int second=spacesize-first;
//        resultarray[0]=first;
//        resultarray[1]=second;
//        return resultarray;
//    }
//
//
//    public  String getSpaceSize(float size, Font font) {
//
//        int need=0;
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < size; i++) {
//            builder.append(' ');
//            need++;
//        }
//        PdfFactoryLog.println("需要补位:"+need);
//        return builder.toString();
//    }
//
//    public  String getSpaceLength(float formatFixedlength, Font font) {
//        if (formatFixedlength < 0) {
//            return "";
//        }
//        int need=0;
//        StringBuilder builder = new StringBuilder();
//        while (getStringLength(builder.toString(), font) < formatFixedlength) {//存在多加一次的可能性
//            builder.append(' ');
//            need++;
//        }
//        PdfFactoryLog.println("需要补位:"+need);
//        return builder.toString();
//    }
//
//
//    public   String[] stringFormatIdentifySplit(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth,String splitmask){
//        String[] orgarray=orgin.split(splitmask);
//        String[] resultarray=new String[2];
//        formatFixedlength=formatlength(formatFixedlength,font);
//        float sum=0;
//        String result1="";//可以允许放入的完整字符 即 末尾按照分割符结束
//        String result2="";//多余的字符串 可能要另起一页
//        int resultindex=orgarray.length;
//        for (int i = 0; i <orgarray.length ; i++) {
//            sum=sum+getStringLength(orgarray[i]+";",font);
//            if(sum>formatFixedlength){
//                resultindex=i;
//                break;
//            }else{
//                if(sum==formatFixedlength){
//                    resultindex=i+1;
//                    break;
//                }else{
//
//                }
//            }
//        }
//        for (int i = 0; i <resultindex ; i++) {
//            result1=result1+orgarray[i]+";";
//        }
//        if(result1.length()>1){
//            result1=result1.substring(0,result1.length()-1);
//        }
//        for (int i = resultindex; i < orgarray.length; i++) {
//            result2=result2+orgarray[i]+";";
//        }
//        if(result2.length()>1){
//            result2=result2.substring(0,result2.length()-1);
//        }
//        resultarray[0]=result1;
//        resultarray[1]=result2;
//        return resultarray;
//    }
//
//    @Override
//    public String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit, int blockindent) {
//        return new String[0];
//    }
//
//    @Override
//    public String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, int blockindent) {
//        return new String[0];
//    }
//
//    @Override
//    public String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, String blocksplit) {
//        return new String[0];
//    }
//
//
//    public  String[] stringFormatIdentifyLnAndKeepLn(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
//        if (pagewidth == -1) {
//            pagewidth = pagewidthorg;
//        }
//        String[] resultarray = new String[3];//最后一个带出序列
//        String numberstring="";
//        String firststring = "";
//        String secondstring = "";
//        formatFixedlength = formatlength(formatFixedlength, font);
//        pagewidth = formatlength(pagewidth, font);
//        firstLineIndent = formatlength(firstLineIndent, font);
//        StringBuilder firststringbuildertmp = new StringBuilder();
//        StringBuilder firststringbuilder = new StringBuilder();
//        StringBuilder secondstringbuilder = new StringBuilder();
//
//        String[] orginarray = orgin.split("\n");//换行符不用转义
//        try {
//            int firstLineIndenttime = 0;//区分首行
//            if (orginarray.length < 1) {
//                firststringbuilder.append(orgin);
//                firststringbuilder.append('\n');
//                firststringbuildertmp.append(orgin);
//                firststringbuildertmp.append('\n');
//            }
//            boolean ismore = false;
//            for (int i = 0; i < orginarray.length; i++) {
//                String orgintmp=orginarray[i].trim();
//                String tmp;
//                if (firstLineIndent > 0 && firstLineIndenttime == 0) {
//                    tmp= stringFormatWrap(orgintmp, font, firstLineIndent, pagewidth, false);
//
//                } else {
//                    tmp = stringFormatWrap(orgintmp, font, 0, pagewidth, false);
//                }
//                firstLineIndenttime = 1;
//                if (ismore) {
//                    secondstringbuilder.append(orgintmp.trim()+"\n");//将原数据
//                } else {
//                    if (getStringLength(firststringbuildertmp.toString() + tmp, font) <= formatFixedlength) {//说明累加起来这以句之后长度还没超过
//                        firststringbuildertmp.append(tmp);
//                        String odtmp=orgintmp.trim()+"\n";
//                        Pattern pattern=Pattern.compile("(\\d)*");
//                        Matcher matcher=pattern.matcher(odtmp);//用来匹配数字
//                        if(matcher.find()){
//                            numberstring=numberstring+matcher.group(1)+",";
//                        }
//                        firststringbuilder.append(odtmp);
//                    } else {
//                        if (!ismore && getStringLength(firststringbuildertmp.toString() + orgintmp.trim(), font) <= formatFixedlength) {//追加判断一次是不是因为加了空格所以超出了 可能最后一句是符合要求的
//                            firststringbuildertmp.append(orgintmp.trim());
//                            String odtmp=orgintmp.trim()+"\n";
//                            Pattern pattern=Pattern.compile("(\\d)*");
//                            Matcher matcher=pattern.matcher(odtmp);//用来匹配数字
//                            if(matcher.find()){
//                                numberstring=numberstring+matcher.group(1)+",";
//                            }
//                            firststringbuilder.append(odtmp);
//                        } else {
//                            secondstringbuilder.append(orgintmp.trim()+"\n");//将原数据
//                        }
//                        ismore = true;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        firststring = firststringbuilder.toString();
//        secondstring = secondstringbuilder.toString();
//
//        if ("".equals(resultarray[0])) {
//            secondstring = orgin;
//        } else {
//        }
//        {//作用是去掉最后一个的多出来的空格和换行
//            while (firststring.endsWith("\n")) {
//                firststring = firststring.substring(0, firststring.length() - 1);
//            }
//            firststring = firststring.trim();
//            while (secondstring.endsWith("\n")) {
//                secondstring = secondstring.substring(0, secondstring.length() - 1);
//            }
//        }
//        secondstring = secondstring.trim();
//        PdfFactoryLog.println("trim1----------------------------------------");
//        PdfFactoryLog.println("原始数据\n"+orgin);
//        PdfFactoryLog.println("trim1----------------------------------------");
//        PdfFactoryLog.println(firststring);
//        PdfFactoryLog.println("trim2----------------------------------------");
//        PdfFactoryLog.println(secondstring);
//        PdfFactoryLog.println("trim3----------------------------------------");
//        resultarray[0] = firststring;
//        if ("".equals(resultarray[0])) {
//            resultarray[1] = secondstring;
//        } else {
//            resultarray[1] = secondstring;
//        }
//        resultarray[2]=numberstring.length()>1?numberstring.substring(0,numberstring.length()-1):numberstring;
//        return resultarray;
//    }
//
//    @Override
//    public String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth, boolean needcenter) {
//        return null;
//    }
//
//    public  String stringFormatFixedLength(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
//        if (pagewidth == -1) {
//            pagewidth = pagewidthorg;
//        }
//        String endString;
//        if(formatFixedlength==-1){//待验证 -1时对长度不处理 只进行格式化
//            endString=stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, true);//获得已经2阶格式化的字符串
//
//        }else{
//            StringBuilder endStringBulider = new StringBuilder();
//            formatFixedlength = formatlength(formatFixedlength, font);
//            firstLineIndent = formatlength(firstLineIndent, font);
//            pagewidth = formatlength(pagewidth, font);
//            StringBuilder orgbuilder = new StringBuilder();
//            float orginrenderlength = getStringLength(orgin, font);
//            boolean needcenter=false;
//            if (orginrenderlength < formatFixedlength) {//当小于时才会考虑进行格式化 如果不小于
//                if (formatFixedlength <= pagewidth) {//说明不存在换行啊 直接添加特定的空格就行
//                    if("".equals(orgin.trim())){//说明空字符那就不要居中了
//                        endStringBulider.append(stringFormatSpaceLast(orgin, formatFixedlength - orginrenderlength, font));//修改成需要居中的
//                        needcenter=false;
//                    }else{
//                        PdfFactoryLog.println("打印出：居中内容"+orgin+"@");
//                        endStringBulider.append(stringFormatSpaceHeadAndLast(orgin, formatFixedlength, font));//修改成需要居中的
//                        needcenter=true;
//                    }
//                } else {
//                    String formatstringfirst = stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, false);//获得已经2阶格式化的字符串
////                //PdfFactoryLog.println(formatstringfirst);
//                    float formatstringfirstlengtht = getStringLength(formatstringfirst, font);
//                    if (formatFixedlength >= formatstringfirstlengtht) {
//                        endStringBulider.append(stringFormatSpaceLast(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
//                    } else {//追加判断去掉末尾的空格之后再进行判断
//                        while (formatstringfirst.endsWith("\n")) {
//                            formatstringfirst = formatstringfirst.substring(0, formatstringfirst.length() - 1);
//                        }
//                        formatstringfirst = formatstringfirst.trim();
//                        formatstringfirstlengtht = getStringLength(formatstringfirst, font);
//                        if (formatFixedlength >= formatstringfirstlengtht) {
//                            endStringBulider.append(stringFormatSpaceLast(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
//                        } else {
//                            System.err.println("文字长了1:" + formatFixedlength + ":\n" + orgin + "\n----------\n"+formatstringfirst);
//                            endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin,formatFixedlength,font,firstLineIndent,pagewidth)[0]);//获得不超过的部分 进行智能打印
//                        }
//                    }
//                }
//            } else {
//                System.err.println("文字长了2:" + formatFixedlength + ":\n" + orgin + "\n----------\n");
//                endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin,formatFixedlength,font,firstLineIndent,pagewidth)[0]);//获得不超过的部分 进行智能打印
//            }
//            endString = endStringBulider.toString();
//            if(needcenter){//说明是单行的 需要进行居2次补位的居中处理
//                PdfFactoryLog.println("二次补位");
//                endString = stringFormatSpaceHeadAndLast(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
//            }else{
//                endString = stringFormatSpaceLast(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
//            }
//
//            if (getStringLength(endString, font) > pagewidth - firstLineIndent) {//说明存在换行需要
//                endString = stringFormatIdentifyLn(endString, font, firstLineIndent, pagewidth, true);//最后在补齐空格之后在来一次格式化 不对末尾空格进行增加
//            }
//            while (endString.endsWith("\n")) {
//                endString = endString.substring(0, endString.length() - 1);
//            }
//
//        }
//        PdfFactoryLog.println("*************************************");
//        PdfFactoryLog.println(+getStringLength(endString, font)+"："+formatFixedlength+"："+orgin+"***");
//        PdfFactoryLog.println("*******"+endString+"*******");
//        PdfFactoryLog.println("*************************************");
//        return endString;
//    }
//
//    public  String stringFormatFixedLengthNoCenter(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
//        if (pagewidth == -1) {
//            pagewidth = pagewidthorg;
//        }
//        String endString;
//        if(formatFixedlength==-1){//待验证 -1时对长度不处理 只进行格式化
//            endString=stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, true);//获得已经2阶格式化的字符串
//
//        }else{
//            StringBuilder endStringBulider = new StringBuilder();
//            formatFixedlength = formatlength(formatFixedlength, font);
//            firstLineIndent = formatlength(firstLineIndent, font);
//            pagewidth = formatlength(pagewidth, font);
//            StringBuilder orgbuilder = new StringBuilder();
//            float orginrenderlength = getStringLength(orgin, font);
//            if (orginrenderlength < formatFixedlength) {//当小于时才会考虑进行格式化 如果不小于
//                if (formatFixedlength <= pagewidth) {//说明不存在换行啊 直接添加特定的空格就行
//                    endStringBulider.append(stringFormatSpaceLast(orgin, formatFixedlength - orginrenderlength, font));//修改成需要居中的
//                } else {
//                    String formatstringfirst = stringFormatIdentifyLn(orgin, font, firstLineIndent, pagewidth, false);//获得已经2阶格式化的字符串
//                    float formatstringfirstlengtht = getStringLength(formatstringfirst, font);
//                    if (formatFixedlength >= formatstringfirstlengtht) {
//                        endStringBulider.append(stringFormatSpaceLast(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
//                    } else {//追加判断去掉末尾的空格之后再进行判断
//                        while (formatstringfirst.endsWith("\n")) {
//                            formatstringfirst = formatstringfirst.substring(0, formatstringfirst.length() - 1);
//                        }
//                        formatstringfirst = formatstringfirst.trim();
//                        formatstringfirstlengtht = getStringLength(formatstringfirst, font);
//                        if (formatFixedlength >= formatstringfirstlengtht) {
//                            endStringBulider.append(stringFormatSpaceLast(formatstringfirst, formatFixedlength - formatstringfirstlengtht, font));
//                        } else {
//                            System.err.println("文字长了1:" + formatFixedlength + ":\n" + orgin + "\n----------\n"+formatstringfirst);
//                            endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin,formatFixedlength,font,firstLineIndent,pagewidth)[0]);//获得不超过的部分 进行智能打印
//                        }
//                    }
//                }
//            } else {
//                System.err.println("文字长了2:" + formatFixedlength + ":\n" + orgin + "\n----------\n");
//                endStringBulider.append(stringFormatIdentifyLnAndKeepLn(orgin,formatFixedlength,font,firstLineIndent,pagewidth)[0]);//获得不超过的部分 进行智能打印
//            }
//            endString = endStringBulider.toString();
//            endString = stringFormatSpaceLast(endString, formatFixedlength, font);//最后在补齐空格之后在来一次格式化
//
//
//
//            if (getStringLength(endString, font) > pagewidth - firstLineIndent) {//说明存在换行需要
//                endString = stringFormatIdentifyLn(endString, font, firstLineIndent, pagewidth, true);//最后在补齐空格之后在来一次格式化 不对末尾空格进行增加
//            }
//            while (endString.endsWith("\n")) {
//                endString = endString.substring(0, endString.length() - 1);
//            }
//
//        }
//        PdfFactoryLog.println("*************************************");
//        PdfFactoryLog.println(+getStringLength(endString, font)+"："+formatFixedlength+"："+orgin+"***");
//        PdfFactoryLog.println("*******"+endString+"*******");
//        PdfFactoryLog.println("*************************************");
//        return endString;
//    }
//
//
//    public  String stringFormatFixedTableLength(String orgin, float formatFixedlength, Font font) {
//        return stringFormatFixedLength(orgin, formatFixedlength, font, 0, -1);
//    }
//
//    @Override
//    public float getScaleSizeOfMatchOrginIfBeyond(String orgin, float formatFixedlength, Font font, float firstLineIndent, float pagewidth) {
//        return 0;
//    }
//
//
//    public  String stringFormatFixedLength(String orgin, float formatFixedlength, Font font) {
//        return stringFormatFixedLength(orgin, formatFixedlength, font, 0, -1);
//    }
//}
