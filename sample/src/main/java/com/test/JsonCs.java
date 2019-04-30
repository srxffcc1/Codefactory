//package com.test;
//
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import utils.Util_Dao;
//
//public class JsonCs {
//    public static void main(String[] args) {
//        String jsonarray = "";
//        Util_Dao.create().setDbname("org.db");
//        ResultSet res2 = Util_Dao.create().seach("select * from tb_zhifayijuk");
//        List<String> jsonlist = new ArrayList<String>();
//        try {
//            if (res2 != null) {
//                ResultSetMetaData rsm = res2.getMetaData();
//                List<String> columnlist = new ArrayList<String>();
//                int count = rsm.getColumnCount();
//                for (int j = 0; j < count; j++) {
//                    String columm = new String();
//                    columm = rsm.getColumnName(j + 1);
//                    columnlist.add(columm);
//                }
//                int conut = 0;
//                while (res2.next()) {
//                    String subjson = "";
//                    for (int j = 0; j < columnlist.size(); j++) {
//                        String h1 = columnlist.get(j);
//                        String h2 = res2.getString(columnlist.get(j));
//                        if (h2 != null) {
//                            h2 = h2.replaceAll("\"", "“");
//
//                        } else {
//                            h2 = "null";
//                        }
//
//                        subjson = subjson + "\"" + columnlist.get(j) + "\"" + ":\"" + h2 + "\"" + ",";
//                    }
//                    subjson = subjson.substring(0, subjson.length() - 1);
//                    subjson = "{" + subjson + "}";
//                    jsonlist.add(subjson);
//                }
//                for (int i = 0; i < jsonlist.size(); i++) {
//                    jsonarray = jsonarray + jsonlist.get(i) + ",";
//                }
//                Util_Dao.create().close();
//                jsonarray = jsonarray.substring(0, jsonarray.length() - 1);
//                jsonarray = "{" + "\"rows\":" + "[" + jsonarray + "]" + "}";
//                System.out.println(jsonarray);
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//    }
//}
