package com.test;

import com.business.EngineManager;
import com.business.GradleEngineObjcet;
import com.business.IBaseEngineObject;

/**
 * Created by King6rf on 2017/5/22.
 */
public class Test {
    public static void main(String[] args) {
//        business2view();
//        Gson gson=new Gson();
//        List<ModuleView> viewlist=new ArrayList<>();
//        viewlist.add(new ModuleView("企业信息","R.drawable.main_enterpiseinfo","com.shark.app.singleactivity.Activity_EnterpriseList"));
//        viewlist.add(new ModuleView("行政执法","R.drawable.main_checkup","com.shark.app.singleactivity.Activity_CheckUpList"));
//        Util_File.string2Stream(gson.toJson(viewlist,new TypeToken<List<ModuleView>>(){}.getType()),"viewlayout.json");

    }

    private static void business2view() {
        EngineManager.newInstance()
                .add(new GradleEngineObjcet("企业列表","EnterpriseList", IBaseEngineObject.BusinessType.list).addFucation("choseEnterprise"))
                .add(new GradleEngineObjcet("企业详情","EnterpriseDetail", IBaseEngineObject.BusinessType.detail).addFucation("seeDetail","seeRecord","passToCheck"))
                .add(new GradleEngineObjcet("制定（年度/季度/月度）执法计划","PlanList", IBaseEngineObject.BusinessType.list).addFucation("addPlan","seePlan"))
                .add(new GradleEngineObjcet("制定（年度/季度/月度）执法计划","PlanDetial", IBaseEngineObject.BusinessType.detail).addFucation("addPlan","seePlan","updatePlan"))
                .add(new GradleEngineObjcet("选择企业，制定检查方案","SchemeList", IBaseEngineObject.BusinessType.list).addFucation("addScheme","seeScheme"))
                .add(new GradleEngineObjcet("选择企业，制定检查方案","SchemeDetail", IBaseEngineObject.BusinessType.detail).addFucation("addScheme","seeScheme","updateScheme"))
                .add(new GradleEngineObjcet("执法检查","CheckUpList", IBaseEngineObject.BusinessType.list).addFucation("addCheckUpResult","seeCheckUpResult"))
                .add(new GradleEngineObjcet("执法检查","CheckUpDetail", IBaseEngineObject.BusinessType.detail).addFucation("addCheckUpResult","seeCheckUpResult","updateCheckUpResult","uploadObj"))
                .add(new GradleEngineObjcet("形成现场检查记录","CheckUpRecordList", IBaseEngineObject.BusinessType.list).addFucation("seeRecord"))
                .add(new GradleEngineObjcet("形成现场检查记录","CheckUpRecordDetail", IBaseEngineObject.BusinessType.list).addFucation("seeRecord"))
                .add(new GradleEngineObjcet("开具责令限期整改指令书（现场处理措施）","OfficialDispatchList", IBaseEngineObject.BusinessType.list).addFucation("addBook","seeBook"))
                .add(new GradleEngineObjcet("开具责令限期整改指令书（现场处理措施）","OfficialDispatchDetail", IBaseEngineObject.BusinessType.detail).addFucation("addBook","seeBook","updateBook"))
                .add(new GradleEngineObjcet("整改复查","RectificationReviewList", IBaseEngineObject.BusinessType.list).addFucation("passToReview"))
                .add(new GradleEngineObjcet("整改复查","RectificationReview", IBaseEngineObject.BusinessType.detail).addFucation("updateReview","uploadObj"))
                .add(new GradleEngineObjcet("移交监察支队","Transfer", IBaseEngineObject.BusinessType.detail).addFucation("addApply","updateApply","seeApply"))
                .add(new GradleEngineObjcet("进入立案","LawList", IBaseEngineObject.BusinessType.list).addFucation("addLaw","seeLaw"))
                .add(new GradleEngineObjcet("进入立案","LawDetail", IBaseEngineObject.BusinessType.detail).addFucation("addLaw","seeLaw","updateLaw"))
        ;
        EngineManager.newInstance().buildList();
//        EngineManager.newInstance().buildApp("apps/","extends FrameActivity");
    }
}
