package com.wisdomregulation.data.entitybase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateBase_Entity extends Base_Entity {

    private List<String> needsqlhacklist = new ArrayList<String>();
    private Map<String, String> logicmap = new HashMap<String, String>();//用于数据库查询时的不同条件
    private Map<String, String> hacklogicmap = new HashMap<String, String>();//用于数据库查询时的不同条件
    private String keyword = "";
    private String id = "";
    private String hashid = "";
    private String datastate = "";
    private String createdatadate = "";
    private String updatadate = "";
    private String tableid = "";
    private String isadd = "";
    private String created = "";
    private String idlogic = "=";
    private String hashidlogic = "=";
    private String namelogic = "=";
    private String datastatelogic = "=";
    private String datadatelogic = "=";
    private String tableidlogic = "=";
    private String status = "";
    private String statuslogic = "=";  //2016 准备新加的优化政策

    public Base_Entity clear(){
        super.clear();//对东西进行清空
        needsqlhacklist.clear();
        logicmap.clear();
        hacklogicmap.clear();
         keyword = "";
         id = "";
         hashid = "";
         datastate = "";
         createdatadate = "";
         updatadate = "";
         tableid = "";
         isadd = "";
         created = "";
         idlogic = "=";
         hashidlogic = "=";
         namelogic = "=";
         datastatelogic = "=";
         datadatelogic = "=";
         tableidlogic = "=";
         status = "";
         statuslogic = "=";  //2016 准备新加的优化政策
        return this;
    }
    public String getStatuslogic() {
        return statuslogic;
    }

    public DateBase_Entity setStatuslogic(String statuslogic) {
        this.statuslogic = statuslogic;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public DateBase_Entity setStatus(String status) {
        this.status = status;
        return this;
    }

    public DateBase_Entity setId(String id) {
        this.id = id;
        return this;
    }

    public DateBase_Entity setHashid(String hashid) {
        this.hashid = hashid;
        return this;
    }

    public DateBase_Entity setDatastate(String datastate) {
        this.datastate = datastate;
        return this;
    }

    public DateBase_Entity setUpDatadate(String datadate) {

        this.updatadate = getTime(datadate);
        return this;
    }

    public DateBase_Entity setCreatedatadate(String createdatadate) {

        this.createdatadate = getTime(createdatadate);
        return this;
    }

    public DateBase_Entity setTableid(String tableid) {
        this.tableid = tableid;
        return this;
    }

    public DateBase_Entity setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public DateBase_Entity setKeywordAll(String keyword) {
        this.keyword = keyword;
        if (keyword != null && !keyword.equals("") && !keyword.equals(" ")) {
            putlogicAll("like");
            for (int i = 0; i < size(); i++) {
                if (!getValue(i).equals("") && !getValue(i).equals(" ")) {

                } else {
                    put(i, keyword);
                }

            }
        }

        return this;
    }

    public String getCreated() {
        if (created == null) {
            return "";
        } else {
            return created;
        }

    }

    public DateBase_Entity setCreated(String created) {
        this.created = created;
        return this;
    }

    public DateBase_Entity setIdlogic(String idlogic) {
        this.idlogic = idlogic;
        return this;
    }

    public DateBase_Entity setHashidlogic(String hashidlogic) {
        this.hashidlogic = hashidlogic;
        return this;
    }


    public DateBase_Entity setDatastatelogic(String datastatelogic) {
        this.datastatelogic = datastatelogic;
        return this;
    }

    public DateBase_Entity setNamelogic(String namelogic) {
        this.namelogic = namelogic;
        return this;
    }

    public DateBase_Entity setDatadatelogic(String datadatelogic) {
        this.datadatelogic = datadatelogic;
        return this;
    }

    public DateBase_Entity setTableidlogic(String tableidlogic) {
        this.tableidlogic = tableidlogic;
        return this;
    }

    public String getCreatedatadate() {
        if (createdatadate != null && !createdatadate.equals("") && !createdatadate.equals("null")) {

            return getTime(createdatadate);
        } else {
            return "";
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public String getIsadd() {
        return isadd;
    }

    public String getId() {
        return id;
    }

    public String getHashid() {
        return hashid;
    }

    public String getDatastate() {
        return datastate;
    }

    public String getTableid() {
        return tableid;
    }

    public String getUpDatadate() {
        if (updatadate != null && !updatadate.equals("") && !updatadate.equals("null")) {
            //System.out.println("更新原始时间结果："+updatadate);
            return getTime(updatadate);
        } else {
            return "";
        }

    }


    public String getIdlogic() {
        return idlogic;
    }

    public String getHashidlogic() {
        return hashidlogic;
    }

    public String getNamelogic() {
        return namelogic;
    }

    public String getDatastatelogic() {
        return datastatelogic;
    }

    public String getUpDatadatelogic() {
        return datadatelogic;
    }

    public String getTableidlogic() {
        return tableidlogic;
    }




    public String getDbNoHackFieldSql(int index, String logicmax) {
        String fieldname = fieldnamelsit.get(index);
        String logic = getlogic(index);
        return " " + fieldname + " " + logic + " " + "?" + " " + logicmax + "";
    }

    public String getDbHackFieldSql(int index, String logicmax) {
        if (index > fieldnamelsit.size() - 1) {
            return "";
        }
        String result = fieldvaluemap.get(fieldnamelsit.get(index));
        if (result == null || result.equals(" ") || result.equals("null")) {
            result = " ";
        }
        if (result.matches("\\s(.+)")) {
            result = result.substring(1, result.length());
        }
        String[] hackarray = result.split(",");
        String logic = getlogic(index);
        String logic2 = gethacklogic(index);
        String fieldname = getField(index);
        String resultfield = "";

        for (int i = 0; i < hackarray.length; i++) {
            resultfield = resultfield + " " + fieldname + " " + logic + " " + "?" + " " + logic2 + "";
        }
        if (resultfield.length() > 1) {
            resultfield = resultfield.substring(0, resultfield.length() - logic2.length());
        }
        if (resultfield.equals("")) {
            return "";
        }
        return "(" + resultfield + ") " + logicmax + "";
    }

    public String[] getDbHackValue(int index) {
        if (index > fieldnamelsit.size() - 1) {
            return new String[]{""};
        }
        String result = fieldvaluemap.get(fieldnamelsit.get(index));
        if (result == null || result.equals(" ") || result.equals("null")) {
            result = " ";
        }
        if (result.matches("\\s(.+)")) {
            result = result.substring(1, result.length());
        }
        String[] hackarray = result.split(",");
        String[] resultarray = new String[hackarray.length];
        for (int i = 0; i < resultarray.length; i++) {
            if (getlogic(index).equals("like")) {
                resultarray[i] = "%" + hackarray[i].trim() + "%";
            } else {
                resultarray[i] = hackarray[i].trim();
            }

        }
        return resultarray;
    }

    public String getDbFieldSql(int index, String logicmax) {
        //System.out.println("hack需要"+index);
        if (isneedhack(index)) {
            return getDbHackFieldSql(index, logicmax);
        } else {
            return getDbNoHackFieldSql(index, logicmax);
        }
    }

    public String[] getDbValue(int index) {
        if (isneedhack(index)) {
            return getDbHackValue(index);
        } else {
            return getDbNoHackValue(index);
        }

    }

    public String getDbFieldSql(String specailname, String logicmax) {
        //System.out.println("需要hack"+specailname);
        if (isneedhack(specailname)) {
            return getDbHackSpecailFieldSql(specailname, logicmax);
        } else {
            return getDbNoHackSpecailFieldSql(specailname, logicmax);
        }
    }

    public String[] getDbValue(String specailname) {
        if (isneedhack(specailname)) {
            return getDbHackSpecailValue(specailname);
        } else {
            return getDbNoHackSpecailValue(specailname);
        }

    }

    public String getDbHackSpecailFieldSql(String specailname, String logicmax) {
        String result = "";
        if (specailname.equals("id")) {
            result = id;
            //System.out.println("hanck的"+id);
        } else if (specailname.equals("hashid")) {
            result = hashid;
        } else if (specailname.equals("updatadate")) {
            result = updatadate;
        } else if (specailname.equals("tableid")) {
            result = tableid;
        } else if (specailname.equals("created")) {
            result = created;
        }
        String[] hackarray = result.split(",");
        String logic = getIdlogic();
        String resultfield = "";
        for (int i = 0; i < hackarray.length; i++) {
            resultfield = resultfield + " " + specailname + " " + logic + " " + "?" + " " + logicmax + "";
        }
        return resultfield;
    }

    public String getDbNoHackSpecailFieldSql(String specailname, String logicmax) {
        String result = "";
        if (specailname.equals("id")) {
            result = id;
        } else if (specailname.equals("hashid")) {
            result = hashid;
        } else if (specailname.equals("updatadate")) {
            result = updatadate;
        } else if (specailname.equals("tableid")) {
            result = tableid;
        }
        String logic = "";
        if (specailname.equals("id")) {
            logic = getIdlogic();
        } else if (specailname.equals("hashid")) {
            logic = getHashidlogic();
        } else if (specailname.equals("updatadate")) {
            logic = getUpDatadatelogic();
        } else if (specailname.equals("tableid")) {
            logic = getTableidlogic();
        } else {
            logic = "=";
        }
        result = " " + specailname + " " + logic + " " + "?" + " " + logicmax + "";
        return result;
    }

    public String[] getDbNoHackSpecailValue(String specailname) {
        String result = "";
        if (specailname.equals("id")) {
            result = id;
        } else if (specailname.equals("hashid")) {
            result = hashid;
        } else if (specailname.equals("updatadate")) {
            result = updatadate;
        } else if (specailname.equals("tableid")) {
            result = tableid;
        } else if (specailname.equals("created")) {
            result = created;
        }
        if (getIdlogic().equals("like")) {
            result = "%" + result + "%";
        } else {
            result = result.trim();
        }


        return new String[]{result};
    }

    public String[] getDbHackSpecailValue(String specailname) {
        String result = "";
        if (specailname.equals("id")) {
            result = id;
        } else if (specailname.equals("hashid")) {
            result = hashid;
        } else if (specailname.equals("updatadate")) {
            result = updatadate;
        } else if (specailname.equals("tableid")) {
            result = tableid;
        } else if (specailname.equals("created")) {
            result = created;
        }

        String[] hackarray = result.split(",");
        String[] resultarray = new String[hackarray.length];
        for (int i = 0; i < resultarray.length; i++) {
            if (getIdlogic().equals("like")) {
                resultarray[i] = "%" + hackarray[i].trim() + "%";
            } else {
                resultarray[i] = hackarray[i].trim();
            }

        }
        return resultarray;
    }

    public String[] getDbNoHackValue(int index) {
        if (index > fieldnamelsit.size() - 1) {
            return new String[]{""};
        }
        String result = fieldvaluemap.get(fieldnamelsit.get(index));
        if (result == null || result.equals(" ") || result.equals("null")) {
            result = "";
        }
        if (result.matches("\\s(.+)")) {
            result = result.substring(1, result.length());
        }
        if (getlogic(index).equals("like")) {
            result = "%" + result + "%";
        }
        return new String[]{result};
    }

    public boolean isneedhack(String key) {
        boolean isneed = false;
        for (int i = 0; i < needsqlhacklist.size(); i++) {
            if (needsqlhacklist.get(i).equals(key)) {
                isneed = true;
                break;
            }
        }
        return isneed;
    }


    public boolean isneedhack(int index) {
        boolean isneed = false;
        for (int i = 0; i < needsqlhacklist.size(); i++) {
            if (needsqlhacklist.get(i).equals(getField(index))) {
                isneed = true;
                break;
            }
        }
        return isneed;
    }

    /**
     * 将此字段加入 需要在生成sql语句时进行 逗号分割来解析
     *
     * @param index
     * @return
     */
    public DateBase_Entity putHack(int index) {
        needsqlhacklist.add(fieldnamelsit.get(index));
        return this;
    }

    /**
     * 将此字段加入 需要在生成sql语句时进行 逗号分割来解析 中文
     *
     * @param
     * @return
     */
    public DateBase_Entity putHack(String key) {
        needsqlhacklist.add(chinese2pinyin(key));
        return this;
    }

    public DateBase_Entity putlogic(int index, String logic) {
        logicmap.put(fieldnamelsit.get(index), logic);
        return this;
    }

    public DateBase_Entity putlogic(String key, String logic) {
        logicmap.put(chinese2pinyin(key), logic);
        return this;
    }

    public DateBase_Entity puthacklogic(int index, String logic) {
        hacklogicmap.put(fieldnamelsit.get(index), logic);
        return this;
    }

    public DateBase_Entity puthacklogic(String key, String logic) {
        hacklogicmap.put(chinese2pinyin(key), logic);
        return this;
    }

    /**
     * 设置搜索逻辑 比如 字段1 > 多少
     *
     * @param index
     * @param logic
     * @param value
     * @return
     */
    public DateBase_Entity putlogic2value(int index, String logic, String value) {
        logicmap.put(fieldnamelsit.get(index), logic);
        fieldvaluemap.put(fieldnamelsit.get(index), value);
        return this;
    }

    /**
     * 设置搜索逻辑 比如 字段1 > 多少
     *
     * @param key
     * @param logic
     * @param value
     * @return
     */
    public DateBase_Entity putlogic2value(String key, String logic, String value) {
        logicmap.put(chinese2pinyin(key), logic);
        fieldvaluemap.put(chinese2pinyin(key), value);
        return this;
    }

    public DateBase_Entity putlogicAll2(String logic) {
        for (int i = 0; i < fieldnamelsit.size(); i++) {
            logicmap.put(fieldnamelsit.get(i), logic);
        }

        return this;
    }

    public DateBase_Entity putlogicAll1(String logic) {
        setIdlogic(logic);
        setDatadatelogic(logic);
        setDatastatelogic(logic);
        setHashidlogic(logic);
        setNamelogic(logic);
        setTableidlogic(logic);
        return this;
    }

    public DateBase_Entity putlogicAll(String logic) {
        putlogicAll2(logic);
        putlogicAll1(logic);
        return this;
    }

    public String gethacklogic(String search) {
        search = chinese2pinyin(search);
        if (search.equals("") || search == null) {
            return "";
        }
        String result = hacklogicmap.get(search);
        if (result == null || result.equals("") || result.equals("null")) {
            result = "";
        }
        return result;
    }

    public String getlogic(String search) {
        search = chinese2pinyin(search);
        if (search.equals("") || search == null) {
            return "";
        }
        String result = logicmap.get(search);
        if (result == null || result.equals("") || result.equals("null")) {
            result = "";
        }
        return result;
    }

    public String gethacklogic(int index) {
        if (index > fieldnamelsit.size() - 1) {
            System.err.println("超出范围:" + getClass().getSimpleName());
            return "";
        }
        String result = hacklogicmap.get(fieldnamelsit.get(index));
        if (result == null || result.equals("") || result.equals("null")) {
            result = "";
        }
        return result;
    }

    public String getlogic(int index) {
        if (index > fieldnamelsit.size() - 1) {
            System.err.println("超出范围:" + getClass().getSimpleName());
            return "";
        }
        String result = logicmap.get(fieldnamelsit.get(index));
        if (result == null || result.equals("") || result.equals("null")) {
            result = " = ";
        }
        return result;
    }


}
