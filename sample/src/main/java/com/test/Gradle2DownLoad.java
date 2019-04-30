package com.test;

import utils.Util_Http;

public class Gradle2DownLoad {
    public static void main(String[] args) {
        String gradle="compile 'org.xutils:xutils:3.3.36'";
        String[] gradles=gradle.replace("compile","").replace("'","").trim().split(":");
        String head="https://jcenter.bintray.com/"+gradles[0].replace(".","/")+"/"+gradles[1]+"/"+gradles[2].split("@")[0]+"/";
        System.out.println(head);
//        System.out.println(Util_Http.sendGet(head,null));
    }
}
