package utils;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;
import utils.bean.LineMenu;

import java.util.List;

public class Shop_List {
    public String classannotationstring;

    public Shop_List(String classannotationstring) {
        this.classannotationstring = classannotationstring;
    }

    public String getClassannotationstring() {
        return classannotationstring;
    }

    public Shop_List setClassannotationstring(String classannotationstring) {
        this.classannotationstring = classannotationstring;
        return this;
    }
    public  void parse(String classname, List<LineMenu> lineMenus){
        parseXmlItem(classname,lineMenus);
        parseJava(classname,lineMenus);

    }

    private void parseJava(String classname, List<LineMenu> lineMenus) {
        String javatempelt=""
                +"package com.android.yidongzhifa.activity;\n"
                +"import android.app.Activity;\n"
                +"import android.graphics.Color;\n"
                +"import android.graphics.drawable.ColorDrawable;\n"
                +"import android.os.AsyncTask;\n"
                +"import android.os.Bundle;\n"
                +"import android.view.View;\n"
                +"import android.view.View.OnClickListener;\n"
                +"import android.view.ViewGroup;\n"
                +"import android.view.ViewTreeObserver;\n"
                +"import android.view.Window;\n"
                +"import android.view.inputmethod.InputMethodManager;\n"
                +"import android.widget.BaseAdapter;\n"
                +"import android.widget.Button;\n"
                +"import android.widget.EditText;\n"
                +"import android.widget.ImageView;\n"
                +"import android.widget.LinearLayout;\n"
                +"import android.widget.ListView;\n"
                +"import android.widget.RelativeLayout;\n"
                +"import android.widget.TextView;\n"
                +"import android.widget.Toast;\n"
                +"import com.android.ayplatform.anim.ZhiFaJianCha_Anim;\n"
                +"import com.android.ayplatform.javabean.*;\n"
                +"import com.android.ayplatform.utils.Connection;\n"
                +"import com.android.ayplatform.utils.CustomProgressDialog;\n"
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
                + "/**\n"
                +" * "+classannotationstring.split(";")[0].trim()+"\n"
                +" */\n"
                +"public class List_Activity_"+classname+" extends Activity implements OnClickListener {\n"
                +"private int Page = 1;\n"
                +"private int Count = 1;\n"
                +"private int Num = 1;\n"
                +"private int TOTALSIZE;\n"
                +"private String searchtag;\n"
                +"private CustomProgressDialog mProgressDialog = null;\n"
                +"private LinearLayout myContentView;\n"
                +"private LinearLayout titleline;\n"
                +"private ImageView back;\n"
                +"private TextView title;\n"
                +"private Button btnSet;\n"
                +"private TextView add;\n"
                +"private EditText searchEdit;\n"
                +"private Button search;\n"
                +"private ListView mList;\n"
                +"private ImageView empty;\n"
                +"private Button up;\n"
                +"private Button down;\n"
                +"private TextView yeshu;\n"
                +"private TextView total;\n"
                +"private String URL_LIST=\"请填写URL\";\n"
                +"private List<"+classname+"> mDataList = new ArrayList<>();\n"
                +"HashMap<Integer, Boolean> isOpenMap = new HashMap<>();\n"
                +"protected void onCreate(Bundle savedInstanceState) {\n"
                +"super.onCreate(savedInstanceState);\n"
                +"requestWindowFeature(Window.FEATURE_NO_TITLE);\n"
                +"setContentView(R.layout.list_activity_" + classname.toLowerCase() + ");\n"
                +"initView();\n"
                +"setDataFromNet(\"\",1);\n"
                +"}\n"
                +"private void setDataFromNet(String searchtag, int Page) {\n"
                +"String urlRecord = URL_LIST+\"?page=\"\n"
                +"+ Page + \"&rows=10\" + \"\";\n"
                +"new ListTask().execute(urlRecord,searchtag);\n"
                +"}\n"
                +"private class ListTask extends AsyncTask<String, Integer, String> {\n"
                +"protected void onPostExecute(String result) {\n"
                +"super.onPostExecute(result);\n"
                +"try {\n"
                +"mDataList.clear();\n"
                +"JSONObject object = new JSONObject(result);\n"
                +"TOTALSIZE = Integer.parseInt(object.get(\"total\").toString());\n"
                +"String jsonarraystr = object.get(\"rows\").toString();\n"
                +"JSONArray objectarray = new JSONArray(jsonarraystr);\n"
                +"GsonBuilder builder = new GsonBuilder();\n"
                +"builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {\n"
                +"public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {\n"
                +"return new Date(json.getAsJsonPrimitive().getAsLong());\n"
                +"}\n"
                +"});\n"
                +"Gson gson = builder.create();\n"
                +"Type type = new TypeToken<ArrayList<"+classname+">>() {\n"
                +"}.getType();\n"
                +"mDataList = gson.fromJson(jsonarraystr, type);\n"
                +"for (int i = 0; i < objectarray.length(); i++) {\n"
                +"isOpenMap.put(i, false);\n"
                +"}\n"
                +"} catch (JSONException e) {\n"
                +"e.printStackTrace();\n"
                +"}\n"
                +"mList.setAdapter(new ListDataAdapter());\n"
                +"Num = (TOTALSIZE % 10 == 0) ? TOTALSIZE / 10 : TOTALSIZE / 10 + 1;\n"
                +"if (TOTALSIZE == 0) {\n"
                +"Num = 1;\n"
                +"}\n"
                +"yeshu.setText(Page + \"/\" + Num);\n"
                +"total.setText(\"总条数：\" + TOTALSIZE + \"\");\n"
                +"stopProgressDialog();\n"
                +"}\n"
                +"protected void onPreExecute() {\n"
                +"super.onPreExecute();\n"
                +"startProgressDialog();\n"
                +"}\n"
                +"protected String doInBackground(String... arg0) {\n"
                +"Connection connection = new Connection(arg0[0], getBaseContext());\n"
                +"HashMap<String, Object> datamap = new HashMap<String, Object>();\n"
                +"if (arg0[1] != null && !arg0[1].equals(\"\")) {\n"
                +"datamap.put(\"jcjl.qymc\", arg0[1]);\n"
                +"}\n"
                +"String resultRecord = connection.connectPost(datamap,\n"
                +"getBaseContext());\n"
                +"return resultRecord;\n"
                +"}\n"
                +"}\n"
                +"class ListDataAdapter extends BaseAdapter {\n"
                +"private int mHiddenViewMeasuredHeight;\n"
                +"public int getCount() {\n"
                +"return mDataList.size();\n"
                +"}\n"
                +"public Object getItem(int position) {\n"
                +"return mDataList.get(position);\n"
                +"}\n"
                +"public long getItemId(int position) {\n"
                +"return position;\n"
                +"}\n"
                +"public View getView(final int position, View convertView, final ViewGroup parent) {\n"
                +"final ViewHolder holder;\n"
                +"if (convertView == null) {\n"
                +"convertView = getLayoutInflater().inflate(\n"
                +"R.layout.item_list_activity_"+classname.toLowerCase()+", null);\n"
                +"holder = new ViewHolder();\n"
                +parseHolderFind(classname,lineMenus)
                +"convertView.setTag(holder);\n"
                +"} else {\n"
                +"holder = (ViewHolder) convertView.getTag();\n"
                +"}\n"
                +parseBean(classname,lineMenus)
                +"//holder.sub_layout.getViewTreeObserver().addOnGlobalLayoutListener(\n"
                +"//new ViewTreeObserver.OnGlobalLayoutListener() {\n"
                +"//public void onGlobalLayout() {\n"
                +"//if (mHiddenViewMeasuredHeight == 0) {\n"
                +"//mHiddenViewMeasuredHeight = holder.sub_layout.getHeight();\n"
                +"//}\n"
                +"//holder.sub_layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);\n"
                +"//ZhiFaJianCha_Anim.rebuild(holder.jiantou, holder.sub_layout, isOpenMap.get(position), mHiddenViewMeasuredHeight);\n"
                +"//}\n"
                +"//});\n"
                +"//if (mHiddenViewMeasuredHeight > 0) {\n"
                +"//ZhiFaJianCha_Anim.rebuild(holder.jiantou, holder.sub_layout, isOpenMap.get(position), mHiddenViewMeasuredHeight);\n"
                +"//}\n"
                +"//final View finalConvertView = convertView;\n"
                +"//holder.root_layout.setOnClickListener(new OnClickListener() {\n"
                +"//public void onClick(View v) {\n"
                +"//isOpenMap.put(position, ZhiFaJianCha_Anim.RotateImg(holder.jiantou, holder.sub_layout, isOpenMap.get(position), mHiddenViewMeasuredHeight));\n"
                +"//ZhiFaJianCha_Anim.afterAnimItemScrollToEnd(parent, mList, finalConvertView, 300);\n"
                +"//}\n"
                +"//});\n"
                +"return convertView;\n"
                +"}\n"
                +"class ViewHolder {\n"
                +"ImageView jiantou;\n"
                +"RelativeLayout root_layout;\n"
                +"LinearLayout sub_layout;\n"
                +parseHolderInit(classname,lineMenus)
                +"}\n"
                +"}\n"
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
                +"public void onClick(View v) {\n"
                +"switch (v.getId()) {\n"
                +"case R.id.back:\n"
                +"finish();\n"
                +"break;\n"
                +"case R.id.add:\n"
                +"break;\n"
                +"case R.id.up:\n"
                +"if (Page == 1) {\n"
                +"Toast.makeText(getBaseContext(), \"已是第一页\",\n"
                +"Toast.LENGTH_SHORT).show();\n"
                +"} else {\n"
                +"Page--;\n"
                +"setDataFromNet(searchtag, Page);\n"
                +"}\n"
                +"break;\n"
                +"case R.id.down:\n"
                +"if (Page == Num) {\n"
                +"Toast.makeText(getBaseContext(), \"已是最后一页\",\n"
                +"Toast.LENGTH_SHORT).show();\n"
                +"} else {\n"
                +"Page++;\n"
                +"setDataFromNet(searchtag, Page);\n"
                +"}\n"
                +"break;\n"
                +"case R.id.search:\n"
                +"((InputMethodManager) getSystemService(getBaseContext().INPUT_METHOD_SERVICE))\n"
                +".hideSoftInputFromWindow(\n"
                +"getCurrentFocus().getWindowToken(),\n"
                +"InputMethodManager.HIDE_NOT_ALWAYS);\n"
                +"Page = 1;\n"
                +"searchtag = searchEdit.getText().toString().trim();\n"
                +"setDataFromNet(searchtag, Page);\n"
                +"break;\n"
                +"}\n"
                +"}\n"
                +"private void initView() {\n"
                +"myContentView = (LinearLayout) findViewById(R.id.my_content_view);\n"
                +"titleline = (LinearLayout) findViewById(R.id.titleline);\n"
                +"back = (ImageView) findViewById(R.id.back);\n"
                +"title = (TextView) findViewById(R.id.title);\n"
                +"btnSet = (Button) findViewById(R.id.btnSet);\n"
                +"add = (TextView) findViewById(R.id.add);\n"
                +"searchEdit = (EditText) findViewById(R.id.search_edit);\n"
                +"search = (Button) findViewById(R.id.search);\n"
                +"mList = (ListView) findViewById(R.id.mList);\n"
                +"empty = (ImageView) findViewById(R.id.empty);\n"
                +"up = (Button) findViewById(R.id.up);\n"
                +"down = (Button) findViewById(R.id.down);\n"
                +"yeshu = (TextView) findViewById(R.id.yeshu);\n"
                +"total = (TextView) findViewById(R.id.total);\n"
                +"mList = (ListView) findViewById(R.id.mList);\n"
                +"title = (TextView) findViewById(R.id.title);\n"
                +"mList.setEmptyView(empty);\n"
                +"mList.setDivider(new ColorDrawable(Color.GRAY));\n"
                +"mList.setDividerHeight(1);\n"
                +"add.setOnClickListener(this);\n"
                +"back.setOnClickListener(this);\n"
                +"search.setOnClickListener(this);\n"
                +"up.setOnClickListener(this);\n"
                +"down.setOnClickListener(this);\n"
                +"}\n"
                +"}\n";
        Util_File.string2Stream(javatempelt, "apps/java/com/activity/List_Activity_" + classname + ".java");
    }

