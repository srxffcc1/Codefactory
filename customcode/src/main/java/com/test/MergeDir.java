package com.test;

import com.codefactory.intface.CallBack;
import com.codefactory.utils.Util_File;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/17.
 */
public class MergeDir {
    public static void main(String[] args) {
//        System.out.println(File.separator);
        final String oldparent = "D:" + File.separator + "Apk_Need" + File.separator + "WPSOffice_197" + File.separator + "sdd";
        Util_File.getFiles("D:" + File.separator + "Apk_Need" + File.separator + "WPSOffice_197" + File.separator + "sdd", "", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String fileoldname = file.getAbsolutePath();
                Pattern pattern = Pattern.compile(".*\\\\(smali_.*?)\\\\.*");
                Matcher matcher = pattern.matcher(fileoldname);
                String newfilename = "";
                if (matcher.find()) {
//                    String ss=matcher.group(1);
//                    System.out.println(ss);
                    newfilename = fileoldname.replace(matcher.group(1), "smali_all").replace(oldparent, "D:\\Apk_Need\\WPSOffice_197");
                }
                System.out.println(newfilename);
                new File(newfilename).getParentFile().mkdirs();
                file.renameTo(new File(newfilename));
            }
        });
    }
}
