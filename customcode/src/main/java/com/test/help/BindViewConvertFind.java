package com.test.help;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by King6rf on 2017/6/5.
 */
public class BindViewConvertFind {
    public static void main(String[] args) {
        String idneedconverts="\t@BindView(id=R.id.newtitle)\n" +
                "\tprivate TextView newtitle;\n" +
                "\t@BindView(id=R.id.libraryList)\n" +
                "\tprivate ListView libraryList;\n" +
                "\tprivate int level;\n" +
                "\tprivate Base_Entity searchtarget;\n" +
                "\tprivate BaseAdapter adapter;\n" +
                "\tprivate List<Base_Entity> baselist;\n" +
                "\tprivate boolean isall = true;\n" +
                "\t@BindView(id = R.id.targetsearch)\n" +
                "\tEditText targetsearch;";
        String[] idneedconvertsarray=idneedconverts.replace("BindView (","BindView(").replace("( id","(id").replace(" =","=").replace("public","").replace("private","").trim().split(";");
        for (int i = 0; i <idneedconvertsarray.length ; i++) {
            String idneedconvert=idneedconvertsarray[i];
            Pattern pattern=Pattern.compile("@BindView\\(id=([\\s\\S]*)\\)([\\s\\S]*)");
            Matcher matcher=pattern.matcher(idneedconvert);
            if(matcher.find()){
                System.out.println(matcher.group(2).trim().split(" ")[1]+"=("+matcher.group(2).trim().split(" ")[0]+")findViewById("+matcher.group(1).trim()+");");
            }
        }

    }
}
