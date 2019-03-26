package com.codefactory.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Util_Http;
import utils.Util_String;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util_Translate {
	public static final String keyfrom="srxffcc2";
	public static final String key="188764345";
	private static int limit=0;//次数限制下别又给我
	public static void getAllTRANSLATE(OutputStream os,List<String> allstring,String... str) {
		try {
			Pattern p = Pattern.compile("(<TRANSLATE>.*:)(.*)\r");
			if(str.length>1){
				
				Matcher m = p.matcher(str[0]);
				Matcher m2 = p.matcher(str[1]);
				ArrayList<String> strs = new ArrayList<String>();
				ArrayList<String> strs2 = new ArrayList<String>();
				while (m.find()) {
					strs.add(m.group(2));
				}
				while (m2.find()) {
					strs2.add(m2.group(2));
				}
				for (int i = 0; i < strs.size(); i++) {
					String tran=getTranslate(strs.get(i));
					if(tran.equals(strs.get(i))){
						if(strs2.size()>i){
							tran=strs2.get(i);
						}else{
							tran=strs.get(i);
						}
						
					}else{
						
					}
					String tmp="\t[TRANSLATION]\r"+
							"\t\t<STRING>ORIGINAL:"+strs.get(i)+"\r"+
							"\t\t<STRING>TRANSLATION:"+tran+"\r"+
							"\t[/TRANSLATION]\r";
					if(Util_String.isInList(allstring, tmp)){
						
					}else{
						if(allstring!=null){
							os.write(tmp.getBytes());
							allstring.add(tmp);
						}
						
					}
				}
				
			}else{
				Matcher m = p.matcher(str[0]);
				ArrayList<String> strs = new ArrayList<String>();
				while (m.find()) {
					strs.add(m.group(2));
				}
				for (String s : strs) {
					String tmp="\t[TRANSLATION]\r"+
							"\t\t<STRING>ORIGINAL:"+s+"\r"+
							"\t\t<STRING>TRANSLATION:"+getTranslate(s)+"\r"+
							"\t[/TRANSLATION]\r";
					if(Util_String.isInList(allstring, tmp)){
						
					}else{
						
						if(allstring!=null){
							os.write(tmp.getBytes());
							allstring.add(tmp);
						}
						
					}
				}
			}
			System.out.println("1");
		} catch (Exception e) {
			System.out.println("--------报错--------");
			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i]);
			}
			
			e.printStackTrace();
			System.exit(0);
		}

	}
	public static void getAllTRANSLATE(OutputStream os,List<String> allstring,File... file) {
		int length=file.length;
		String[] filearray=new String[length];
		for (int i = 0; i < filearray.length; i++) {
			filearray[i]=Util_File.inputStream2String(file[i]);
		}
		getAllTRANSLATE(os,allstring,filearray);
		
	}
	public static String getTranslate(String dd) {
		String tmpdd=dd; 
		String result="";
		String str=Util_File.inputStream2String("D:\\Torchlight 2\\MEDIA\\TRANSLATIONS\\MANDARIN\\TRANSLATION.DAT");
		dd="<STRING>ORIGINAL:"+Util_String.washString(dd);
		Pattern p = Pattern.compile(""+dd+"\r\n(.*:)(.*)");
		Matcher m = p.matcher(str);
		ArrayList<String> strs = new ArrayList<String>();
		while (m.find()) {
			strs.add(m.group(2));
		}
		if(strs.size()==1){
			result=strs.get(0);
		}else{
			result=tmpdd;
		}
		return result;
		
	}
	public static String getTranslaterResultOnWeb(String needtran){
		String result="";
		
			try {
				Thread.sleep(5000);//5秒一次翻译不然就被封号了
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String json = null;
			try {
				json= Util_Http.sendPost("http://fanyi.youdao.com/openapi.do?", "keyfrom="+keyfrom+"&key="+key+"&type=data&doctype=json&version=1.1&q="+needtran);
				JSONObject jsono=new JSONObject(json);
				JSONArray jsona=jsono.getJSONArray("translation");
				if(jsona.length()>0){
					result=jsona.get(0).toString();
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				result="";
//				e.printStackTrace();
				System.out.println("出错已经直接返回了");
			}
			limit++;
		
		
		return result;
	}

}
