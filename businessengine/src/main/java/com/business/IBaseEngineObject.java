package com.business;

import java.util.List;

/**
 * Created by King6rf on 2017/5/22.
 */
 public  interface IBaseEngineObject {
    public Object getEntity();
    public IBaseEngineObject setEntity(Object entity) ;
    public String getBusinessname();
    public IBaseEngineObject addName(String name);
    public List<String> getBusinessfuncation();
    public IBaseEngineObject setBusinessname(String businessname);
    public String getBusinessview();
    public IBaseEngineObject setBusinessview(String businessview) ;
    public IBaseEngineObject addAllFucation(List<String> funcations);
    public IBaseEngineObject addFucation(String... funcation);
    String getAllFuncation();
    public enum BusinessType{
        list,detail,other;
    }
    public void build(String superextends);
    public String buildXml();
    public String buildView(String superextends);
    public String buildFuncations();
}
