package utils;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import utils.bean.LineMenu;
import utils.bean.ModeBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2019年重新设计架构 功能分离 按照给的请求url进行分离 已知功能 添加 修改 查看 因后期增加的整改 对目前架构进行修改
public class Shop_Detail {
    public String classannotationstring;
    private List<ModeBean> beanlist = new ArrayList<>();

//    public Map<String, String> getUsedkeyStrings() {
//        Map<String,String> result=new HashMap<>();
//
//        for (Map.Entry<String, String> entry : usedkeyStrings.entrySet()) {
//            result.put(entry.getKey(), UsedHelp.getUsedKeyString(entry.getValue()));
//        }
//        return result;
//    }


    public Map<String, String> modeExtraHide = new HashMap<>();
    public Map<String, String> modeUsedWeight = new HashMap<>();//用来存储对应mod对应的应该显示的控件
    public Map<String, String> modeUsedUrl = new HashMap<>();//用来存储对应mod对应的应该显示的控件
    private String justparmstring;//

    //
//    public Shop_Detail setUsedkeyStringS(Map<String,String> usedkeyStrings) {
//        this.usedkeyStrings = usedkeyStrings;
//        return this;
//    }
    public Shop_Detail setBeanlist(List<ModeBean> beanlist) {
        this.beanlist = beanlist;
        return this;
    }

    private void parseMode() {
        modeUsedWeight.clear();
        modeUsedUrl.clear();
        for (int i = 0; i < beanlist.size(); i++) {
            ModeBean modeBean = beanlist.get(i);
            modeUsedWeight.put(modeBean.getMode(), modeBean.getRespone());
            modeUsedUrl.put(modeBean.getMode(), modeBean.getUrl());
            modeExtraHide.put(modeBean.getMode(), modeBean.getExtraHide());
        }
    }

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

    public void parse(String classname, List<LineMenu> lineMenus, String justparmstring) {
        parseMode();
        paseXml(classname, lineMenus);
        parseJava(classname, lineMenus);
        this.justparmstring =justparmstring;
    }


    private void parseJava(String classname, List<LineMenu> lineMenus) {
        String initJavaHead = parseHead(classname, lineMenus);
        String initViewString = parseInitView(classname, lineMenus);
        String oncreatestring = parseOncreate(classname, lineMenus);
        String initdatastring = parseInitData(classname, lineMenus);
        String initSpinnerString = parseInitSpinner(classname, lineMenus);
        String initListenerString = parseInitListener(classname, lineMenus);
        String initbindDataToViewString = parseInitBindDataToView(classname, lineMenus);
        String initgetParamsMapString = parseGetParamsMap(classname, lineMenus);
        String initgetModeUrl = parseModeUrl(classname, lineMenus);
        String initHide = parseHide(classname, lineMenus);
//        System.out.println(initHide);
        String end = parseEnd(classname, lineMenus);
        printAllStringToJava(classname,
                initJavaHead,
                initViewString,
                oncreatestring,
                initdatastring,
                initSpinnerString,
                initListenerString,
                initbindDataToViewString,
                initgetParamsMapString,
                initgetModeUrl,
                initHide,
                end);

    }

    private String parseModeUrl(String classname, List<LineMenu> lineMenus) {
        String result1 = ""
                + "private String getModeUrl() {\n"
                + "String result=\"\";\n";
        for (Map.Entry<String, String> entry : modeUsedUrl.entrySet()) {
            if (!modeUsedUrl.get(entry.getKey()).contains("getById")) {
                result1 = result1 + "if(\"" + entry.getKey() + "\".equals(urlMode)){\n" + "result=\"" + entry.getValue() + "\";\n" + "}\n";
            }
        }
        String resultend = ""
                + "return result;\n"
                + "}\n";
        return result1 + resultend;
    }

    private String parseHide(String classname, List<LineMenu> lineMenus) {
        String result1 = ""
                + "private void hideNoNeedWeight() {\n";
        String resultend = ""
                + "}\n";
        return result1 + parseModeShowOrHideS(lineMenus) + resultend;
    }

