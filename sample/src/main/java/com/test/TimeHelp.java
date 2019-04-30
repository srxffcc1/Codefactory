package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelp {
    public static void main(String[] args) {
//	for (int i = 0; i < 37; i++) {
//		System.out.println(".add(new Entity_Book"+i+"())");
//	}
//	try {
//		Date date1=new Date();
//		System.out.println(date1.getTime());
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sssssssss");
//		String d=sdf.format(date1);
//		Date date2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sssssssss").parse(d);
//		System.out.println(date2.getTime());
//		Date date3=new Date();
//		System.out.println(date3.getTime());
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

//	String datestring="";
//	Date date=new Date();
//	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
//	datestring=sdf.format(date);
//	System.out.println(datestring);
//	Base_Entity base=new Base_Entity();
//	Gson gson = new Gson();
//	
//	System.out.println(gson.toJson(base));

//			
//			try {
//				Date date=new Date(Long.parseLong("-2209017600000"));
//				System.out.println(date);
//				System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		String[] ss=new String[]{"ssss","sdasdasd"};
//		String[] sss=new String[]{"aaaa"};
//		String[] result=add(ss, sss);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
//	System.out.println(getRealTime("1481874480000"));
//	System.out.println(getTime("2016-07-18 11:00:43"));
//	String where=new Date().getTime()+"";
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
////	System.out.println(where);
//	Date date=new Date();
//			date.setTime(1500556360726l);
//	System.out.println(sdf.format(date).toString());
        String time = "2013年10月1日14时27分10秒";
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
                    System.out.println("start:" + start + ",end:" + end);
                    e.printStackTrace();
                }
                start = i + 1;
            }
        }
        System.out.println(nian + "年" + yue + "月" + ri + "日" + shi + "时" + fen + "分" + miao + "秒");


    }

    public static String getTime(String time) {
        String resulttime = "";
        if (time == null || time.equals("")) {
            resulttime = (new Date()).getTime() + "";
        } else {
            if (time.matches("(.+)-(.*)")) {
                String[] headresultarray = time.split(" ");
                String headresult = "";
                if (headresultarray.length < 1) {
                    headresult = time;
                } else {
                    headresult = time.split(" ")[0];
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
                    bodyresult = bodyresult + (bodysplit[i] != null ? bodysplit[i] : "00") + ":";
                }
                if (bodyresult != null && bodyresult.length() > 0) {
                    bodyresult = bodyresult.substring(0, bodyresult.length() - 1);
                }
                resulttime = headresult + " " + bodyresult;
                try {
                    resulttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resulttime).getTime() + "";
                } catch (ParseException e) {
                    e.printStackTrace();
                    try {

                        System.exit(0);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

            } else {
                resulttime = time;
            }
        }


        return resulttime;
    }

    public static String getRealTime(String longstr) {
        String result = "";
        try {
            Date date = new Date(Long.parseLong(longstr));

            result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }
}
