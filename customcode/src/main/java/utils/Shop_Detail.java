package utils;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import utils.bean.LineMenu;

import java.util.List;

public class Shop_Detail {
    public String classannotationstring;

    public Shop_Detail(String classannotationstring) {
        this.classannotationstring = classannotationstring;
    }

    public String getClassannotationstring() {
        return classannotationstring;
    }

    public Shop_Detail setClassannotationstring(String classannotationstring) {
        this.classannotationstring = classannotationstring;
        return this;
    }

    public  void parse(String classname, List<LineMenu> lineMenus){
        paseXml(classname,lineMenus);
        parseJava(classname,lineMenus);
    }

    private  void parseJava(String classname, List<LineMenu> lineMenus) {
        String initJavaHead=parseHead(classname,lineMenus);
        String initViewString=parseInitView(classname,lineMenus);
        String oncreatestring=parseOncreate(classname,lineMenus);
        String initdatastring=parseInitData(classname,lineMenus);
        String initSpinnerString=parseInitSpinner(classname,lineMenus);
        String initListenerString=parseInitListener(classname,lineMenus);
        String initbindDataToViewString=parseInitBindDataToView(classname,lineMenus);
        String initgetParamsMapString=parseGetParamsMap(classname,lineMenus);
        String end=parseEnd(classname,lineMenus);
        printAllStringToJava(classname,initJavaHead,initViewString,oncreatestring,initdatastring,initSpinnerString,initListenerString,initbindDataToViewString,initgetParamsMapString,end);

    }

    private  String parseEnd(String classname, List<LineMenu> lineMenus) {
        String result=""
                +"private class SaveDataTask extends AsyncTask<String, Integer, String> {\n"
                +"protected void onPostExecute(String s) {\n"
                +"super.onPostExecute(s);\n"
                +"try {\n"
                +"JSONObject objectItem = new JSONObject(s);\n"
                +"if (objectItem.getBoolean(\"operateSuccess\") == true) {\n"
                +"Toast.makeText(getBaseContext(), \"保存成功\",\n"
                +"Toast.LENGTH_LONG).show();\n"
                +"setResult(RESULT_OK);\n"
                +"finish();\n"
                +"} else {\n"
                +"Toast.makeText(getBaseContext(), \"保存失败\",\n"
                +"Toast.LENGTH_LONG).show();\n"
                +"}\n"
                +"} catch (JSONException e) {\n"
                +"e.printStackTrace();\n"
                +"}\n"
                +"}\n"
                +"protected String doInBackground(String... strings) {\n"
                +"Connection connection = new Connection(strings[0], getBaseContext());\n"
                +"HashMap<String, Object> datamap = getParamsMap();\n"
                +"String result=connection.connectPost(datamap,getBaseContext());\n"
                +"return result;\n"
                +"}\n"
                +"}\n"
                +"private class FindDataTask extends AsyncTask<String, Integer, String> {\n"
                +"protected void onPostExecute(String s) {\n"
                +"super.onPostExecute(s);\n"
                +"try {\n"
                +"GsonBuilder builder = new GsonBuilder();\n"
                +"builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {\n"
                +"public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {\n"
                +"return new Date(json.getAsJsonPrimitive().getAsLong());\n"
                +"}\n"
                +"});\n"
                +"Gson gson = builder.create();\n"
                +"Type type = new TypeToken<"+classname+">() {\n"
                +"}.getType();\n"
                +"detailbean = gson.fromJson(s, type);\n"
                +"id=detailbean.getId();\n"
                +"} catch (Exception e) {\n"
                +"detailbean = null;\n"
                +"e.printStackTrace();\n"
                +"}\n"
                +"bindDataToView();\n"
                +"}\n"
                +"protected String doInBackground(String... strings) {\n"
                +"Connection connection = new Connection(strings[0], getBaseContext());\n"
                +"HashMap<String, Object> datamap = new HashMap<>();\n"
                +"datamap.put(\"id\",id);\n"
                +"String result=connection.connectPost(datamap,getBaseContext());\n"
                +"return result;\n"
                +"}\n"
                +"}\n"
                +"private class SpinnerTask extends AsyncTask<String, Integer, String> {\n"
                +"public String codekey;\n"
                +"public String namekey;\n"
                +"public Spinner spinnerbind;\n"
                +"public SpinnerTask(String codekey, String namekey, Spinner spinnerbind) {\n"
                +"this.codekey = codekey;\n"
                +"this.namekey = namekey;\n"
                +"this.spinnerbind = spinnerbind;\n"
                +"}\n"
                +"protected void onPostExecute(String s) {\n"
                +"super.onPostExecute(s);\n"
                +"try {\n"
                +"List<CodeAndString> codeAndStringList=new ArrayList<>();\n"
                +"JSONArray jsonArray=new JSONArray(s);\n"
                +"for (int i = 0; i <jsonArray.length() ; i++) {\n"
                +"JSONObject jsonObject=jsonArray.getJSONObject(i);\n"
                +"String code=jsonObject.optString(codekey);\n"
                +"String name=jsonObject.optString(namekey);\n"
                +"CodeAndString codeAndString=new CodeAndString(code,name);\n"
                +"codeAndStringList.add(codeAndString);\n"
                +"}\n"
                +"SrxSpinnerAdapter adapter=new SrxSpinnerAdapter(getBaseContext(),codeAndStringList);\n"
                +"spinnerbind.setAdapter(adapter);\n"
                +"adapter.notifyDataSetChanged();\n"
                +"} catch (JSONException e) {\n"
                +"e.printStackTrace();\n"
                +"}\n"
                +"}\n"
                +"protected String doInBackground(String... strings) {\n"
                +"Connection connection = new Connection(strings[0], getBaseContext());\n"
                +"HashMap<String, Object> datamap = new HashMap<>();\n"
                +"String result=connection.connectPost(datamap,getBaseContext());\n"
                +"return result;\n"
                +"}\n"
                +"}\n"
                +"private CustomProgressDialog mProgressDialog = null;\n"
                +"private void startProgressDialog() {\n"
                +"if (mProgressDialog == null) {\n"
                +"mProgressDialog = CustomProgressDialog.createDialog(this);\n"
                +"}\n"
                +"mProgressDialog.show();\n"
                +"}\n"
                +"private void stopProgressDialog() {\n"
                +"if (mProgressDialog != null) {\n"
                +"mProgressDialog.dismiss();\n"
                +"mProgressDialog = null;\n"
                +"}\n"
                +"}\n"
                +"class TimeClickListener implements View.OnClickListener {\n"
                +"private TextView finalTime;\n"
                +"public TimeClickListener(TextView time) {\n"
                +"this.finalTime = time;\n"
                +"}\n"
                +"public void onClick(View view) {\n"
                +"Utils.makeDateAndTimeDialog(finalTime, view.getContext());\n"
                +"}\n"
                +"}\n"
                +"}\n";
        return result;
    }

