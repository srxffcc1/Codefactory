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

    public List<LineMenu> getNodelist() {
        return nodelist;
    }
    public String[] getListFunction(String liststring){
        String[] result=null;
        if(liststring.contains("List")){
            Pattern pattern=Pattern.compile(".*List:(.*);.*?");
            Matcher matcher=pattern.matcher(liststring);
            if(matcher.find()){
                String[] split=matcher.group(1).split(":");
                for (int i = 0; i <split.length ; i++) {
                    if(split[i].contains("FUNCTION")){
                        result=split[i].replace("FUNCTION=","").split(",");
                    }
                }
            }
        }
        return result;
    }
    public String[] getListShow(String liststring){
        String[] result=null;
        if(liststring.contains("List")){
            Pattern pattern=Pattern.compile(".*List:(.*);.*?");
            Matcher matcher=pattern.matcher(liststring);
            if(matcher.find()){
                String[] split=matcher.group(1).split(":");
                for (int i = 0; i <split.length ; i++) {
                    if(split[i].contains("SHOW")){
                        result=split[i].replace("SHOW=","").split(",");
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
                    Pattern pattern=Pattern.compile(".*url=(.*);.*?");
                    Matcher matcher=pattern.matcher(annotationstring);
                    if(matcher.find()){
                        String[] urls=matcher.group(1).split(":");
                        for (int i = 0; i <urls.length ; i++) {
                            if(urls[i].contains("codekey")){
                                codekey=urls[i].split("=")[1];
                            }
                        }
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
                    Pattern pattern=Pattern.compile(".*url=(.*);.*?");
                    Matcher matcher=pattern.matcher(annotationstring);
                    if(matcher.find()){
                        String[] urls=matcher.group(1).split(":");
                        for (int i = 0; i <urls.length ; i++) {
                            if(urls[i].contains("namekey")){
                                namekey=urls[i].split("=")[1];
                            }
                        }
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
    public String getUrl() {
        if(annotationstring !=null){
            if(annotationstring.contains("url=")){
                Pattern pattern=Pattern.compile(".*url=(.*);.*?");
                Matcher matcher=pattern.matcher(annotationstring);
                if(matcher.find()){
                    url=matcher.group(1).split(":")[0];
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
        if(annotationstring !=null){
            if(annotationstring.contains("Spinner")){

                menutype="Spinner";
            }
            else if(annotationstring.contains("TextView")){

                menutype="TextView";
            }
            else{

                menutype="EditText";
            }
        }
        return menutype;
    }

    public String[] getStringarray() {
        if(annotationstring !=null){
            if(annotationstring.contains("string=")){
                Pattern pattern=Pattern.compile(".*string=(.*);.*?");
                Matcher matcher=pattern.matcher(annotationstring);
                if(matcher.find()){
                    stringarray=matcher.group(1).split(",");
                }

            }
        }
        return stringarray;
    }



    public LineMenu(String chinesstring, String idstring) {
        this.annotationstring = chinesstring;
        this.fieldname = idstring;
    }

}