    private String parseEnd(String classname, List<LineMenu> lineMenus) {
        String result = ""
                + "private class SaveDataTask extends AsyncTask<String, Integer, String> {\n"
                + "protected void onPostExecute(String s) {\n"
                + "super.onPostExecute(s);\n"
                + "try {\n"
                + "JSONObject objectItem = new JSONObject(s);\n"
                + "if (objectItem.getBoolean(\"operateSuccess\") == true) {\n"
                + "Toast.makeText(getBaseContext(), \"保存成功\",\n"
                + "Toast.LENGTH_LONG).show();\n"
                + "setResult(RESULT_OK);\n"
                + "finish();\n"
                + "} else {\n"
                + "Toast.makeText(getBaseContext(), \"保存失败\",\n"
                + "Toast.LENGTH_LONG).show();\n"
                + "}\n"
                + "} catch (JSONException e) {\n"
                + "e.printStackTrace();\n"
                + "}\n"
                + "}\n"
                + "protected String doInBackground(String... strings) {\n"
                + "Connection connection = new Connection(strings[0], getBaseContext());\n"
                + "HashMap<String, Object> datamap = getParamsMap();\n"
                + "String result=connection.connectPost(datamap,getBaseContext());\n"
                + "return result;\n"
                + "}\n"
                + "}\n"
                + "private class FindDataTask extends AsyncTask<String, Integer, String> {\n"
                + "protected void onPostExecute(String s) {\n"
                + "super.onPostExecute(s);\n"
                + "try {\n"
                + "GsonBuilder builder = new GsonBuilder();\n"
                + "builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {\n"
                + "public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {\n"
                + "return new Date(json.getAsJsonPrimitive().getAsLong());\n"
                + "}\n"
                + "});\n"
                + "Gson gson = builder.create();\n"
                + "Type type = new TypeToken<" + classname + ">() {\n"
                + "}.getType();\n"
                + "detailbean = gson.fromJson(s, type);\n"
                + "id=detailbean.getId();\n"
                + "} catch (Exception e) {\n"
                + "detailbean = null;\n"
                + "e.printStackTrace();\n"
                + "}\n"
                + "if(URL_DATA_FIND.contains(\"填写\")){\n" +
                "                Toast.makeText(getBaseContext(),\"类里忘记填URL了吧\",Toast.LENGTH_SHORT).show();\n" +
                "            }else{\n" +
                "\n" +
                "                bindDataToView();\n" +
                "            }\n"
                + "}\n"
                + "protected String doInBackground(String... strings) {\n"
                + "Connection connection = new Connection(strings[0], getBaseContext());\n"
                + "HashMap<String, Object> datamap = new HashMap<>();\n"
                + "datamap.put(\"id\",id);\n"
                + "String result=connection.connectPost(datamap,getBaseContext());\n"
                + "return result;\n"
                + "}\n"
                + "}\n"
                + "private class SpinnerTask extends AsyncTask<String, Integer, String> {\n"
                + "public String codekey;\n"
                + "public String namekey;\n"
                + "public Spinner spinnerbind;\n"
                + "public SpinnerTask(String codekey, String namekey, Spinner spinnerbind) {\n"
                + "this.codekey = codekey;\n"
                + "this.namekey = namekey;\n"
                + "this.spinnerbind = spinnerbind;\n"
                + "}\n"
                + "protected void onPostExecute(String s) {\n"
                + "super.onPostExecute(s);\n"
                + "try {\n"
                + "List<CodeAndString> codeAndStringList=new ArrayList<>();\n"
                + "JSONArray jsonArray=new JSONArray(s);\n"
                + "for (int i = 0; i <jsonArray.length() ; i++) {\n"
                + "JSONObject jsonObject=jsonArray.getJSONObject(i);\n"
                + "String code=jsonObject.optString(codekey);\n"
                + "String name=jsonObject.optString(namekey);\n"
                + "CodeAndString codeAndString=new CodeAndString(code,name);\n"
                + "codeAndStringList.add(codeAndString);\n"
                + "}\n"
                + "SrxSpinnerAdapter adapter=new SrxSpinnerAdapter(getBaseContext(),codeAndStringList);\n"
                + "spinnerbind.setAdapter(adapter);\n"
                + "adapter.notifyDataSetChanged();\n"
                + "} catch (JSONException e) {\n"
                + "e.printStackTrace();\n"
                + "}\n"
                + "}\n"
                + "protected String doInBackground(String... strings) {\n"
                + "Connection connection = new Connection(strings[0], getBaseContext());\n"
                + "HashMap<String, Object> datamap = new HashMap<>();\n"
                + "String result=connection.connectPost(datamap,getBaseContext());\n"
                + "return result;\n"
                + "}\n"
                + "}\n"
                + "private CustomProgressDialog mProgressDialog = null;\n"
                + "private void startProgressDialog() {\n"
                + "if (mProgressDialog == null) {\n"
                + "mProgressDialog = CustomProgressDialog.createDialog(this);\n"
                + "}\n"
                + "mProgressDialog.show();\n"
                + "}\n"
                + "private void stopProgressDialog() {\n"
                + "if (mProgressDialog != null) {\n"
                + "mProgressDialog.dismiss();\n"
                + "mProgressDialog = null;\n"
                + "}\n"
                + "}\n"
                + "class TimeClickListener implements View.OnClickListener {\n"
                + "private TextView finalTime;\n"
                + "public TimeClickListener(TextView time) {\n"
                + "this.finalTime = time;\n"
                + "}\n"
                + "public void onClick(View view) {\n"
                + "Utils.makeDateAndTimeDialog(finalTime, view.getContext());\n"
                + "}\n"
                + "}\n"
                + "}\n";
        return result;
    }