    private  String parseHead(String classname, List<LineMenu> lineMenus) {
        String result=""
                +"package com.android.yidongzhifa.activity;\n"
                +"import android.os.AsyncTask;\n"
                +"import android.os.Bundle;\n"
                +"import android.support.annotation.Nullable;\n"
                +"import android.support.v7.app.AppCompatActivity;\n"
                +"import android.support.v7.widget.Toolbar;\n"
                +"import android.view.View;\n"
                +"import android.widget.EditText;\n"
                +"import android.widget.ImageView;\n"
                +"import android.widget.LinearLayout;\n"
                +"import android.widget.RelativeLayout;\n"
                +"import android.widget.Spinner;\n"
                +"import android.widget.TextView;\n"
                +"import android.widget.Toast;\n"
                +"import com.android.ayplatform.adapter.SrxSpinnerAdapter;\n"
                +"import com.android.ayplatform.javabean.CodeAndString;\n"
                +"import com.android.ayplatform.javabean."+classname+";\n"
                +"import com.android.ayplatform.utils.*;\n"
                +"import com.android.ayplatform.utils.Utils;\n"
                +"import com.aykj.mustinsert.MustInsert;\n"
                +"import com.google.gson.Gson;\n"
                +"import com.google.gson.GsonBuilder;\n"
                +"import com.google.gson.JsonDeserializationContext;\n"
                +"import com.google.gson.JsonDeserializer;\n"
                +"import com.google.gson.JsonElement;\n"
                +"import com.google.gson.JsonParseException;\n"
                +"import com.google.gson.reflect.TypeToken;\n"
                +"import org.json.JSONArray;\n"
                +"import org.json.JSONException;\n"
                +"import org.json.JSONObject;\n"
                +"import java.lang.reflect.Type;\n"
                +"import java.util.ArrayList;\n"
                +"import java.util.Date;\n"
                +"import java.util.HashMap;\n"
                +"import java.util.List;\n"
                +"import java.util.Map;\n"
                +"import java.util.UUID;\n"
                +"import java.util.concurrent.ExecutorService;\n"
                +"import java.util.concurrent.Executors;\n"
                +"public class Detail_Activity_"+classname+" extends AppCompatActivity {\n"
                +"private ExecutorService newCachedThreadPool;\n"
                +"private String URL_DATA_FIND=\"\";\n"
                +"private String URL_ADD=\"\";\n"
                +"private String URL_UPDATE=\"\";\n"
                +"private String id;\n";
        return result;
    }

