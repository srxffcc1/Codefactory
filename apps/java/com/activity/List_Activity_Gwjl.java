package com.android.yidongzhifa.activity;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ayplatform.anim.ZhiFaJianCha_Anim;
import com.android.ayplatform.javabean.*;
import com.android.ayplatform.utils.Connection;
import com.android.ayplatform.utils.CustomProgressDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * 公文记录表
 */
public class List_Activity_Gwjl extends Activity implements OnClickListener {
private int Page = 1;
private int Count = 1;
private int Num = 1;
private int TOTALSIZE;
private String searchtag;
private CustomProgressDialog mProgressDialog = null;
private LinearLayout myContentView;
private LinearLayout titleline;
private ImageView back;
private TextView title;
private Button btnSet;
private TextView add;
private EditText searchEdit;
private Button search;
private ListView mList;
private ImageView empty;
private Button up;
private Button down;
private TextView yeshu;
private TextView total;
private String URL_LIST="请填写URL";
private List<Gwjl> mDataList = new ArrayList<>();
HashMap<Integer, Boolean> isOpenMap = new HashMap<>();
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE);
setContentView(R.layout.list_activity_gwjl);
initView();
setDataFromNet("",1);
}
private void setDataFromNet(String searchtag, int Page) {
String urlRecord = URL_LIST+"?page="
+ Page + "&rows=10" + "";
new ListTask().execute(urlRecord,searchtag);
}
private class ListTask extends AsyncTask<String, Integer, String> {
protected void onPostExecute(String result) {
super.onPostExecute(result);
try {
mDataList.clear();
JSONObject object = new JSONObject(result);
TOTALSIZE = Integer.parseInt(object.get("total").toString());
String jsonarraystr = object.get("rows").toString();
JSONArray objectarray = new JSONArray(jsonarraystr);
GsonBuilder builder = new GsonBuilder();
builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
return new Date(json.getAsJsonPrimitive().getAsLong());
}
});
Gson gson = builder.create();
Type type = new TypeToken<ArrayList<Gwjl>>() {
}.getType();
mDataList = gson.fromJson(jsonarraystr, type);
for (int i = 0; i < objectarray.length(); i++) {
isOpenMap.put(i, false);
}
} catch (JSONException e) {
e.printStackTrace();
}
mList.setAdapter(new ListDataAdapter());
Num = (TOTALSIZE % 10 == 0) ? TOTALSIZE / 10 : TOTALSIZE / 10 + 1;
if (TOTALSIZE == 0) {
Num = 1;
}
yeshu.setText(Page + "/" + Num);
total.setText("总条数：" + TOTALSIZE + "");
stopProgressDialog();
}
protected void onPreExecute() {
super.onPreExecute();
startProgressDialog();
}
protected String doInBackground(String... arg0) {
Connection connection = new Connection(arg0[0], getBaseContext());
HashMap<String, Object> datamap = new HashMap<String, Object>();
if (arg0[1] != null && !arg0[1].equals("")) {
datamap.put("jcjl.qymc", arg0[1]);
}
String resultRecord = connection.connectPost(datamap,
getBaseContext());
return resultRecord;
}
}
class ListDataAdapter extends BaseAdapter {
private int mHiddenViewMeasuredHeight;
public int getCount() {
return mDataList.size();
}
public Object getItem(int position) {
return mDataList.get(position);
}
public long getItemId(int position) {
return position;
}
public View getView(final int position, View convertView, final ViewGroup parent) {
final ViewHolder holder;
if (convertView == null) {
convertView = getLayoutInflater().inflate(
R.layout.item_list_activity_gwjl, null);
holder = new ViewHolder();
holder.root_layout=(RelativeLayout) convertView.findViewById(R.id.root_layout);
holder.sub_layout = (LinearLayout) convertView.findViewById(R.id.sub_layout);

holder.jiantou= (ImageView) convertView.findViewById(R.id.jiantou);
                holder.title= (TextView) convertView.findViewById(R.id.title);
                holder.childtitle= (TextView) convertView.findViewById(R.id.childtitle);
holder.function_0 = (Button) convertView.findViewById(R.id.function_0);
holder.sprname = (TextView) convertView.findViewById(R.id.sprname);
holder.jlzt = (TextView) convertView.findViewById(R.id.jlzt);
holder.wcsj = (TextView) convertView.findViewById(R.id.wcsj);
holder.spqk = (TextView) convertView.findViewById(R.id.spqk);
holder.spyj = (TextView) convertView.findViewById(R.id.spyj);
convertView.setTag(holder);
} else {
holder = (ViewHolder) convertView.getTag();
}
final Gwjl bean=mDataList.get(position);
holder.sprname.setText("审批人姓名:"+bean.sprname);
holder.jlzt.setText("记录状态:"+bean.jlzt);
holder.wcsj.setText("完成时间:"+bean.wcsj);
holder.spqk.setText("审批情况:"+bean.spqk);
holder.spyj.setText("审批意见:"+bean.spyj);
//holder.sub_layout.getViewTreeObserver().addOnGlobalLayoutListener(
//new ViewTreeObserver.OnGlobalLayoutListener() {
//public void onGlobalLayout() {
//if (mHiddenViewMeasuredHeight == 0) {
//mHiddenViewMeasuredHeight = holder.sub_layout.getHeight();
//}
//holder.sub_layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//ZhiFaJianCha_Anim.rebuild(holder.jiantou, holder.sub_layout, isOpenMap.get(position), mHiddenViewMeasuredHeight);
//}
//});
//if (mHiddenViewMeasuredHeight > 0) {
//ZhiFaJianCha_Anim.rebuild(holder.jiantou, holder.sub_layout, isOpenMap.get(position), mHiddenViewMeasuredHeight);
//}
//final View finalConvertView = convertView;
//holder.root_layout.setOnClickListener(new OnClickListener() {
//public void onClick(View v) {
//isOpenMap.put(position, ZhiFaJianCha_Anim.RotateImg(holder.jiantou, holder.sub_layout, isOpenMap.get(position), mHiddenViewMeasuredHeight));
//ZhiFaJianCha_Anim.afterAnimItemScrollToEnd(parent, mList, finalConvertView, 300);
//}
//});
return convertView;
}
class ViewHolder {
ImageView jiantou;
RelativeLayout root_layout;
LinearLayout sub_layout;
            TextView title;
            TextView childtitle;Button function_0;
TextView sprname;
TextView jlzt;
TextView wcsj;
TextView spqk;
TextView spyj;
}
}
private void startProgressDialog() {
if (mProgressDialog == null) {
mProgressDialog = CustomProgressDialog.createDialog(this);
}
mProgressDialog.show();
}
private void stopProgressDialog() {
if (mProgressDialog != null) {
mProgressDialog.dismiss();
mProgressDialog = null;
}
}
public void onClick(View v) {
switch (v.getId()) {
case R.id.back:
finish();
break;
case R.id.add:
break;
case R.id.up:
if (Page == 1) {
Toast.makeText(getBaseContext(), "已是第一页",
Toast.LENGTH_SHORT).show();
} else {
Page--;
setDataFromNet(searchtag, Page);
}
break;
case R.id.down:
if (Page == Num) {
Toast.makeText(getBaseContext(), "已是最后一页",
Toast.LENGTH_SHORT).show();
} else {
Page++;
setDataFromNet(searchtag, Page);
}
break;
case R.id.search:
((InputMethodManager) getSystemService(getBaseContext().INPUT_METHOD_SERVICE))
.hideSoftInputFromWindow(
getCurrentFocus().getWindowToken(),
InputMethodManager.HIDE_NOT_ALWAYS);
Page = 1;
searchtag = searchEdit.getText().toString().trim();
setDataFromNet(searchtag, Page);
break;
}
}
private void initView() {
myContentView = (LinearLayout) findViewById(R.id.my_content_view);
titleline = (LinearLayout) findViewById(R.id.titleline);
back = (ImageView) findViewById(R.id.back);
title = (TextView) findViewById(R.id.title);
btnSet = (Button) findViewById(R.id.btnSet);
add = (TextView) findViewById(R.id.add);
searchEdit = (EditText) findViewById(R.id.search_edit);
search = (Button) findViewById(R.id.search);
mList = (ListView) findViewById(R.id.mList);
empty = (ImageView) findViewById(R.id.empty);
up = (Button) findViewById(R.id.up);
down = (Button) findViewById(R.id.down);
yeshu = (TextView) findViewById(R.id.yeshu);
total = (TextView) findViewById(R.id.total);
mList = (ListView) findViewById(R.id.mList);
title = (TextView) findViewById(R.id.title);
mList.setEmptyView(empty);
mList.setDivider(new ColorDrawable(Color.GRAY));
mList.setDividerHeight(1);
add.setOnClickListener(this);
back.setOnClickListener(this);
search.setOnClickListener(this);
up.setOnClickListener(this);
down.setOnClickListener(this);
}
}