    private String parseHead(String classname, List<LineMenu> lineMenus) {
        String result = ""
                + "package com.android.yidongzhifa.activity;\n"
                + "import android.os.AsyncTask;\n"
                + "import android.os.Bundle;\n"
                + "import android.support.annotation.Nullable;\n"
                + "import android.support.v7.app.AppCompatActivity;\n"
                + "import android.support.v7.widget.Toolbar;\n"
                + "import android.view.View;\n"
                + "import android.widget.EditText;\n"
                + "import android.widget.ImageView;\n"
                + "import android.widget.LinearLayout;\n"
                + "import android.widget.RelativeLayout;\n"
                + "import android.widget.Spinner;\n"
                + "import android.widget.TextView;\n"
                + "import android.widget.Toast;\n"
                + "import com.android.ayplatform.adapter.SrxSpinnerAdapter;\n"
                + "import com.android.ayplatform.javabean.CodeAndString;\n"
                + "import com.android.ayplatform.javabean." + classname + ";\n"
                + "import com.android.ayplatform.utils.*;\n"
                + "import com.android.ayplatform.utils.Utils;\n"
                + "import com.aykj.mustinsert.MustInsert;\n"
                + "import com.google.gson.Gson;\n"
                + "import com.google.gson.GsonBuilder;\n"
                + "import com.google.gson.JsonDeserializationContext;\n"
                + "import com.google.gson.JsonDeserializer;\n"
                + "import com.google.gson.JsonElement;\n"
                + "import com.google.gson.JsonParseException;\n"
                + "import com.google.gson.reflect.TypeToken;\n"
                + "import org.json.JSONArray;\n"
                + "import org.json.JSONException;\n"
                + "import org.json.JSONObject;\n"
                + "import java.lang.reflect.Type;\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.Date;\n"
                + "import java.util.HashMap;\n"
                + "import java.util.List;\n"
                + "import java.util.Map;\n"
                + "import java.util.UUID;\n"
                + "import java.util.concurrent.ExecutorService;\n"
                + "import java.util.concurrent.Executors;\n"
                + "/**\n"
                +" * "+classannotationstring.split(";")[0].trim()+"\n"
                +" */\n"
                + "public class Detail_Activity_" + classname + " extends AppCompatActivity {\n"
                + "private ExecutorService newCachedThreadPool;\n"
                + "private String URL_DATA_FIND=\"" + getFindUrl() + "\";\n"
                + "private String urlMode;\n"
                + "private String id;\n";
        return result;
    }

