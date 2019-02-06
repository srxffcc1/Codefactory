package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HackTest {

    public static void main(String[] args) {
        TestBean u = new TestBean();
        u.setId(1, "kjsakjdh");
//		u.setName("cc");
        u.setBy((byte) 1);
        u.setSt((short) 2);
        try {
            getProperty(u);
            getMethods(u);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(u.getId());
        System.out.println(u.getName());
    }

    public static void getProperty(Object entityName) throws Exception {
        Class c = entityName.getClass();
        Field field[] = c.getDeclaredFields();
        for (Field f : field) {
            f.setAccessible(true);
//			System.out.println(f.get(entityName));
//			Object v = invokeMethod(entityName, f.getName(), null);
//			System.out.println(f.getName() + "\t" + v + "\t" + f.getType());
        }
    }

    public static void getMethods(Object entityName) throws Exception {
        Class c = entityName.getClass();
        Method[] field = c.getDeclaredMethods();
        for (Method f : field) {
            f.setAccessible(true);
            String methodname = f.getName();
            if (methodname.equals("setId")) {
                f.invoke(entityName, 23, null);
            }


//			Object v = invokeMethod(entityName, f.getName(), null);
//			System.out.println(f.getName() + "\t" + v + "\t" + f.getType());
        }
    }

    private static Object invokeMethod(Object owner, String methodName,
                                       Object[] args) throws Exception {
        Class ownerClass = owner.getClass();
        methodName = methodName.substring(0, 1).toUpperCase()
                + methodName.substring(1);
        Method method = null;
        try {
            method = ownerClass.getMethod("get" + methodName);
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e) {
            return " can't find 'get" + methodName + "' method";
        }
        return method.invoke(owner);
    }
}
