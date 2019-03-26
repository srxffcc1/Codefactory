package utils;

import com.ay.framework.annotation.ChineseName;
import com.codefactory.utils.Util_File;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop_Wash {
    public static void main(String[] args) {
        String javaorg = Util_File.inputStream2String("D:\\AppAy3.0\\Pdf\\customcode\\src\\main\\java\\com\\test\\bean\\SpecialPlan.java");


        String result = washBeanString(javaorg);
        System.out.println(result);
    }

    public static String washBeanString(String javaorg) {

        String result = "";
        javaorg = javaorg.replace("import com.baomidou.mybatisplus.annotations.TableName;", "import com.ay.framework.annotation.ChineseName;");
        javaorg = javaorg.replace("public static final long serialVersionUID = 1L;", "")
                .replace("private static final long serialVersionUID = 1L;", "")
                .replace("import com.baomidou.mybatisplus.annotations.TableId;", "")
                .replace("import dc.platform.admin.common.utils.UtilValidate;", "");
        //替换*号注释为ChineseName注释
        Pattern pattern = Pattern.compile("/\\*[\\s\\S]*?\\*/");
        Matcher matcher = pattern.matcher(javaorg);
        while (matcher.find()) {
            String needr = matcher.group(0);
//            System.out.println(needr);
            String resultr = needr
                    .replace("*", "")
                    .replace("/", "")
                    .trim().split("\n")[0];
            javaorg = javaorg.replace(needr, "@ChineseName(\"" + resultr.trim() + "\")");


        }
        //替换private为public
        pattern = Pattern.compile(".*private .*((?!(class|List|String)).)* ");
        matcher = pattern.matcher(javaorg);
        while (matcher.find()) {
            String needr = matcher.group(0);
//            System.out.println(Util_String.washString(needr));
//
//            System.out.println("-----------------------");
            if(!needr.contains("static")){

                javaorg = javaorg.replace(needr, "public String ");
            }

        }
        //对ChineseName清理
        pattern = Pattern.compile("@ChineseName\\((.*)\\)");
        matcher = pattern.matcher(javaorg);
        while (matcher.find()) {
            String needr = matcher.group(0);
            String needr2 = matcher.group(1);
//            System.out.println(Util_String.washString(needr));

            javaorg = javaorg.replaceFirst(Util_String.washString(needr), "@ChineseName(\"" + needr2.replace("\"", "").replace("(", "").replace(")", "").trim() + "\")");

        }
        //替换注释为ChineseName
        String[] javaorgarray = javaorg.split("\n");
        List<String> allwashstring = new ArrayList<>();
        for (int i = 0; i < javaorgarray.length; i++) {
            if (javaorgarray[i].trim().equals("") || javaorgarray[i].trim().matches("(.*)TODO(.*)") || javaorgarray[i].trim().matches("(.*)Override(.*)")) {

            } else {

                allwashstring.add(javaorgarray[i].trim());
            }

        }
        for (int i = 0; i < allwashstring.size(); i++) {
            String tmp = allwashstring.get(i);
            if (i != 0) {
                if (tmp.contains("//")) {
                    if (!allwashstring.get(i - 1).contains("@ChineseName")) {
                        String[] head2end = tmp.split("//");
                        String head = "";
                        String end = "";
                        if (head2end.length > 1) {
                            head = head2end[1];
                            end = head2end[0];
                            tmp = "@ChineseName(\"" + head + "\")\n" + end;
                        }
                    } else {
                        String[] head2end = tmp.split("//");
                        String head = "";
                        String end = "";
                        if (head2end.length > 1) {
                            head = head2end[1];
                            end = head2end[0];
                            tmp = end;
                        }
                    }
                }
            }

            if (tmp.trim().equals("")) {

            } else {
                result = result + tmp + "\n";
            }
        }
        result = result.replace("//", "");
        // 增加重复注释清理
        allwashstring.clear();
        javaorgarray = result.split("\n");
        result="";
        for (int i = 0; i < javaorgarray.length; i++) {
            if (javaorgarray[i].trim().equals("") || javaorgarray[i].trim().matches("(.*)TODO(.*)") || javaorgarray[i].trim().matches("(.*)Override(.*)")) {

            } else {

                allwashstring.add(javaorgarray[i].trim());
            }

        }
        for (int i = 0; i < allwashstring.size(); i++) {
            String tmp = allwashstring.get(i);
            if (i != 0) {
                if (allwashstring.get(i - 1).contains("@ChineseName") && allwashstring.get(i).contains("@ChineseName")) {
                    tmp = "";
                }
            }
            if (tmp.trim().equals("")) {

            } else {
                result = result + tmp + "\n";
            }
        }
        result = result.replace("//", "");
        return result;
    }
}