    private String getFindUrl() {
        String findurl = "请填写URL";
        for (Map.Entry<String, String> entry : modeUsedUrl.entrySet()) {
            if (entry.getValue().contains("getById")) {
                findurl = entry.getValue();
                break;
            }
        }
        return findurl;
    }

    private String parseInitView(String classname, List<LineMenu> lineMenus) {
        String result1 = parseViewField(classname, lineMenus);
        String result2 = ""
                + "private void initView() {\n"
                + parseViewFind(classname, lineMenus)
                + "}\n";
        return result1 + result2;
    }

    private String parseViewFind(String classname, List<LineMenu> lineMenus) {
        String result = "";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if(!"".equals(menu.getFirstannotionstring())){
                result = result + "" + menu.getFieldname() + " = (" + menu.getMenutype() + ") findViewById(R.id." + menu.getFieldname() + ");\n";
            }

        }
        result = result
                + "title = (TextView) findViewById(R.id.title);\n"
                + "cancelRelativeLayout = (RelativeLayout) findViewById(R.id.cancel_relativeLayout);\n"
                + "saveRelativeLayout = (RelativeLayout) findViewById(R.id.save_relativeLayout);\n";

        return result;
    }

    private String parseViewField(String classname, List<LineMenu> lineMenus) {
        String result = "" + "private " + classname + " detailbean;\n";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
//            if("".equals(menu.getFirstannotionstring())){
//                result = result + "private String " + menu.getFieldname() + ";\n";
//            }else{
//
//            }
            result = result + "private " + menu.getMenutype() + " " + menu.getFieldname() + ";\n";
        }
        result = result

                + "private TextView title;\n"
                + "private RelativeLayout cancelRelativeLayout;\n"
                + "private RelativeLayout saveRelativeLayout;\n";
        return result;
    }

    private String parseGetParamsMap(String classname, List<LineMenu> lineMenus) {
        String result1 = ""
                + "private HashMap<String, Object> getParamsMap() {\n"
                + "HashMap<String, Object> result = new HashMap<String, Object>();\n"
                + "result.put(\"" + Util_String.changeHeadToLowCase(classname) + ".id\",id);\n";

        String result2 = paseMapS(classname, lineMenus);
        String result3 = ""
                + "return result;\n"
                + "}\n";
        ;
        return result1 + result2 + result3;
    }

    private String paseMapS(String classname, List<LineMenu> lineMenus) {
        String result = "";

        for (Map.Entry<String, String> entry : modeUsedWeight.entrySet()) {
            if (!modeUsedUrl.get(entry.getKey()).contains("getById")) {
                result = result + "if(\"" + entry.getKey() + "\".equals(urlMode)){\n" + paseMap(classname, lineMenus, entry.getValue()) + "}\n";
            }

        }
//        for (int i = 0; i <lineMenus.size() ; i++) {
//            LineMenu menu=lineMenus.get(i);
//            if("Spinner".equals(menu.getMenutype())){
//                result=result+"result.put(\""+classname.toLowerCase()+"."+menu.getFieldname()+"\",((CodeAndString)"+menu.getFieldname()+".getSelectedItem()).getCode());\n";
//            }else{
//                result=result+"result.put(\""+classname.toLowerCase()+"."+menu.getFieldname()+"\","+menu.getFieldname()+".getText().toString());\n";
//            }
//        }
        return result;
    }

    private String paseMap(String classname, List<LineMenu> lineMenus, String value) {
        String result = "";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if (value.contains(menu.getFieldname())) {
                if(!"".equals(menu.getFirstannotionstring())){
                    if ("Spinner".equals(menu.getMenutype())) {
                        result = result + "result.put(\"" + Util_String.changeHeadToLowCase(classname) + "." + menu.getFieldname() + "\",((CodeAndString)" + menu.getFieldname() + ".getSelectedItem()).getCode());\n";
                    } else {
                        result = result + "result.put(\"" + Util_String.changeHeadToLowCase(classname) + "." + menu.getFieldname() + "\"," + menu.getFieldname() + ".getText().toString());\n";
                    }
                }else{
                        result = result + "result.put(\"" + Util_String.changeHeadToLowCase(classname) + "." + menu.getFieldname() + "\"," + menu.getFieldname() + ");\n";
                }

            }

        }
        return result;
    }

    private String parseInitBindDataToView(String classname, List<LineMenu> lineMenus) {
        String result1 = ""
                + "public void bindDataToView(){\n"
                + "if(detailbean!=null){\n";

        String result2 = parseBindFieldValue(classname, lineMenus);
        String result3 = parseBindSpinnerValue(classname, lineMenus);
        String result3_1 = "" + "if(getIntent().getBooleanExtra(\"see\",false)){\n";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if(!"".equals(menu.getFirstannotionstring())){
                if ("Spinner".equals(menu.getMenutype())) {
                    result3_1 = result3_1 + "" + menu.getFieldname() + ".setEnabled(false);\n" + "" + menu.getFieldname() + ".setOnKeyListener(null);\n";
                } else {
                    result3_1 = result3_1 + "" + menu.getFieldname() + ".setEnabled(false);\n";
                }
            }

        }
        result3_1 = result3_1 + "cancelRelativeLayout.setVisibility(View.GONE);\n"
                + "saveRelativeLayout.setVisibility(View.GONE);\n"
                + "}\n"
                + "}\n";

        String result3_2 = "hideNoNeedWeight();\n";


        String result4 = ""
                + "}\n";
        ;
        return result1 + result2 + result3 + result3_1 + result3_2 + result4;
    }

    private String parseModeShowOrHideS(List<LineMenu> lineMenus) {
        String result = "";
        for (Map.Entry<String, String> entry : modeUsedWeight.entrySet()) {
            result = result + "if(\"" + entry.getKey() + "\".equals(urlMode)){\n" + parseModeShowOrHideOne(lineMenus, entry.getValue(), modeExtraHide.get(entry.getKey())) + "}";
        }
        return result;
    }

    private String parseModeShowOrHideOne(List<LineMenu> lineMenus, String useString, String mustHideString) {
        String result = "";
        if (mustHideString == null) {
            mustHideString = "";
        }
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if(!"".equals(menu.getFirstannotionstring())){
                if ((useString.contains(menu.getFieldname())||"".equals(useString)) && !mustHideString.contains(menu.getFieldname())) {
                    if ("Spinner".equals(menu.getMenutype())) {
                        result = result + "findViewById(R.id.linespinner_" + menu.getFieldname() + ").setVisibility(View.VISIBLE);\n"
                                + "findViewById(R.id.lineview_" + menu.getFieldname() + ").setVisibility(View.VISIBLE);\n";
                    } else {
                        result = result + "findViewById(R.id.lineeditext_" + menu.getFieldname() + ").setVisibility(View.VISIBLE);\n"
                                + "findViewById(R.id.lineview_" + menu.getFieldname() + ").setVisibility(View.VISIBLE);\n";
                    }

                } else {
                    if ("Spinner".equals(menu.getMenutype())) {
                        result = result + "findViewById(R.id.linespinner_" + menu.getFieldname() + ").setVisibility(View.GONE);\n"
                                + "findViewById(R.id.lineview_" + menu.getFieldname() + ").setVisibility(View.GONE);\n";
                    } else {
                        result = result + "findViewById(R.id.lineeditext_" + menu.getFieldname() + ").setVisibility(View.GONE);\n"
                                + "findViewById(R.id.lineview_" + menu.getFieldname() + ").setVisibility(View.GONE);\n";
                    }

                }
            }

        }
        return result;
    }

    private String parseBindSpinnerValue(String classname, List<LineMenu> lineMenus) {
        String result = "";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if ("Spinner".equals(menu.getMenutype())) {
                result = result
                        + "List<CodeAndString> " + menu.getFieldname() + "datalist=((SrxSpinnerAdapter)" + menu.getFieldname() + ".getAdapter()).getmCodeAndStringlist();\n"
                        + "for (int i = 0; i <" + menu.getFieldname() + "datalist.size() ; i++) {\n"
                        + "if(" + menu.getFieldname() + "datalist.get(i).getCode().equals(detailbean." + menu.getFieldname() + ")||"+ menu.getFieldname() + "datalist.get(i).getName().equals(detailbean." + menu.getFieldname() +")){\n"
                        + "" + menu.getFieldname() + ".setSelection(i);\n"
                        + "}\n"
                        + "}\n";
            }
        }
        return result;
    }

    private String parseBindFieldValue(String classname, List<LineMenu> lineMenus) {
        String result = "";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if(!"".equals(menu.getFirstannotionstring())){

                if (!"Spinner".equals(menu.getMenutype())) {
                    result = result + "" + menu.getFieldname() + ".setText(detailbean." + menu.getFieldname() + ");\n";
                }
            }
        }
        return result;
    }

    private String parseInitListener(String classname, List<LineMenu> lineMenus) {
        String result1 = "" + "public void initListener(){\n";
        String result2 = parseSaveButton(classname, lineMenus);
        String result3 = "" + "cancelRelativeLayout.setOnClickListener(new View.OnClickListener() {\n"
                + "public void onClick(View v) {\n"
                + "finish();\n"
                + "}\n"
                + "});\n";
        String result4 = paseTime(classname, lineMenus);
        String result5 = "" + "}\n";
        return result1 + result2 + result3 + result4 + result5;
//        return result1+result4+result5;
    }

    private String parseSaveButton(String classname, List<LineMenu> lineMenus) {
        String result1 = "" + "saveRelativeLayout.setOnClickListener(new View.OnClickListener() {\n"
                + "public void onClick(View v) {\n" + parseMust(classname, lineMenus);
        String result2 = ""
                + "}\n"
                + "});\n";
        return result1 + result2;
    }

    private String paseTime(String classname, List<LineMenu> lineMenus) {
        String result = "";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if (menu.getFirstannotionstring().contains("时间") || menu.getFirstannotionstring().contains("日期")) {
                result = result + "" + menu.getFieldname() + ".setOnClickListener(new TimeClickListener(" + menu.getFieldname() + "));\n";
            }
        }
        return result;
    }

    private String parseMust(String classname, List<LineMenu> lineMenus) {
        String result1 = ""
                + "//if(MustInsert.checkAllText(getBaseContext()," + parseMustView(classname, lineMenus) + ")){\n";

        String result2 = ""
                + "new SaveDataTask().executeOnExecutor(newCachedThreadPool,getModeUrl());\n"
                + "//}\n";
        return result1 + result2;
    }

    private String parseMustView(String classname, List<LineMenu> lineMenus) {
        String result = "";
        int need = 0;
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if (menu.isIsmustinsert()) {
                need++;
                result = result + menu.getFieldname() + ",";
            }
        }
        if (need == 0) {
            result = "null";
        } else {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    public void printAllStringToJava(String... strings) {
        String clasename = strings[0];
        String javatempelt = "";
        for (int i = 1; i < strings.length; i++) {
            javatempelt = javatempelt + strings[i];
        }
        Util_File.string2Stream(javatempelt, "apps/java/com/activity/Detail_Activity_" + clasename + ".java");
    }


    private String parseInitSpinner(String classname, List<LineMenu> lineMenus) {
        String result1 = ""
                + "public void initSpinner(){\n";
        String result2 = "";
        for (int i = 0; i < lineMenus.size(); i++) {
            LineMenu menu = lineMenus.get(i);
            if ("Spinner".equals(menu.getMenutype())) {
                if (menu.getUrl() != null) {

                    result2 = result2
                            + "List<CodeAndString> " + menu.getFieldname() + "datalist=new ArrayList<>();\n"
                            + "" + menu.getFieldname() + ".setAdapter(new SrxSpinnerAdapter(getBaseContext()," + menu.getFieldname() + "datalist));\n"
                            + "new SpinnerTask(\"" + menu.getCodekey() + "\",\"" + menu.getNamekey() + "\"," + menu.getFieldname() + ").executeOnExecutor(newCachedThreadPool,\"" + menu.getUrl() + "\");\n";
                }
                if (menu.getStringarray() != null) {
                    String[] chose = menu.getStringarray();

                    String[] code = menu.getCodearray();
                    String tmp = "";
                    if (code != null) {
//                        System.out.println(menu.getFieldname());
//                        System.out.println(code.length);
//                        System.out.println(chose.length);
                        tmp = "List<CodeAndString> " + menu.getFieldname() + "datalist=new ArrayList<>();\n";
                        for (int j = 0; j < chose.length; j++) {
                            tmp = tmp + "" + menu.getFieldname() + "datalist.add(new CodeAndString(\"" + code[j] + "\",\"" + chose[j] + "\"));\n";

                        }
                        tmp = tmp + "" + menu.getFieldname() + ".setAdapter(new SrxSpinnerAdapter(getBaseContext()," + menu.getFieldname() + "datalist));\n";
                        result2 = result2 + tmp;
                    } else {
                        tmp = "List<CodeAndString> " + menu.getFieldname() + "datalist=new ArrayList<>();\n";
                        for (int j = 0; j < chose.length; j++) {
                            tmp = tmp + "" + menu.getFieldname() + "datalist.add(new CodeAndString(\"" + chose[j] + "\",\"" + chose[j] + "\"));\n";

                        }
                        tmp = tmp + "" + menu.getFieldname() + ".setAdapter(new SrxSpinnerAdapter(getBaseContext()," + menu.getFieldname() + "datalist));\n";
                        result2 = result2 + tmp;
                    }


                }
            }
        }
        String reslut3 = ""
                + "}\n";
        ;
        return result1 + result2 + reslut3;
    }

    private String parseInitData(String classname, List<LineMenu> lineMenus) {
        String result = ""
                + "private void initData() {\n"
                + "newCachedThreadPool = Executors.newFixedThreadPool(1);\n"
                + "initSpinner();\n"
                + "initListener();\n"
                + "if(getIntent().getStringExtra(\"id\")==null){//新增\n"
                + "id=UUID.randomUUID().toString().replace(\"-\",\"\");\n"
                + "bindDataToView();\n"
                + "}else{\n"
                + "id=getIntent().getStringExtra(\"id\");\n"
                + "new FindDataTask().executeOnExecutor(newCachedThreadPool,URL_DATA_FIND);\n"
                + "}\n"
                + "}\n";
        return result;
    }

    private String parseOncreate(String classname, List<LineMenu> lineMenus) {
        String result = ""
                + "protected void onCreate(@Nullable Bundle savedInstanceState) {\n"
                + "super.onCreate(savedInstanceState);\n"
                + "setContentView(R.layout.detail_activity_" + classname.toLowerCase() + ");\n"
                + "urlMode=getIntent().getStringExtra(\"urlMode\");\n"
                + "initView();\n"
                + "initData();\n"
                + "}\n";
        return result;
    }

    private void paseXml(String classname, List<LineMenu> lineMenus) {
        ParseBase layoutxml = new XmlNode().build().parse(Util_File.inputStream2String("templete/templete_layout.xml"));
        ParseBase cellline = new XmlNode().build().parse(Util_File.inputStream2String("templete/templete_line.xml"));
        ParseBase title = layoutxml.findNodeByProperty("android:id=\"@\\+id/title\"");
        boolean ispartshowneed = new LineMenu().isNeedRollbackShow(classannotationstring);//可能要去除
        title.addProperty("android:text", "" + classannotationstring.trim().split(";|:|：| ")[0] + "");
//        System.out.println(usedkeyString);
        for (int i = 0; i < lineMenus.size(); i++) {

            LineMenu menu = lineMenus.get(i);
            if(!"".equals(menu.getFirstannotionstring())){

                ParseBase cellfindtextview = cellline.findNodeByProperty("android:id=\"@\\+id/linetext\"").copy();
                ParseBase cellfindview = cellline.findNodeByProperty("android:id=\"@\\+id/lineview\"").copy();
                ParseBase cellfindedit = cellline.findNodeByProperty("android:id=\"@\\+id/lineeditext\"").copy();
                ParseBase cellfindspinner = cellline.findNodeByProperty("android:id=\"@\\+id/linespinner\"").copy();
                String annotationstring = menu.getAnnotationstring();
                String fieldname = menu.getFieldname();
                String firstannotionstring = menu.getFirstannotionstring();

//            if(!"".equals(usedkeyString)||(usedkeyString.contains(fieldname))){//说明需要进行特殊处理
//
//            }else{
//
//            }
                boolean lineneedhide = false;

                if (ispartshowneed) {
                    lineneedhide = !annotationstring.contains("Show");
                } else {
                    lineneedhide = annotationstring.contains("Hide");
                }
//            if(!"".equals(usedkeyString)){//说明需要进行特殊处理
////                System.out.println(fieldname);
//                if((usedkeyString.contains(fieldname))){
//                    lineneedhide=false;
//                }else{
//                    lineneedhide=true;
//                }
//            }
//            System.out.println("需要隐藏:"+lineneedhide);
                if (annotationstring.contains("Spinner")) {
                    ParseBase text = cellfindspinner.findNodeByProperty("android:id=\"@\\+id/text\"");
                    ParseBase value = cellfindspinner.findNodeByProperty("android:id=\"@\\+id/value\"");

                    cellfindspinner.addProperty("android:id", "@+id/linespinner_" + fieldname + "");
                    cellfindview.addProperty("android:id", "@+id/lineview_" + fieldname + "");
                    if (lineneedhide) {
                        cellfindspinner.addProperty("android:visibility", "gone");
                        cellfindview.addProperty("android:visibility", "gone");
                    }
                    text.addProperty("android:id", "@+id/" + fieldname + "_text");
                    text.addProperty("android:text", firstannotionstring.trim().split(";|:|：| ")[0] + ":");
                    value.addProperty("android:id", "@+id/" + fieldname);
                    layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/sublayout\"", cellfindspinner, cellfindview);
                } else if (annotationstring.contains("TextView")) {

                } else {
                    ParseBase text = cellfindedit.findNodeByProperty("android:id=\"@\\+id/text\"");
                    ParseBase value = cellfindedit.findNodeByProperty("android:id=\"@\\+id/value\"");

                    cellfindedit.addProperty("android:id", "@+id/lineeditext_" + fieldname + "");
                    cellfindview.addProperty("android:id", "@+id/lineview_" + fieldname + "");
                    if (lineneedhide) {
                        cellfindedit.addProperty("android:visibility", "gone");
                        cellfindview.addProperty("android:visibility", "gone");
                    }
                    text.addProperty("android:id", "@+id/" + fieldname + "_text");
                    text.addProperty("android:text", firstannotionstring.trim().split(";|:|：| ")[0] + ":");
                    value.addProperty("android:id", "@+id/" + fieldname);
                    if (firstannotionstring.contains("时间") || firstannotionstring.contains("日期")) {
                        value.addProperty("android:focusable", "false");
                    }
                    layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/sublayout\"", cellfindedit, cellfindview);
                }
            }

        }
        Util_File.string2Stream(layoutxml.getEntityString(), "apps/res/layout/detail_activity_" + classname.toLowerCase() + ".xml");
    }
}
