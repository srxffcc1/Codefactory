package com.wisdomregulation.data.entityother;

import com.wisdomregulation.data.entitybase.DateBase_Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//用户实体
public class Entity_User extends DateBase_Entity {
    private  List<String> fieldnamelsitchinese=new ArrayList<String>();
    private  Map<String,String> fieldvaluemap=new HashMap<String, String>();
    public Entity_User(){
        super.initsuper(fieldnamelsitchinese, fieldvaluemap);
    }
    {
        fieldnamelsitchinese.clear();
        fieldnamelsitchinese.add("登录名");//0
        fieldnamelsitchinese.add("密码");//1
        fieldnamelsitchinese.add("真实姓名");//2//
        fieldnamelsitchinese.add("组织机构代码");//3 org
        fieldnamelsitchinese.add("人员类型");//4
        fieldnamelsitchinese.add("部门代码");//5
        fieldnamelsitchinese.add("人员权限");//6 dept


    }
}



//package com.wisdomregulation.data.entityother;
//public class Entity_User {
//private boolean status;
//
//private String userId;
//
//private String realName;
//
//private String avatar;
//
//private String entId;
//
//private String entName;
//
//private String roleId;
//
//private String roleName;
//
//private String departmentId;
//
//private String departmentName;
//
//private String business;
//
//private String isZf;
//
//private String password;
//
//private String sessionId;
//
//private String Id;
//
//private String org;
//
//public void setStatus(boolean status){
//this.status = status;
//}
//public boolean getStatus(){
//return this.status;
//}
//public void setUserId(String userId){
//this.userId = userId;
//}
//public String getUserId(){
//return this.userId;
//}
//public void setRealName(String realName){
//this.realName = realName;
//}
//public String getRealName(){
//return this.realName;
//}
//public void setAvatar(String avatar){
//this.avatar = avatar;
//}
//public String getAvatar(){
//return this.avatar;
//}
//public void setEntId(String entId){
//this.entId = entId;
//}
//public String getEntId(){
//return this.entId;
//}
//public void setEntName(String entName){
//this.entName = entName;
//}
//public String getEntName(){
//return this.entName;
//}
//public void setRoleId(String roleId){
//this.roleId = roleId;
//}
//public String getRoleId(){
//return this.roleId;
//}
//public void setRoleName(String roleName){
//this.roleName = roleName;
//}
//public String getRoleName(){
//return this.roleName;
//}
//public void setDepartmentId(String departmentId){
//this.departmentId = departmentId;
//}
//public String getDepartmentId(){
//return this.departmentId;
//}
//public void setDepartmentName(String departmentName){
//this.departmentName = departmentName;
//}
//public String getDepartmentName(){
//return this.departmentName;
//}
//public void setBusiness(String business){
//this.business = business;
//}
//public String getBusiness(){
//return this.business;
//}
//public void setIsZf(String isZf){
//this.isZf = isZf;
//}
//public String getIsZf(){
//return this.isZf;
//}
//public void setPassword(String password){
//this.password = password;
//}
//public String getPassword(){
//return this.password;
//}
//public void setSessionId(String sessionId){
//this.sessionId = sessionId;
//}
//public String getSessionId(){
//return this.sessionId;
//}
//public void setId(String Id){
//this.Id = Id;
//}
//public String getId(){
//return this.Id;
//}
//public void setOrg(String org){
//this.org = org;
//}
//public String getOrg(){
//return this.org;
//}
//
//}