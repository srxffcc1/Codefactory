package utils;


import com.github.promeg.pinyinhelper.Pinyin;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util_String {
    /**
     * 洗字符串 转义需要转义的东西
     *
     * @param keyword
     * @return
     */
    public static String washString(String keyword) {
        if (keyword != null && !keyword.equals("")) {
            String[] fbsArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]",
                    "?", "^", "{", "}", "|"};
            for (String key : fbsArr) {
                if (keyword.contains(key)) {
                    keyword = keyword.replace(key, "\\" + key);
                }
            }
        } else {
            return "";
        }
        return keyword;
    }

    /**
     * 获得首位小写的字符串
     *
     * @param keyword
     * @return
     */
    public static String changeHeadToLowCase(String keyword) {
        String result = "";
        String head = keyword.substring(0, 1).toLowerCase();
        String body = keyword.substring(1, keyword.length());
        result = head + body;
        return result;
    }

    public static String removeExplan(String keyword) {
        Pattern explan = Pattern.compile("<!-[\\s\\S]*?-->");
        Matcher match = explan.matcher(keyword);
        while (match.find()) {
            keyword = keyword.replace(match.group(), "");

        }

        return keyword;
    }

    /**
     * 判断是不是在list里
     *
     * @param checklist
     * @param key
     * @return
     */
    public static boolean isInList(List<String> checklist, String key) {
        boolean result = false;
        if (checklist == null) {

        } else {
            for (int i = 0; i < checklist.size(); i++) {
                if (checklist.get(i).equals(key)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 截取字符
     *
     * @param orgstring
     * @param sub
     * @return
     */
    public static int getSubStringNumber(String orgstring, String sub) {
        int result = 0;
        int start = 0;
        while (orgstring.indexOf(sub, start) >= 0 && start <= orgstring.length()) {
            result++;
            start = orgstring.indexOf(sub, start) + sub.length();
        }
        return result;
    }


    public static String chinese2pinyin(String chinesestr) {
        long old = System.currentTimeMillis();
//        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String targetchinese = Pinyin.toPinyin(chinesestr, "");

//        char[] chinesechar = chinesestr.toCharArray();
//        try {
//            for (int i = 0; i < chinesechar.length; i++) {
//
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        if (targetchinese.length() > 60) {
            targetchinese = targetchinese.substring(0, 60);
        }

        return targetchinese.toLowerCase();
    }

    /**
     * 是否22对应 用于xml layout类似的节点< >+</ >
     *
     * @param orgstring
     * @param subhead
     * @param subend
     * @return
     */
    public static boolean is22match(String orgstring, String subhead, String subend) {
        int result1 = 0;
        int start1 = 0;
        int result2 = 0;
        int start2 = 0;
        while (orgstring.indexOf(subhead, start1) >= 0 && start1 <= orgstring.length()) {
            result1++;

            start1 = orgstring.indexOf(subhead, start1) + subhead.length();
        }

        while (orgstring.indexOf(subend, start2) >= 0 && start2 <= orgstring.length()) {
            result2++;
            start2 = orgstring.indexOf(subend, start2) + subend.length();
        }
        Pattern special = Pattern.compile(subhead + "([\\s\\S]*?)" + "/>");
//		System.out.println(special);
        Matcher matcher = special.matcher(orgstring);
        while (matcher.find()) {//发现内部包含特殊的节点
            String tmp = matcher.group(1);
            if (tmp.contains("<") || tmp.contains(">")) {

            } else {
                result1--;//消去一个头
            }
        }
        if (result1 == result2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否对应 用于xml view类似的节点< />
     *
     * @param orgstring
     * @param subhead
     * @param subend
     * @return
     */
    public static boolean is222match(String orgstring, String subhead, String subend) {
        int result1 = 0;
        int start1 = 0;
        int result2 = 0;
        int start2 = 0;
        while (orgstring.indexOf(subhead, start1) >= 0 && start1 <= orgstring.length()) {
            result1++;
            start1 = orgstring.indexOf(subhead, start1) + subhead.length();
        }
        while (orgstring.indexOf(subend, start2) >= 0 && start2 <= orgstring.length()) {
            result2++;
            start2 = orgstring.indexOf(subend, start1) + subend.length();
        }
        if ((result1 + result2) == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 生成19位数字和一个负号位的随机guid
     *
     * @return
     */
    public static String getRandomGuid() {
        String result = "";
        Random random = new Random();
        result += random.nextInt(9) + 1;
        for (int i = 0; i < 18; i++) {
            result += random.nextInt(10);
        }
        if (random.nextInt(2) == 1) {

        } else {
            result = "-" + result;
        }
        return result;
    }

    private static String string2unicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] + "").getBytes().length > 1) {
                returnStr += "\\u" + Integer.toString(chars[i], 16);
            } else {
                returnStr += chars[i];
            }

        }
        return returnStr;
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {

        String[] strs = unicode.split("\\\\u");
        String returnStr = null;
            returnStr = "";
            // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() > 4) {
                    String hex4 = strs[i].substring(0, 4);
                    String hex4_2 = strs[i].substring(4, strs[i].length());
                    try {
                        returnStr += (char) Integer.valueOf(hex4, 16).intValue() + hex4_2;
                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
                        returnStr += strs[i];
                    }
                } else {
                    if (strs[i].length() == 4) {
                        try {
                            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
                        } catch (NumberFormatException e) {
//                            e.printStackTrace();
                            returnStr += strs[i];
                        }
                    } else {
                        returnStr += strs[i];
                    }
                }


            }
        return returnStr;
    }

}
