package com.test;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.intface.CallBack;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import com.google.gson.Gson;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.apache.xmlbeans.impl.regex.Match;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.HMMDao;

import javax.rmi.CORBA.Util;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HMMTest {

    public static Map<String, String> idsmap = new HashMap<>();
    public static Map<String, String> idsZhuanzhangmap = new HashMap<>();
    public static Map<String, String> idsmap2 = new HashMap<>();
    public static Map<String, String> idsmap3 = new HashMap<>();
    public static Map<String, String> resultMap = new HashMap<>();
    public static String nowPro="pro502";

    //    public static String resultOutToTxt="";
//    public static String resultIdsOutToTxt="";
    public static long deep=1;
    public static int backTime=0;
    public static int oldLine=0;
    public static int nowLine=0;
    public static String  updateS;
    public static String path="D:\\Work\\";
    public static String result="";
    public static int lineCount=0;
    public static int lineNo=0;
    public static DocumentBuilderFactory documentBuilderFactory;
    public static DocumentBuilder db;
    public static void main(String[] args) {
//        String[] idsAlready=Util_File.inputStream2String("D:\\Work\\OPS.txt").split("\n");
//
//        Calendar calendar = Calendar.getInstance();
//        try {
//            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-14"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar calendar2 = Calendar.getInstance();
//        Date dateLast= null;
//        try {
//            dateLast = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-17");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        while (calendar.getTime().before(dateLast)){
//            BigDecimal amountAllplatform=new BigDecimal(0);
//            calendar2.setTime(calendar.getTime());
//            calendar2.add(calendar.DATE, 1);
//            for (int i = 0; i < idsAlready.length; i++) {
//                String[] line=idsAlready[i].split("\t");
//                boolean isBetween=false;
//                try {
//                    Date createTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(line[0]);
//                    if(createTime.after(calendar.getTime())
//                            &&
//                            createTime.before(calendar2.getTime())){
//                        isBetween=true;
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                double amoumt=Double.parseDouble(line[6]);
////            System.out.println(amoumt);
//                if(isBetween){
////                System.out.println("进来了");
//                    amountAllplatform=amountAllplatform.add(new BigDecimal(amoumt));
//                }
//
//            }
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())+",手续费"+amountAllplatform.doubleValue());
//            calendar.add(calendar.DATE, 1);
//        }

//         documentBuilderFactory=DocumentBuilderFactory.newInstance();
//        try {
//            db=documentBuilderFactory.newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//        updateS="";
//        //解析对应的xml文件
//        Util_File.getFiles("D:\\Work\\HMMP", ".*\\.xml", new CallBack() {
//            @Override
//            public void back(Object... object) {
//                File file = (File) object[0];
//                if(file.getName().contains("Mapper")){
//                    String xmlString=Util_File.inputStream2String(file);
//
//                }
//
//            }
//        });
//
//        Util_File.string2Stream(updateS, "D:\\Work\\Update汇总.txt");

//        String xmlString=Util_File.inputStream2String("D:\\Work\\Update汇总2.txt");
//        xmlString=xmlString.replace("<set","set");
//        Pattern pattern=Pattern.compile("((?i)set[\\s\\S]*?)where");
//        Matcher matcher=pattern.matcher(xmlString);
//        while (matcher.find()){
////            System.out.println(matcher.group(1));
//            xmlString=xmlString.replace(matcher.group(1),"");
////            matcher.reset();
////            updateS+=matcher.group(1)+"\n";
////            System.out.println("----------------------------");
////            updateS+="----------------------------\n";
//        }
//        System.out.println(xmlString);
//        xmlString=xmlString.replace("where>","<where>");
////
//        Util_File.string2Stream(xmlString, "D:\\Work\\Update汇总3.txt");
        //比较两个Map的差异
//        extractedMap("D:\\Work\\MAP1.txt",idsmap);
//        extractedMap("D:\\Work\\MAP2.txt",idsmap2);
//
//        for (Map.Entry<String, String> entry : idsmap2.entrySet()) {//迭代规格选择
//            if(TextUtils.isEmpty(idsmap.get(entry.getKey()))){
//                System.out.println(entry.getKey());
//            }
//
//        }
//        System.out.println("25053,25680,25681,25946,26585,26587,27200,27400,27567,27568,27569,27570,27571,27572,27573,27574,27575,27776,27778,27780,27785,27788,27790,27794,27801,27810,27812,27814,27824,27828,27830,27831,27832,27834,27836,27883,27887,27889,27891,27895,27899,27900,27901,27906,27907,27963,27966,27971,27973,27975,27980,27983,27986,27988,27992,27994,27996,27997,27999,28003,28004,28007,28010,28012,28015,28060,28067,28081,28086,28087,28089,28090,28092,28097,28099,28102,28105,28111,28180,28183,28185,28200,28202,28204,28206,28207,28208,28209,28212,28213,28214,28215,28217,28218,28219,28220,28221,28222,28223,28224,28225,28227,28228,28230,28232,28234,28236,28238,28243,28244,28245,28250,28252,28254,28256,28257,28260,28263,28265,28266,28267,28268,28269,28271,28272,28273,28274,28275,28276,28277,28278,28279,28280,28281,28283,28284,28302,28304,28305,28307,28310,28311,28313,28314,28315,28316,28317,28318,28320,28321,28322,28323,28324,28325,28326,28327,28328,28329,28330,28331,28332,28333,28334,28335,28338,28339,28340,28341,28342,28343,28344,28346,28347,28349,28350,28351,28353,28354,28356,28358,28359,28361,28362,28363,28364,28365,28366,28367,28368,28369,28370,28371,28372,28373,28374,28375,28376,28378,28379,28380,28382,28383,28384,28385,28386,28398,28399,28401,28402,28403,28404,28405,28408,28412,28415,28416,28417,28418,28420,28421,28422,28424,28433".split(",").length);

//        String[] mapStringArray=Util_File.inputStream2String("D:\\Work\\待推送信息.txt").split("\n");
//        String upload="{\n" +
//                "    \"OlNickName\": \"%s\",\n" +
//                "    \"OlLoginDate\": \"%s\",\n" +
//                "    \"Sex\": \"%s\",\n" +
//                "    \"LoginSequence\": \"7B2978F6\",\n" +
//                "    \"olDate2\": \"%s\",\n" +
//                "    \"version\": \"082737\",\n" +
//                "    \"AppID\": \"%s\",\n" +
//                "    \"Command\": \"RegCard\",\n" +
//                "    \"CardTel\": \"%s\",\n" +
//                "    \"IsSendFixed\": \"N\",\n" +
//                "    \"Memo\": \"憨妈妈\",\n" +
//                "    \"memberId\": \"%s\",\n" +
//                "}";


//        String result="";
//        String sql="Insert INTO map_goods_shop_price ( shop_id, goods_id, retail_price, store_price, limit_price, platform_price, plus_price, max_inventory, available_inventory, locked_inventory, total_inventory, goods_status, price_grade_num, sales) select %s, goods_id, retail_price, store_price, limit_price, platform_price, plus_price, max_inventory, available_inventory, locked_inventory, total_inventory, goods_status, price_grade_num, sales from map_goods_shop_price where shop_id=9388;";
//
//        String[] lineids=Util_File.inputStream2String("D:\\Work\\SHOP_IDS.txt").split("\n");


