package utils.bean;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineMenu {
    public String annotationstring;
    public String fieldname;
    public String codekey;
    public String namekey;
    public List<LineMenu> nodelist;

    public LineMenu() {
    }

    public static void main(String[] args) {
        String[] array=null;
        String org="隐患大类;Spinner:string=基础管理,现场管理:code=1402450901716,1402450932605;";
                    if(org.contains("string=")){
                Pattern pattern=Pattern.compile(".*string=(.*?)[:;]");
                Matcher matcher=pattern.matcher(org);
                if(matcher.find()){
                    array=matcher.group(1).split(",");
                }

            }
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }

    }

    public List<LineMenu> getNodelist() {
        return nodelist;
    }
    public String[] getListFunction(String liststring){
        String[] result=null;
        if(liststring.contains("List")){
            Pattern pattern=Pattern.compile(".*FUNCTION=(.*?)[:;]");
            Matcher matcher=pattern.matcher(liststring);
            if(matcher.find()){
                result=matcher.group(1).split(",");
            }
//            Pattern pattern=Pattern.compile(".*List:(.*);.*?");
//            Matcher matcher=pattern.matcher(liststring);
//            if(matcher.find()){
//                String[] split=matcher.group(1).split(":");
//                for (int i = 0; i <split.length ; i++) {
//                    if(split[i].contains("FUNCTION")){
//                        result=split[i].replace("FUNCTION=","").split(",");
//                    }
//                }
//            }
        }
        return result;
    }
    public String findAnnotionstring(List<LineMenu> lineMenus,String fieldname){
        for (int i = 0; i <lineMenus.size() ; i++) {
            if(fieldname.equals(lineMenus.get(i).getFieldname())){
                return lineMenus.get(i).getFirstannotionstring().trim().split(";|:|：| ")[0] + ":";
            }
        }
        return fieldname;
    }
    public String[] getListShow(String liststring){
        String[] result=null;
        if(liststring.contains("List")){
//            Pattern pattern=Pattern.compile(".*List:(.*?);.*?");
//            Matcher matcher=pattern.matcher(liststring);


            Pattern pattern=Pattern.compile(".*SHOW=(.*?)[:;]");
            Matcher matcher=pattern.matcher(liststring);
            if(matcher.find()){
                result=matcher.group(1).split(",");
            }
//            if(matcher.find()){
//                String[] split=matcher.group(1).split(":");
//                for (int i = 0; i <split.length ; i++) {
//                    if(split[i].contains("SHOW")){
//                        result=split[i].replace("SHOW=","").split(",");
//                    }
//                }
//            }
        }
        return result;
    }
    public boolean isNeedRollbackShow(String liststring){
        boolean result=false;
        if(liststring.contains("Detail")){
            Pattern pattern=Pattern.compile(".*Detail:(.*?);.*?");
            Matcher matcher=pattern.matcher(liststring);
            if(matcher.find()){
                String[] split=matcher.group(1).split(":");
                for (int i = 0; i <split.length ; i++) {
                    if(split[i].contains("PartShow")){
                        result=true;
                    }
                }
            }
        }
        return result;
    }

    public void setNodelist(List<LineMenu> nodelist) {
        this.nodelist = nodelist;
    }

    public String getFirstannotionstring() {
        return annotationstring.split(";")[0];
    }

    public String getCodekey() {
        if("Spinner".equals(getMenutype())){
            if(annotationstring !=null){
                if(annotationstring.contains("url=")){
//                    Pattern pattern=Pattern.compile(".*url=(.*?);.*?");
//                    Matcher matcher=pattern.matcher(annotationstring);
//                    if(matcher.find()){
//                        String[] urls=matcher.group(1).split(":");
//                        for (int i = 0; i <urls.length ; i++) {
//                            if(urls[i].contains("codekey")){
//                                codekey=urls[i].split("=")[1];
//                            }
//                        }
//                    }
                    Pattern pattern=Pattern.compile(".*codekey=(.*?)[:;]");
                    Matcher matcher=pattern.matcher(annotationstring);
                    if(matcher.find()){
                        codekey=matcher.group(1);
                    }

                }
            }
        }
        return codekey;
    }

    public String getNamekey() {
        if("Spinner".equals(getMenutype())){
            if(annotationstring !=null){
                if(annotationstring.contains("url=")){
//                    Pattern pattern=Pattern.compile(".*url=(.*?);.*?");
//                    Matcher matcher=pattern.matcher(annotationstring);
//                    if(matcher.find()){
//                        String[] urls=matcher.group(1).split(":");
//                        for (int i = 0; i <urls.length ; i++) {
//                            if(urls[i].contains("namekey")){
//                                namekey=urls[i].split("=")[1];
//                            }
//                        }
//                    }
                    Pattern pattern=Pattern.compile(".*namekey=(.*?)[:;]");
                    Matcher matcher=pattern.matcher(annotationstring);
                    if(matcher.find()){
                        namekey=matcher.group(1);
                    }

                }
            }
        }
        return namekey;
    }

    public String getAnnotationstring() {
        return annotationstring;
    }

    public String getFieldname() {
        return fieldname;
    }

    public String url;
    public boolean ismustinsert;
    public String menutype;//Spinner Text Edit
    public String[] stringarray;
    public String[] codearray;
    public String getUrl() {
        if(annotationstring !=null){
            if(annotationstring.contains("url=")){
                Pattern pattern=Pattern.compile(".*url=(.*?)[:;]");
                Matcher matcher=pattern.matcher(annotationstring);
                if(matcher.find()){
                    url=matcher.group(1);
                }

            }
        }
        return url;
    }

    public boolean isIsmustinsert() {
        if(annotationstring !=null){
            if(annotationstring.contains("Must")){

                ismustinsert=true;
            }else{
                ismustinsert=false;
            }
        }
        return ismustinsert;
    }

    public String getMenutype() {
        menutype="String";
        if(!"".equals(annotationstring)){
            if(annotationstring.contains("Spinner")){

                menutype="Spinner";
            }
            else if(annotationstring.contains("TextView")){

                menutype="TextView";
            } else{

                menutype="EditText";
            }
        }
        return menutype;
    }

    public String[] getStringarray() {
        if(annotationstring !=null){
            if(annotationstring.contains("string=")){
                Pattern pattern=Pattern.compile(".*string=(.*?)[:;]");
                Matcher matcher=pattern.matcher(annotationstring);
                if(matcher.find()){
                    stringarray=matcher.group(1).split(",");
                }
//                Pattern pattern=Pattern.compile(".*string=(.*?);.*?");
//                Matcher matcher=pattern.matcher(annotationstring);
//                if(matcher.find()){
//                    String stringarrays=matcher.group(1).split(":")[0];
//                    stringarray=stringarrays.split(",");
//                }

            }
        }
//        if("Spinner".equals(getMenutype())){
//            if(annotationstring !=null){
//                if(annotationstring.contains("string=")){
//                    Pattern pattern=Pattern.compile(".*string=(.*);.*?");
//                    Matcher matcher=pattern.matcher(annotationstring);
//                    if(matcher.find()){
//                        String[] urls=matcher.group(1).split(":");
//                        for (int i = 0; i <urls.length ; i++) {
//                            if(urls[i].contains("string=")){
//                                String stringarrays=urls[i].split("=")[1];
//                                stringarray=stringarrays.split(",");
//                            }
//                        }
//                    }
//
//                }
//            }
//        }



//        if(annotationstring !=null){
//            if(annotationstring.contains("string=")){
//                Pattern pattern=Pattern.compile(".*string=(.*)?[:|;]");
//                Matcher matcher=pattern.matcher(annotationstring);
//                if(matcher.find()){
//                    stringarray=matcher.group(1).split(",");
//                }
//
//            }
//        }
        return stringarray;
    }
    public String[] getCodearray() {
        if("Spinner".equals(getMenutype())){
            if(annotationstring !=null){
                if(annotationstring.contains("string=")){
//                    Pattern pattern=Pattern.compile(".*string=(.*?);.*?");
//                    Matcher matcher=pattern.matcher(annotationstring);
//                    if(matcher.find()){
//                        String[] urls=matcher.group(1).split(":");
//                        for (int i = 0; i <urls.length ; i++) {
//                            if(urls[i].contains("code=")){
//                                String codearrays=urls[i].split("=")[1];
//                                codearray=codearrays.split(",");
//                            }
//                        }
//                    }
                    Pattern pattern=Pattern.compile(".*code=(.*?)[:;]");
                    Matcher matcher=pattern.matcher(annotationstring);
                    if(matcher.find()){
                        codearray=matcher.group(1).split(",");
                    }

                }
            }
        }
//        if(annotationstring !=null){
//            if(annotationstring.contains("code=")){
//                Pattern pattern=Pattern.compile(".*code=(.*)?[:|;]");
//                Matcher matcher=pattern.matcher(annotationstring);
//                if(matcher.find()){
//                    codearray=matcher.group(1).split(",");
//                }
//
//            }
//        }
        return codearray;
    }



    public LineMenu(String chinesstring, String idstring) {
        this.annotationstring = chinesstring;
        this.fieldname = idstring;
    }

}
