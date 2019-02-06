package com.business;

import com.codefactory.utils.Util_File;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by King6rf on 2017/5/22.
 * 业务类
 */
public class GradleEngineObjcet implements IBaseEngineObject {
    public String businessname;//业务名称
    public String businessview;//业务涉及的页面
    public IBaseEngineObject.BusinessType viewtype;//视图类型 list detail other
    public Object entity;//业务实体
    public List<String> businessfuncation=new ArrayList<String>();//业务涉及的需要实现的方法

    public GradleEngineObjcet(String businessname, String businessview, IBaseEngineObject.BusinessType type) {
        this.businessname = businessname;
        this.businessview = businessview;
        this.viewtype=type;
        if(type== IBaseEngineObject.BusinessType.list){
            businessfuncation.add("order");
            businessfuncation.add("search");
        }
    }

    public Object getEntity() {
        return entity;
    }

    public GradleEngineObjcet setEntity(Object entity) {
        this.entity = entity;
        return this;
    }

    public String getBusinessname() {
        return businessname;
    }
    public GradleEngineObjcet addName(String name){
        businessname=businessname+","+name;
        return this;
    }
    public List<String> getBusinessfuncation() {
        return businessfuncation;
    }

    public GradleEngineObjcet setBusinessname(String businessname) {
        this.businessname = businessname;
        return this;
    }

    public String getBusinessview() {
        return businessview;
    }

    public GradleEngineObjcet setBusinessview(String businessview) {
        this.businessview = businessview;
        return this;
    }
    public GradleEngineObjcet addAllFucation(List<String> funcations){
        businessfuncation.addAll(funcations);
        return this;
    }
    public GradleEngineObjcet addFucation(String... funcation){
        for (int i = 0; i <funcation.length ; i++) {
            businessfuncation.add(funcation[i]);
        }

        return this;
    }
    public String getAllFuncation(){
        String result="";
        for (int i = 0; i <businessfuncation.size() ; i++) {
            result=result+businessfuncation.get(i)+":\n";
        }
        return "\n"+result.substring(0,result.length()-1);
    }
    @Override
    public String toString() {
        String result="业务名称:"+getBusinessname()+"\n业务视图:"+getBusinessview()+"\n视图类型:"+viewtype+"\n业务方法:"+getAllFuncation();
        return result;
    }
    public void build(String superextends){
        System.out.println(buildView(superextends));
        System.out.println(buildXml());
        Util_File.string2Stream(buildView(superextends),"apps/src/main/java/com/shark/app/singleactivity/Activity_"+businessview+".java");
        Util_File.string2Stream(buildXml(),"apps/src/main/res/layout/"+(viewtype==BusinessType.list?"list_activity_":"detail_activity_")+businessview.toLowerCase()+".xml");

    }
    public String buildXml(){
        String templete=Util_File.inputStream2String(viewtype==BusinessType.list?"templete/templet_activity_list.xml":"templete/templet_activity_detail.xml");
        String result="";
        result=result+templete;
        return result;
    }
    public String buildView(String superextends){
        String result="";
        result=result+
                "" +
                "package com.shark.app.singleactivity;\n" +
                "import android.os.Bundle;\n" +
                "import android.os.Message;\n" +
                "import android.support.annotation.Nullable;\n" +
                "import com.businessframehelp.app.FrameActivity;\n" +
                "import com.businessframehelp.enums.ORIENTATION;\n" +
                "" +
                "abstract public class Activity" +businessview+" "+superextends+"\n"+
                "{\n" +
                "" +buildFuncations()+"\n"+
                "" +
                "" +
                "" +
                "}\n" +
                "";
        return result;
    }
    public String buildFuncations(){
        String result="";
        for (int i = 0; i <businessfuncation.size() ; i++) {
            result=result+
                    "" +
                    "    public void "+businessfuncation.get(i)+"(){\n" +
                    "        \n" +
                    "    }\n" +
                    "";
        }
        return result;
    }
}