//        String[] lineshops=Util_File.inputStream2String("D:\\Work\\SHOP_IDS.txt").split("\n");
//
//        String tmpids="";
//        for (int i = 0; i < lineids.length; i++) {
//            String goodsIds=lineids[i].trim();
//            String tmp=String.format(sql,goodsIds);
//            result+=tmp+"\n";
//            System.out.println(tmp);
//        }
//        Util_File.string2Stream(result,"D:\\Work\\RED_IDS.txt");



//        List<String> stringList=Arrays.asList("2789,2811,2883,2976,2899,2914,2833,2871,3003,75,74".split(","));
//        List<Goods> goodsList=new ArrayList<>();
//        goodsList.add(new Goods("1001560","6957931480910","2789,2791,2804",new BigDecimal(40.600000)));
//
//        if (stringList.size()>0) {    //品类
//            BigDecimal goodsAmount = new BigDecimal("0.00");
//            for (Goods goods : goodsList) {
//                String[] categoryIdS = new String[0];
//                try {
//                    categoryIdS = StringUtils.trimToEmpty(goods.getCategoryId()).split(",");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                boolean isCateGoryIn=false;
//                for (int i = 0; i < categoryIdS.length; i++) {
//                    if(!isEmpty(categoryIdS[i])&&stringList.contains(categoryIdS[i])){
//                        isCateGoryIn=true;
//                    }
//                }
//                if (isCateGoryIn) {
//                    goodsAmount = goodsAmount.add(goods.getGoodsAmount());
//                }
//
//            }
//            System.out.println(goodsAmount);
//            if (goodsAmount.compareTo(new BigDecimal(1.0)) >= 0) {
//                System.out.println("符合要求");
//            }
//        }

//        JSONArray jsonArray=new JSONArray();
//        long first=11000000010L;
//        for (int i = 0; i < 5000; i++) {
//            JSONObject jsonObject=new JSONObject();
//            jsonObject.put("phone",first);
//            jsonArray.put(jsonObject);
//            first++;
//        }
//        System.out.println(jsonArray.toString());
//
//        Util_File.string2Stream(jsonArray.toString(),"D:\\Work\\member-phone.txt");

//        tmpids=tmpids.substring(0,tmpids.length()-1);
//        System.out.println(tmpids);
//
//        System.out.println(String.format(result,tmpids));
//
//
//        String resultgg=String.format(result,tmpids);
//
//        Util_File.string2Stream(resultgg,"D:\\Work\\member-3.txt");
//        String result="INSERT INTO hmm_member_partner (member_id,partner_id,badge_id,create_time,latest_update_time) VALUES ";
//        String sql="('%s', '1548954017314267137', NULL, '2022-08-25 18:00:44', '2022-08-30 15:49:44')";
//        for (int i = 0; i < lines.length; i++) {
//            result+="'"+lines[i].trim()+"'"+",";
//        }
//        System.out.println(result);




//        extractedMap("D:\\Work\\member_phone.txt",idsmap);
//
//        String result="";
//        String[] orderLins= Util_File.inputStream2String("D:\\Work\\order_org2.txt").split("\n");
//
//        for (int i = 0; i < orderLins.length; i++) {
//            if(!TextUtils.isEmpty(orderLins[i])){
//                String[] cells=orderLins[i].trim().split("\t");
//                String  member_id=cells[0];
//                String  sharemember_id=cells[2];
//                String phone=getMapResult(idsmap,member_id)+"\t"+getMapResult(idsmap,sharemember_id);
//                result+=orderLins[i].trim()+"\t"+phone+"\n";
//            }
//
//
//        }
//        System.out.println(result);
//        Util_File.string2Stream(result,"D:\\Work\\order_result.txt");





        String[] orderLins= Util_File.inputStream2String("D:\\Work\\goods_id_map.txt").split("\n");

        String sqlInsertGoodsApplicable="insert into map_goods_applicable (goods_id," +
                "applicable_id) select %s," +
                "applicable_id from map_goods_applicable where goods_id=%s;";
        String sqlInsertGoodsFile="insert into goods_file (file_type," +
                "file_path," +
                "thumbs_path," +
                "image_title," +
                "image_description," +
                "text_description," +
                "goods_id," +
                "channel_platform," +
                "ranking) select file_type," +
                "file_path," +
                "thumbs_path," +
                "image_title," +
                "image_description," +
                "text_description," +
                "%s," +
                "channel_platform," +
                "ranking from goods_file where goods_id=%s;";
        String sqlInsertGoodsPrice="insert into map_goods_shop_price (shop_id," +
                "goods_id," +
                "retail_price," +
                "store_price," +
                "limit_price," +
                "platform_price," +
                "plus_price," +
                "max_inventory," +
                "available_inventory," +
                "locked_inventory," +
                "total_inventory," +
                "goods_status," +
                "price_grade_num," +
                "sales) select 0," +
                "%s," +
                "retail_price," +
                "store_price," +
                "limit_price," +
                "platform_price," +
                "plus_price," +
                "max_inventory," +
                "available_inventory," +
                "locked_inventory," +
                "total_inventory," +
                "3," +
                "price_grade_num," +
                "sales from map_goods_shop_price where goods_id=%s and shop_id=0;";
        String sqlInsertGoodsPublish="insert into goods_publish (goods_id," +
                "publish) select %s," +
                "publish from goods_publish where goods_id=%s;";
        String sqlInsertGoodsChild="insert into goods_child (shop_id," +
                "goods_id," +
                "barcode_sku," +
                "goods_title," +
                "ad_title," +
                "goods_spec," +
                "goods_spec_str," +
                "retail_price," +
                "limit_price," +
                "store_price," +
                "platform_price," +
                "plus_price," +
                "share_price," +
                "share_money," +
                "max_inventory," +
                "available_inventory," +
                "locked_inventory," +
                "total_inventory," +
                "sales," +
                "status," +
                "commission_rate_shop," +
                "commission_rate_user," +
                "commission_rate_shop_is_off," +
                "commission_rate_user_is_off," +
                "price_grade_num," +
                "channel_platform," +
                "version," +
                "create_time," +
                "update_time) select 0," +
                "%s," +
                "barcode_sku," +
                "goods_title," +
                "ad_title," +
                "goods_spec," +
                "goods_spec_str," +
                "retail_price," +
                "limit_price," +
                "store_price," +
                "platform_price," +
                "plus_price," +
                "share_price," +
                "share_money," +
                "max_inventory," +
                "available_inventory," +
                "locked_inventory," +
                "total_inventory," +
                "sales," +
                "status," +
                "commission_rate_shop," +
                "commission_rate_user," +
                "commission_rate_shop_is_off," +
                "commission_rate_user_is_off," +
                "price_grade_num," +
                "channel_platform," +
                "version," +
                "create_time," +
                "update_time from goods_child where shop_id=0 and goods_id=%s;";
        for (int i = 0; i < orderLins.length; i++) {
            String[] cells=orderLins[i].split("\t");
            result+=String.format(sqlInsertGoodsApplicable,cells[0].trim(),cells[1].trim())+"\n";
            result+=String.format(sqlInsertGoodsFile,cells[0].trim(),cells[1].trim())+"\n";
            result+=String.format(sqlInsertGoodsPrice,cells[0].trim(),cells[1].trim())+"\n";
            result+=String.format(sqlInsertGoodsPublish,cells[0].trim(),cells[1].trim())+"\n";
        }




        Util_File.string2Stream(result,"D:\\Work\\goods_extra_result.txt");

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 15);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        calendar.add(Calendar.DAY_OF_MONTH,1);
//
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S").format(calendar.getTime()));

