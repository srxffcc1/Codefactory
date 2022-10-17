package com.test;

import com.codefactory.utils.Util_File;
import org.apache.http.util.TextUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utils.HMMDao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HMMCopyShopTest {

    public static Map<String, String> idsmap = new HashMap<>();
    public static Map<String, String> idsZhuanzhangmap = new HashMap<>();
    public static Map<String, String> idsmap2 = new HashMap<>();
    public static Map<String, String> idsmap3 = new HashMap<>();
    public static Map<String, String> resultMap = new HashMap<>();
    public static long deep=1;
    public static int backTime=0;
    public static int oldLine=0;
    public static int nowLine=0;
    public static String  updateS;

    public static DocumentBuilderFactory documentBuilderFactory;
    public static DocumentBuilder db;
    public static void main(String[] args) {


    }

}
