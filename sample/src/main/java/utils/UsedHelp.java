package utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//增加一层判断判断展示位
public class UsedHelp {
    public static String getUsedKeyString(String jsonstring){
        String result="";
        try {
            JSONObject jsonObject = new JSONObject(jsonstring);
            Iterator iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
//                System.out.println(key);
                String value = null;
                try {
                    value = jsonObject.getString(key);
                } catch (JSONException e) {
//                    e.printStackTrace();
                }
                if (value!=null&&!"null".equals(value)&&!"".equals(value)) {
                    result=result+key+",";
                }else{

                }


            }
        } catch (JSONException e) {
            Pattern pattern=Pattern.compile("(.*?):(.*)");
            Matcher matcher=pattern.matcher(jsonstring);
            while (matcher.find()){
                String tmp1=matcher.group(1);
                String textview= null;
                try {
                    textview = tmp1.split("\\.")[1];
                } catch (Exception e1) {
                    textview=tmp1.split("\\.")[0];
                    e1.printStackTrace();
                }
                result=result+textview+",";
            }
        }
        return result;
    }
    public static String getIdKeyString(String jsonstring){
        String result="";
        try {
            JSONObject jsonObject = new JSONObject(jsonstring);
            Iterator iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                String value = null;
                try {
                    value = jsonObject.getString(key);
                    if(checkStringIsIds(value)){
                        result=result+","+key;
                    }
                } catch (JSONException e) {

                }


            }
        } catch (JSONException e) {
            Pattern pattern=Pattern.compile("(.*?):(.*)");
            Matcher matcher=pattern.matcher(jsonstring);
            while (matcher.find()){
                String tmp1=matcher.group(1);
                String textview= null;
                try {
                    textview = tmp1.split("\\.")[1];
                    if(checkStringIsIds(matcher.group(2))){
                        result=result+textview+",";
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }
    public static boolean checkStringIsIds(String org){
        boolean result=true;
        if(org.length()<20){
            return false;
        }else{
            char[] array=org.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if((array[i]+"").getBytes().length>1){//说明字段存在中文可能是大段话
                    result= false;
                    break;
                }
            }
        }
        return result;
    }
}