//
//        Util_File.getFiles("D:\\Work\\HMM\\HMM-C-Android", "(.*)\\.java", new CallBack() {
//            @Override
//            public void back(Object... object) {
//                File file= (File) object[0];
//                if(!file.getName().contains("$$")&&!file.getName().contains("BuildConfig")){
//                    System.out.println(file.getName());
//                    String[] lines=Util_File.inputStream2String(file).split("\n");
//                    for (int i = 0; i < lines.length; i++) {
//                        if(!TextUtils.isEmpty(lines[i].trim())){
//                            lineCount++;
//                            result+=lines[i].trim()+"\n";
//                        }
//                    }
//                    if(lineCount>6000&& lineNo<7){
//                        lineCount=0;
//                        Util_File.string2Stream(result,path+"post"+lineNo+".txt");
//                        lineNo++;
//                        result="";
//                    }
//                }
//            }
//        });




//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp);
//
//        //return number of milliseconds since January 1, 1970, 00:00:00 GMT
//        System.out.println(timestamp.getTime());
//
//        // Convert timestamp to instant
//        Instant instant = timestamp.toInstant();
//        System.out.println(instant);
//
//        //return number of milliseconds since the epoch of 1970-01-01T00:00:00Z
//        System.out.println(instant.toEpochMilli());
//
//        // Convert instant to timestamp
//        Timestamp tsFromInstant = Timestamp.from(instant);
//        System.out.println(tsFromInstant.getTime());


//        1363177085554791,1363177085554977,1363177085555721,1363177085555959,1363177085554791,1363177085554977,1363177085555721,1363177085555959,1363177085517347,1363177085517593,1363177085554515,1363177085555141,1363177085517347,1363177085517593,1363177085554515,1363177085555141,1363177085517231,1363177085517231,1363177085556181,1363177085556181,1363177085555925,1363177085555925,1363177085556619,1363177085556619,1363177085517313,1363177085517329,1363177085517501,1363177085554199,1363177085555355,1363177085555555,1363177085555885,1363177085555999,1363177085556159,1363177085556749,1363177085556947,1363177085517313,1363177085517329,1363177085517501,1363177085554199,1363177085555355,1363177085555555,1363177085555885,1363177085555999,1363177085556159,1363177085556749,1363177085556947,1363177085517199,1363177085556899,1363177085517199,1363177085556899,1363177085555943,1363177085555943,1363177085517321,1363177085555359,1363177085555793,1363177085557067,1363177085517321,1363177085555359,1363177085555793,1363177085557067,1363177085556715,1363177085556715,1363177085554195,1363177085554195,1363177085555041,1363177085556133,1363177085556557,1363177085555041,1363177085556133,1363177085556557,1363177085555977,1363177085555977,1363177085555401,1363177085555401,1363177085517361,1363177085517673,1363177085554797,1363177085555439,1363177085555913,1363177085555921,1363177085555961,1363177085555973,1363177085556095,1363177085556161,1363177085556189,1363177085556225,1363177085517361,1363177085517673,1363177085554797,1363177085555439,1363177085555913,1363177085555921,1363177085555961,1363177085555973,1363177085556095,1363177085556161,1363177085556189,1363177085556225,1363177085555935,1363177085556213,1363177085556639,1363177085555935,1363177085556213,1363177085556639,1363177085517481,1363177085517521,1363177085554813,1363177085517481,1363177085517521,1363177085554813,1363177085555259,1363177085556503,1363177085556759,1363177085556781,1363177085556783,1363177085556787,1363177085556875,1363177085556877,1363177085517327,1363177085554759,1363177085555465,1363177085555971,1363177085555997,1363177085556291,1363177085556445,1363177085556623,1363177085517327,1363177085554759,1363177085555465,1363177085555971,1363177085555997,1363177085556291,1363177085556445,1363177085556623,1363177085555981,1363177085556425,1363177085517429,1363177085556641,1363177085556645,1363177085556649,1363177085555833,1363177085556041,1363177085556245,1363177085556259,1363177085556275,1363177085555655,1363177085555649,1363177085556069,1363177085556247,1363177085555827,1363177085556243,1363177085556821,1363177085555715,1363177085556171,1363177085557059,1363177085517187,1363177085556229,1363177085556563,1363177085556609,1363177085556775,1363177085556841,1363177085556979,1363177085556973,1363177085557113


//         JSONObject jsonObject=new JSONObject(jsonOrg);
//         JSONArray resultsjsonArray=jsonObject.getJSONArray("results");
//        JSONArray allTestsjsonArray=resultsjsonArray.getJSONObject(0).getJSONArray("allTests");
//        for (int i = 0; i < allTestsjsonArray.length(); i++) {
//            JSONObject nickJson=allTestsjsonArray.getJSONObject(i);
//            Iterator<String> keys=nickJson.keySet().iterator();
//            while(keys.hasNext()){
//                String key=keys.next();
////                System.out.println(key);
//                JSONObject keyJSONobj=new JSONObject(key).getJSONObject("data");
//
//                result+=keyJSONobj.getString("memberId")+"\t"+keyJSONobj.getString("token")+"\n";
//
//                System.out.println(keyJSONobj.getString("memberId"));
//                System.out.println(keyJSONobj.getString("token"));
//            }
//        }
//        Util_File.string2Stream(result,"D:\\Work\\tokenList.txt");






//        System.out.println(String.format(upload,"用户429175","2022-07-20 07:44:41","男","2022-07-20 07:45:06","30478240","18056429175","2207190000005716"));
//        for (int i = 0; i <mapStringArray.length ; i++) {



//        String[] mapStringArray=Util_File.inputStream2String("D:\\Work\\门店商品数据.txt").split("\n");
//
//        String sqlResult="INSERT INTO `hmm_merchant_goods_new`.`map_goods_shop`(`goods_id`, `shop_id`, `is_marketing_goods_id`)VALUES (%s,%s,0);";
//        String result="";
//        for (int i = 0; i < mapStringArray.length; i++) {
//            String[] line=mapStringArray[i].split("\t");
//            String goods_id=line[1].trim();
//            result+=String.format(sqlResult,goods_id,1098,0)+"\n";
//        }
//        System.out.println(result);


//        Date yesterday= null;
//        try {
//            yesterday = new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-01");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < 30; i++) {
//             yesterday=getYesterday(yesterday);
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(yesterday));
//        }
//        Gson gson=new Gson();
//        System.out.println(gson.toJson(new MonthlyTip()));




