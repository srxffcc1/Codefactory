package utils;

import com.ay.framework.annotation.ChineseName;
import com.codefactory.utils.Util_File;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop_Wash {
    public static void main(String[] args) {
        String javaorg = Util_File.inputStream2String("D:\\App\\entity\\entitywrite\\WritAdministrativeDiscussEntity.java");


        String result = washBeanString(javaorg);
        System.out.println(result);
    }

    public static String washBeanString(String javaorg) {
        javaorg=javaorg.replace("import com.baomidou.mybatisplus.annotations.TableName;","import com.ay.framework.annotation.ChineseName;");
        javaorg=javaorg.replace("public static final long serialVersionUID = 1L;","").replace("import com.baomidou.mybatisplus.annotations.TableId;","").replace("import dc.platform.admin.common.utils.UtilValidate;","");

        Pattern pattern=Pattern.compile("/\\*[\\s\\S]*?\\*/");
        Matcher matcher=pattern.matcher(javaorg);
        while (matcher.find()){
            String needr=matcher.group(0);
//            System.out.println(Util_String.washString(needr));
            String resultr=needr
                    .replace("*","")
                    .replace("/","")
                    .trim().split("\n")[0];
//            System.out.println(resultr.trim());
            javaorg=javaorg.replaceFirst(Util_String.washString(needr),"@ChineseName(\""+resultr.trim()+"\")");

        }
         pattern=Pattern.compile("@ChineseName((?!public)[\\s\\S])*@ChineseName.*");
         matcher=pattern.matcher(javaorg);
        while (matcher.find()){
            String needr=matcher.group(0);
//            System.out.println(Util_String.washString(needr));

            javaorg=javaorg.replaceFirst(Util_String.washString(needr),"");

        }
        pattern=Pattern.compile("public ((?!(class|List|String)).)* ");
        matcher=pattern.matcher(javaorg);
        while (matcher.find()){
            String needr=matcher.group(0);
//            System.out.println(Util_String.washString(needr));

            javaorg=javaorg.replaceFirst(Util_String.washString(needr),"public String ");

        }
        pattern=Pattern.compile("@ChineseName\\((.*)\\)");
        matcher=pattern.matcher(javaorg);
        while (matcher.find()){
            String needr=matcher.group(0);
            String needr2=matcher.group(1);
//            System.out.println(Util_String.washString(needr));

            javaorg=javaorg.replaceFirst(Util_String.washString(needr),"@ChineseName(\""+needr2.replace("\"","").replace("(","").replace(")","").trim()+"\")");

        }
        String[] javaorgarray = javaorg.split("\n");
        List<String> allwashstring=new ArrayList<>();
        for (int i = 0; i < javaorgarray.length; i++) {
            if (javaorgarray[i].trim().equals("") || javaorgarray[i].trim().matches("(.*)TODO(.*)") || javaorgarray[i].trim().matches("(.*)Override(.*)")) {

            } else {
//                System.out.println("+\"" + javaorgarray[i].trim().replace("\"", "\\\"") + "\\n\"");
//                System.out.println(javaorgarray[i].trim().replace("\"", "\\\""));
                allwashstring.add(javaorgarray[i].trim());
            }

        }
        String result="";
        for (int i = 0; i <allwashstring.size() ; i++) {
            String tmp=allwashstring.get(i);
            if(tmp.contains("//")){
                if(i!=0){
                    if(!allwashstring.get(i-1).contains("@ChineseName")){
                        String[] head2end=tmp.split("//");
                        String head="";
                        String end="";
                        if(head2end.length>1){
                            head=head2end[1];
                            end=head2end[0];
                            tmp="@ChineseName(\""+head+"\")\n"+end;
                        }else{

                        }
                    }else{
                        String[] head2end=tmp.split("//");
                        String head="";
                        String end="";
                        if(head2end.length>1){
                            head=head2end[1];
                            end=head2end[0];
                            tmp=end;
                        }else{

                        }
                    }

                }

            }
            if (tmp.trim().equals("")) {

            }else{
                result=result+tmp+"\n";
            }
        }
        result=result.replace("//","");
        return result;
    }
}
