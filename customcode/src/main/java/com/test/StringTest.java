package com.test;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.intface.CallBack;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import com.github.promeg.pinyinhelper.Pinyin;
import utils.Util_String;

import java.io.File;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    public static void main(String[] args) {
        int result=0;
        String resultstring="PrinterShare_Crack16.app";
        Pattern pattern=Pattern.compile(".*?(\\d+).+");
        Matcher matcher=pattern.matcher(resultstring);
        if(matcher.find()){
            result=Integer.parseInt(matcher.group(1));
        }
        System.out.println(result);















//        final Map<String, Boolean> listmap = new HashMap<>();
//        String actiondir = "D:\\AppAy\\AysjzZ\\jianyeyidongzhifa_feidisanfang_sjz\\src\\main\\java\\com\\android\\yidongzhifa\\activity";
//        Util_File.getFiles(actiondir, ".*\\.java", new CallBack() {
//            @Override
//            public void back(Object... object) {
//                File javafile = (File) object[0];
//                String javacontent = Util_File.inputStream2String(javafile);
//                Pattern pattern = Pattern.compile("\\\".+(/.*Action).*\\\"");
//                Matcher matcher = pattern.matcher(javacontent);
//                while (matcher.find()) {
////                    System.out.println(matcher.group(1));
//                    listmap.put(matcher.group(1), true);
//                }
//            }
//        });
//        for (Map.Entry<String, Boolean> entry : listmap.entrySet()) {
////            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//            System.out.println(entry.getKey());
//        }


//        String org="[{dataName:\"《安全生产许可证条例》\",fl:\"综合类\"},{dataName:\"《安全生产违法行为行政处罚办法》\",fl:\"综合类\"},{dataName:\"《生产安全事故报告和调查处理条例》\",fl:\"综合类\"},\n" +
//                "\t           {dataName:\"《中华人民共和国安全生产法》\",fl:\"综合类\"},{dataName:\"《劳动防护用品监督管理规定》\",fl:\"综合类\"},{dataName:\"《安全生产事故隐患排查治理暂行规定》\",fl:\"综合类\"},\n" +
//                "\t           {dataName:\"《特种作业人员安全技术培训考核管理规定》\",fl:\"综合类\"},{dataName:\"《生产安全事故信息报告和处置办法》\",fl:\"综合类\"},{dataName:\"《生产安全事故应急预案管理办法》\",fl:\"综合类\"},\n" +
//                "\t           {dataName:\"《生产经营单位安全培训规定》\",fl:\"综合类\"},{dataName:\"《作业场所职业健康监督管理暂行规定》\",fl:\"职业健康类\"},{dataName:\"《作业场所职业危害申报管理办法》\",fl:\"职业健康类\"},\n" +
//                "\t           {dataName:\"《中华人民共和国矿山安全法》\",fl:\"非煤矿山类\"},{dataName:\"《中华人民共和国矿山安全法实施条例》\",fl:\"非煤矿山类\"},{dataName:\"《生产安全事故应急预案管理办法》\",fl:\"非煤矿山类\"},\n" +
//                "\t           {dataName:\"《尾矿库安全监督管理规定》\",fl:\"非煤矿山类\"},{dataName:\"《海洋石油安全生产规定》\",fl:\"非煤矿山类\"},{dataName:\"《海洋石油安全管理细则》\",fl:\"非煤矿山类\"},\n" +
//                "\t           {dataName:\"《石油天然气管道保护条例》\",fl:\"非煤矿山类\"},{dataName:\"《生产安全事故信息报告和处置办法》\",fl:\"非煤矿山类\"},{dataName:\"《安全生产培训管理办法》\",fl:\"中介服务类\"},\n" +
//                "\t           {dataName:\"《矿山救护队资质认定管理规定》\",fl:\"中介服务类\"},{dataName:\"《安全生产检测检验机构管理规定》\",fl:\"中介服务类\"},{dataName:\"《安全评价机构管理规定》\",fl:\"中介服务类\"},\n" +
//                "\t           {dataName:\"《注册安全工程师管理规定》\",fl:\"中介服务类\"},{dataName:\"《冶金企业安全生产监督管理规定》\",fl:\"其他类\"},{dataName:\"《危险化学品安全管理条例》\",fl:\"危险化学品类\"},           \n" +
//                "\t           {dataName:\"《危险化学品建设项目安全许可实施办法》\",fl:\"危险化学品类\"},{dataName:\"《危险化学品生产企业安全生产许可证实施办法》\",fl:\"危险化学品类\"},{dataName:\"《危险化学品登记管理办法》\",fl:\"危险化学品类\"},\n" +
//                "\t           {dataName:\"《危险化学品经营许可证管理办法》\",fl:\"危险化学品类\"},{dataName:\"《易制毒化学品管理条例》\",fl:\"危险化学品类\"},{dataName:\"《易制毒化学品管理条例》\",fl:\"危险化学品类\"},\n" +
//                "\t           {dataName:\"《烟花爆竹安全管理条例》\",fl:\"烟花爆竹类\"},{dataName:\"《烟花爆竹生产企业安全生产许可证实施办法》\",fl:\"烟花爆竹类\"},{dataName:\"《烟花爆竹经营许可实施办法》\",fl:\"烟花爆竹类\"}\n" +
//                "\t           ];";
//        Pattern pattern=Pattern.compile("\\{dataName:(.*?),[\\s\\S]*?fl:(.*?)\\}");
//        Map<String,String> leixingmap=new HashMap<>();
//        Matcher matcher=pattern.matcher(org);
//        while (matcher.find()){
//            if(leixingmap.get(matcher.group(2))!=null){
//                String tmp=leixingmap.get(matcher.group(2));
//
//                leixingmap.put(matcher.group(2),matcher.group(1)+","+tmp);
//            }else{
//
//                leixingmap.put(matcher.group(2),matcher.group(1));
//            }
//        }
//        Iterator<Map.Entry<String, String>> entries = leixingmap.entrySet().iterator();
//        System.out.println("Map<String,String> leixingmap=new HashMap<>();");
//        while (entries.hasNext()) {
//            Map.Entry<String, String> entry = entries.next();
////            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            System.out.println("leixingmap.put(\""+entry.getKey().replace("\"","")+"\",\""+entry.getValue().replace("\"","")+"\");");
//        }
//        System.out.println(clearHeadNumber("1、测试股"));

    }

    public static String clearHeadNumber(String org) {
        String result = "";
        Pattern pattern = Pattern.compile(".*?(\\d+).+");
        Matcher matcher = pattern.matcher(org);
        if (matcher.find()) {
            result = org.replaceFirst(matcher.group(1), "");
            if ((result.toCharArray()[0] + "").getBytes().length > 1) {//说明第一位是符号那么去掉就行
                result = result.substring(1, result.length());
            }
        } else {
            return org;
        }
        return result;
    }

    public void test2() {
        float needspeed = 1.4f;
        String classz = "    Class \"One Hand Swords\"\n";
        String org = "Charan's Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 5-11\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.45\n" +
                "Weapon Range: 9\n" +
                "Requires Level 2, 9 Str, 9 Dex\n" +
                "\tRusted Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 4-10\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.45\n" +
                "Weapon Range: 9\n" +
                "Requires Level 1, 8 Str, 8 Dex\n" +
                "\tCopper Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 7-15\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.4\n" +
                "Weapon Range: 9\n" +
                "Requires Level 5, 14 Str, 14 Dex\n" +
                "\tSabre\n" +
                "One Hand Swords\n" +
                "Physical Damage: 5-22\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.55\n" +
                "Weapon Range: 9\n" +
                "Requires Level 10, 18 Str, 26 Dex\n" +
                "\tBroad Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 17-25\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 15, 30 Str, 30 Dex\n" +
                "\tWar Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 20-37\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.2\n" +
                "Weapon Range: 9\n" +
                "Requires Level 20, 41 Str, 35 Dex\n" +
                "\tAncient Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 20-38\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 24, 44 Str, 44 Dex\n" +
                "\tElegant Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 20-33\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.5\n" +
                "Weapon Range: 9\n" +
                "Requires Level 28, 46 Str, 55 Dex\n" +
                "\tDusk Blade\n" +
                "One Hand Swords\n" +
                "Physical Damage: 19-54\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 32, 57 Str, 57 Dex\n" +
                "\tHook Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 28-60\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.15\n" +
                "Weapon Range: 9\n" +
                "Requires Level 34, 64 Str, 64 Dex\n" +
                "\tVariscite Blade\n" +
                "One Hand Swords\n" +
                "Physical Damage: 25-53\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 35, 62 Str, 62 Dex\n" +
                "\tCutlass\n" +
                "One Hand Swords\n" +
                "Physical Damage: 13-53\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.55\n" +
                "Weapon Range: 9\n" +
                "Requires Level 38, 55 Str, 79 Dex\n" +
                "\tBaselard\n" +
                "One Hand Swords\n" +
                "Physical Damage: 37-53\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 41, 72 Str, 72 Dex\n" +
                "\tBattle Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 38-70\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.2\n" +
                "Weapon Range: 9\n" +
                "Requires Level 44, 83 Str, 70 Dex\n" +
                "\tElder Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 36-66\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 47, 81 Str, 81 Dex\n" +
                "\tGraceful Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 34-55\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.5\n" +
                "Weapon Range: 9\n" +
                "Requires Level 50, 78 Str, 94 Dex\n" +
                "\tTwilight Blade\n" +
                "One Hand Swords\n" +
                "Physical Damage: 30-86\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 53, 91 Str, 91 Dex\n" +
                "\tGrappler\n" +
                "One Hand Swords\n" +
                "Physical Damage: 44-94\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.15\n" +
                "Weapon Range: 9\n" +
                "Requires Level 55, 99 Str, 99 Dex\n" +
                "\tGemstone Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 39-83\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 56, 96 Str, 96 Dex\n" +
                "\tCorsair Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 20-80\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.55\n" +
                "Weapon Range: 9\n" +
                "Requires Level 58, 81 Str, 117 Dex\n" +
                "\tGladius\n" +
                "One Hand Swords\n" +
                "Physical Damage: 54-78\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 60, 113 Str, 113 Dex\n" +
                "\tLegion Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 53-98\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.2\n" +
                "Weapon Range: 9\n" +
                "Requires Level 62, 122 Str, 104 Dex\n" +
                "\tVaal Blade\n" +
                "One Hand Swords\n" +
                "Physical Damage: 46-86\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 64, 113 Str, 113 Dex\n" +
                "\tEternal Sword\n" +
                "One Hand Swords\n" +
                "Physical Damage: 41-68\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.5\n" +
                "Weapon Range: 9\n" +
                "Requires Level 66, 104 Str, 122 Dex\n" +
                "\tMidnight Blade\n" +
                "One Hand Swords\n" +
                "Physical Damage: 35-99\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.3\n" +
                "Weapon Range: 9\n" +
                "Requires Level 68, 113 Str, 113 Dex\n" +
                "\tTiger Hook\n" +
                "One Hand Swords\n" +
                "Physical Damage: 49-105\n" +
                "Critical Strike Chance: 5%\n" +
                "Attacks per Second: 1.15\n" +
                "Weapon Range: 9\n" +
                "Requires Level 70, 119 Str, 119 Dex\n";
        Pattern pattern = Pattern.compile("[\\s\\S]*?Dex");
        Matcher matcher = pattern.matcher(org);
        while (matcher.find()) {
            String block = matcher.group().trim();
//        System.out.println(block);
//        System.out.println("-------------");
            Pattern pattern1 = Pattern.compile("Attacks per Second:(.*)");
            Matcher matcher1 = pattern1.matcher(block);
            Float speed = 0f;
            if (matcher1.find()) {
                speed = Float.parseFloat(matcher1.group(1).trim());
            }
            int level = 0;
            Pattern pattern2 = Pattern.compile("Requires Level(.*?),");
            Matcher matcher2 = pattern2.matcher(block);
            if (matcher2.find()) {
                level = Integer.parseInt(matcher2.group(1).trim());
            }
            String basetype = "";
            Pattern pattern3 = Pattern.compile("(.*)");
            Matcher matcher3 = pattern3.matcher(block);
            if (matcher3.find()) {
                basetype = matcher3.group(1).trim();
//            System.out.println(basetype);
            }
            if (speed > needspeed) {
                String result = "Show\n" +
                        classz +
                        "    BaseType \"" + basetype + "\"\n" +
                        "    ItemLevel <= " + (level + 10) + "\n" +
                        "    SetBackgroundColor 255 0 86 220\n" +
                        "    SetFontSize 39";
                System.out.println(result);
            }

        }
    }

    public void test1() {
        //        for (int i = 0; i <50 ; i++) {
//            System.out.println("    public static void tip"+i+"(){\n" +
//                    "        Log.v(\"SRX\","+i+"+\"\");\n" +
//                    "    }\n");
//        }
//        String string=new File("D:/ApkNeed/18183_2/乞丐的旅途/assets").getAbsolutePath().replace("\\","/");
//        Pattern pattern=Pattern.compile("D:/ApkNeed/18183_2/乞丐的旅途/(assets|lib|original|res|.+?/android)");
//        System.out.println(pattern);
//        System.out.println(string);
//        Matcher matcher=pattern.matcher(string);
//        if(matcher.find()){
//            System.out.println("OK");
//
//        }
//        String sss="sccc.sadasd.aewwww".replace(".","/");
//        System.out.println(sss);
//        String xmlcontent= Util_File.inputStream2String("D:\\ApkNeed\\18183_3\\塔防：魔法勇士\\AndroidManifest2.xml");
////        System.out.println(xmlcontent);
//        ParseBase parseBase=new XmlNode().build().parse(xmlcontent);
//        System.out.println(parseBase.getEntityString());
        String test = "111、安全生产承包租赁:采场有危及安全的悬石、松石、浮石2、安全生产警示标志管理:采场坡面角大于80°（石灰岩）或45°（页岩)";
//        Pattern patte=Pattern.compile("[0-9]、[^([0-9]、)]*");
//        Matcher matcher=patte.matcher(test);
//        while (matcher.find()){
//            System.out.println(matcher.group());
//            System.out.println("----------------------");
//        }
        String odtmp = test.trim() + "\n";
        Pattern pattern = Pattern.compile("(\\d)*");
        Matcher matcher = pattern.matcher(odtmp);//用来匹配数字
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
//        String[] testarray=test.split("\\d、");
//        for (int i = 0; i <testarray.length ; i++) {
//            System.out.println(testarray[i]);
//        }
    }

    private boolean validateString(String str) {
        boolean res = true;
        if (str == null || "".equals(str)) {
            res = false;
        }
        return res;
    }

    public static String getchinese2pinyin(String chinesestr) {
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

}