//        String[] hmmOrg=Util_File.inputStream2String("D:\\Work\\平台71.txt").split("\n");
//        String[] tlOrg=Util_File.inputStream2String("D:\\Work\\通联71.txt").split("\n");
//
////        idsmap 左边 key为 hmmorg id 右边value为 tl
//         //以通联数据为准 进行逐条 匹配
//        for (int i = 0; i < tlOrg.length; i++) {//逐条匹配之后记录
//            String[] lineCell=tlOrg[i].trim().split("\t");
//            String amountTl=lineCell[12].trim();
//            String tradeTl=lineCell[13].trim();
//            String idTl=i+"";
//            boolean isHas=false;
////            System.out.println(amountTl+":"+tradeTl);
//
//            for (int j = 0; j <hmmOrg.length ; j++) {
//                String[] lineHmmCell=hmmOrg[j].trim().split("\t");
//                String amountHm=lineHmmCell[6].trim();
//                String tradeHm=lineHmmCell[8].trim();
//                String idHm=j+"";
//                if(!isHas){
//                    if(amountTl.equals(amountHm)&&tradeHm.equals(tradeTl)){
//                        if(idsmap.get(idHm)==null){
//                            isHas=true;
//                            idsmap.put(idHm,idTl);
//                        }
//                    }
//                }
//
//
//            }
//            if(!isHas){
//                System.out.println("未识别到得通联数据:"+i+"-"+amountTl+":"+tradeTl);
//            }
//        }


