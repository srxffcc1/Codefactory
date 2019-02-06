package com.business;

import com.codefactory.intface.CallBack;
import com.codefactory.utils.Util_File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by King6rf on 2017/5/22.
 */
public class EngineManager {
    private EngineManager(){

    }
    private static final EngineManager instance=new EngineManager();
    public static EngineManager newInstance(){
        return  instance;

    }
    public EngineManager clear(){
        list.clear();
        return  this;
    }
    List<GradleEngineObjcet> list=new ArrayList<GradleEngineObjcet>();

    public EngineManager add(GradleEngineObjcet objcet){//提炼业务 融合相同的视图
        boolean result=false;
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getBusinessview().equals(objcet.getBusinessview())){//说明存在相同的页面
                list.get(i).addAllFucation(objcet.getBusinessfuncation()).addName(objcet.getBusinessname());
                result= true;
                break;
            }
        }
        if(!result){
            list.add(objcet);
        }
        return this;
    }
//    public void parse(){
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//            System.out.println("-----------------------------");
//        }
//    }
    public void buildList(){
        for (int i = 0; i <list.size() ; i++) {
            GradleEngineObjcet tmp=list.get(i);
            System.out.println(tmp.toString());
            System.out.println("-----------------------------");
        }
    }
    public void buildApp(String parentpath,String superextends){
        Util_File.getFiles(parentpath, "", new CallBack() {
            @Override
            public void back(Object... object) {
                File file= (File) object[0];
                if(file.getName().contains("xml")||file.getName().contains("java")){
                    System.out.println("清理:"+file.getName());
                    file.delete();
                }
            }
        });
        for (int i = 0; i <list.size() ; i++) {
            GradleEngineObjcet tmp=list.get(i);
            tmp.build(superextends);
        }

    }

}
