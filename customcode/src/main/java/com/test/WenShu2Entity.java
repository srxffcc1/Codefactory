//-------WsAjclcp-------
//-------WsAjsy-------
//-------WsAjyss-------
//-------WsAjysspb-------
//-------WsCyqzpz-------
//-------WsDsrcssbbl-------
//-------WsFkcjtzs-------
//-------WsJaspb-------
//-------WsJdwts-------
//-------WsJnml-------
//-------WsKybl-------
//-------WsLasp-------
//-------WsQzcs-------
//-------WsQzzxsqs-------
//-------WsSdhz-------
//-------WsTzbl-------
//-------WsTzgzs-------
//-------WsTzhbg-------
//-------WsTzhtzs-------
//-------WsXcclcs-------
//-------WsXcjc-------
//-------WsXwbl-------
//-------WsXwtz-------
//-------WsXxdjbc-------
//-------WsXxdjcljds-------
//-------WsXxdjclspb-------
//-------WsXxdjtzs-------
//-------WsXzcfdw-------
//-------WsXzcfgr-------
//-------WsXzcfgzs-------
//-------WsXzcfjdsdw-------
//-------WsXzcfjdsgr-------
//-------WsXzcftljl-------
//-------WsYqjnfkpzs-------
//-------WsYqjnfkspb-------
//-------WsZgfc-------
//-------WsZlxqzg-------
package com.test;

import com.wisdomregulation.data.entitybase.Base_Entity;
import utils.Util_Class;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.wisdomregulation.staticlib.Static_BookLib.*;

public class WenShu2Entity {
    public static void main(String[] args) {
//	getWenshu2Entity(new WsAjclcp());
//	getWenshu2Entity2017(new com.ay.ydzf.zhifawenshu.pojo2014.WsAjclcp());

//	getString2Entity();

//	for (int i = 0; i < WEBBOOKNAMECHILD2017.length; i++) {
//		if(!WEBBOOKNAMECHILD2017[i].equals("")){
//			System.out.println(i);
//		}
//	}
//	List<Object> list= Util_Class.create().getReaAllClassObjectInThisPackage(new Entity_Book_2017_0(),"");
//	for (int i = 0; i <list.size() ; i++) {
//		if(((Base_Entity)(list.get(i))).getField(0).contains("null")){
//			System.out.println(list.get(i).getClass().getSimpleName());
//		}
//	}
    }
//private static void getWenshu2Entity2(){
//	List<Object> list= Util_Class.create().getReaAllClassObjectInThisPackage(new WsAjclcp(),"Ws(.*)");
//	for (int i = 0; i < list.size(); i++) {
//		System.out.println("//-------"+list.get(i).getClass().getSimpleName()+"-------");
//		System.out.println("else if(webobjectname.equals(\""+list.get(i).getClass().getSimpleName()+"\")){");
//
//
//		System.out.println("}");
//	}
//}