//        String ytbJson="{\"MemberID\":\"2010310064615628\",\"CardName\":\"o1Hj5025\",\"AppID\":\"27082865\",\"Command\":\"pcPreCalcPop\",\"DeliverInfo\":{\"DeliveryTime\":\"下午\",\"ThDepartID\":\"003\",\"DeliveryShopId\":\"273\",\"DeliveryDate\":\"2021-07-11\",\"DeliveryType\":\"10\"},\"IsChkPopOK\":\"Y\",\"CardTel\":\"13897267782\",\"LoginSequence\":\"7B2978F6\",\"SaleInfo\":[{\"IsZP\":\"N\",\"MemberCartDetailId\":\"9999999\",\"Number\":\"1\",\"Price\":\"1.0\",\"PopNo\":\"null\",\"IsCardGoods\":\"N\",\"SalePrice\":\"1.0\",\"RowNo\":0.0,\"FactPrice\":\"1.0\",\"GoodsID\":\"6907830274860\",\"GoodsName\":\"1元抢购50元水育项目代金券\"}],\"DepartID\":\"003\"}";
//        Pattern pattern=Pattern.compile(".*\\\"PopNo\\\":\\\"[0-9]+\\\".*");
//        Matcher matcher=pattern.matcher(ytbJson);
//        if(matcher.find()){
//            System.out.println("有活动");
//        }


    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof CharSequence) {
            return ((CharSequence)obj).length() == 0;
        } else if (obj instanceof Collection) {
            return ((Collection)obj).isEmpty();
        } else {
            return obj instanceof Map ? ((Map)obj).isEmpty() : false;
        }
    }

    public static class Goods{
        private String goodsBrandId;
        private String goodsBarCode;
        private String categoryId;
        private BigDecimal goodsAmount;

        public String getGoodsBrandId() {
            return goodsBrandId;
        }

        public String getGoodsBarCode() {
            return goodsBarCode;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public BigDecimal getGoodsAmount() {
            return goodsAmount;
        }

        public Goods(String goodsBrandId, String goodsBarCode, String categoryId, BigDecimal goodsAmount) {
            this.goodsBrandId = goodsBrandId;
            this.goodsBarCode = goodsBarCode;
            this.categoryId = categoryId;
            this.goodsAmount = goodsAmount;
        }
    }

    public static class MonthlyTip {//月度专题
        private Long id=1L;
        private String name="名字";
        private String description="简介";
        private Integer isDelete=0;
        private Long topicId=1L;//话题ID
        private Long postPkId=1L;//PK帖子ID
        private String videoIds="1,2,3";//关联的憨妈课堂的 ids
        private String goodsIds="1,2,3";//关联的商品的ids
        private Integer questionType=1;//关联的专家答疑提问类型  5071接口中的 expertCategoryNo
        private Date createTime=new Date();
        private Date updateTime=new Date();
    }

    public static Date getYesterday(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        // 时
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 分
        calendar.set(Calendar.MINUTE, 0);
        // 秒
        calendar.set(Calendar.SECOND, 0);
        // 毫秒
        calendar.set(Calendar.MILLISECOND, 0);

//        calendar.add(Calendar.DATE,-1);

        date = calendar.getTime();
        return date;
    }

    private static void extractedMap(String filePath,Map<String, String> idsmap) {
        idsmap.clear();
        String[] mapStringArray=Util_File.inputStream2String(filePath).split("\n");
        for (int i = 0; i < mapStringArray.length; i++) {
            idsmap.put(mapStringArray[i].split("\t")[0],mapStringArray[i]);
        }
    }

    public static String getMapResult(Map<String, String> idsmap,String key){
        String result="";
        result=idsmap.get(key);
        if(TextUtils.isEmpty(result)){
            result="";
        }
        return result.trim();
    }

    public static void element(NodeList list){
        for (int i = 0; i <list.getLength() ; i++) {
            Element element = (Element) list.item(i);
            NodeList childNodes = element.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()== Node.ELEMENT_NODE) {
                    //获取节点
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    //获取节点值
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }

    public static void node(NodeList list){
        for (int i = 0; i <list.getLength() ; i++) {
            Node node = list.item(i);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }



    public static void mainNow(String[] args) {
//        HMMDao.getInstance().setDbname("D:\\Work\\hmmcopy");
//        HMMDao.getInstance().createTable("CREATE TABLE if not exists hmm_online_flow3 (\n" +
//                "    id  PRIMARY KEY,\n" +
//                "    bill_id,\n" +
//                "    biz_user_id,\n" +
//                "    source_id,\n" +
//                "    source_type,\n" +
//                "    status,\n" +
//                "    amount,\n" +
//                "    trade_fee,\n" +
//                "    service_fee,\n" +
//                "    type,\n" +
//                "    balance,\n" +
//                "    create_time,\n" +
//                "    update_time\n" +
//                ");");
//        buildDb();
//        doCheck();
//        docheckPit("D:\\Work\\1月通联流水.txt");



//        HMMDao.getInstance().close();
//        luodingCheck();

        String mapSource="18036097021\t2011190000030849\n" +
                "18036092297\t1912140000030678\n" +
                "18036095837\t1912120000012593\n" +
                "18551195219\t2204080000191469\n" +
                "18036095823\t1911280000006604\n" +
                "18036096853\t1912130000104220\n" +
                "18036095171\t2002270000038108\n" +
                "18036097823\t2204060000195743\n" +
                "18036095057\t1912140000029882\n" +
                "18036095073\t2002270000037492\n" +
                "18036096157\t2112290000174278\n" +
                "18036095825\t1911300000015946\n" +
                "18862279539\t2204060000155651\n" +
                "18013063857\t2204060000140048\n" +
                "18012781237\t2204060000086969\n" +
                "18036091052\t2203300000117893\n" +
                "18036095715\t1912110000031764\n" +
                "18036096073\t2204060000103928\n" +
                "18036096232\t2204060000089788\n" +
                "18036097152\t1911210000020484\n" +
                "18115503512\t1912110000028319\n" +
                "18762965069\t2008100000003171\n" +
                "18036091735\t2103260000092914\n" +
                "18068420317\t2204060000129263\n" +
                "18036097083\t2009070000004199\n" +
                "18036090971\t1912120000004710\n" +
                "18036097027\t1912120000001160\n" +
                "18036092275\t2009180000031100\n" +
                "18136097120\t2105130082708570\n" +
                "18036095705\t1912120000002923\n" +
                "18036097082\t1912130000106009\n" +
                "18556955901\t2103200000129179\n" +
                "18036092271\t2002200000011029\n" +
                "18036091727\t2102260000047833\n" +
                "18506289517\t2003130000048359\n" +
                "18912739762\t2107120000024002\n" +
                "18912739165\t2002270000028835\n" +
                "18912739701\t2002240000005012\n" +
                "18036096973\t2106100000338860\n" +
                "18036096803\t2002270000014433\n" +
                "18018125337\t2004290000065698\n" +
                "18036080751\t2109270000089420\n" +
                "18136096795\t2105080000025981\n" +
                "18136081053\t2103300001077132\n" +
                "18036092105\t2008040000008876\n" +
                "18036095373\t2006230000003778\n" +
                "18036090397\t2010220137314983\n" +
                "18036092251\t2109260141288820\n" +
                "19898866663\t2003130000050528\n" +
                "18036098757\t2007180000014728\n" +
                "18036090372\t2109240000184061\n" +
                "18936087537\t2111250000046599\n" +
                "18036096035\t1912120000016648\n" +
                "18036085069\t2204290000168931\n" +
                "18036091306\t2110200000657509\n" +
                "18936094406\t2204060000088592\n" +
                "18936096722\t2204060000135249\n" +
                "18036091807\t2204070000279277\n" +
                "18136098286\t2204290000149031\n" +
                "18136084407\t2103300002218222\n" +
                "18036093805\t2107210000563804\n" +
                "18036090381\t2005280002617575\n" +
                "18036097120\t2205010000210456\n" +
                "18136087683\t2112250000435119\n" +
                "18151597865\t2204180000176460\n" +
                "18021341811\t2204060000547078\n" +
                "18936093940\t2109090001438439\n" +
                "18912739217\t2002200000014271\n" +
                "18912729170\t2204060000456320\n" +
                "18912737192\t2002280000002488\n" +
                "18912713137\t2002280000020218\n" +
                "18912739332\t2001200000014133\n" +
                "18912739159\t2002270000017863\n" +
                "18912737063\t2002200000005483\n" +
                "18912737605\t2001200000009377\n" +
                "18912728172\t2102240000084567\n" +
                "18912723370\t2002270000035421\n" +
                "18912738105\t2002270000018530\n" +
                "18912723109\t2002280000012842\n" +
                "18036083648\t2204080000192355\n" +
                "18912737391\t2002280000019510\n" +
                "18912737559\t2002270000010666\n" +
                "18912738160\t2003020000019870\n" +
                "18912739121\t2002270000001846\n" +
                "18036095972\t1911210000021927\n" +
                "18036097983\t1912130000124726\n" +
                "18936094749\t2111020000285939\n" +
                "18036091593\t2007030000007724\n" +
                "18036093831\t2011140000007815\n" +
                "18015588099\t2002270000050226\n" +
                "18036081082\t2106120000571381\n" +
                "18018129376\t2003040000006383\n" +
                "18018125327\t2003010000003234\n" +
                "18136081273\t2104160000066178\n" +
                "18015533077\t1911290000001929\n" +
                "18136092650\t2105130093066495\n" +
                "18112731715\t2001200000008926\n" +
                "18036093015\t2007290000031019\n" +
                "18036092873\t2012300000061815\n" +
                "18936084071\t2112280001292788\n" +
                "18036083647\t2111250000235758\n" +
                "18912738153\t2002270000021871\n" +
                "18912739215\t2002270000042172\n" +
                "18112736103\t2001200000011183\n" +
                "18112731719\t2002270000002045\n" +
                "18112731063\t2002280000016806\n" +
                "18112736120\t2002280000007088";

        String org="阳春,1456549053320314881\n" +
                "山东,1342294230515515393\n" +
                "合肥康婴坊,1483371209031139329\n" +
                "西爱,1336196294471778305\n" +
                "十堰,1293813464509775873\n" +
                "十堰宝贝豆,1293813464509775873\n" +
                "岳池,1341190730310156290\n" +
                "厦门,1456433973209051138\n" +
                "四川岳池,1341190730310156290\n" +
                "全开,\n" +
                "柒鑫,1483371209031139329\n" +
                "大竹宝贝豆,1337664404726939649\n" +
                "合肥,1483371209031139329\n" +
                "竹山,1447810038882549762\n" +
                "商丘,1352447402219339778\n" +
                "竹山宝贝豆,1447810038882549762\n" +
                "山东诸城,1342294230515515393\n" +
                "六安爱婴金摇篮,1296991286015352834\n" +
                "河北迁安,1337387162331447298\n" +
                "葫芦岛,1428929926867185666\n" +
                "哈一代,1429045135608344578\n" +
                "康婴坊,1364390436305620994\n" +
                "甘肃,1336196294471778305\n" +
                "山西,1345985600602177538\n" +
                "鄂尔多斯,1457543828039188482\n" +
                "唐山,1337387162331447298\n" +
                "罗定,1429372983467044865\n" +
                "青海萌萌哒,1293810683505868802\n" +
                "宝鸡,1411942340420423682\n" +
                "四川达州,1337664404726939649\n" +
                "运城,1345985600602177538\n" +
                "0,1337387162331447298\n" +
                "惠州,1429045135608344578\n" +
                "六安,1296991286015352834\n" +
                "南漳,1338286926598176769\n" +
                "青海,1293810683505868802\n" +
                "迁安,1337387162331447298\n" +
                "大竹,1337664404726939649\n" +
                "寻乌,1290242028184633346\n" +
                "鄂尔多斯未来妈咪,1457543828039188482\n" +
                "瑞金,1473517773160099841\n" +
                "荥阳,1290240084242169858\n" +
                "佛山,1291565991984693250";
        String[] phoneMapStringArray=mapSource.split("\n");
        for (int i = 0; i < phoneMapStringArray.length; i++) {
            idsmap2.put(phoneMapStringArray[i].split("\t")[0].trim(),phoneMapStringArray[i].split("\t")[1].trim());
        }

        String[] merchantMapStringArray=org.split("\n");
        for (int i = 0; i < merchantMapStringArray.length; i++) {
            try {
                idsZhuanzhangmap.put(merchantMapStringArray[i].split(",")[0].trim(),merchantMapStringArray[i].split(",")[1].trim());
            } catch (Exception e) {
                idsZhuanzhangmap.put(merchantMapStringArray[i].split(",")[0].trim(),merchantMapStringArray[i].split(",")[0].trim());
                e.printStackTrace();
            }
        }
        String[] idsAlready=Util_File.inputStream2String("D:\\Work\\IDSA.txt").split("\n");
        for (int i = 0; i < idsAlready.length; i++) {
            idsmap3.put(idsAlready[i].split("\t")[0].trim()+","+idsAlready[i].split("\t")[1].trim(),"has");
        }

        String insertSql="INSERT INTO `hmm_c_member`.`hmm_member_partner` ( `member_id`, `partner_id`, `badge_id`, `create_time`, `latest_update_time`) VALUES ('%s', '%s', NULL, '2022-03-22 00:00:00', '2022-03-22 00:00:00');";
//        String sqlCompany="select partner.id from hmm_partner.partner partner\n" +
//                "left join hmm_merchant_user.user_info user_info on user_info.partner_id=partner.id\n" +
//                "where merchant_type=2\n" +
//                "and (%s)";
//        String memberSql= "select member_id from hmm_c_member.hmm_member_info where phone='%s'";
//        String memberSql2= "select member_id from hmm_c_member.hmm_member_info where phone in (%s) order by FIELD(member_id,%s)";
        String[] stringArray=Util_File.inputStream2String("D:\\Work\\IDS.txt").split("\n");
        String phoneSet="";
        for (int i = 0; i <stringArray.length ; i++) {
            String line=stringArray[i];
            String phone=line.split("\t")[0].trim();
            phoneSet+=phone+",";
            String memberId=idsmap2.get(phone);
            String keyNameArrayString= line.split("\t")[1].trim();
//            System.out.println(String.format(memberSql,phone));
            if(TextUtils.isEmpty(memberId)){
                resultMap.put(phone,"");
            }else {
                String[] keyNameArray=null;
                try {
                    keyNameArray = keyNameArrayString.split("，");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String sqlResult="";

                if(keyNameArray.length>0){
                    for (int j = 0; j < keyNameArray.length; j++) {
                        if(!TextUtils.isEmpty(keyNameArray[j].trim())){
                            if(idsmap3.get(phone+","+idsZhuanzhangmap.get(keyNameArray[j].trim()))==null){
                                sqlResult+=String.format(insertSql,memberId,idsZhuanzhangmap.get(keyNameArray[j].trim()));
                            }
                        }
                    }
                }
                resultMap.put(phone,sqlResult);
                if(keyNameArrayString!=null&&keyNameArrayString.contains("全开")){
                    resultMap.put(phone,"");
                }

            }



        }
        String idsAllZHuanMap = "";
//        int index=0;
//        for (Map.Entry<String, String> entry : idsmap.entrySet()) {//迭代规格选择
//            if(!TextUtils.isEmpty(checkMapHas(idsZhuanzhangmap,entry.getKey().trim()))){
//                System.out.println("发现了");
//                idsmap.put(entry.getKey().trim(),checkMapHas(idsZhuanzhangmap,entry.getKey().trim()));
//            }
////            idsAllZHuanMap+=String.format(" company_full_name like '%%%s%%'",entry.getKey().trim())+" or";
////            System.out.println(String.format(sqlCompany,String.format(" company_full_name like '%%%s%%'",entry.getKey().trim())));
//
//        }
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {//迭代规格选择
            if(!TextUtils.isEmpty(entry.getValue())){

                idsAllZHuanMap +=entry.getValue() + "\n";
            }

        }
//        System.out.println(index);
//        idsAllZHuanMap=idsAllZHuanMap.substring(0,idsAllZHuanMap.length()-2);
//        System.out.println(String.format(sqlCompany,idsAllZHuanMap));


        Util_File.string2Stream(idsAllZHuanMap, "D:\\Work\\SQl汇总.txt");
        System.out.println(phoneSet);
//        System.out.println(phoneSet.split(",").length);
//        phoneSet=phoneSet.substring(0,phoneSet.length()-1);
//        System.out.println(String.format(memberSql2,phoneSet,phoneSet));




//        String[] platformFlow=Util_File.inputStream2String("D:\\Work\\罗定平台流水.txt").split("\n");
//        String[] merchantFlow=Util_File.inputStream2String("D:\\Work\\罗定商家流水.txt").split("\n");
//        BigDecimal amountAllplatform=new BigDecimal(0);
//        BigDecimal amountAllMerchant=new BigDecimal(0);
//        for (int i = 0; i < platformFlow.length; i++) {
//            String amoutPlat=platformFlow[i].split("\t")[1].trim();
//            String platformSubOrderId=platformFlow[i].split("\t")[3].trim();
//            double amoutMerchant = 0;
//            try {
//                amoutMerchant = new BigDecimal(amoutPlat).doubleValue();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            amountAllplatform=amountAllplatform.add(new BigDecimal(amoutMerchant));
//
//        }
//        for (int j = 0; j < merchantFlow.length; j++) {
//            if(!TextUtils.isEmpty((merchantFlow[j]))){
//                double amoutMerchant = 0;
//                try {
//                    amoutMerchant = new BigDecimal(merchantFlow[j].split("\t")[3].trim()).multiply(new BigDecimal(100)).doubleValue();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
////                String merchantSubOrderId=merchantFlow[j].split("\t")[0].trim();
////                if(amoutPlat.equals(((int)amoutMerchant)+"")&&platformSubOrderId.equals(merchantSubOrderId)){
////                    platformFlow[i]="";
////                    merchantFlow[j]="";
////                    break;
////                }
//
//                amountAllMerchant=amountAllMerchant.add(new BigDecimal(amoutMerchant));
//            }
//
//        }
//        System.out.println("保存最后结果"+amountAllplatform+":"+amountAllMerchant);
//        String resultPlatformResult=subStringArray(platformFlow,0);
//        Util_File.string2Stream(resultPlatformResult, "D:\\Work\\罗定平台流水.txt");
//        String resultMerchantResult=subStringArray(merchantFlow,0);
//        Util_File.string2Stream(resultMerchantResult, "D:\\Work\\罗定商家流水.txt");
    }

    private static String checkMapHas(Map<String, String> idsZhuanzhangmap,String trim) {
        for (Map.Entry<String, String> entry : idsZhuanzhangmap.entrySet()) {//迭代规格选择
            if(entry.getKey().contains(trim)){
                return entry.getValue();
            }

        }
        return null;
    }

    private static void luodingCheck() {
        String[] platformFlow=Util_File.inputStream2String("D:\\Work\\罗定平台流水.txt").split("\n");
        String[] merchantFlow=Util_File.inputStream2String("D:\\Work\\罗定商家流水.txt").split("\n");
        for (int i = 0; i < platformFlow.length; i++) {
            String amoutPlat=platformFlow[i].split("\t")[1].trim();
            String platformSubOrderId=platformFlow[i].split("\t")[3].trim();
            for (int j = 0; j < merchantFlow.length; j++) {
                if(!TextUtils.isEmpty((merchantFlow[j]))){
                    double amoutMerchant = 0;
                    try {
                        amoutMerchant = new BigDecimal(merchantFlow[j].split("\t")[3].trim()).multiply(new BigDecimal(100)).doubleValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String merchantSubOrderId=merchantFlow[j].split("\t")[0].trim();
                    if(amoutPlat.equals(((int)amoutMerchant)+"")&&platformSubOrderId.equals(merchantSubOrderId)){
                        platformFlow[i]="";
                        merchantFlow[j]="";
                        break;
                    }
                }

            }
        }
        System.out.println("保存最后结果");
        String resultPlatformResult=subStringArray(platformFlow,0);
        Util_File.string2Stream(resultPlatformResult, "D:\\Work\\罗定平台流水.txt");
        String resultMerchantResult=subStringArray(merchantFlow,0);
        Util_File.string2Stream(resultMerchantResult, "D:\\Work\\罗定商家流水.txt");
    }

    public static String subStringArray(String[] org,int start){
        String result="";
        for (int i = start; i < org.length; i++) {
            if(!TextUtils.isEmpty(org[i].trim())){
                result+=org[i]+ "\n";
            }
        }
        return result;
    }


    private static void docheckPit(String path) {
        String oldMap=Util_File.inputStream2String("D:\\Work\\平台已对结果Map.txt");
        if(!TextUtils.isEmpty(oldMap)){
            String[] oldMapLine=oldMap.split("\n");
            for (int i = 0; i < oldMapLine.length; i++) {
                idsmap.put(oldMapLine[i].split(",")[0],oldMapLine[i].split(",")[1]);
                idsmap2.put(oldMapLine[i].split(",")[1],oldMapLine[i].split(",")[0]);
            }
        }
        String tmp=Util_File.inputStream2String("D:\\Work\\通联IDS.txt");
        String[] lines=tmp.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if(idsmap2.get(lines[i].trim())==null){
                System.out.println(lines[i].trim()+"-----------");
            }
        }



    }

    private static void buildDb() {
        HMMDao.getInstance().createTable("CREATE TABLE if not exists hmm_online_flow3 (\n" +
                "    id  PRIMARY KEY,\n" +
                "    bill_id,\n" +
                "    biz_user_id,\n" +
                "    source_id,\n" +
                "    source_type,\n" +
                "    status,\n" +
                "    amount,\n" +
                "    trade_fee,\n" +
                "    service_fee,\n" +
                "    type,\n" +
                "    balance,\n" +
                "    create_time,\n" +
                "    update_time\n" +
                ");");

//        String[] flowALLStringArray=Util_File.inputStream2String("D:\\Work\\hmmonlieflowtxt.txt").split("\n");
//        for (int i = 0; i < flowALLStringArray.length; i++) {
//            System.out.println("进度"+(i+1)+"/"+flowALLStringArray.length);
//            String[] flowStringArray=flowALLStringArray[i].split(",");
//
//            String sql= null;
//            try {
//                sql = String.format("insert into hmm_online_flow (" +
//                                "id," +
//                                "bill_id," +
//                                "biz_user_id," +
//                                "source_id," +
//                                "source_type," +
//                                "status," +
//                                "amount," +
//                                "trade_fee," +
//                                "service_fee," +
//                                "type," +
//                                "balance," +
//                                "create_time," +
//                                "update_time" +
//                                ") values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
//                        flowStringArray[0].trim(),
//                        flowStringArray[1].trim(),
//                        flowStringArray[2].trim(),
//                        flowStringArray[3].trim(),
//                        flowStringArray[4].trim(),
//                        flowStringArray[5].trim(),
//                        flowStringArray[6].trim(),
//                        flowStringArray[7].trim(),
//                        flowStringArray[8].trim(),
//                        flowStringArray[9].trim(),
//                        flowStringArray[10].trim(),
//                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("M/d/yyyy HH:mm:ss").parse(flowStringArray[11].trim())),
//                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("M/d/yyyy HH:mm:ss").parse(flowStringArray[12].trim())));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            HMMDao.getInstance().add(sql);
//        }
    }

    private static void doCheck() {
        int againTime=5;
//        deep=8640*60l;


        String oldMap=Util_File.inputStream2String("D:\\Work\\平台已对结果Map.txt");
        if(!TextUtils.isEmpty(oldMap)){
            String[] oldMapLine=oldMap.split("\n");
            for (int i = 0; i < oldMapLine.length; i++) {
                idsmap.put(oldMapLine[i].split(",")[0],oldMapLine[i].split(",")[1]);
            }
        }
        String oldZhuanMap=Util_File.inputStream2String("D:\\Work\\平台转账结果.txt");
        if(!TextUtils.isEmpty(oldZhuanMap)){
            String[] oldMapLine=oldZhuanMap.split("\n");
            for (int i = 0; i < oldMapLine.length; i++) {
                idsZhuanzhangmap.put(oldMapLine[i].split(",")[0],oldMapLine[i].split(",")[1]);
            }
        }
        String errorListString = "";
        String errorListString1 = "";
        String errorListString2 = "";
        String errorListString3 = "";
        String errorListString4 = "";
        String oldTongString=Util_File.inputStream2String("D:\\Work\\通联对账结果.txt");

        checkBill(Util_File.inputStream2String("D:\\Work\\0月通联流水.txt"), deep*10 * 1000);
//        errorListString = flash(againTime, errorListString, oldTongString);

//        Util_File.string2Stream(errorListString, "D:\\Work\\通联对账结果.txt");
//
//
//        String idsAll = "";
//        for (Map.Entry<String, String> entry : idsmap.entrySet()) {//迭代规格选择
//            if(!entry.getKey().trim().contains("R")){
//
//                idsAll += entry.getKey().trim() + ",";
//            }
//        }
//        String idsAllMap = "";
//        for (Map.Entry<String, String> entry : idsmap.entrySet()) {//迭代规格选择
//            idsAllMap += entry.getKey().trim() + "," + entry.getValue() + "\n";
//        }
//        String idsAllZHuanMap = "";
//        for (Map.Entry<String, String> entry : idsZhuanzhangmap.entrySet()) {//迭代规格选择
//            idsAllZHuanMap += entry.getKey().trim() + "," + entry.getValue() + "\n";
//        }
//        Util_File.string2Stream(idsAllZHuanMap, "D:\\Work\\平台转账结果.txt");
//        Util_File.string2Stream(idsAll, "D:\\Work\\平台已对结果.txt");
//        Util_File.string2Stream(idsAllMap, "D:\\Work\\平台已对结果Map.txt");
    }

    private static String flash(int againTime, String errorListString, String oldTongString) {
        if(!TextUtils.isEmpty(oldTongString)){
            backTime=1;
            errorListString +=checkBill(oldTongString,deep*10*1000);
        }else {
            errorListString += checkBill(Util_File.inputStream2String("D:\\Work\\0月通联流水.txt"), deep*10 * 1000);
//            System.out.println("----------------------检测1月的----------------------");
//            errorListString += checkBill(Util_File.inputStream2String("D:\\Work\\2月通联流水.txt"), deep*10 * 1000);
//            System.out.println("----------------------检测2月的----------------------");
//            errorListString += checkBill(Util_File.inputStream2String("D:\\Work\\3月通联流水.txt"), deep*10 * 1000);
//            System.out.println("----------------------检测3月的----------------------");
//            errorListString += checkBill(Util_File.inputStream2String("D:\\Work\\4月通联流水.txt"), deep*10 * 1000);
//            System.out.println("----------------------检测4月的----------------------");
        }
        oldLine= errorListString.split("\n").length;
        deep++;
        errorListString =checkBill(errorListString,deep*10 * 1000);
        System.out.println("扫描深度1:"+deep+"级"+"新老页数:"+oldLine+","+nowLine);
        int checkTime=0;
        while (oldLine>nowLine||(oldLine<=nowLine&&checkTime<= againTime)){
            if(deep>=8640l){
                deep=deep+8640l;
            }else {
                deep=deep+2;
            }
            if(deep>10&&deep<8640){
                deep=8640l;
            }
            System.out.println("扫描深度2:"+deep+"级"+"新老页数:"+oldLine+","+nowLine);
            oldLine= errorListString.split("\n").length;

            errorListString =checkBill(errorListString,deep*10 * 1000);

            if(oldLine>nowLine){
                checkTime=0;
            }else {
                checkTime++;
            }
            if(backTime==0){
                System.out.println("开始回归");
                backTime=1;
                deep=1;
                checkTime=0;
            }
        }
        System.out.println("最终扫描深度"+deep);
        return errorListString;
    }

    public static String checkBill(String content, long limit) {
        BigDecimal money=new BigDecimal(0);
        String errorListString = "";
        String[] line = content.split("\n");
        for (int i = 0; i < line.length; i++) {
            String[] cells = line[i].split(",", -1);
            double amount = 0;
            try {
                amount = new BigDecimal(cells[6].trim()).multiply(new BigDecimal(100)).doubleValue();
            } catch (Exception e) {
                System.err.println(line[i]);
                e.printStackTrace();
            }
            System.out.println("当前进度"+(i+1)+"/"+line.length);
            String orderIdTongLian = cells[0].trim();
            String business = cells[2].trim();
            String version = cells[1].trim();
            String createTime = cells[10].trim();
            String status = cells[15].trim();
            String sourceId=cells[23].trim();
            String oldOrderIdTongLian=cells[17].trim();
            String orderBack=cells[22].trim();
            String receiveCompany=cells[21].trim();
//            System.out.println(orderBack);
//            if("1505198159557562368".equals(orderIdTongLian)){
//                System.out.println(line[i]);
//            }
            if(!status.contains("交易失败") && !version.contains("PREPRO")){
                if(business.contains("转账")){
//                    System.out.println("设置oldOrderId"+orderIdTongLian);
//                    idsZhuanzhangmap.put(orderIdTongLian,orderIdTongLian);
                    errorListString = getDocString(limit, errorListString, line, i, cells, amount, orderIdTongLian,oldOrderIdTongLian, createTime, sourceId,orderBack,1);
                }
                if(business.contains("代付")){

                    Date startDate = null;
                    try {
                        startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(createTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    boolean isBetween=false;
                    try {
                        if(startDate.after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-03-01 00:00:00"))
                                &&
                                startDate.before(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-01 00:00:00"))){
                            isBetween=true;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                        if("pro502".equals(receiveCompany)&&isBetween){
                            System.out.println(amount);
                            money=money.add(new BigDecimal(amount));
                        }
//                    errorListString = getDocString(limit, errorListString, line, i, cells, amount, orderIdTongLian,oldOrderIdTongLian, createTime, sourceId,orderBack,1);
                }
                if(business.contains("退款")){

//                    errorListString = getDocString(limit, errorListString, line, i, cells, amount, orderIdTongLian,oldOrderIdTongLian, createTime, sourceId,orderBack,-1);
                }
                if(business.contains("提现")){
//                    errorListString = getDocString(limit, errorListString, line, i, cells, amount, orderIdTongLian,oldOrderIdTongLian, createTime, sourceId,orderBack,2);
                }
            }

        }
        System.out.println("通联代付总额"+money.toString());
        nowLine=errorListString.split("\n").length;
        return errorListString;
    }

    private static String getDocString(long limit, String errorListString, String[] line, int i, String[] cells, double amount, String orderIdTongLian,String oldOrderIdTongLian, String createTime, String sourceId,String orderBack,int type) {
        long tonglianCreateTime = 0;
        try {
            tonglianCreateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(createTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date startDate = new Date(tonglianCreateTime);
        Date endDate = new Date(tonglianCreateTime + limit);
//        System.out.println(tonglianCreateTime + limit);
        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate);
        String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate);
        String selectSql = "";
        String notinid = "";
        try {
            if(startDate.after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-08 16:20:41"))){
                return "";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(type==-1){
            selectSql = String.format("" +
                            "select * from hmm_online_flow2 where  source_type='2' and type ='"+type+"'and create_time >= '%s' and create_time <= '%s' and amount <='%s' and  amount >='%s' order by create_time asc,amount desc"
                    , startTime, endTime,(int) amount,(int)(amount*0.98));

        }else if(type==1){
            if(orderBack!=null&&orderBack.contains("购买憨妈赚商品")){
                selectSql = String.format("" +
                                "select * from hmm_online_flow where source_type='8' and amount ='%s' and type ='"+type+"'and create_time >= '%s' and create_time <= '%s' order by create_time asc"
                        , (int) amount, startTime, endTime);
            }else if(orderBack!=null&&orderBack.contains("预约")){
                selectSql = String.format("" +
                                "select * from hmm_online_flow where source_type='3' and amount ='%s' and type ='"+type+"'and create_time >= '%s' and create_time <= '%s' order by create_time asc"
                        , (int) amount, startTime, endTime);
            }else if(orderBack!=null&&orderBack.contains("憨妈赚合伙人")){
                selectSql = String.format("" +
                                "select * from hmm_online_flow where source_type='9' and amount ='%s' and type ='"+type+"'and create_time >= '%s' and create_time <= '%s' order by create_time asc"
                        , (int) amount, startTime, endTime);
            }else if(orderBack!=null&&orderBack.contains("付费")){
                selectSql = String.format("" +
                                "select * from hmm_online_flow where source_type='4' and amount ='%s' and type ='"+type+"'and create_time >= '%s' and create_time <= '%s' order by create_time asc"
                        , (int) amount, startTime, endTime);
            }
            else{
                selectSql = String.format("" +
                                "select * from hmm_online_flow where amount ='%s' and type ='"+type+"'and create_time >= '%s' and create_time <= '%s' order by create_time asc"
                        , (int) amount, startTime, endTime);
            }
        }else if(type==2){

            selectSql = String.format("" +
                            "select * from hmm_online_flow2 where source_type='11' and amount ='%s' and type ='"+-1+"'and create_time >= '%s' and create_time <= '%s' order by create_time asc"
                    , (int) amount, startTime, endTime);
        }


        ResultSet resultSet = HMMDao.getInstance().select(selectSql);

        if(!TextUtils.isEmpty(sourceId)){
//            System.out.println("sourceId:"+sourceId);
//            System.out.println(selectSql);
        }
        try {
            boolean hasCheck = false;
            while (resultSet.next()) {
                hasCheck = false;

                String onlineId = resultSet.getString("id");
                String onlinesourceId = resultSet.getString("source_id");

                if(!TextUtils.isEmpty(sourceId)&&type==1){
                    if(sourceId.equals(onlinesourceId)&&type==1){
                        if(idsmap.get(onlineId) == null){
                            hasCheck = true;
                            idsmap.put(onlineId+"", orderIdTongLian);
                            break;
                        }else {
                            hasCheck = true;
                            idsmap.put(onlineId+"R", orderIdTongLian);
                            break;
                        }

                    }
                }else {
                    if(backTime>=1){
                        if (idsmap.get(onlineId) == null) {
                            hasCheck = true;
                            idsmap.put(onlineId, orderIdTongLian);
                            break;
                        } else {
                            if(orderIdTongLian.equals(idsmap.get(onlineId))){
                                hasCheck=true;
                                break;
                            }
                        }
                    }

                }





            }
            if(type==-1){
                if(idsZhuanzhangmap.get(oldOrderIdTongLian)!=null){//属于转账退款自循环
                    hasCheck=true;
                }
            }
//            System.out.println(orderIdTongLian);
            if(orderIdTongLian.equals("1512277072519630848")){
                            System.out.println(orderIdTongLian);
                            System.out.println(selectSql);
            }
//            System.out.println(orderIdTongLian);
//            System.out.println(selectSql);
//            if(orderIdTongLian.equals("1487439589713911808")){
//
//            }
            if (!hasCheck) {
                errorListString += line[i] + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return errorListString;
    }
}
