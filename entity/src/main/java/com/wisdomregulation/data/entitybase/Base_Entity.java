package com.wisdomregulation.data.entitybase;

import com.github.promeg.pinyinhelper.Pinyin;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Base_Entity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected List<String> fieldnamelsit = new ArrayList<String>();//字段list
    protected Map<String, String> fieldvaluemap = new HashMap<String, String>();//字段和字值得map
    protected List<String> fieldnamelsitchinese = new ArrayList<String>();//字段中文名对应字值得map
    protected Map<String,Object> exobjmap=new HashMap<String,Object>();//可能是附加的签名文件 可能是对象可能是路劲
    public int tmpkey = -1;//记录特殊push得key
    public int pullkey = 0;//当前pulll类似于put
    public int pushkey = 0;//当前push位置 push有返回值
    private Object extraImage;//额外的附件
    private Object extraSign;//额外的签名
    private Object extraObj;//额外的对象
    private Object extraSeal;//额外的盖章
    private boolean isneedaddlist=false;
    public Object getExtraSeal() {
        return extraSeal;
    }

    /**
     * 盖章 复数传数组
     * @param extraSeal
     * @return
     */
    public Base_Entity setExtraSeal(Object extraSeal) {
        this.extraSeal = extraSeal;
        return this;
    }

    public Base_Entity putexvalue(String key,Object value){
        exobjmap.put(key,value);
        return this;
    }
    public Object getexvalue(String key){
        return exobjmap.get(key);
    }


    public Object getExtraImage() {
        return extraImage;
    }

    /**
     * 附件 复数传数组
     * @param extraImage
     * @return
     */
    public Base_Entity setExtraImage(Object extraImage) {
        this.extraImage = extraImage;
        return this;
    }

    public Object getExtraSign() {
        return extraSign;
    }
    /**
     * 签名 复数传数组
     * @param extraSign
     * @return
     */
    public Base_Entity setExtraSign(Object extraSign) {
        this.extraSign = extraSign;
        return this;
    }

    public Object getExtraObj() {
        return extraObj;
    }

    /**
     * 额外对象 复数传数组
     * @param extraObj
     * @return
     */
    public Base_Entity setExtraObj(Object extraObj) {
        this.extraObj = extraObj;
        return this;
    }

    public Base_Entity setIsneedaddlist(boolean isneedaddlist) {
        this.isneedaddlist = isneedaddlist;
        return this;
    }

    private List<EntityCallback> callbackList=new ArrayList<EntityCallback>();//作用回调
    public Base_Entity() {

    }
    public void resetKey(){
        resetPullKey();
        resetPushKey();
    }
    public void resetPushKey(){
        pushkey=0;
    }
    public void resetPullKey(){
        pullkey=0;
    }
    /**
     * 返回附加对象
     * @return
     */


    public int getPullkey() {
        return pullkey;
    }

    public int getPushkey() {
        return pushkey;
    }



    /**
     * 子类数据形对象必须调用的方法为了配置一些参数
     *
     * @param fieldnamelsitchinese
     * @param fieldvaluemap
     */
    public void initsuper(List<String> fieldnamelsitchinese, Map<String, String> fieldvaluemap) {
        this.fieldnamelsitchinese = fieldnamelsitchinese;
        this.fieldnamelsitchinese.add("续页");//再末尾增加通常的续页
        this.fieldvaluemap = fieldvaluemap;
        boolean neederr = false;
        for (int i = 0; i < fieldnamelsitchinese.size(); i++) {
            callbackList.add(null);
            if (isInList(chinese2pinyin(fieldnamelsitchinese.get(i)))) {
                neederr = true;
                //System.out.println(getClass().getSimpleName() + ":list有重复:" + fieldnamelsitchinese.get(i));
            }
            fieldnamelsit.add(chinese2pinyin(fieldnamelsitchinese.get(i)));
        }
        if (neederr) {
            //System.out.println("----------------------------------------");
        }
        init();
    }
    public Base_Entity setListeners(List<EntityCallback> callbackList){
        this.callbackList=callbackList;
        return this;
    }
    public Base_Entity setListener(int index, EntityCallback callback){
        callbackList.set(index,callback);
        return this;
    }
    public EntityCallback getListener(int index){
        if(index<fieldnamelsit.size()){

            return callbackList.get(index);
        }
        return new EntityCallback() {
            @Override
            public void back(Object obj) {

            }
        };
    }
    /**
     * 按照index返回字段
     * @param index
     * @return
     */
    public String getField(int index) {
        return fieldnamelsit.get(index);
    }

    /**
     * 按照index返回中文字段
     * @param index
     * @return
     */
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
//            e.printStackTrace();
        }
        if (searchkeyint != -1 && searchkeyint < fieldvaluemap.size()) {
            return getValue(searchkeyint);
        }
        searchkey = chinese2pinyin(searchkey);
        if (searchkey.equals("") || searchkey == null) {
            return "";
        }
        String result = fieldvaluemap.get(searchkey);
        if (result == null || result.equals("") || result.equals("null")) {
            result = "";
        }
        if (result.matches("\\s(.+)")) {
            result = result.substring(1, result.length());
        }
        return result;
    }

    public String getValue(int index) {
        if (index > fieldnamelsit.size() - 1) {
            if (canaddlist()||isneedaddlist) {
                String result = fieldvaluemap.get("demo:" + index);
                return result;
            } else {
                return "";
            }

        }
        String result = fieldvaluemap.get(fieldnamelsit.get(index));
        if (result == null || result.equals("") || result.equals("null")) {
            result = "";
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

    public Base_Entity clear() {
        fieldvaluemap.clear();
        return this;
    }

    /**
     * 按顺序push出东西
     *
     * @return
     */
    public String push(int key) {
        //System.out.println("pushkey:"+pushkey);
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
    public String push(boolean unlock) {
        //System.out.println("pushkey:"+pushkey);
        ////System.out.println("pushkey204:"+pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            //System.out.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
            return "";
        }
        if (!unlock) {
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
        //System.out.println("pushkey:"+pushkey);
        ////System.out.println("pushkey220:"+pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            //System.out.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
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
    public String justpushnoreturn() {
        //System.out.println("pushkey:"+pushkey);
        ////System.out.println("pushkey242:"+pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            //System.out.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
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
     * 强制loop 锁定key
     * @return
     */
    public String pushloop() {

        //System.out.println("pushkey:"+pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            //System.out.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
            return "";
        }
        if (tmpkey != -1) {//说明进行了特殊push
            if (tmpkey > fieldnamelsit.size() - 1) {
                return "";
            }
            pushkey = tmpkey;
            tmpkey = -1;//还原为-1
        }

        pushkey--;//对pushkey进行锁住 使得不能前进 比如进来时1 --之后就是0 但是因为取还是要取1所有先加最后出去还是pushkey还是1
        return getValue(++pushkey);

    }
    /**
     * 按顺序push出东西
     *
     * @return
     */
    public String pushneedcheck() {

        //System.out.println("pushkey:"+pushkey);
        if (pushkey > fieldnamelsit.size() - 1) {
            //System.out.println("超出范围:" + getClass().getSimpleName() + ":" + pushkey);
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
            pushkey--;//对pushkey进行锁住 使得不能前进 比如进来时1 --之后就是0 但是因为取还是要取1所有先加最后出去还是pushkey还是1
            return getValue(++pushkey);
        } else {

        }
        return getValue(pushkey++);
    }

    public Base_Entity pull(String value) {
        if (pullkey > fieldnamelsit.size() - 1) {
            //System.out.println("超出范围:" + getClass().getSimpleName());
        } else {
            fieldvaluemap.put(fieldnamelsit.get(pullkey++), value);
        }


        return this;
    }
    public Base_Entity putAll(Map<String, String> map){
        fieldvaluemap.putAll(map);
        return this;
    }
    public Base_Entity put(String key, String value) {
        if (canaddlist()||isneedaddlist) {
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

    public Base_Entity nput(String key, String value) {
//        long old=System.currentTimeMillis();
        fieldvaluemap.put(chinese2pinyin(key), value.replaceAll("\n", "").replaceAll("\"", "“"));
//        //System.out.println("耗时：nput"+(System.currentTimeMillis()-old));
        return this;
    }

    public Base_Entity uput(String value, String key) {
//        long old=System.currentTimeMillis();
        fieldvaluemap.put(chinese2pinyin(key).replaceAll("\n", "").replaceAll("\"", "“"), value);
//        //System.out.println("耗时：uput"+(System.currentTimeMillis()-old));
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

    public Base_Entity copy() throws CloneNotSupportedException {
        Base_Entity result = null;
        try {
            result = (Base_Entity) Class.forName(this.getClass().getName()).newInstance();
            result.putAll(fieldvaluemap);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 一个可扩展的方法 前提是扩展锁打开
     *
     * @param key
     * @param value
     * @return
     */
    public Base_Entity add(String key, String value) {
        if (canaddlist()||isneedaddlist) {
            fieldnamelsitchinese.add(key);
            callbackList.add(null);
            fieldnamelsit.add(chinese2pinyin(key));
            fieldvaluemap.put(chinese2pinyin(key), value);
        }

        return this;
    }

    /**
     * put键值对
     * @param index
     * @param value
     * @return
     */
    public Base_Entity put(int index, String value) {
        if (index > size() - 1) {//下面得方法待验证
            //System.out.println("超出范围:" + getClass().getSimpleName());
            if (canaddlist()||isneedaddlist) {
                if(!isInList("demo:" + index)){
                    fieldnamelsitchinese.add("demo:" + index);
                    callbackList.add(null);
                }
                fieldvaluemap.put("demo:" + index, value);
            }
        } else {
            fieldvaluemap.put(fieldnamelsit.get(index), value);
        }

        return this;
    }

    /**
     * 中文转拼音
     *
     * @param chinesestr
     * @return
     */
    protected String chinese2pinyin(String chinesestr) {
//        long old = System.currentTimeMillis();
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
        targetchinese=targetchinese.toLowerCase();
        return targetchinese;
    }

    public boolean isempty() {
        return fieldvaluemap.size() == 0 ? true : false;
    }

    /**
     * 初始化字段 一般可以不用
     *
     * @return
     */
    public Base_Entity init() {
        init("");
        return this;
    }

    /**
     * 特定key初始化 用于多条件匹配
     *
     * @param
     * @return
     */
    public Base_Entity init(String key) {
        fieldvaluemap.clear();
        for (int i = 0; i < fieldnamelsit.size(); i++) {
            fieldvaluemap.put(fieldnamelsit.get(i), key);

        }
        return this;
    }

    /**
     * 打印自己的方法 可以重写此方法
     *
     * @return
     */

    public Base_Entity printSelf() {
        return this;
    }


    /**
     * 格式化字符串成时间字符串 用-号隔开
     *
     * @param time 时间字符串
     * @return
     */
    public static String getTime(String time) {//格式化任意时间格式yyyy-MM-dd-HH-mm-ss
        String resulttime = "";
        if (time == null || time.equals("")) {//如果为空
            //System.out.println("时间为空:" + time);
            resulttime = "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            try {//尝试用long来解析字符串
                long longs = Long.parseLong(time);
                Date date = new Date();
                date.setTime(longs);
                resulttime = sdf.format(date).toString();
            } catch (NumberFormatException e) {
//            e.printStackTrace();
            }
            try {//尝试用年月日时分秒中文来匹配
                if (time.matches("(.*年.*)|(.*月.*)|(.*日.*)|(.*时.*)|(.*分.*)|(.*秒.*)")) {
                    char[] timearray = time.toCharArray();
                    String nian = "";
                    String yue = "";
                    String ri = "";
                    String shi = "";
                    String fen = "";
                    String miao = "";
                    int start = 0;
                    int end = 0;
                    for (int i = 0; i < timearray.length; i++) {
                        if (Character.isDigit(timearray[i])) {

                        } else {
                            end = i;
                            try {
                                if (timearray[i] == '年') {
                                    nian = time.substring(start, end);
                                }
                                if (timearray[i] == '月') {
                                    yue = time.substring(start, end);

                                }
                                if (timearray[i] == '日') {
                                    ri = time.substring(start, end);

                                }
                                if (timearray[i] == '时') {
                                    shi = time.substring(start, end);

                                }
                                if (timearray[i] == '分') {
                                    fen = time.substring(start, end);

                                }
                                if (timearray[i] == '秒') {
                                    miao = time.substring(start, end);

                                }
                            } catch (Exception e) {
                                //System.out.println("start:" + start + ",end:" + end);
                                e.printStackTrace();
                            }
                            start = i + 1;
                        }
                    }
                    resulttime = nian + "-" + yue + "-" + ri + "-" + shi + "-" + fen + "-" + miao;
//                //System.out.println(nian+"年"+yue+"月"+ri+"日"+shi+"时"+fen+"分"+miao+"秒");
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            try {//如果本身就是-号形式的格式化
                if (time.matches("(.+)-(.*)")) {
                    if (time.matches("(.+) (.*)")) {
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
                    } else {
                        String[] newtime = time.split("-");
                        String[] resultarray = new String[6];
                        for (int i = 0; i < resultarray.length; i++) {
                            if (newtime.length > i) {
                                resultarray[i] = newtime[i];
                            } else {
                                resultarray[i] = "00";
                            }
                            resulttime = resulttime + resultarray[i] + "-";
                        }

                        resulttime = resulttime.substring(0, resulttime.length() - 1);
                    }

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return resulttime;
    }

}
