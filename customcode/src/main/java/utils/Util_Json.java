//package utils;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import static utils.Util_Dao.isIdExsist;
//
///**
// * 此类废弃
// */
//public class Util_Json {
//    public static String inputStream2String(InputStream is) {
//        if (null == is) {
//            return null;
//        }
//        StringBuilder resultSb = null;
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            resultSb = new StringBuilder();
//            String len;
//            while (null != (len = br.readLine())) {
//                resultSb.append(len);
//            }
//        } catch (Exception ex) {
//        } finally {
//            is=null;
//        }
//        return null == resultSb ? null : resultSb.toString();
//    }
//    public static String passup(List<String> exidlist,String time,String logic){
//    	String jsonarray="";
//    	List<String> jsonlist=new ArrayList<String>();
//    	try {
//			String idif=new String("");
//			for (int i = 0; i < exidlist.size(); i++) {
//				idif=idif+" id <> "+"\""+exidlist.get(i)+"\" and";
//			}
//			if(time==null){
//				idif=idif.substring(0, idif.length()-3);
//			}
//			System.out.println("idif");
//			System.out.println(idif);
//			List<String> alltable=new ArrayList<String>();
//			String seachalltablesql="select name from sqlite_master where type='table' order by name";
//			ResultSet res= Util_Dao.create().setDbname("anjian.db").seach(seachalltablesql);
//			while(res.next()){
//				String tmptablename=new String();
//				tmptablename=res.getString("name");
//				alltable.add(tmptablename);
//			}
//			String seachsql="";
//			for (int i = 0; i < alltable.size(); i++) {
//				if(time!=null){
//					seachsql="select * from "+alltable.get(i)+" where"+idif+"datadate "+logic+" \""+time+"\"";
//				}else{
//					seachsql="select * from "+alltable.get(i)+" where"+idif+"";
//				}
//				System.out.println(seachsql);
//				ResultSet res2= Util_Dao.create().setDbname("anjian.db").seach(seachsql);
//				if(res2!=null){
//					ResultSetMetaData rsm=res2.getMetaData();
//					List<String> columnlist=new ArrayList<String>();
//					int count=rsm.getColumnCount();
//					for (int j = 0; j < count; j++) {
//						String columm=new String();
//						columm=rsm.getColumnName(j+1);
//						columnlist.add(columm);
//					}
//					int conut=0;
//					while(res2.next()){
//						String subjson="";
//						for (int j = 0; j < columnlist.size(); j++) {
//							String h1=columnlist.get(j);
//							String h2=res2.getString(columnlist.get(j));
//							h2=h2.replaceAll("\"", "“");
//							subjson=subjson+"\""+columnlist.get(j)+"\""+":\""+h2+"\""+",";
//						}
//						subjson=subjson.substring(0, subjson.length()-1);
//						subjson="{"+subjson+"}";
//						jsonlist.add(subjson);
//					}
//				}
//			}
//			for (int i = 0; i < jsonlist.size(); i++) {
//				jsonarray=jsonarray+jsonlist.get(i)+",";
//			}
//			Util_Dao.create().close();
//			jsonarray=jsonarray.substring(0, jsonarray.length()-1);
//			jsonarray="{"+"\"passup\":"+"["+jsonarray+"]"+"}";
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//    	return jsonarray;
//    }
//    public static List<String> getUpStringList2ExId(String json){
//    	List<String> resultlist=new ArrayList<String>();
//    	try {
//			JSONObject jo=new JSONObject(json);
//			JSONArray ja=jo.getJSONArray("data");
//
//			for (int i = 0; i < ja.length(); i++) {
//				JSONObject jotmp=new JSONObject(ja.get(i).toString());
//			    Iterator it = jotmp.keys();
//		        List<String> keyListstr = new ArrayList<String>();
//		        while(it.hasNext()){
//		        	String ele=it.next().toString();
//		        	keyListstr.add(ele);
//		        }
//		        String table=jotmp.getString("tableid");
//		        String datadatereq=jotmp.getString("datadate");
//		        String id=new String();
//		        id=jotmp.getString("id");
//		        String body="";
//		        for (int j = 0; j < keyListstr.size(); j++) {
//		        	body=body+keyListstr.get(j)+" = "+"\""+jotmp.getString(keyListstr.get(j))+"\""+" ,";
//				}
//		        body=body.substring(0, body.length()-1);
//		        String resultsql=new String();
//
//		        resultsql="update "+table+" set "+body+" where id = \""+id+"\" and datadate < \""+datadatereq+"\"";
//		        int re= Util_Dao.create().setDbname("anjian.db").update(resultsql);
//		        if(re==0){
//		        	if(isIdExsist(table, id)){
//
//		        	}else{
//			        	String columu="";
//			        	String value="";
//				        for (int j = 0; j < keyListstr.size(); j++) {
//				        	columu=columu+keyListstr.get(j)+",";
//				        	value=value+"\""+jotmp.getString(keyListstr.get(j))+"\""+",";
//						}
//				        columu=columu.substring(0, columu.length()-1);
//				        value=value.substring(0, value.length()-1);
//			        	resultsql="insert into "+table+" ("+columu+") values ("+value+")";
//			        	int re2= Util_Dao.create().setDbname("anjian.db").insert(resultsql);
//			        	resultlist.add(id);
//		        	}
//		        }else{
//		        	resultlist.add(id);
//		        }
//
//
//			}
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return resultlist;
//    }
//
//
//
//}
