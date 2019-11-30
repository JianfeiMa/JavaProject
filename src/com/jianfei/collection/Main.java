package com.jianfei.collection;

import java.util.*;
import java.util.regex.Pattern;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-08 08:39
 * 回顾集合框架
 */
public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        List<String> vector = new Vector<String>();

        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        Set<Integer> treeSet = new TreeSet<Integer>();

        Map<String, String> hashMap = new HashMap<String, String>();
        Map<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        arrayList.add("JianfeiMa");
        arrayList.add("JianfeiMa");

        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(8);

        hashMap.put("JianfeiMa", "JianfeiMa");
        hashMap.put("JianxiaMa", "JianxiaMa");
        hashMap.put("JianfeiMa", "JianfeiMa");
        hashMap.put("a", "a");
        hashMap.put("b", "b");

        for (String s : arrayList) {
            System.out.println(s);
        }
        System.out.println("----------------------");
        for (Integer s : treeSet) {
            System.out.println(s);
        }
        System.out.println("----------------------");
        Set<Map.Entry<String, String>> a = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = a.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key->" + entry.getKey() + ";" + "value->" + entry.getValue());
        }
        System.out.println("--------------------------------------");
        List<String> student = new LinkedList<>();
        boolean isMatches = Pattern.matches(".", "m");
        System.out.println("是否匹配：" + isMatches);
    }
}
