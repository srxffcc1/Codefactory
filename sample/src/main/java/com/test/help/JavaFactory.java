package com.test.help;


import com.ay.framework.annotation.ChineseName;
import com.codefactory.abstracts.ParseBase;
import com.codefactory.intface.CallBack;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import utils.Util_String;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.wisdomregulation.staticlib.Static_BookLib.*;


public class JavaFactory {
    public static void main(String[] args) {

//	getDetailXml2JavaByWebEntity();
//	convertJava2String();
//        clearXml2Java();
    }

    public static void clearXml2Java() {
        Util_File.getFiles("app/", "", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                if (file.getName().contains("xml") || file.getName().contains("java")) {
                    System.out.println("清理:" + file.getName());
                    file.delete();
                }
            }
        });
    }

    /**
     * 将java文件转化为string的类似
     * +"import com.android.ayplatform.javabean.WsAjclcp;\n"
     * +"import com.android.ayplatform.utils.Connection;\n"
     * +"import com.android.ayplatform.utils.ConvertPrint2014;\n"
     * +"import com.android.yidongzhifa.R;\n"
     * +"import com.zhihuianjianproject.data.entitybase.Base_Entity;\n"
     * +"import com.zhihuianjianproject.pdflink.Help_Pdf;\n"
     * +"import com.zhihuianjianproject.util.Static_InfoApp;\n"
     */
    private static void convertJava2String() {
        String javaorg = Util_File.inputStream2String("Activity_Detail.java");
        String[] javaorgarray = javaorg.split("\n");
        for (int i = 0; i < javaorgarray.length; i++) {
            if (javaorgarray[i].trim().equals("") || javaorgarray[i].trim().matches("(.*)TODO(.*)") || javaorgarray[i].trim().matches("(.*)Override(.*)")) {

            } else {
                System.out.println("+\"" + javaorgarray[i].trim().replace("\"", "\\\"") + "\\n\"");
            }

        }
    }

    /**
     * 解析AndroidManifest.xml
     */
    private static void parsexml() {
        String orgstring = Util_File.inputStream2String("AndroidManifest.xml");
        ParseBase linearlayout1 = new XmlNode().build().parse(orgstring);
        System.out.println(linearlayout1.getEntityString());
    }

    private static void getJavaFileList(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String javatempelt = ""
                + "﻿package com.activity;\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.HashMap;\n"
                + "import java.util.List;\n"
                + "import org.json.JSONArray;\n"
                + "import org.json.JSONObject;\n"
                + "import android.app.Activity;\n"
                + "import android.content.Intent;\n"
                + "import android.os.AsyncTask;\n"
                + "import android.os.Bundle;\n"
                + "import android.view.LayoutInflater;\n"
                + "import android.view.View;\n"
                + "import android.view.ViewGroup;\n"
                + "import android.view.Window;\n"
                + "import android.widget.BaseAdapter;\n"
                + "import android.widget.ListView;\n"
                + "import android.widget.TextView;\n"
                + "import com.android.ayplatform.utils.Connection;\n"
                + "import com.android.yidongzhifa.R;\n"
                + "import java.io.File;\n"
                + "public class Activity_List_" + outputstring + " extends Activity {\n"
                + "List<Entity" + outputstring + "> entitylist=new ArrayList<Entity" + outputstring + ">();\n"
                + "Adapter" + outputstring + " adapter;\n"
                + "ListView listview;"
                + "String url;\n"
                + "protected void onCreate(Bundle savedInstanceState) {\n"
                + "super.onCreate(savedInstanceState);\n"
                + "requestWindowFeature(Window.FEATURE_NO_TITLE);\n"
                + "setContentView(R.layout.activity_list_" + outputstring + ");\n"
                + "url = \"\";\n"
                + "initAdapter();\n"
                + "initClick();\n"
                + "}\n"
                + "protected void onResume() {\n"
                + "super.onResume();\n"
                + "}\n"
                + "public void initAdapter() {\n"
                + "listview=(ListView)findViewById(R.id.list);\n"
                + "adapter=new Adapter" + outputstring + "(this,entitylist);\n"
                + "listview.setAdapter(adapter);\n"
                + "}\n"
                + "public void initClick() {\n"
                + "}\n"
                + "protected void onActivityResult(int requestCode, int resultCode, Intent data) {\n"
                + "super.onActivityResult(requestCode, resultCode, data);\n"
                + "}\n"
                + "public HashMap<String, Object> getMap() {\n"
                + "HashMap<String, Object> result = new HashMap<String, Object>();\n"
                + "return result;\n"
                + "}\n"
                + getMultTask(outputstring, chinesenamelist, fieldlist)
                + getJavaEntityString(outputstring, chinesenamelist, fieldlist)
                + getAdapterString(outputstring, chinesenamelist, fieldlist)
                + "}\n";
        Util_File.string2Stream(javatempelt, "app/src/com/activity/Activity_List_" + outputstring + ".java");
        getItemXml(outputstring, chinesenamelist, fieldlist);
        getActivityListXml(outputstring, chinesenamelist, fieldlist);
    }

    private static void getJavaFileDetail(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String javatemplet = ""
                + "package com.activity;\n"
                + "import android.app.Activity;\n"
                + "import android.os.AsyncTask;\n"
                + "import android.os.Bundle;\n"
                + "import android.view.View;\n"
                + "import android.view.Window;\n"
                + "import android.widget.EditText;\n"
                + "import android.widget.ImageView;\n"
                + "import android.widget.TextView;\n"
                + "import android.widget.Toast;\n"
                + "import com.android.ayplatform.utils.Connection;\n"
                + "import com.android.yidongzhifa.R;\n"
                + "import com.ay.ydzf.zhifawenshu.pojo2014.*;\n"
                + "import com.wisdomregulation.data.entitybase.*;\n"
                + "import com.wisdomregulation.pdflink.IPdfBack;\n"
                + "import com.wisdomregulation.shark.PdfFactory;\n"
                + "import com.wisdomregulation.staticlib.Static_InfoApp;\n"
                + "import com.wisdomregulation.utils.ConvertPrint2017;\n"
                + "import com.wisdomregulation.utils.PdfPrintMaster;\n"
                + "import org.json.JSONObject;\n"
                + "import java.util.HashMap;\n"
                + "public class Activity_Detail_" + outputstring + " extends Activity{\n"
                + "TextView submitButton;\n"
                + "ImageView back;\n"
                + "boolean justshow;\n"
                + getJavaDetailField(outputstring, chinesenamelist, fieldlist)
                + "" + outputstring + " wenshuobject;\n"
                + "String url;\n"
                + "protected void onCreate(Bundle savedInstanceState) {\n"
                + "super.onCreate(savedInstanceState);\n"
                + "requestWindowFeature(Window.FEATURE_NO_TITLE);\n"
                + "setContentView(R.layout.detail_activity_" + outputstring.toLowerCase() + ");\n"
                + "initData();\n"
                + "initWeight();\n"
                + "initBinderData();\n"
                + "initClick();\n"
                + "if(justshow){new " + outputstring + "SubmitTask().execute();}"
                + "}\n"
                + "public HashMap<String, Object> getMap() {\n"
                + "HashMap<String, Object> result = new HashMap<String, Object>();\n"
                + getMapJava(outputstring, chinesenamelist, fieldlist)
                + "return result;\n"
                + "}\n"
                + "public void initWeight(){\n"
                + "back=(ImageView)findViewById(R.id.back);\n"
                + getInitWeight(outputstring, chinesenamelist, fieldlist)
                + "submitButton=(TextView)findViewById(R.id.submitButton);\n"
                + "if(justshow){"
                + "submitButton.setText(\"打印\");\n"
                + "}"
                + "}\n"
                + "public void initData(){\n"
                + getInitData(outputstring, chinesenamelist, fieldlist)
                + "}\n"
                + "public void initBinderData(){\n"
                + getinitBinderData(outputstring, chinesenamelist, fieldlist)
                + "}\n"
                + "public void initClick(){\n"
                + getInitClick(outputstring, chinesenamelist, fieldlist)
                + "}\n"
                + "public void submit(){\n"
                + "new " + outputstring + "SubmitTask().execute();"
                + "}\n"
                + getJavaSubmitTask(outputstring, chinesenamelist, fieldlist)
                + "}\n";

        Util_File.string2Stream(javatemplet, "app/src/com/activity/Activity_Detail_" + outputstring + ".java");
        getDetailXml(outputstring, chinesenamelist, fieldlist);
    }

    /**
     * 获得initclick
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getInitClick(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = ""
                + "submitButton.setOnClickListener(new View.OnClickListener() {\n"
                + "public void onClick(View v) {\n"
                + "if(justshow){try {\n"
                + "Base_Entity bookentity = ConvertPrint2017.getInstance().webobject2bookentity(wenshuobject);\n"
                + "PdfFactory.create().\n"
                + "setFileout(Static_InfoApp.create().getPath()+\"/dongtest.pdf\").\n"
                + "open().printerMaster(bookentity,null).close(new IPdfBack() {\n"
                + "public void writeEnd() {\n"
                + "PdfPrintMaster.print(Static_InfoApp.create().getPath()+\"/dongtest.pdf\",Activity_Detail_" + outputstring + ".this,100);\n"
                + "}\n"
                + "});\n"
                + "} catch (Exception e) {\n"
                + "e.printStackTrace();\n"
                + "}\n"
                + "}else{new " + outputstring + "SubmitTask().execute();}\n"
                + "}});back.setOnClickListener(new View.OnClickListener(){\n"
                + "public void onClick(View v) {\n"
                + "finish();\n"
                + "}});\n";
        return result;
    }

    /**
     * 获得initdata
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getInitData(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "wenshuobject=(" + outputstring + ")(getIntent().getSerializableExtra(\"wenshuobject\"));\n"
                + "if(wenshuobject==null){wenshuobject=new " + outputstring + "();"
                + "}\n"
                + "justshow=getIntent().getBooleanExtra(\"justshow\",false);\n"
                + "if(justshow){"
                + "url=\"" + Util_String.changeHeadToLowCase(outputstring) + "/" + Util_String.changeHeadToLowCase(outputstring) + "Action!getById\";"
                + "}else{"
                + "url=\"" + Util_String.changeHeadToLowCase(outputstring) + "/" + Util_String.changeHeadToLowCase(outputstring) + "Action!add\";"
                + "}";

        return result;
    }

    /**
     * 获得视图数据绑定
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getinitBinderData(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String array = "";
        for (int i = 0; i < fieldlist.size(); i++) {
            array = array
                    + "if(edit_" + fieldlist.get(i) + "!=null){"
                    + "edit_" + fieldlist.get(i) + ".setText(wenshuobject." + fieldlist.get(i) + ");"
                    + "}\n";
        }
        return result + array;
    }

    /**
     * 获得视图绑定
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getInitWeight(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String array = "";
        for (int i = 0; i < fieldlist.size(); i++) {
            array = array
                    + "edit_" + fieldlist.get(i) + "=(EditText)findViewById(R.id.edit_" + fieldlist.get(i) + ");\n"
                    + "if(justshow){"
                    + "if(edit_" + fieldlist.get(i) + "!=null){"
                    + "edit_" + fieldlist.get(i) + ".setKeyListener(null);\n"
                    + "}}else{"
                    + ""
                    + "}";
        }
        return result + array;
    }

    /**
     * 获得网络请求的map
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getMapJava(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String array = "";
        array = array + "if(justshow){"
                + "result.put(\"id\",getIntent().getStringExtra(\"id\"));\n"
                + "}else{"
                + "result.put(\"" + Util_String.changeHeadToLowCase(outputstring) + ".xzzfid\",getIntent().getStringExtra(\"xzzfid\"));\n"
                + "result.put(\"" + Util_String.changeHeadToLowCase(outputstring) + ".version\",getIntent().getStringExtra(\"version\"));\n"
                + "result.put(\"" + Util_String.changeHeadToLowCase(outputstring) + ".zzjgdm\",getIntent().getStringExtra(\"zzjgdm\"));\n"
                + "result.put(\"" + Util_String.changeHeadToLowCase(outputstring) + ".tname\",getIntent().getStringExtra(\"tname\"));\n"
                + ""
        ;

        for (int i = 0; i < fieldlist.size(); i++) {
            array = array + "result.put(\"" + Util_String.changeHeadToLowCase(outputstring) + "." + fieldlist.get(i) + "\",edit_" + fieldlist.get(i) + ".getText().toString());\n";
        }
        return result + array + "}\n";
    }

    /**
     * 获得提交
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getJavaSubmitTask(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String multemplet = ""
                + "class " + outputstring + "SubmitTask extends AsyncTask<String[], Integer, String> {\n"
                + "protected void onPreExecute() {\n"
                + "super.onPreExecute();\n"
                + "}\n"
                + "protected void onPostExecute(String result) {\n"
                + "super.onPostExecute(result);\n"
                + "try {\n"
                + "System.out.println(result);\n"
//			+"JSONArray array = new JSONArray(result);\n"
//			+"for (int i = 0; i < array.length(); i++) {\n"
                + "JSONObject jsonobject = new JSONObject(result);\n"
                + ""
                + "if(justshow){"
                + getJsonDataField(outputstring, chinesenamelist, fieldlist)
                + "initBinderData();"
                + ""
                + "}else{"
                + "boolean isok=jsonobject.getBoolean(\"operateSuccess\");"
                + "if(isok){"
                + "Toast.makeText(Activity_Detail_" + outputstring + ".this, jsonobject.getString(\"operateMessage\"), Toast.LENGTH_SHORT).show();"
                + "finish();"
                + "}else{"
                + "Toast.makeText(Activity_Detail_" + outputstring + ".this, jsonobject.getString(\"operateMessage\"), Toast.LENGTH_SHORT).show();"
                + ""
                + "}"
                + "}"
//			+"}\n"
                + "} catch (Exception e) {\n"
                + "e.printStackTrace();\n"
                + "}\n"
                + "}\n"
                + "protected String doInBackground(String[]... params) {\n"
                + "Connection connnect = new Connection(url, Activity_Detail_" + outputstring + ".this);\n"
                + "HashMap<String, Object> map = getMap();\n"
                + "String result = connnect.connectPost(map,\n"
                + "Activity_Detail_" + outputstring + ".this);\n"
                + "return result;\n"
                + "}\n"
                + "}\n";
        return multemplet;
    }

    /**
     * 对json解析成文书实体
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getJsonDataField(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String array = "";
        for (int i = 0; i < fieldlist.size(); i++) {
            array = array + "wenshuobject." + fieldlist.get(i) + "=jsonobject.getString(\"" + fieldlist.get(i) + "\");\n";
            System.out.println(outputstring + ":" + fieldlist.get(i));
        }
        return result + array;
    }

    /**
     * 生成视图字段变量
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getJavaDetailField(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String array = "";
        for (int i = 0; i < fieldlist.size(); i++) {
            array = array + "EditText edit_" + fieldlist.get(i) + ";\n";
            System.out.println(outputstring + ":" + fieldlist.get(i));
        }
        return result + array;
    }

    /**
     * 对activity进行注册
     *
     * @param classlist
     */
    private static void getManifestDetailXml(List<Object> classlist) {
        String result = "";
        ParseBase itemxml = new XmlNode().build().parse(Util_String.removeExplan(Util_File.inputStream2String("AndroidManifest.xml")));
        for (int i = 0; i < classlist.size(); i++) {
            ParseBase child0 = new XmlNode().build("activity");
            child0.setIsSpecail(true);
            child0.addProperty("android:name", "com.activity.Activity_Detail_" + classlist.get(i).getClass().getSimpleName() + "");
            itemxml.addNodeToAlreadyNodeByNodeName("application", child0);

        }
        result = itemxml.getEntityString();
        Util_File.string2Stream(result, "app/AndroidManifest.xml");
    }

    /**
     * 获得detail的xml文件
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     */
    private static void getDetailXml(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        ParseBase itemxml = new XmlNode().build().parse(Util_File.inputStream2String("templet_activity_detail.xml"));
        for (int i = 0; i < fieldlist.size(); i++) {
            ParseBase child0 = new XmlNode().build("LinearLayout");
            child0.setIsSpecail(false);
            child0.addProperty("android:layout_width", "match_parent");
            child0.addProperty("android:layout_height", "wrap_content");
            child0.addProperty("android:orientation", "horizontal");
            child0.addProperty("android:layout_marginTop", "3dp");
            child0.addProperty("android:layout_marginBottom", "3dp");
            child0.addProperty("android:id", "@+id/linear_" + fieldlist.get(i) + "");
            ParseBase child1 = new XmlNode().build("TextView");
            child1.setIsSpecail(true);
            child1.addProperty("android:layout_width", "0dp");
            child1.addProperty("android:layout_height", "wrap_content");
            child1.addProperty("android:layout_weight", "2");
            child1.addProperty("android:padding", "5dp");
            child1.addProperty("android:text", chinesenamelist.get(i));
            child1.addProperty("android:textColor", "@android:color/black");


            ParseBase child2 = new XmlNode().build("EditText");
            child2.setIsSpecail(true);
            child2.addProperty("android:id", "@+id/edit_" + fieldlist.get(i) + "");
            child2.addProperty("android:layout_width", "0dp");
            child2.addProperty("android:layout_height", "wrap_content");
            child2.addProperty("android:layout_weight", "3");
            child2.addProperty("android:background", "@drawable/shape_bg_listview");
            child2.addProperty("android:hint", "未输入");
            child2.addProperty("android:padding", "3dp");
            child2.addProperty("android:layout_margin", "2dp");
            child2.addProperty("android:textColor", "@android:color/black");
            child0.addNode(child1, child2);
            itemxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/scrollmain\"", child0);
        }
        result = result + itemxml.getEntityString();
        Util_File.string2Stream(result, "app/res/layout/detail_activity_" + outputstring.toLowerCase() + ".xml");
    }

    /**
     * 获得list的item的xml文件
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     */
    private static void getItemXml(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        ParseBase itemxml = new XmlNode().build().parse(Util_File.inputStream2String("templet_item_activity_list.xml"));
        for (int i = 0; i < fieldlist.size(); i++) {
            ParseBase child2 = new XmlNode().build("TextView");
            child2.setIsSpecail(true);
            child2.addProperty("android:id", "@+id/" + chinesenamelist.get(i) + "");
            child2.addProperty("android:layout_width", "0dp");
            child2.addProperty("android:layout_height", "wrap_content");
            child2.addProperty("android:layout_weight", "1");
            child2.addProperty("android:padding", "5dp");
            child2.addProperty("android:textColor", "@android:color/black");
            itemxml.addNode(child2);
        }
        result = result + itemxml.getEntityString();
        Util_File.string2Stream(result, "app/res/layout/item_activity_list_" + outputstring + ".xml");
    }

    /**
     * 获得list的xml文件
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     */
    private static void getActivityListXml(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        ParseBase activitylistxml = new XmlNode().build().parse(Util_String.removeExplan(Util_File.inputStream2String("templet_activity_list.xml")));
        result = result + activitylistxml.getEntityString();
        Util_File.string2Stream(result, "app/res/layout/activity_list_" + outputstring + ".xml");
    }

    /**
     * 获得multask的请求代码
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getMultTask(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String multemplet = ""
                + "class " + outputstring + "SearchTask extends AsyncTask<String[], Integer, String> {\n"
                + "protected void onPreExecute() {\n"
                + "super.onPreExecute();\n"
                + "}\n"
                + "protected void onPostExecute(String result) {\n"
                + "super.onPostExecute(result);\n"
                + "try {\n"
                + "System.out.println(result);\n"
                + "JSONArray array = new JSONArray(result);\n"
                + "entitylist.clear();\n"
                + "for (int i = 0; i < array.length(); i++) {\n"
                + "JSONObject jsonobject = array.getJSONObject(i);\n"
                + getEntity2Json(outputstring, chinesenamelist, fieldlist)
                + "}\n"
                + "adapter.notifyDataSetChanged();\n"
                + "} catch (Exception e) {\n"
                + "e.printStackTrace();\n"
                + "}\n"
                + "}\n"
                + "protected String doInBackground(String[]... params) {\n"
                + "Connection connnect = new Connection(url, Activity_List_" + outputstring + ".this);\n"
                + "HashMap<String, Object> map = getMap();\n"
                + "String result = connnect.connectPost(map,\n"
                + "Activity_List_" + outputstring + ".this);\n"
                + "return result;\n"
                + "}\n"
                + "}\n";
        return multemplet;
    }

    /**
     * 解析josn 产生集合对象
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getEntity2Json(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "Entity" + outputstring + " tmpentity=" + "new Entity" + outputstring + "();\n";
        String body = "";
        for (int i = 0; i < fieldlist.size(); i++) {
            body = body + "tmpentity.set" + fieldlist.get(i) + "(jsonobject.getString(\"" + fieldlist.get(i) + "\"));\n";
        }

        result = result + body + "entitylist.add(tmpentity);\n";
        return result;
    }

    /**
     * 获得adapter的代码
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getAdapterString(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String templetstring = ""
                + "class Adapter" + outputstring + " extends BaseAdapter {\n"
                + "Activity context;\n"
                + "List<Entity" + outputstring + "> entitylistdata;\n"
                + "public Adapter" + outputstring + "(Activity context,\n"
                + "List<Entity" + outputstring + "> entitylistdata) {\n"
                + "super();\n"
                + "this.context = context;\n"
                + "this.entitylistdata = entitylistdata;\n"
                + "}\n"
                + "public int getCount() {\n"
                + "return entitylistdata.size();\n"
                + "}\n"
                + "public Object getItem(int position) {\n"
                + "return entitylistdata.get(position);\n"
                + "}\n"
                + "public long getItemId(int position) {\n"
                + "return position;\n"
                + "}\n"
                + "public View getView(final int position, View convertView, ViewGroup parent) {\n"
                + "" + outputstring + "Holder holder;\n"
                + "if (convertView == null) {\n"
                + "holder = new " + outputstring + "Holder();\n"
                + "convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_list_" + outputstring + ", null);\n"
                + getBindHolderString(outputstring, chinesenamelist, fieldlist)
                + "convertView.setTag(holder);\n"
                + "} else {\n"
                + "holder = (" + outputstring + "Holder) convertView.getTag();\n"
                + "}\n"
                + getSetHolderString(outputstring, chinesenamelist, fieldlist)
                + "return convertView;\n"
                + "}\n"
                + getHolderString(outputstring, chinesenamelist, fieldlist)
                + "}\n";
        return templetstring;
    }

    /**
     * 获得绑定holder的代码
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getBindHolderString(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String body = "";
        for (int i = 0; i < chinesenamelist.size(); i++) {
            body = body + "holder." + chinesenamelist.get(i) + "=(TextView)convertView.findViewById(R.id." + chinesenamelist.get(i) + ");\n";
        }
        result = result + body;
        return result;
    }

    /**
     * 获得对holder对象的赋值
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getSetHolderString(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String body = "";
        for (int i = 0; i < chinesenamelist.size(); i++) {
            body = body + "holder." + chinesenamelist.get(i) + ".setText(entitylistdata.get(position).get" + fieldlist.get(i) + "());\n";
        }
        result = result + body;
        return result;
    }

    /**
     * 对holder初始化
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getHolderString(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String head = ""
                + "public class " + outputstring + "Holder {\n";

        String body = "";
        for (int i = 0; i < fieldlist.size(); i++) {
            body = body + "public TextView " + chinesenamelist.get(i) + ";\n";
        }
        String end = "" + "}\n";
        result = head + body + end;
        return result;
    }

    /**
     * 产生一个实体
     *
     * @param outputstring
     * @param chinesenamelist
     * @param fieldlist
     * @return
     */
    private static String getJavaEntityString(String outputstring, List<String> chinesenamelist, List<String> fieldlist) {
        String result = "";
        String head = ""
                + "class Entity" + outputstring + " {\n";
        String body = "";
        for (int i = 0; i < fieldlist.size(); i++) {
            body = body
                    + "private String " + fieldlist.get(i) + ";\n"
                    + "public String get" + fieldlist.get(i) + "() {\n"
                    + "return " + fieldlist.get(i) + ";\n"
                    + "}\n"
                    + "public void set" + fieldlist.get(i) + "(String " + fieldlist.get(i) + ") {\n"
                    + "this." + fieldlist.get(i) + " = " + fieldlist.get(i) + ";\n"
                    + "}\n";
        }
        String end = ""
                + "}\n";


        result = head + body + end;
        return result;
    }

    /**
     * 利用web端的实体生成list的xml和java
     *
     * @param detailpath
     * @param jsonlist
     */
    private static void getListXml2JavaByWebEntity(String detailpath, String jsonlist) {
        System.out.println(System.currentTimeMillis());
        String linestring = Util_File.inputStream2String(detailpath);
        linestring = linestring.replace("：", ":");
        String[] array = linestring.split("\n");
        int j = 0;
        List<String> fieldlist = new ArrayList<String>();
        List<String> chinesenamelist = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            String child = array[i];
            if (child.matches("([\\s\\S]*?):([\\s\\S]*?)")) {
                String childtext = child.split(":")[0];
                fieldlist.add(Util_String.chinese2pinyin(childtext));
                chinesenamelist.add(Util_String.chinese2pinyin(childtext));
                j++;

            }

        }
        String outputstring = detailpath.split("\\.")[0].trim();
        getJavaFileList(outputstring, chinesenamelist, fieldlist);
        System.out.println(System.currentTimeMillis());
        System.out.println("生成完毕");
    }

    /**
     * 生成昆明的报表xml和java文件
     */
    private static void getBaoBiaoXml2JavaByWebEntity() {
//	System.out.println(System.currentTimeMillis());
//	String linestring=Util_File.inputStream2String("baobiao.txt");
//	linestring=linestring.replace("：", ":");
//	String[] array=linestring.split("\n");
//	int j=0;
//	List<String> fieldlist=new ArrayList<String>();
//	List<String> chinesenamelist=new ArrayList<String>();
//	for (int i = 0; i < array.length; i++) {
//		String child=array[i];
//		if(child.matches("([\\s\\S]*?):([\\s\\S]*?)")){
//			String childtext=child.split(":")[0].trim();//英文
//			String fieldtext=child.split(":")[1].trim();
//			fieldlist.add(Util_String.chinese2pinyin(childtext));
//			chinesenamelist.add(fieldtext);
//			j++;
//
//		}
//
//	}
//	String outputstring="baobiao.txt".split("\\.")[0].trim();
//	getJavaFileDetail(outputstring, chinesenamelist, fieldlist);
////	getDetailXml(outputstring, chinesenamelist, fieldlist);
//	System.out.println(System.currentTimeMillis());
//	System.out.println("生成完毕");
        try {
//		getProperty(new KmJcMx());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getRegisterMan() {
        List<Object> list = new ArrayList<>();
        String webpath = "com.ay.ydzf.zhifawenshu.pojo2014";
        for (int i = 0; i < WEBBOOKNAME2017.length; i++) {
            if (!WEBBOOKNAME2017[i].equals("")) {
                try {
                    System.out.println("<activity android:name=\"com.activity.Activity_Detail_" + WEBBOOKNAME2017[i] + "\" />");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 将实体类转化为java和xml
     */
    private static void getDetailXml2JavaByWebEntity() {
        clearXml2Java();
        List<Object> list = new ArrayList<>();
        String webpath = "com.ay.ydzf.zhifawenshu.pojo2014";
        for (int i = 0; i < WEBBOOKNAME2017.length; i++) {
            if (!WEBBOOKNAME2017[i].equals("")) {
                try {
                    Object tmp = Class.forName("com.ay.ydzf.zhifawenshu.pojo2014." + WEBBOOKNAME2017[i]).newInstance();
                    list.add(tmp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                getProperty(list.get(i));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        getRegisterMan();
//	try {
//		getProperty(new Yhysxx());
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	getManifestDetailXml(list);

    }

    public static void getProperty(Object entityName) throws Exception {
        String classname = entityName.getClass().getSimpleName();
        List<String> fieldlist = new ArrayList<String>();
        List<String> chinesenamelist = new ArrayList<String>();
        Class c = entityName.getClass();
        Field[] declaredFields = c.getDeclaredFields();
        for (Field f : declaredFields) {
            ChineseName annotation = f.getAnnotation(ChineseName.class);

            if (annotation == null || annotation.equals("") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {

            } else {
                fieldlist.add(f.getName());
                System.out.println(f.getName());
                chinesenamelist.add(annotation.value().toString());
            }


        }
        getJavaFileDetail(classname, chinesenamelist, fieldlist);

    }
}
