package com.wisdomregulation.data.entitybase;

import com.github.promeg.pinyinhelper.Pinyin;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateBase_Entity implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<String> fieldnamelsit = new ArrayList<String>();
    private List<String> needsqlhacklist = new ArrayList<String>();
    private Map<String, String> fieldvaluemap = new HashMap<String, String>();
    private List<String> fieldnamelsitchinese = new ArrayList<String>();
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
    private int tmpkey = -1;
    private String xzzfid;
    private String tname;
    private String qyid;
    private String version;
    private int pullkey = 0;
    private int pushkey = 0;
    private Object extraobj;//额外的附加

    public DateBase_Entity() {

    }

    public Object getExtraobj() {
        return extraobj;
    }

    /**
     * 设置额外对象
     *
     * @param extraobj
     * @return
     */
    public DateBase_Entity setExtraobj(Object extraobj) {
        this.extraobj = extraobj;
        return this;
    }

    /**
     * 子类数据形对象必须调用的方法为了配置一些参数
     *
     * @param fieldnamelsitchinese
     * @param fieldvaluemap
     */
    public void initsuper(List<String> fieldnamelsitchinese, Map<String, String> fieldvaluemap) {
        this.fieldnamelsitchinese = fieldnamelsitchinese;
        this.fieldvaluemap = fieldvaluemap;
        boolean neederr = false;
        for (int i = 0; i < fieldnamelsitchinese.size(); i++) {
            if (isInList(chinese2pinyin(fieldnamelsitchinese.get(i)))) {
                neederr = true;
                System.err.println(getClass().getSimpleName() + ":list有重复:" + fieldnamelsitchinese.get(i));
            }
            fieldnamelsit.add(chinese2pinyin(fieldnamelsitchinese.get(i)));
        }
        if (neederr) {
            System.err.println("----------------------------------------");
        }

        for (int i = 0; i < fieldnamelsitchinese.size(); i++) {
            logicmap.put(fieldnamelsit.get(i), "=");
        }
        for (int i = 0; i < fieldnamelsitchinese.size(); i++) {
            hacklogicmap.put(fieldnamelsit.get(i), "and");
        }
        init();
    }

    public String getStatuslogic() {
        return statuslogic;
    }

    public DateBase_Entity setStatuslogic(String statuslogic) {
        this.statuslogic = statuslogic;
        return this;
    }

    public String getXzzfid() {
        return xzzfid;
    }

    public DateBase_Entity setXzzfid(String xzzfid) {
        this.xzzfid = xzzfid;
        return this;
    }

    public String getTname() {
        return tname;
    }

    public DateBase_Entity setTname(String tname) {
        this.tname = tname;
        return this;
    }

    public String getQyid() {
        return qyid;
    }

    public DateBase_Entity setQyid(String qyid) {
        this.qyid = qyid;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public DateBase_Entity setVersion(String version) {
        this.version = version;
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

    public String getField(int index) {
        return fieldnamelsit.get(index);
    }

    public String getFieldChinese(int index) {
        return fieldnamelsitchinese.get(index);
    }

    /**
     * 获得key队应的falue
     *
     * @param searchkey
     * @return
     */
    public String getValue(String searchkey) {
        int searchkeyint = -1;
        try {
            searchkeyint = Integer.parseInt(searchkey);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (searchkeyint != -1 && searchkeyint < fieldvaluemap.size()) {
            return getValue(searchkeyint);
        }
        searchkey = chinese2pinyin(searchkey);
        if (searchkey.equals("") || searchkey == null) {
            return "";
        }
        String result = fieldvaluemap.get(searchkey);
        if (result == null || result.equals(" ") || result.equals("null")) {
            result = " ";
        }
        if (result.matches("\\s(.+)")) {
            result = result.substring(1, result.length());
        }
        return result;
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

    public String getValue(int index) {
        if (index > fieldnamelsit.size() - 1) {
            if (canaddlist()) {
                String result = fieldvaluemap.get("demo:" + index);
                return result;
            } else {
                return "";
            }

        }
        String result = fieldvaluemap.get(fieldnamelsit.get(index));
        if (result == null || result.equals(" ") || result.equals("null")) {
            result = " ";
        }
        if (result.matches("\\s(.+)")) {
            result = result.substring(1, result.length());
        }
        return result;
    }

    public String getData(int index, int splitindex) {
        String datehassplit = getField(index);
        if (!datehassplit.matches("(.*)-(.*)")) {
            return "";
        } else {
            String[] datehasnosplit = datehassplit.split("-");
            return datehasnosplit[splitindex].trim();
        }
    }

    public int size() {
        return fieldnamelsit.size();
    }

    public DateBase_Entity clear() {
        fieldvaluemap.clear();
        keyword = "";
        return this;
    }

    /**
     * 按顺序push出东西
     *
     * @return
     */
    public String push(int key) {
        tmpkey = key;
        if (key > fieldnamelsit.size() - 1) {
            return "";
        }
        return getValue(key);
    }

    /**
     * 按顺序push出东西 打开push锁
     *
     * @return
     */
    public String push(boolean lock) {
        System.out.println(pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            System.err.println("超出范围");
            return "";
        }
        if (!lock) {
            pushkey--;
        }
        return getValue(pushkey++);
    }

    /**
     * 按顺序push出东西
     *
     * @return
     */
    public String push() {
//        System.out.println(pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            System.err.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
            return "";
        }
        if (tmpkey != -1) {//说明进行了特殊push
            if (tmpkey > fieldnamelsit.size() - 1) {
                return "";
            }
            pushkey = tmpkey;
            tmpkey = -1;//还原为-1
        }
        return getValue(pushkey++);
    }
    /**
     * 按顺序push出东西
     *
     * @return
     */
    public String  justpushnoreturn() {
//        System.out.println(pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            System.err.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
            return "";
        }
        if (tmpkey != -1) {//说明进行了特殊push
            if (tmpkey > fieldnamelsit.size() - 1) {
                return "";
            }
            pushkey = tmpkey;
            tmpkey = -1;//还原为-1
        }
        if (getFieldChinese(pushkey).matches("(.*时间.*)|(.*日期.*)|(.*list.*)|(.*期限.*)")) {
            pushkey--;//对pushkey进行锁住 使得不能前进
        } else {

        }
        pushkey++;
        return "";
    }
    /**
     * 按顺序push出东西
     *
     * @return
     */
    public String pushneedcheck() {
//        System.out.println(pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            System.err.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
            return "";
        }
        if (tmpkey != -1) {//说明进行了特殊push
            if (tmpkey > fieldnamelsit.size() - 1) {
                return "";
            }
            pushkey = tmpkey;
            tmpkey = -1;//还原为-1
        }
        if (getFieldChinese(pushkey).matches("(.*时间.*)|(.*日期.*)|(.*list.*)|(.*期限.*)")) {
            pushkey--;//对pushkey进行锁住 使得不能前进
        } else {

        }
        return getValue(pushkey++);
    }

    public DateBase_Entity pull(String value) {
        if (pullkey > fieldnamelsit.size() - 1) {
            System.err.println("超出范围:" + getClass().getSimpleName());
        } else {
            fieldvaluemap.put(fieldnamelsit.get(pullkey++), value);
        }


        return this;
    }

    public DateBase_Entity put(String key, String value) {
        if (canaddlist()) {
            if (!isInList(chinese2pinyin(key))) {
                fieldnamelsitchinese.add(key);
                fieldnamelsit.add(chinese2pinyin(key));
            }
            fieldvaluemap.put(chinese2pinyin(key), value);
        } else {
            fieldvaluemap.put(chinese2pinyin(key), value);
        }

        return this;
    }

    public boolean isInList(String filed) {
        boolean result = false;
        for (int i = 0; i < fieldnamelsit.size(); i++) {
            if (filed.equals(fieldnamelsit.get(i))) {
                return true;
            }
        }
        return result;
    }

    public DateBase_Entity nput(String key, String value) {
//        long old=System.currentTimeMillis();
        fieldvaluemap.put(chinese2pinyin(key), value.replaceAll("\n", "").replaceAll("\"", "“"));
//        System.out.println("耗时：nput"+(System.currentTimeMillis()-old));
        return this;
    }

    public DateBase_Entity uput(String key, String value) {
//        long old=System.currentTimeMillis();
        fieldvaluemap.put(chinese2pinyin(value).replaceAll("\n", "").replaceAll("\"", "“"), key);
//        System.out.println("耗时：uput"+(System.currentTimeMillis()-old));
        return this;
    }

    /**
     * 重写此方法来确认扩展锁
     *
     * @return
     */
    protected boolean canaddlist() {
        return false;
    }

    /**
     * 一个可扩展的方法 前提是扩展锁打开
     *
     * @param key
     * @param value
     * @return
     */
    public DateBase_Entity add(String key, String value) {
        if (canaddlist()) {
            fieldnamelsitchinese.add(key);
            fieldnamelsit.add(chinese2pinyin(key));
            fieldvaluemap.put(chinese2pinyin(key), value);
        }

        return this;
    }

    public DateBase_Entity put(int index, String value) {
        if (index > size() - 1) {
            System.err.println("超出范围:" + getClass().getSimpleName());
            if (canaddlist()) {
                fieldvaluemap.put("demo:" + index, value);
            }
        } else {
            fieldvaluemap.put(fieldnamelsit.get(index), value);
        }

        return this;
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
            result = "";
        }
        return result;
    }

    /**
     * 中文转拼音
     *
     * @param chinesestr
     * @return
     */
    private String chinese2pinyin(String chinesestr) {
        long old = System.currentTimeMillis();
//        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String targetchinese = Pinyin.toPinyin(chinesestr, "");

//        char[] chinesechar = chinesestr.toCharArray();
//        try {
//            for (int i = 0; i < chinesechar.length; i++) {
//
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        if (targetchinese.length() > 60) {
            targetchinese = targetchinese.substring(0, 60);
        }

        return targetchinese.toLowerCase();
    }

    public boolean isempty() {
        return fieldvaluemap.size() == 0 ? true : false;
    }

    /**
     * 初始化字段 一般可以不用
     *
     * @return
     */
    public DateBase_Entity init() {
        fieldvaluemap.clear();
        for (int i = 0; i < fieldnamelsit.size(); i++) {
            fieldvaluemap.put(fieldnamelsit.get(i), " ");
        }
        keyword = "";
        return this;
    }

    /**
     * 特定key初始化 用于多条件匹配
     *
     * @param
     * @return
     */
    public DateBase_Entity init(String key) {
        fieldvaluemap.clear();
        for (int i = 0; i < fieldnamelsit.size(); i++) {
            fieldvaluemap.put(fieldnamelsit.get(i), key);

        }
        keyword = "";
        return this;
    }
    /**
     * 打印自己的方法 可以重写此方法
     *
     * @return
     */

    public DateBase_Entity printSelf() {
        return this;
    }

    public DateBase_Entity clearOther() {
        this.id = "";
        this.hashid = "";
        this.datastate = "";
        this.updatadate = "";
        this.tableid = "";
        this.isadd = "";
        this.status = "";
        return this;
    }

    public DateBase_Entity initId() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        return this;
    }

    /**
     * 格式化字符串成时间字符串 用-号隔开
     * @param time 时间字符串
     * @return
     */
    public static String getTime(String time) {//格式化任意时间格式yyyy-MM-dd-HH-mm-ss
        String resulttime = "";
        if (time == null || time.equals("")) {//如果为空
            System.err.println("时间为空:"+time);
            resulttime = "";
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            try {//尝试用long来解析字符串
                long longs=Long.parseLong(time);
                Date date=new Date();
                date.setTime(longs);
                resulttime=sdf.format(date).toString();
            } catch (NumberFormatException e) {
//            e.printStackTrace();
            }
            try {//尝试用年月日时分秒中文来匹配
                if(time.matches("(.*年.*)|(.*月.*)|(.*日.*)|(.*时.*)|(.*分.*)|(.*秒.*)")){
                    char[] timearray=time.toCharArray();
                    String nian="";
                    String yue="";
                    String ri="";
                    String shi="";
                    String fen="";
                    String miao="";
                    int start=0;
                    int end=0;
                    for (int i = 0; i <timearray.length ; i++) {
                        if(Character.isDigit(timearray[i])){

                        }else{
                            end=i;
                            try {
                                if(timearray[i]=='年'){
                                    nian=time.substring(start,end);
                                }
                                if(timearray[i]=='月'){
                                    yue=time.substring(start,end);

                                }
                                if(timearray[i]=='日'){
                                    ri=time.substring(start,end);

                                }
                                if(timearray[i]=='时'){
                                    shi=time.substring(start,end);

                                }
                                if(timearray[i]=='分'){
                                    fen=time.substring(start,end);

                                }
                                if(timearray[i]=='秒'){
                                    miao=time.substring(start,end);

                                }
                            } catch (Exception e) {
                                System.out.println("start:"+start+",end:"+end);
                                e.printStackTrace();
                            }
                            start=i+1;
                        }
                    }
                    resulttime=nian+"-"+yue+"-"+ri+"-"+shi+"-"+fen+"-"+miao;
//                System.out.println(nian+"年"+yue+"月"+ri+"日"+shi+"时"+fen+"分"+miao+"秒");
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            try {//如果本身就是-号形式的格式化
                if(time.matches("(.+)-(.*)")){
                    if(time.matches("(.+) (.*)")){
                        String[] headresultarray = time.split(" ");
                        String headresult = "";
                        if (headresultarray.length < 1) {
                            headresult = time;
                        } else {
                            if (time.matches("(.+) (.*)")) {
                                headresult = time.split(" ")[0];
                            } else {
                                time = time + " 00:00:00";
                                headresult = time.split(" ")[0];
                            }

                        }

                        String bodyresult = "";
                        String body = time.split(" ")[1];
                        String[] bodysplit = new String[3];
                        String[] bodysplit2 = body.split(":");
                        for (int i = 0; i < bodysplit2.length; i++) {
                            String tmp = body.split(":")[i].trim();
                            if (tmp == null || tmp.equals("") || tmp.equals("null")) {
                                bodysplit[i] = "00";
                            } else {
                                bodysplit[i] = tmp;
                            }

                        }
                        for (int i = 0; i < bodysplit.length; i++) {
                            bodyresult = bodyresult
                                    + (bodysplit[i] != null ? bodysplit[i] : "00")
                                    + "-";
                        }
                        if (bodyresult != null && bodyresult.length() > 0) {
                            bodyresult = bodyresult.substring(0,
                                    bodyresult.length() - 1);
                        }
                        resulttime = headresult + "-" + bodyresult;
                    }else{
                        String[] newtime=time.split("-");
                        String[] resultarray=new String[6];
                        for (int i = 0; i <resultarray.length ; i++) {
                            if(newtime.length>i){
                                resultarray[i]=newtime[i];
                            }else{
                                resultarray[i]="00";
                            }
                            resulttime=resulttime+resultarray[i]+"-";
                        }

                        resulttime=resulttime.substring(0,resulttime.length()-1);
                    }

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return resulttime;
    }

}
