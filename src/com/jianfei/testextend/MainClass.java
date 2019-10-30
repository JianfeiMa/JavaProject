package com.jianfei.testextend;

import java.util.*;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-12 13:05
 */
public class MainClass {

    public static void main(String[] args) {
        Class1 class1 = new Class2();
        class1.method1();
        class1.otherMethod();
//        class1.sayHello();
        Set<String> testHashSet = new HashSet<String>();
        Set<String> testTreeSet = new TreeSet<String>();
        Set<String> testLinkedSet = new LinkedHashSet<String>();

        testLinkedSet.add("张三");
        testLinkedSet.add("李四");
        testLinkedSet.add("李四");
        testLinkedSet.add("王五");
        testLinkedSet.add("啊四");
        testLinkedSet.add("啊笔");
        for (String s : testLinkedSet) {
            System.out.println(s);
        }

        List<String> testArrayList = new ArrayList<String>();
        List<String> testVector = new Vector<String>();
        List<String> testLinkedList = new LinkedList<String>();
        System.out.println("**********");
        testLinkedList.add("张三");
        testLinkedList.add("李四");
        testLinkedList.add("李四");
        testLinkedList.add("王五");
        for (String s : testLinkedList) {
            System.out.println(s);
        }

        Map<Integer, String> testHashMap = new HashMap<Integer, String>();
        Map<Integer, String> testHashTable = new Hashtable<Integer, String>();
        Map<Integer, String> testTreeMap = new TreeMap<Integer, String>();

        testTreeMap.put(3, "张三");
        testTreeMap.put(2, "李四");
        testTreeMap.put(1, "王五");
        testTreeMap.put(5, "啊狗");
        testTreeMap.put(4, "啊猫");
        Set<Map.Entry<Integer, String>> set = testTreeMap.entrySet();
        Iterator<Map.Entry<Integer, String>> entryIterator = set.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, String> entry = entryIterator.next();
            System.out.println("key->" + entry.getKey() + ";value->" + entry.getValue());
        }
    }
}
