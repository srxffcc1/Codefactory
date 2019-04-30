package com.test.help;

import cn.com.cjf.CJFBeanFactory;
import cn.com.cjf.ChineseJF;
import com.codefactory.abstracts.ParseBase;
import com.codefactory.intface.CallBack;
import com.codefactory.node.DatNode;
import com.codefactory.utils.Util_Dat;
import com.codefactory.utils.Util_File;
import com.codefactory.utils.Util_Node;
import com.codefactory.utils.Util_Translate;
import utils.Util_String;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TorchlightFactory {
    public static void main(String[] args) {
        String orgstring = Util_File.inputStream2String("D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\UNITS\\PLAYERS\\ARBITER\\HUM_ARBITER_BASE.DAT");
        ParseBase parent = new DatNode().build().parse(orgstring);
        System.out.println(parent.getEntityString());


//		String orgstring=Util_File.inputStream2String("D:\\New_Book\\Torchlight 2\\mods\\CRE2706\\MEDIA\\AFFIXES.txt");
//		ParseBase parent=new DatNode().build().parse(orgstring);
//		List<ParseBase> affixlist=parent.getNodeInThisLevel("AFFIX");
//		for (int i = 0; i <affixlist.size() ; i++) {
//			System.out.println(affixlist.get(i).getEntityString());
//		}
        washDir("D:\\Game\\Torchlight 2\\mods");

//		freshTranslate("TRANSLATION2.DAT");
//		removeDuplicate("TRANSLATION3.dat");
//		jt2ft();
//		String orgstring=Util_File.inputStream2String("BERSERKER_05_GLOVES.DAT");
//		ParseBase parent=new DatNode().link().parse(orgstring);
//		System.out.println(parent.getEntityString());
//		
//		
//		String orgstring2=Util_File.inputStream2String("activity_book_printeredit_list.xml");
//		ParseBase parent2=new XmlNode().link().parse(orgstring2);
//		System.out.println(parent2.getEntityString());
//		washjavafile();
//		String test="DeviceResult [sm=3, rs=[DeviceType [tid=1, nameZh=有线电视机顶盒, nameEn=stb], DeviceType [tid=2, nameZh=电视机, nameEn=tv], DeviceType [tid=7, nameZh=空调, nameEn=air]]]";
//		
//		Pattern p = Pattern.compile("DeviceType \\[tid=(.*?), nameZh=(.*?), nameEn=(.*?)\\]");
//		Matcher m = p.matcher(test);
//		while(m.find()){
//		System.out.println(m.group(1));
//		System.out.println(m.group(2));
//		System.out.println(m.group(3));
//		System.out.println("---------");
//		}
//		getEnglistTranslate("D:\\BundleWork2\\ZhiHuiAnJianTorchlight\\TRANSLATION.DAT");
//		addRarityProperty();
//----------------------------------------以上都不看-----------------------------------------------------		
//		randomItemsAffixesToEffects("MEDIA");//
//		getEnglistTranslate("TRANSLATION.DAT");
//		getTranslateOnWeb("English.dat");
//		removeAllNotUsedAffix("IMBA_V_5_11\\MEDIA", "IMBA_V_5_11\\MEDIA2");
//		removeDupAffix("IMBA_V_5_11\\MEDIA2");
//		removeSkillDependenceUnitPlayer("D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\UNITS","D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\SKILLS");
//		removeAllNotUsedAffix("D:\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\PEOPLEUSESKILLS", "D:\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\AFFIXES");

//		removeParticlesDependenceUnitSkillLayout("D:\\Torchlight 2\\mods\\IMBA_CLEAN2","D:\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\PEOPLEUSESKILLSLAYOUT","D:\\Torchlight 2\\mods\\IMBA_CLEAN2\\media\\PARTICLES");
//		removeModelsDependenceUnit("D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1","D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\UNITS\\MONSTERS","D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\MODELS\\MONSTERS");
//		removeSkillWrongUnitPlayer("D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media");
//		removeLayoutDependenceUnitSkill("D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1","D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\SKILLS","D:\\New_Book\\Torchlight 2\\mods\\IMBA_CLEAN1\\media\\SKILLS");
    }

    /**
     * 对物品进行属性转换
     * 需要目录结构如原版MEDIA 需要affixes.txt文档来寻址 对装备进行affix属性转成effect属性 使得装备可以有固有属性 然后随机
     * 2016 9 13 增加 新的随机
     *
     * @param mediapath
     */

    private static void randomItemsAffixesToEffects(final String mediapath) {
        washDir(mediapath);
        final String affixesraw = Util_File.inputStream2String(mediapath + "/AFFIXES.txt");
        Util_File.getFiles(mediapath + "/UNITS/", "((.*)\\.((?i)dat))", new CallBack() {
            @Override
            public void back(Object... object) {
                int length = object.length;
                File[] file = new File[length];
                for (int i = 0; i < file.length; i++) {
                    file[i] = (File) object[i];
                    String orgdatstring = Util_File.inputStream2String(file[i]);
                    ParseBase orgparent = new DatNode().build().parse(orgdatstring);
                    List<ParseBase> resultlist = orgparent.getNodeInThisLevel("AFFIXES");
                    for (int j = 0; j < resultlist.size(); j++) {
                        ParseBase parentaffixes = resultlist.get(i);
                        String willdeletehashcode = parentaffixes.getHashCode();
                        List<String> affixesname = parentaffixes.getPropertyValueInThisLevelNode("AFFIX");
                        for (int k = 0; k < affixesname.size(); k++) {
                            String willfindpathmatch = affixesname.get(k);
                            Pattern pathPattern = Pattern.compile("<STRING>Name:" + willfindpathmatch + "\r\n([\\s\\S]*?)<STRING>File:([\\s\\S]*?)\r\n");
                            Matcher mpathPattern = pathPattern.matcher(affixesraw);
                            while (mpathPattern.find()) {
                                String needfixaffix = mpathPattern.group(2);
                                String orgaffixstring = Util_File.inputStream2String(needfixaffix);
                                ParseBase parentaffix = new DatNode().build().parse(orgaffixstring);
                                List<ParseBase> listeffect = parentaffix.getNodeInThisLevel("EFFECT");
                                orgparent.removeNode("AFFIXES", willdeletehashcode);
                                for (int l = 0; l < listeffect.size(); l++) {
                                    orgparent.addNode(listeffect.get(l));
                                }
                                orgparent.addNode(new DatNode().setNodename("AFFIXES"));
                                String datnameorg = orgparent.getPropertyValueInThisLevelNode("NAME").get(0);
                                for (int l = 0; l < 50; l++) {
                                    Util_Dat.moveEffectHold(orgparent, 2);
                                    Util_Dat.setLevel(orgparent, l);
                                    Util_Dat.setNameArray(orgparent, datnameorg, l);
                                    Util_Dat.setRandomEffectBase(orgparent);
                                    Util_Dat.setRandomRarity(orgparent);
                                    Util_Dat.setRandomRequire(orgparent);
                                    Util_Dat.setRandomuid(orgparent);
                                    String indexname = orgparent.getPropertyValueInThisLevelNode("NAME").get(0);
                                    try {
                                        String resultwrite = orgparent.getEntityString();
                                        File writefile = new File(file[i].getParentFile().getAbsolutePath().replace(mediapath, mediapath + "4"), indexname + ".DAT");
                                        writefile.getParentFile().mkdirs();
                                        FileOutputStream os = new FileOutputStream(writefile);
                                        os.write(resultwrite.getBytes("UnicodeLittle"));
                                        os.close();
                                        System.out.println("写入文件完成:" + writefile.getAbsolutePath());
                                    } catch (Exception e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }

                }
            }
        });
        System.out.println("回调结束");
        System.exit(0);
    }

    /**
     * 删除BIN文件
     */
    private static void washDir(String needwash) {
        Util_File.deletelink(needwash, null);
        System.out.println("-----------清理完毕-------------");

    }


    /**
     * 简体转繁体
     */
	private static void jt2ft() {
		try {
			File source_jan_file=new File("TRANSLATION.DAT");

			String source_jan_file_charSet="UnicodeLittle";

			File target_fan_file=new File("TRANSLATIONF.DAT");

			String target_fan_file_charSet="UnicodeLittle";

			//获得繁体-简体转换器
			ChineseJF chinesdJF = CJFBeanFactory.getChineseJF();

			long useTime = chinesdJF.chineseJan2Fan(source_jan_file, source_jan_file_charSet, target_fan_file, target_fan_file_charSet);

			System.out.println("简体文件->繁体文件 ，用时：[ "+useTime+" ] ms");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * 获得需要翻译的条目
     *
     * @param path
     */
    private static void getEnglistTranslate(String path) {
        try {
            String str = Util_File.inputStream2String(path);
            FileOutputStream os = new FileOutputStream("English.dat");
            List<String> headlist = new ArrayList<String>();
            String needpring = "";
//		System.out.println(str);
            Pattern p = Pattern.compile("\t\t<STRING>ORIGINAL:(.*)\r\n(.*)<STRING>TRANSLATION:(.*)");
            Matcher m = p.matcher(str);

            while (m.find()) {
                String needreplace = m.group(0);
//				System.out.println(needreplace);
                if (m.group(1).equals(m.group(3))) {
                    needpring = "\t[TRANSLATION]\r\n\t\t<STRING>ORIGINAL:" + m.group(1) + "\r\n\t\t<STRING>TRANSLATION:" + m.group(3) + "\r\n\t[/TRANSLATION]\r\n" + needpring;
                } else {

                }
//				System.out.println(result);

            }
//			System.out.println(needpring);
            os.write(needpring.getBytes());
            os.close();
            System.out.println("-----------over-------------");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 对翻译文件的顺序进行整理
     *
     * @param path
     */
    private static void freshTranslate(String path) {
        try {
            String str = Util_File.inputStream2String(path);
            FileOutputStream os = new FileOutputStream("test.dat");
            List<String> headlist = new ArrayList<String>();

//		System.out.println(str);
            Pattern p = Pattern.compile("\t\t<STRING>TRANSLATION:(.*)\r\n(.*)<STRING>ORIGINAL:(.*)");
            Matcher m = p.matcher(str);

            while (m.find()) {
                String needreplace = m.group(0);
//				System.out.println(needreplace);
                String result = "\t\t<STRING>ORIGINAL:" + m.group(3) + "\r\n\t\t<STRING>TRANSLATION:" + m.group(1) + "";
//				System.out.println(result);
                str = str.replaceAll(needreplace, result);
            }
            os.write(str.getBytes());
            os.close();
            System.out.println("-----------over-------------");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 移除重复的翻译条目
     *
     * @param path
     */
    public static void removeDuplicate(String path) {
        try {
            FileOutputStream os = new FileOutputStream("test.dat");
            List<String> headlist = new ArrayList<String>();
            String str = Util_File.inputStream2String(path);
            os.write(new String("[TRANSLATIONS]\r\n").getBytes());
            Pattern p = Pattern.compile("\t\t<STRING>ORIGINAL:(.*)\r\n(.*)<STRING>TRANSLATION:(.*)");
            Matcher m = p.matcher(str);
            ArrayList<String> strs = new ArrayList<String>();
            while (m.find()) {
                strs.add(m.group(0));
                if (Util_String.isInList(headlist, m.group(1))) {

                } else {
                    headlist.add(m.group(1));
                    String tmp = "\t[TRANSLATION]\r\n" + m.group(0) + "\r\n\t[/TRANSLATION]\r\n";
                    os.write(tmp.getBytes());
                    System.out.println(tmp);
                }

            }
            os.write(new String("[/TRANSLATIONS]").getBytes());
            os.close();
            System.out.println("-----------over-------------");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 删除 java代码里的 System.out类型的注释
     */
    public static void washjavafile() {
        Util_File.getFiles("src", "(.*)\\.java",
                new CallBack() {

                    @Override
                    public void back(Object... object) {
                        try {
                            File file = (File) object[0];
                            String filepath = file.getAbsolutePath();
                            String filecontent = Util_File.inputStream2String(file);
                            Pattern p = Pattern.compile("System\\.out\\.println(.*);");
                            Matcher m = p.matcher(filecontent);
                            boolean needfix = false;
                            while (m.find()) {
                                filecontent = filecontent.replace(m.group(), "");
                                needfix = true;
                            }
                            if (needfix) {
                                FileOutputStream os = new FileOutputStream(filepath);
                                os.write(filecontent.getBytes("utf-8"));
                                os.close();
                                System.out.println(filepath + "修改成功");
                            } else {
                                System.out.println(filepath + "无修改");
                            }


                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                });
    }

    /**
     * 增加一个稀有度属性
     */
    public static void addRarityProperty() {
        try {


//			os.write(new String("[TRANSLATION]\r").getBytes());
            Util_File.getFiles("ADD_U_WEAPON", "((.*)\\.((?i)dat))|((.*)\\.((?i)layout))",
                    new CallBack() {

                        @Override
                        public void back(Object... object) {
                            int length = object.length;
                            File[] file = new File[length];
                            for (int i = 0; i < file.length; i++) {
                                file[i] = (File) object[i];
                                String tmp = Util_File.inputStream2String(file[i]);
                                ParseBase parent = new DatNode().build().parse(tmp);
                                parent.addProperty("\t<INTEGER>RARITY", "0");
                                tmp = parent.getEntityString();
                                try {
                                    FileOutputStream os = new FileOutputStream(file[i].getAbsolutePath());
                                    os.write(tmp.getBytes("UnicodeLittle"));
                                    os.close();
                                } catch (Exception e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }


                        }
                    });

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-----------over-------------");
    }

    /**
     * 获得所有需要翻译的文本
     */
    public static void binginTranslate() {
        try {
            final List<String> allstring = new ArrayList<String>();

            final FileOutputStream os = new FileOutputStream("test.DAT");
//			os.write(new String("[TRANSLATION]\r").getBytes());
            Util_File.getFiles("MEDIA", "((.*)\\.((?i)dat))|((.*)\\.((?i)layout))",
                    new CallBack() {

                        @Override
                        public void back(Object... object) {
                            int length = object.length;
                            File[] file = new File[length];
                            for (int i = 0; i < file.length; i++) {
                                file[i] = (File) object[i];
                            }
                            Util_Translate.getAllTRANSLATE(os, allstring, file);

                        }
                    });
            allstring.clear();
//			os.write(new String("[/TRANSLATION]").getBytes());
            os.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-----------over-------------");
    }

    /**
     * 机翻方法
     *
     * @param path
     */
    public static void getTranslateOnWeb(String path) {
        try {
            String str = Util_File.inputStream2String(path);
            FileOutputStream os = new FileOutputStream("EnglishOK.dat");
//			System.out.println(str);
            String needpring = "";
            Pattern p = Pattern.compile("\t\t<STRING>ORIGINAL:(.*)\r\n(.*)<STRING>TRANSLATION:(.*)");
            Matcher m = p.matcher(str);

            while (m.find()) {
                String needtranslater = m.group(3);
//				System.out.println(needtranslater);
                String resultonweb = Util_Translate.getTranslaterResultOnWeb(needtranslater);
                System.out.println(resultonweb);
                if (resultonweb.equals("")) {
                    str = str.replace("<STRING>TRANSLATION:" + needtranslater, "<STRING>TRANSLATION:" + resultonweb);
                } else {

                }

            }
            System.out.println("翻译结果:" + str);
//			os.write(needpring.getBytes());
//			os.close();
            System.out.println("-----------over-------------");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 移除重复的affix
     *
     * @param affixpath
     */
    public static void removeDupAffix(String affixpath) {
        final List<String> usedaffix = new ArrayList<String>();
        Util_File.getFiles(affixpath, "", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];

                if (Util_String.isInList(usedaffix, file.getName().split("\\.")[0])) {

                    System.out.println("重复文件名:" + file.getName().split("\\.")[0]);
//					file.delete();
                } else {
                    usedaffix.add(file.getName().split("\\.")[0]);
                }
            }
        });
    }

    /**
     * 移除没有使用的affix
     *
     * @param mediapath
     * @param affixpath
     */
    public static void removeAllNotUsedAffix(String mediapath, String affixpath) {
        final List<String> usedaffix = new ArrayList<String>();
        Util_File.getFiles(mediapath, "", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String str = Util_File.inputStream2String(file.getAbsolutePath());
                Pattern p = Pattern.compile("<STRING>AFFIX:(.*)");
                Matcher m = p.matcher(str);
                while (m.find()) {
                    if (!Util_String.isInList(usedaffix, m.group(1))) {
                        usedaffix.add(m.group(1));
//					System.out.println("文件名:"+file.getName());
                    }

                }
            }
        });

        Util_File.getFiles(affixpath, "", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];

                if (!Util_String.isInList(usedaffix, file.getName().split("\\.")[0])) {

                    System.out.println("未使用文件名:" + file.getName().split("\\.")[0]);
                    file.delete();
                }
            }
        });


    }

    public static void removeParticlesDependenceUnitSkillLayout(final String mediapath, String layoutpath, String particlepath) {
        final List<String> usedlayout = new ArrayList<String>();
        Util_File.getFiles(layoutpath, "((.*)((?i)\\.LAYOUT))", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String str = Util_File.inputStream2String(file.getAbsolutePath());
                Pattern p = Pattern.compile("<STRING>LAYOUT FILE:(.*)");
                Matcher m = p.matcher(str);
                while (m.find()) {
                    String orgpath = m.group(1);
                    String layoutfilepath = mediapath + File.separatorChar + orgpath;
                    String resultpath = new File(layoutfilepath).getAbsolutePath().toLowerCase();

                    if (!Util_String.isInList(usedlayout, resultpath)) {
                        usedlayout.add(resultpath);
//					System.out.println("用到的particle:"+resultpath);
                    }

                }


            }
        });


        Util_File.getFiles(particlepath, "((.*)((?i)\\.LAYOUT))", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String resultpath = file.getAbsolutePath().toLowerCase();
                if (!Util_String.isInList(usedlayout, resultpath)) {
                    System.out.println("未用到的layout:" + resultpath);
                    file.delete();

                }

            }
        });
    }

    public static void removeLayoutDependenceUnitSkill(final String mediapath, String skillpath, String layoutpath) {
        final List<String> usedlayout = new ArrayList<String>();
        Util_File.getFiles(skillpath, "((.*)((?i)\\.DAT))", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String str = Util_File.inputStream2String(file.getAbsolutePath());
                Pattern p = Pattern.compile("<STRING>FILE:(.*)");
                Matcher m = p.matcher(str);
                while (m.find()) {
                    String orgpath = m.group(1);
                    String layoutfilepath = mediapath + File.separatorChar + orgpath;
                    String resultpath = new File(layoutfilepath).getAbsolutePath().toLowerCase();

                    if (!Util_String.isInList(usedlayout, resultpath)) {
                        usedlayout.add(resultpath);
//					System.out.println("用到的layout:"+resultpath);
                    }

                }


            }
        });
//		for (int i = 0; i < usedlayout.size(); i++) {
//			System.out.println(usedlayout.get(i));
//		}

        Util_File.getFiles(layoutpath, "((.*)((?i)\\.LAYOUT))", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String resultpath = file.getAbsolutePath().toLowerCase();
                if (!Util_String.isInList(usedlayout, resultpath)) {
                    System.out.println("未用到的layout:" + resultpath);
                    file.delete();

                }

            }
        });
    }

    public static void removeSkillWrongUnitPlayer(String mediapath) {

        Util_File.getFiles(mediapath, "((.*)((?i)\\.DAT))", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String str = Util_File.inputStream2String(file.getAbsolutePath());
//				System.out.println("错误文件:"+file.getAbsoluteFile());
                if (str.matches("([\\s\\S]*)\\[\\]([\\s\\S]*)")) {
                    System.out.println("错误文件:" + file.getAbsoluteFile());
                }


            }
        });

    }

    public static void removeModelsDependenceUnit(final String mediapath, String unitpath, String modelpath) {
        final List<String> usedmodel = new ArrayList<String>();
        Util_File.getFiles(unitpath, "((.*)((?i)\\.DAT))", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String str = Util_File.inputStream2String(file.getAbsolutePath());

                ParseBase unitdat = new DatNode().build().parse(str);
                try {
                    String tmppath = mediapath + "/" + unitdat.getPropertyValueInThisLevelNode("RESOURCEDIRECTORY").get(0).toLowerCase() + "/" + unitdat.getPropertyValueInThisLevelNode("MESHFILE").get(0).toLowerCase();
                    String resultpath = new File(tmppath).getAbsolutePath().toLowerCase();
                    if (!Util_String.isInList(usedmodel, resultpath)) {
                        usedmodel.add(resultpath);
                    }
                } catch (Exception e) {
//					e.printStackTrace();
                }


            }
        });
        Util_File.getFiles(modelpath, "((.*)((?i)\\.MESH))", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String filename = file.getAbsolutePath().toLowerCase();
                if (!Util_String.isInList(usedmodel, filename)) {
                    System.out.println("未使用的模型:" + file.getAbsoluteFile());
                    file.delete();
                }

            }
        });
    }

    /**
     * 移除对于单位来说没有使用的技能文件
     *
     * @param unitpath
     * @param skillpath
     */
    public static void removeSkillDependenceUnitPlayer(String unitpath, String skillpath) {
        final List<String> usedskill = new ArrayList<String>();
        Util_File.getFiles(unitpath, "((.*)((?i)\\.DAT))", new CallBack() {

            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String str = Util_File.inputStream2String(file.getAbsolutePath());

                ParseBase unitdat = new DatNode().build().parse(str);
                usedskill.addAll(Util_Node.getValuesINNodeLowerCase(unitdat, "SKILL", "NAME"));

            }
        });
        Util_File.getFiles(skillpath, "((.*)((?i)\\.DAT))", new CallBack() {
            @Override
            public void back(Object... object) {
                File file = (File) object[0];
                String str = Util_File.inputStream2String(file.getAbsolutePath());
//				System.out.println("开始解析:"+file.getAbsolutePath());

                ParseBase unitdat = null;
                try {
                    unitdat = new DatNode().build().parse(str);
                } catch (Exception e) {
                    System.out.println("错误文件:" + file.getAbsoluteFile());
                    file.delete();
//					e.printStackTrace();
                }
                try {
                    String skillname = unitdat.getPropertyValueInThisLevelNode("NAME").get(0).toLowerCase();
                    if (!Util_String.isInList(usedskill, skillname)) {
//                        System.out.println("未使用的技能:"+file.getAbsoluteFile());
//						file.delete();
                    }
                } catch (Exception e) {
                    System.out.println("错误文件:" + file.getAbsoluteFile());
                    file.delete();
//					e.printStackTrace();
                }

            }
        });
    }
}