    private  String parseInitView(String classname, List<LineMenu> lineMenus) {
        String result1=parseViewField(classname,lineMenus);
        String result2=""
                +"private void initView() {\n"
                +parseViewFind(classname,lineMenus)
                +"}\n";
        return result1+result2;
    }

    private  String parseViewFind(String classname, List<LineMenu> lineMenus) {
        String result="";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            result=result+""+menu.getFieldname()+" = ("+menu.getMenutype()+") findViewById(R.id."+menu.getFieldname()+");\n";
        }
        result=result+"cancelRelativeLayout = (RelativeLayout) findViewById(R.id.cancel_relativeLayout);\n"
                +"saveRelativeLayout = (RelativeLayout) findViewById(R.id.save_relativeLayout);\n";

        return result;
    }

    private  String parseViewField(String classname, List<LineMenu> lineMenus) {
        String result=""+"private "+classname+" detailbean;\n";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            result=result+"private "+menu.getMenutype()+" "+menu.getFieldname()+";\n";
        }
        result=result+"private RelativeLayout cancelRelativeLayout;\n"
                +"private RelativeLayout saveRelativeLayout;\n";
        return result;
    }

    private  String parseGetParamsMap(String classname, List<LineMenu> lineMenus) {
        String result1=""
                +"private HashMap<String, Object> getParamsMap() {\n"
                +"HashMap<String, Object> result = new HashMap<String, Object>();\n"
                +"result.put(\""+classname.toLowerCase()+".id\",id);\n";

        String result2=paseMap(classname,lineMenus);
        String result3=""
                +"return result;\n"
                +"}\n";;
        return result1+result2+result3;
    }

    private  String paseMap(String classname, List<LineMenu> lineMenus) {
        String result="";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            if("Spinner".equals(menu.getMenutype())){
                result=result+"result.put(\""+classname.toLowerCase()+"."+menu.getFieldname()+"\",((CodeAndString)"+menu.getFieldname()+".getSelectedItem()).getCode());\n";
            }else{
                result=result+"result.put(\""+classname.toLowerCase()+"."+menu.getFieldname()+"\","+menu.getFieldname()+".getText().toString());\n";
            }
        }
        return result;
    }

    private  String parseInitBindDataToView(String classname, List<LineMenu> lineMenus) {
        String result1=""
                +"public void bindDataToView(){\n"
                +"if(detailbean!=null){\n";

        String result2=parseBindFieldValue(classname,lineMenus);
        String result3=parseBindSpinnerValue(classname,lineMenus);
                String result3_1=""+"if(getIntent().getBooleanExtra(\"see\",false)){\n";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);

            if("Spinner".equals(menu.getMenutype())){
                result3_1=result3_1+""+menu.getFieldname()+".setEnabled(false);\n" +""+menu.getFieldname()+".setOnKeyListener(null);\n";
            }else{
                result3_1=result3_1+""+menu.getFieldname()+".setEnabled(false);\n";
            }
        }
        result3_1=result3_1+"cancelRelativeLayout.setVisibility(View.GONE);\n"
                +"saveRelativeLayout.setVisibility(View.GONE);\n"
                +"}\n";
        String result4=""
                +"}\n"
                +"}\n";
        ;
        return result1+result2+result3+result3_1+result4;
    }

    private  String parseBindSpinnerValue(String classname, List<LineMenu> lineMenus) {
        String result="";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            if("Spinner".equals(menu.getMenutype())){
                result=result
                        +"List<CodeAndString> "+menu.getFieldname()+"datalist=((SrxSpinnerAdapter)"+menu.getFieldname()+".getAdapter()).getmCodeAndStringlist();\n"
                        +"for (int i = 0; i <"+menu.getFieldname()+"datalist.size() ; i++) {\n"
                        +"if("+menu.getFieldname()+"datalist.get(i).getCode().equals(detailbean."+menu.getFieldname()+")){\n"
                        +""+menu.getFieldname()+".setSelection(i);\n"
                        +"}\n"
                        +"}\n";
            }
        }
        return result;
    }

    private  String parseBindFieldValue(String classname, List<LineMenu> lineMenus) {
        String result="";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            if(!"Spinner".equals(menu.getMenutype())){
                result=result+""+menu.getFieldname()+".setText(detailbean."+menu.getFieldname()+");\n";
            }
        }
        return result;
    }

    private  String parseInitListener(String classname, List<LineMenu> lineMenus) {
        String result1=""+"public void initListener(){\n";
        String result2=parseSaveButton(classname,lineMenus);
        String result3=""+"cancelRelativeLayout.setOnClickListener(new View.OnClickListener() {\n"
                +"public void onClick(View v) {\n"
                +"finish();\n"
                +"}\n"
                +"});\n";
        String result4=paseTime(classname,lineMenus);
        String result5=""+"}\n";
        return result1+result2+result3+result4+result5;
//        return result1+result4+result5;
    }

    private  String parseSaveButton(String classname, List<LineMenu> lineMenus) {
        String result1=""+"saveRelativeLayout.setOnClickListener(new View.OnClickListener() {\n"
                +"public void onClick(View v) {\n"+parseMust(classname,lineMenus)
                ;
        String result2=""
                +"}\n"
                +"});\n";
        return result1+result2;
    }

    private  String paseTime(String classname, List<LineMenu> lineMenus) {
        String result="";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            if(menu.getFirstannotionstring().contains("时间")||menu.getFirstannotionstring().contains("日期")){
                result=result+""+menu.getFieldname()+".setOnClickListener(new TimeClickListener("+menu.getFieldname()+"));\n";
            }
        }
        return result;
    }

    private  String parseMust(String classname, List<LineMenu> lineMenus) {
        String result1=""
                +"if(MustInsert.checkAllText(getBaseContext(),"+parseMustView(classname,lineMenus)+")){\n"
                ;

        String result2=""
                +"if(getIntent().getStringExtra(\"id\")==null){\n"
                +"new SaveDataTask().executeOnExecutor(newCachedThreadPool,URL_ADD);\n"
                +"}else{\n"
                +"new SaveDataTask().executeOnExecutor(newCachedThreadPool,URL_UPDATE);\n"
                +"}\n"
                +"}\n";
        return result1+result2;
    }

    private  String parseMustView(String classname, List<LineMenu> lineMenus) {
        String result="";
        int need=0;
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            if(menu.isIsmustinsert()){
                need++;
                result=result+menu.getFieldname()+",";
            }
        }
        if(need==0){
            result="null";
        }else{
            result=result.substring(0,result.length()-1);
        }

        return result;
    }

    public  void printAllStringToJava(String... strings){
        String clasename=strings[0];
        String javatempelt="";
        for (int i = 1; i <strings.length ; i++) {
            javatempelt=javatempelt+strings[i];
        }
        Util_File.string2Stream(javatempelt, "apps/java/com/activity/Detail_Activity_" + clasename + ".java");
    }


    private  String parseInitSpinner(String classname, List<LineMenu> lineMenus) {
        String result1=""
                +"public void initSpinner(){\n";
        String result2="";
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            if("Spinner".equals(menu.getMenutype())){
                if(menu.getUrl()!=null){

                    result2=result2+"new SpinnerTask(\""+menu.getCodekey()+"\",\""+menu.getNamekey()+"\","+menu.getFieldname()+").executeOnExecutor(newCachedThreadPool,\""+menu.getUrl()+"\");\n";
                }
                if(menu.getStringarray()!=null){
                    String[] chose=menu.getStringarray();
                    String tmp="";
                    tmp="List<CodeAndString> "+menu.getFieldname()+"datalist=new ArrayList<>();\n";
                    for (int j = 0; j <chose.length; j++) {
                        tmp=tmp +""+menu.getFieldname()+"datalist.add(new CodeAndString(\""+chose[j]+"\",\""+chose[j]+"\"));\n";

                    }
                    tmp=tmp+""+menu.getFieldname()+".setAdapter(new SrxSpinnerAdapter(getBaseContext(),"+menu.getFieldname()+"datalist));\n";
                    result2=result2+tmp;

                }
            }
        }
        String reslut3=""
                +"}\n";;
        return result1+result2+reslut3;
    }

    private  String parseInitData(String classname, List<LineMenu> lineMenus) {
        String result=""
                +"private void initData() {\n"
                +"newCachedThreadPool = Executors.newFixedThreadPool(1);\n"
                +"initSpinner();\n"
                +"initListener();\n"
                +"if(getIntent().getStringExtra(\"id\")==null){//新增\n"
                +"id=UUID.randomUUID().toString().replace(\"-\",\"\");\n"
                +"}else{\n"
                +"new FindDataTask().executeOnExecutor(newCachedThreadPool,URL_DATA_FIND);\n"
                +"}\n"
                +"}\n";
        return result;
    }

    private  String parseOncreate(String classname, List<LineMenu> lineMenus) {
        String result=""
                +"protected void onCreate(@Nullable Bundle savedInstanceState) {\n"
                +"super.onCreate(savedInstanceState);\n"
                +"setContentView(R.layout.detail_activity_"+classname.toLowerCase()+");\n"
                +"initView();\n"
                +"initData();\n"
                +"}\n";
        return result;
    }

    private  void paseXml(String classname, List<LineMenu> lineMenus) {
        ParseBase layoutxml = new XmlNode().build().parse(Util_File.inputStream2String("templete/templete_layout.xml"));
        ParseBase cellline = new XmlNode().build().parse(Util_File.inputStream2String("templete/templete_line.xml"));
        ParseBase title=layoutxml.findNodeByProperty("android:id=\"@\\+id/title\"");
        title.addProperty("android:text",""+classannotationstring.split(";")[0]+"");
        for (int i = 0; i <lineMenus.size() ; i++) {
            LineMenu menu=lineMenus.get(i);
            ParseBase cellfindtextview=cellline.findNodeByProperty("android:id=\"@\\+id/linetext\"").copy();
            ParseBase cellfindview=cellline.findNodeByProperty("android:id=\"@\\+id/lineview\"").copy();
            ParseBase cellfindedit=cellline.findNodeByProperty("android:id=\"@\\+id/lineeditext\"").copy();
            ParseBase cellfindspinner=cellline.findNodeByProperty("android:id=\"@\\+id/linespinner\"").copy();
            String annotationstring=menu.getAnnotationstring();
            String fieldname=menu.getFieldname();
            String firstannotionstring=menu.getFirstannotionstring();
            if(annotationstring.contains("Spinner")){
                ParseBase text=cellfindspinner.findNodeByProperty("android:id=\"@\\+id/text\"");
                ParseBase value=cellfindspinner.findNodeByProperty("android:id=\"@\\+id/value\"");

                cellfindspinner.addProperty("android:id","@+id/linespinner_"+ fieldname +"");
                cellfindview.addProperty("android:id","@+id/lineview_"+fieldname+"");
                if(annotationstring.contains("Hide")){
                    cellfindspinner.addProperty("android:visibility","gone");
                    cellfindview.addProperty("android:visibility","gone");
                }
                text.addProperty("android:id","@+id/"+fieldname+"_text");
                text.addProperty("android:text",firstannotionstring+":");
                value.addProperty("android:id","@+id/"+fieldname);
                layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/sublayout\"",cellfindspinner,cellfindview);
            } else if(annotationstring.contains("TextView")){

            }else{
                ParseBase text=cellfindedit.findNodeByProperty("android:id=\"@\\+id/text\"");
                ParseBase value=cellfindedit.findNodeByProperty("android:id=\"@\\+id/value\"");

                cellfindedit.addProperty("android:id","@+id/lineeditext_"+ fieldname +"");
                cellfindview.addProperty("android:id","@+id/lineview_"+fieldname+"");
                if(annotationstring.contains("Hide")){
                    cellfindedit.addProperty("android:visibility","gone");
                    cellfindview.addProperty("android:visibility","gone");
                }
                text.addProperty("android:id","@+id/"+fieldname+"_text");
                text.addProperty("android:text",firstannotionstring+":");
                value.addProperty("android:id","@+id/"+fieldname);
                if(firstannotionstring.contains("时间")||firstannotionstring.contains("日期")){
                    value.addProperty("android:focusable","false");
                }
                layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/sublayout\"",cellfindedit,cellfindview);
            }
        }
        Util_File.string2Stream(layoutxml.getEntityString(), "apps/res/layout/detail_activity_" + classname.toLowerCase() + ".xml");
    }
}