    private String parseBean(String classname, List<LineMenu> lineMenus) {
        String result="final "+classname+" bean=mDataList.get(position);\n";

        String[] shows=new LineMenu().getListShow(classannotationstring);

        if(shows!=null){
            for (int i = 0; i <shows.length ; i++) {
                result=result+"holder."+shows[i]+".setText(\""+new LineMenu().findAnnotionstring(lineMenus,shows[i])+"\"+bean."+shows[i]+");\n";
            }
        }
        return result;
    }

    private String parseHolderInit(String classname, List<LineMenu> lineMenus) {
        String[] functions=new LineMenu().getListFunction(classannotationstring);
        String[] shows=new LineMenu().getListShow(classannotationstring);
        String result="            TextView title;\n" +
                "            TextView childtitle;";
        if(functions!=null){
            for (int i = 0; i <functions.length ; i++) {
                result=result+"Button function_"+i+";\n";
            }
        }
        if(shows!=null){
            for (int i = 0; i <shows.length ; i++) {
                result=result+"TextView "+shows[i]+";\n";
            }
        }


        return result;
    }

    private String parseHolderFind(String classname, List<LineMenu> lineMenus) {

        String[] functions=new LineMenu().getListFunction(classannotationstring);
        String[] shows=new LineMenu().getListShow(classannotationstring);
        String result="holder.root_layout=(RelativeLayout) convertView.findViewById(R.id.root_layout);\n" +
                      "holder.sub_layout = (LinearLayout) convertView.findViewById(R.id.sub_layout);\n\n" +
                      "holder.jiantou= (ImageView) convertView.findViewById(R.id.jiantou);\n" +
                "                holder.title= (TextView) convertView.findViewById(R.id.title);\n" +
                "                holder.childtitle= (TextView) convertView.findViewById(R.id.childtitle);\n";
        if(functions!=null){
            for (int i = 0; i <functions.length ; i++) {
                result=result +"holder.function_"+i+" = (Button) convertView.findViewById(R.id.function_"+i+");\n";
            }
        }
        if(shows!=null){
            for (int i = 0; i <shows.length ; i++) {
                result=result +"holder."+shows[i]+" = (TextView) convertView.findViewById(R.id."+shows[i]+");\n";
            }
        }

        return result;
    }

