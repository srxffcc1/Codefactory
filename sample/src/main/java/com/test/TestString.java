package com.test;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestString {
    public static void main(String[] args) {
//        BigDecimal bd = new BigDecimal("3.40256010353E11");
//        System.out.println(bd);
//        String check =  "^(?:https?://)?[\\w]{1,}(?:\\.?[\\w]{1,})+[\\w-_/?&=#%:]*$";
//        System.out.println("http://58.213.148.41:8805//".matches(check));
//        Util_File.copy("D:\\AppHook\\Debug\\app\\build\\outputs\\apk\\app-debug\\smali\\net","D:\\AppHook\\Debug\\app\\build\\outputs\\apk\\oiopo\\net");
//        String filecontent = Util_File.inputStream2String("D:\\ApkNeed\\18183_3\\塔防：魔法勇士\\AndroidManifest.xml");
//        ParseBase manifestnode = new XmlNode().build().parse(filecontent);
//        System.out.println(manifestnode.getEntityString());
//        try {
//            XmlPullParserFactory pullParserFactory=XmlPullParserFactory.newInstance();
//            XmlPullParser xmlPullParser=pullParserFactory.newPullParser();
//            Reader is = new InputStreamReader(new FileInputStream(""));
//            xmlPullParser.setInput(is);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String xcyj = "";
//        String jcqk="1、《烟花爆竹经营许可实施办法》第三十二条：“批发企业有下列行为之一的，责令其限期改正，处5000元以上3万元以下的罚款：（七）未将黑火药、引火线的采购、销售记录报所在地县级安全监管局备案的；”\n" +
//                "2、《中华人民共和国安全生产法》第九十四条：生产经营单位有下列行为之一的，责令限期改正，可以处五万元以下的罚款;逾期未改正的，责令停产停业整顿，并处五万元以上十万元以下的罚款，对其直接负责的主管人员和其他直接责任人员处一万元以上二万元以下的罚款：“(二)危险物品的生产、经营、储存单位以及矿山、金属冶炼、建筑施工、道路运输单位的主要负责人和安全生产管理人员未按照规定经考核合格的；”《江苏省安全生产条例》第五十条：“矿山、金属冶炼、建筑施工、船舶修造、船舶拆解、道路运输单位和危险物品的生产、经营、储存单位的主要负责人或者安全生产管理人员违反本条例第二十条第一款规定，未按照规定经考核合格的，责令生产经营单位限期改正，可以处一万元以上五万元以下罚款；逾期未改正的，责令停产停业整顿，并处五万元以上十万元以下罚款，对其直接负责的主管人员和其他直接责任人员处一万元以上二万元以下罚款。” ";
//        Pattern pattern= Pattern.compile("(《.*?》)");
//        Matcher matcher=pattern.matcher(jcqk);
//        while (matcher.find()){
//            xcyj=xcyj+matcher.group(1);
//        }
//        System.out.println(xcyj);
        String org = "颜色:白色;品种:红富士;重量:10kg";
//        List<String> result= Arrays.asList(org.split(";"));
//        for (int i = 0; i <result.size() ; i++) {
//            System.out.println(result.get(i));
//        }
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*?:(.+?);");
        Matcher matcher = pattern.matcher(org + ";");
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

}
