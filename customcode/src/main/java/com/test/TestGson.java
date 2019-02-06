package com.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TestGson {
    public static void main(String[] args) {
        String str="[{\"menuId\":\"164\",\"menuName\":\"HR管理\",\"menuUrl\":\"\",\"menuTableName\":null,\"iconNo\":null,\"children\":[{\"menuId\":\"167\",\"menuName\":\"计划汇报\",\"menuUrl\":\"\",\"menuTableName\":null,\"iconNo\":null,\"children\":[{\"menuId\":\"168\",\"menuName\":\"工作汇报\",\"menuUrl\":\"jsp/enterpriseManagement/report/reportTab.jsp\",\"menuTableName\":null,\"iconNo\":null,\"children\":[]}]}]},{\"menuId\":\"40\",\"menuName\":\"系统设置\",\"menuUrl\":\"\",\"menuTableName\":null,\"iconNo\":null,\"children\":[{\"menuId\":\"50\",\"menuName\":\"系统参数设置\",\"menuUrl\":\"\",\"menuTableName\":null,\"iconNo\":null,\"children\":[{\"menuId\":\"52\",\"menuName\":\"个人密码修改\",\"menuUrl\":\"jsp/sys/sysSetting/updateUserPwd.jsp\",\"menuTableName\":null,\"iconNo\":null,\"children\":[]}]}]}]";
        Gson gson=new Gson();
        Type type = new TypeToken<List<Children>>() {}.getType();
        List<Children> listchildern=gson.fromJson(str,type);
        System.out.println(listchildern);
    }
}


/**
 * Auto-generated: 2017-08-14 19:4:20
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
 class Children {

    private String menuId;
    private String menuName;
    private String menuUrl;
    private String menuTableName;
    private String iconNo;
    private List<Children> children;
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    public String getMenuId() {
        return menuId;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuTableName(String menuTableName) {
        this.menuTableName = menuTableName;
    }
    public String getMenuTableName() {
        return menuTableName;
    }

    public void setIconNo(String iconNo) {
        this.iconNo = iconNo;
    }
    public String getIconNo() {
        return iconNo;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
    public List<Children> getChildren() {
        return children;
    }

}