    private void parseXmlItem(String classname, List<LineMenu> lineMenus) {
        ParseBase listxml = new XmlNode().build().parse(Util_File.inputStream2String("templete/templete_list.xml"));
        ParseBase title=listxml.findNodeByProperty("android:id=\"@\\+id/title\"");
        title.addProperty("android:text",""+classannotationstring.split(";")[0]+"");
        ParseBase layoutxml = new XmlNode().build().parse(Util_File.inputStream2String("templete/templete_list_item.xml"));
        ParseBase cellline = new XmlNode().build().parse(Util_File.inputStream2String("templete/templete_list_item_line.xml"));
        String[] functions=new LineMenu().getListFunction(classannotationstring);
        String[] shows=new LineMenu().getListShow(classannotationstring);
        if(functions!=null){
            for (int i = 0; i <functions.length ; i++) {
                ParseBase cellvalue=cellline.findNodeByProperty("android:id=\"@\\+id/function\"").copy();
                cellvalue.addProperty("android:text",functions[i]);
//                if(i!=0){
//                    cellvalue.addProperty("android:layout_below","@+id/function_"+(i-1));
//                }
                cellvalue.addProperty("android:id","@+id/function_"+i);
                layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/functionlayout\"",cellvalue);
            }
        }
        if(shows!=null){
            for (int i = 0; i <shows.length ; i++) {
                ParseBase cellvalue=cellline.findNodeByProperty("android:id=\"@\\+id/value\"").copy();
                cellvalue.addProperty("android:text",shows[i]);
                if(i!=0){
                    cellvalue.addProperty("android:layout_below","@+id/"+shows[i-1]);
                }
                cellvalue.addProperty("android:id","@+id/"+shows[i]);
                layoutxml.addNodeToAlreadyNodeByProperty("android:id=\"@\\+id/valuelayout\"",cellvalue);
            }
        }


        Util_File.string2Stream(layoutxml.getEntityString(), "apps/res/layout/item_list_activity_" + classname.toLowerCase() + ".xml");
        Util_File.string2Stream(listxml.getEntityString(), "apps/res/layout/list_activity_" + classname.toLowerCase() + ".xml");

    }

}
