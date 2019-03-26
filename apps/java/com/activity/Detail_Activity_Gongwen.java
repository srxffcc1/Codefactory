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
import com.android.ayplatform.javabean.Gongwen;
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
 * 公文表
 */
public class Detail_Activity_Gongwen extends AppCompatActivity {
private ExecutorService newCachedThreadPool;
private String URL_DATA_FIND="gongwen/gongwenAction!getById";
private String urlMode;
private String id;
private Gongwen detailbean;
private EditText gwbt;
private EditText gwnr;
private EditText fsrname;
private EditText sprids;
private EditText gwfj;
private EditText gwshr;
private EditText shrid;
private String time;
private TextView title;
private RelativeLayout cancelRelativeLayout;
private RelativeLayout saveRelativeLayout;
private void initView() {
gwbt = (EditText) findViewById(R.id.gwbt);
gwnr = (EditText) findViewById(R.id.gwnr);
fsrname = (EditText) findViewById(R.id.fsrname);
sprids = (EditText) findViewById(R.id.sprids);
gwfj = (EditText) findViewById(R.id.gwfj);
gwshr = (EditText) findViewById(R.id.gwshr);
shrid = (EditText) findViewById(R.id.shrid);
title = (TextView) findViewById(R.id.title);
cancelRelativeLayout = (RelativeLayout) findViewById(R.id.cancel_relativeLayout);
saveRelativeLayout = (RelativeLayout) findViewById(R.id.save_relativeLayout);
}
protected void onCreate(@Nullable Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.detail_activity_gongwen);
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
}
public void bindDataToView(){
if(detailbean!=null){
gwbt.setText(detailbean.gwbt);
gwnr.setText(detailbean.gwnr);
fsrname.setText(detailbean.fsrname);
sprids.setText(detailbean.sprids);
gwfj.setText(detailbean.gwfj);
gwshr.setText(detailbean.gwshr);
shrid.setText(detailbean.shrid);
if(getIntent().getBooleanExtra("see",false)){
gwbt.setEnabled(false);
gwnr.setEnabled(false);
fsrname.setEnabled(false);
sprids.setEnabled(false);
gwfj.setEnabled(false);
gwshr.setEnabled(false);
shrid.setEnabled(false);
cancelRelativeLayout.setVisibility(View.GONE);
saveRelativeLayout.setVisibility(View.GONE);
}
}
hideNoNeedWeight();
}
private HashMap<String, Object> getParamsMap() {
HashMap<String, Object> result = new HashMap<String, Object>();
result.put("gongwen.id",id);
return result;
}
private String getModeUrl() {
String result="";
return result;
}
private void hideNoNeedWeight() {
if("Gongwen-ck".equals(urlMode)){
findViewById(R.id.lineeditext_gwbt).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_gwbt).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_gwnr).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_gwnr).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_fsrname).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_fsrname).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_sprids).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_sprids).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_gwfj).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_gwfj).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_gwshr).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_gwshr).setVisibility(View.VISIBLE);
findViewById(R.id.lineeditext_shrid).setVisibility(View.VISIBLE);
findViewById(R.id.lineview_shrid).setVisibility(View.VISIBLE);
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
Type type = new TypeToken<Gongwen>() {
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
