package com.android.yidongzhifa.activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ayplatform.adapter.SrxSpinnerAdapter;
import com.android.ayplatform.javabean.CodeAndString;
import com.android.ayplatform.javabean.Gwjl;
import com.android.ayplatform.utils.*;
import com.android.ayplatform.utils.Utils;
import com.aykj.mustinsert.MustInsert;
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
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 公文记录表
 */
public class Detail_Activity_Gwjl extends AppCompatActivity {
private ExecutorService newCachedThreadPool;
private String URL_DATA_FIND="请填写URL";
private String urlMode;
private String id;
private Gwjl detailbean;
private EditText sprname;
private EditText jlzt;
private EditText gwid;
private EditText wcsj;
private EditText spqk;
private EditText spyj;
private String sprid;
private TextView title;
private RelativeLayout cancelRelativeLayout;
private RelativeLayout saveRelativeLayout;
private void initView() {
sprname = (EditText) findViewById(R.id.sprname);
jlzt = (EditText) findViewById(R.id.jlzt);
gwid = (EditText) findViewById(R.id.gwid);
wcsj = (EditText) findViewById(R.id.wcsj);
spqk = (EditText) findViewById(R.id.spqk);
spyj = (EditText) findViewById(R.id.spyj);
title = (TextView) findViewById(R.id.title);
cancelRelativeLayout = (RelativeLayout) findViewById(R.id.cancel_relativeLayout);
saveRelativeLayout = (RelativeLayout) findViewById(R.id.save_relativeLayout);
}
protected void onCreate(@Nullable Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.detail_activity_gwjl);
urlMode=getIntent().getStringExtra("urlMode");
initView();
initData();
}
private void initData() {
newCachedThreadPool = Executors.newFixedThreadPool(1);
initSpinner();
initListener();
if(getIntent().getStringExtra("id")==null){//新增
id=UUID.randomUUID().toString().replace("-","");
bindDataToView();
}else{
id=getIntent().getStringExtra("id");
new FindDataTask().executeOnExecutor(newCachedThreadPool,URL_DATA_FIND);
}
}
public void initSpinner(){
}
public void initListener(){
saveRelativeLayout.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
//if(MustInsert.checkAllText(getBaseContext(),null)){
new SaveDataTask().executeOnExecutor(newCachedThreadPool,getModeUrl());
//}
}
});
cancelRelativeLayout.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
finish();
}
});
wcsj.setOnClickListener(new TimeClickListener(wcsj));
}
public void bindDataToView(){
if(detailbean!=null){
sprname.setText(detailbean.sprname);
jlzt.setText(detailbean.jlzt);
gwid.setText(detailbean.gwid);
wcsj.setText(detailbean.wcsj);
spqk.setText(detailbean.spqk);
spyj.setText(detailbean.spyj);
if(getIntent().getBooleanExtra("see",false)){
sprname.setEnabled(false);
jlzt.setEnabled(false);
gwid.setEnabled(false);
wcsj.setEnabled(false);
spqk.setEnabled(false);
spyj.setEnabled(false);
cancelRelativeLayout.setVisibility(View.GONE);
saveRelativeLayout.setVisibility(View.GONE);
}
}
hideNoNeedWeight();
}
private HashMap<String, Object> getParamsMap() {
HashMap<String, Object> result = new HashMap<String, Object>();
result.put("gwjl.id",id);
if("Gwjl-ck".equals(urlMode)){
}
return result;
}
private String getModeUrl() {
String result="";
if("Gwjl-ck".equals(urlMode)){
result="gwjl/gwjlAction!getByid";
}
return result;
}
private void hideNoNeedWeight() {
if("Gwjl-ck".equals(urlMode)){
findViewById(R.id.lineeditext_sprname).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_sprname).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_jlzt).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_jlzt).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_gwid).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_gwid).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_wcsj).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_wcsj).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_spqk).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_spqk).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_spyj).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_spyj).setVisibility(View.VISIBLE);
}}
private class SaveDataTask extends AsyncTask<String, Integer, String> {
protected void onPostExecute(String s) {
super.onPostExecute(s);
try {
JSONObject objectItem = new JSONObject(s);
if (objectItem.getBoolean("operateSuccess") == true) {
Toast.makeText(getBaseContext(), "保存成功",
Toast.LENGTH_LONG).show();
setResult(RESULT_OK);
finish();
} else {
Toast.makeText(getBaseContext(), "保存失败",
Toast.LENGTH_LONG).show();
}
} catch (JSONException e) {
e.printStackTrace();
}
}
protected String doInBackground(String... strings) {
Connection connection = new Connection(strings[0], getBaseContext());
HashMap<String, Object> datamap = getParamsMap();
String result=connection.connectPost(datamap,getBaseContext());
return result;
}
}
private class FindDataTask extends AsyncTask<String, Integer, String> {
protected void onPostExecute(String s) {
super.onPostExecute(s);
try {
GsonBuilder builder = new GsonBuilder();
builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
return new Date(json.getAsJsonPrimitive().getAsLong());
}
});
Gson gson = builder.create();
Type type = new TypeToken<Gwjl>() {
}.getType();
detailbean = gson.fromJson(s, type);
id=detailbean.getId();
} catch (Exception e) {
detailbean = null;
e.printStackTrace();
}
if(URL_DATA_FIND.contains("填写")){
                Toast.makeText(getBaseContext(),"类里忘记填URL了吧",Toast.LENGTH_SHORT).show();
            }else{

                bindDataToView();
            }
}
protected String doInBackground(String... strings) {
Connection connection = new Connection(strings[0], getBaseContext());
HashMap<String, Object> datamap = new HashMap<>();
datamap.put("id",id);
String result=connection.connectPost(datamap,getBaseContext());
return result;
}
}
private class SpinnerTask extends AsyncTask<String, Integer, String> {
public String codekey;
public String namekey;
public Spinner spinnerbind;
public SpinnerTask(String codekey, String namekey, Spinner spinnerbind) {
this.codekey = codekey;
this.namekey = namekey;
this.spinnerbind = spinnerbind;
}
protected void onPostExecute(String s) {
super.onPostExecute(s);
try {
List<CodeAndString> codeAndStringList=new ArrayList<>();
JSONArray jsonArray=new JSONArray(s);
for (int i = 0; i <jsonArray.length() ; i++) {
JSONObject jsonObject=jsonArray.getJSONObject(i);
String code=jsonObject.optString(codekey);
String name=jsonObject.optString(namekey);
CodeAndString codeAndString=new CodeAndString(code,name);
codeAndStringList.add(codeAndString);
}
SrxSpinnerAdapter adapter=new SrxSpinnerAdapter(getBaseContext(),codeAndStringList);
spinnerbind.setAdapter(adapter);
adapter.notifyDataSetChanged();
} catch (JSONException e) {
e.printStackTrace();
}
}
protected String doInBackground(String... strings) {
Connection connection = new Connection(strings[0], getBaseContext());
HashMap<String, Object> datamap = new HashMap<>();
String result=connection.connectPost(datamap,getBaseContext());
return result;
}
}
private CustomProgressDialog mProgressDialog = null;
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
class TimeClickListener implements View.OnClickListener {
private TextView finalTime;
public TimeClickListener(TextView time) {
this.finalTime = time;
}
public void onClick(View view) {
Utils.makeDateAndTimeDialog(finalTime, view.getContext());
}
}
}