    public static void getString2Entity() {
        List<Object> list = new ArrayList<>();
        String webpath = "com.ay.ydzf.zhifawenshu.pojo2014";
        for (int i = 0; i < WEBBOOKNAME2017.length; i++) {
            if (!WEBBOOKNAME2017[i].equals("")) {
                try {
                    Object tmp = Class.forName("com.ay.ydzf.zhifawenshu.pojo2014." + WEBBOOKNAME2017[i]).newInstance();
                    list.add(tmp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("String stringtmp=\"\";");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("//-------" + list.get(i).getClass().getSimpleName() + "-------");
            System.out.println("else if(webobjectname.equals(\"" + list.get(i).getClass().getSimpleName() + "\")){");
            System.out.println("stringtmp=stringtmp");
            try {
                getPropertyList(list.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(";");
            System.out.println("}");

        }
    }

    private static void getWenshu2Entity2017(Object childobj) {
//	List<Object> list= Util_Class.create().getReaAllClassObjectInThisPackage(childobj,"Ws(.*)");
        String webpath = "com.ay.ydzf.zhifawenshu.pojo2014";

        List<Object> list = new ArrayList<>();
        for (int i = 0; i < WEBBOOKNAME2017.length; i++) {
            try {
                Object tmp = Class.forName("com.ay.ydzf.zhifawenshu.pojo2014." + WEBBOOKNAME2017[i]).newInstance();
                list.add(tmp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//	System.out.println();
//	for (int i = 0; i < list.size(); i++) {
//		System.out.println(list.get(i).getClass().getSimpleName());
//	}
        for (int i = 0; i < list.size(); i++) {
            try {
                for (int j = 0; j < WEBBOOKNAME2017.length; j++) {
                    if (WEBBOOKNAME2017[j].equals(list.get(i).getClass().getSimpleName())) {
                        if (j == 8 || j == 17 || j == 22 || j == 39 | j == 47) {
                            System.out.println("//-------" + list.get(i).getClass().getSimpleName() + "-------" + BOOKNAMELIST2017[j]);
                            System.out.println("else if(webobjectname.equals(\"" + list.get(i).getClass().getSimpleName() + "\")){");

                        } else {
                            System.out.println("//-------" + list.get(i).getClass().getSimpleName() + "-------" + BOOKNAMELIST2017[j]);
                            System.out.println("else if(webobjectname.equals(\"" + list.get(i).getClass().getSimpleName() + "\")){");
                        }
                    }
                }

                Base_Entity entity = null;
                int jj = 0;
                for (int j = 0; j < WEBBOOKNAME2017.length; j++) {
                    if (WEBBOOKNAME2017[j].equals(list.get(i).getClass().getSimpleName())) {
                        entity = (Base_Entity) Class.forName("com.wisdomregulation.data.entitybook2017.Entity_Book_2017_" + j).newInstance();
                        if (j == 8 || j == 17 || j == 22 || j == 39 | j == 47) {
                            if (j == 15 || j == 24 || j == 27 || j == 47 || j == 48 || j == 8) {
                                entity.push();
                                entity.push();
                                entity.push();
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                jj = j;
                                break;
                            } else {

                            }

                        } else {
                            if (j == 15 || j == 24 || j == 27 || j == 47 || j == 48 || j == 8) {
                                entity.push();
                                entity.push();
                                entity.push();
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                jj = j;
                                break;
                            } else {

                            }

                        }

                    } else {
//					System.err.println(list.get(i).getClass().getSimpleName());
                    }
                }
                if (entity != null) {
                    if (jj == 8 || jj == 17 || jj == 22 || jj == 39 | jj == 47) {
                        System.out.println("//------" + list.get(i).getClass().getSimpleName() + "-" + entity.getClass().getSimpleName() + "-------");
                        getProperty(list.get(i), entity);

                        System.out.println("bookentity.pull(((" + list.get(i).getClass().getSimpleName() + ")webobject).tbsj+\"\");");
                        System.out.println("}");
                    } else {
                        System.out.println("//------" + list.get(i).getClass().getSimpleName() + "-" + entity.getClass().getSimpleName() + "-------");
                        getProperty(list.get(i), entity);
                        System.out.println("bookentity.pull(((" + list.get(i).getClass().getSimpleName() + ")webobject).tbsj+\"\");");
                        System.out.println("}");
                    }
                } else {
//				System.err.println(list.get(i).getClass().getSimpleName());
                }

//
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(i);
                e.printStackTrace();
            }
        }
    }

    private static void getWenshu2Entity(Object childobj) {
        List<Object> list = Util_Class.create().getReaAllClassObjectInThisPackage(childobj, "Ws(.*)");
        System.out.println();
//	for (int i = 0; i < list.size(); i++) {
//		System.out.println(list.get(i).getClass().getSimpleName());
//	}
        for (int i = 0; i < list.size(); i++) {
            try {
                for (int j = 0; j < WEBBOOKNAME.length; j++) {
                    if (WEBBOOKNAME[j].equals(list.get(i).getClass().getSimpleName())) {
                        if (j == 4 || j == 14 || j == 30 || j == 36) {
                            System.out.println("//-------" + list.get(i).getClass().getSimpleName() + "-------");
                            System.out.println("else if(webobjectname.equals(\"" + list.get(i).getClass().getSimpleName() + "\")){");

                        } else {
                            System.out.println("//-------" + list.get(i).getClass().getSimpleName() + "-------");
                            System.out.println("else if(webobjectname.equals(\"" + list.get(i).getClass().getSimpleName() + "\")){");
                        }
                    }
                }

                Base_Entity entity = null;
                int jj = 0;
                for (int j = 0; j < WEBBOOKNAME.length; j++) {
                    if (WEBBOOKNAME[j].equals(list.get(i).getClass().getSimpleName())) {
                        entity = (Base_Entity) Class.forName("com.wisdomregulation.data.entitybook.Entity_Book" + j).newInstance();
                        if (j == 4 || j == 14 || j == 30 || j == 36) {
                            if (j == 16 || j == 33 || j == 28 || j == 22 || j == 7 || j == 5 || j == 2 || j == 9 || j == 19) {
                                entity.push();
                                entity.push();
                                entity.push();
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                jj = j;
                                break;
                            } else {

                            }

                        } else {
                            if (j == 16 || j == 33 || j == 28 || j == 22 || j == 7 || j == 5 || j == 2 || j == 9 || j == 19) {
                                entity.push();
                                entity.push();
                                entity.push();
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                System.out.println("bookentity.pull(\"\");");
                                jj = j;
                                break;
                            } else {

                            }

                        }

                    } else {
//					System.err.println(list.get(i).getClass().getSimpleName());
                    }
                }
                if (entity != null) {
                    if (jj == 4 || jj == 14 || jj == 30 || jj == 36) {
                        System.out.println("//------" + list.get(i).getClass().getSimpleName() + "-" + entity.getClass().getSimpleName() + "-------");
                        getProperty(list.get(i), entity);

                        System.out.println("bookentity.pull(((" + list.get(i).getClass().getSimpleName() + ")webobject).tbsj+\"\");");
                        System.out.println("}");
                    } else {
                        System.out.println("------" + list.get(i).getClass().getSimpleName() + "-" + entity.getClass().getSimpleName() + "-------");
                        getProperty(list.get(i), entity);
                        System.out.println("bookentity.pull(((" + list.get(i).getClass().getSimpleName() + ")webobject).tbsj+\"\");");
                        System.out.println("}");
                    }
                } else {
//				System.err.println(list.get(i).getClass().getSimpleName());
                }

//
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(i);
                e.printStackTrace();
            }
        }
    }

    public static void getPropertyList(Object entityName) throws Exception {
        Class c = entityName.getClass();
        Field field[] = c.getDeclaredFields();
        for (Field f : field) {
            f.setAccessible(true);
            if (f.getName().equals("version") || f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {

            } else {
                System.out.println("+((" + entityName.getClass().getSimpleName() + ")webobject)." + f.getName() + "+\"#\"");
            }

        }
    }

    public static void getProperty(Object entityName, Base_Entity entity) throws Exception {
        Class c = entityName.getClass();
        Field field[] = c.getDeclaredFields();
        for (Field f : field) {
            f.setAccessible(true);
            if (f.getName().equals("version") || f.getName().equals("tbsj") || f.getName().equals("tname") || f.getName().equals("xzzfid") || f.getName().equals("qyid") || f.getName().equals("sfwc")) {

            } else {
//			System.out.println(f.getName()+"@"+entity.push());

                System.out.println("bookentity.pull(((" + entityName.getClass().getSimpleName() + ")webobject)." + f.getName() + "+\"\");");
            }

        }
    }
}
