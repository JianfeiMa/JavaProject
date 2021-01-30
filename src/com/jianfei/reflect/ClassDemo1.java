package com.jianfei.reflect;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2021-01-28 13:20
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Foo");
            java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i ++) {
                java.lang.reflect.Field field = fields[i];
                String name = field.getName();
                System.out.println("field->" + name);
            }
        } catch (java.lang.ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }



        try {
            File file = new File("C:\\Users\\classes\\com\\test");
            URL[] urls = {file.toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("SortUtil");
            java.lang.Object fooObject = clazz.newInstance();
            java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i ++) {
                java.lang.reflect.Field field = fields[i];
                String name = field.getName();
                System.out.println("field->" + name);
            }
            Method computeFreightFeeMethod = null;
            java.lang.reflect.Method[] methods = clazz.getMethods();
            for (int i = 0; i < methods.length; i ++) {
                Method method = methods[i];
                String name = method.getName();
                System.out.println("method->" + name);
                if (name.equals("sort")) {
                    computeFreightFeeMethod = method;
                }
            }
            if (computeFreightFeeMethod != null) {
                Class[] parameterTypes = computeFreightFeeMethod.getParameterTypes();
                int parameterCount = computeFreightFeeMethod.getParameterCount();
                System.out.println("打印参数数量->" + parameterCount);
                for (int i = 0; i < parameterTypes.length; i ++) {
                    System.out.println("打印参数类型->" + parameterTypes[i].toString());
                }
                Object result = computeFreightFeeMethod.invoke(fooObject);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }


    }
}

